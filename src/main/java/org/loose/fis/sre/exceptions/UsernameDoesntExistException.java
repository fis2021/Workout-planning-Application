package org.loose.fis.sre.exceptions;

public class UsernameDoesntExistException extends AccException
{

    private String username;

    public UsernameDoesntExistException(String username) {
        super(String.format("An account with the username %s doesn't exist!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}