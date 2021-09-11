module com.covid.jxcovidapiconnect {
    requires javafx.controls;
    requires javafx.fxml;

    requires json.simple;
    requires org.controlsfx.controls;

    opens com.covid.jxcovidapiconnect to javafx.fxml;
    exports com.covid.jxcovidapiconnect;
}