package com.zzk;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class InsertTable {
    
    public static void main(String[] args) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\嵌套表格.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            BaseFont Chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 定義基本字體
            Font FontChinese = new Font(Chinese, 10, Font.BOLDITALIC,
                    Color.BLUE);// 實例化字體
            Font font = new Font(Chinese, 10, Font.NORMAL);
            Table table1 = new Table(3);// 建立表格
            Cell cell = new Cell(new Paragraph("嵌入的表一", FontChinese));// 建立單元格
            cell.setColspan(3);// 設定列跨度
            // 單元格添入到表格行滿自動換行
            table1.addCell(cell);
            table1.addCell(new Paragraph("表一 0.0", FontChinese));
            table1.addCell(new Paragraph("表一 0.1", FontChinese));
            table1.addCell(new Paragraph("表一 0.2", FontChinese));
            table1.addCell(new Paragraph("表一 1.0", FontChinese));
            table1.addCell(new Paragraph("表一 1.1", FontChinese));
            table1.addCell(new Paragraph("表一 1.2", FontChinese));
            Table table2 = new Table(2);// 建立表格
            // 單元格添入到表格，行滿自動換行
            table2.addCell(new Paragraph("表二 0.0", FontChinese));
            table2.addCell(new Paragraph("表二0.1", FontChinese));
            table2.addCell(new Paragraph("表二 1.0", FontChinese));
            table2.addCell(new Paragraph("表二 1.1", FontChinese));
            Cell tableCell = new Cell(new Paragraph("使用Cell嵌入的表二", FontChinese));// 建立一個單元格
            tableCell.add(table2);// 將表格增加到單元格
            Table table3 = new Table(5, 5);// 建立5行5列的原表
            table3.insertTable(table1); // 將第一個表格嵌入到原表中第一列
            // 單元格添入到表格行滿自動換行
            table3.addCell(new Paragraph("原表1.1", font));
            table3.addCell(new Paragraph("原表1.2", font));
            table3.addCell(new Paragraph("原表1.3", font));
            table3.setPadding(5);// 設定填充值為5
            table3.addCell(tableCell);// 增加單元格，實現第二個表格的嵌入
            document.add(table3);// 向文件中增加原表
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