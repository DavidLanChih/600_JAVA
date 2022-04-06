package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class SetParagraphLeftRightIndent {
	
	
	public static void main(String[] args){
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream("C:\\Java編程詞典.pdf"));// 關聯文件對象與輸出流
			document.open();// 開啟文件
			Paragraph paragraph1 = new Paragraph("The Paragraph IndentLeft");// 實例化段落並增加內容
			paragraph1.setIndentationLeft(100);// 段落左縮排
			document.add(paragraph1);// 向文件中增加段落
			Paragraph paragraph2 = new Paragraph("The Paragraph IndentRight");// 實例化段落並增加內容
			paragraph2.setIndentationRight(100);// 段落右縮排
			document.add(paragraph2);// 向文件中增加段落
			document.close();// 關閉文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}