package org.loose.fis.sre.controllers;

        import org.loose.fis.sre.Main;
        import java.io.IOException;

public class SeeListOfClientsController {


    public void handleBackClientsButton() throws IOException {
        Main x = new Main();
        x.changeWindow("CoachHome.fxml");
    }

}
