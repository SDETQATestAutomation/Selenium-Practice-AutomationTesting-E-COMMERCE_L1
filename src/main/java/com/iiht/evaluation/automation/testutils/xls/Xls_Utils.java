package com.iiht.evaluation.automation.testutils.xls;


public class Xls_Utils {

	/*******************************************************************
	 * 
	 * @param xls
	 * @param suiteID
	 * @return
	 */

	public static boolean isSuiteRunnable(Xls_Reader xls, String suiteID) {
		boolean isExecutable = false;
		for (int i = 2; i <= xls.getRowCount("TestSuite"); i++) {
			if (xls.getCellData("TestSuite", "TSID", i).equalsIgnoreCase(suiteID)) {
				if (xls.getCellData("TestSuite", "Runmode", i).equalsIgnoreCase("Y")) {
					isExecutable = true;
				} else {
					isExecutable = false;
				}
			}

		}
		xls = null;
		return isExecutable;

	}

	/************************************************************************
	 * 
	 * @param xls
	 * @param testCaseID
	 * @return
	 */

	public static boolean isTestCaseRunnable(Xls_Reader xls, String testCaseID) {
		boolean isExecutable = false;
		for (int i = 2; i <= xls.getRowCount("TestCase"); i++) {
			if (xls.getCellData("TestCase", "TCID", i).equalsIgnoreCase(testCaseID)) {
				if (xls.getCellData("TestCase", "Runmode", i).equalsIgnoreCase("Y")) {
					isExecutable = true;
				} else {
					isExecutable = false;
				}
			}

		}
		xls = null;
		return isExecutable;

	}

	/*****************************************************************
	 * 
	 * @param xls
	 * @param testCaseID
	 * @return
	 */

	public static Object[][] getData(Xls_Reader xls, String testCaseID) {
		if (!xls.isSheetExist(testCaseID)) {
			xls = null;
			return new Object[1][0];
		}

		int rows = xls.getRowCount(testCaseID);
		int cols = xls.getColumnCount(testCaseID);

		Object[][] data = new Object[rows - 1][cols - 3];
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols - 3; colNum++) {
				data[rowNum - 2][colNum] = xls.getCellData(testCaseID, colNum, rowNum);
			}

		}
		return data;

	}

	/**********************************************************
	 * 
	 * @param xlsFile
	 * @param sheetName
	 * @return
	 */

	public static String[] getDataSetRunmodes(Xls_Reader xlsFile, String sheetName) {
		String[] runmodes = null;
		if (!xlsFile.isSheetExist(sheetName)) {
			xlsFile = null;
			sheetName = null;
			runmodes = new String[1];
			runmodes[0] = "Y";
			xlsFile = null;
			sheetName = null;
			return runmodes;
		}
		runmodes = new String[xlsFile.getRowCount(sheetName) - 1];
		for (int i = 2; i <= runmodes.length + 1; i++) {
			runmodes[i - 2] = xlsFile.getCellData(sheetName, "Runmode", i);
		}
		xlsFile = null;
		sheetName = null;
		return runmodes;

	}

	/*******************************************************************
	 * 
	 * @param xls
	 * @param testCaseID
	 * @param rowNum
	 * @param result
	 */

	public static void reportDataSetResult(Xls_Reader xls, String testCaseID, int rowNum, String result) {
		xls.setCellData(testCaseID, "Result", rowNum, result);
	}


	/********************************************************************
	 * 
	 * @param xls
	 * @param testCaseName
	 * @param rowNum
	 * @param Error
	 */

	public static void reportError(Xls_Reader xls, String testCaseName, int rowNum, String Error) {
		xls.setCellData(testCaseName, "Error", rowNum, Error);
	}

	/********************************************************************
	 * 
	 * @param xls
	 * @param sheetName
	 * @param column
	 */

	public static void resetColumnData(Xls_Reader xls, String sheetName, String column) {
		for (int i = 2; i <= xls.getRowCount(sheetName); i++) {
			xls.setCellData(sheetName, column, i, "");
		}

	}

	/*******************************************************************
	 * 
	 * @param xls
	 * @param tcidd
	 * @return
	 */

	public static int getRowNum(Xls_Reader xls, String tcidd) {
		for (int i = 2; i <= xls.getRowCount("TestCase"); i++) {
			String tcid = xls.getCellData("TestCase", "TCID", i);

			if (tcid.equals(tcidd)) {
				xls = null;
				return i;
			}
		}
		return -1;
	}

}
