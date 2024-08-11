package com.pps.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.pps.model.User;

@Component
public class ExcelWriter {
	
	@Value("#{${users}}")
	private Map<String,String> users;

	@SuppressWarnings("resource")
	public ResponseEntity<?> writeExcelOnLoc(User user,List<User> userList,HttpServletRequest request,HttpServletResponse response) {
		
		String fileName = "userDetails_"+new Date().getTime()+".xlsx";
		try {
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("UserDetailsExcel");
			CreationHelper createHelper = workbook.getCreationHelper();
			if(user!=null && user.getUserSelectedFields()!=null && !user.getUserSelectedFields().isEmpty()) {
			    Font headerFont = workbook.createFont();
			    headerFont.setBold(true);
			    headerFont.setFontHeightInPoints((short) 14);
			    headerFont.setColor(IndexedColors.RED.getIndex());
			    // Create a CellStyle with the font
			    CellStyle headerCellStyle = workbook.createCellStyle();
			    headerCellStyle.setFont(headerFont);
			    // Create a Row
			    Row headerRow = sheet.createRow(0);
			        for(int i = 0; i < user.getUserSelectedFields().size(); i++) {
			            Cell cell = headerRow.createCell(i);
			            cell.setCellValue(users.get(user.getUserSelectedFields().get(i)));
			            cell.setCellStyle(headerCellStyle);
			        }
			        CellStyle dateCellStyle = workbook.createCellStyle();
			        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			        
			        // Create Other rows and cells with user data
			        int rowNum = 1;
			        
				    for (@SuppressWarnings("rawtypes")
					Iterator iterator = userList.iterator(); iterator.hasNext();) {
						Object[] object = (Object[]) iterator.next();
						Row row = sheet.createRow(rowNum++);
						for (int i = 0; i < object.length; i++) {
							 if (object[i]!=null && object[i] instanceof Date) {
								 Cell   dateCell = row.createCell(i);
						            	dateCell.setCellValue((Date)object[i]);
						            	dateCell.setCellStyle(dateCellStyle);
							}else
								row.createCell(i).setCellValue(object[i]!=null?object[i].toString():"");
						}
			        }

					// Resize all columns to fit the content size
			        for(int i = 0; i < user.getUserSelectedFields().size(); i++) {
			            sheet.autoSizeColumn(i);
			        }
					final File homeDir = new File(System.getProperty("user.home")); 
					final File dir = new File(homeDir, "/exported/excel/"); 
					if (!dir.exists() && !dir.mkdirs()) throw new IOException("Unable to create " +dir.getAbsolutePath());
					FileOutputStream fileOut = new FileOutputStream(dir.toString()+"/"+fileName);
					workbook.write(fileOut);

			        File file = new File(dir.toString()+"/"+fileName);
			        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
			        workbook.close();
			        return ResponseEntity.ok()
			                // Content-Disposition
			                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
			                // Content-Type
			                .contentType(MediaType.APPLICATION_OCTET_STREAM)
			                // Contet-Length
			                .contentLength(file.length()) //
			                .body(resource);
/*					FileChannel outputChannel = fileOut.getChannel();
					FileInputStream fis = new FileInputStream(inputFile);
					FileChannel inputChannel = fis.getChannel();
					 
					//Transfer from output stream to input stream is happening here
					outputChannel.transferTo(0, inputChannel.size(), inputChannel);
					 
					 
					/Don't forget to close the streams and channels
					inputChannel.close();
					fis.close();
					 
					outputChannel.close();
					fos.close();
			        fileAbsolutePath= dir.toString()+"/"+fileName;
			        Path path = Paths.get(fileAbsolutePath);
					byte[] bytes = Files.readAllBytes(path);
					//byte[] bytes = IOUtils.toByteArray(fileOut);
					String file = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
					HttpHeaders httpHeaders = new HttpHeaders();
					httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
					httpHeaders.setContentLength(dir.length());
					httpHeaders.setContentDispositionFormData("attachment", file);
					
*/					
			        //fileOut.close();
					
					//return new ResponseEntity<>(dir, httpHeaders, HttpStatus.OK);

			        
			    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
