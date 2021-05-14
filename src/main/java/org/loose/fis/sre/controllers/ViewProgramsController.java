package org.loose.fis.sre.controllers;

  import org.loose.fis.sre.Main;
  import java.io.IOException;

public class ViewProgramsController {

    public void handleAddPrograms() throws IOException {
        Main x = new Main();
        x.changeWindow("Coach_AddPrograms.fxml");
    }

    public void handleBackPrograms() throws IOException {
        Main x = new Main();
        x.changeWindow("CoachHome.fxml");
    }
}