package com.iiht.evaluation.automation.testutils.xls;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {
	public static String filename = System.getProperty("user.dir")
			+ "src/test/java/com/iiht/evaluation/automation/testdata/TestSuite.xlsx";
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public Xls_Reader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
            return sheet.getLastRowNum() + 1;
		}
	}

	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0) {
				return "";
			}
			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1) {
				return "";
			}
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1) {
				return "";
			}
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null) {
				return "";
			}
			cell = row.getCell(col_Num);
			if (cell == null) {
				return "";
			}
			if (cell.getCellType() == CellType.STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				String cellText = null;
				try {
					if (DateUtil.isCellDateFormatted(cell)) {
						workbook.getCreationHelper().createFormulaEvaluator().evaluateFormulaCell(cell);
						cellText = new CellDateFormatter(cell.getCellStyle().getDataFormatString())
								.format(cell.getDateCellValue());
					} else {
						cell.setCellType(CellType.STRING);
						cellText = cell.getStringCellValue();
					}
					return cellText;
				} catch (Throwable t) {
					cell.setCellType(CellType.STRING);
					cellText = cell.getStringCellValue();
					return cellText;
				}

			} else if (cell.getCellType() == CellType.BLANK) {
				return "";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0) {
				return "";
			}
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1) {
				return "";
			}
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null) {
				return "";
			}
			cell = row.getCell(colNum);
			if (cell == null) {
				return "";
			}
			if (cell.getCellType() == CellType.STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				String cellText = null;
				try {
					if (DateUtil.isCellDateFormatted(cell)) {
						workbook.getCreationHelper().createFormulaEvaluator().evaluateFormulaCell(cell);
						cellText = new CellDateFormatter(cell.getCellStyle().getDataFormatString())
								.format(cell.getDateCellValue());
					} else {
						cell.setCellType(CellType.STRING);
						cellText = cell.getStringCellValue();
					}
					return cellText;
				} catch (Throwable t) {
					cell.setCellType(CellType.STRING);
					cellText = cell.getStringCellValue();
					return cellText;
				}

			} else if (cell.getCellType() == CellType.BLANK) {
				return "";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}

	public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			if (rowNum <= 0) {
				return false;
			}
			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1) {
				return false;
			}
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i) != null) {
					if (row.getCell(i).getStringCellValue().trim().equals(colName))
						colNum = i;
				}
			}
			if (colNum == -1) {
				return false;
			}
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null) {
				row = sheet.createRow(rowNum - 1);
			}
			cell = row.getCell(colNum);
			if (cell == null) {
				cell = row.createCell(colNum);
			}
			cell.setCellValue(data);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean setCellData(String sheetName, int colNumber, int rowNum, String data) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			if (rowNum <= 0) {
				return false;
			}
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1) {
				return false;
			}
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			if (colNumber == -1) {
				return false;
			}
			sheet.autoSizeColumn(colNumber);
			row = sheet.getRow(rowNum - 1);
			if (row == null) {
				row = sheet.createRow(rowNum - 1);
			}
			cell = row.getCell(colNumber);
			if (cell == null) {
				cell = row.createCell(colNumber);
			}
			cell.setCellValue(data);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean setCellData(String sheetName, String colName, int rowNum, String data, String url) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			if (rowNum <= 0) {
				return false;
			}
			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1) {
				return false;
			}
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
					colNum = i;
			}

			if (colNum == -1) {
				return false;
			}
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null) {
				row = sheet.createRow(rowNum - 1);
			}
			cell = row.getCell(colNum);
			if (cell == null) {
				cell = row.createCell(colNum);
			}
			cell.setCellValue(data);
			XSSFCreationHelper createHelper = workbook.getCreationHelper();
			CellStyle hlink_style = workbook.createCellStyle();
			XSSFFont hlink_font = workbook.createFont();
			hlink_font.setUnderline(Font.U_SINGLE);
			hlink_font.setColor(IndexedColors.BLUE.getIndex());
			hlink_style.setFont(hlink_font);
			XSSFHyperlink link = createHelper.createHyperlink(HyperlinkType.EMAIL);
			link.setAddress(url);
			cell.setHyperlink(link);
			cell.setCellStyle(hlink_style);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean addSheet(String sheetname) {
		FileOutputStream fileOut;
		try {
			workbook.createSheet(sheetname);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean removeSheet(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return false;
		FileOutputStream fileOut;
		try {
			workbook.removeSheetAt(index);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean addColumn(String sheetName, String colName) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1) {
				return false;
			}
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BRIGHT_GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			if (row == null) {
				row = sheet.createRow(0);
			}
			if (row.getLastCellNum() == -1) {
				cell = row.createCell(0);
			} else {
				cell = row.createCell(row.getLastCellNum());

				cell.setCellValue(colName);
				cell.setCellStyle(style);

				fileOut = new FileOutputStream(path);
				workbook.write(fileOut);
				fileOut.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean removeColumn(String sheetName, int colNum) {
		try {
			if (!isSheetExist(sheetName)) {
				return false;
			}
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BRIGHT_GREEN.getIndex());
			style.setFillPattern(FillPatternType.NO_FILL);
			for (int i = 0; i < getRowCount(sheetName); i++) {
				row = sheet.getRow(i);
				if (row != null) {
					cell = row.getCell(colNum);
					if (cell != null) {
						cell.setCellStyle(style);
						row.removeCell(cell);
					}
				}
			}
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}

	}

	public int getColumnCount(String sheetName) {
		if (!isSheetExist(sheetName)) {
			return -1;
		}
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		if (row == null) {
			return -1;
		}
		return row.getLastCellNum();
	}

	public int getColumnCountSpecifiedStartRow(String sheetName, int rowNumber) {
		if (!isSheetExist(sheetName)) {
			return -1;
		}
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		if (row == null) {
			return -1;
		}
		return row.getLastCellNum();
	}

	public boolean addHyperLink(String sheetName, String screenShotColName, String testCaseName, int index, String url,
			String message) {
		url = url.replace('\\', '/');
		if (!isSheetExist(sheetName)) {
			return false;
		}
		sheet = workbook.getSheet(sheetName);
		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)) {
				// System.out.println("**caught "+(i+index));
				setCellData(sheetName, screenShotColName, i + index, message, url);
				break;
			}
		}
		return true;
	}

	public int getCellRowNum(String sheetName, String colName, String cellValue) {
		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;

	}

	public String getSpecificRowCellData(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum < 0) {
				return "";
			}
			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1) {
				return "";
			}
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1) {
				return "";
			}
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum);
			if (row == null) {
				return "";
			}
			cell = row.getCell(col_Num);
			if (cell == null) {
				return "";
			}
			if (cell.getCellType() == CellType.STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				String cellText = null;
				try {
					if (DateUtil.isCellDateFormatted(cell)) {
						workbook.getCreationHelper().createFormulaEvaluator().evaluateFormulaCell(cell);
						cellText = new CellDateFormatter(cell.getCellStyle().getDataFormatString())
								.format(cell.getDateCellValue());
					} else {
						cell.setCellType(CellType.STRING);
						cellText = cell.getStringCellValue();
					}
					return cellText;
				} catch (Throwable t) {
					cell.setCellType(CellType.STRING);
					cellText = cell.getStringCellValue();
					return cellText;
				}

			} else if (cell.getCellType() == CellType.BLANK) {
				return "";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	public boolean setCellColor(String sheetName, String colName, String data) throws IOException {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			int rowNum = getRowCount(sheetName);
			row = sheet.getRow(0);
			int col_Num = -1;
			String getCellValue = null;
			XSSFCellStyle my_style = workbook.createCellStyle();
			my_style.setFillBackgroundColor(IndexedColors.RED.getIndex());
			my_style.setFillPattern(FillPatternType.FINE_DOTS);
			my_style.setFillForegroundColor(IndexedColors.RED.getIndex());
			for (int i = 0; i <= row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName)) {
					col_Num = i;
					break;
				}
			}
			for (int i = 0; i <= rowNum; i++) {
				getCellValue = getCellData(sheetName, col_Num, i);
				if (getCellValue.equalsIgnoreCase("Yes")) {
					cell.setCellStyle(my_style);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		}
		return true;
	}

}
