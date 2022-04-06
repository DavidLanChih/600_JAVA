package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class ImportAndAddWatermark {
	public static void main(String[] args) {
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream("c:\\水印.pdf"));// 關聯文件對象與輸出流
			document.open();// 開啟文件
			document.add(new Paragraph("No. One.")); // 向文件中增加內容
			document.add(new Paragraph("No. Two.")); // 向文件中增加內容
			document.add(new Paragraph("No. Three.")); // 向文件中增加內容
			document.add(new Paragraph("No. Four.")); // 向文件中增加內容
			document.add(new Paragraph("No. Five.")); // 向文件中增加內容
			document.close();// 關閉文件對像
			PdfReader reader = new PdfReader("c:\\水印.pdf");// 建立「水印.pdf」的PdfReader對像
			PdfStamper stamp = new PdfStamper(reader, new FileOutputStream("c:\\匯入並增加水印.pdf"));// 建立PdfStamper對像
			Image img = Image.getInstance("image/watermark.jpg");// 寫上內容
			img.setAbsolutePosition(30, 385);// 定位圖片對像
			PdfContentByte under = stamp.getUnderContent(1);// 獲得第一頁的內容
			under.addImage(img);// 增加圖片,完成水印功能
			stamp.close();// PdfStamper對象，將從「水印.pdf」中讀取的文件增加水印後寫入「匯入並增加水印.pdf」
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
