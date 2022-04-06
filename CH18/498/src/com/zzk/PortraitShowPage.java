package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class PortraitShowPage {
	public static void main(String[] args) {
		Document document = new Document();// 建立文件對像設定文件大小
		try {
			PdfWriter.getInstance(document, new FileOutputStream(
					"c:\\垂直顯示頁面.pdf"));// 關聯文件對象與輸出流
			Rectangle pageSize = new Rectangle(220, 150);// 建立表示頁面大小的矩形對像,該矩形對象是水平顯示的
			pageSize = pageSize.rotate();// 轉為垂直
			document.setPageSize(pageSize); // 設定頁面大小
			document.open();// 開啟文件
			document.add(new Paragraph("Page Size"));// 向文件中增加內容
			document.close();// 關閉文件
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	}
}
