package org.loose.fis.sre.services;

        import org.dizitart.no2.Nitrite;
        import org.dizitart.no2.objects.ObjectRepository;
        import org.loose.fis.sre.exceptions.ProgramAlreadyExistsException;
        import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
        import org.loose.fis.sre.model.ProgramName;
        import org.loose.fis.sre.model.User;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Objects;

        import static org.dizitart.no2.objects.filters.ObjectFilters.eq;
        import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class ProgramService {

    private static ObjectRepository<ProgramName> productNameRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("product-name.db").toFile())
                .openOrCreate("test", "test");

        productNameRepository = database.getRepository(ProgramName.class);
    }

    public static void addName(String  name, String category,int price) throws ProgramAlreadyExistsException {
        checkNameDoesNotAlreadyExist(name);
        productNameRepository.insert(new ProgramName(name,category, price));
    }

    public static void removeName(ProgramName productName) {
        productNameRepository.remove(eq("name",productName.getName()));
    }

    public static void checkNameDoesNotAlreadyExist(String name) throws ProgramAlreadyExistsException {
        for (ProgramName productName : productNameRepository.find()) {
            if (Objects.equals(name, productName.getName()))
                throw new ProgramAlreadyExistsException(name);
        }
    }

    public static ArrayList<ProgramName> productNames() {
        ArrayList<ProgramName> list = new ArrayList<>();
        for(ProgramName productName : productNameRepository.find()) {
            list.add(productName);
        }
        return list;
    }


    public static ProgramName getProductName(String name){
        for(ProgramName productName : productNameRepository.find())
            if(Objects.equals(name, productName.getName()))
                return productName;
        return null;


    }


}
