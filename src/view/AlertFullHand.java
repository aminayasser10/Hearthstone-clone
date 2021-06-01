package view;



import java.io.File;

import engine.Game;
import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.Spell;
import model.heroes.Hunter;
import model.heroes.Mage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertFullHand extends Application{
public static void main(String[] args)  {
		launch(args);
	}

	
	public static void display (Card c) {
		AudioClip note = new AudioClip( new File("Wrong.wav").toURI().toString());
		note.play();
		String s = c.getName();
		ImageView ccard1 = new ImageView();
		int i =0;
		switch (s) {
		case "Goldshire Footman":
			if (i == 0) {
				ccard1.setImage(new Image("file:goldshire.png"));
				ccard1.setVisible(true);
			}break;

		case "Stonetusk Boar":
			if (i == 0) {
				ccard1.setImage(new Image("file:stonetusk.png"));
				ccard1.setVisible(true);
			}
			
			break;
		case "Bloodfen Raptor":
			if (i == 0) {
				ccard1.setImage(new Image("file:Bloodfen.png"));
				ccard1.setVisible(true);
			}
			

			break;
		case "Frostwolf Grunt":
			if (i == 0) {
				ccard1.setImage(new Image("file:Frostwolf.png"));
				ccard1.setVisible(true);
			}
			
			break;
		case "Wolfrider":
			if (i == 0) {
				ccard1.setImage(new Image("file:wolfrider.png"));
				ccard1.setVisible(true);
			}
			
			break;
		case "Chilwind Yeti":
			if (i == 0) {
				ccard1.setImage(new Image("file:chillwind.png"));
				ccard1.setVisible(true);
			}
			
			break;
		case "Boulderfist Ogre":
			if (i == 0) {
				ccard1.setImage(new Image("file:Boulderfist.png"));
				ccard1.setVisible(true);
			}
			
			break;
		case "Core Hound":
			if (i == 0) {
				ccard1.setImage(new Image("file:CoreHound.png"));
				ccard1.setVisible(true);
			}
		
			break;
		case "Argent Commander":
			if (i == 0) {
				ccard1.setImage(new Image("file:Argent.png"));
				ccard1.setVisible(true);
			}
		
			break;
		case "Sunwalker":
			if (i == 0) {
				ccard1.setImage(new Image("file:sunwalker.png"));
				ccard1.setVisible(true);
			}
			
			break;
		case "Chromaggus":
			if (i == 0) {
				ccard1.setImage(new Image("file:chromaggus.png"));
				ccard1.setVisible(true);
			}
			
			break;
		case "The LichKing":
			if (i == 0) {
				ccard1.setImage(new Image("file:thelichking.png"));
				ccard1.setVisible(true);
			}
			
			break;
		case "Icehowl":
			if (i == 0) {
				ccard1.setImage(new Image("file:icehowl.png"));
				ccard1.setVisible(true);
			}
			
			break;
		case "Colossus of the Moon":
			if (i == 0) {
				ccard1.setImage(new Image("file:colossus.png"));
				ccard1.setVisible(true);
			}
		
			break;
		case "Curse of Weakness":
			if (i == 0) {
				ccard1.setImage(new Image("file:CurseofWeakness.png"));
				ccard1.setVisible(true);
			}
		
			break;
		case "Divine Spirit":
			if (i == 0) {
				ccard1.setImage(new Image("file:divinespirit.png"));
				ccard1.setVisible(true);
			}
			
			break;
		case "Flamestrike":
			if (i == 0) {
				ccard1.setImage(new Image("file:flamestrike.png"));
				ccard1.setVisible(true);
			}
			
			break;
		case "Holy Nova":
			if (i == 0) {
				ccard1.setImage(new Image("file:holynova.png"));
				ccard1.setVisible(true);
			}
			
			break;

		case "Kill Command":
			if (i == 0) {
				ccard1.setImage(new Image("file:killcommand.png"));
				ccard1.setVisible(true);
			}
			
			break;

		case "Level Up!":
			if (i == 0) {
				ccard1.setImage(new Image("file:LevelUp.png"));
				ccard1.setVisible(true);
			}
			
			break;

		case "Multi-Shot":
			if (i == 0) {
				ccard1.setImage(new Image("file:multishot.png"));
				ccard1.setVisible(true);
			}
			
			break;

		case "Polymorph":
			if (i == 0) {
				ccard1.setImage(new Image("file:polymorph.png"));
				ccard1.setVisible(true);
			}

		
			break;

		case "Pyroblast":
			if (i == 0) {
				ccard1.setImage(new Image("file:pyroblast.png"));
				ccard1.setVisible(true);
			}
		
			break;

		case "Seal of Champions":
			if (i == 0) {
				ccard1.setImage(new Image("file:seal.png"));
				ccard1.setVisible(true);
			}
			
			break;

		case "Shadow Word: Death":
			if (i == 0) {
				ccard1.setImage(new Image("file:shadow.png"));
				ccard1.setVisible(true);
			}

			

			break;
		case "Siphon Soul":
			if (i == 0) {
				ccard1.setImage(new Image("file:Siphon.png"));
				ccard1.setVisible(true);
			}

			
			break;

		case "Twisting Nether":
			if (i == 0) {
				ccard1.setImage(new Image("file:twisting.png"));
				ccard1.setVisible(true);
			}
			
			break;

		case "Kalycgos":
			if (i == 0) {
				ccard1.setImage(new Image("file:kalecgos.png"));
				ccard1.setVisible(true);
			}
			
			break;

		case "Prophet Velen":
			if (i == 0) {
				ccard1.setImage(new Image("file:prophet.png"));
				ccard1.setVisible(true);
			}
			
			break;

		case "Wilfred Fizzlebang":
			if (i == 0) {
				ccard1.setImage(new Image("file:wilfred.png"));
				ccard1.setVisible(true);
			}

		
			break;

		case "Tirion Fordring":
			if (i == 0) {
				ccard1.setImage(new Image("file:tirion.png"));
				ccard1.setVisible(true);
			}
		
			break;

		case "King Krush":
			if (i == 0) {
				ccard1.setImage(new Image("file:king.png"));
				ccard1.setVisible(true);
			}
		
			break;

		default:
			break;
		} 
		
		
		
		Stage window = new Stage();
		
		window.setTitle("Full Hand");
		VBox alart = new VBox(20);
		HBox h = new HBox(10);
		HBox h2 = new HBox(10);
		Button b= new Button("This Card is Burnt ლ(ಠ_ಠლ)");
		
		
		
		BackgroundImage bg = new BackgroundImage(new Image("file:fullhand.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(500, 280, false,
						false, false, true));
		alart.setBackground(new Background(bg));
		
		String infor="";
		if (c instanceof Minion) {

			Minion m = new Minion(c.getName(), c.getManaCost(), c.getRarity(),
					((Minion) c).getAttack(), ((Minion) c).getMaxHP(),
					((Minion) c).isTaunt(), ((Minion) c).isDivine(),
					((Minion) c).isSleeping());
			infor = "Name: " + "" + m.getName() + "\n" + "Attack Points: " + ""
					+ m.getAttack() + "\n" + "Rarity: " + " " + m.getRarity()
					+ "\n" + "Current HP: " + "" + m.getCurrentHP() + "\n"
					+ "Max HP: " + "" + m.getMaxHP() + "\n" + "ManaCost: " + ""
					+ m.getManaCost() + "\n" + "Divine: " + "" + m.isDivine()
					+ "\n" + "Taunt: " + "" + m.isTaunt() ;
		} else {
			
			Spell ss = (Spell) c;

			infor = "Name: " + "" + ss.getName() + "\n" + "Rarity: " + ""
					+ ss.getRarity() + "\n" + "ManaCost: " + ""
					+ ss.getManaCost();
		}
		
		Button info = new Button(infor);
		info.setCancelButton(true);
		info.setTextFill(Color.BLACK);
		alart.setPadding(new Insets(55, 0, 0, 15));
		
		h.getChildren().add(ccard1);
		h.getChildren().addAll(info);
		h2.getChildren().add(b);
		alart.getChildren().addAll(h,h2);
		Scene y = new Scene(alart, 500,281);
		
		
		window.setScene(y);
		window.setResizable(false);
		b.setOnMouseClicked(e-> window.close());
		info.setOnMouseClicked(e-> window.close());
		window.initModality(Modality.APPLICATION_MODAL);
		window.showAndWait();
		
}


	@Override
	public void start(Stage primaryStage) throws Exception {
		
	Game	game = new Game(new Mage(), new Hunter());
		display(game.getCurrentHero().getHand().get(0)  );
		
	}


	
}