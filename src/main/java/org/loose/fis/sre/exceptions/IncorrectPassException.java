package org.loose.fis.sre.exceptions;

public class IncorrectPassException extends AccException
{

    private String password;

    public IncorrectPassException(String password) {
        super(String.format("Incorrect password!", password));
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}