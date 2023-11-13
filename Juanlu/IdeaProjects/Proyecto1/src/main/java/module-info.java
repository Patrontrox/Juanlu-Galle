module com.juanlu.proyecto1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.juanlu.proyecto1 to javafx.fxml;
    exports com.juanlu.proyecto1;
    exports com.juanlu.proyecto1.Modelos;
    opens com.juanlu.proyecto1.Modelos to javafx.fxml;
    exports com.juanlu.proyecto1.Controladores;
    opens com.juanlu.proyecto1.Controladores to javafx.fxml;
}