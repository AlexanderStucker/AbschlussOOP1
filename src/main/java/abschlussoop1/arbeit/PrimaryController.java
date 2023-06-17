package abschlussoop1.arbeit;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class PrimaryController {

    @FXML
    private TableView<VersichertePerson> versicherteTable;

    @FXML
    private TableColumn<VersichertePerson, String> nameColumn;

    @FXML
    private TableColumn<VersichertePerson, String> vornameColumn;

    @FXML
    private TableColumn<VersichertePerson, Integer> franchiseColumn;

    @FXML
    private Button neuButton;

    @FXML
    private Button bearbeitenButton;

    @FXML
    private Button deleteButton;


    @FXML
    public void initialize() {
        this.nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.vornameColumn.setCellValueFactory(cellData -> cellData.getValue().vornameProperty());
        this.franchiseColumn.setCellValueFactory(cellData -> cellData.getValue().franchiseProperty().asObject());

        this.versicherteTable.setItems(App.getVersichgerungsList());
    }

    //Person hinzufügen
    @FXML
    public void openAddPersonWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/addPerson.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Person bearbeiten
    @FXML
    public void editSelectedPerson() {
        VersichertePerson selectedPerson = versicherteTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/editPerson.fxml"));
                Parent root = loader.load();
                EditVersicherteController controller = loader.getController();
                controller.setPerson(selectedPerson);
                controller.setPrimaryController(this);
                controller.setInitialData();

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //Person löschen
    public void deleteSelectedPerson() {
        VersichertePerson selectedPerson = versicherteTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            App.getVersichgerungsList().remove(selectedPerson);
        }
    }

}