package com.pps.excel.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.pps.model.Tutorial;

public class PdfHelper {

	public static ResponseEntity<?> createPdf(Tutorial tutorial) {
		try {
			Boolean isFromDateToDtAvail = false;
			if (tutorial.getFromDate() != null && !tutorial.getFromDate().isEmpty() && tutorial.getToDate() != null
					&& !tutorial.getToDate().isEmpty())
				isFromDateToDtAvail = true;
			String fileName1 = "PPSLatest.jpg";
			File file1 = ResourceUtils.getFile("classpath:" + fileName1);
			final File homeDir = new File(System.getProperty("user.home"));
			final File dir = new File(homeDir, "/exported/pdf/");
			if (!dir.exists() && !dir.mkdirs())
				throw new IOException("Unable to create " + dir.getAbsolutePath());
			Image imageLogo = Image.getInstance(file1.getPath());
			// imageLogo.setAbsolutePosition(470, 475);
			// imageLogo.scalePercent(10);
			// imageLogo.setPaddingTop(-70);
			Rectangle pagesize = null;
			if (isFromDateToDtAvail) {
				// imageLogo.scaleToFit(35, 100);
				imageLogo.scaleAbsoluteWidth(70);
				imageLogo.scaleAbsoluteHeight(70);
				pagesize = new Rectangle(200f, 230f);

			} else {
				// imageLogo.scaleToFit(26, 50);
				imageLogo.scaleAbsoluteWidth(50);
				imageLogo.scaleAbsoluteHeight(50);
				pagesize = new Rectangle(200f, 180f);
			}

			PdfPTable table = new PdfPTable(5);
			PdfPCell cell1 = new PdfPCell();
			Font font10pt = new Font(FontFamily.TIMES_ROMAN, 9);
			Phrase p = new Phrase(" ", font10pt);
			cell1.addElement(p);
			cell1.setPaddingLeft(100);
			cell1.setBorder(Rectangle.NO_BORDER);
			table.addCell(cell1);
			cell1.addElement(p);
			cell1.setPaddingLeft(100);
			cell1.setBorder(Rectangle.NO_BORDER);
			table.addCell(cell1);
			cell1 = new PdfPCell();
			cell1.addElement(p);
			cell1.setPaddingLeft(100);
			cell1.setBorder(Rectangle.NO_BORDER);
			table.addCell(cell1);
			cell1 = new PdfPCell();
			cell1.addElement(p);
			cell1.setPaddingLeft(100);
			cell1.setBorder(Rectangle.NO_BORDER);
			table.addCell(cell1);
			cell1 = new PdfPCell();
			cell1.addElement(imageLogo);
			cell1.setBorder(Rectangle.NO_BORDER);
			cell1.setPaddingTop(-30);
			// cell1.setPaddingRight(-10);
			cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(cell1);
			cell1 = new PdfPCell();

			String fileName = tutorial.getName() + "_userDetails_" + new Date().getTime() + ".pdf";
			Document document = new Document(pagesize);
			PdfWriter.getInstance(document, new FileOutputStream(dir.toString() + "/" + fileName));
			document.open();
			document.add(table);

			table = new PdfPTable(2);
			addCustomRows(table, new PdfPCell(), "Name", font10pt);
			addCustomRows(table, new PdfPCell(), "" + "               " + tutorial.getName(), font10pt);
			addCustomRows(table, new PdfPCell(), "Phone No", font10pt);
			addCustomRows(table, new PdfPCell(), "" + "               " + tutorial.getPhoneNo(), font10pt);
			addCustomRows(table, new PdfPCell(), "Place", font10pt);
			addCustomRows(table, new PdfPCell(), "" + "               " + tutorial.getPlace(), font10pt);
			/*
			 * addCustomRows(table, new PdfPCell(), "Date of Birth", font10pt);
			 * addCustomRows(table, new PdfPCell(), "" + "               " +
			 * tutorial.getDob(), font10pt);
			 */ if (isFromDateToDtAvail) {
				addCustomRows(table, new PdfPCell(), "From", font10pt);
				addCustomRows(table, new PdfPCell(), "" + "               " + tutorial.getFromDate(), font10pt);
				addCustomRows(table, new PdfPCell(), "To", font10pt);
				addCustomRows(table, new PdfPCell(), "" + "               " + tutorial.getToDate(), font10pt);
			}
			table.setSpacingBefore(10);
			table.setSpacingAfter(10);
			document.add(table);
			/*
			 * document.add(new
			 * Paragraph("                                                                                                                                                                            Signature"
			 * , font10pt));
			 */
			document.close();
			File file = new File(dir.toString() + "/" + fileName);
			InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
			String src = dir.toString() + "/" + fileName;
			String dest = dir.toString() + "/" + "water_mark_" + fileName;
			String waterImg = "Swami_Avdheshanand_Giri_Ji_Maharaj.jpg";
			File waterFile = ResourceUtils.getFile("classpath:" + waterImg);
			PdfReader reader = new PdfReader(src);
			int n = reader.getNumberOfPages();
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
			// image watermark
			Image img = Image.getInstance(waterFile.getPath());
			float w = img.getScaledWidth() + 75f;
			float h = img.getScaledHeight() + 75f;
			// transparency
			PdfGState gs1 = new PdfGState();
			gs1.setFillOpacity(0.5f);
			// properties
			PdfContentByte over;
			float x, y;
			// loop over every page
			for (int i = 1; i <= n; i++) {
				pagesize = reader.getPageSizeWithRotation(i);
				x = (pagesize.getLeft() + pagesize.getRight()) / 2;
				y = (pagesize.getTop() + pagesize.getBottom()) / 2;
				over = stamper.getOverContent(i);
				over.saveState();
				over.setGState(gs1);
				/*
				 * if (i % 2 == 1) ColumnText.showTextAligned(over, Element.ALIGN_CENTER, p, x,
				 * y, 0); else
				 */
				over.addImage(img, w, 0, 0, h, x - (w / 2), y - (h / 2));
				over.restoreState();
			}
			stamper.close();
			reader.close();

			return ResponseEntity.ok()
					// Content-Disposition
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
					// Content-Type
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
					// Contet-Length
					.contentLength(file.length()) //
					.body(resource);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void addCustomRows(PdfPTable table, PdfPCell cell, String fieldValue, Font font) {
		cell.addElement(new Phrase("" + fieldValue, font));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setNoWrap(true);
		cell.setPaddingLeft(-40);
		table.addCell(cell);

	}
}
