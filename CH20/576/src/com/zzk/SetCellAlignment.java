package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class SetCellAlignment {
    
    public static void main(String[] args) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\設定單元格的對齊方式.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            PdfPTable table = new PdfPTable(2);// 定義表格
            Paragraph p = new Paragraph("I think Bale will win");// 定義段落和內容
            table.addCell("alignment left");// 向單元格增加內容
            PdfPCell cell = new PdfPCell(p);// 定義單元格
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);// 設定單元格水平向左對齊
            table.addCell(cell);
            table.addCell("alignment right");// 向單元格增加內容
            PdfPCell cell1 = new PdfPCell(p);// 定義單元格
            cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);// 設定單元格水平向右對齊
            table.addCell(cell1);
            table.addCell("alignment justified");// 向單元格增加內容
            PdfPCell cell2 = new PdfPCell(p);// 定義單元格
            cell2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);// 設定單元格為合理的對齊方式
            table.addCell(cell2);
            table.addCell("alignment center");// 向單元格增加內容
            PdfPCell cell3 = new PdfPCell(p);// 定義單元格
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);// 設定單元格水平向中間對齊
            table.addCell(cell3);
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