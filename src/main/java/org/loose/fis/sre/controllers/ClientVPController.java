package org.loose.fis.sre.controllers;

import org.loose.fis.sre.Main;

import java.io.IOException;

public class ClientVPController {

    public void handleBackButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientHome.fxml");
    }

    public void handleWorkoutButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientDone.fxml");
    }

    public void handleEnrollButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientEnroll.fxml");
    }
}
