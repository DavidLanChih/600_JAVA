package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CreateNewPage {
    
    public static void main(String[] args) {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\建立新頁.pdf"));// 關聯文件與輸出流
            document.open();// 開啟文件
            document.add(new Paragraph("Old Page"));// 為第一頁增加內容
            document.newPage();// 建立新的頁
            document.add(new Paragraph("New Page"));// 為新頁增加內容
            document.close();// 關閉文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
