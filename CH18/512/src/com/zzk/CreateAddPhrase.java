package com.zzk;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class CreateAddPhrase {
	public static void main(String args[]){
		Document document = new Document();		//建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream("c:\\book.pdf"));// 關聯對象與輸出流
			document.open();// 開啟文件	
			Phrase phrase1 = new Phrase("BeiJing Olympics");// 建立子句並增加內容
			document.add(phrase1);
			Phrase phrase2 = new Phrase("One world, one dream!");// 建立子句並增加內容
			document.add(phrase2);
			document.close();// 關閉文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
}

