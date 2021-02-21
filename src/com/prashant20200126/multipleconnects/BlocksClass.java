package com.prashant20200126.multipleconnects;

/**
 * <h1>Representation of the Blocks</h1> This class is used to explain the
 * representation of the block tiles for the game.
 * <p>
 * <b>Note:</b> It is used in the MultipleConnects Class.
 *
 * @author Prashant Wakchaure
 */

public class BlocksClass {
	/**
	 * BlocksClass instance variables
	 */
	public int row, col;
	public char color;

	/**
	 * <p>
	 * <b>Get Row Function: </b> This is a getter to get the row of the tilepane.
	 * </p>
	 * 
	 * @return int Returns a row integer.
	 * 
	 */
	public int getRow() {
		return row;
	}

	/**
	 * <p>
	 * <b>Set Row Function: </b> This is a setter to set the row of the tilepane.
	 * </p>
	 * 
	 * @param row Set the integer row of the tilepane.
	 * 
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * <p>
	 * <b>Get Column Function: </b> This is a getter to get the column of the
	 * tilepane.
	 * </p>
	 * 
	 * @return int Returns a column integer.
	 * 
	 */
	public int getCol() {
		return col;
	}

	/**
	 * <p>
	 * <b>Set Column Function: </b> This is a setter to set the column of the
	 * tilepane.
	 * </p>
	 * 
	 * @param col Set the integer column of the tilepane.
	 * 
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * <p>
	 * <b>Get Color Function: </b> This is a getter to get the color of the
	 * tilepane.
	 * </p>
	 * 
	 * @return char Returns a color char, specifically just 'r' or 'b'.
	 * 
	 */
	public char getColor() {
		return color;
	}

	/**
	 * <p>
	 * <b>Set Color Function: </b> This is a setter to set the color of the
	 * tilepane.
	 * </p>
	 * 
	 * @param color Set the color character of the tilepane.
	 * 
	 */
	public void setColor(char color) {
		this.color = color;
	}

	/**
	 * <p>
	 * <b>Constructor </b>
	 * </p>
	 * 
	 * @param row   Rows for the Tile blocks of the game.
	 * @param col   Columns for the Tile blocks of the game.
	 * @param color Colors for the Tile blocks of the game.
	 * 
	 */
	public BlocksClass(int row, int col, char color) {
		this.row = row;
		this.col = col;
		this.color = color;
	}

}