package abschlussoop1.arbeit;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class VersichertePerson {

    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty vorname = new SimpleStringProperty();
    private SimpleIntegerProperty franchise_defaulte = new SimpleIntegerProperty();

    // private Kundenberater kundenberater;


    //Konstruktor
    public VersichertePerson(String name,String vorname, int franchise_defaulte){
        this.setName(name);
        this.setVorname(vorname);
        this.setFranchise(300);
    }

    public SimpleStringProperty nameProperty(){
        return this.name;
    }

    public String getName(){
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty vornameProperty(){
        return this.vorname;
    }

    public String getVorname(){
        return vorname.get();
    }

    public void setVorname(String vorname) {
        this.vorname.set(vorname);
    }


     public SimpleIntegerProperty franchiseProperty(){
        return this.franchise_defaulte;
    }

    public int getFranchise(){
        return franchise_defaulte.get();
    }

    public void setFranchise(int franchise) {
        this.franchise_defaulte.set(franchise);
    }

        
}
