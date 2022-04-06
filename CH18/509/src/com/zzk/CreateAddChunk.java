package com.zzk;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

public class CreateAddChunk {
	
	
	public static void main(String args[]){
		Document document = new Document();	//建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream("C:\\Java.pdf"));// 關聯文件對象與輸出流
			document.open();				//開啟文件
			Chunk chunk1 = new Chunk("Text chunk1",FontFactory.getFont(FontFactory.COURIER_BOLD,15,Font.ITALIC));// 建立塊定並義字體屬性和增加內容
			document.add(chunk1);
			Chunk chunk2 = new Chunk("Text chunk2",FontFactory.getFont(FontFactory.COURIER_BOLD,30,Font.BOLD));// 建立塊定並義字體屬性和增加內容
			document.add(chunk2);
			document.close();				//關閉文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
