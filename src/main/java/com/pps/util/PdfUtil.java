package com.pps.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pps.model.User;

@Component
public class PdfUtil {

	public ResponseEntity<?> createPdf(User user, HttpServletRequest request, HttpServletResponse response) {
		try {
			String fileName1 = "icon.png";
			String fileName2 = "kumbh.jpg";

			//ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			File file1 = ResourceUtils.getFile("classpath:"+fileName1);
			File file2 = ResourceUtils.getFile("classpath:"+fileName2);
			//File file1 = new File(classLoader.getResource(fileName1).getFile());
			//File file2 = new File(classLoader.getResource(fileName2).getFile());
			final File homeDir = new File(System.getProperty("user.home"));
			final File dir = new File(homeDir, "/exported/pdf/");
			if (!dir.exists() && !dir.mkdirs())
				throw new IOException("Unable to create " + dir.getAbsolutePath());
			Image imageLogo = Image.getInstance(file1.getPath());
			Image imageKmb = Image.getInstance(file2.getPath());
			imageLogo.scalePercent(10);
			imageLogo.scaleToFit(26, 50);
			imageLogo.scaleAbsoluteWidth(50);
			imageLogo.scaleAbsoluteHeight(50);

			imageKmb.scalePercent(10);
			imageKmb.scaleToFit(26, 50);
			imageKmb.scaleAbsoluteWidth(50);
			imageKmb.scaleAbsoluteHeight(50);
			imageKmb.setAbsolutePosition(350, 325);
			PdfPTable table = new PdfPTable(3);
			PdfPCell cell1 = new PdfPCell();
			Font font12pt = new Font(FontFamily.TIMES_ROMAN, 11);
			Font font10pt = new Font(FontFamily.TIMES_ROMAN, 9);
			Phrase p = new Phrase("   PRABHU PREMI SANGH  ", font12pt);
			Phrase p2 = new Phrase(
					"  9TH JAN 2019 TO 15TH FEB 2019 \n        Sector 14, Annpurna Marg,\r\n" + "         Jhusi, Pryagraj – 211019" + "",
					font10pt);
			cell1.addElement(imageLogo);
			cell1.setBorder(Rectangle.NO_BORDER);
			cell1.setPaddingTop(-30);
			table.addCell(cell1);
			cell1 = new PdfPCell();
			cell1.addElement(p);
			cell1.setNoWrap(true);
			cell1.addElement(p2);
			cell1.setPaddingLeft(-20);
			cell1.setBorder(Rectangle.NO_BORDER);
			cell1.setPaddingTop(-30);
			table.addCell(cell1);
			cell1 = new PdfPCell();
			cell1.addElement(imageKmb);
			cell1.setBorder(Rectangle.NO_BORDER);
			cell1.setPaddingTop(-30);
			cell1.setPaddingLeft(40);
			table.addCell(cell1);
			table.setWidthPercentage(130);
			String fileName = user.getRegNo().split("/")[1] + "_userDetails_" + new Date().getTime() + ".pdf";
			//Rectangle pagesize = new Rectangle(216f, 720f);
			Document document = new Document(PageSize.A6);
			// Document document = new Document(pagesize, 36f, 72f, 108f, 180f);
			PdfWriter.getInstance(document, new FileOutputStream(dir.toString() + "/" + fileName));
			document.open();
			document.add(table);

			table = new PdfPTable(2);
			addCustomRows(table, new PdfPCell(), "Registration No.",font10pt);
			addCustomRows(table, new PdfPCell(), ""+user.getRegNo(),font10pt);
			addCustomRows(table, new PdfPCell(), "Name",font10pt);
			addCustomRows(table, new PdfPCell(), ""+user.getUserName(),font10pt);
			addCustomRows(table, new PdfPCell(), "Place",font10pt);
			addCustomRows(table, new PdfPCell(), ""+user.getUserAddress()+","+user.getCity()+","+user.getState(),font10pt);
			addCustomRows(table, new PdfPCell(), "Contact No.",font10pt);
			addCustomRows(table, new PdfPCell(), ""+user.getContactNo(),font10pt);
			addCustomRows(table, new PdfPCell(), "Accommodation",font10pt);
			addCustomRows(table, new PdfPCell(), ""+user.getAccomodation(),font10pt);
			addCustomRows(table, new PdfPCell(), "Period From",font10pt);
			addCustomRows(table, new PdfPCell(), ""+String.format("%1$td-%1$tm-%1$tY", user.getStartDate())+"  To "+String.format("%1$td-%1$tm-%1$tY",user.getEndDate()),font10pt);
			table.setSpacingBefore(10);
			table.setSpacingAfter(10);
			document.add(table);
			document.add(new Paragraph("                                                                                  Signature", font10pt));
			document.close();
			File file = new File(dir.toString() + "/" + fileName);
			InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
			return ResponseEntity.ok()
					// Content-Disposition
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
					// Content-Type
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
					// Contet-Length
					.contentLength(file.length()) //
					.body(resource);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void addCustomRows(PdfPTable table,PdfPCell cell,String fieldValue,Font font) {
		cell.addElement(new Phrase(""+fieldValue, font));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setNoWrap(true);
		cell.setPaddingLeft(-40);
		table.addCell(cell);

		
	}
}
