package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class SetParagraphAlignment {
	
	
	public static void main(String[] args){
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream("c:\\Java.pdf"));// 關聯文件對象與輸出流
			document.open();// 開啟文件
			Paragraph paragraph1 = new Paragraph("www.mingrosoft.com");// 建立段落並增加內容
			paragraph1.setAlignment(Element.ALIGN_LEFT); // 左對齊
			document.add(new Paragraph(paragraph1));     // 向文件增加段落	
			Paragraph paragraph2 = new Paragraph("www.mingribook.com");// 建立段落並增加內容
			paragraph2.setAlignment(Element.ALIGN_RIGHT);// 右對齊
			document.add(new Paragraph(paragraph2));	 // 向文件增加段落
					
			Paragraph paragraph3 = new Paragraph("www.mingribccd.com"); // 建立段落並增加內容
			paragraph3.setAlignment(Element.ALIGN_CENTER);// 居中對齊 
			document.add(new Paragraph(paragraph3));	  // 向文件增加段落	
			document.close();// 關閉文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	 }
}

