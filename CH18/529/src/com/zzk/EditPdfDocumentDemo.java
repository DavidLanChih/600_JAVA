package com.zzk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class EditPdfDocumentDemo {
	public static void main(String[] args) {
		createOldFile();// 建立原檔案
		editOldFile();// 編輯原檔案
	}

	public static void createOldFile() {// 建立原檔案的方法
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter
					.getInstance(document, new FileOutputStream("c:\\原文件.pdf"));// 關聯文件對象與輸出流
			document.open();// 開啟文件
			document.add(new Paragraph("First")); // 向文件中增加內容
			document.newPage();
			document.add(new Paragraph("Second")); // 向文件中增加內容
			document.newPage();
			document.add(new Paragraph("Third")); // 向文件中增加內容
			document.close();// 關閉文件對像
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static void editOldFile() {// 編輯原檔案的方法
		try {
			PdfReader reader = new PdfReader("c:\\原文件.pdf");// 建立「原文件.pdf」的PdfReader對像
			int totalPages = reader.getNumberOfPages();// 獲得總頁數
			PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(
					"c:\\編輯後文件的臨時檔案.pdf"));// 建立PdfStamper對像
			BaseFont chinese = BaseFont.createFont("STSong-Light",
					"UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);// 定義字體
			PdfContentByte under = null;
			for (int i = 1; i <= totalPages; i++) {
				under = stamp.getUnderContent(i);// 獲得每一頁的內容
				under.beginText();// 標記純文字開始
				under.setFontAndSize(chinese, 18);// 設定字體和字號
				under.setTextMatrix(200, 810);// 設定頁碼的顯示位置
				under.showText("第" + i + "頁");// 增加頁腳
				under.endText();// 標記純文字結束
				under.beginText();// 標記純文字開始
				under.setFontAndSize(chinese, 32);// 設定字體和字號
				under.setTextMatrix(100, 750);// 設定純文字的顯示位置
				under.showText("新增加的內容" + i);// 增加新純文字
				under.endText();// 標記純文字結束
			}
			stamp.close();// PdfStamper對象，將從「原文件.pdf」中讀取的文件增加頁碼後寫入「編輯後文件的臨時檔案.pdf」
			File oldFile = new File("c:\\原文件.pdf");// 建立原檔案的File對像
			oldFile.delete();// 刪除原檔案
			File tempFile = new File("c:\\編輯後文件的臨時檔案.pdf");// 建立臨時檔案的File對像
			tempFile.renameTo(oldFile);// 重命名臨時檔案為原檔案名
			tempFile.delete();// 刪除臨時檔案
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