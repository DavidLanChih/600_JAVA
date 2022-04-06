package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;


public class BoldFontDocumentDemo {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter.getInstance(document, new FileOutputStream("c:\\Java.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            BaseFont bfChinese = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);// 定義基本字體
            Font contentFont = new Font(bfChinese, 12, Font.BOLD);// 定義粗體字體
            document.add(new Paragraph("www.mingribccd.com",contentFont));// 向文件中增加內容並指定粗體字體
            document.add(new Paragraph("www.mingribook.com"));
            document.close();// 關閉文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
