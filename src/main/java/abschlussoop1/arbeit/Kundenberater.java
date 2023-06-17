package abschlussoop1.arbeit;

import javafx.beans.property.SimpleStringProperty;

public class Kundenberater {

    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty language = new SimpleStringProperty();

    // Konstruktor
    public Kundenberater(String name, String language){
        this.setName(name);
        this.setLanguage(language);
    }

    public SimpleStringProperty nameProperty(){
        return this.name;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty languageProperty(){
        return this.name;
    }

    public String getLanguage() {
        return language.get();
    }

    public void setLanguage(String language) {
        this.language.set(language);
    }
    




    @Override
    public String toString(){
        return getName();
    }
}
