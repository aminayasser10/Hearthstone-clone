package view;


import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertMana {
public static void main(String[] args) {
		
	}

	
	public static void display () {
		Stage window = new Stage();
		
		window.setTitle("Not Enough Manacrystals");
		StackPane alart = new StackPane();
		
		Button b= new Button("Okay ლ(ಠ_ಠლ)");
		b.setAlignment(Pos.CENTER);
		

		
		alart.getChildren().add(b);
		
		alart.setPadding(new Insets(100, 0, 0, 0));
		Scene y = new Scene(alart, 500,281);

		BackgroundImage bg = new BackgroundImage(new Image("file:manacrystals.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(500, 281, false,
						false, false, true));
		alart.setBackground(new Background(bg));
		window.setScene(y);
		AudioClip note = new AudioClip( new File("Wrong.wav").toURI().toString());
		note.play();
		b.setOnMouseClicked(e-> window.close());
		window.initModality(Modality.APPLICATION_MODAL);
		window.showAndWait();
		
		
		
		
	}


}
