package abschlussoop1.arbeit;

public class Kundenberater {

    private String name;
    private String language;

    // Konstruktor
    public Kundenberater(String name, String language){
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

      public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    




    @Override
    public String toString(){
        return name;
    }
}
