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

public class Alerthero  {
	public static void main(String[] args) {
		
	}

	
	public static void display () {
		Stage window = new Stage();
		AudioClip note = new AudioClip( new File("Wrong.wav").toURI().toString());
		note.play();
		window.setTitle("Player names Error");
		StackPane alart = new StackPane();
		alart.setPadding(new Insets(75, 0, 0, 0));
		Button b= new Button("OKAY");
		b.setAlignment(Pos.CENTER);
		
//		alart.setHgap(5);
		
		alart.getChildren().add(b);
		
		
		Scene y = new Scene(alart,500,281);
		window.setScene(y);
		BackgroundImage bg = new BackgroundImage(new Image("file:choosehero.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(500, 281, false,
						false, false, true));
		alart.setBackground(new Background(bg));
		
		b.setOnMouseClicked(e-> window.close());
		window.initModality(Modality.APPLICATION_MODAL);
		window.showAndWait();
		
	
		
		
	}

}
