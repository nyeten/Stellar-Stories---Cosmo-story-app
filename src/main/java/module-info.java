module com.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.solar to javafx.fxml;
    exports com.solar;
}
