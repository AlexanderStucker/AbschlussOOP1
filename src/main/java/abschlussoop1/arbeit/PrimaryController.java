package abschlussoop1.arbeit;


import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class PrimaryController {

    // Versichertenfelder
    @FXML
    private TableView<VersichertePerson> versicherteTable;

    @FXML
    private TableColumn<VersichertePerson, String> nameColumn;

    @FXML
    private TableColumn<VersichertePerson, String> vornameColumn;

    @FXML
    private TableColumn<VersichertePerson, Integer> franchiseColumn;

    @FXML
    private TableColumn<VersichertePerson, String> beraterColumn;

    @FXML
    private Button neuButton;

    @FXML
    private Button bearbeitenButton;

    @FXML
    private Button deleteButton;

    // Statistikfelder
    @FXML
    private TableView<KundenberaterStatistik> statistikTable;

    @FXML
    private TableColumn<KundenberaterStatistik, String> statistikKundenberaterColumn;

    @FXML
    private TableColumn<KundenberaterStatistik, Integer> statistikAnzahlKundenColumn;


    @FXML
    public void initialize() {
        //Initialisierung der Versicherten-Tabelle
        this.nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.vornameColumn.setCellValueFactory(cellData -> cellData.getValue().vornameProperty());
        this.franchiseColumn.setCellValueFactory(cellData -> cellData.getValue().franchiseProperty().asObject());
        this.beraterColumn.setCellValueFactory(cellData -> cellData.getValue().getKundenberater().nameProperty());

        //Initialisierung der Kundenberater-Statistik-Tabelle
        statistikKundenberaterColumn.setCellValueFactory(cellData -> cellData.getValue().kundenberaterProperty());
        statistikAnzahlKundenColumn.setCellValueFactory(cellData -> cellData.getValue().anzahlKundenProperty().asObject());

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
            stage.setOnHiding(event -> updateKundenberaterStatistik());
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
                stage.setOnHiding(event -> updateKundenberaterStatistik());
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
            updateKundenberaterStatistik();
        }
    }


    //Methode zum Aktualisieren der Statistik nachdem ein Kunde erfasst/gelöscht/bearbeitet wurde
    public void updateKundenberaterStatistik() {
    ObservableList<KundenberaterStatistik> statistikList = FXCollections.observableArrayList();

    // Iteriere über die Kundenberater
    for (Kundenberater berater : App.getKundenberaterList()) {
        int anzahlKunden = 0;

        // Über die Versicherte Person iteriren und die Anzahl kundenberater auf der Person zählen
        for (VersichertePerson person : App.getVersichgerungsList()) {
            if (person.getKundenberater().equals(berater)) {
                anzahlKunden++;
            }
        }

        // KundenberaterStatistik-Objekt erstellen um es korrekt anzuzgeien
        KundenberaterStatistik statistik = new KundenberaterStatistik(berater.getName(), anzahlKunden);
        statistikList.add(statistik);
    }
    // aktualisierte Tabelle setzen
    statistikTable.setItems(statistikList);
}


    //Der Kundenberater hat es nach dem EditVersichertePerson nicht automatisch aktualisiert. Diese Methode sorgt für den Refresh der versichertenTable
    public void updatePerson(VersichertePerson updatedPerson) {
    int index = App.getVersichgerungsList().indexOf(updatedPerson);
    if (index >= 0) {
        App.getVersichgerungsList().set(index, updatedPerson);
        versicherteTable.refresh();
    }
}

}