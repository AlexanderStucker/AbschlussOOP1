package abschlussoop1.arbeit;


public class VersichertePerson {

    private String name;
    private int franchise_defaulte = 300;
    private Kundenberater kundenberater;


    //Konstruktor
    public VersichertePerson(String name, int franchise_defaulte){
        this.name = name;
        this.franchise_defaulte = franchise_defaulte;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFranchise(){
        return franchise_defaulte;
    }

    public void setFranchise(int franchise) {
        this.franchise_defaulte = franchise;
    }

    public Kundenberater getKundenberater(){
        return kundenberater;
    }

    public void setKundenberater(Kundenberater kundenberater) {
        this.kundenberater = kundenberater;
    }
        
}
