package com.prashant20200126.multipleconnects;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;

/**
 * <h1>Class for Multiple Connects Test Cases</h1> This class is created to test
 * the testcases created for the entire game.
 * <p>
 * <b>Note:</b> Even though it has minimal tests, it covers around 50% of the
 * code, and as we've not learnt how to test GUI, the other 50% remains
 * untouched.
 *
 * @author Prashant Wakchaure
 */
class MultipleConnectsAllTestCases {

	/**
	 * MultipleConnectsAllTestCases instances
	 */
	MultipleConnects mc;

	@Test
	public void MainApplicationWorkingTest() throws InterruptedException {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				new JFXPanel(); // Initializes the JavaFx Platform
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						try {
							mc = new MultipleConnects();
							mc.start(new Stage());

						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				});
			}
		});

		thread.start();
		Thread.sleep(1500);
	}

	@Test
	public void TableFieldsTest() {
		TableFieldsforTest a1 = new TableFieldsforTest("PlayerOne", "PlayerTwo", "PlayerOne", 4, "6 x 8", 6,
				"17.12.2020", "19.50.30");
		TableFieldsforTest a2 = new TableFieldsforTest("Player1", "Player2", "Player2", 5, "12 x 6", 23, "18.12.2020",
				"02.50.30");
		TableFieldsforTest a3 = new TableFieldsforTest("PlayerOne", "PlayerTwo", "PlayerOne", 4, "6 x 8", 6,
				"17.12.2020", "19.50.30");

		assertEquals(a1, a1);
		assertTrue(a1.equals(a3));
		assertFalse(a1.equals(a2));
	}

	@Test
	void csvFileTest() {
		File f = new File("src\\com\\prashant20200126\\multipleconnects\\testfinalresults.csv");

		try {
			ArrayList<TableFieldsforTest> al = TableFieldsforTest.read(f);
			assertEquals(5, al.size());

			TableFieldsforTest a = new TableFieldsforTest("PlayerOne", "PlayerTwo", "PlayerOne", 4, "6 x 8", 6,
					"17.12.2020", "19.50.30");
			assertEquals(a, al.get(0));
			assertFalse(a.equals(al.get(3)));
		} catch (Exception ex) {
			fail("Please check the inputs again");
		}
	}

	@Test
	void csvFileTest2() {

		try {
			ArrayList<TableFieldsforTest> al = TableFieldsforTest.read(new File("notrealfile.txt"));
			fail("File does not exist");
		} catch (Exception ex) {
		}

	}

	@Test
	void csvFileTest3() {

		String pl1 = "Pinky", pl2 = "Oswold", gw = "Oswold", dim = "6 x 11", date = "18.03.2019", time = "11.39.45";
		int n = 5, nt = 23;

		TableFieldsforTest tl = new TableFieldsforTest(pl1, pl2, gw, n, dim, nt, date, time);

		tl.setDate(date);
		assertEquals("18.03.2019", tl.getDate());
		assertFalse(tl.getPlayerOneName().equals(tl.getPlayerTwoName()));

	}

	@Test
	void blocksTest1() {
		int row = 0;
		int col = 0;
		char color = 0;
		BlocksClass bc = new BlocksClass(row, col, color);
		MultipleConnects mc = new MultipleConnects();

		bc.setRow(4);
		bc.setCol(6);
		bc.setColor('r');
		assertEquals(4, bc.getRow());
		assertEquals("rrrr", mc.stringMultiply("r", 4));
	}

	@Test
	void StringMultiplyTest() {
		int row = 0;
		int col = 0;
		char color = 0;
		BlocksClass bc = new BlocksClass(row, col, color);
		MultipleConnects mc = new MultipleConnects();

		bc.setRow(4);
		bc.setCol(6);
		bc.setColor('r');
		assertEquals(4, bc.getRow());
		assertEquals("rrrrrr", mc.stringMultiply(String.valueOf(bc.getColor()), 6));
	}

	@Test
	void StringMultiplyTest2() {
		int row = 0;
		int col = 0;
		char color = 0;
		BlocksClass bc = new BlocksClass(row, col, color);
		MultipleConnects mc = new MultipleConnects();

		bc.setRow(4);
		bc.setCol(6);
		bc.setColor('r');
		assertEquals(4, bc.getRow());
		assertNotEquals("rrrrrrrrr", mc.stringMultiply(String.valueOf(bc.getColor()), 6));
	}

	@Test
	void BlueVictoryTestCase() {
		int row = 0;
		int col = 0;
		char color = 'b';
		BlocksClass bc = new BlocksClass(row, col, color);
		MultipleConnects mc = new MultipleConnects();
		String bluevic;

		if (mc.stringMultiply(String.valueOf(bc.getColor()), 6).equals("bbbbbb")) {
			bluevic = "Blue Victory!";
		} else {
			bluevic = "Red Victory!";
		}

		assertEquals("Blue Victory!", bluevic);
	}

	@Test
	void RedVictoryTestCase() {
		int row = 0;
		int col = 0;
		char color = 0;
		BlocksClass bc = new BlocksClass(row, col, color);
		MultipleConnects mc = new MultipleConnects();
		String bluevic;
		bc.setCol('r');

		if (mc.stringMultiply(String.valueOf(bc.getColor()), 4).equals("rrrr")) {
			bluevic = "Red Victory!";
		} else {
			bluevic = "Blue Victory!";
		}

		assertEquals("Blue Victory!", bluevic);
	}

	@Test
	void interfaceMethodsTest() {
		Method[] methods = MultipleConnectsInterface.class.getMethods();

		int count = 0;

		for (Method m : methods) {
			if (m.getName().trim().equalsIgnoreCase("operatePrevResButton"))
				count++;
			else if (m.getName().trim().equalsIgnoreCase("operateStartButton"))
				count++;
			else if (m.getName().trim().equalsIgnoreCase("getMenuBar"))
				count++;
			else if (m.getName().trim().equalsIgnoreCase("getTableView"))
				count++;
			else if (m.getName().trim().equalsIgnoreCase("getTable"))
				count++;
			else if (m.getName().trim().equalsIgnoreCase("goBack"))
				count++;
			else if (m.getName().trim().equalsIgnoreCase("exitGame"))
				count++;
			else if (m.getName().trim().equalsIgnoreCase("playGameFunction"))
				count++;
			else if (m.getName().trim().equalsIgnoreCase("stringMultiply"))
				count++;
			else if (m.getName().trim().equalsIgnoreCase("printResults"))
				count++;

		}

		assertEquals(10, count);

		assertTrue(MultipleConnectsInterface.class.isInterface());
	}

	@Test
	void checkTurnsTest() {
		int row = 0;
		int col = 0;
		char color = 0;
		BlocksClass bc = new BlocksClass(row, col, color);
		MultipleConnects mc = new MultipleConnects();

		if (mc.noOfBlocks % 2 == 1) {
			bc.setCol('b');
		} else {
			bc.setCol('r');
		}

		String b;

		if (mc.noOfBlocks == 2) {
			b = "Red's Turn!";
		} else {
			b = "Blue's Turn!";
		}

		assertEquals("Blue's Turn!", b);
	}

}
