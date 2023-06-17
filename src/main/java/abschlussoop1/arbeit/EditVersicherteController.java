package abschlussoop1.arbeit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditVersicherteController {

    
    @FXML
    private TextField nameTextField;

    @FXML
    private TextField vornameTextField;
    
    @FXML
    private TextField franchiseTextField;

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
        int newFranchise = Integer.parseInt(franchiseTextField.getText());

        if (selectedPerson != null) {
            selectedPerson.setName(newName);
            selectedPerson.setVorname(newVorname);
            selectedPerson.setFranchise(newFranchise);
        }

        Stage stage = (Stage) okButton.getScene().getWindow(); 
        stage.close();
    }

    public void setInitialData() {
    nameTextField.setText(selectedPerson.getName());
    vornameTextField.setText(selectedPerson.getVorname());
    franchiseTextField.setText(String.valueOf(selectedPerson.getFranchise()));
}
    
}
