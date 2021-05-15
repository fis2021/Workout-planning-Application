package org.loose.fis.sre.controllers;

        import javafx.fxml.FXML;
        import org.loose.fis.sre.Main;
        import org.loose.fis.sre.services.ProgramService;
        import org.loose.fis.sre.services.UserService;
        import org.loose.fis.sre.model.ProgramName;
        import org.loose.fis.sre.model.User;

        import java.io.IOException;

        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextField;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import org.dizitart.no2.Nitrite;
        import org.dizitart.no2.objects.ObjectRepository;


public class AddProgramsController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField intensityField;
    @FXML
    private TextField durationField;
    @FXML
    private Button addprogrambutton;
    @FXML
    private Text AddProgramMessage;


    public void handleAddProductAction() throws Exception
    {
        if(nameField.getText().trim().isEmpty())
        {
            AddProgramMessage.setText("Name missing!");
        }
        else
        if(intensityField.getText().trim().isEmpty())
        {
            AddProgramMessage.setText("Intensity missing!");
        }
        else
        if(durationField.getText().trim().isEmpty())
        {
            AddProgramMessage.setText("Duration missing!");
        }
        else
        {
            ProgramService.addName(nameField.getText(), intensityField.getText(), durationField.getText());
            AddProgramMessage.setText("Program added!");
        }
    }

    public void handleBackButton() throws IOException{
        Main x = new Main();
        x.changeWindow("viewPrograms.fxml");
        cancelAddPrograms();
    }

    public void cancelAddPrograms()
    {
        addprogrambutton.getScene().getWindow().hide();
    }



}