module abschlussoop1.arbeit {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens abschlussoop1.arbeit to javafx.fxml;
    exports abschlussoop1.arbeit;
}
