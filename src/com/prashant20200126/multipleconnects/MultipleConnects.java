package com.prashant20200126.multipleconnects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * <h1>Multi Connects</h1> This is a Multi Connect Game which is an improvised
 * version of the Basic Connect 4 game. It has 2 additional functionalities:
 * <ul>
 * <li>Connect N: It takes the number of connects from the user.</li>
 * <li>Dimensions: It also takes the height and width of the board from the
 * user.</li>
 * </ul>
 * <p>
 * <b>Note:</b> Even though this class seems cluttered, it is well-defined in
 * accordance to my game, wherein the variables, functions and ClassNames which
 * I have initialized/called give clarity to my Game Logic.
 *
 * @author Prashant Wakchaure
 * 
 */

public class MultipleConnects extends Application implements MultipleConnectsInterface {
	/**
	 * MultipleConnects instance variables
	 */

	int noOfBlocks = 0;

	TextField connectField;

	TextField FirstPlayer;
	TextField SecondPlayer;

	TextField HeightBoard;
	TextField WidthBoard;

	String finalturns;

	MultipleConnectsData data;

	/**
	 * <p>
	 * <b>Start Function: </b> This is the overrided start function from the
	 * javafx.application.Application Class which is basically the inception of the
	 * Main Game (Main Stage).
	 * </p>
	 * 
	 * @param primStage This is the only parameter which is nothing but the main
	 *                  stage.
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void start(Stage primStage) {

		connectField = new TextField("4");

		FirstPlayer = new TextField("PlayerOne");
		SecondPlayer = new TextField("PlayerTwo");

		HeightBoard = new TextField("6");
		WidthBoard = new TextField("8");

		data = new MultipleConnectsData(new TilePane(), new TableView<>(), FXCollections.observableArrayList(), true,
				new StackPane(), new AudioClip(this.getClass().getResource("victory.mp3").toString()));

		/**
		 * <p>
		 * <b>Main Logo </b>
		 * </p>
		 */
		Image logoim = new Image(getClass().getResourceAsStream("logo.png"));
		primStage.getIcons().add(logoim);

		/**
		 * <p>
		 * <b>Initialized Fonts </b>
		 * </p>
		 */
		Font mainfont = Font.font("SHOWCARD GOTHIC", FontWeight.BOLD, 18);
		Font buttonfont = Font.font("SHOWCARD GOTHIC", FontWeight.BOLD, 32);

		/**
		 * <p>
		 * <b>Main Stage </b>
		 * </p>
		 */
		data.stageFinal = primStage;
		primStage.centerOnScreen();

		/**
		 * <p>
		 * <b>TableView </b>
		 * </p>
		 */
		TableColumn columnF1 = new TableColumn("Player One Name");
		TableColumn columnF2 = new TableColumn("Player Two Name");
		TableColumn columnF3 = new TableColumn("Winner Name");
		TableColumn columnF4 = new TableColumn("No. of Connects");
		TableColumn columnF5 = new TableColumn("Dimension of the Board");
		TableColumn columnF6 = new TableColumn("No. of tiles filled");
		TableColumn columnF7 = new TableColumn("Date");
		TableColumn columnF8 = new TableColumn("Time");
		getTableView(columnF1, columnF2, columnF3, columnF4, columnF5, columnF6, columnF7, columnF8);

		/**
		 * <p>
		 * <b>Game Tile Blocks </b>
		 * </p>
		 */
		TilePane rootBlocks = new TilePane();
		data.blockTiles = rootBlocks;

		/**
		 * <p>
		 * <b>Player Name Label </b>
		 * </p>
		 */
		Label plyrNameLbl = new Label();
		data.playerNameLabel = plyrNameLbl;

		/**
		 * <p>
		 * <b>Menu Bar: Creating Menu Bar for Main Game VBox </b>
		 * </p>
		 */
		MenuBar menuBar = getMenuBar(primStage, rootBlocks);
		data.mainMenuBar = menuBar;

		/**
		 * <p>
		 * <b>VBox: Adding Menu Bar and rootBlocks to the Main Game VBOX (In the Start
		 * Button Operator Function) </b>
		 * </p>
		 */
		VBox mainGameVBox = new VBox();
		data.playGameVBox = mainGameVBox;

		/**
		 * <p>
		 * <b>VBox: Players Turns VBox </b>
		 * </p>
		 */
		VBox playersTurnsVBox = new VBox();
		data.plyrsTurnsVBox = playersTurnsVBox;
		playersTurnsVBox.setPadding(new Insets(10));
		playersTurnsVBox.setSpacing(10);
		playersTurnsVBox.setAlignment(Pos.CENTER);
		playersTurnsVBox.setStyle("-fx-background-color: red;");
		playersTurnsVBox.setPrefHeight(3);
		playersTurnsVBox.setPrefWidth(400);

		/**
		 * <p>
		 * <b>HBox: Main Game HBox </b>
		 * </p>
		 */
		HBox mainGameHBox = new HBox(data.playGameVBox, playersTurnsVBox);

		/**
		 * <p>
		 * <b>ADDING VBOX TO THE GAME SCENE </b>
		 * </p>
		 */
		Scene gameScene = new Scene(mainGameHBox);

		/**
		 * <p>
		 * <b>Image: GAME LOGO </b>
		 * </p>
		 */
		Image logovim = new Image(getClass().getResourceAsStream("logo.png"));
		ImageView logovimview = new ImageView(logovim);
		logovimview.setFitHeight(150);
		logovimview.setFitWidth(200);

		/**
		 * <p>
		 * <b>HBox: Connect </b>
		 * </p>
		 */
		HBox hcon = new HBox();
		Label connectLabel = new Label("Connect:");
		connectLabel.setFont(mainfont);
		connectField.setTextFormatter(
				new TextFormatter<>(change -> (change.getControlNewText().matches("^|[3-9]$")) ? change : null));
		connectField.setPrefWidth(80);
		connectField.setTooltip(new Tooltip("The Connects should be between 3 to 9"));
		connectField.setStyle("-fx-font-size: 16px; -fx-control-inner-background: coral;");
		hcon.getChildren().addAll(connectLabel, connectField);
		hcon.setPadding(new Insets(10));
		hcon.setSpacing(10);

		/**
		 * <p>
		 * <b>HBox: First Player Name </b>
		 * </p>
		 */
		HBox hfp = new HBox();
		Label fp = new Label("First Player:");
		fp.setFont(mainfont);
		FirstPlayer.setTextFormatter(
				new TextFormatter<>(change1 -> (change1.getControlNewText().matches("([A-Za-z]*)?")) ? change1 : null));
		FirstPlayer.setPrefWidth(200);
		FirstPlayer.setTooltip(new Tooltip("Enter only Letters"));
		FirstPlayer.setStyle("-fx-font-size: 16px; -fx-control-inner-background: red;");
		hfp.getChildren().addAll(fp, FirstPlayer);
		hfp.setPadding(new Insets(10));
		hfp.setSpacing(10);

		/**
		 * <p>
		 * <b>HBox: Second Player Name </b>
		 * </p>
		 */
		HBox hsp = new HBox();
		Label sp = new Label("Second Player:");
		sp.setFont(mainfont);
		SecondPlayer.setTextFormatter(
				new TextFormatter<>(change2 -> (change2.getControlNewText().matches("([A-Za-z]*)?")) ? change2 : null));
		SecondPlayer.setPrefWidth(200);
		SecondPlayer.setTooltip(new Tooltip("Enter only Letters"));
		SecondPlayer.setStyle("-fx-font-size: 16px; -fx-control-inner-background: blue;");
		hsp.getChildren().addAll(sp, SecondPlayer);
		hsp.setPadding(new Insets(10));
		hsp.setSpacing(10);

		/**
		 * <p>
		 * <b>HBox: Height of the Board </b>
		 * </p>
		 */
		HBox hhb = new HBox();
		Label heightlabel = new Label("Height of the board: ");
		heightlabel.setFont(mainfont);
		HeightBoard.setTextFormatter(new TextFormatter<>(
				change -> (change.getControlNewText().matches("^|[1-9]$|^[1][0-2]$")) ? change : null));
		HeightBoard.setPrefWidth(80);
		HeightBoard.setTooltip(new Tooltip("The Height of the board should be between 4 to 12"));
		HeightBoard.setStyle("-fx-font-size: 16px; -fx-control-inner-background: coral;");
		hhb.getChildren().addAll(heightlabel, HeightBoard);
		hhb.setPadding(new Insets(10));
		hhb.setSpacing(10);

		/**
		 * <p>
		 * <b>HBox: Width of the Board </b>
		 * </p>
		 */
		HBox hwb = new HBox();
		Label widthlabel = new Label("Width of the board: ");
		widthlabel.setFont(mainfont);
		WidthBoard.setTextFormatter(new TextFormatter<>(
				change -> (change.getControlNewText().matches("^|[1-9]$|^[1][0-2]$")) ? change : null));
		WidthBoard.setPrefWidth(80);
		WidthBoard.setTooltip(new Tooltip("The Width of the board should be between 4 to 12"));
		WidthBoard.setStyle("-fx-font-size: 16px; -fx-control-inner-background: coral;");
		hwb.getChildren().addAll(widthlabel, WidthBoard);
		hwb.setPadding(new Insets(10));
		hwb.setSpacing(10);

		/**
		 * <p>
		 * <b>Image: Start Button </b>
		 * </p>
		 */
		Image but1img = new Image(getClass().getResourceAsStream("start.png"));
		ImageView but1view = new ImageView(but1img);

		/**
		 * <p>
		 * <b>Button: StartButton </b>
		 * </p>
		 */
		Button startButton = new Button("", but1view);
		startButton.setPadding(new Insets(10));
		startButton.setStyle("-fx-base: coral;");
		startButton.setOnAction(e -> {
			operateStartButton(primStage, buttonfont, rootBlocks, plyrNameLbl, gameScene, menuBar);
		});

		/**
		 * <p>
		 * <b>Background: Previous Results Button </b>
		 * </p>
		 */
		BackgroundFill backgroundresfill = new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY);
		Background backgroundfill = new Background(backgroundresfill);

		/**
		 * <p>
		 * <b>Image: Previous Results Button </b>
		 * </p>
		 */
		Image but2img = new Image(getClass().getResourceAsStream("logs.png"));
		ImageView but2view = new ImageView(but2img);

		/**
		 * <p>
		 * <b>Font: Previous Result Button </b>
		 * </p>
		 */
		Font previousResButtonFont = Font.font("SHOWCARD GOTHIC", FontWeight.BOLD, 12);

		/**
		 * <p>
		 * <b>Button: Previous Results Button </b>
		 * </p>
		 */
		Button previousResButton = new Button("PREVIOUS RESULTS", but2view);
		previousResButton.setFont(previousResButtonFont);
		previousResButton.setContentDisplay(ContentDisplay.TOP);
		previousResButton.setPadding(new Insets(10));
		previousResButton.setStyle("-fx-base: coral;");
		previousResButton.setOnAction(e -> {
			operatePrevResButton(primStage, mainfont, columnF1, columnF2, columnF3, columnF4, columnF5, columnF6,
					columnF7, columnF8, backgroundfill);
		});

		/**
		 * <p>
		 * <b>HBox: Main Menu Buttons (Start & Previous Results) </b>
		 * </p>
		 */
		HBox mainMenuButtons = new HBox();
		mainMenuButtons.getChildren().addAll(startButton, previousResButton);
		mainMenuButtons.setPadding(new Insets(10));
		mainMenuButtons.setSpacing(10);
		mainMenuButtons.setAlignment(Pos.CENTER);

		/**
		 * <p>
		 * <b>Label: CREATOR </b>
		 * </p>
		 */
		Label creator = new Label("Created By - Prashant Wakchaure");

		/**
		 * <p>
		 * <b>Background: Main Menu VBox Background </b>
		 * </p>
		 */
		BackgroundFill background_fill = new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(background_fill);

		/**
		 * <p>
		 * <b>VBox: Main Menu VBox </b>
		 * </p>
		 */
		VBox mainMenuVBox = new VBox(20);
		mainMenuVBox.setBackground(background);
		mainMenuVBox.getChildren().addAll(logovimview, hcon, hfp, hsp, hhb, hwb, mainMenuButtons, creator);
		mainMenuVBox.setPadding(new Insets(10));
		mainMenuVBox.setSpacing(10);
		mainMenuVBox.setAlignment(Pos.CENTER);
		data.mainMenuScene = new Scene(mainMenuVBox, 420, 700);

		/**
		 * <p>
		 * <b>Setting: GAME STARTS ON THE MAIN MENU </b>
		 * </p>
		 */
		primStage.setScene(data.mainMenuScene);
		primStage.setTitle("Multiple Connects");
		primStage.centerOnScreen();
		primStage.show();
		primStage.setResizable(false);

	}

	/**
	 * <p>
	 * <b>Previous Button Operator Function: </b> This function basically operates
	 * the Action Event of the Previous Results Button
	 * </p>
	 * 
	 * @param primStage      Main Stage.
	 * @param mainfont       Font for results.
	 * @param columnF1       Column for Player Name 1.
	 * @param columnF2       Column for Player Name 2.
	 * @param columnF3       Column for Winner Name.
	 * @param columnF4       Column for No. of connects.
	 * @param columnF5       Column for Dimension of Board.
	 * @param columnF6       Column for No. of tiles filled.
	 * @param columnF7       Column for Date.
	 * @param columnF8       Column for Time.
	 * @param backgroundfill Background for Previous Results Pane.
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void operatePrevResButton(Stage primStage, Font mainfont, TableColumn columnF1, TableColumn columnF2,
			TableColumn columnF3, TableColumn columnF4, TableColumn columnF5, TableColumn columnF6,
			TableColumn columnF7, TableColumn columnF8, Background backgroundfill) {
		File f = new File("src\\com\\prashant20200126\\multipleconnects\\finalresults.csv");
		if (f.exists()) {
			BorderPane bpr = new BorderPane();
			bpr.setBackground(backgroundfill);
			HBox hbox1 = new HBox();

			Label labelres = new Label("Previous Results: ");
			labelres.setFont(mainfont);
			labelres.setPadding(new Insets(5));
			hbox1.getChildren().addAll(labelres);
			hbox1.setPadding(new Insets(10));
			hbox1.setSpacing(10);
			bpr.setTop(hbox1);

			VBox vbox1 = new VBox();
			vbox1.setPadding(new Insets(10));
			vbox1.setSpacing(10);

			Image backimg = new Image(getClass().getResourceAsStream("back.png"));
			ImageView backimgview = new ImageView(backimg);
			Button buttonback = new Button("", backimgview);
			buttonback.setContentDisplay(ContentDisplay.TOP);
			buttonback.setStyle("-fx-base: coral;");
			buttonback.setOnAction(event -> {
				primStage.setScene(data.mainMenuScene);
				primStage.centerOnScreen();
			});
			getTable();

			vbox1.getChildren().addAll(data.tableView, buttonback);

			bpr.setCenter(vbox1);

			columnF8.getSortType();
			columnF8.setSortType(SortType.DESCENDING);
			data.tableView.getSortOrder().add(columnF8);
			data.tableView.sort();
			columnF1.setStyle("-fx-alignment: CENTER;");
			columnF2.setStyle("-fx-alignment: CENTER;");
			columnF3.setStyle("-fx-alignment: CENTER;");
			columnF4.setStyle("-fx-alignment: CENTER;");
			columnF5.setStyle("-fx-alignment: CENTER;");
			columnF6.setStyle("-fx-alignment: CENTER;");
			columnF7.setStyle("-fx-alignment: CENTER;");
			columnF8.setStyle("-fx-alignment: CENTER;");
			Scene scres = new Scene(bpr, 800, 600);
			primStage.setScene(scres);
			primStage.centerOnScreen();
		} else {
			new Alert(AlertType.INFORMATION, "There are no games played yet!", ButtonType.OK).showAndWait();
		}
	}

	/**
	 * <p>
	 * <b>Start Button Operator Function: </b> This function basically operates the
	 * Action Event of the Start Game Button
	 * </p>
	 * 
	 * @param primStage   Main Stage.
	 * @param buttonfont  Font for Player Name Label.
	 * @param rootBlocks  The scenario for the Blocks.
	 * @param plyrNameLbl Label for the Player name.
	 * @param gameScene   Scene for the Game.
	 * @param menuBar     MenuBar at the top of the Game Scene.
	 * 
	 */
	@Override
	public void operateStartButton(Stage primStage, Font buttonfont, TilePane rootBlocks, Label plyrNameLbl,
			Scene gameScene, MenuBar menuBar) {
		if (FirstPlayer.getText().trim().isEmpty()) {
			new Alert(AlertType.INFORMATION, "Enter Player 1's Name!", ButtonType.OK).showAndWait();
		} else if (SecondPlayer.getText().trim().isEmpty()) {
			new Alert(AlertType.INFORMATION, "Enter Player 2's Name!", ButtonType.OK).showAndWait();
		} else if (connectField.getText().trim().contains("0") || connectField.getText().trim().isEmpty()) {
			new Alert(AlertType.INFORMATION, "Enter an appropriate Connect Value!", ButtonType.OK).showAndWait();
		} else if (HeightBoard.getText().trim().isEmpty() || WidthBoard.getText().trim().isEmpty()
				|| Integer.parseInt(HeightBoard.getText()) < 4 || Integer.parseInt(WidthBoard.getText()) < 4) {
			new Alert(AlertType.INFORMATION, "The dimensions of the board should be above 3!", ButtonType.OK)
					.showAndWait();
		} else if ((Integer.parseInt(connectField.getText()) > Integer.parseInt(HeightBoard.getText()) / 1.5)
				&& (Integer.parseInt(connectField.getText()) > Integer.parseInt(WidthBoard.getText()) / 1.5)) {
			new Alert(AlertType.INFORMATION,
					"The Connect should not be more than the half the size of the HEIGHT of the Board", ButtonType.OK)
							.showAndWait();
		} else {
			rootBlocks.getChildren().clear();
			// GAME SCREEN
			int h = Integer.parseInt(HeightBoard.getText());
			int w = Integer.parseInt(WidthBoard.getText());

			data.blocks = new Button[h][w];
			rootBlocks.setStyle("-fx-background-color: yellow;" + "-fx-padding: 10;" + "-fx-hgap: 5;" + "-fx-vgap: 5;"
					+ "-fx-pref-columns: " + w + ";");

			for (int r = 0; r < data.blocks.length; r++) {
				for (int c = 0; c < data.blocks[r].length; c++) {
					Button b = data.blocks[r][c] = new Button();
					b.setUserData(new BlocksClass(r, c, ' '));
					b.setOnAction(event -> {
						try {
							playGameFunction(event);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					});
					b.setPrefSize(50, 50);
					b.setStyle("-fx-background-radius: 50%;");
					rootBlocks.getChildren().add(b);
				}
			}

			data.playGameVBox.getChildren().addAll(menuBar, rootBlocks);

			data.plyrsTurnsVBox.getChildren().addAll(plyrNameLbl);
			data.plyrsTurnsVBox
					.setStyle(data.isPlayerOneTurn ? "-fx-background-color: red;" : "-fx-background-color: blue;");
			plyrNameLbl.setText(
					data.isPlayerOneTurn ? FirstPlayer.getText() + "'s TURN" : SecondPlayer.getText() + "'s TURN");
			data.playerNameLabel.setFont(buttonfont);
			data.playerNameLabel.setStyle("-fx-background-color: pink;");
			primStage.setScene(gameScene);
			primStage.centerOnScreen();

		}
	}

	/**
	 * <p>
	 * <b>Menu Bar Function: </b> This function creates the Menu items and adds them
	 * to the Menu Bar which is at the top of the Game scene.
	 * </p>
	 * 
	 * @param primStage  Main Stage.
	 * @param rootBlocks The scenario for the Blocks.
	 * @return {@link MenuBar} This function returns the MenuBar.
	 * 
	 */
	@Override
	public MenuBar getMenuBar(Stage primStage, TilePane rootBlocks) {
		Menu fileMenu = new Menu("Game Settings");
		MenuItem newGame = new MenuItem("New game");
		newGame.setOnAction(event -> {
			primStage.centerOnScreen();
			rootBlocks.setStyle("-fx-background-color: yellow;" + "-fx-padding: 10;" + "-fx-hgap: 5;" + "-fx-vgap: 5;"
					+ "-fx-pref-columns: " + Integer.parseInt(HeightBoard.getText()) + ";");
			for (int r = 0; r < data.blocks.length; r++) {
				for (int c = 0; c < data.blocks[r].length; c++) {
					Button b = data.blocks[r][c];
					b.setUserData(new BlocksClass(r, c, ' '));
					b.setPrefSize(50, 50);
					b.setStyle("-fx-background-radius: 50%;");
				}
			}
			goBack();
		});

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem exitGame = new MenuItem("Exit game");

		exitGame.setOnAction(event -> exitGame());

		fileMenu.getItems().addAll(newGame, separatorMenuItem, exitGame);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu);
		return menuBar;
	}

	/**
	 * <p>
	 * <b>Table View Function: </b> This function is used to create the Table
	 * Columns for the Previous Results Summary.
	 * </p>
	 * 
	 * @param columnF1 Column for Player Name 1.
	 * @param columnF2 Column for Player Name 2.
	 * @param columnF3 Column for Winner Name.
	 * @param columnF4 Column for No. of connects.
	 * @param columnF5 Column for Dimension of Board.
	 * @param columnF6 Column for No. of tiles filled.
	 * @param columnF7 Column for Date.
	 * @param columnF8 Column for Time.
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getTableView(TableColumn columnF1, TableColumn columnF2, TableColumn columnF3, TableColumn columnF4,
			TableColumn columnF5, TableColumn columnF6, TableColumn columnF7, TableColumn columnF8) {
		columnF1.setCellValueFactory(new PropertyValueFactory<>("Player1Name"));
		columnF1.setPrefWidth(110);

		columnF2.setCellValueFactory(new PropertyValueFactory<>("Player2Name"));
		columnF2.setPrefWidth(110);

		columnF3.setCellValueFactory(new PropertyValueFactory<>("WinnerName"));
		columnF3.setPrefWidth(110);

		columnF4.setCellValueFactory(new PropertyValueFactory<>("NoOfConnects"));
		columnF4.setPrefWidth(110);

		columnF5.setCellValueFactory(new PropertyValueFactory<>("DimOfBoard"));
		columnF5.setPrefWidth(150);

		columnF6.setCellValueFactory(new PropertyValueFactory<>("NoOfTilesFilled"));
		columnF6.setPrefWidth(100);

		columnF7.setCellValueFactory(new PropertyValueFactory<>("Date"));
		columnF7.setPrefWidth(70);

		columnF8.setCellValueFactory(new PropertyValueFactory<>("Time"));
		columnF8.setPrefWidth(70);

		data.tableView.setItems(data.dataList);
		data.tableView.getColumns().addAll(columnF1, columnF2, columnF3, columnF4, columnF5, columnF6, columnF7,
				columnF8);
	}

	/**
	 * <p>
	 * <b>Final Results CSV Read Function: </b> This function reads the
	 * finalresults.csv file.
	 * </p>
	 * 
	 */
	@Override
	public void getTable() {

		BufferedReader br;

		try {
			File f = new File("src\\com\\prashant20200126\\multipleconnects\\finalresults.csv");

			int iteration = 0;

			if (f.exists()) {
				data.dataList.clear();
				br = new BufferedReader(new FileReader(f));
				String line;
				while ((line = br.readLine()) != null) {
					if (iteration == 0) {
						iteration++;
						continue;
					}
					String[] fields = line.split(",", -1);

					TableColumns tabCols = new TableColumns(fields[0], fields[1], fields[2], fields[3], fields[4],
							fields[5], fields[6], fields[7]);
					data.dataList.add(tabCols);

				}
			} else {
				new Alert(AlertType.INFORMATION, "There is no csv file, play a game!", ButtonType.OK).showAndWait();
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex2) {
			ex2.printStackTrace();
		}
	}

	/**
	 * <p>
	 * <b>Go Back Function: </b> This function is used to go back to another scene
	 * in a stage.
	 * </p>
	 * 
	 */
	@Override
	public void goBack() {
		data.dataList.clear();
		data.playGameVBox.getChildren().clear();
		data.blockTiles.setStyle("-fx-background-color: yellow;" + "-fx-padding: 10;" + "-fx-hgap: 5;" + "-fx-vgap: 5;"
				+ "-fx-pref-columns: " + Integer.parseInt(HeightBoard.getText()) + ";");

		for (int r = 0; r < data.blocks.length; r++) {
			for (int c = 0; c < data.blocks[r].length; c++) {
				Button b = data.blocks[r][c];
				b.setUserData(new BlocksClass(r, c, ' '));
				b.setPrefSize(50, 50);
				b.setStyle("-fx-background-radius: 50%;");
			}
		}

		noOfBlocks = 0;
		data.isPlayerOneTurn = true;
		data.plyrsTurnsVBox.getChildren().clear();

		data.playerNameLabel
				.setText(data.isPlayerOneTurn ? FirstPlayer.getText() + "'s TURN" : SecondPlayer.getText() + "'s TURN");
		data.stageFinal.setScene(data.mainMenuScene);
		data.stageFinal.centerOnScreen();
	}

	/**
	 * <p>
	 * <b>Exit game function: </b> This is a basic exit game function.
	 * </p>
	 * 
	 */
	@Override
	public void exitGame() {
		Platform.exit();
		System.exit(0);
	}

	/**
	 * <p>
	 * <b>String Multiply Function: </b> This function is created in order to
	 * multiply the strings, so that the N Connect Logic is fulfilled and the win
	 * condition is met.
	 * </p>
	 * 
	 * @param s The Red or Blue color letter to be multiplied to check the win
	 *          condition.
	 * @param n The N connect number from the user.
	 * @return {@link String} Returns the result of the multiplied string.
	 * 
	 */
	@Override
	public String stringMultiply(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(s);
		}
		return sb.toString();
	}

	/**
	 * <p>
	 * <b>Final Results CSV Create/Write Function: </b> This function is used to
	 * create/write the previous results CSV file dynamically.
	 * </p>
	 * 
	 * @param winner The winner String of the game.
	 * 
	 */
	@Override
	public void printResults(String winner) throws NumberFormatException, IOException {

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter out = null;
		int c = (Integer.parseInt(connectField.getText()));
		int hinput = Integer.parseInt(HeightBoard.getText());
		int winput = Integer.parseInt(WidthBoard.getText());

		// YOU MAY NEED TO CHANGE THE FILEPATH ACCORDING TO YOUR COMPUTERS/IDE FILEPATH
		File f = new File("src\\com\\prashant20200126\\multipleconnects\\finalresults.csv");

		try {
			StringBuilder sb = new StringBuilder();
			if (!f.exists()) {
				f.createNewFile();
				sb.append("Player One Name,");
				sb.append("Player Two Name,");
				sb.append("Winner,");
				sb.append("No. of Connects,");
				sb.append("Dimension of the Board,");
				sb.append("No. of tiles filled,");
				sb.append("Date,");
				sb.append("Time");
				sb.append('\n');
				System.out.println("Results file was created!");
			}

			String timeStampDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
			String timeStampTime = new SimpleDateFormat("HH.mm.ss").format(new Date());

			sb.append(FirstPlayer.getText() + ",");
			sb.append(SecondPlayer.getText() + ",");
			sb.append(winner + ",");
			sb.append(c + ",");
			sb.append(hinput + " x " + winput + ",");
			sb.append(finalturns + ",");
			sb.append(timeStampDate + ",");
			sb.append(timeStampTime);

			fw = new FileWriter(f, true);
			bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			out.println(sb.toString());
			out.close();
			fw.close();
			bw.close();

			System.out.println("Written the results in the csv successfully!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * <p>
	 * <b>Multi-Connect Game Logic Function: </b> This function is the fundamental
	 * logic of my game. It explains the crux of the game.
	 * </p>
	 * 
	 * @param e The ActionEvent which is inside the Start Button Operator function.
	 * 
	 */
	@Override
	public void playGameFunction(ActionEvent e) throws FileNotFoundException {

		// getting the player names into variables
		String fpfinal = FirstPlayer.getText();
		String spfinal = SecondPlayer.getText();

		// getting the board dimensions into variables
		int h = Integer.parseInt(HeightBoard.getText());
		int w = Integer.parseInt(WidthBoard.getText());

		// image for red's victory
		Image image = new Image(getClass().getResourceAsStream("redwon.jpg"));
		ImageView redWinsImage = new ImageView(image);

		// image for blue's victory
		Image image1 = new Image(getClass().getResourceAsStream("bluewon.jpg"));
		ImageView blueWinsImage = new ImageView(image1);

		// image for game draw
		Image drawimg = new Image(getClass().getResourceAsStream("draw.jpg"));
		ImageView drawimgview = new ImageView(drawimg);

		// getting the multiple connect integer into a variable
		int connect = (Integer.parseInt(connectField.getText()));

		// LOGIC STARTS:-

		Button clicked = (Button) e.getSource();
		BlocksClass d = (BlocksClass) clicked.getUserData();
		String lineData = "";
		int currentCol = d.col;
		int currentRow = d.row;

		for (currentRow = (h - 1); currentRow > -1; currentRow--) {
			BlocksClass rowData = (BlocksClass) data.blocks[currentRow][currentCol].getUserData();
			if (rowData.color == ' ') {
				if (noOfBlocks % 2 == 1) {
					// Blue's Turn
					rowData.color = 'b';
					data.blocks[currentRow][currentCol].setStyle("-fx-background-radius: 50%;" + "-fx-base: blue;");
					data.playerNameLabel.setText(fpfinal + "'s TURN");
					data.plyrsTurnsVBox.setStyle("-fx-background-color: red;");

				} else {
					// Red's Turn
					rowData.color = 'r';
					data.blocks[currentRow][currentCol].setStyle("-fx-background-radius: 50%;" + "-fx-base: red;");
					data.playerNameLabel.setText(spfinal + "'s TURN");
					data.plyrsTurnsVBox.setStyle("-fx-background-color: blue;");
				}
				break;
			}
		}

		// when the column is not full
		if (currentRow > -1) {
			// Putting the blocks into the board
			noOfBlocks++;
			for (int i = 0; i < w; i++) {
				// for horizontal additions
				BlocksClass btnData = (BlocksClass) data.blocks[currentRow][i].getUserData();
				lineData += btnData.color;
			}
			lineData += "#";
			for (int i = 0; i < h; i++) {
				// for vertical additions
				BlocksClass btnData = (BlocksClass) data.blocks[i][currentCol].getUserData();
				lineData += btnData.color;
			}
			lineData += "#";
			int sr = Math.max(0, currentRow - currentCol);
			int sc = Math.max(0, currentCol - currentRow);
			while (sr < h && sc < w) {
				BlocksClass btnData = (BlocksClass) data.blocks[sr][sc].getUserData();
				lineData += btnData.color;
				sr++;
				sc++;
			}
			lineData += "#";
			sr = currentRow - Math.min(currentRow, (w - 1) - currentCol);
			sc = Math.min((w - 1), currentRow + currentCol);
			System.out.println(sr + "," + sc);
			while (sr < h && sc > -1) {
				BlocksClass btnData = (BlocksClass) data.blocks[sr][sc].getUserData();
				System.out.println(sr + "," + sc);
				lineData += btnData.color;
				sr++;
				sc--;
			}
			System.out.println(lineData);
		}

		if (lineData.contains(stringMultiply("r", connect))) {
			// RED's VICTORY!!!
			data.victorySound.play();
			data.playGameVBox.getChildren().clear();
			data.victoryImageSP.getChildren().clear();
			data.plyrsTurnsVBox.getChildren().clear();
			data.plyrsTurnsVBox.getChildren().addAll(redWinsImage);
			data.victoryImageSP.getChildren().addAll(redWinsImage);
			redWinsImage.fitWidthProperty().bind(data.plyrsTurnsVBox.widthProperty());
			redWinsImage.fitHeightProperty().bind(data.plyrsTurnsVBox.heightProperty());
			data.plyrsTurnsVBox.getChildren().add(data.victoryImageSP);
			data.plyrsTurnsVBox.setStyle("-fx-background-color: red;");
			new Alert(AlertType.INFORMATION, fpfinal + " (RED) Won!", ButtonType.OK).showAndWait();
			data.stageFinal.centerOnScreen();
			try {
				printResults(fpfinal);
			} catch (NumberFormatException | IOException e1) {
				e1.printStackTrace();
			}
			goBack();
		} else if (lineData.contains(stringMultiply("b", connect))) {
			// BLUE's VICTORY!!!
			data.victorySound.play();

			data.playGameVBox.getChildren().clear();

			data.stageFinal.centerOnScreen();
			data.victoryImageSP.getChildren().clear();
			data.plyrsTurnsVBox.getChildren().clear();
			data.plyrsTurnsVBox.getChildren().addAll(blueWinsImage);
			data.victoryImageSP.getChildren().addAll(blueWinsImage);
			blueWinsImage.fitWidthProperty().bind(data.plyrsTurnsVBox.widthProperty());
			blueWinsImage.fitHeightProperty().bind(data.plyrsTurnsVBox.heightProperty());
			data.plyrsTurnsVBox.getChildren().add(data.victoryImageSP);
			data.plyrsTurnsVBox.setStyle("-fx-background-color: blue;");
			new Alert(AlertType.INFORMATION, spfinal + " (BLUE) :  Won!", ButtonType.OK).showAndWait();
			try {
				printResults(spfinal);
			} catch (NumberFormatException | IOException e1) {
				e1.printStackTrace();
			}
			goBack();
		} else if (noOfBlocks == ((h * w) - 1)) {
			// GAME DRAWS!!!
			data.victoryImageSP.getChildren().clear();
			data.playGameVBox.getChildren().clear();
			data.plyrsTurnsVBox.getChildren().clear();
			data.plyrsTurnsVBox.getChildren().addAll(drawimgview);
			data.victoryImageSP.getChildren().addAll(drawimgview);
			drawimgview.fitWidthProperty().bind(data.plyrsTurnsVBox.widthProperty());
			drawimgview.fitHeightProperty().bind(data.plyrsTurnsVBox.heightProperty());
			data.plyrsTurnsVBox.getChildren().add(data.victoryImageSP);

			new Alert(AlertType.INFORMATION, "It is draw!", ButtonType.OK).showAndWait();
			String noonewon = "Draw!";
			try {
				printResults(noonewon);
			} catch (NumberFormatException | IOException e1) {
				e1.printStackTrace();
			}
			goBack();
		}

		// getting the final number of blocks into a variable
		finalturns = String.valueOf(noOfBlocks);
		System.out.println("Number of blocks on the board: " + noOfBlocks);

	}

	public static void main(String[] args) {
		launch(args);
	}

}
