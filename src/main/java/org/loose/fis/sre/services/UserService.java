package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.AccException;
import org.loose.fis.sre.exceptions.IncorrectPassException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.UsernameDoesntExistException;
import org.loose.fis.sre.model.ProgramName;
import org.loose.fis.sre.model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Objects;


import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class UserService {

    private static ObjectRepository<User> userRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("registration-example.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role));
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

    public static String getUserRole(String username, String password) throws AccException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
            {
                if (Objects.equals(encodePassword(username,password), user.getPassword()))
                    return user.getRole();
                else
                    throw new IncorrectPassException(password);
            }
        }
        throw new UsernameDoesntExistException(username);
    }

    public static void clearClient(String username, String password){
        for(User u:userRepository.find()) {
            if(u.getUsername()!=null && u.getUsername().equals(username) && u.getPassword().equals(password))
            {
                userRepository.remove(u);
                break;
            }
        }
    }

    public static ArrayList<User> clientNames() {
        ArrayList<User> list = new ArrayList<>();
        for(User client : userRepository.find()) {
            if(client.getRole().equalsIgnoreCase("Client"))
            list.add(client);
        }
        return list;
    }
}