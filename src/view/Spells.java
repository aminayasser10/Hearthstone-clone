package view;

import java.io.File;

import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.cards.minions.Minion;
import model.cards.spells.MinionTargetSpell;
import model.heroes.Hero;

public class Spells {
	
	public static  void sound2() {

		AudioClip note = new AudioClip( new File("Spell.wav").toURI().toString());
		note.play();
	}

	public static void display(Hero cur , MinionTargetSpell s){
		
		ImageView curfield1 = new ImageView();
		ImageView curfield2 = new ImageView();
		ImageView curfield3 = new ImageView();
		ImageView curfield4 = new ImageView();
		ImageView curfield5 = new ImageView();
		ImageView curfield6 = new ImageView();
		ImageView curfield7 = new ImageView();
	
		updateCurField(curfield1, curfield2, curfield3, curfield4, curfield5, curfield6, curfield7, cur);
		
		
		HBox z = new HBox();
		z.setPadding(new Insets(150, 0, 0, 10));
		z.getChildren().addAll(curfield1,curfield2,curfield3,curfield4,curfield5,curfield6
				,curfield7);
	
		BackgroundImage bg = new BackgroundImage(new Image("file:spellsp.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(800, 450, false,
						false, false, true));
		z.setBackground(new Background(bg));
		Scene ppower = new Scene(z,800,450);
		Stage window = new Stage();
		window.setScene(ppower);
		window.show();
		window.setTitle("Spell Target");

		
				
			curfield1.setOnMouseClicked(e5->{
				if(curfield1.isVisible()){
			Minion m = cur.getField().get(0);
			try {
				cur.castSpell(s, m);sound2();
			}  catch (NotEnoughManaException e1) {
				AlertMana.display();
				e1.printStackTrace();
			} catch (NotYourTurnException e3) {
				AlertTurn.display();
			} catch (InvalidTargetException e3) {
				AlertSpell.display();	 
				 
			}

			finally {
				window.close();
			}
							
					}
						
					});
			curfield2.setOnMouseClicked(e5->{
				if(curfield2.isVisible()){
			Minion m = cur.getField().get(1);
			try {
				cur.castSpell(s, m);sound2();
			}  catch (NotEnoughManaException e1) {
				AlertMana.display();
				e1.printStackTrace();
			} catch (NotYourTurnException e3) {
				AlertTurn.display();
			} catch (InvalidTargetException e3) {
				AlertSpell.display();	 
				 
			}

			finally {
				window.close();
			}
							
					}
						
					});		
					
			curfield3.setOnMouseClicked(e5->{
				if(curfield3.isVisible()){
			Minion m = cur.getField().get(2);
			try {
				cur.castSpell(s, m);sound2();
			}  catch (NotEnoughManaException e1) {
				AlertMana.display();
				e1.printStackTrace();
			} catch (NotYourTurnException e3) {
				AlertTurn.display();
			} catch (InvalidTargetException e3) {
				AlertSpell.display();	 
				 
			}

			finally {
				window.close();
			}
							
					}
						
					});
			
			curfield4.setOnMouseClicked(e5->{
				if(curfield4.isVisible()){
			Minion m = cur.getField().get(3);
			try {
				cur.castSpell(s, m);sound2();
			}  catch (NotEnoughManaException e1) {
				AlertMana.display();
				e1.printStackTrace();
			} catch (NotYourTurnException e3) {
				AlertTurn.display();
			} catch (InvalidTargetException e3) {
				AlertSpell.display();	 
				 
			}

			finally {
				window.close();
			}
							
					}
						
					});
			curfield5.setOnMouseClicked(e5->{
				if(curfield5.isVisible()){
			Minion m = cur.getField().get(4);
			try {
				cur.castSpell(s, m);sound2();
			}  catch (NotEnoughManaException e1) {
				AlertMana.display();
				e1.printStackTrace();
			} catch (NotYourTurnException e3) {
				AlertTurn.display();
			} catch (InvalidTargetException e3) {
				AlertSpell.display();	 
				 
			}

			finally {
				window.close();
			}
							
					}
						
					});
			curfield6.setOnMouseClicked(e5->{
				if(curfield6.isVisible()){
			Minion m = cur.getField().get(5);
			try {
				cur.castSpell(s, m);sound2();
			}  catch (NotEnoughManaException e1) {
				AlertMana.display();
				e1.printStackTrace();
			} catch (NotYourTurnException e3) {
				AlertTurn.display();
			} catch (InvalidTargetException e3) {
				AlertSpell.display();	 
				 
			}

			finally {
				window.close();
			}
							
					}
						
					});
			curfield7.setOnMouseClicked(e5->{
				if(curfield7.isVisible()){
			Minion m = cur.getField().get(6);
			try {
				cur.castSpell(s, m);sound2();
			}  catch (NotEnoughManaException e1) {
				AlertMana.display();
				e1.printStackTrace();
			} catch (NotYourTurnException e3) {
				AlertTurn.display();
			} catch (InvalidTargetException e3) {
				AlertSpell.display();	 
				 
			}

			finally {
				window.close();
			}
							
					}
						
					});
					
				
		
		
		
		
		
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.showAndWait();
		
	}
	public static Image Addtofield(String name) {

		Image card = null;

		switch (name) {
		case "Goldshire Footman":
			card = new Image("file:goldshire.png");
			break;
		case "Stonetusk Boar":
			card = new Image("file:stonetusk.png");
			break;
		case "Bloodfen Raptor":
			card = new Image("file:Bloodfen.png");
			break;
		case "Frostwolf Grunt":
			card = new Image("file:Frostwolf.png");
			break;
		case "Wolfrider":
			card = new Image("file:wolfrider.png");
			break;
		case "Chilwind Yeti":
			card = new Image("file:chillwind.png");
			break;
		case "Boulderfist Ogre":
			card = new Image("file:Boulderfist.png");
			break;
		case "Core Hound":
			card = new Image("file:CoreHound.png");
			break;
		case "Argent Commander":
			card = new Image("file:Argent.png");
			break;
		case "Sunwalker":
			card = new Image("file:sunwalker.png");
			break;
		case "Chromaggus":
			card = new Image("file:chromaggus.png");
			break;
		case "The LichKing":
			card = new Image("file:thelichking.png");
			break;
		case "Icehowl":
			card = new Image("file:icehowl.png");
			break;
		case "Colossus of the Moon":
			card = new Image("file:colossus.png");
			break;
		case "Wilfred Fizzlebang":
			card = new Image("file:wilfred.png");
			break;
		case "Prophet Velen":
			card = new Image("file:prophet.png");
			break;
		case "Kalycgos":
			card = new Image("file:kalecgos.png");
			break;
		case "King Krush":
			card = new Image("file:king.png");
			break;
		case "Tirion Fordring":
			card = new Image("file:tirion.png");
			break;
		case"Silver Hand Recruit":
			card= new Image("file:Silver.png");
		break;
		case"Sheep":
			card= new Image("file:Sheep.png");
		break;
		
		default:
			break;
		}

		return card;
	}

	public static void updateCurField(ImageView curfield1, ImageView curfield2,
			ImageView curfield3, ImageView curfield4, ImageView curfield5,
			ImageView curfield6, ImageView curfield7, Hero curhero) {
		int size = curhero.getField().size();
		switch (size) {
		case 0:
			curfield1.setVisible(false);
			curfield2.setVisible(false);
			curfield3.setVisible(false);
			curfield4.setVisible(false);
			curfield5.setVisible(false);
			curfield6.setVisible(false);
			curfield7.setVisible(false);
			break;
		case 1:
			curfield1.setVisible(true);
			curfield2.setVisible(false);
			curfield3.setVisible(false);
			curfield4.setVisible(false);
			curfield5.setVisible(false);
			curfield6.setVisible(false);
			curfield7.setVisible(false);
			break;
		case 2:
			curfield1.setVisible(true);
			curfield2.setVisible(true);
			curfield3.setVisible(false);
			curfield4.setVisible(false);
			curfield5.setVisible(false);
			curfield6.setVisible(false);
			curfield7.setVisible(false);
			break;
		case 3:
			curfield1.setVisible(true);
			curfield2.setVisible(true);
			curfield3.setVisible(true);
			curfield4.setVisible(false);
			curfield5.setVisible(false);
			curfield6.setVisible(false);
			curfield7.setVisible(false);
			break;
		case 4:
			curfield1.setVisible(true);
			curfield2.setVisible(true);
			curfield3.setVisible(true);
			curfield4.setVisible(true);
			curfield5.setVisible(false);
			curfield6.setVisible(false);
			curfield7.setVisible(false);
			break;
		case 5:
			curfield1.setVisible(true);
			curfield2.setVisible(true);
			curfield3.setVisible(true);
			curfield4.setVisible(true);
			curfield5.setVisible(true);
			curfield6.setVisible(false);
			curfield7.setVisible(false);
			break;
		case 6:
			curfield1.setVisible(true);
			curfield2.setVisible(true);
			curfield3.setVisible(true);
			curfield4.setVisible(true);
			curfield5.setVisible(true);
			curfield6.setVisible(true);
			curfield7.setVisible(false);
			break;
		case 7:
			curfield1.setVisible(true);
			curfield2.setVisible(true);
			curfield3.setVisible(true);
			curfield4.setVisible(true);
			curfield5.setVisible(true);
			curfield6.setVisible(true);
			curfield7.setVisible(true);
			break;
		default:
			break;
		}

		for (int i = 0; i < curhero.getField().size(); i++) {
			switch (i) {
			case 0:
				curfield1.setImage(Addtofield(curhero.getField().get(i)
						.getName()));
				break;
			case 1:
				curfield2.setImage(Addtofield(curhero.getField().get(i)
						.getName()));
				break;
			case 2:
				curfield3.setImage(Addtofield(curhero.getField().get(i)
						.getName()));
				break;
			case 3:
				curfield4.setImage(Addtofield(curhero.getField().get(i)
						.getName()));
				break;
			case 4:
				curfield5.setImage(Addtofield(curhero.getField().get(i)
						.getName()));
				break;
			case 5:
				curfield6.setImage(Addtofield(curhero.getField().get(i)
						.getName()));
				break;
			case 6:
				curfield7.setImage(Addtofield(curhero.getField().get(i)
						.getName()));
				break;
			default:
				break;
			}

		}
	}

}
