package zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class AddUnderline {
	
	
	public static void main(String[] args){
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream("C:\\明日科技簡介.pdf"));// 關聯文件對象與輸出流
			document.open();// 開啟文件
			document.add(new Paragraph("Generalize"));// 向文件中增加內容
			document.add(new Paragraph("Welcome to GuangZhou！", FontFactory.getFont(FontFactory.HELVETICA,15,Font.UNDERLINE)));// 向文件中增加內容
			document.close();// 關閉文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}

