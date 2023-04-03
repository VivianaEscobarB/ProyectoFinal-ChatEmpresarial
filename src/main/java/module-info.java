module com.example.proyectofinalchatempresarial {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                requires org.kordamp.ikonli.javafx;
                
    opens com.example.proyectofinalchatempresarial to javafx.fxml;
    exports com.example.proyectofinalchatempresarial;
}