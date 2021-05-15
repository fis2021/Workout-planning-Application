package org.loose.fis.sre.services;

        import javafx.beans.property.StringProperty;
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

    private static ObjectRepository<ProgramName> programNameRepository;
    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("program-name.db").toFile())
                .openOrCreate("test", "test");

        programNameRepository = database.getRepository(ProgramName.class);
    }

    public static void addName(String  name, String intensity,String duration) throws ProgramAlreadyExistsException {
        checkNameDoesNotAlreadyExist(name);
        programNameRepository.insert(new ProgramName(name,intensity, duration));
    }

    public static void removeName(ProgramName programName) {
        programNameRepository.remove(eq("name",programName.getName()));
    }

    public static void checkNameDoesNotAlreadyExist(String name) throws ProgramAlreadyExistsException {
        for (ProgramName programName : programNameRepository.find()) {
            if (Objects.equals(name, programName.getName()))
                throw new ProgramAlreadyExistsException(name);
        }
    }

    public static ArrayList<ProgramName> programNames() {
        ArrayList<ProgramName> list = new ArrayList<>();
        for(ProgramName programName : programNameRepository.find()) {
            list.add(programName);
        }
        return list;
    }


    public static ProgramName getProgramName(String name){
        for(ProgramName productName : programNameRepository.find())
            if(Objects.equals(name, productName.getName()))
                return productName;
        return null;

    }

    public static void addClient(ProgramName programName, String clientname){
        if (programName.getCounter()<20)
        {
            programName.client[programName.getCounter()]=clientname;
            programName.setCounter(programName.getCounter()+1);
        }

    }

    public static String workout(ProgramName programName, int counter){
        if (programName.durationleft[counter]==0)
        {
            return "Program "+programName.getName()+" finished!";
        }
        else
        {
            programName.durationleft[counter]--;
            return programName.durationleft[counter]+" days left of the program";
        }
    }

    public static int findClient(ProgramName programName, String name){
        for(int i=0;i<programName.client.length;i++)
        {
           if  (Objects.equals(programName.client[i],name))
               return i;
        }
        return -1;
    }

    public static ArrayList<String> programNamelist() {
        ArrayList<String> list = new ArrayList<>();
        for(ProgramName programName : programNameRepository.find()) {
            list.add(programName.getName());
        }
        return list;
    }

    public static ArrayList<String> programIntensitylist() {
        ArrayList<String> list = new ArrayList<>();
        for(ProgramName programName : programNameRepository.find()) {
            list.add(programName.getIntensity());
        }
        return list;
    }

    public static ArrayList<String> programDurationlist() {
        ArrayList<String> list = new ArrayList<>();
        for(ProgramName programName : programNameRepository.find()) {
            list.add(programName.getDuration());
        }
        return list;
    }
}
