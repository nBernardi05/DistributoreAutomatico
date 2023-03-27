module com.bernardisrl.distributoreautomatico {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.bernardisrl.distributoreautomatico to javafx.fxml;
    exports com.bernardisrl.distributoreautomatico;
}
