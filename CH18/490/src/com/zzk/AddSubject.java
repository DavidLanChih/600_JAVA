package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class AddSubject {

	public static void main(String[] args) {
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream(
					"C:\\增加PDF文件主題.pdf"));// 關聯文件對象與輸出流
			document.addSubject("學習iText的使用");// 向文件中增加主題
			document.open();// 開啟文件
			document.add(new Paragraph("Subject"));// 向文件中增加內容
			document.close();// 關閉文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
