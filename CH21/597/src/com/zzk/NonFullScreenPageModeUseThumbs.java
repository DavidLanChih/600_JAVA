package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class NonFullScreenPageModeUseThumbs {
    
    public static void main(String args[]) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\全螢幕模式下顯示縮圖.pdf"));// 關聯文件對象與輸出流
            writer.setViewerPreferences(PdfWriter.PageModeFullScreen);// 設定為全螢幕模式
            writer
                    .setViewerPreferences(PdfWriter.NonFullScreenPageModeUseThumbs);// 設定閱讀器在全螢幕模式下顯示縮圖
            document.open();// 開啟文件
            BaseFont Chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);   
            Font fontChinese1 = new Font(Chinese, 18, Font.BOLDITALIC,BaseColor.RED);// 實例化字體類別、設定字體大小和顏色
            Font fontChinese2 = new Font(Chinese, 15, Font.BOLDITALIC,BaseColor.BLUE);// 實例化字體類別、設定字體大小和顏色
            Paragraph paragraph = new Paragraph("章節",fontChinese1);// 建立段落對像
            Chapter chapter = new Chapter(paragraph,1);// 建立章節對像
            paragraph = new Paragraph("小節一",fontChinese2);// 建立段落對像
            chapter.addSection(paragraph);// 增加小節
            paragraph = new Paragraph("小節二",fontChinese2);// 建立段落對像
            chapter.addSection(paragraph);// 增加小節
            document.add(chapter);// 向文件增加章節
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