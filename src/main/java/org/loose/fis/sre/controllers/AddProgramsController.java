package org.loose.fis.sre.controllers;

        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.TableView;
        import javafx.scene.control.TextField;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import org.loose.fis.sre.exceptions.ProgramAlreadyExistsException;
        import org.loose.fis.sre.model.ProgramName;
        import org.loose.fis.sre.Main;
        import org.loose.fis.sre.model.User;
        import org.loose.fis.sre.services.ProgramService;
        import static org.loose.fis.sre.services.ProgramService.addName;
        import static org.loose.fis.sre.services.ProgramService.checkNameDoesNotAlreadyExist;
        import java.io.IOException;
        import java.util.Objects;

public class AddProgramsController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField intensityField;
    @FXML
    private TextField durationField;
    @FXML
    private Text AddProgramMessage;
    @FXML
    private TextField coachField;
    @FXML
    private TextField linkField;


    public void handleAddButtonAction()  {

        try
        {
            ProgramService.checkNameDoesNotAlreadyExist(nameField.getText());
            ProgramService.addName(nameField.getText(), intensityField.getText(), durationField.getText(), User.getCurrentUser(),linkField.getText());

        }catch (Exception e)
        {
            AddProgramMessage.setText(e.getMessage());
        }

    }

    public void handleBackButton() throws IOException{
        Main x = new Main();
        x.changeWindow("viewPrograms.fxml");
    }

}