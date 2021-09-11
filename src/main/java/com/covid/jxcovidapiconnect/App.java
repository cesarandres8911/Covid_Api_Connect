package com.covid.jxcovidapiconnect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("covid-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Covid-19");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/covid-19.png"))));
        scene.getStylesheets().add(String.valueOf(getClass().getResource("/Style/stylesheet.css")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}