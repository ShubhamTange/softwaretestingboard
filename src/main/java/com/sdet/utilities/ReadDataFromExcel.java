package com.sdet.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	static XSSFWorkbook workbook;

	public static String[][] getDataForSignIn() {

		String fileName = "User Details for SignIn.xlsx";

		try {
			FileInputStream fis = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fis);

		} catch (Exception ex) {

		}

		XSSFSheet sheet = workbook.getSheet("Sheet1");
		// counting how many rows are there in sheet
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][cellCount];
		System.out.println("rowCount: " + rowCount);
		for (int rowNo = 1; rowNo <= rowCount; rowNo++) {

			// count how many cells are there in specific row

			System.out.println("cellCount: " + cellCount);
			for (int cellNo = 0; cellNo < cellCount; cellNo++) {

				data[rowNo - 1][cellNo] = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
				System.out.println(data[rowNo - 1][cellNo]);

			}

		}

		return data;
	}

	public static String[][] getDataForRegistration() {

		String fileName = "RegistrationDetails.xlsx";

		try {
			FileInputStream fis = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fis);

		} catch (Exception ex) {

		}

		XSSFSheet sheet = workbook.getSheet("Sheet1");
		// int cellCount = sheet.getRow(0).getLastCellNum();

		// counting how many rows are there in sheet
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][cellCount];
		System.out.println("rowCount: " + rowCount);
		for (int rowNo = 1; rowNo <= rowCount; rowNo++) {

			// count how many cells are there in specific row

			System.out.println("cellCount: " + cellCount);
			for (int cellNo = 0; cellNo < cellCount; cellNo++) {

				data[rowNo - 1][cellNo] = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
				System.out.println(data[rowNo - 1][cellNo]);

			}

		}

		return data;
	}

	public static void main(String[] args) {
		getDataForSignIn();
		getDataForRegistration();
	}
}
