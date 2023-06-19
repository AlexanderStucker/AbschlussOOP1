package abschlussoop1.arbeit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditVersicherteController {

    
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
    
    
    
    private VersichertePerson selectedPerson;
    private PrimaryController primaryController;

    public void setPerson(VersichertePerson selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public void setPrimaryController(PrimaryController primaryController) {
        this.primaryController = primaryController;
    }

    @FXML
    public void savePerson() {
        String newName = nameTextField.getText(); 
        String newVorname = vornameTextField.getText();
        int newFranchise = franchiseComboBox.getValue();
        Kundenberater kundenberater = kundenberaterComboBox.getSelectionModel().getSelectedItem();

        if (selectedPerson != null) {
            selectedPerson.setName(newName);
            selectedPerson.setVorname(newVorname);
            selectedPerson.setFranchise(newFranchise);
            selectedPerson.setKundenberater(kundenberater);

            primaryController.updatePerson(selectedPerson);
        }

        Stage stage = (Stage) okButton.getScene().getWindow(); 
        stage.close();
    }

    @FXML
    public void cancleView(){
        Stage stage = (Stage) abbruchButton.getScene().getWindow(); 
        stage.close();
    }

    public void setInitialData() {
    nameTextField.setText(selectedPerson.getName());
    vornameTextField.setText(selectedPerson.getVorname());
    franchiseComboBox.setValue(selectedPerson.getFranchise());
    kundenberaterComboBox.setValue(selectedPerson.getKundenberater());
    }

    @FXML
    public void initialize() {
        franchiseComboBox.getItems().addAll(300, 500, 1500, 2000, 2500);
        kundenberaterComboBox.setItems(App.getKundenberaterList());
    }
    
}
