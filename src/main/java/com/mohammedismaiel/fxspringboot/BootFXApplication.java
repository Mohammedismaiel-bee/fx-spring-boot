package com.mohammedismaiel.fxspringboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mohammedismaiel.fxspringboot.app.fx.controller.MainController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@SpringBootApplication
public class BootFXApplication extends javafx.application.Application {

	private static ConfigurableApplicationContext context = null;
	private MainController controller;
	private double xOffset = 0;
	private double yOffset = 0;

	public static void main(String[] args) {
		launch(args);
	}

	{
		// @Override
		// public void start(Stage primaryStage) throws Exception {
		// Button startServerButton = new Button("Start Server");
		// Button stopServerButton = new Button("Stop Server");
		// Text state = new Text("Down");
		// StackPane root = new StackPane();
		// stopServerButton.setDisable(true);
		//
		// startServerButton.setOnAction(event -> {
		// if (context == null)
		// context = SpringApplication.run(BootFXApplication.class);
		// startServerButton.setDisable(true);
		// stopServerButton.setDisable(false);
		// state.setText("Running");
		// });
		//
		// stopServerButton.setOnAction(event -> {
		// if (context != null) {
		// context.close();
		// context = null;
		// }
		// startServerButton.setDisable(false);
		// stopServerButton.setDisable(true);
		// state.setText("Down");
		// });
		//
		// HBox buttonsContainer = new HBox(startServerButton, stopServerButton, state);
		// buttonsContainer.setAlignment(Pos.CENTER);
		// buttonsContainer.setSpacing(10);
		//
		// root.getChildren().add(buttonsContainer);
		//
		// Scene scene = new Scene(root, 300, 250);
		// primaryStage.setTitle("My App Amin pannel");
		// primaryStage.setScene(scene);
		// primaryStage.show();
		// primaryStage.setOnCloseRequest(event -> {
		// if (context!=null)
		// context.close();
		// });
		// }
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		Parent root = loader.load();
		controller = loader.getController();
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("/fxml/style.css").toExternalForm());

		scene.setFill(Color.TRANSPARENT);

		root.setOnMousePressed(event -> {
			xOffset = event.getSceneX();
			yOffset = event.getSceneY();
		});

		root.setOnMouseDragged(event -> {
			primaryStage.setX(event.getScreenX() - xOffset);
			primaryStage.setY(event.getScreenY() - yOffset);
		});

		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event -> {
			if (context != null)
				context.close();
			controller.shutdown();
		});
	}
}
