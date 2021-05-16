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
    private static Nitrite database;
    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(FileSystemService.getPathToFile("program-name.db").toFile())
                .openOrCreate("test", "test");

        programNameRepository = database.getRepository(ProgramName.class);
    }


    public static void addName(String  name, String intensity,String duration,String coach,String link) throws ProgramAlreadyExistsException {
        checkNameDoesNotAlreadyExist(name);
        programNameRepository.insert(new ProgramName(name,intensity, duration,coach,link));
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

    public static void clearProgram(String name, String intensity,String duration,String coach,String link){
        for(ProgramName p:programNameRepository.find()) {
            if(p.getName()!=null && p.getName().equals(name) && p.getIntensity().equals(intensity)
                    && p.getDuration().equals(duration) && p.getCoach().equals(coach) && p.getLink().equals(link) )
            {
                programNameRepository.remove(p);
                break;
            }
        }
    }


    public static ArrayList<ProgramName> programNames() {
        ArrayList<ProgramName> list = new ArrayList<>();
        for(ProgramName program : programNameRepository.find()) {
            list.add(program);
        }
        return list;
    }

    public static ProgramName getProgramName(String name){
        for(ProgramName programName : programNameRepository.find())
            if(Objects.equals(name, programName.getName()))
                return programName;
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

    /*public static ArrayList<String> clientPrograms(String name) {
        ArrayList<String> list = new ArrayList<>();
        for(ProgramName program : programNameRepository.find()) {
            if (ProgramService.findClient(program,name))
        }
        return list;
    }*/

}
