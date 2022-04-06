package com.zzk;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class AbsoluteOrientationTable {
    public static void main(String[] args) {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("c:\\絕對定位表格.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            float[] columnSize = { 21F, 21F, 21F };// 設定列寬
            PdfPTable table = null;
            PdfPCell cell = null;
            table = new PdfPTable(columnSize);// 定義新表格
            table.getDefaultCell().setBorder(1);// 設定表格邊框寬度
            table.setHorizontalAlignment(Element.ALIGN_CENTER);// 設定居中對齊
            table.setTotalWidth(500); // 設定總寬度500
            table.setLockedWidth(true); // 解鎖
            cell = new PdfPCell(new Phrase("Add table"));// 定義單元格
            cell.setColspan(3);// 設定單元格跨度3
            table.addCell(cell);// 向表格增加單元格
            table.addCell(new PdfPCell(new Phrase("Add 001")));// 向表格增加內容
            table.addCell(new PdfPCell(new Phrase("Add 002")));// 向表格增加內容
            table.addCell(new PdfPCell(new Phrase("Add 003")));// 向表格增加內容
            document.add(table);// 向文件增加表格
            table = new PdfPTable(columnSize);
            // 定義新表格
            table.getDefaultCell().setBorder(1);// 設定表格邊框寬度
            table.setHorizontalAlignment(Element.ALIGN_CENTER);// 設定居中對齊
            table.setTotalWidth(500);// 設定總寬度500
            table.setLockedWidth(true);// 解鎖
            cell = new PdfPCell(new Phrase("Table writeSelectedRows"));// 定義單元格
            cell.setColspan(columnSize.length);// 設定單元格跨度3
            table.addCell(cell); // 向表格增加單元格
            table.addCell(new PdfPCell(new Phrase("Add 004")));// 向表格增加內容
            table.addCell(new PdfPCell(new Phrase("Add 005")));// 向表格增加內容
            table.addCell(new PdfPCell(new Phrase("Add 006")));// 向表格增加內容
            table.writeSelectedRows(0, 2, 50, 750, writer.getDirectContent());// 在指定位置增加表格內容
            document.close();// 關閉文件
        } catch (DocumentException de) {
        } catch (IOException ioe) {
            
        }
        
    }
}
