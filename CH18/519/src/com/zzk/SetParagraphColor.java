package com.zzk;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class SetParagraphColor {
	public static void main(String[] args){
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream("c:\\Java類別庫參考手冊.pdf"));// 關聯文件對象與輸出流
			document.open();// 開啟文件
			Paragraph paragraph = new Paragraph(new Paragraph("JFrame Class Member List",FontFactory.getFont(FontFactory.HELVETICA, 30, BaseColor.BLUE )));// 建立段落定義字體並增加內容
			paragraph.setFirstLineIndent(100); // 設定段落首先縮排
			document.add(paragraph);// 向文件增加段落
			document.close();// 關閉文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
