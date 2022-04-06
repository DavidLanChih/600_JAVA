package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class AddandCreateDate {
	public static void main(String args[]){
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream("c:\\Java編程詞典.pdf"));// 關聯文件對象與輸出流
			document.addAuthor("明日科技");	//增加作者
			document.addCreationDate();// 建立日期
			document.open();// 開啟文件
			document.add(new Paragraph("CreateDate"));// 向文件中增加內容
			document.close();// 關閉文件
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
