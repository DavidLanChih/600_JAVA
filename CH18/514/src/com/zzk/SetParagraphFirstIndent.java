package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class SetParagraphFirstIndent {
	public static void main(String[] args){
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream("c:\\公司簡介.pdf"));// 關聯文件對象與輸出流
			document.open();// 開啟文件
			Paragraph P1 = new Paragraph("MR company was builded in 1999!");// 建立段落並增加內容
			P1.setFirstLineIndent(20); 		//設定段落首先縮排
			document.add(new Paragraph(P1));//向文件增加段落
			Paragraph P2 = new Paragraph("Company own about for fifty employees.");//建立段落並增加內容
			document.add(P2);		//向文件增加段落
			document.close();		//關閉文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
