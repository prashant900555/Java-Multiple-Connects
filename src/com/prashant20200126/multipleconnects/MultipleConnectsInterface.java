package com.prashant20200126.multipleconnects;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Background;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * <h1>Interface for the Multi-Connect functions</h1> This interface is
 * basically the blueprint of the functions which are to be implemented in the
 * MultipleConnects.java Class.
 * <p>
 *
 * @author Prashant Wakchaure
 */
public interface MultipleConnectsInterface {

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
	@SuppressWarnings("rawtypes")
	void operatePrevResButton(Stage primStage, Font mainfont, TableColumn columnF1, TableColumn columnF2,
			TableColumn columnF3, TableColumn columnF4, TableColumn columnF5, TableColumn columnF6,
			TableColumn columnF7, TableColumn columnF8, Background backgroundfill);

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
	void operateStartButton(Stage primStage, Font buttonfont, TilePane rootBlocks, Label plyrNameLbl, Scene gameScene,
			MenuBar menuBar);

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
	MenuBar getMenuBar(Stage primStage, TilePane rootBlocks);

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
	@SuppressWarnings("rawtypes")
	void getTableView(TableColumn columnF1, TableColumn columnF2, TableColumn columnF3, TableColumn columnF4,
			TableColumn columnF5, TableColumn columnF6, TableColumn columnF7, TableColumn columnF8);

	/**
	 * <p>
	 * <b>Final Results CSV Read Function: </b> This function reads the
	 * finalresults.csv file.
	 * </p>
	 * 
	 */
	void getTable();

	/**
	 * <p>
	 * <b>Go Back Function: </b> This function is used to go back to another scene
	 * in a stage.
	 * </p>
	 * 
	 */
	void goBack();

	/**
	 * <p>
	 * <b>Exit game function: </b> This is a basic exit game function.
	 * </p>
	 * 
	 */
	void exitGame();

	/**
	 * <p>
	 * <b>Multi-Connect Game Logic Function: </b> This function is the fundamental
	 * logic of my game. It explains the crux of the game.
	 * </p>
	 * 
	 * @param e The ActionEvent which is inside the Start Button Operator function.
	 * @throws FileNotFoundException The required file is not found.
	 */
	void playGameFunction(ActionEvent e) throws FileNotFoundException;

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
	String stringMultiply(String s, int n);

	/**
	 * <p>
	 * <b>Final Results CSV Create/Write Function: </b> This function is used to
	 * create/write the previous results CSV file dynamically.
	 * </p>
	 * 
	 * @param winner The winner String of the game.
	 * @throws NumberFormatException The number is in the wrong format.
	 * @throws IOException           The File I/O Handling has some issue.
	 * 
	 */
	void printResults(String winner) throws NumberFormatException, IOException;

}