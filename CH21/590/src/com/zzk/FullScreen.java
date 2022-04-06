package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class FullScreen {
    
    public static void main(String args[]) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\全螢幕顯示.pdf"));// 關聯文件對象與輸出流
            writer.setViewerPreferences(PdfWriter.PageModeFullScreen);// 設定閱讀器以全螢幕模式顯示
            document.open();// 開啟文件
            document.add(new Paragraph("PageModelFullScreen."));// 向文件中增加內容
            document.close();// 關閉文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
