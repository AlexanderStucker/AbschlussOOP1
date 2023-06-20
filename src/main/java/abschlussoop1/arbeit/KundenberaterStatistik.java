package abschlussoop1.arbeit;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class KundenberaterStatistik {
    private final SimpleStringProperty kundenberater;
    private final SimpleIntegerProperty anzahlKunden;

    public KundenberaterStatistik(String kundenberater, int anzahlKunden) {
        this.kundenberater = new SimpleStringProperty(kundenberater);
        this.anzahlKunden = new SimpleIntegerProperty(anzahlKunden);
    }

    public String getKundenberater() {
        return kundenberater.get();
    }

    public SimpleStringProperty kundenberaterProperty() {
        return kundenberater;
    }

    public int getAnzahlKunden() {
        return anzahlKunden.get();
    }

    public SimpleIntegerProperty anzahlKundenProperty() {
        return anzahlKunden;
    }
    
}