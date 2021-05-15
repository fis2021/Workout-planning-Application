package org.loose.fis.sre.model;

        import java.util.Objects;

public class ProgramName {
    private String name;
    private String intensity;
    private int duration;
    private String[] client = new String[10];
    public int counter;

    public ProgramName(String name, String intensity, int duration) {
        this.name = name;
        this.intensity = intensity;
        this.duration = duration;
    }

    public String

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

    public void setIntensity(String name) {
        this.intensity = intensity;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration=duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramName programName = (ProgramName) o;
        if(!Objects.equals(name, programName.name)) return false;
        return duration==0 ? duration== programName.duration : programName.duration==0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration);
    }

    public String toString(){
        return name;
    }
}
