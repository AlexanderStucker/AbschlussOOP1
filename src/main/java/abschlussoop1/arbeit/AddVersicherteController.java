package abschlussoop1.arbeit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddVersicherteController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField vornameTextField;
    
    @FXML 
    private ComboBox<Integer> franchiseComboBox;

    @FXML 
    private ComboBox<Kundenberater> kundenberaterComboBox;

    @FXML
    private Button okButton;

    @FXML Button abbruchButton;
    

    //Methode um eine neue VersicherteP zu erfassen
    @FXML
    public void addPerson() {
        String name = nameTextField.getText(); 
        String vorname = vornameTextField.getText();
        int franchise = franchiseComboBox.getSelectionModel().getSelectedItem();
        Kundenberater kundenberater = kundenberaterComboBox.getSelectionModel().getSelectedItem();

        VersichertePerson newPerson = new VersichertePerson(name, vorname, franchise, kundenberater);
        App.getVersichgerungsList().add(newPerson);

        Stage stage = (Stage) okButton.getScene().getWindow(); 
        stage.close();
    }

    //Methode um zurück zur PrimaryView zu gelangen, ohne neue Person zu erfassen
    @FXML
    public void cancleAddPerson(){
        Stage stage = (Stage) abbruchButton.getScene().getWindow(); 
        stage.close();
    }

    @FXML
    public void initialize() {
        franchiseComboBox.getItems().addAll(300, 500, 1500, 2000, 2500);
        kundenberaterComboBox.setItems(App.getKundenberaterList());
    }
    
}
