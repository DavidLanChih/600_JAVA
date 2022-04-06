package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class SetParagraphSpacingAfter {
	public static void main(String[] args){
		Document document = new Document();		//建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream("c:\\Java.pdf"));// 關聯文件對象與輸出流
			document.open();					//開啟文件
			Paragraph paragraph1 = new Paragraph("Java resource");	//建立段落增加內容
			paragraph1.setSpacingBefore(10); 	//設定段落上邊距
			paragraph1.setSpacingAfter(30); 	//設定段落下邊距
			document.add(paragraph1);			//向文件增加段落
			Paragraph paragraph2 = new Paragraph("Java classes introduce");			//建立段落增加內容
			paragraph2.setSpacingAfter(30); 	//設定段落下邊距
			document.add(paragraph2);			//向文件增加段落
			document.close();					//關閉文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
