package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ShowPageLayoutTwoColumnLeft {
    
    public static void main(String args[]) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\雙列顯示奇頁在左.pdf"));// 關聯文件對象與輸出流
            writer.setViewerPreferences(PdfWriter.PageLayoutTwoColumnLeft);// 設定閱讀器雙列顯示奇頁在左
            document.open();// 開啟文件
            document.add(new Paragraph("This is Odd Page 1"));// 向文件中增加內容
            document.newPage();// 新增第二頁
            document.add(new Paragraph("this is Even Page 2"));// 向文件中增加內容
            document.newPage();// 新增第三頁
            document.add(new Paragraph("This is Odd Page 3"));// 向文件中增加內容
            document.newPage();// 新增第四頁
            document.add(new Paragraph("This is Even Page 4"));// 向文件中增加內容
            document.close();// 關閉文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    
}
