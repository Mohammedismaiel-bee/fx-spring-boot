package com.mohammedismaiel.fxspringboot.app.fx.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.mohammedismaiel.fxspringboot.BootFXApplication;

@Component
public class MainController {

    private ConfigurableApplicationContext context;

    @FXML
    private Button startServerButton;

    @FXML
    private Button stopServerButton;
    @FXML
    private Button exit;

    @FXML
    private Circle state;

    @FXML
    private HBox buttonsContainer;

    @FXML
    private void initialize() {
        stopServerButton.setDisable(true);
    }

    @FXML
    private void exit() {
        handleStopServer();
        Platform.exit();
    }

    @FXML
    private void handleStartServer() {
        if (context == null)
            context = SpringApplication.run(BootFXApplication.class);
        startServerButton.setDisable(true);
        stopServerButton.setDisable(false);
        state.setFill(Paint.valueOf("#34eb52"));
    }

    @FXML
    private void handleStopServer() {
        shutdown();
        startServerButton.setDisable(false);
        stopServerButton.setDisable(true);
        state.setFill(Paint.valueOf("#cf4611f5"));
    }

    public void shutdown() {
        if (context != null) {
            context.close();
            context = null;
        }
    }
}
