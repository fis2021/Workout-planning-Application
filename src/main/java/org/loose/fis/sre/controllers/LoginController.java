package org.loose.fis.sre.controllers;

        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.PasswordField;
        import javafx.scene.control.TextField;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import org.loose.fis.sre.exceptions.AccException;
        import org.loose.fis.sre.exceptions.IncorrectPassException;
        import org.loose.fis.sre.model.User;

        import static org.loose.fis.sre.services.UserService.getUserRole;


public class LoginController
{

    public Button loginButton;
    @FXML
    private Button createAccountButton;

    @FXML
    private Text registrationMessage;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;



    public void handleLoginAction() throws Exception{
        Stage primary = (Stage) registrationMessage.getScene().getWindow();

        try {
            String role = getUserRole(usernameField.getText(), passwordField.getText());
            User.setCurrentUser(usernameField.getText());
            if(role.equals("Client")){
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pclient.fxml"));
                Scene nextScene = new Scene(root, 800, 600);

                primary.setScene(nextScene);
            }
            else
            if(role.equals("Couch")){
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("couch.fxml"));
                Scene nextScene = new Scene(root, 800, 600);

                primary.setScene(nextScene);
            }
            else
            {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
                Scene nextScene = new Scene(root, 800, 600);

                primary.setScene(nextScene);
            }
        }catch (AccException e) {
            registrationMessage.setText(e.getMessage());
        }
    }

    public void handleCreateAccountAction() throws Exception{

        Stage primary = (Stage) registrationMessage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Scene nextScene = new Scene(root, 800, 600);

        primary.setScene(nextScene);
    }
}