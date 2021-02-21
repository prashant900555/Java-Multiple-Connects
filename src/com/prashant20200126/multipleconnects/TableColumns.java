package com.prashant20200126.multipleconnects;

import javafx.beans.property.SimpleStringProperty;

/**
 * <h1>Previous Results Table Columns</h1> This class is used to define the
 * previous results table columns, which is further added to the Observable
 * List.
 * <p>
 * <b>Note:</b> It is used in the MultipleConnects Class.
 *
 * @author Prashant Wakchaure
 */

public class TableColumns {
	/**
	 * TableColumns instance variables
	 */
	private SimpleStringProperty pl1, f2, f3, f4, f5, f6, f7, f8;

	/**
	 * <p>
	 * <b>Get Player1Name Function: </b> This is a getter to get the first player
	 * name.
	 * </p>
	 * 
	 * @return String Returns the name of the first player.
	 * 
	 */
	public String getPlayer1Name() {
		return pl1.get();
	}

	/**
	 * <p>
	 * <b>Get Player2Name Function: </b> This is a getter to get the second player
	 * name.
	 * </p>
	 * 
	 * @return String Returns the name of the second player.
	 * 
	 */
	public String getPlayer2Name() {
		return f2.get();
	}

	/**
	 * <p>
	 * <b>Get WinnerName Function: </b> This is a getter to get the name of the
	 * winner.
	 * </p>
	 * 
	 * @return String Returns the name of the winner.
	 * 
	 */
	public String getWinnerName() {
		return f3.get();
	}

	/**
	 * <p>
	 * <b>Get NoOfConnects Function: </b> This is a getter to get the user input no.
	 * of connects.
	 * </p>
	 * 
	 * @return String Returns the user inputted no. of connects.
	 * 
	 */
	public String getNoOfConnects() {
		return f4.get();
	}

	/**
	 * <p>
	 * <b>Get DimensionofBoard Function: </b> This is a getter to get the dimension
	 * of the board.
	 * </p>
	 * 
	 * @return String Returns the Dimension of the Board in the format - "height x
	 *         width".
	 * 
	 */
	public String getDimOfBoard() {
		return f5.get();
	}

	/**
	 * <p>
	 * <b>Get NoOfTilesFilled Function: </b> This is a getter to get the no. of
	 * tiles filled after the game ends.
	 * </p>
	 * 
	 * @return String Returns the no. of tiles filled after each game.
	 * 
	 */
	public String getNoOfTilesFilled() {
		return f6.get();
	}

	/**
	 * <p>
	 * <b>Get Date Function: </b> This is a getter to get the date of the game.
	 * </p>
	 * 
	 * @return String Returns the date of the game.
	 * 
	 */
	public String getDate() {
		return f7.get();
	}

	/**
	 * <p>
	 * <b>Get Time Function: </b> This is a getter to get the time of the game.
	 * </p>
	 * 
	 * @return String Returns the time of the game.
	 * 
	 */
	public String getTime() {
		return f8.get();
	}

	/**
	 * <p>
	 * <b>Constructor </b>
	 * </p>
	 * 
	 * @param pl1 Player 1 Name
	 * @param f2  Player 2 Name
	 * @param f3  Winner Name
	 * @param f4  No. of Connects
	 * @param f5  Dimension of the board
	 * @param f6  No. of Tiles filled
	 * @param f7  Date
	 * @param f8  Time
	 * 
	 */
	TableColumns(String pl1, String f2, String f3, String f4, String f5, String f6, String f7, String f8) {
		this.pl1 = new SimpleStringProperty(pl1);
		this.f2 = new SimpleStringProperty(f2);
		this.f3 = new SimpleStringProperty(f3);
		this.f4 = new SimpleStringProperty(f4);
		this.f5 = new SimpleStringProperty(f5);
		this.f6 = new SimpleStringProperty(f6);
		this.f7 = new SimpleStringProperty(f7);
		this.f8 = new SimpleStringProperty(f8);
	}

}
