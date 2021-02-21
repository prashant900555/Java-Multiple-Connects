package com.prashant20200126.multipleconnects;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/**
 * <h1>Data members of Connects Data</h1> This class is used to initialize
 * various GUI members which are to be utilized in MultiConnects.java Class.
 * <p>
 * <b>Note:</b> It is used in the MultipleConnects Class.
 *
 * @author Prashant Wakchaure
 */

public class MultipleConnectsData {
	/**
	 * MultipleConnectsData instance variables
	 */
	public Scene mainMenuScene;
	public TilePane blockTiles;
	public TableView<TableColumns> tableView;
	public ObservableList<TableColumns> dataList;
	public VBox plyrsTurnsVBox;
	public VBox playGameVBox;
	public Label playerNameLabel;
	public boolean isPlayerOneTurn;
	public Button[][] blocks;
	public Stage stageFinal;
	public StackPane victoryImageSP;
	public AudioClip victorySound;
	public MenuBar mainMenuBar;

	/**
	 * <p>
	 * <b>Constructor </b>
	 * </p>
	 * 
	 * @param blockTiles      Block Tiles as TilePanes to be seen in the main game
	 *                        scene.
	 * @param tableView       The previous results summary tableView to look at the
	 *                        previous results.
	 * @param dataList        The ObservableList to get the tableview columns and
	 *                        data.
	 * @param isPlayerOneTurn To check which players turn it is.
	 * @param victoryImageSP  Stack Pane to get the victory image of the
	 *                        red/blue/draw win condition.
	 * @param victorySound    AudioClip file to get the victorySound when any player
	 *                        wins the game.
	 * 
	 */
	public MultipleConnectsData(TilePane blockTiles, TableView<TableColumns> tableView,
			ObservableList<TableColumns> dataList, boolean isPlayerOneTurn, StackPane victoryImageSP,
			AudioClip victorySound) {
		this.blockTiles = blockTiles;
		this.tableView = tableView;
		this.dataList = dataList;
		this.isPlayerOneTurn = isPlayerOneTurn;
		this.victoryImageSP = victoryImageSP;
		this.victorySound = victorySound;
	}
}