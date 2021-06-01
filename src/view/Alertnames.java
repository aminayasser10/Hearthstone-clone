package view;






import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alertnames  {
	public static void main(String[] args) {
		
	}

	
	public static void display () {
		Stage window = new Stage();
		AudioClip note = new AudioClip( new File("Wrong.wav").toURI().toString());
		note.play();
		window.setTitle("Player no chosen hero Error");
		VBox alart = new VBox();
		Label x= new Label("Please write all Player Names");
		Button b= new Button("OKAY");
		b.setAlignment(Pos.CENTER);
		alart.setPadding(new Insets(15, 0, 5, 75));
//		alart.setHgap(5);
		alart.getChildren().add(x);
		alart.getChildren().add(b);
		
		
		Scene y = new Scene(alart, 300,80);
		window.setScene(y);
		b.setOnMouseClicked(e-> window.close());
		window.initModality(Modality.APPLICATION_MODAL);
		window.showAndWait();
		
	
		
		
	}

}
