package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class TransverseShowPage {

	public static void main(String[] args) {
		Document document = new Document();// 建立文件對像設定文件大小
		try {
			PdfWriter.getInstance(document, new FileOutputStream("c:\\水平顯示頁面.pdf"));// 關聯文件對象與輸出流
			Rectangle pageSize= new Rectangle(150,220);// 設定頁面大小
			pageSize = pageSize.rotate();
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