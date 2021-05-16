package org.loose.fis.sre.controllers;

        import org.loose.fis.sre.Main;
        import java.io.IOException;

        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.stage.Stage;
        import javafx.scene.control.Button;
        import org.loose.fis.sre.model.User;
        import org.loose.fis.sre.services.UserService;
        import java.util.List;

        import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class SeeListOfClientsController {

    @FXML
    private TableView<User> clientTable;
    @FXML
    private TableColumn<User, String> usernameColumn;


    public void initialize() {

        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        clientTable.setItems(categories);
    }

    @FXML
    public void removeClient() {

        ObservableList<User> u,u1;

        u1=clientTable.getSelectionModel().getSelectedItems();

        UserService.clearClient(u1.get(0).getUsername(),u1.get(0).getPassword());

        u= clientTable.getItems();
        u1.forEach(u::remove);
    }

    public void handleBackClientsButton() throws IOException {
        Main x = new Main();
        x.changeWindow("CoachHome.fxml");
    }

    private ObservableList<User> categories = FXCollections.observableArrayList(UserService.clientNames());
    public List <User> getProgramNamesFromTable() {
        return clientTable.getItems();
    }

}
