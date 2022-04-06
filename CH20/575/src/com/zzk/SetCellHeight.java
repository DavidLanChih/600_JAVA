package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class SetCellHeight {
    
    public static void main(String[] args) {
        
        try {
            Font font = FontFactory.getFont("COURIER", 10, Font.BOLD);// 定義一個字體
            Font xfont = FontFactory.getFont("HELVETICA", 10, Font.BOLD);// 定義一個字體
            Document document = new Document();// 建立文件對像
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\設定單元格的高度.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            PdfPTable table = new PdfPTable(2);// 定義表格
            table.getDefaultCell().setBackgroundColor(BaseColor.ORANGE);
            table.addCell(new Paragraph("default height", xfont));// 向表格增加單元格
            PdfPCell cell = new PdfPCell(new Paragraph("AAA", font));// 定義一個表格單元
            table.addCell(cell);// 向表格增加單元格
            table.addCell(new Paragraph("set height", xfont));
            PdfPCell cell2 = new PdfPCell(new Paragraph("ABC", font));// 定義單元格
            cell2.setFixedHeight(60);// 設定單元格高度為60
            table.addCell(cell2);// 將單元加入到表格
            table.addCell(new Paragraph("minimum height", xfont));
            PdfPCell cell3 = new PdfPCell(new Paragraph(
                    "A cat may look at a king.", font));// 定義單元格
            cell3.setMinimumHeight(40);// 設定單元格高度為40
            table.addCell(cell3);// 將單元加入到表格
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