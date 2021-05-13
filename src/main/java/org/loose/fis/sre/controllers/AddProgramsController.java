package org.loose.fis.sre.controllers;

        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.ChoiceBox;
        import javafx.scene.control.TextField;
        import javafx.stage.Stage;
        import org.loose.fis.sre.exceptions.ProgramAlreadyExistsException;
        import org.loose.fis.sre.services.ProgramService;

        import java.io.IOException;

public class AddProgramsController {

    @FXML
    private ChoiceBox intensity;

    @FXML
    private TextField name;


    @FXML
    private TextField duration;

    @FXML
    public void initialize() {
        intensity.getItems().addAll("Beginner", "Medium", "High-intensity");
    }

    public void handleAddButtonAction() throws  IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Coach_viewPrograms.fxml"));
        Stage window = (Stage) intensity.getScene().getWindow();
        window.setScene(new Scene(root, 800, 600));

    }


    public void handleCancelButtonAction() throws Exception{

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Coach_viewPrograms.fxml"));
        Stage window = (Stage) intensity.getScene().getWindow();
        window.setScene(new Scene(root, 800, 600));
    }

}