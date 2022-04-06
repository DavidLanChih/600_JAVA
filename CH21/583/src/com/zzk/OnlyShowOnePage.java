package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class OnlyShowOnePage {
    
    public static void main(String[] args) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\只顯示一個頁面.pdf"));// 關聯文件對象與輸出流
            writer.setViewerPreferences(PdfWriter.PageLayoutSinglePage);// 設定閱讀器只顯示一個頁面
            document.open();// 開啟文件
            document.add(new Paragraph("PageLayoutSinglePage 1"));// 向文件中增加內容
            document.newPage();// 增加新頁
            document.add(new Paragraph("PageLayoutSinglePage 2"));// 向文件中增加內容
            document.close();// 關閉文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        
    }
}
