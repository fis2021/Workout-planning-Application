package org.loose.fis.sre.controllers;

import org.loose.fis.sre.Main;

import java.io.IOException;

public class ClientHomeController {

    public void handleLogoutButton() throws IOException{
        Main x = new Main();
        x.changeWindow("login.fxml");
    }

    public void handleProgressButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientProgress.fxml");
    }

    public void handleProgramsButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientViewPrograms.fxml");
    }
}
