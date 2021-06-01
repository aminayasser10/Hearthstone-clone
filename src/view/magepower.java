package view;

import java.io.File;

import javafx.scene.Scene;
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
import javafx.stage.Modality;
import javafx.stage.Stage;


import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.NotEnoughManaException;

public class magepower {
	public static  void sound2() {

		AudioClip note = new AudioClip( new File("Sword.wav").toURI().toString());
		note.play();
	}
public static  void display(Hero cur , Hero opphero  ){
		
		ImageView oppfield1 = new ImageView();
		ImageView oppfield2 = new ImageView();
		ImageView oppfield3 = new ImageView();
		ImageView oppfield4 = new ImageView();
		ImageView oppfield5 = new ImageView();
		ImageView oppfield6 = new ImageView();
		ImageView oppfield7 = new ImageView();
		
		ImageView player2heropic = new ImageView();
		if (opphero instanceof Mage)
			player2heropic.setImage(new Image("file:Jaina.png"));
		else if (opphero instanceof Hunter)
			player2heropic.setImage(new Image("file:Rexxar.png"));
		else if (opphero instanceof Priest)
			player2heropic.setImage(new Image("file:Anduin.png"));
		else if (opphero instanceof Paladin)
			player2heropic.setImage(new Image("file:img.png"));
		else
			player2heropic.setImage(new Image("file:warlockhero.png"));


		updateCurField(oppfield1, oppfield2, oppfield3, oppfield4, oppfield5, oppfield6, oppfield7, opphero);
		VBox x = new VBox();
		HBox y = new HBox();
		y.getChildren().add(player2heropic);
		HBox z = new HBox();
		z.getChildren().addAll(oppfield1,oppfield2,oppfield3,oppfield4,oppfield5,oppfield6
				,oppfield7);
		x.getChildren().add(y);
		x.getChildren().add(z);
		BackgroundImage bg = new BackgroundImage(new Image("file:magepower.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(800, 450, false,
						false, false, true));
		x.setBackground(new Background(bg));
		Scene ppower = new Scene(x,800,450);
		Stage window = new Stage();
		window.setTitle("Choose Your Target");
		window.setScene(ppower);
		window.show();
			
		
		


		if (oppfield1.isVisible()) {
			oppfield1.setOnMouseClicked(e2 -> {
				Mage use = (Mage) cur;
				try {
					use.useHeroPower(opphero.getField()
							.get(0));
					sound2();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e8) {
					AlertPowerused.display();
				} catch (Exception e5) {

				} finally {
					window.close();
				}

			});
		}
		if (oppfield2.isVisible()) {
			oppfield2.setOnMouseClicked(e2 -> {
				Mage use = (Mage) cur;
				try {
					use.useHeroPower(opphero.getField()
							.get(1));sound2();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e8) {
					AlertPowerused.display();
				} catch (Exception e5) {

				} finally {
					window.close();
				}

			});
		}
		if (oppfield3.isVisible()) {
			oppfield3.setOnMouseClicked(e2 -> {
				Mage use = (Mage) cur;
				try {
					use.useHeroPower(opphero.getField()
							.get(2));sound2();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e8) {
					AlertPowerused.display();
				} catch (Exception e5) {

				} finally {
					window.close();
				}

			});
		}
		if (oppfield4.isVisible()) {
			oppfield4.setOnMouseClicked(e2 -> {
				Mage use = (Mage) cur;
				try {
					use.useHeroPower(opphero.getField()
							.get(3));sound2();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e8) {
					AlertPowerused.display();
				} catch (Exception e5) {

				} finally {
					window.close();
				}

			});
		}
		if (oppfield5.isVisible()) {
			oppfield5.setOnMouseClicked(e2 -> {
				Mage use = (Mage) cur;
				try {
					use.useHeroPower(opphero.getField()
							.get(4));sound2();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e8) {
					AlertPowerused.display();
				} catch (Exception e5) {

				} finally {
					window.close();
				}

			});
		}
		if (oppfield6.isVisible()) {
			oppfield6.setOnMouseClicked(e2 -> {
				Mage use = (Mage) cur;
				try {
					use.useHeroPower(opphero.getField()
							.get(5));sound2();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e8) {
					AlertPowerused.display();
				} catch (Exception e5) {

				} finally {
					window.close();
				}

			});
		}
		if (oppfield7.isVisible()) {
			oppfield7.setOnMouseClicked(e2 -> {
				Mage use = (Mage) cur;
				try {
					use.useHeroPower(opphero.getField()
							.get(6));sound2();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e8) {
					AlertPowerused.display();
				} catch (Exception e5) {

				} finally {
					window.close();
				}

			});
		}
		player2heropic.setOnMouseClicked(e2 -> {
			Mage use = (Mage) cur;
			try {
				use.useHeroPower(opphero);sound2();
			} catch (NotEnoughManaException e1) {
				AlertMana.display();
				e1.printStackTrace();
			} catch (HeroPowerAlreadyUsedException e8) {
				AlertPowerused.display();
			} catch (Exception e5) {

			} finally {
				window.close();
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
