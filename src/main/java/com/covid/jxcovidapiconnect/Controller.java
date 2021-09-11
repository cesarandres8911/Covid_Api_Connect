package com.covid.jxcovidapiconnect;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import org.controlsfx.control.ToggleSwitch;
import org.controlsfx.control.textfield.TextFields;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Controller {

    @FXML
    private ToggleSwitch tsDarkLigth;

    @FXML
    private TableView<Summary> tdData;

    @FXML
    private Button btnSearchCountry;

    @FXML
    private TextField txtCountry;

    private TableColumn<Summary, String> tcCountry = new TableColumn<>();
    private TableColumn<Summary, String> tcNewConfirmed  = new TableColumn<>();
    private TableColumn<Summary, String> tcTotalConfirmed = new TableColumn<>();
    private TableColumn<Summary, String> tcNewDeaths = new TableColumn<>();
    private TableColumn<Summary, String> tcTotalDeaths = new TableColumn<>();
    private TableColumn<Summary, String> tcTotalRecovered = new TableColumn<>();
    private TableColumn<Summary, String> tcDate = new TableColumn<>();


    @FXML
    void changeTheme(MouseEvent event) {
        tsDarkLigth.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Prueba");
            }
        });
    }

    @FXML
    void searchCountry(ActionEvent event) throws IOException, ParseException {
        CovidApiRequest covidApi = new CovidApiRequest();
        tdData.getItems().add(covidApi.summaryConnect(txtCountry.getText()));
        //tdData.getItems().add(new Summary("colombia","15","14","10","8","9","1235456"));
        //tdData.getItems().add(new Summary("alemania","12","15","20","18","249","123"));
    }

    @FXML
    void initialize() throws IOException {
        CovidApiRequest covidApi = new CovidApiRequest();

        // Get all Country from Covid-19 API
        covidApi.countryConnect();

        // Add String array suggesting to search country TextField.
        TextFields.bindAutoCompletion(txtCountry, covidApi.CountrySuggestion());

        // Assign column index from tableView fxml.
        tcCountry = (TableColumn<Summary, String>) tdData.getColumns().get(0);
        tcNewConfirmed  = (TableColumn<Summary, String>) tdData.getColumns().get(1);
        tcTotalConfirmed = (TableColumn<Summary, String>) tdData.getColumns().get(2);
        tcNewDeaths = (TableColumn<Summary, String>) tdData.getColumns().get(3);
        tcTotalDeaths = (TableColumn<Summary, String>) tdData.getColumns().get(4);
        tcTotalRecovered = (TableColumn<Summary, String>) tdData.getColumns().get(5);
        tcDate = (TableColumn<Summary, String>) tdData.getColumns().get(6);

        // Assign data from Summary Class fields
        tcCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        tcNewConfirmed.setCellValueFactory(new PropertyValueFactory<>("newConfirmed"));
        tcTotalConfirmed.setCellValueFactory(new PropertyValueFactory<>("totalConfirmed"));
        tcNewDeaths.setCellValueFactory(new PropertyValueFactory<>("newDeaths"));
        tcTotalDeaths.setCellValueFactory(new PropertyValueFactory<>("totalDeaths"));
        tcTotalRecovered.setCellValueFactory(new PropertyValueFactory<>("totalRecovery"));
        tcDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }
}
