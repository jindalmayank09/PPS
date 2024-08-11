package com.pps.excel.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.pps.model.Tutorial;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Name","Phone No", "Place", "DOB","From","To" };
	static String SHEET = "Data";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static ByteArrayInputStream tutorialsToExcel(List<Tutorial> tutorials) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(SHEET);

			// Header
			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
			}

			int rowIdx = 1;
			for (Tutorial tutorial : tutorials) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(tutorial.getName());
				row.createCell(1).setCellValue(tutorial.getPhoneNo());
				row.createCell(2).setCellValue(tutorial.getPlace());
				row.createCell(3).setCellValue(tutorial.getDob());
				row.createCell(4).setCellValue(tutorial.getFromDate());
				row.createCell(5).setCellValue(tutorial.getToDate());
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

	public static List<Tutorial> excelToTutorials(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<Tutorial> tutorials = new ArrayList<Tutorial>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				
				Iterator<Cell> cellsInRow = currentRow.iterator();

				Tutorial tutorial = new Tutorial();
				DataFormatter formatter = new DataFormatter();
				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						tutorial.setName(currentCell.getStringCellValue());
						break;

					case 1:
						String val = formatter.formatCellValue(sheet.getRow(currentRow.getRowNum()).getCell(cellIdx));
						tutorial.setPhoneNo(val);
						break;

					case 2:
						tutorial.setPlace(currentCell.getStringCellValue());
						break;

					case 3:
						tutorial.setDob(currentCell.getStringCellValue());
						break;
					case 4:
						tutorial.setFromDate(currentCell.getStringCellValue());
						break;
					case 5:
						tutorial.setToDate(currentCell.getStringCellValue());
						break;

					default:
						break;
					}

					cellIdx++;
				}
				
				tutorials.add(tutorial);
			}

			workbook.close();
			tutorials.forEach(t->t.setCreationDate(new Date()));
			return tutorials;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}
