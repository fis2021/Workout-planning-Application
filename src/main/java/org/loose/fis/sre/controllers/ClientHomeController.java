package org.loose.fis.sre.controllers;

import org.loose.fis.sre.Main;

import java.io.IOException;

public class ClientHomeController {

    public void handleLogoutButton() throws IOException{
        Main x = new Main();
        x.changeWindow("login.fxml");
    }
}
