package org.loose.fis.sre.exceptions;

public class ProgramAlreadyExistsException extends Exception {

    private String name;

    public ProgramAlreadyExistsException(String name) {
        super(String.format("A product with the name %s already exists!", name));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}