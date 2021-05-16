package org.loose.fis.sre.controllers;

        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.fxml.FXML;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.control.cell.PropertyValueFactory;
        import org.loose.fis.sre.Main;
        import org.loose.fis.sre.model.User;
        import org.loose.fis.sre.services.UserService;

        import java.io.IOException;

public class CoachSeeProgressController {

    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, String> usernameColumn;


    public void initialize() {

        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        userTable.setItems(categories);
    }

    public void handleBackClientsButton() throws IOException {
        Main x = new Main();
        x.changeWindow("CoachHome.fxml");
    }

    private ObservableList<User> categories = FXCollections.observableArrayList(UserService.clientNames());

}
