package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfInsertTable {
    public static void main(String[] args) {
        
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(
                    "c:\\Pdf嵌套表格.pdf"));
            document.open();// 開啟文件
            PdfPTable table = new PdfPTable(4);// 建立表格對像
            PdfPTable table1 = new PdfPTable(2);// 建立表格對像
            table1.addCell("1.1");// 增加單元格內容
            table1.addCell("1.2");// 增加單元格內容
            PdfPTable table2 = new PdfPTable(1);// 建立表格對像
            table2.addCell("2.1");// 增加單元格內容
            table2.addCell("2.2");// 增加單元格內容
            table.addCell("table1");// 增加單元格內容
            table.addCell("table2");// 增加單元格內容
            table.addCell("text");// 增加單元格內容
            table.addCell("text");// 增加單元格內容
            table.addCell(table1);// 增加嵌套的表格
            table.addCell(table2);// 增加嵌套的表格
            table.addCell("cell");// 增加單元格內容
            table.addCell("cell");// 增加單元格內容
            document.add(table);// 將表格增加到文件中
            document.close();// 關閉文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    
}
