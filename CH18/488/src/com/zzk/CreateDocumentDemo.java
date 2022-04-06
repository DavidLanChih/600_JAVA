package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CreateDocumentDemo {
    
    /**
     * @param args
     */
	public static void main(String[] args) {
        try {
            Document document = new Document();				// 建立文件對像
            PdfWriter.getInstance(document, new FileOutputStream("c:\\建立第一個PDF文件.pdf"));// 關聯文件對象與輸出流
            document.open();							// 開啟文件
            document.add(new Paragraph("First Document."));		// 向文件中增加內容
            document.add(new Paragraph("Success."));			// 向文件中增加內容
            document.close();							// 關閉文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        
    }

}
