package org.loose.fis.sre.controllers;

import org.loose.fis.sre.Main;

import java.io.IOException;

public class CoachHomeController {


    public void handleLogout() throws IOException {
        Main x = new Main();
        x.changeWindow("login.fxml");
    }

    public void handleClients() throws IOException {
        Main y = new Main();
        y.changeWindow("CoachCanSeeListOfClients.fxml");
    }

    public void handlePrograms() throws IOException {
        Main z = new Main();
        z.changeWindow("viewPrograms.fxml");
    }

    public void handleProgress() throws IOException {
        Main q = new Main();
        q.changeWindow("Coach_Seeprogress.fxml");
    }
}