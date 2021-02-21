package com.prashant20200126.multipleconnects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <h1>Class to test the Table Fields</h1> This class is created to test the
 * tablefields in the {@link MultipleConnectsAllTestCases}
 * <p>
 * <b>Note:</b> It is created to test the testfinalresults.csv file in the
 * {@link MultipleConnectsAllTestCases}.
 *
 * @author Prashant Wakchaure
 */

public class TableFieldsforTest {
	/**
	 * TableFieldsforTest instance variables
	 */
	private String playerOneName;
	private String playerTwoName;
	private String gameWinner;
	private int noOfComponents;
	private String dimensionOfBoard;
	private int noOfTiles;
	private String date;
	private String time;

	/**
	 * <p>
	 * <b>Constructor </b>
	 * </p>
	 * 
	 * @param playerOneName    Player 1 Name
	 * @param playerTwoName    Player 2 Name
	 * @param gameWinner       Winner Name
	 * @param noOfComponents   No. of Connects
	 * @param dimensionOfBoard Dimension of the board
	 * @param noOfTiles        No. of Tiles filled
	 * @param date             Date
	 * @param time             Time
	 * 
	 */
	public TableFieldsforTest(String playerOneName, String playerTwoName, String gameWinner, int noOfComponents,
			String dimensionOfBoard, int noOfTiles, String date, String time) {
		super();
		this.playerOneName = playerOneName;
		this.playerTwoName = playerTwoName;
		this.gameWinner = gameWinner;
		this.noOfComponents = noOfComponents;
		this.dimensionOfBoard = dimensionOfBoard;
		this.noOfTiles = noOfTiles;
		this.date = date;
		this.time = time;
	}

	/**
	 * <p>
	 * <b>Get Player1Name Function: </b> This is a getter to get the first player
	 * name.
	 * </p>
	 * 
	 * @return String Returns the name of the first player.
	 * 
	 */
	public String getPlayerOneName() {
		return playerOneName;
	}

	/**
	 * <p>
	 * <b>Set Player1Name Function: </b> This is a setter to set the name of the
	 * first player.
	 * </p>
	 * 
	 * @param playerOneName Set the name of the first player
	 * 
	 */
	public void setPlayerOneName(String playerOneName) {
		this.playerOneName = playerOneName;
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
	public String getPlayerTwoName() {
		return playerTwoName;
	}

	/**
	 * <p>
	 * <b>Set Player2Name Function: </b> This is a setter to set the name of the
	 * second player.
	 * </p>
	 * 
	 * @param playerTwoName Set the name of the second player
	 * 
	 */
	public void setPlayerTwoName(String playerTwoName) {
		this.playerTwoName = playerTwoName;
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
	public String getGameWinner() {
		return gameWinner;
	}

	/**
	 * <p>
	 * <b>Set Winner Function: </b> This is a setter to set the name of the winner.
	 * </p>
	 * 
	 * @param gameWinner Set the name of the winner.
	 * 
	 */
	public void setGameWinner(String gameWinner) {
		this.gameWinner = gameWinner;
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
	public int getNoOfComponents() {
		return noOfComponents;
	}

	/**
	 * <p>
	 * <b>Set NoofConnects Function: </b> This is a setter to set the no. of
	 * connects
	 * </p>
	 * 
	 * @param noOfComponents Set the no. of connects.
	 * 
	 */
	public void setNoOfComponents(int noOfComponents) {
		this.noOfComponents = noOfComponents;
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
	public String getDimensionOfBoard() {
		return dimensionOfBoard;
	}

	/**
	 * <p>
	 * <b>Set dimensionOfBoard Function: </b> This is a setter to set the dimension
	 * of the board in the format - "height x width".
	 * </p>
	 * 
	 * @param dimensionOfBoard Set the dimension of the board in the format -
	 *                         "height x width".
	 * 
	 */
	public void setDimensionOfBoard(String dimensionOfBoard) {
		this.dimensionOfBoard = dimensionOfBoard;
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
	public int getNoOfTiles() {
		return noOfTiles;
	}

	/**
	 * <p>
	 * <b>Set noOfTiles Function: </b> This is a setter to set the no. of tiles
	 * left. (Test purpose only)
	 * </p>
	 * 
	 * @param noOfTiles Set the no. of Tiles left. (Test purpose only)
	 * 
	 */
	public void setNoOfTiles(int noOfTiles) {
		this.noOfTiles = noOfTiles;
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
		return date;
	}

	/**
	 * <p>
	 * <b>Set date Function: </b> This is a setter to set the date.
	 * </p>
	 * 
	 * @param date Set the date.
	 * 
	 */
	public void setDate(String date) {
		this.date = date;
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
		return time;
	}

	/**
	 * <p>
	 * <b>Set time Function: </b> This is a setter to set the time.
	 * </p>
	 * 
	 * @param time Set the time.
	 * 
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * <p>
	 * <b>Read testCSV file function: </b> This function is created to return an
	 * arraylist of TableFields.
	 * </p>
	 * 
	 * @param f The test csv file to be included while testing.
	 * @return ArrayList It returns the arraylist of tablefields
	 *         by taking the strings from the test csv file.
	 * @throws NumberFormatException Wrong Number Input.
	 * @throws IOException           Input Ouput handling exception.
	 * @throws FileNotFoundException File is not found exception.
	 */
	public static ArrayList<TableFieldsforTest> read(File f)
			throws NumberFormatException, IOException, FileNotFoundException {
		ArrayList<TableFieldsforTest> tfs = new ArrayList<>();

		if (f.exists()) {
			int iteration = 0;
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line = br.readLine()) != null) {
				if (iteration == 0) {
					iteration++;
					continue;
				}
				String[] temp = line.split(",");
				String playerOneName = temp[0];
				String playerTwoName = temp[1];
				String winner = temp[2];
				int noofconn = Integer.parseInt(temp[3]);
				String dim = temp[4];
				int noOfTiles = Integer.parseInt(temp[5]);
				String date = temp[6];
				String time = temp[7];
				if (!playerOneName.isEmpty() && !playerTwoName.isEmpty() && !winner.isEmpty() && noofconn > 0
						&& !dim.isEmpty() && noOfTiles > 0 && !date.isEmpty() && !time.isEmpty()) {
					tfs.add(new TableFieldsforTest(playerOneName, playerTwoName, winner, noofconn, dim, noOfTiles, date,
							time));

				} else {
					throw new IOException("read method accepted a file with errors in it");
				}

			}
		} else {
			throw new FileNotFoundException("read method accepted a file that doesn't exist?");
		}
		return tfs;

	}

	/**
	 * <p>
	 * <b>Equals overriden function: </b> To test the equality of 2 object
	 * instances.
	 * </p>
	 * 
	 * @param o The given object is tested for equality.
	 * @return boolean returns true/false depending upon the equality.
	 * 
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof TableFieldsforTest) {
			return getPlayerOneName().equals(((TableFieldsforTest) o).getPlayerOneName())
					&& getPlayerTwoName().equals(((TableFieldsforTest) o).getPlayerTwoName())
					&& getGameWinner().equals(((TableFieldsforTest) o).getGameWinner())
					&& getNoOfComponents() == ((TableFieldsforTest) o).getNoOfComponents()
					&& getDimensionOfBoard().equals(((TableFieldsforTest) o).getDimensionOfBoard())
					&& getNoOfTiles() == ((TableFieldsforTest) o).getNoOfTiles()
					&& getDate().equals(((TableFieldsforTest) o).getDate())
					&& getTime().equals(((TableFieldsforTest) o).getTime());

		} else {
			return super.equals(o);
		}
	}

}
