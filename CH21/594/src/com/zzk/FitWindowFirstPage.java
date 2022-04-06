package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class FitWindowFirstPage {
    
    public static void main(String[] args) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\使文件視窗適合顯示第一頁.pdf"));// 關聯文件對象與輸出流
            writer.setViewerPreferences(PdfWriter.FitWindow);// 設定閱讀器適合顯示第一頁
            document.open();// 開啟文件
            for (int i = 1; i <= 100; i++) {
                document.add(new Paragraph("Fit show Page 1. row " + i));// 向文件中增加段落內容
            }
            document.close();// 關閉文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
