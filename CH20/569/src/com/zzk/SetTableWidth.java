package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class SetTableWidth {
    
    public static void main(String[] args) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\設定表格寬度.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            float[] widths = { 0.05f, 0.10f, 0.30f, 0.55f };// 設定列寬相關比率為5%,10%,30%,55%
            PdfPTable table = new PdfPTable(widths);// 建立表格關聯列寬
            table.setWidthPercentage(60);// 為表格設定百分比寬度
            // 將單元格順次的加入到表格，當一行充滿時自動換行
            table.addCell("5%");
            table.addCell("10%");
            table.addCell("30%");
            table.addCell("55%");
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
        }
    }
}
