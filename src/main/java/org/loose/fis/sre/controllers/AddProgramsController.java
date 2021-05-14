package org.loose.fis.sre.controllers;

        import org.loose.fis.sre.Main;

        import java.io.IOException;

public class AddProgramsController {


    public void handleBackButton() throws IOException{
        Main x = new Main();
        x.changeWindow("viewPrograms.fxml");
    }



}