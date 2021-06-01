package view;

import java.io.File;

import javafx.geometry.Insets;
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

public class instruction {
	public static  void sound2() {

		AudioClip note = new AudioClip( new File("Click.wav").toURI().toString());
		note.play();
	}
public instruction() {
	// TODO Auto-generated constructor stub
}

public static void display(){
	Stage window = new Stage();
	StackPane layout = new StackPane();
	Button back = new Button("BACK");
	back.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9;");
	back.setMaxSize(100, 30);
	layout.getChildren().add(back);
	layout.setPadding(new Insets(500,0, 0, 170));
	Scene scene = new Scene(layout,487,660);
	window.setTitle("Instruction");

	BackgroundImage bg = new BackgroundImage(new Image("file:ins.png"),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER, new BackgroundSize(487, 680, false,
					false, false, true));
	layout.setBackground(new Background(bg));
	
	
	window.setScene(scene);
	window.show();
	back.setOnMouseClicked(e->{
		sound2();
		window.close();
	});
	
	window.initModality(Modality.APPLICATION_MODAL);
	window.showAndWait();
}



}
