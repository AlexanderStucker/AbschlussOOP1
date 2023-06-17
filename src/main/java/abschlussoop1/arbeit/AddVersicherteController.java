package abschlussoop1.arbeit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddVersicherteController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField vornameTextField;
    
    @FXML
    private TextField franchiseTextField;

    @FXML
    private Button okButton;

    @FXML Button abbruchButton;
    

    //Methode um eine neue VersicherteP zu erfassen
    @FXML
    public void addPerson() {
        String name = nameTextField.getText(); 
        String vorname = vornameTextField.getText();
        int franchise = Integer.parseInt(franchiseTextField.getText()); 

        VersichertePerson newPerson = new VersichertePerson(name, vorname, franchise);
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
    
}
