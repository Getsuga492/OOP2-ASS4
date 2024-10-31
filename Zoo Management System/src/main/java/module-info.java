module com.example.oop2a4f24 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop2a4f24 to javafx.fxml;
    exports com.example.oop2a4f24;
}