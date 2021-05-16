package org.loose.fis.sre.model;

        import org.dizitart.no2.objects.Id;

        import java.util.Objects;

public class ProgramName {
    @Id
    private String name;
    private String intensity;
    private String duration;
    private String coach;
    private String link;
    public String[] client = new String[20];
    private int counter;
    public int[] durationleft=new int[20];

    public ProgramName(){}
    public ProgramName(String name, String intensity,String duration,String coach,String link) {
        this.name = name;
        this.intensity=intensity;
        this.duration=duration;
        this.coach=coach;
        this.link=link;
        this.counter=0;
        for(int i=0;i<client.length;i++)
        {
            this.client[i]="0";
            this.durationleft[i]=Integer.parseInt(duration);
        }

    }

    public String getCoach() {
        return coach;
    }

    public String getLink() {
        return link;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration=duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramName programName = (ProgramName) o;
        if(!Objects.equals(name, programName.name)) return false;
        return Objects.equals(name, programName.name) && Objects.equals(intensity, programName.intensity)  && Objects.equals(duration, programName.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, intensity, duration);
    }

    public String toString(){
        return name;
    }
}
