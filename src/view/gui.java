package view;




import java.io.File;

import engine.Game;
import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.AOESpell;
import model.cards.spells.DivineSpirit;
import model.cards.spells.FieldSpell;
import model.cards.spells.KillCommand;
import model.cards.spells.LeechingSpell;
import model.cards.spells.MinionTargetSpell;
import model.cards.spells.Polymorph;
import model.cards.spells.Pyroblast;
import model.cards.spells.SealOfChampions;
import model.cards.spells.ShadowWordDeath;
import model.cards.spells.SiphonSoul;
import model.cards.spells.Spell;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class gui extends Application {

	Hero player1;
	Hero player2;
	Game game;
	boolean targeting;

	public static void main(String[] args) {
//		 String uriString = new File("Music.wav").toURI().toString();
//		    MediaPlayer player = new MediaPlayer( new Media(uriString));
//		   player.setVolume(0.1);
		   // player.play();
//		AudioClip note = new AudioClip( new File("Music.wav").toURI().toString());
//		note.setVolume(0.5);
//		note.play();
		//sound("Music.wav");
		launch(args);
		
	}

	public static void sound(String name) {
		AudioClip note = new AudioClip( new File(name).toURI().toString());
		note.play();
	}
	public  void sound2(String name) {
//		 String uriString = new File(name).toURI().toString();
//		    MediaPlayer player = new MediaPlayer( new Media(uriString));
//		    player.play();
		AudioClip note = new AudioClip( new File(name).toURI().toString());
		note.play();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage window = new Stage();
		primaryStage = window;
		window.setTitle("Hearthstone");

		scene1(window);

		// playerOne scene to choose

		// startButton.setOnAction(e-> window.setScene(name()));

		window.setResizable(false);

		window.show();

	}

	public void scene1(Stage window) {
	

		
		 
         
		StackPane startlayout = new StackPane();// Start pane

		// will add start pic and button
		Image startImage = new Image("file:Start1.jpg");
		ImageView startview = new ImageView(startImage);
		Group startg = new Group();
		startg.getChildren().addAll(startview);
		Button startButton = new Button("PLAY");

		startButton.setMaxHeight(50);
		startButton.setMaxWidth(125);
		startButton.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
		startlayout.getChildren().addAll(startg, startButton);
		Scene startScene = new Scene(startlayout, 1275, 680);
		window.setScene(startScene);
		startButton.setOnMouseClicked(e -> {sound2("Click.wav");
		scene2(window);
			
		});
		
	}

	public void scene2(Stage window) {

		Button next = new Button("Next");
		next.setAlignment(Pos.BOTTOM_CENTER);
		next.setMaxHeight(50);
		next.setMaxWidth(140);
		next.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");

		TextField playerone = new TextField();
		playerone.setPromptText("Player One Name       ");
		playerone.setOnKeyPressed(e->{
			sound2("typing.wav");
		});
		TextField playertwo = new TextField();
		playertwo.setOnKeyPressed(e->{
			sound2("typing.wav");
		});
		playertwo.setPromptText("Player Two Name:      ");
		playerone.setMaxSize(200, 80);
		playertwo.setMaxSize(200, 80);

		GridPane namelayout = new GridPane();
		playerone.setAlignment(Pos.CENTER_RIGHT);
		playertwo.setAlignment(Pos.CENTER_RIGHT);

		Image nameimage = new Image("file:setname.png");
		ImageView nameview = new ImageView(nameimage);
		Group nameg = new Group();
		nameg.getChildren().addAll(nameview);
		BackgroundImage bg = new BackgroundImage(new Image("file:setname.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1275, 680, false,
						false, false, true));

		namelayout.setPadding(new Insets(50, 50, 50, 50));
		namelayout.setHgap(20);
		namelayout.setVgap(20);
		namelayout.add(playerone, 25, 12);
		namelayout.add(playertwo, 25, 14);
		namelayout.add(next, 25, 20);

		Scene writename = new Scene(namelayout, 1275, 680);
		namelayout.setBackground(new Background(bg));
		window.setScene(writename);
		Button tool = new Button("Instructions") ;
		tool.setMaxHeight(50);
		tool.setMaxWidth(140);
		tool.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9;");
		
		namelayout.add(tool, 25, 21);
		tool.setOnMouseClicked(e->{
			sound2("Click.wav");
			instruction.display();
			
			
		});
		
		next.setOnMouseClicked(e -> {sound2("Click.wav");
			if (playerone.getText().isEmpty() || playertwo.getText().isEmpty()) {
				Alertnames.display();

			} else {
				scene3(window, playerone.getText(), playertwo.getText());
			}

		});

	}

	public void scene3(Stage window, String p1, String p2) {
		String herop1[] = new String[1];
		BorderPane layout = new BorderPane();
		HBox x = new HBox(13);
		layout.setCenter(x);
		x.setPadding(new Insets(100, 59, 0, 90));
		layout.setPadding(new Insets(30));

		BackgroundImage bg = new BackgroundImage(new Image("file:chooseh.jpg"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1275, 680, false,
						false, false, true));
		layout.setBackground(new Background(bg));

		ToggleButton h1 = new ToggleButton();
		ToggleButton h2 = new ToggleButton();
		ToggleButton h3 = new ToggleButton();
		ToggleButton h4 = new ToggleButton();
		ToggleButton h5 = new ToggleButton();

		h1.setGraphic(new ImageView("file:mage.jpg"));
		h1.setPadding(new Insets(0));
		h2.setGraphic(new ImageView("file:hunter.jpg"));
		h2.setPadding(new Insets(0));
		h3.setGraphic(new ImageView("file:paladin.jpg"));
		h3.setPadding(new Insets(0));
		h4.setGraphic(new ImageView("file:priest.jpg"));
		h4.setPadding(new Insets(0));
		h5.setGraphic(new ImageView("file:warlock.jpg"));
		h5.setPadding(new Insets(0));
		x.getChildren().add(h1);
		x.getChildren().add(h2);
		x.getChildren().add(h3);
		x.getChildren().add(h4);
		x.getChildren().add(h5);

		Label hero = new Label("Please" + " " + p1 + " " + "choose your hero");

		hero.setTextFill(Color.WHITE);
		hero.setFont(Font.font("CHILLER", FontWeight.BOLD, 70));
		StackPane stack = new StackPane();
		stack.getChildren().addAll(hero);
		layout.setTop(stack);

		Button next = new Button("Next Player");
		StackPane down = new StackPane();
		layout.setBottom(down);
		down.getChildren().add(next);
		down.setMaxHeight(300);
		down.setMaxWidth(1300);
		down.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");

		Scene hero1 = new Scene(layout, 1275, 680);

		h1.setMaxSize(10, 30);
		window.setScene(hero1);
		DropShadow x1 = new DropShadow();
		x1.setColor(Color.WHITESMOKE);
		x1.setSpread(0.7);

		h1.setOnMouseClicked(e -> {
			sound2("Click.wav");
			h1.setEffect(x1);
			h2.setEffect(null);
			h3.setEffect(null);
			h4.setEffect(null);
			h5.setEffect(null);

		});

		h2.setOnMouseClicked(e -> {
			sound2("Click.wav");
			h2.setEffect(x1);
			h1.setEffect(null);
			h3.setEffect(null);
			h4.setEffect(null);
			h5.setEffect(null);

		});

		h3.setOnMouseClicked(e -> {
			sound2("Click.wav");
			h3.setEffect(x1);
			h2.setEffect(null);
			h1.setEffect(null);
			h4.setEffect(null);
			h5.setEffect(null);

		});

		h4.setOnMouseClicked(e -> {
			sound2("Click.wav");
			h4.setEffect(x1);
			h2.setEffect(null);
			h3.setEffect(null);
			h1.setEffect(null);
			h5.setEffect(null);

		});

		h5.setOnMouseClicked(e -> {sound2("Click.wav");
			h5.setEffect(x1);
			h2.setEffect(null);
			h3.setEffect(null);
			h4.setEffect(null);
			h1.setEffect(null);

		});

		next.setOnMouseClicked(e -> {
			if (h1.getEffect() != null)
				herop1[0] = "mage";
			if (h2.getEffect() != null)
				herop1[0] = "hunter";
			if (h3.getEffect() != null)
				herop1[0] = "paladin";
			if (h4.getEffect() != null)
				herop1[0] = "priest";
			if (h5.getEffect() != null)
				herop1[0] = "warlock";
			if (herop1[0] != null) {
				sound2("Click.wav");
				scenename2(herop1[0], p1, p2, window);
			} else {
				Alerthero.display();

			}

		});

	}

	public void scenename2(String herop1, String p1, String p2, Stage window) {
		String herop2[] = new String[1];
		BorderPane layout = new BorderPane();
		HBox x = new HBox(13);
		layout.setCenter(x);
		x.setPadding(new Insets(100, 59, 0, 90));
		layout.setPadding(new Insets(30));

		BackgroundImage bg = new BackgroundImage(new Image("file:chooseh.jpg"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1275, 680, false,
						false, false, true));
		layout.setBackground(new Background(bg));

		ToggleButton h1 = new ToggleButton();
		ToggleButton h2 = new ToggleButton();
		ToggleButton h3 = new ToggleButton();
		ToggleButton h4 = new ToggleButton();
		ToggleButton h5 = new ToggleButton();

		h1.setGraphic(new ImageView("file:mage.jpg"));
		h1.setPadding(new Insets(0));
		h2.setGraphic(new ImageView("file:hunter.jpg"));
		h2.setPadding(new Insets(0));
		h3.setGraphic(new ImageView("file:paladin.jpg"));
		h3.setPadding(new Insets(0));
		h4.setGraphic(new ImageView("file:priest.jpg"));
		h4.setPadding(new Insets(0));
		h5.setGraphic(new ImageView("file:warlock.jpg"));
		h5.setPadding(new Insets(0));
		x.getChildren().add(h1);
		x.getChildren().add(h2);
		x.getChildren().add(h3);
		x.getChildren().add(h4);
		x.getChildren().add(h5);

		Label hero = new Label("Please" + " " + p2 + " " + "choose your hero");

		hero.setTextFill(Color.WHITE);
		hero.setFont(Font.font("CHILLER", FontWeight.BOLD, 70));
		StackPane stack = new StackPane();
		stack.getChildren().addAll(hero);
		layout.setTop(stack);

		Button next = new Button("Start Game");
		StackPane down = new StackPane();
		layout.setBottom(down);
		down.getChildren().add(next);
		down.setMaxHeight(300);
		down.setMaxWidth(1300);
		down.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");

		Scene hero1 = new Scene(layout, 1275, 680);

		h1.setMaxSize(10, 30);
		window.setScene(hero1);
		DropShadow x1 = new DropShadow();
		x1.setColor(Color.WHITESMOKE);
		x1.setSpread(0.7);

		h1.setOnMouseClicked(e -> {
			sound2("Click.wav");
			h1.setEffect(x1);
			h2.setEffect(null);
			h3.setEffect(null);
			h4.setEffect(null);
			h5.setEffect(null);

		});

		h2.setOnMouseClicked(e -> {
			sound2("Click.wav");
			h2.setEffect(x1);
			h1.setEffect(null);
			h3.setEffect(null);
			h4.setEffect(null);
			h5.setEffect(null);

		});

		h3.setOnMouseClicked(e -> {
			sound2("Click.wav");
			h3.setEffect(x1);
			h2.setEffect(null);
			h1.setEffect(null);
			h4.setEffect(null);
			h5.setEffect(null);

		});

		h4.setOnMouseClicked(e -> {
			sound2("Click.wav");
			h4.setEffect(x1);
			h2.setEffect(null);
			h3.setEffect(null);
			h1.setEffect(null);
			h5.setEffect(null);

		});

		h5.setOnMouseClicked(e -> {sound2("Click.wav");
			h5.setEffect(x1);
			h2.setEffect(null);
			h3.setEffect(null);
			h4.setEffect(null);
			h1.setEffect(null);

		});

		next.setOnMouseClicked(e -> {
			if (h1.getEffect() != null)
				herop2[0] = "mage";
			if (h2.getEffect() != null)
				herop2[0] = "hunter";
			if (h3.getEffect() != null)
				herop2[0] = "paladin";
			if (h4.getEffect() != null)
				herop2[0] = "priest";
			if (h5.getEffect() != null)
				herop2[0] = "warlock";
			if (herop2[0] != null) {
				sound2("Click.wav");
				switch (herop1) {
				case "mage":

					try {
						player1 = new Mage();
					} catch (Exception e3) {

						e3.printStackTrace();
					}

					break;
				case "hunter":

					try {
						player1 = new Hunter();
					} catch (Exception e2) {

						e2.printStackTrace();
					}
					break;
				case "priest":

					try {
						player1 = new Priest();
					} catch (Exception e2) {

						e2.printStackTrace();
					}
					break;
				case "paladin":

					try {
						player1 = new Paladin();
					} catch (Exception e2) {

						e2.printStackTrace();
					}
					break;
				case "warlock":

					try {
						player1 = new Warlock();
					} catch (Exception e2) {

						e2.printStackTrace();
					}
					break;
				default:

					break;
				}
				switch (herop2[0]) {
				case "mage":

					try {
						player2 = new Mage();
					} catch (Exception e2) {

						e2.printStackTrace();
					}
					break;
				case "hunter":

					try {
						player2 = new Hunter();
					} catch (Exception e2) {

						e2.printStackTrace();
					}
					break;
				case "priest":

					try {
						player2 = new Priest();
					} catch (Exception e2) {

						e2.printStackTrace();
					}
					break;
				case "paladin":

					try {
						player2 = new Paladin();
					} catch (Exception e2) {

						e2.printStackTrace();
					}
					break;
				case "warlock":

					try {
						player2 = new Warlock();
					} catch (Exception e2) {

						e2.printStackTrace();
					}
					break;
				default:
					break;
				}
				try {

					Gamegui(p1, p2, herop1, herop2[0], window);

				} catch (Exception e1) {

					e1.printStackTrace();

				}

			} else {
				Alerthero.display();

			}

		});

	}

	public void Gamegui(String p1name, String p2name, String h1, String h2,
			Stage window) throws Exception {
		Hero curhero;
		Hero opphero;
		String playercurname = p1name;
		String playeropname = p2name;
		playercurname = playercurname +"";
		playeropname = playeropname +"";
		game = new Game(player1, player2);

		if (game.getCurrentHero() == player1) {
			curhero = player1;
			opphero = player2;
			playercurname = p1name;
			playeropname = p2name;
		} else {
			opphero = player1;
			curhero = player2;
			playercurname = p2name;
			playeropname = p1name;
		}

		BorderPane field = new BorderPane();
		BackgroundImage bg = new BackgroundImage(new Image("file:field.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1275, 680, false,
						false, false, true));
		field.setBackground(new Background(bg));
		// set player 2 hero pic
		ImageView player2heropic = new ImageView();
		// player 1 hero pic
		ImageView player1heropic = new ImageView();
		swipPic(player1heropic, player2heropic, curhero, opphero);

		// adding deck of current player and hero pic
		HBox curherobox = new HBox(5.5);
		curherobox.setPadding(new Insets(0, 0, 10, 20)); // new Insets(top,
															// right, bottom,
															// left)
		field.setBottom(curherobox);

		ImageView ccard1 = new ImageView("file:player1deck.jpg");
		ImageView ccard2 = new ImageView("file:player1deck.jpg");
		ImageView ccard3 = new ImageView("file:player1deck.jpg");
		ImageView ccard4 = new ImageView("file:player1deck.jpg");
		ImageView ccard5 = new ImageView("file:player1deck.jpg");
		ImageView ccard6 = new ImageView("file:player1deck.jpg");
		ImageView ccard7 = new ImageView("file:player1deck.jpg");
		ImageView ccard8 = new ImageView("file:player1deck.jpg");
		ImageView ccard9 = new ImageView("file:player1deck.jpg");
		ImageView ccard10 = new ImageView("file:player1deck.jpg");

		ccard1.setVisible(false);
		ccard2.setVisible(false);
		ccard3.setVisible(false);
		ccard4.setVisible(false);
		ccard5.setVisible(false);
		ccard6.setVisible(false);
		ccard7.setVisible(false);
		ccard8.setVisible(false);
		ccard9.setVisible(false);
		ccard10.setVisible(false);

		curherobox.getChildren().addAll(ccard1, ccard2, ccard3, ccard4, ccard5,
				player1heropic, ccard6, ccard7, ccard8, ccard9, ccard10);
		// adding deck and hero of opp
		HBox opheroBox = new HBox(5.5);
		opheroBox.setPadding(new Insets(0, 0, 10, 20));
		field.setTop(opheroBox);

		ImageView ocard1 = new ImageView("file:player1deck.jpg");
		ImageView ocard2 = new ImageView("file:player1deck.jpg");
		ImageView ocard3 = new ImageView("file:player1deck.jpg");
		ImageView ocard4 = new ImageView("file:player1deck.jpg");
		ImageView ocard5 = new ImageView("file:player1deck.jpg");
		ImageView ocard6 = new ImageView("file:player1deck.jpg");
		ImageView ocard7 = new ImageView("file:player1deck.jpg");
		ImageView ocard8 = new ImageView("file:player1deck.jpg");
		ImageView ocard9 = new ImageView("file:player1deck.jpg");
		ImageView ocard10 = new ImageView("file:player1deck.jpg");

		opheroBox.getChildren().addAll(ocard1, ocard2, ocard3, ocard4, ocard5,
				player2heropic, ocard6, ocard7, ocard8, ocard9, ocard10);

		// adding endturn button
		ImageView endturn = new ImageView("File:EndTurn.png");

		StackPane endturnstack = new StackPane();
		endturnstack.setPadding(new Insets(0, 0, 70, 0));
		endturnstack.getChildren().add(endturn);
		field.setRight(endturnstack);

		infoCurHand(ccard1, ccard2, ccard3, ccard4, ccard5, ccard6, ccard7,
				ccard8, ccard9, ccard10, curhero);

		ocard1.setOnMouseMoved(e -> {
			if (ocard1.isVisible())
				Tooltip.install(ocard1, new Tooltip("Opponent Card"));
		});

		ocard2.setOnMouseMoved(e -> {
			if (ocard2.isVisible())
				Tooltip.install(ocard2, new Tooltip("Opponent Card"));
		});
		ocard3.setOnMouseMoved(e -> {
			if (ocard3.isVisible())
				Tooltip.install(ocard3, new Tooltip("Opponent Card"));
		});
		ocard4.setOnMouseMoved(e -> {
			if (ocard4.isVisible())
				Tooltip.install(ocard4, new Tooltip("Opponent Card"));
		});
		ocard5.setOnMouseMoved(e -> {
			if (ocard5.isVisible())
				Tooltip.install(ocard5, new Tooltip("Opponent Card"));
		});
		ocard6.setOnMouseMoved(e -> {
			if (ocard6.isVisible())
				Tooltip.install(ocard6, new Tooltip("Opponent Card"));
		});
		ocard7.setOnMouseMoved(e -> {
			if (ocard7.isVisible())
				Tooltip.install(ocard7, new Tooltip("Opponent Card"));
		});
		ocard8.setOnMouseMoved(e -> {
			if (ocard8.isVisible())
				Tooltip.install(ocard8, new Tooltip("Opponent Card"));
		});

		ocard9.setOnMouseMoved(e -> {
			if (ocard9.isVisible())
				Tooltip.install(ocard9, new Tooltip("Opponent Card"));
		});
		ocard10.setOnMouseMoved(e -> {
			if (ocard10.isVisible())
				Tooltip.install(ocard10, new Tooltip("Opponent Card"));
		});

		hideopp(ocard1, ocard2, ocard3, ocard4, ocard5, ocard6, ocard7, ocard8,
				ocard9, ocard10, opphero);
		refreshcards(curhero, ccard1, ccard2, ccard3, ccard4, ccard5, ccard6,
				ccard7, ccard8, ccard9, ccard10);

		// to start field

		VBox addfield = new VBox(10);
		HBox oppfield = new HBox(5);
		HBox curfield = new HBox(5);
		addfield.setPadding(new Insets(0, 0, 0, 140));

		addfield.getChildren().add(oppfield);
		addfield.getChildren().add(curfield);
		field.setCenter(addfield);

		ImageView oppfield1 = new ImageView("file:king.png");
		ImageView oppfield2 = new ImageView("file:king.png");
		ImageView oppfield3 = new ImageView("file:king.png");
		ImageView oppfield4 = new ImageView("file:king.png");
		ImageView oppfield5 = new ImageView("file:king.png");
		ImageView oppfield6 = new ImageView("file:king.png");
		ImageView oppfield7 = new ImageView("file:king.png");

		ImageView curfield1 = new ImageView("file:king.png");
		ImageView curfield2 = new ImageView("file:king.png");
		ImageView curfield3 = new ImageView("file:king.png");
		ImageView curfield4 = new ImageView("file:king.png");
		ImageView curfield5 = new ImageView("file:king.png");
		ImageView curfield6 = new ImageView("file:king.png");
		ImageView curfield7 = new ImageView("file:king.png");

		updateCurField(curfield1, curfield2, curfield3, curfield4, curfield5,
				curfield6, curfield7, game.getCurrentHero());
		updateCurField(oppfield1, oppfield2, oppfield3, oppfield4, oppfield5,
				oppfield6, oppfield7, game.getOpponent());

		oppfield1.setOnMouseClicked(e -> {sound2("Click.wav");
			if (curfield1.getEffect() == null && curfield2.getEffect() == null
					&& curfield3.getEffect() == null
					&& curfield4.getEffect() == null
					&& curfield5.getEffect() == null
					&& curfield6.getEffect() == null
					&& curfield7.getEffect() == null)
				if (oppfield1.isVisible())
					AlertTurn.display();
		});

		oppfield2.setOnMouseClicked(e -> {sound2("Click.wav");
			if (curfield1.getEffect() == null && curfield2.getEffect() == null
					&& curfield3.getEffect() == null
					&& curfield4.getEffect() == null
					&& curfield5.getEffect() == null
					&& curfield6.getEffect() == null
					&& curfield7.getEffect() == null)
				if (oppfield2.isVisible())
					AlertTurn.display();
		});

		oppfield3.setOnMouseClicked(e -> {sound2("Click.wav");
			if (curfield1.getEffect() == null && curfield2.getEffect() == null
					&& curfield3.getEffect() == null
					&& curfield4.getEffect() == null
					&& curfield5.getEffect() == null
					&& curfield6.getEffect() == null
					&& curfield7.getEffect() == null)
				if (oppfield3.isVisible())
					AlertTurn.display();
		});

		oppfield4.setOnMouseClicked(e -> {sound2("Click.wav");
			if (curfield1.getEffect() == null && curfield2.getEffect() == null
					&& curfield3.getEffect() == null
					&& curfield4.getEffect() == null
					&& curfield5.getEffect() == null
					&& curfield6.getEffect() == null
					&& curfield7.getEffect() == null)
				if (oppfield4.isVisible())
					AlertTurn.display();
		});

		oppfield5.setOnMouseClicked(e -> {sound2("Click.wav");
			if (curfield1.getEffect() == null && curfield2.getEffect() == null
					&& curfield3.getEffect() == null
					&& curfield4.getEffect() == null
					&& curfield5.getEffect() == null
					&& curfield6.getEffect() == null
					&& curfield7.getEffect() == null)
				if (oppfield5.isVisible())
					AlertTurn.display();
		});

		oppfield6.setOnMouseClicked(e -> {sound2("Click.wav");
			if (curfield1.getEffect() == null && curfield2.getEffect() == null
					&& curfield3.getEffect() == null
					&& curfield4.getEffect() == null
					&& curfield5.getEffect() == null
					&& curfield6.getEffect() == null
					&& curfield7.getEffect() == null)
				if (oppfield6.isVisible())
					AlertTurn.display();
		});

		oppfield7.setOnMouseClicked(e -> {sound2("Click.wav");
			if (curfield1.getEffect() == null && curfield2.getEffect() == null
					&& curfield3.getEffect() == null
					&& curfield4.getEffect() == null
					&& curfield5.getEffect() == null
					&& curfield6.getEffect() == null
					&& curfield7.getEffect() == null)
				if (oppfield7.isVisible())
					AlertTurn.display();
		});

		Glow selected = new Glow(0.9);

		endturn.setOnMouseClicked(e -> {
			try {

				curhero.endTurn();
				sound2("Click.wav");
			} catch (FullHandException e1) {

				AlertFullHand.display(e1.getBurned());
				e1.printStackTrace();
			} catch (Exception e2) {

				e2.printStackTrace();
			} finally {
				hideopp(ocard1, ocard2, ocard3, ocard4, ocard5, ocard6, ocard7,
						ocard8, ocard9, ocard10, game.getOpponent());
				refreshcards(game.getCurrentHero(), ccard1, ccard2, ccard3,
						ccard4, ccard5, ccard6, ccard7, ccard8, ccard9, ccard10);
				infoCurHand(ccard1, ccard2, ccard3, ccard4, ccard5, ccard6,
						ccard7, ccard8, ccard9, ccard10, game.getCurrentHero());

				swipPic(player1heropic, player2heropic, game.getCurrentHero(),
						game.getOpponent());
				updateCurField(curfield1, curfield2, curfield3, curfield4,
						curfield5, curfield6, curfield7, game.getCurrentHero());
				updateCurField(oppfield1, oppfield2, oppfield3, oppfield4,
						oppfield5, oppfield6, oppfield7, game.getOpponent());

			}

		});

		// ImageView Amina = curfield1;
		// Amina= (new ImageView ("file:king.png"));
		oppfield.getChildren().addAll(oppfield1, oppfield2, oppfield3,
				oppfield4, oppfield5, oppfield6, oppfield7);
		curfield.getChildren().addAll(curfield1, curfield2, curfield3,
				curfield4, curfield5, curfield6, curfield7);

		ccard1.setOnMouseClicked(e -> {
			if (game.getCurrentHero().getHand().get(0) instanceof Minion
					&& game.getCurrentHero().getHand().get(0) != null) {
				Minion m = (Minion) game.getCurrentHero().getHand().get(0);
				try {

					game.getCurrentHero().playMinion(m); sound2("Card.wav");
					updateCurField(curfield1, curfield2, curfield3, curfield4,
							curfield5, curfield6, curfield7,
							game.getCurrentHero());

				} catch (FullFieldException e2) {
					AlertField.display();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				}

				catch (NotYourTurnException e2) {
					e2.printStackTrace();
				}

			} else {
				ccard1.setEffect(selected);
				Card c = game.getCurrentHero().getHand().get(0);
				boolean youcan = true;

				if (c instanceof DivineSpirit
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SealOfChampions
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SiphonSoul
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof Polymorph
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof ShadowWordDeath
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (youcan) {
					if (c instanceof AOESpell) {
						AOESpell s = (AOESpell) c;
						s = (AOESpell) s;
						try {
							game.getCurrentHero().castSpell(s,
									game.getOpponent().getField()); sound2("Evil.wav");
						} catch (NotEnoughManaException e1) {
							AlertMana.display();
							e1.printStackTrace();
						} catch (NotYourTurnException e2) {
							AlertTurn.display();
						} finally {
							ccard1.setEffect(null);
						}
					} else {
						if (c instanceof FieldSpell) {
							FieldSpell s = (FieldSpell) c;
							try {
								game.getCurrentHero().castSpell(s); sound2("Spell.wav");
							} catch (NotEnoughManaException e1) {
								AlertMana.display();
								e1.printStackTrace();
							} catch (NotYourTurnException e2) {
								AlertTurn.display();
							} finally {
								ccard1.setEffect(null);
							}

						} else {
							if (c instanceof LeechingSpell) {
								sound2("Click.wav");
								ccard1.setEffect(null);
								leechingspells.display(game.getCurrentHero(),
										game.getOpponent(), c);

							} else {
								
								if (c instanceof KillCommand
										|| c instanceof Pyroblast) {
									ccard1.setEffect(null);sound2("Click.wav");
									herospells.display(game.getCurrentHero(),
											game.getOpponent(), c);
								} else {
									if (c instanceof MinionTargetSpell) {
										sound2("Click.wav");
										if (c instanceof DivineSpirit
												|| c instanceof SealOfChampions) {
											MinionTargetSpell s = (MinionTargetSpell) c;
											ccard1.setEffect(null);
											Spells.display(
													game.getCurrentHero(), s);

										}

										else {

											ccard1.setEffect(null);
											minionspells.display(
													game.getCurrentHero(),
													game.getOpponent(), c);

										}

									}
								}
							}

						}

					}

				} else {
					ccard1.setEffect(null);
				}
			}
		});
		ccard2.setOnMouseClicked(e -> {
			if (game.getCurrentHero().getHand().get(1) instanceof Minion
					&& game.getCurrentHero().getHand().get(1) != null) {

				Minion m = (Minion) game.getCurrentHero().getHand().get(1);
				try {

					game.getCurrentHero().playMinion(m); sound2("Card.wav");
					updateCurField(curfield1, curfield2, curfield3, curfield4,
							curfield5, curfield6, curfield7,
							game.getCurrentHero());

				} catch (FullFieldException e2) {
					AlertField.display();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				}

				catch (NotYourTurnException e2) {
					e2.printStackTrace();

				}

			} else {
				ccard2.setEffect(selected);
				Card c = game.getCurrentHero().getHand().get(1);
				boolean youcan = true;

				if (c instanceof DivineSpirit
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SealOfChampions
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SiphonSoul
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof Polymorph
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof ShadowWordDeath
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (youcan) {
					if (c instanceof AOESpell) {
						AOESpell s = (AOESpell) c;
						s = (AOESpell) s;
						try {
							game.getCurrentHero().castSpell(s,
									game.getOpponent().getField()); sound2("Evil.wav");
						} catch (NotEnoughManaException e1) {
							AlertMana.display();
							e1.printStackTrace();
						} catch (NotYourTurnException e2) {
							AlertTurn.display();
						} finally {
							ccard2.setEffect(null);
						}
					} else {
						if (c instanceof FieldSpell) {
							FieldSpell s = (FieldSpell) c;
							try {
								game.getCurrentHero().castSpell(s); sound2("Spell.wav");
							} catch (NotEnoughManaException e1) {
								AlertMana.display();
								e1.printStackTrace();
							} catch (NotYourTurnException e2) {
								AlertTurn.display();
							} finally {
								ccard2.setEffect(null);
							}

						} else {
							if (c instanceof LeechingSpell) {
								ccard2.setEffect(null);
								leechingspells.display(game.getCurrentHero(),
										game.getOpponent(), c);sound2("Click.wav");
							} else {
								if (c instanceof KillCommand
										|| c instanceof Pyroblast) {

									ccard2.setEffect(null);sound2("Click.wav");
									herospells.display(game.getCurrentHero(),
											game.getOpponent(), c);

								} else {
									if (c instanceof MinionTargetSpell) {
										sound2("Click.wav");
										if (c instanceof DivineSpirit
												|| c instanceof SealOfChampions) {

											MinionTargetSpell s = (MinionTargetSpell) c;
											ccard2.setEffect(null);
											Spells.display(
													game.getCurrentHero(), s);

										}

										else {
											ccard2.setEffect(null);
											minionspells.display(
													game.getCurrentHero(),
													game.getOpponent(), c);
										}

									}
								}
							}

						}

					}

				} else {
					ccard2.setEffect(null);
				}
			}
		});
		ccard3.setOnMouseClicked(e -> {
			if (game.getCurrentHero().getHand().get(2) instanceof Minion
					&& game.getCurrentHero().getHand().get(2) != null) {

				Minion m = (Minion) game.getCurrentHero().getHand().get(2);
				try {

					game.getCurrentHero().playMinion(m); sound2("Card.wav");
					updateCurField(curfield1, curfield2, curfield3, curfield4,
							curfield5, curfield6, curfield7,
							game.getCurrentHero());

				} catch (FullFieldException e2) {
					AlertField.display();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				}

				catch (NotYourTurnException e2) {
					e2.printStackTrace();
				}
			} else {
				ccard3.setEffect(selected);
				Card c = game.getCurrentHero().getHand().get(2);
				boolean youcan = true;

				if (c instanceof DivineSpirit
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SealOfChampions
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SiphonSoul
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof Polymorph
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof ShadowWordDeath
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (youcan) {
					if (c instanceof AOESpell) {
						AOESpell s = (AOESpell) c;
						s = (AOESpell) s;
						try {
							game.getCurrentHero().castSpell(s,
									game.getOpponent().getField());sound2("Evil.wav");
						} catch (NotEnoughManaException e1) {
							AlertMana.display();
							e1.printStackTrace();
						} catch (NotYourTurnException e2) {
							AlertTurn.display();
						} finally {
							ccard3.setEffect(null);
						}
					} else {
						if (c instanceof FieldSpell) {
							FieldSpell s = (FieldSpell) c;
							try {
								game.getCurrentHero().castSpell(s); sound2("Spell.wav");
							} catch (NotEnoughManaException e1) {
								AlertMana.display();
								e1.printStackTrace();
							} catch (NotYourTurnException e2) {
								AlertTurn.display();
							} finally {
								ccard3.setEffect(null);
							}

						} else {
							if (c instanceof LeechingSpell) {
								ccard3.setEffect(null);sound2("Click.wav");
								leechingspells.display(game.getCurrentHero(),
										game.getOpponent(), c);
							} else {
								if (c instanceof KillCommand
										|| c instanceof Pyroblast) {
									ccard3.setEffect(null);sound2("Click.wav");
									herospells.display(game.getCurrentHero(),
											game.getOpponent(), c);
								} else {
									if (c instanceof MinionTargetSpell) {
										sound2("Click.wav");
										if (c instanceof DivineSpirit
												|| c instanceof SealOfChampions) {

											MinionTargetSpell s = (MinionTargetSpell) c;
											ccard3.setEffect(null);
											Spells.display(
													game.getCurrentHero(), s);
										}

										else {
											ccard3.setEffect(null);
											minionspells.display(
													game.getCurrentHero(),
													game.getOpponent(), c);
										}

									}
								}
							}

						}

					}

				} else {
					ccard3.setEffect(null);
				}
			}
		});
		ccard4.setOnMouseClicked(e -> {
			if (game.getCurrentHero().getHand().get(3) instanceof Minion
					&& game.getCurrentHero().getHand().get(3) != null) {

				Minion m = (Minion) game.getCurrentHero().getHand().get(3);
				try {

					game.getCurrentHero().playMinion(m); sound2("Card.wav");
					updateCurField(curfield1, curfield2, curfield3, curfield4,
							curfield5, curfield6, curfield7,
							game.getCurrentHero());

				} catch (FullFieldException e2) {
					AlertField.display();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				}

				catch (NotYourTurnException e2) {
					e2.printStackTrace();
				}
			} else {
				ccard4.setEffect(selected);
				Card c = game.getCurrentHero().getHand().get(3);
				boolean youcan = true;

				if (c instanceof DivineSpirit
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SealOfChampions
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SiphonSoul
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof Polymorph
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof ShadowWordDeath
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (youcan) {
					if (c instanceof AOESpell) {
						AOESpell s = (AOESpell) c;
						s = (AOESpell) s;
						try {
							game.getCurrentHero().castSpell(s,
									game.getOpponent().getField());sound2("Evil.wav");
						} catch (NotEnoughManaException e1) {
							AlertMana.display();
							e1.printStackTrace();
						} catch (NotYourTurnException e2) {
							AlertTurn.display();
						} finally {
							ccard4.setEffect(null);
						}
					} else {
						if (c instanceof FieldSpell) {
							FieldSpell s = (FieldSpell) c;
							try {
								game.getCurrentHero().castSpell(s); sound2("Spell.wav");
							} catch (NotEnoughManaException e1) {
								AlertMana.display();
								e1.printStackTrace();
							} catch (NotYourTurnException e2) {
								AlertTurn.display();
							} finally {
								ccard4.setEffect(null);
							}

						} else {
							if (c instanceof LeechingSpell) {
								ccard4.setEffect(null);sound2("Click.wav");
								leechingspells.display(game.getCurrentHero(),
										game.getOpponent(), c);
							} else {
								if (c instanceof KillCommand
										|| c instanceof Pyroblast) {
									ccard4.setEffect(null);sound2("Click.wav");
									herospells.display(game.getCurrentHero(),
											game.getOpponent(), c);
								} else {
									if (c instanceof MinionTargetSpell) {
										sound2("Click.wav");
										if (c instanceof DivineSpirit
												|| c instanceof SealOfChampions) {
											MinionTargetSpell s = (MinionTargetSpell) c;
											ccard4.setEffect(null);
											Spells.display(
													game.getCurrentHero(), s);
										}

										else {
											ccard4.setEffect(null);
											minionspells.display(
													game.getCurrentHero(),
													game.getOpponent(), c);
										}

									}
								}
							}

						}

					}

				} else {
					ccard4.setEffect(null);
				}
			}

		});
		ccard5.setOnMouseClicked(e -> {
			if (game.getCurrentHero().getHand().get(4) instanceof Minion
					&& game.getCurrentHero().getHand().get(4) != null) {

				Minion m = (Minion) game.getCurrentHero().getHand().get(4);
				try {

					game.getCurrentHero().playMinion(m); sound2("Card.wav");
					updateCurField(curfield1, curfield2, curfield3, curfield4,
							curfield5, curfield6, curfield7,
							game.getCurrentHero());

				} catch (FullFieldException e2) {
					AlertField.display();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				}

				catch (NotYourTurnException e2) {
					e2.printStackTrace();
				}
			} else {
				ccard5.setEffect(selected);
				Card c = game.getCurrentHero().getHand().get(4);
				boolean youcan = true;

				if (c instanceof DivineSpirit
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SealOfChampions
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SiphonSoul
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof Polymorph
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof ShadowWordDeath
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (youcan) {
					if (c instanceof AOESpell) {
						AOESpell s = (AOESpell) c;
						s = (AOESpell) s;
						try {
							game.getCurrentHero().castSpell(s,
									game.getOpponent().getField());sound2("Evil.wav");
						} catch (NotEnoughManaException e1) {
							AlertMana.display();
							e1.printStackTrace();
						} catch (NotYourTurnException e2) {
							AlertTurn.display();
						} finally {
							ccard5.setEffect(null);
						}
					} else {
						if (c instanceof FieldSpell) {
							FieldSpell s = (FieldSpell) c;
							try {
								game.getCurrentHero().castSpell(s); sound2("Spell.wav");
							} catch (NotEnoughManaException e1) {
								AlertMana.display();
								e1.printStackTrace();
							} catch (NotYourTurnException e2) {
								AlertTurn.display();
							} finally {
								ccard5.setEffect(null);
							}

						} else {
							if (c instanceof LeechingSpell) {
								ccard5.setEffect(null);sound2("Click.wav");
								leechingspells.display(game.getCurrentHero(),
										game.getOpponent(), c);
							} else {
								if (c instanceof KillCommand
										|| c instanceof Pyroblast) {
									ccard5.setEffect(null);sound2("Click.wav");
									herospells.display(game.getCurrentHero(),
											game.getOpponent(), c);
								} else {
									if (c instanceof MinionTargetSpell) {
										sound2("Click.wav");
										if (c instanceof DivineSpirit
												|| c instanceof SealOfChampions) {
											MinionTargetSpell s = (MinionTargetSpell) c;
											ccard5.setEffect(null);
											Spells.display(
													game.getCurrentHero(), s);
										}

										else {
											ccard5.setEffect(null);
											minionspells.display(
													game.getCurrentHero(),
													game.getOpponent(), c);
										}

									}
								}
							}

						}

					}

				} else {
					ccard5.setEffect(null);
				}
			}

		});
		ccard6.setOnMouseClicked(e -> {
			if (game.getCurrentHero().getHand().get(5) instanceof Minion
					&& game.getCurrentHero().getHand().get(5) != null) {

				Minion m = (Minion) game.getCurrentHero().getHand().get(5);
				try {

					game.getCurrentHero().playMinion(m); sound2("Card.wav");
					updateCurField(curfield1, curfield2, curfield3, curfield4,
							curfield5, curfield6, curfield7,
							game.getCurrentHero());

				} catch (FullFieldException e2) {
					AlertField.display();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				}

				catch (NotYourTurnException e2) {
					e2.printStackTrace();
				}
			} else {
				ccard6.setEffect(selected);
				Card c = game.getCurrentHero().getHand().get(5);
				boolean youcan = true;

				if (c instanceof DivineSpirit
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SealOfChampions
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SiphonSoul
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof Polymorph
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof ShadowWordDeath
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (youcan) {
					if (c instanceof AOESpell) {
						AOESpell s = (AOESpell) c;
						s = (AOESpell) s;
						try {
							game.getCurrentHero().castSpell(s,
									game.getOpponent().getField());sound2("Evil.wav");
						} catch (NotEnoughManaException e1) {
							AlertMana.display();
							e1.printStackTrace();
						} catch (NotYourTurnException e2) {
							AlertTurn.display();
						} finally {
							ccard6.setEffect(null);
						}
					} else {
						if (c instanceof FieldSpell) {
							FieldSpell s = (FieldSpell) c;
							try {
								game.getCurrentHero().castSpell(s); sound2("Spell.wav");
							} catch (NotEnoughManaException e1) {
								AlertMana.display();
								e1.printStackTrace();
							} catch (NotYourTurnException e2) {
								AlertTurn.display();
							} finally {
								ccard6.setEffect(null);
							}

						} else {
							if (c instanceof LeechingSpell) {
								ccard6.setEffect(null);sound2("Click.wav");
								leechingspells.display(game.getCurrentHero(),
										game.getOpponent(), c);
							} else {
								if (c instanceof KillCommand
										|| c instanceof Pyroblast) {
									ccard6.setEffect(null);sound2("Click.wav");
									herospells.display(game.getCurrentHero(),
											game.getOpponent(), c);
								} else {
									if (c instanceof MinionTargetSpell) {
										sound2("Click.wav");
										if (c instanceof DivineSpirit
												|| c instanceof SealOfChampions) {
											MinionTargetSpell s = (MinionTargetSpell) c;
											ccard6.setEffect(null);
											Spells.display(
													game.getCurrentHero(), s);
										}

										else {
											ccard6.setEffect(null);
											minionspells.display(
													game.getCurrentHero(),
													game.getOpponent(), c);
										}

									}
								}
							}

						}

					}

				} else {
					ccard6.setEffect(null);
				}
			}

		});
		ccard7.setOnMouseClicked(e -> {
			if (game.getCurrentHero().getHand().get(6) instanceof Minion
					&& game.getCurrentHero().getHand().get(6) != null) {

				Minion m = (Minion) game.getCurrentHero().getHand().get(6);
				try {

					game.getCurrentHero().playMinion(m); sound2("Card.wav");
					updateCurField(curfield1, curfield2, curfield3, curfield4,
							curfield5, curfield6, curfield7,
							game.getCurrentHero());

				} catch (FullFieldException e2) {
					AlertField.display();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				}

				catch (NotYourTurnException e2) {
					e2.printStackTrace();
				}
			} else {
				ccard7.setEffect(selected);
				Card c = game.getCurrentHero().getHand().get(6);
				boolean youcan = true;

				if (c instanceof DivineSpirit
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SealOfChampions
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SiphonSoul
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof Polymorph
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof ShadowWordDeath
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (youcan) {
					if (c instanceof AOESpell) {
						AOESpell s = (AOESpell) c;
						s = (AOESpell) s;
						try {
							game.getCurrentHero().castSpell(s,
									game.getOpponent().getField());sound2("Evil.wav");
						} catch (NotEnoughManaException e1) {
							AlertMana.display();
							e1.printStackTrace();
						} catch (NotYourTurnException e2) {
							AlertTurn.display();
						} finally {
							ccard7.setEffect(null);
						}
					} else {
						if (c instanceof FieldSpell) {
							FieldSpell s = (FieldSpell) c;
							try {
								game.getCurrentHero().castSpell(s); sound2("Spell.wav");
							} catch (NotEnoughManaException e1) {
								AlertMana.display();
								e1.printStackTrace();
							} catch (NotYourTurnException e2) {
								AlertTurn.display();
							} finally {
								ccard7.setEffect(null);
							}

						} else {
							if (c instanceof LeechingSpell) {
								ccard7.setEffect(null);sound2("Click.wav");
								leechingspells.display(game.getCurrentHero(),
										game.getOpponent(), c);
							} else {
								if (c instanceof KillCommand
										|| c instanceof Pyroblast) {
									ccard7.setEffect(null);sound2("Click.wav");
									herospells.display(game.getCurrentHero(),
											game.getOpponent(), c);
								} else {
									if (c instanceof MinionTargetSpell) {
										sound2("Click.wav");
										if (c instanceof DivineSpirit
												|| c instanceof SealOfChampions) {
											MinionTargetSpell s = (MinionTargetSpell) c;
											ccard7.setEffect(null);
											Spells.display(
													game.getCurrentHero(), s);

										}

										else {
											ccard7.setEffect(null);
											minionspells.display(
													game.getCurrentHero(),
													game.getOpponent(), c);
										}

									}
								}
							}

						}

					}

				} else {
					ccard7.setEffect(null);
				}
			}

		});
		ccard8.setOnMouseClicked(e -> {
			if (game.getCurrentHero().getHand().get(7) instanceof Minion
					&& game.getCurrentHero().getHand().get(7) != null) {

				Minion m = (Minion) game.getCurrentHero().getHand().get(7);
				try {

					game.getCurrentHero().playMinion(m); sound2("Card.wav");
					updateCurField(curfield1, curfield2, curfield3, curfield4,
							curfield5, curfield6, curfield7,
							game.getCurrentHero());

				} catch (FullFieldException e2) {
					AlertField.display();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				}

				catch (NotYourTurnException e2) {
					e2.printStackTrace();
				}
			} else {
				ccard8.setEffect(selected);
				Card c = game.getCurrentHero().getHand().get(7);
				boolean youcan = true;

				if (c instanceof DivineSpirit
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SealOfChampions
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SiphonSoul
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof Polymorph
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof ShadowWordDeath
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (youcan) {
					if (c instanceof AOESpell) {
						AOESpell s = (AOESpell) c;
						s = (AOESpell) s;
						try {
							game.getCurrentHero().castSpell(s,
									game.getOpponent().getField());sound2("Evil.wav");
						} catch (NotEnoughManaException e1) {
							AlertMana.display();
							e1.printStackTrace();
						} catch (NotYourTurnException e2) {
							AlertTurn.display();
						} finally {
							ccard8.setEffect(null);
						}
					} else {
						if (c instanceof FieldSpell) {
							FieldSpell s = (FieldSpell) c;
							try {
								game.getCurrentHero().castSpell(s); sound2("Spell.wav");
							} catch (NotEnoughManaException e1) {
								AlertMana.display();
								e1.printStackTrace();
							} catch (NotYourTurnException e2) {
								AlertTurn.display();
							} finally {
								ccard8.setEffect(null);
							}

						} else {
							if (c instanceof LeechingSpell) {
								ccard8.setEffect(null);sound2("Click.wav");
								leechingspells.display(game.getCurrentHero(),
										game.getOpponent(), c);
							} else {
								if (c instanceof KillCommand
										|| c instanceof Pyroblast) {
									ccard8.setEffect(null);sound2("Click.wav");
									herospells.display(game.getCurrentHero(),
											game.getOpponent(), c);
								} else {
									if (c instanceof MinionTargetSpell) {
										sound2("Click.wav");
										if (c instanceof DivineSpirit
												|| c instanceof SealOfChampions) {
											MinionTargetSpell s = (MinionTargetSpell) c;
											ccard8.setEffect(null);
											Spells.display(
													game.getCurrentHero(), s);

										}

										else {
											ccard8.setEffect(null);
											minionspells.display(
													game.getCurrentHero(),
													game.getOpponent(), c);
										}

									}
								}
							}

						}

					}

				} else {
					ccard8.setEffect(null);
				}
			}

		});
		ccard9.setOnMouseClicked(e -> {
			if (game.getCurrentHero().getHand().get(8) instanceof Minion
					&& game.getCurrentHero().getHand().get(8) != null) {

				Minion m = (Minion) game.getCurrentHero().getHand().get(8);
				try {

					game.getCurrentHero().playMinion(m); sound2("Card.wav");
					updateCurField(curfield1, curfield2, curfield3, curfield4,
							curfield5, curfield6, curfield7,
							game.getCurrentHero());

				} catch (FullFieldException e2) {
					AlertField.display();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				}

				catch (NotYourTurnException e2) {
					e2.printStackTrace();
				}
			} else {
				ccard9.setEffect(selected);
				Card c = game.getCurrentHero().getHand().get(8);
				boolean youcan = true;

				if (c instanceof DivineSpirit
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SealOfChampions
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SiphonSoul
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof Polymorph
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof ShadowWordDeath
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (youcan) {
					if (c instanceof AOESpell) {
						AOESpell s = (AOESpell) c;
						s = (AOESpell) s;
						try {
							game.getCurrentHero().castSpell(s,
									game.getOpponent().getField());sound2("Evil.wav");
						} catch (NotEnoughManaException e1) {
							AlertMana.display();
							e1.printStackTrace();
						} catch (NotYourTurnException e2) {
							AlertTurn.display();
						} finally {
							ccard9.setEffect(null);
						}
					} else {
						if (c instanceof FieldSpell) {
							FieldSpell s = (FieldSpell) c;
							try {
								game.getCurrentHero().castSpell(s); sound2("Spell.wav");
							} catch (NotEnoughManaException e1) {
								AlertMana.display();
								e1.printStackTrace();
							} catch (NotYourTurnException e2) {
								AlertTurn.display();
							} finally {
								ccard9.setEffect(null);
							}

						} else {
							if (c instanceof LeechingSpell) {
								ccard9.setEffect(null);sound2("Click.wav");
								leechingspells.display(game.getCurrentHero(),
										game.getOpponent(), c);
							} else {
								if (c instanceof KillCommand
										|| c instanceof Pyroblast) {
									ccard9.setEffect(null);sound2("Click.wav");
									herospells.display(game.getCurrentHero(),
											game.getOpponent(), c);
								} else {
									if (c instanceof MinionTargetSpell) {
										sound2("Click.wav");
										if (c instanceof DivineSpirit
												|| c instanceof SealOfChampions) {
											MinionTargetSpell s = (MinionTargetSpell) c;
											ccard9.setEffect(null);
											Spells.display(
													game.getCurrentHero(), s);
										}

										else {
											ccard9.setEffect(null);
											minionspells.display(
													game.getCurrentHero(),
													game.getOpponent(), c);
										}
									}
								}
							}

						}

					}

				} else {
					ccard9.setEffect(null);
				}
			}

		});
		ccard10.setOnMouseClicked(e -> {
			if (game.getCurrentHero().getHand().get(9) instanceof Minion
					&& game.getCurrentHero().getHand().get(9) != null) {

				Minion m = (Minion) game.getCurrentHero().getHand().get(9);
				try {

					game.getCurrentHero().playMinion(m); sound2("Card.wav");
					updateCurField(curfield1, curfield2, curfield3, curfield4,
							curfield5, curfield6, curfield7,
							game.getCurrentHero());

				} catch (FullFieldException e2) {
					AlertField.display();
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				}

				catch (NotYourTurnException e2) {
					e2.printStackTrace();
				}
			} else {
				ccard10.setEffect(selected);
				Card c = game.getCurrentHero().getHand().get(9);
				boolean youcan = true;

				if (c instanceof DivineSpirit
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SealOfChampions
						&& game.getCurrentHero().getField().size() == 0)
					youcan = false;
				if (c instanceof SiphonSoul
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof Polymorph
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (c instanceof ShadowWordDeath
						&& game.getOpponent().getField().size() == 0)
					youcan = false;
				if (youcan) {
					if (c instanceof AOESpell) {
						AOESpell s = (AOESpell) c;
						s = (AOESpell) s;
						try {
							game.getCurrentHero().castSpell(s,
									game.getOpponent().getField());sound2("Evil.wav");
						} catch (NotEnoughManaException e1) {
							AlertMana.display();
							e1.printStackTrace();
						} catch (NotYourTurnException e2) {
							AlertTurn.display();
						} finally {
							ccard10.setEffect(null);
						}
					} else {
						if (c instanceof FieldSpell) {
							FieldSpell s = (FieldSpell) c;
							try {
								game.getCurrentHero().castSpell(s); sound2("Spell.wav");
							} catch (NotEnoughManaException e1) {
								AlertMana.display();
								e1.printStackTrace();
							} catch (NotYourTurnException e2) {
								AlertTurn.display();
							} finally {
								ccard10.setEffect(null);
							}

						} else {
							if (c instanceof LeechingSpell) {
								ccard10.setEffect(null);sound2("Click.wav");
								leechingspells.display(game.getCurrentHero(),
										game.getOpponent(), c);
							} else {
								if (c instanceof KillCommand
										|| c instanceof Pyroblast) {
									ccard10.setEffect(null);sound2("Click.wav");
									herospells.display(game.getCurrentHero(),
											game.getOpponent(), c);
								} else {
									if (c instanceof MinionTargetSpell) {
										sound2("Click.wav");
										if (c instanceof DivineSpirit
												|| c instanceof SealOfChampions) {
											MinionTargetSpell s = (MinionTargetSpell) c;
											ccard10.setEffect(null);
											Spells.display(
													game.getCurrentHero(), s);
										}

										else {
											ccard10.setEffect(null);
											minionspells.display(
													game.getCurrentHero(),
													game.getOpponent(), c);
										}

									}
								}
							}

						}

					}

				} else {
					ccard10.setEffect(null);
				}
			}

		});
		// HERO power
		StackPane heropoweruse = new StackPane();
		ImageView heropower = new ImageView("file:heropower.png");
		heropoweruse.getChildren().add(heropower);
		// opp , hero , his hero , opp hand , team , his hand

		curfield1.setOnMouseClicked(e -> {sound2("Click.wav");
			curfield1.setEffect(selected);
			curfield2.setEffect(null);
			curfield3.setEffect(null);
			curfield4.setEffect(null);
			curfield7.setEffect(null);
			curfield5.setEffect(null);
			curfield6.setEffect(null);
			heropower.setEffect(null);

		});
		curfield2.setOnMouseClicked(e -> {sound2("Click.wav");
			curfield2.setEffect(selected);
			curfield1.setEffect(null);
			curfield3.setEffect(null);
			curfield4.setEffect(null);
			curfield7.setEffect(null);
			curfield5.setEffect(null);
			curfield6.setEffect(null);
			heropower.setEffect(null);
		});
		curfield3.setOnMouseClicked(e -> {sound2("Click.wav");
			curfield3.setEffect(selected);
			curfield2.setEffect(null);
			curfield1.setEffect(null);
			curfield4.setEffect(null);
			curfield7.setEffect(null);
			curfield5.setEffect(null);
			curfield6.setEffect(null);
			heropower.setEffect(null);
		});
		curfield4.setOnMouseClicked(e -> {sound2("Click.wav");
			curfield4.setEffect(selected);
			curfield2.setEffect(null);
			curfield3.setEffect(null);
			curfield1.setEffect(null);
			curfield7.setEffect(null);
			curfield5.setEffect(null);
			curfield6.setEffect(null);
			heropower.setEffect(null);
		});
		curfield5.setOnMouseClicked(e -> {sound2("Click.wav");
			curfield5.setEffect(selected);
			curfield2.setEffect(null);
			curfield3.setEffect(null);
			curfield4.setEffect(null);
			curfield7.setEffect(null);
			curfield1.setEffect(null);
			curfield6.setEffect(null);
			heropower.setEffect(null);
		});
		curfield6.setOnMouseClicked(e -> {sound2("Click.wav");
			curfield6.setEffect(selected);
			curfield2.setEffect(null);
			curfield3.setEffect(null);
			curfield4.setEffect(null);
			curfield7.setEffect(null);
			curfield5.setEffect(null);
			curfield1.setEffect(null);
			heropower.setEffect(null);
		});
		curfield7.setOnMouseClicked(e -> {sound2("Click.wav");
			curfield7.setEffect(selected);
			curfield2.setEffect(null);
			curfield3.setEffect(null);
			curfield4.setEffect(null);
			curfield1.setEffect(null);
			curfield5.setEffect(null);
			curfield6.setEffect(null);
			heropower.setEffect(null);
		});

		field.setLeft(heropoweruse);
		// heropower.
		heropower
				.setOnMouseMoved(e -> {
					String x = "";
					if (game.getCurrentHero() instanceof Mage) {
						x = "Your Hero Power Costs 2 ManaCrystals,"
								+ "\n"
								+ "Inflicts one damage point to a specific target (a hero or a minion).";
					}
					if (game.getCurrentHero() instanceof Hunter) {
						x = "Your Hero Power Costs 2 ManaCrystals,"
								+ "\n"
								+ "Inflicts two damage points to the opponent Hero.";
					}
					if (game.getCurrentHero() instanceof Paladin) {
						x = "Your Hero Power Costs 2 ManaCrystals,"
								+ "\n"
								+ "Creates a new minion and adds it to the field.";
					}
					if (game.getCurrentHero() instanceof Priest) {
						x = "Your Hero Power Costs 2 ManaCrystals,"
								+ "\n"
								+ "Restores two health points to a specific target (a hero or a minion).";
					}
					if (game.getCurrentHero() instanceof Warlock) {
						x = "Your Hero Power Costs 2 ManaCrystals,"
								+ "\n"
								+ "Draws an extra card and inflicts two damage points to the hero.";
					}

					Tooltip.install(heropower, new Tooltip(x));
				});
		// ImageView x = curfield1;
		// curfield1.setOnMousePressed(value);;
		heropower.setOnMouseClicked(e -> {
			heropower.setEffect(selected);
			curfield1.setEffect(null);
			curfield2.setEffect(null);
			curfield3.setEffect(null);
			curfield4.setEffect(null);
			curfield5.setEffect(null);
			curfield6.setEffect(null);
			curfield7.setEffect(null);

			if (game.getCurrentHero() instanceof Priest) {
				heropower.setEffect(null);
				sound2("Click.wav");
					Priestpower.display(game.getCurrentHero());
					
			
			
				
			}

			if (game.getCurrentHero() instanceof Mage) {sound2("Click.wav");
				 heropower.setEffect(null);
			magepower.display(game.getCurrentHero(), game.getOpponent());
			
			
			}

			if (game.getCurrentHero() instanceof Hunter) {
				try {
					Hunter use = (Hunter) game.getCurrentHero();
					use.useHeroPower();
					sound2("Sword.wav");
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e2) {
					AlertPowerused.display();
				} catch (Exception e2) {

				} finally {
					heropower.setEffect(null);
				}

			}
			if (game.getCurrentHero() instanceof Paladin) {

				try {
					Paladin use = (Paladin) game.getCurrentHero();
					use.useHeroPower();
					
					sound2("SilverHand.wav");
					
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e2) {
					AlertPowerused.display();
				} catch (FullHandException e2) {
					AlertFullHand.display(e2.getBurned());
				} catch (FullFieldException e4) {
					AlertField.display();
				} catch (Exception e5) {

				} finally {
					heropower.setEffect(null);
				}

			}

			if (game.getCurrentHero() instanceof Warlock) {
				try {
					Warlock use = (Warlock) game.getCurrentHero();
					use.useHeroPower();
					sound2("Card.wav");
				} catch (NotEnoughManaException e1) {
					AlertMana.display();
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e2) {
					AlertPowerused.display();
				} catch (FullHandException e2) {
					AlertFullHand.display(e2.getBurned());
				} catch (Exception e4) {

				} finally {
					heropower.setEffect(null);
				}

			}

		});

		System.out.println(curhero.getHand().get(0).getName());
		System.out.println(curhero.getHand().get(1).getName());
		System.out.println(curhero.getHand().get(2).getName());

		Scene fieldscene = new Scene(field, 1275, 680);
		fieldscene.setOnMouseMoved(e -> {
			playerDetails(p1name, p2name, h1, h2, player1heropic,
					player2heropic);
			refreshcards(game.getCurrentHero(), ccard1, ccard2, ccard3, ccard4,
					ccard5, ccard6, ccard7, ccard8, ccard9, ccard10);
			updateCurField(curfield1, curfield2, curfield3, curfield4,
					curfield5, curfield6, curfield7, game.getCurrentHero());
			updateCurField(oppfield1, oppfield2, oppfield3, oppfield4,
					oppfield5, oppfield6, oppfield7, game.getOpponent());
			infoField(curfield1, curfield2, curfield3, curfield4, curfield5,
					curfield6, curfield7, game.getCurrentHero());
			infoField(oppfield1, oppfield2, oppfield3, oppfield4, oppfield5,
					oppfield6, oppfield7, game.getOpponent());

			if (game.getOpponent().getCurrentHP() <= 0) {
				if (game.getCurrentHero() == player1) {

					winner(window, game.getCurrentHero(), p1name);
				} else {
					winner(window, game.getCurrentHero(), p2name);
				}
			}
			
			if (game.getCurrentHero().getCurrentHP() <= 0) {
				if (game.getOpponent() == player1) {

					winner(window, game.getOpponent(), p1name);
				} else {
					winner(window,game.getOpponent(), p2name);
				}
			}
			
			

		});
		fieldscene.setOnMouseClicked(e -> {

			try {
				attack(selected, curfield1, curfield2, curfield3, curfield4,
						curfield5, curfield6, curfield7, oppfield1, oppfield2,
						oppfield3, oppfield4, oppfield5, oppfield6, oppfield7,
						player1heropic, player2heropic, ocard1, ocard2, ocard3,
						ocard4, ocard5, ocard6, ocard7, ocard8, ocard9,
						ocard10, game.getCurrentHero(), game.getOpponent());
			} catch (Exception e1) {
				System.out.println("hello");

			}
			infoField(curfield1, curfield2, curfield3, curfield4, curfield5,
					curfield6, curfield7, game.getCurrentHero());
			infoField(oppfield1, oppfield2, oppfield3, oppfield4, oppfield5,
					oppfield6, oppfield7, game.getOpponent());

		});
		window.setScene(fieldscene);
	}

	public void winner(Stage window, Hero win, String name) {

		window.setTitle("GAMEOVER");

		BackgroundImage bg = null;
		if (win instanceof Mage) {
			bg = new BackgroundImage(new Image("file:magewin.JPG"),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
					BackgroundPosition.CENTER, new BackgroundSize(1275, 680,
							false, false, false, true));
		}
		if (win instanceof Hunter) {
			bg = new BackgroundImage(new Image("file:hunterwin.JPG"),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
					BackgroundPosition.CENTER, new BackgroundSize(1275, 680,
							false, false, false, true));
		}
		if (win instanceof Paladin) {
			bg = new BackgroundImage(new Image("file:paladinwin.JPG"),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
					BackgroundPosition.CENTER, new BackgroundSize(1275, 680,
							false, false, false, true));
		}
		if (win instanceof Priest) {
			bg = new BackgroundImage(new Image("file:priestwin.JPG"),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
					BackgroundPosition.CENTER, new BackgroundSize(1275, 680,
							false, false, false, true));
		}
		if (win instanceof Warlock) {
			bg = new BackgroundImage(new Image("file:warlockwin.JPG"),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
					BackgroundPosition.CENTER, new BackgroundSize(1275, 680,
							false, false, false, true));
		}

		BorderPane y = new BorderPane();

		String z = "" + name.toUpperCase() + "  " + "YOU WIN (๑>◡<๑)";
		Label winnername = new Label(z);
		winnername.setTextFill(Color.WHITE);
		winnername
				.setFont(Font.font("Lucida handwriting", FontWeight.BOLD, 50));
		StackPane tt = new StackPane(winnername);
		y.setTop(tt);

		y.setBackground(new Background(bg));
		Button restart = new Button("Play Again");

		restart.setTextFill(Color.BLACK);
		restart.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		VBox res = new VBox(5);
		res.setPadding(new Insets(500, 150, 0, 0));

		Button gameover = new Button("END GAME");
		StackPane center = new StackPane(gameover);
		gameover.setTextFill(Color.BLACK);
		gameover.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		center.setPadding(new Insets(0, 150, 0, 0));

		StackPane x = new StackPane();
		x.setPadding(new Insets(0, 0, 0, 150));// new Insets(topRightBottomLeft)
		x.getChildren().add(restart);
		StackPane yy = new StackPane();
		yy.setPadding(new Insets(0, 0, 0, 150));
		yy.getChildren().add(gameover);

		res.getChildren().add(x);
		res.getChildren().add(yy);
		y.setBottom(res);

		gameover.setOnMouseClicked(e -> {sound2("Click.wav");
			window.close();

		});
		restart.setOnMouseClicked(e -> {sound2("Click.wav");
			scene1(window);
		});

		Scene scene = new Scene(y, 967, 680);

		window.setResizable(false);
		window.setScene(scene);
		window.initModality(Modality.APPLICATION_MODAL);
		window.showAndWait();

	}

	public void attack(Effect selected, ImageView curfield1,
			ImageView curfield2, ImageView curfield3, ImageView curfield4,
			ImageView curfield5, ImageView curfield6, ImageView curfield7,
			ImageView oppfield1, ImageView oppfield2, ImageView oppfield3,
			ImageView oppfield4, ImageView oppfield5, ImageView oppfield6,
			ImageView oppfield7, ImageView player1heropic,
			ImageView player2heropic, ImageView ocard1, ImageView ocard2,
			ImageView ocard3, ImageView ocard4, ImageView ocard5,
			ImageView ocard6, ImageView ocard7, ImageView ocard8,
			ImageView ocard9, ImageView ocard10, Hero curhero, Hero opphero)
			throws TauntBypassException, CannotAttackException,
			InvalidTargetException, NotSummonedException {
		if (curfield1 != null || curfield2 != null || curfield3 != null
				|| curfield4 != null || curfield5 != null || curfield6 != null
				|| curfield7 != null) {
			if (curfield1.getEffect() != null) {
				player2heropic.setOnMouseClicked(e -> {
					player2heropic.setEffect(selected); sound2("Attack.wav");

					try {
						if (curfield1.getEffect() != null)
							curhero.attackWithMinion(curhero.getField().get(0),
									opphero);
					} catch (CannotAttackException e1) {
						if (curhero.getField().get(0).getAttack() == 0)
							AlertzeroAttack.display();
						else {
							if (curhero.getField().get(0).isSleeping())
								AlertSleeping.display();
							else {
								AlertAttacked.display();
							}
						}
						e1.printStackTrace();
					} catch (InvalidTargetException e2) {
						Alerticehowl.display();
						e2.printStackTrace();
					} catch (TauntBypassException e3) {
						AlertTaunt.display();
						e3.printStackTrace();
					} catch (NotSummonedException e4) {
						AlertSummon.display();
						e4.printStackTrace();
					} catch (NotYourTurnException e2) {
						e2.printStackTrace();
					} finally {
						curfield1.setEffect(null);
						player2heropic.setEffect(null);

					}
				});

				player1heropic.setOnMouseClicked(e -> {
					player1heropic.setEffect(selected); sound2("Attack.wav");

					try {
						if (curfield1.getEffect() != null)
							curhero.attackWithMinion(curhero.getField().get(0),
									curhero);
					} catch (CannotAttackException e1) {
						if (curhero.getField().get(0).getAttack() == 0)
							AlertzeroAttack.display();
						else {
							if (curhero.getField().get(0).isSleeping())
								AlertSleeping.display();
							else {
								AlertAttacked.display();
							}
						}
						e1.printStackTrace();
					} catch (InvalidTargetException e2) {
						AlertYourHero.display();
						e2.printStackTrace();
					} catch (TauntBypassException e3) {
						AlertTaunt.display();
						e3.printStackTrace();
					} catch (NotSummonedException e4) {
						AlertSummon.display();
						e4.printStackTrace();
					} catch (NotYourTurnException e2) {
						e2.printStackTrace();
					} finally {
						curfield1.setEffect(null);
						player1heropic.setEffect(null);
					}
				});
			}

			if (curfield2.getEffect() != null) {
				player2heropic.setOnMouseClicked(e -> {
					player2heropic.setEffect(selected); sound2("Attack.wav");

					try {
						if (curfield2.getEffect() != null)
							curhero.attackWithMinion(curhero.getField().get(1),
									opphero);
					} catch (CannotAttackException e1) {
						if (curhero.getField().get(1).getAttack() == 0)
							AlertzeroAttack.display();
						else {
							if (curhero.getField().get(1).isSleeping())
								AlertSleeping.display();
							else {
								AlertAttacked.display();
							}
						}
						e1.printStackTrace();
					} catch (InvalidTargetException e2) {
						Alerticehowl.display();
						e2.printStackTrace();
					} catch (TauntBypassException e3) {
						AlertTaunt.display();
						e3.printStackTrace();
					} catch (NotSummonedException e4) {
						AlertSummon.display();
						e4.printStackTrace();
					} catch (NotYourTurnException e2) {
						e2.printStackTrace();
					} finally {
						curfield2.setEffect(null);
						player2heropic.setEffect(null);

					}
				});

				player1heropic.setOnMouseClicked(e -> {
					player1heropic.setEffect(selected); sound2("Attack.wav");

					try {
						if (curfield2.getEffect() != null)
							curhero.attackWithMinion(curhero.getField().get(1),
									curhero);
					} catch (CannotAttackException e1) {
						if (curhero.getField().get(1).getAttack() == 0)
							AlertzeroAttack.display();
						else {
							if (curhero.getField().get(1).isSleeping())
								AlertSleeping.display();
							else {
								AlertAttacked.display();
							}
						}
						e1.printStackTrace();
					} catch (InvalidTargetException e2) {
						AlertYourHero.display();
						e2.printStackTrace();
					} catch (TauntBypassException e3) {
						AlertTaunt.display();
						e3.printStackTrace();
					} catch (NotSummonedException e4) {
						AlertSummon.display();
						e4.printStackTrace();
					} catch (NotYourTurnException e2) {
						e2.printStackTrace();
					} finally {
						curfield2.setEffect(null);
						player1heropic.setEffect(null);
					}
				});
			}

			if (curfield3.getEffect() != null) {
				player2heropic.setOnMouseClicked(e -> {
					player2heropic.setEffect(selected); sound2("Attack.wav");

					try {
						if (curfield3.getEffect() != null)
							curhero.attackWithMinion(curhero.getField().get(2),
									opphero);
					} catch (CannotAttackException e1) {
						if (curhero.getField().get(2).getAttack() == 0)
							AlertzeroAttack.display();
						else {
							if (curhero.getField().get(2).isSleeping())
								AlertSleeping.display();
							else {
								AlertAttacked.display();
							}
						}
						e1.printStackTrace();
					} catch (InvalidTargetException e2) {
						Alerticehowl.display();
						e2.printStackTrace();
					} catch (TauntBypassException e3) {
						AlertTaunt.display();
						e3.printStackTrace();
					} catch (NotSummonedException e4) {
						AlertSummon.display();
						e4.printStackTrace();
					} catch (NotYourTurnException e2) {
						e2.printStackTrace();
					} finally {
						curfield3.setEffect(null);
						player2heropic.setEffect(null);

					}
				});

				player1heropic.setOnMouseClicked(e -> {
					player1heropic.setEffect(selected); sound2("Attack.wav");

					try {
						if (curfield3.getEffect() != null)
							curhero.attackWithMinion(curhero.getField().get(2),
									curhero);
					} catch (CannotAttackException e1) {
						if (curhero.getField().get(2).getAttack() == 0)
							AlertzeroAttack.display();
						else {
							if (curhero.getField().get(2).isSleeping())
								AlertSleeping.display();
							else {
								AlertAttacked.display();
							}
						}
						e1.printStackTrace();
					} catch (InvalidTargetException e2) {
						AlertYourHero.display();
						e2.printStackTrace();
					} catch (TauntBypassException e3) {
						AlertTaunt.display();
						e3.printStackTrace();
					} catch (NotSummonedException e4) {
						AlertSummon.display();
						e4.printStackTrace();
					} catch (NotYourTurnException e2) {
						e2.printStackTrace();
					} finally {
						curfield3.setEffect(null);
						player1heropic.setEffect(null);
					}
				});
			}

			if (curfield4.getEffect() != null) {
				player2heropic.setOnMouseClicked(e -> {
					player2heropic.setEffect(selected); sound2("Attack.wav");

					try {
						if (curfield4.getEffect() != null)
							curhero.attackWithMinion(curhero.getField().get(3),
									opphero);
					} catch (CannotAttackException e1) {
						if (curhero.getField().get(3).getAttack() == 0)
							AlertzeroAttack.display();
						else {
							if (curhero.getField().get(3).isSleeping())
								AlertSleeping.display();
							else {
								AlertAttacked.display();
							}
						}
						e1.printStackTrace();
					} catch (InvalidTargetException e2) {
						Alerticehowl.display();
						e2.printStackTrace();
					} catch (TauntBypassException e3) {
						AlertTaunt.display();
						e3.printStackTrace();
					} catch (NotSummonedException e4) {
						AlertSummon.display();
						e4.printStackTrace();
					} catch (NotYourTurnException e2) {
						e2.printStackTrace();
					} finally {
						curfield4.setEffect(null);
						player2heropic.setEffect(null);

					}
				});

				player1heropic.setOnMouseClicked(e -> {
					player1heropic.setEffect(selected); sound2("Attack.wav");

					try {
						if (curfield4.getEffect() != null)
							curhero.attackWithMinion(curhero.getField().get(3),
									curhero);
					} catch (CannotAttackException e1) {
						if (curhero.getField().get(3).getAttack() == 0)
							AlertzeroAttack.display();
						else {
							if (curhero.getField().get(3).isSleeping())
								AlertSleeping.display();
							else {
								AlertAttacked.display();
							}
						}
						e1.printStackTrace();
					} catch (InvalidTargetException e2) {
						AlertYourHero.display();
						e2.printStackTrace();
					} catch (TauntBypassException e3) {
						AlertTaunt.display();
						e3.printStackTrace();
					} catch (NotSummonedException e4) {
						AlertSummon.display();
						e4.printStackTrace();
					} catch (NotYourTurnException e2) {
						e2.printStackTrace();
					} finally {
						curfield4.setEffect(null);
						player1heropic.setEffect(null);
					}
				});
			}

			if (curfield5.getEffect() != null) {
				player2heropic.setOnMouseClicked(e -> {
					player2heropic.setEffect(selected); sound2("Attack.wav");

					try {
						if (curfield5.getEffect() != null)
							curhero.attackWithMinion(curhero.getField().get(4),
									opphero);
					} catch (CannotAttackException e1) {
						if (curhero.getField().get(4).getAttack() == 0)
							AlertzeroAttack.display();
						else {
							if (curhero.getField().get(4).isSleeping())
								AlertSleeping.display();
							else {
								AlertAttacked.display();
							}
						}
						e1.printStackTrace();
					} catch (InvalidTargetException e2) {
						Alerticehowl.display();
						e2.printStackTrace();
					} catch (TauntBypassException e3) {
						AlertTaunt.display();
						e3.printStackTrace();
					} catch (NotSummonedException e4) {
						AlertSummon.display();
						e4.printStackTrace();
					} catch (NotYourTurnException e2) {
						e2.printStackTrace();
					} finally {
						curfield5.setEffect(null);
						player2heropic.setEffect(null);

					}
				});

				player1heropic.setOnMouseClicked(e -> {
					player1heropic.setEffect(selected); sound2("Attack.wav");

					try {
						if (curfield5.getEffect() != null)
							curhero.attackWithMinion(curhero.getField().get(4),
									curhero);
					} catch (CannotAttackException e1) {
						if (curhero.getField().get(4).getAttack() == 0)
							AlertzeroAttack.display();
						else {
							if (curhero.getField().get(4).isSleeping())
								AlertSleeping.display();
							else {
								AlertAttacked.display();
							}
						}
						e1.printStackTrace();
					} catch (InvalidTargetException e2) {
						AlertYourHero.display();
						e2.printStackTrace();
					} catch (TauntBypassException e3) {
						AlertTaunt.display();
						e3.printStackTrace();
					} catch (NotSummonedException e4) {
						AlertSummon.display();
						e4.printStackTrace();
					} catch (NotYourTurnException e2) {
						e2.printStackTrace();
					} finally {
						curfield5.setEffect(null);
						player1heropic.setEffect(null);
					}
				});
			}

			if (curfield6.getEffect() != null) {
				player2heropic.setOnMouseClicked(e -> {
					player2heropic.setEffect(selected); sound2("Attack.wav");

					try {
						if (curfield6.getEffect() != null)
							curhero.attackWithMinion(curhero.getField().get(5),
									opphero);
					} catch (CannotAttackException e1) {
						if (curhero.getField().get(5).getAttack() == 0)
							AlertzeroAttack.display();
						else {
							if (curhero.getField().get(5).isSleeping())
								AlertSleeping.display();
							else {
								AlertAttacked.display();
							}
						}
						e1.printStackTrace();
					} catch (InvalidTargetException e2) {
						Alerticehowl.display();
						e2.printStackTrace();
					} catch (TauntBypassException e3) {
						AlertTaunt.display();
						e3.printStackTrace();
					} catch (NotSummonedException e4) {
						AlertSummon.display();
						e4.printStackTrace();
					} catch (NotYourTurnException e2) {
						e2.printStackTrace();
					} finally {
						curfield6.setEffect(null);
						player2heropic.setEffect(null);

					}
				});

				player1heropic.setOnMouseClicked(e -> {
					player1heropic.setEffect(selected); sound2("Attack.wav");

					try {
						if (curfield6.getEffect() != null)
							curhero.attackWithMinion(curhero.getField().get(5),
									curhero);
					} catch (CannotAttackException e1) {
						if (curhero.getField().get(5).getAttack() == 0)
							AlertzeroAttack.display();
						else {
							if (curhero.getField().get(5).isSleeping())
								AlertSleeping.display();
							else {
								AlertAttacked.display();
							}
						}
						e1.printStackTrace();
					} catch (InvalidTargetException e2) {
						AlertYourHero.display();
						e2.printStackTrace();
					} catch (TauntBypassException e3) {
						AlertTaunt.display();
						e3.printStackTrace();
					} catch (NotSummonedException e4) {
						AlertSummon.display();
						e4.printStackTrace();
					} catch (NotYourTurnException e2) {
						e2.printStackTrace();
					} finally {
						curfield6.setEffect(null);
						player1heropic.setEffect(null);
					}
				});
			}

			if (curfield7.getEffect() != null) {
				player2heropic.setOnMouseClicked(e -> {
					player2heropic.setEffect(selected); sound2("Attack.wav");

					try {
						if (curfield7.getEffect() != null)
							curhero.attackWithMinion(curhero.getField().get(6),
									opphero);
					} catch (CannotAttackException e1) {
						if (curhero.getField().get(6).getAttack() == 0)
							AlertzeroAttack.display();
						else {
							if (curhero.getField().get(6).isSleeping())
								AlertSleeping.display();
							else {
								AlertAttacked.display();
							}
						}
						e1.printStackTrace();
					} catch (InvalidTargetException e2) {
						Alerticehowl.display();
						e2.printStackTrace();
					} catch (TauntBypassException e3) {
						AlertTaunt.display();
						e3.printStackTrace();
					} catch (NotSummonedException e4) {
						AlertSummon.display();
						e4.printStackTrace();
					} catch (NotYourTurnException e2) {
						e2.printStackTrace();
					} finally {
						curfield7.setEffect(null);
						player2heropic.setEffect(null);

					}
				});

				player1heropic.setOnMouseClicked(e -> {
					player1heropic.setEffect(selected); sound2("Attack.wav");

					try {
						if (curfield7.getEffect() != null)
							curhero.attackWithMinion(curhero.getField().get(6),
									curhero);
					} catch (CannotAttackException e1) {
						if (curhero.getField().get(6).getAttack() == 0)
							AlertzeroAttack.display();
						else {
							if (curhero.getField().get(6).isSleeping())
								AlertSleeping.display();
							else {
								AlertAttacked.display();
							}
						}
						e1.printStackTrace();
					} catch (InvalidTargetException e2) {
						AlertYourHero.display();
						e2.printStackTrace();
					} catch (TauntBypassException e3) {
						AlertTaunt.display();
						e3.printStackTrace();
					} catch (NotSummonedException e4) {
						AlertSummon.display();
						e4.printStackTrace();
					} catch (NotYourTurnException e2) {
						e2.printStackTrace();
					} finally {
						curfield7.setEffect(null);
						player1heropic.setEffect(null);
					}
				});
			}

			if (curfield1.getEffect() != null) {

				if (oppfield1.isVisible())
					oppfield1.setOnMouseClicked(e -> {
						oppfield1.setEffect(selected);
						performAttack(false, "curfield1", "oppfield1", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield1.setEffect(null);

				if (oppfield2.isVisible())
					oppfield2.setOnMouseClicked(e -> {
						oppfield2.setEffect(selected);
						performAttack(false, "curfield1", "oppfield2", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield2.setEffect(null);

				if (oppfield3.isVisible())
					oppfield3.setOnMouseClicked(e -> {
						oppfield3.setEffect(selected);
						performAttack(false, "curfield1", "oppfield3", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield3.setEffect(null);

				if (oppfield4.isVisible())
					oppfield4.setOnMouseClicked(e -> {
						oppfield4.setEffect(selected);
						performAttack(false, "curfield1", "oppfield4", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield4.setEffect(null);

				if (oppfield5.isVisible())
					oppfield5.setOnMouseClicked(e -> {
						oppfield5.setEffect(selected);
						performAttack(false, "curfield1", "oppfield5", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield5.setEffect(null);

				if (oppfield6.isVisible())
					oppfield6.setOnMouseClicked(e -> {
						oppfield6.setEffect(selected);
						performAttack(false, "curfield1", "oppfield6", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield6.setEffect(null);

				if (oppfield7.isVisible())
					oppfield7.setOnMouseClicked(e -> {
						oppfield7.setEffect(selected);
						performAttack(false, "curfield1", "oppfield7", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield7.setEffect(null);

				if (ocard1.isVisible())
					ocard1.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard2.isVisible())
					ocard2.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard3.isVisible())
					ocard3.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard4.isVisible())
					ocard4.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard5.isVisible())
					ocard5.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard6.isVisible())
					ocard6.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard7.isVisible())
					ocard7.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard8.isVisible())
					ocard8.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard9.isVisible())
					ocard9.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard10.isVisible())
					ocard10.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

			}

			// card
			if (curfield2.getEffect() != null) {

				if (oppfield1.isVisible())
					oppfield1.setOnMouseClicked(e -> {
						oppfield1.setEffect(selected);
						performAttack(false, "curfield2", "oppfield1", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield1.setEffect(null);

				if (oppfield2.isVisible())
					oppfield2.setOnMouseClicked(e -> {
						oppfield2.setEffect(selected);
						performAttack(false, "curfield2", "oppfield2", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield2.setEffect(null);

				if (oppfield3.isVisible())
					oppfield3.setOnMouseClicked(e -> {
						oppfield3.setEffect(selected);
						performAttack(false, "curfield2", "oppfield3", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield3.setEffect(null);

				if (oppfield4.isVisible())
					oppfield4.setOnMouseClicked(e -> {
						oppfield4.setEffect(selected);
						performAttack(false, "curfield2", "oppfield4", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield4.setEffect(null);

				if (oppfield5.isVisible())
					oppfield5.setOnMouseClicked(e -> {
						oppfield5.setEffect(selected);
						performAttack(false, "curfield2", "oppfield5", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield5.setEffect(null);

				if (oppfield6.isVisible())
					oppfield6.setOnMouseClicked(e -> {
						oppfield6.setEffect(selected);
						performAttack(false, "curfield2", "oppfield6", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield6.setEffect(null);

				if (oppfield7.isVisible())
					oppfield7.setOnMouseClicked(e -> {
						oppfield7.setEffect(selected);
						performAttack(false, "curfield2", "oppfield7", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield7.setEffect(null);

				if (ocard1.isVisible())
					ocard1.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard2.isVisible())
					ocard2.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard3.isVisible())
					ocard3.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard4.isVisible())
					ocard4.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard5.isVisible())
					ocard5.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard6.isVisible())
					ocard6.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard7.isVisible())
					ocard7.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard8.isVisible())
					ocard8.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard9.isVisible())
					ocard9.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard10.isVisible())
					ocard10.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

			}

			if (curfield3.getEffect() != null) {

				if (oppfield1.isVisible())
					oppfield1.setOnMouseClicked(e -> {
						oppfield1.setEffect(selected);
						performAttack(false, "curfield3", "oppfield1", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield1.setEffect(null);

				if (oppfield2.isVisible())
					oppfield2.setOnMouseClicked(e -> {
						oppfield2.setEffect(selected);
						performAttack(false, "curfield3", "oppfield2", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield2.setEffect(null);

				if (oppfield3.isVisible())
					oppfield3.setOnMouseClicked(e -> {
						oppfield3.setEffect(selected);
						performAttack(false, "curfield3", "oppfield3", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield3.setEffect(null);

				if (oppfield4.isVisible())
					oppfield4.setOnMouseClicked(e -> {
						oppfield4.setEffect(selected);
						performAttack(false, "curfield3", "oppfield4", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield4.setEffect(null);

				if (oppfield5.isVisible())
					oppfield5.setOnMouseClicked(e -> {
						oppfield5.setEffect(selected);
						performAttack(false, "curfield3", "oppfield5", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield5.setEffect(null);

				if (oppfield6.isVisible())
					oppfield6.setOnMouseClicked(e -> {
						oppfield6.setEffect(selected);
						performAttack(false, "curfield3", "oppfield6", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield6.setEffect(null);

				if (oppfield7.isVisible())
					oppfield7.setOnMouseClicked(e -> {
						oppfield7.setEffect(selected);
						performAttack(false, "curfield3", "oppfield7", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield7.setEffect(null);

				if (ocard1.isVisible())
					ocard1.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard2.isVisible())
					ocard2.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard3.isVisible())
					ocard3.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard4.isVisible())
					ocard4.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard5.isVisible())
					ocard5.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard6.isVisible())
					ocard6.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard7.isVisible())
					ocard7.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard8.isVisible())
					ocard8.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard9.isVisible())
					ocard9.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard10.isVisible())
					ocard10.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

			}

			if (curfield4.getEffect() != null) {

				if (oppfield1.isVisible())
					oppfield1.setOnMouseClicked(e -> {
						oppfield1.setEffect(selected);
						performAttack(false, "curfield4", "oppfield1", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield1.setEffect(null);

				if (oppfield2.isVisible())
					oppfield2.setOnMouseClicked(e -> {
						oppfield2.setEffect(selected);
						performAttack(false, "curfield4", "oppfield2", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield2.setEffect(null);

				if (oppfield3.isVisible())
					oppfield3.setOnMouseClicked(e -> {
						oppfield3.setEffect(selected);
						performAttack(false, "curfield4", "oppfield3", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield3.setEffect(null);

				if (oppfield4.isVisible())
					oppfield4.setOnMouseClicked(e -> {
						oppfield4.setEffect(selected);
						performAttack(false, "curfield4", "oppfield4", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield4.setEffect(null);

				if (oppfield5.isVisible())
					oppfield5.setOnMouseClicked(e -> {
						oppfield5.setEffect(selected);
						performAttack(false, "curfield4", "oppfield5", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield5.setEffect(null);

				if (oppfield6.isVisible())
					oppfield6.setOnMouseClicked(e -> {
						oppfield6.setEffect(selected);
						performAttack(false, "curfield4", "oppfield6", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield6.setEffect(null);

				if (oppfield7.isVisible())
					oppfield7.setOnMouseClicked(e -> {
						oppfield7.setEffect(selected);
						performAttack(false, "curfield4", "oppfield7", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield7.setEffect(null);

				if (ocard1.isVisible())
					ocard1.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard2.isVisible())
					ocard2.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard3.isVisible())
					ocard3.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard4.isVisible())
					ocard4.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard5.isVisible())
					ocard5.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard6.isVisible())
					ocard6.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard7.isVisible())
					ocard7.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard8.isVisible())
					ocard8.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard9.isVisible())
					ocard9.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard10.isVisible())
					ocard10.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

			}

			if (curfield4.getEffect() != null) {

				if (oppfield1.isVisible())
					oppfield1.setOnMouseClicked(e -> {
						oppfield1.setEffect(selected);
						performAttack(false, "curfield4", "oppfield1", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield1.setEffect(null);

				if (oppfield2.isVisible())
					oppfield2.setOnMouseClicked(e -> {
						oppfield2.setEffect(selected);
						performAttack(false, "curfield4", "oppfield2", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield2.setEffect(null);

				if (oppfield3.isVisible())
					oppfield3.setOnMouseClicked(e -> {
						oppfield3.setEffect(selected);
						performAttack(false, "curfield4", "oppfield3", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield3.setEffect(null);

				if (oppfield4.isVisible())
					oppfield4.setOnMouseClicked(e -> {
						oppfield4.setEffect(selected);
						performAttack(false, "curfield4", "oppfield4", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield4.setEffect(null);

				if (oppfield5.isVisible())
					oppfield5.setOnMouseClicked(e -> {
						oppfield5.setEffect(selected);
						performAttack(false, "curfield4", "oppfield5", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield5.setEffect(null);

				if (oppfield6.isVisible())
					oppfield6.setOnMouseClicked(e -> {
						oppfield6.setEffect(selected);
						performAttack(false, "curfield4", "oppfield6", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield6.setEffect(null);

				if (oppfield7.isVisible())
					oppfield7.setOnMouseClicked(e -> {
						oppfield7.setEffect(selected);
						performAttack(false, "curfield4", "oppfield7", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield7.setEffect(null);

				if (ocard1.isVisible())
					ocard1.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard2.isVisible())
					ocard2.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard3.isVisible())
					ocard3.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard4.isVisible())
					ocard4.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard5.isVisible())
					ocard5.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard6.isVisible())
					ocard6.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard7.isVisible())
					ocard7.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard8.isVisible())
					ocard8.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard9.isVisible())
					ocard9.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard10.isVisible())
					ocard10.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

			}

			if (curfield5.getEffect() != null) {

				if (oppfield1.isVisible())
					oppfield1.setOnMouseClicked(e -> {
						oppfield1.setEffect(selected);
						performAttack(false, "curfield5", "oppfield1", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield1.setEffect(null);

				if (oppfield2.isVisible())
					oppfield2.setOnMouseClicked(e -> {
						oppfield2.setEffect(selected);
						performAttack(false, "curfield5", "oppfield2", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield2.setEffect(null);

				if (oppfield3.isVisible())
					oppfield3.setOnMouseClicked(e -> {
						oppfield3.setEffect(selected);
						performAttack(false, "curfield5", "oppfield3", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield3.setEffect(null);

				if (oppfield4.isVisible())
					oppfield4.setOnMouseClicked(e -> {
						oppfield4.setEffect(selected);
						performAttack(false, "curfield5", "oppfield4", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield4.setEffect(null);

				if (oppfield5.isVisible())
					oppfield5.setOnMouseClicked(e -> {
						oppfield5.setEffect(selected);
						performAttack(false, "curfield5", "oppfield5", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield5.setEffect(null);

				if (oppfield6.isVisible())
					oppfield6.setOnMouseClicked(e -> {
						oppfield6.setEffect(selected);
						performAttack(false, "curfield5", "oppfield6", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield6.setEffect(null);

				if (oppfield7.isVisible())
					oppfield7.setOnMouseClicked(e -> {
						oppfield7.setEffect(selected);
						performAttack(false, "curfield5", "oppfield7", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield7.setEffect(null);

				if (ocard1.isVisible())
					ocard1.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard2.isVisible())
					ocard2.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard3.isVisible())
					ocard3.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard4.isVisible())
					ocard4.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard5.isVisible())
					ocard5.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard6.isVisible())
					ocard6.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard7.isVisible())
					ocard7.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard8.isVisible())
					ocard8.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard9.isVisible())
					ocard9.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard10.isVisible())
					ocard10.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

			}

			if (curfield6.getEffect() != null) {

				if (oppfield1.isVisible())
					oppfield1.setOnMouseClicked(e -> {
						oppfield1.setEffect(selected);
						performAttack(false, "curfield6", "oppfield1", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield1.setEffect(null);

				if (oppfield2.isVisible())
					oppfield2.setOnMouseClicked(e -> {
						oppfield2.setEffect(selected);
						performAttack(false, "curfield6", "oppfield2", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield2.setEffect(null);

				if (oppfield3.isVisible())
					oppfield3.setOnMouseClicked(e -> {
						oppfield3.setEffect(selected);
						performAttack(false, "curfield6", "oppfield3", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield3.setEffect(null);

				if (oppfield4.isVisible())
					oppfield4.setOnMouseClicked(e -> {
						oppfield4.setEffect(selected);
						performAttack(false, "curfield6", "oppfield4", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield4.setEffect(null);

				if (oppfield5.isVisible())
					oppfield5.setOnMouseClicked(e -> {
						oppfield5.setEffect(selected);
						performAttack(false, "curfield6", "oppfield5", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield5.setEffect(null);

				if (oppfield6.isVisible())
					oppfield6.setOnMouseClicked(e -> {
						oppfield6.setEffect(selected);
						performAttack(false, "curfield6", "oppfield6", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield6.setEffect(null);

				if (oppfield7.isVisible())
					oppfield7.setOnMouseClicked(e -> {
						oppfield7.setEffect(selected);
						performAttack(false, "curfield6", "oppfield7", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield7.setEffect(null);

				if (ocard1.isVisible())
					ocard1.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard2.isVisible())
					ocard2.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard3.isVisible())
					ocard3.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard4.isVisible())
					ocard4.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard5.isVisible())
					ocard5.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard6.isVisible())
					ocard6.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard7.isVisible())
					ocard7.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard8.isVisible())
					ocard8.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard9.isVisible())
					ocard9.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard10.isVisible())
					ocard10.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

			}

			if (curfield7.getEffect() != null) {

				if (oppfield1.isVisible())
					oppfield1.setOnMouseClicked(e -> {
						oppfield1.setEffect(selected);
						performAttack(false, "curfield7", "oppfield1", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield1.setEffect(null);

				if (oppfield2.isVisible())
					oppfield2.setOnMouseClicked(e -> {
						oppfield2.setEffect(selected);
						performAttack(false, "curfield7", "oppfield2", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield2.setEffect(null);

				if (oppfield3.isVisible())
					oppfield3.setOnMouseClicked(e -> {
						oppfield3.setEffect(selected);
						performAttack(false, "curfield7", "oppfield3", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield3.setEffect(null);

				if (oppfield4.isVisible())
					oppfield4.setOnMouseClicked(e -> {
						oppfield4.setEffect(selected);
						performAttack(false, "curfield7", "oppfield4", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield4.setEffect(null);

				if (oppfield5.isVisible())
					oppfield5.setOnMouseClicked(e -> {
						oppfield5.setEffect(selected);
						performAttack(false, "curfield7", "oppfield5", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield5.setEffect(null);

				if (oppfield6.isVisible())
					oppfield6.setOnMouseClicked(e -> {
						oppfield6.setEffect(selected);
						performAttack(false, "curfield7", "oppfield6", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield6.setEffect(null);

				if (oppfield7.isVisible())
					oppfield7.setOnMouseClicked(e -> {
						oppfield7.setEffect(selected);
						performAttack(false, "curfield7", "oppfield7", ".",
								curhero, opphero, curfield1, curfield2,
								curfield3, curfield4, curfield5, curfield6,
								curfield7, oppfield1, oppfield2, oppfield3,
								oppfield4, oppfield5, oppfield6, oppfield7);
					});

				oppfield7.setEffect(null);

				if (ocard1.isVisible())
					ocard1.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard2.isVisible())
					ocard2.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard3.isVisible())
					ocard3.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard4.isVisible())
					ocard4.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard5.isVisible())
					ocard5.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard6.isVisible())
					ocard6.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard7.isVisible())
					ocard7.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard8.isVisible())
					ocard8.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard9.isVisible())
					ocard9.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

				if (ocard10.isVisible())
					ocard10.setOnMouseClicked(e -> {
						AlertSummon.display();
						curfield1.setEffect(null);
						curfield2.setEffect(null);
						curfield3.setEffect(null);
						curfield4.setEffect(null);
						curfield5.setEffect(null);
						curfield6.setEffect(null);
						curfield7.setEffect(null);
						oppfield1.setEffect(null);
						oppfield2.setEffect(null);
						oppfield3.setEffect(null);
						oppfield4.setEffect(null);
						oppfield5.setEffect(null);
						oppfield6.setEffect(null);
						oppfield7.setEffect(null);
					});

			}

		}

	}

	public void performAttack(Boolean friendly, String cur, String opp,
			String cur2, Hero curhero, Hero opphero, ImageView curfield1,
			ImageView curfield2, ImageView curfield3, ImageView curfield4,
			ImageView curfield5, ImageView curfield6, ImageView curfield7,
			ImageView oppfield1, ImageView oppfield2, ImageView oppfield3,
			ImageView oppfield4, ImageView oppfield5, ImageView oppfield6,
			ImageView oppfield7) {
		curfield1.setEffect(null);
		curfield4.setEffect(null);
		curfield6.setEffect(null);
		curfield2.setEffect(null);
		curfield5.setEffect(null);
		curfield7.setEffect(null);
		curfield3.setEffect(null);

		int i = 0;
		int j = 0;

		switch (cur) {
		case "curfield1":
			i = 0;
			break;
		case "curfield2":
			i = 1;
			break;
		case "curfield3":
			i = 2;
			break;
		case "curfield4":
			i = 3;
			break;
		case "curfield5":
			i = 4;
			break;
		case "curfield6":
			i = 5;
			break;
		case "curfield7":
			i = 6;
			break;
		default:
			break;
		}
		switch (opp) {
		case "oppfield1":
			j = 0;
			break;
		case "oppfield2":
			j = 1;
			break;
		case "oppfield3":
			j = 2;
			break;
		case "oppfield4":
			j = 3;
			break;
		case "oppfield5":
			j = 4;
			break;
		case "oppfield6":
			j = 5;
			break;
		case "oppfield7":
			j = 6;
			break;
		default:
			break;
		}

		try {

			curhero.attackWithMinion(curhero.getField().get(i), opphero
					.getField().get(j));
			AudioClip note = new AudioClip( new File("Attack.wav").toURI().toString());
			note.play();
		} catch (CannotAttackException e1) {
			if (curhero.getField().get(i).getAttack() == 0)
				AlertzeroAttack.display();
			else {
				if (curhero.getField().get(i).isSleeping())
					AlertSleeping.display();
				else {

					AlertAttacked.display();
				}
			}
			e1.printStackTrace();
		} catch (InvalidTargetException e2) {
			Alertfriendly.display();
			e2.printStackTrace();
		} catch (TauntBypassException e3) {
			AlertTaunt.display();
			e3.printStackTrace();
		} catch (NotSummonedException e4) {
			AlertSummon.display();
			e4.printStackTrace();
		} catch (NotYourTurnException e2) {
			e2.printStackTrace();
		} finally {
			curfield1.setEffect(null);
			curfield4.setEffect(null);
			curfield6.setEffect(null);
			curfield2.setEffect(null);
			curfield5.setEffect(null);
			curfield7.setEffect(null);
			curfield3.setEffect(null);
			oppfield1.setEffect(null);
			oppfield2.setEffect(null);
			oppfield3.setEffect(null);
			oppfield6.setEffect(null);
			oppfield5.setEffect(null);
			oppfield4.setEffect(null);
			oppfield7.setEffect(null);
		}

	}

	public void updateCurField(ImageView curfield1, ImageView curfield2,
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

	public void infoCurHand(ImageView ccard1, ImageView ccard2,
			ImageView ccard3, ImageView ccard4, ImageView ccard5,
			ImageView ccard6, ImageView ccard7, ImageView ccard8,
			ImageView ccard9, ImageView ccard10, Hero curhero) {

		ccard1.setOnMouseMoved(e -> {
			if (ccard1.isVisible()) {
				if (curhero.getHand().size() >= 1
						&& curhero.getHand().get(0) != null)
					Tooltip.install(ccard1, new Tooltip(info(curhero.getHand()
							.get(0))));

			}
		});

		ccard2.setOnMouseMoved(e -> {
			if (ccard2.isVisible()) {
				if (curhero.getHand().size() >= 2
						&& curhero.getHand().get(1) != null)
					Tooltip.install(ccard2, new Tooltip(info(curhero.getHand()
							.get(1))));
			}
		});
		ccard3.setOnMouseMoved(e -> {
			if (ccard3.isVisible()) {
				if (curhero.getHand().size() >= 3
						&& curhero.getHand().get(2) != null)
					Tooltip.install(ccard3, new Tooltip(info(curhero.getHand()
							.get(2))));
			}
		});
		ccard4.setOnMouseMoved(e -> {
			if (ccard4.isVisible())
				if (curhero.getHand().size() >= 4
						&& curhero.getHand().get(3) != null)
					Tooltip.install(ccard4, new Tooltip(info(curhero.getHand()
							.get(3))));
		});

		ccard5.setOnMouseMoved(e -> {
			if (ccard5.isVisible())
				if (curhero.getHand().size() >= 5
						&& curhero.getHand().get(4) != null)
					Tooltip.install(ccard5, new Tooltip(info(curhero.getHand()
							.get(4))));
		});

		ccard6.setOnMouseMoved(e -> {
			if (ccard6.isVisible())
				if (curhero.getHand().size() >= 6
						&& curhero.getHand().get(5) != null)
					Tooltip.install(ccard6, new Tooltip(info(curhero.getHand()
							.get(5))));
		});

		ccard7.setOnMouseMoved(e -> {
			if (ccard7.isVisible())
				if (curhero.getHand().size() >= 7
						&& curhero.getHand().get(6) != null)
					Tooltip.install(ccard7, new Tooltip(info(curhero.getHand()
							.get(6))));
		});

		ccard8.setOnMouseMoved(e -> {
			if (ccard8.isVisible())
				if (curhero.getHand().size() >= 8
						&& curhero.getHand().get(7) != null)
					Tooltip.install(ccard8, new Tooltip(info(curhero.getHand()
							.get(7))));
		});

		ccard9.setOnMouseMoved(e -> {
			if (ccard9.isVisible())
				if (curhero.getHand().size() >= 9
						&& curhero.getHand().get(8) != null)
					Tooltip.install(ccard9, new Tooltip(info(curhero.getHand()
							.get(8))));
		});

		ccard10.setOnMouseMoved(e -> {
			if (ccard10.isVisible())
				if (curhero.getHand().size() >= 10
						&& curhero.getHand().get(9) != null)
					Tooltip.install(ccard10, new Tooltip(info(curhero.getHand()
							.get(9))));
		});

	}

	public void playerDetails(String p1name, String p2name, String h1,
			String h2, ImageView player1heropic, ImageView player2heropic) {

		String playercurname = p1name;
		String playeropname = p2name;

		if (game.getCurrentHero() == player1) {

			playercurname = p1name;
			playeropname = p2name;
		} else {
			playercurname = p2name;
			playeropname = p1name;
		}

		String detailcur = "Player Name: " + "" + playercurname + "\n"
				+ "Hero Name:" + "" + game.getCurrentHero().getName() + "\n"
				+ "CurrentHP:" + "" + game.getCurrentHero().getCurrentHP()
				+ "\n" + "Total Manacrystals: " + ""
				+ game.getCurrentHero().getTotalManaCrystals() + "\n"
				+ "Current Manacrystals:  " + ""
				+ game.getCurrentHero().getCurrentManaCrystals() + "\n"
				+ "Cards left in Deck: " + ""
				+ game.getCurrentHero().getDeck().size();

		Tooltip.install(player1heropic, new Tooltip(detailcur));

		String detailopp = "Player Name: " + "" + playeropname + "\n"
				+ "Hero Name:" + "" + game.getOpponent().getName() + "\n"
				+ "CurrentHP:" + "" + game.getOpponent().getCurrentHP() + "\n"
				+ "Total Manacrystals: " + ""
				+ game.getOpponent().getTotalManaCrystals() + "\n"
				+ "Current Manacrystals: " + ""
				+ game.getOpponent().getCurrentManaCrystals() + "\n"
				+ "Cards left in Deck: " + ""
				+ game.getOpponent().getDeck().size() + "\n" + "Cards in Hand:"
				+ "" + game.getOpponent().getHand().size();
		Tooltip.install(player2heropic, new Tooltip(detailopp));

	}

	public void infoField(ImageView curfield1, ImageView curfield2,
			ImageView curfield3, ImageView curfield4, ImageView curfield5,
			ImageView curfield6, ImageView curfield7, Hero curhero) {

		curfield1.setOnMouseMoved(e -> {
			if (curfield1.isVisible()) {
				if (curhero.getField().size() >= 1
						&& curhero.getField().get(0) != null)
					Tooltip.install(curfield1, new Tooltip(infoField(curhero
							.getField().get(0))));

			}
		});

		curfield2.setOnMouseMoved(e -> {
			if (curfield2.isVisible()) {
				if (curhero.getField().size() >= 2
						&& curhero.getField().get(1) != null)
					Tooltip.install(curfield2, new Tooltip(infoField(curhero
							.getField().get(1))));
			}
		});
		curfield3.setOnMouseMoved(e -> {
			if (curfield3.isVisible()) {
				if (curhero.getField().size() >= 3
						&& curhero.getField().get(2) != null)
					Tooltip.install(curfield3, new Tooltip(infoField(curhero
							.getField().get(2))));
			}
		});
		curfield4.setOnMouseMoved(e -> {
			if (curfield4.isVisible())
				if (curhero.getField().size() >= 4
						&& curhero.getField().get(3) != null)
					Tooltip.install(curfield4, new Tooltip(infoField(curhero
							.getField().get(3))));
		});

		curfield5.setOnMouseMoved(e -> {
			if (curfield5.isVisible())
				if (curhero.getField().size() >= 5
						&& curhero.getField().get(4) != null)
					Tooltip.install(curfield5, new Tooltip(infoField(curhero
							.getField().get(4))));
		});

		curfield6.setOnMouseMoved(e -> {
			if (curfield6.isVisible())
				if (curhero.getField().size() >= 6
						&& curhero.getField().get(5) != null)
					Tooltip.install(curfield6, new Tooltip(infoField(curhero
							.getField().get(5))));
		});

		curfield7.setOnMouseMoved(e -> {
			if (curfield7.isVisible())
				if (curhero.getField().size() >= 7
						&& curhero.getField().get(6) != null)
					Tooltip.install(curfield7, new Tooltip(infoField(curhero
							.getField().get(6))));
		});
	}

	public void swipPic(ImageView player1heropic, ImageView player2heropic,
			Hero curhero, Hero opphero) {

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

		if (curhero instanceof Mage)
			player1heropic.setImage(new Image("file:Jaina.png"));
		else if (curhero instanceof Hunter)
			player1heropic.setImage(new Image("file:Rexxar.png"));
		else if (curhero instanceof Priest)
			player1heropic.setImage(new Image("file:Anduin.png"));
		else if (curhero instanceof Paladin)
			player1heropic.setImage(new Image("file:img.png"));
		else
			player1heropic.setImage(new Image("file:warlockhero.png"));

	}

	public void setheros(Hero curhero, Hero opphero) {

		curhero = game.getCurrentHero();
		opphero = game.getOpponent();

		System.out.println(curhero);

	}

	public Image Addtofield(String name) {

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
		case "Silver Hand Recruit":
			card = new Image("file:Silver.png");
			break;
		case "Sheep":
			card = new Image("file:Sheep.png");
			break;

		default:
			break;
		}

		return card;
	}

	public void hideopp(ImageView ocard1, ImageView ocard2, ImageView ocard3,
			ImageView ocard4, ImageView ocard5, ImageView ocard6,
			ImageView ocard7, ImageView ocard8, ImageView ocard9,
			ImageView ocard10, Hero opphero) {

		int handofop = opphero.getHand().size();
		switch (handofop) {
		case 0:
			ocard1.setVisible(false);
			ocard2.setVisible(false);
			ocard3.setVisible(false);
			ocard4.setVisible(false);
			ocard5.setVisible(false);
			ocard6.setVisible(false);
			ocard7.setVisible(false);
			ocard8.setVisible(false);
			ocard9.setVisible(false);
			ocard10.setVisible(false);
			break;

		case 1:
			ocard1.setVisible(true);
			ocard2.setVisible(false);
			ocard3.setVisible(false);
			ocard4.setVisible(false);
			ocard5.setVisible(false);
			ocard6.setVisible(false);
			ocard7.setVisible(false);
			ocard8.setVisible(false);
			ocard9.setVisible(false);
			ocard10.setVisible(false);
			break;
		case 2:
			ocard1.setVisible(true);
			ocard2.setVisible(true);
			ocard3.setVisible(false);
			ocard4.setVisible(false);
			ocard5.setVisible(false);
			ocard6.setVisible(false);
			ocard7.setVisible(false);
			ocard8.setVisible(false);
			ocard9.setVisible(false);
			ocard10.setVisible(false);
			break;
		case 3:
			ocard1.setVisible(true);
			ocard2.setVisible(true);
			ocard3.setVisible(true);
			ocard4.setVisible(false);
			ocard5.setVisible(false);
			ocard6.setVisible(false);
			ocard7.setVisible(false);
			ocard8.setVisible(false);
			ocard9.setVisible(false);
			ocard10.setVisible(false);
			break;

		case 4:
			ocard1.setVisible(true);
			ocard2.setVisible(true);
			ocard3.setVisible(true);
			ocard4.setVisible(true);
			ocard5.setVisible(false);
			ocard6.setVisible(false);
			ocard7.setVisible(false);
			ocard8.setVisible(false);
			ocard9.setVisible(false);
			ocard10.setVisible(false);
			break;

		case 5:
			ocard1.setVisible(true);
			ocard2.setVisible(true);
			ocard3.setVisible(true);
			ocard4.setVisible(true);
			ocard5.setVisible(true);
			ocard6.setVisible(false);
			ocard7.setVisible(false);
			ocard8.setVisible(false);
			ocard9.setVisible(false);
			ocard10.setVisible(false);
			break;

		case 6:
			ocard1.setVisible(true);
			ocard2.setVisible(true);
			ocard3.setVisible(true);
			ocard4.setVisible(true);
			ocard5.setVisible(true);
			ocard6.setVisible(true);
			ocard7.setVisible(false);
			ocard8.setVisible(false);
			ocard9.setVisible(false);
			ocard10.setVisible(false);
			break;

		case 7:
			ocard1.setVisible(true);
			ocard2.setVisible(true);
			ocard3.setVisible(true);
			ocard4.setVisible(true);
			ocard5.setVisible(true);
			ocard6.setVisible(true);
			ocard7.setVisible(true);
			ocard8.setVisible(false);
			ocard9.setVisible(false);
			ocard10.setVisible(false);
			break;
		case 8:
			ocard1.setVisible(true);
			ocard2.setVisible(true);
			ocard3.setVisible(true);
			ocard4.setVisible(true);
			ocard5.setVisible(true);
			ocard6.setVisible(true);
			ocard7.setVisible(true);
			ocard8.setVisible(true);
			ocard9.setVisible(false);
			ocard10.setVisible(false);
			break;
		case 9:
			ocard1.setVisible(true);
			ocard2.setVisible(true);
			ocard3.setVisible(true);
			ocard4.setVisible(true);
			ocard5.setVisible(true);
			ocard6.setVisible(true);
			ocard7.setVisible(true);
			ocard8.setVisible(true);
			ocard9.setVisible(true);
			ocard10.setVisible(false);
			break;
		case 10:
			ocard1.setVisible(true);
			ocard2.setVisible(true);
			ocard3.setVisible(true);
			ocard4.setVisible(true);
			ocard5.setVisible(true);
			ocard6.setVisible(true);
			ocard7.setVisible(true);
			ocard8.setVisible(true);
			ocard9.setVisible(true);
			ocard10.setVisible(true);
			break;

		default:
			break;
		}

	}

	public void refreshcards(Hero curhero, ImageView ccard1, ImageView ccard2,
			ImageView ccard3, ImageView ccard4, ImageView ccard5,
			ImageView ccard6, ImageView ccard7, ImageView ccard8,
			ImageView ccard9, ImageView ccard10) {

		int size = curhero.getHand().size();
		switch (size) {
		case 0:
			ccard1.setVisible(false);
			ccard2.setVisible(false);
			ccard3.setVisible(false);
			ccard4.setVisible(false);
			ccard5.setVisible(false);
			ccard6.setVisible(false);
			ccard7.setVisible(false);
			ccard8.setVisible(false);
			ccard9.setVisible(false);
			ccard10.setVisible(false);
			break;
		case 1:
			ccard1.setVisible(true);
			ccard2.setVisible(false);
			ccard3.setVisible(false);
			ccard4.setVisible(false);
			ccard5.setVisible(false);
			ccard6.setVisible(false);
			ccard7.setVisible(false);
			ccard8.setVisible(false);
			ccard9.setVisible(false);
			ccard10.setVisible(false);
			break;
		case 2:
			ccard1.setVisible(true);
			ccard2.setVisible(true);
			ccard3.setVisible(false);
			ccard4.setVisible(false);
			ccard5.setVisible(false);
			ccard6.setVisible(false);
			ccard7.setVisible(false);
			ccard8.setVisible(false);
			ccard9.setVisible(false);
			ccard10.setVisible(false);
			break;
		case 3:
			ccard1.setVisible(true);
			ccard2.setVisible(true);
			ccard3.setVisible(true);
			ccard4.setVisible(false);
			ccard5.setVisible(false);
			ccard6.setVisible(false);
			ccard7.setVisible(false);
			ccard8.setVisible(false);
			ccard9.setVisible(false);
			ccard10.setVisible(false);
			break;
		case 4:
			ccard1.setVisible(true);
			ccard2.setVisible(true);
			ccard3.setVisible(true);
			ccard4.setVisible(true);
			ccard5.setVisible(false);
			ccard6.setVisible(false);
			ccard7.setVisible(false);
			ccard8.setVisible(false);
			ccard9.setVisible(false);
			ccard10.setVisible(false);
			break;
		case 5:
			ccard1.setVisible(true);
			ccard2.setVisible(true);
			ccard3.setVisible(true);
			ccard4.setVisible(true);
			ccard5.setVisible(true);
			ccard6.setVisible(false);
			ccard7.setVisible(false);
			ccard8.setVisible(false);
			ccard9.setVisible(false);
			ccard10.setVisible(false);
			break;
		case 6:
			ccard1.setVisible(true);
			ccard2.setVisible(true);
			ccard3.setVisible(true);
			ccard4.setVisible(true);
			ccard5.setVisible(true);
			ccard6.setVisible(true);
			ccard7.setVisible(false);
			ccard8.setVisible(false);
			ccard9.setVisible(false);
			ccard10.setVisible(false);
			break;
		case 7:
			ccard1.setVisible(true);
			ccard2.setVisible(true);
			ccard3.setVisible(true);
			ccard4.setVisible(true);
			ccard5.setVisible(true);
			ccard6.setVisible(true);
			ccard7.setVisible(true);
			ccard8.setVisible(false);
			ccard9.setVisible(false);
			ccard10.setVisible(false);
			break;
		case 8:
			ccard1.setVisible(true);
			ccard2.setVisible(true);
			ccard3.setVisible(true);
			ccard4.setVisible(true);
			ccard5.setVisible(true);
			ccard6.setVisible(true);
			ccard7.setVisible(true);
			ccard8.setVisible(true);
			ccard9.setVisible(false);
			ccard10.setVisible(false);
			break;
		case 9:
			ccard1.setVisible(true);
			ccard2.setVisible(true);
			ccard3.setVisible(true);
			ccard4.setVisible(true);
			ccard5.setVisible(true);
			ccard6.setVisible(true);
			ccard7.setVisible(true);
			ccard8.setVisible(true);
			ccard9.setVisible(true);
			ccard10.setVisible(false);
			break;
		case 10:
			ccard1.setVisible(true);
			ccard2.setVisible(true);
			ccard3.setVisible(true);
			ccard4.setVisible(true);
			ccard5.setVisible(true);
			ccard6.setVisible(true);
			ccard7.setVisible(true);
			ccard8.setVisible(true);
			ccard9.setVisible(true);
			ccard10.setVisible(true);
			break;

		default:
			break;
		}

		for (int i = 0; i < curhero.getHand().size(); i++) {

			switch (curhero.getHand().get(i).getName()) {
			case "Goldshire Footman":
				if (i == 0) {
					ccard1.setImage(new Image("file:goldshire.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:goldshire.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:goldshire.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:goldshire.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:goldshire.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:goldshire.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:goldshire.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:goldshire.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:goldshire.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:goldshire.png"));
					ccard10.setVisible(true);
				}
				break;

			case "Stonetusk Boar":
				if (i == 0) {
					ccard1.setImage(new Image("file:stonetusk.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:stonetusk.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:stonetusk.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:stonetusk.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:stonetusk.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:stonetusk.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:stonetusk.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:stonetusk.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:stonetusk.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:stonetusk.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Bloodfen Raptor":
				if (i == 0) {
					ccard1.setImage(new Image("file:Bloodfen.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:Bloodfen.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:Bloodfen.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:Bloodfen.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:Bloodfen.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:Bloodfen.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:Bloodfen.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:Bloodfen.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:Bloodfen.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:Bloodfen.png"));
					ccard10.setVisible(true);
				}

				break;
			case "Frostwolf Grunt":
				if (i == 0) {
					ccard1.setImage(new Image("file:Frostwolf.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:Frostwolf.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:Frostwolf.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:Frostwolf.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:Frostwolf.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:Frostwolf.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:Frostwolf.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:Frostwolf.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:Frostwolf.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:Frostwolf.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Wolfrider":
				if (i == 0) {
					ccard1.setImage(new Image("file:wolfrider.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:wolfrider.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:wolfrider.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:wolfrider.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:wolfrider.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:wolfrider.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:wolfrider.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:wolfrider.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:wolfrider.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:wolfrider.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Chilwind Yeti":
				if (i == 0) {
					ccard1.setImage(new Image("file:chillwind.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:chillwind.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:chillwind.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:chillwind.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:chillwind.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:chillwind.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:chillwind.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:chillwind.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:chillwind.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:chillwind.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Boulderfist Ogre":
				if (i == 0) {
					ccard1.setImage(new Image("file:Boulderfist.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:Boulderfist.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:Boulderfist.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:Boulderfist.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:Boulderfist.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:Boulderfist.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:Boulderfist.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:Boulderfist.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:Boulderfist.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:Boulderfist.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Core Hound":
				if (i == 0) {
					ccard1.setImage(new Image("file:CoreHound.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:CoreHound.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:CoreHound.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:CoreHound.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:CoreHound.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:CoreHound.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:CoreHound.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:CoreHound.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:CoreHound.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:CoreHound.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Argent Commander":
				if (i == 0) {
					ccard1.setImage(new Image("file:Argent.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:Argent.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:Argent.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:Argent.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:Argent.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:Argent.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:Argent.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:Argent.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:Argent.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:Argent.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Sunwalker":
				if (i == 0) {
					ccard1.setImage(new Image("file:sunwalker.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:sunwalker.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:sunwalker.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:sunwalker.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:sunwalker.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:sunwalker.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:sunwalker.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:sunwalker.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:sunwalker.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:sunwalker.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Chromaggus":
				if (i == 0) {
					ccard1.setImage(new Image("file:chromaggus.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:chromaggus.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:chromaggus.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:chromaggus.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:chromaggus.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:chromaggus.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:chromaggus.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:chromaggus.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:chromaggus.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:chromaggus.png"));
					ccard10.setVisible(true);
				}
				break;
			case "The LichKing":
				if (i == 0) {
					ccard1.setImage(new Image("file:thelichking.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:thelichking.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:thelichking.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:thelichking.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:thelichking.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:thelichking.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:thelichking.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:thelichking.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:thelichking.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:thelichking.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Icehowl":
				if (i == 0) {
					ccard1.setImage(new Image("file:icehowl.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:icehowl.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:icehowl.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:icehowl.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:icehowl.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:icehowl.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:icehowl.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:icehowl.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:icehowl.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:icehowl.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Colossus of the Moon":
				if (i == 0) {
					ccard1.setImage(new Image("file:colossus.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:colossus.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:colossus.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:colossus.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:colossus.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:colossus.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:colossus.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:colossus.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:colossus.png"));
					{
						ccard9.setVisible(true);
					}
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:colossus.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Curse of Weakness":
				if (i == 0) {
					ccard1.setImage(new Image("file:CurseofWeakness.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:CurseofWeakness.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:CurseofWeakness.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:CurseofWeakness.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:CurseofWeakness.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:CurseofWeakness.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:CurseofWeakness.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:CurseofWeakness.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:CurseofWeakness.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:CurseofWeakness.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Divine Spirit":
				if (i == 0) {
					ccard1.setImage(new Image("file:divinespirit.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:divinespirit.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:divinespirit.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:divinespirit.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:divinespirit.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:divinespirit.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:divinespirit.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:divinespirit.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:divinespirit.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:divinespirit.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Flamestrike":
				if (i == 0) {
					ccard1.setImage(new Image("file:flamestrike.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:flamestrike.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:flamestrike.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:flamestrike.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:flamestrike.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:flamestrike.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:flamestrike.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:flamestrike.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:flamestrike.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:flamestrike.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Holy Nova":
				if (i == 0) {
					ccard1.setImage(new Image("file:holynova.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:holynova.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:holynova.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:holynova.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:holynova.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:holynova.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:holynova.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:holynova.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:holynova.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:holynova.png"));
					ccard10.setVisible(true);
				}
				break;

			case "Kill Command":
				if (i == 0) {
					ccard1.setImage(new Image("file:killcommand.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:killcommand.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:killcommand.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:killcommand.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:killcommand.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:killcommand.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:killcommand.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:killcommand.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:killcommand.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:killcommand.png"));
					ccard10.setVisible(true);
				}
				break;

			case "Level Up!":
				if (i == 0) {
					ccard1.setImage(new Image("file:LevelUp.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:LevelUp.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:LevelUp.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:LevelUp.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:LevelUp.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:LevelUp.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:LevelUp.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:LevelUp.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:LevelUp.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:LevelUp.png"));
					ccard10.setVisible(true);
				}
				break;

			case "Multi-Shot":
				if (i == 0) {
					ccard1.setImage(new Image("file:multishot.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:multishot.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:multishot.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:multishot.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:multishot.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:multishot.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:multishot.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:multishot.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:multishot.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:multishot.png"));
					ccard10.setVisible(true);
				}
				break;

			case "Polymorph":
				if (i == 0) {
					ccard1.setImage(new Image("file:polymorph.png"));
					ccard1.setVisible(true);
				}

				if (i == 1) {
					ccard2.setImage(new Image("file:polymorph.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:polymorph.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:polymorph.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:polymorph.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:polymorph.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:polymorph.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:polymorph.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:polymorph.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:polymorph.png"));
					ccard10.setVisible(true);
				}
				break;

			case "Pyroblast":
				if (i == 0) {
					ccard1.setImage(new Image("file:pyroblast.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:pyroblast.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:pyroblast.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:pyroblast.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:pyroblast.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:pyroblast.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:pyroblast.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:pyroblast.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:pyroblast.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:pyroblast.png"));
					ccard10.setVisible(true);
				}
				break;

			case "Seal of Champions":
				if (i == 0) {
					ccard1.setImage(new Image("file:seal.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:seal.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:seal.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:seal.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:seal.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:seal.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:seal.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:seal.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:seal.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:seal.png"));
					ccard10.setVisible(true);
				}
				break;

			case "Shadow Word: Death":
				if (i == 0) {
					ccard1.setImage(new Image("file:shadow.png"));
					ccard1.setVisible(true);
				}

				if (i == 1) {
					ccard2.setImage(new Image("file:shadow.png"));
					ccard2.setVisible(true);
				}

				if (i == 2) {
					ccard3.setImage(new Image("file:shadow.png"));
					ccard3.setVisible(true);
				}

				if (i == 3) {
					ccard4.setImage(new Image("file:shadow.png"));
					ccard4.setVisible(true);
				}

				if (i == 4) {
					ccard5.setImage(new Image("file:shadow.png"));
					ccard5.setVisible(true);
				}

				if (i == 5) {
					ccard6.setImage(new Image("file:shadow.png"));
					ccard6.setVisible(true);
				}

				if (i == 6) {
					ccard7.setImage(new Image("file:shadow.png"));
					ccard7.setVisible(true);
				}

				if (i == 7) {
					ccard8.setImage(new Image("file:shadow.png"));
					ccard8.setVisible(true);
				}

				if (i == 8) {
					ccard9.setImage(new Image("file:shadow.png"));
					ccard9.setVisible(true);
				}

				if (i == 9) {
					ccard10.setImage(new Image("file:shadow.png"));
					ccard10.setVisible(true);
				}

				break;
			case "Siphon Soul":
				if (i == 0) {
					ccard1.setImage(new Image("file:Siphon.png"));
					ccard1.setVisible(true);
				}

				if (i == 1) {
					ccard2.setImage(new Image("file:Siphon.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:Siphon.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:Siphon.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:Siphon.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:Siphon.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:Siphon.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:Siphon.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:Siphon.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:Siphon.png"));
					ccard10.setVisible(true);
				}
				break;

			case "Twisting Nether":
				if (i == 0) {
					ccard1.setImage(new Image("file:twisting.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:twisting.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:twisting.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:twisting.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:twisting.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:twisting.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:twisting.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:twisting.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:twisting.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:twisting.png"));
					ccard10.setVisible(true);
				}
				break;

			case "Kalycgos":
				if (i == 0) {
					ccard1.setImage(new Image("file:kalecgos.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:kalecgos.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:kalecgos.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:kalecgos.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:kalecgos.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:kalecgos.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:kalecgos.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:kalecgos.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:kalecgos.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:kalecgos.png"));
					ccard10.setVisible(true);
				}
				break;

			case "Prophet Velen":
				if (i == 0) {
					ccard1.setImage(new Image("file:prophet.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:prophet.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:prophet.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:prophet.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:prophet.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:prophet.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:prophet.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:prophet.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:prophet.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:prophet.png"));
					ccard10.setVisible(true);
				}
				break;

			case "Wilfred Fizzlebang":
				if (i == 0) {
					ccard1.setImage(new Image("file:wilfred.png"));
					ccard1.setVisible(true);
				}

				if (i == 1) {
					ccard2.setImage(new Image("file:wilfred.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:wilfred.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:wilfred.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:wilfred.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:wilfred.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:wilfred.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:wilfred.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:wilfred.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:wilfred.png"));
					ccard10.setVisible(true);
				}
				break;

			case "Tirion Fordring":
				if (i == 0) {
					ccard1.setImage(new Image("file:tirion.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:tirion.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:tirion.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:tirion.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:tirion.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:tirion.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:tirion.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:tirion.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:tirion.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:tirion.png"));
					ccard10.setVisible(true);
				}
				break;

			case "King Krush":
				if (i == 0) {
					ccard1.setImage(new Image("file:king.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:king.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:king.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:king.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:king.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:king.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:king.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:king.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:king.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:king.png"));
					ccard10.setVisible(true);
				}
				break;
			case "Silver Hand Recruit":
				if (i == 0) {
					ccard1.setImage(new Image("file:Silver.png"));
					ccard1.setVisible(true);
				}
				if (i == 1) {
					ccard2.setImage(new Image("file:Silver.png"));
					ccard2.setVisible(true);
				}
				if (i == 2) {
					ccard3.setImage(new Image("file:Silver.png"));
					ccard3.setVisible(true);
				}
				if (i == 3) {
					ccard4.setImage(new Image("file:Silver.png"));
					ccard4.setVisible(true);
				}
				if (i == 4) {
					ccard5.setImage(new Image("file:Silver.png"));
					ccard5.setVisible(true);
				}
				if (i == 5) {
					ccard6.setImage(new Image("file:Silver.png"));
					ccard6.setVisible(true);
				}
				if (i == 6) {
					ccard7.setImage(new Image("file:Silver.png"));
					ccard7.setVisible(true);
				}
				if (i == 7) {
					ccard8.setImage(new Image("file:Silver.png"));
					ccard8.setVisible(true);
				}
				if (i == 8) {
					ccard9.setImage(new Image("file:Silver.png"));
					ccard9.setVisible(true);
				}
				if (i == 9) {
					ccard10.setImage(new Image("file:Silver.png"));
					ccard10.setVisible(true);
				}
				break;

			default:
				break;

			}
		}

	}

	public String info(Card c) {

		String minfo = " ";
		if (c instanceof Minion) {

			Minion m = new Minion(c.getName(), c.getManaCost(), c.getRarity(),
					((Minion) c).getAttack(), ((Minion) c).getMaxHP(),
					((Minion) c).isTaunt(), ((Minion) c).isDivine(),
					((Minion) c).isSleeping());
			minfo = "Name: " + "" + m.getName() + "\n" + "Attack Points: " + ""
					+ m.getAttack() + "\n" + "Rarity: " + " " + m.getRarity()
					+ "\n" + "Current HP: " + "" + m.getCurrentHP() + "\n"
					+ "Max HP: " + "" + m.getMaxHP() + "\n" + "ManaCost: " + ""
					+ m.getManaCost() + "\n" + "Divine: " + "" + m.isDivine()
					+ "\n" + "Taunt: " + "" + m.isTaunt();

		} else {
			;
			Spell s = (Spell) c;

			minfo = "Name: " + "" + s.getName() + "\n" + "Rarity: " + ""
					+ s.getRarity() + "\n" + "ManaCost: " + ""
					+ s.getManaCost();
		}

		return minfo;

	}

	public String infoField(Card c) {

		String minfo = " ";

		Minion m = (Minion) c;
		minfo = "Name: " + "" + m.getName() + "\n" + "Attack Points: " + ""
				+ m.getAttack() + "\n" + "Rarity: " + " " + m.getRarity()
				+ "\n" + "Current HP: " + "" + m.getCurrentHP() + "\n"
				+ "Max HP: " + "" + m.getMaxHP() + "\n" + "ManaCost: " + ""
				+ m.getManaCost() + "\n" + "Divine: " + "" + m.isDivine()
				+ "\n" + "Taunt: " + "" + m.isTaunt() + "\n" + "Sleeping: "
				+ "" + m.isSleeping() + "\n" + "Attacked: " + ""
				+ m.isAttacked();
		return minfo;

	}

}
