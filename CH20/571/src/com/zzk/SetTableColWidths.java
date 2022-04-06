package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class SetTableColWidths {
    
    public static void main(String[] args) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\設定表格的列寬.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            BaseFont Chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 定義基本字體
            Font FontChinese = new Font(Chinese, 10, Font.NORMAL,
                    new BaseColor(90, 90, 90));// 實例化字體
            float[] widths = { 0.05f, 0.10f, 0.30f, 0.55f };// 設定列寬相比較例為
                                                            // 5%,10%,30%,55%
            PdfPTable table = new PdfPTable(widths);// 建立表格關聯列寬
            table.addCell(new Paragraph("列寬為5%", FontChinese));// 將單元格順次的加入到表格，當一行充滿時自動換行
            table.addCell(new Paragraph("列寬為10%", FontChinese));
            table.addCell(new Paragraph("列寬為30%", FontChinese));
            table.addCell(new Paragraph("列寬為55%", FontChinese));
            table.addCell("w");
            table.addCell("1");
            table.addCell("2");
            table.addCell("3");
            table.addCell("h");
            table.addCell("1");
            table.addCell("2");
            table.addCell("3");
            table.addCell("s");
            table.addCell("1");
            table.addCell("2");
            table.addCell("3");
            document.add(table);// 將表格增加到文件
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