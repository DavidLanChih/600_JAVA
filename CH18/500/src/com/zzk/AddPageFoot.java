package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class AddPageFoot {
	public static void main(String[] args){
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream("c:\\頁眉頁腳.pdf"));// 關聯文件對象與輸出流
			document.open();// 開啟文件
			document.add(new Paragraph("Add Page Top And Foot.")); // 向文件中增加內容
			document.close();// 關閉文件對像
			PdfReader reader = new PdfReader("c:\\頁眉頁腳.pdf");// 建立「頁眉頁腳.pdf」的PdfReader對像
			PdfStamper stamp = new PdfStamper(reader, new FileOutputStream("c:\\增加頁眉頁腳.pdf"));// 建立PdfStamper對像
			PdfContentByte over = stamp.getOverContent(1);// 獲得第一頁的內容
			over.setTextRise(810);// 純文字上移到810的位置
			over.beginText();// 標記純文字開始
			BaseFont chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);			over.setFontAndSize(chinese, 18);// 設定字體和字號
			over.showText("                                           頁眉的內容");// 增加頁眉
			over.endText();// 標記純文字結束
			stamp.insertPage(2, PageSize.A4);// 增加新的一頁，為新頁增加頁腳
			PdfContentByte under = stamp.getUnderContent(2);// 獲得第二頁的內容
			under.setTextRise(15);// 純文字上移到15的位置
			under.beginText();// 標記純文字開始
			under.setFontAndSize(chinese, 18);// 設定字體和字號
			under.showText("                                          頁腳的內容");// 增加頁腳
			under.endText();// 標記純文字結束
			stamp.close();// PdfStamper對象，將從「頁眉頁腳.pdf」中讀取的文件增加頁眉頁腳後寫入「增加頁眉頁腳.pdf」
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