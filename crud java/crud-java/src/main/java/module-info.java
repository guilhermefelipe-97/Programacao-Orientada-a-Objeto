module com.poo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.poo to javafx.fxml;
    exports com.poo;
}
