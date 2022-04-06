package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class CreateAddParagraph {
	public static void main(String[] args){
		Document document = new Document();	//建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream("c:\\Java編程詞典.pdf"));	//關聯文件對象與輸出流
			document.open();				//開啟文件
			Paragraph P1 = new Paragraph("Java programming dictionary");	
			//建立段落並增加內容
			document.add(P1);		//向文件增加段落
			Paragraph P2 = new Paragraph("The richest resource for learning");
			document.add(P2);		//向文件增加段落		
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (DocumentException e) {
				e.printStackTrace();
		}
		finally{
			document.close();		//關閉文件	
		}
	}
}
