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

public class SetCellRowspan {
    
    public static void main(String[] args) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\設定單元格所佔的行數.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            BaseFont Chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 定義基本字體
            Font FontChinese = new Font(Chinese, 10, Font.NORMAL, Color.red);// 實例化字體
            Table table = new Table(5);// 定義表格
            table.addCell("1.1");// 將單元格順次的加入到表格，當一行充滿時自動換行
            table.addCell("2.1");
            Cell cell = new Cell(new Paragraph("我佔據4行", FontChinese));// 定義一個表格單元
            cell.setRowspan(4);// 設定表格行跨度(合併4個單元格)
            table.addCell(cell); // 將單元加入到表格
            table.addCell("2.1"); // 將單元格順次的加入到表格，當一行充滿時自動換行
            table.addCell("2.2");
            table.addCell("3.2");
            table.addCell("1.3");
            table.addCell("2.3");
            table.addCell("3.3");
            Cell cell2 = new Cell(new Paragraph("我佔據3行 ", FontChinese));// 定義一個表格單元
            cell2.setRowspan(3);// 設定表格行跨度(合併3個單元格)
            table.addCell(cell2); // 將單元加入到表格
            table.addCell("3.1"); // 將單元格順次的加入到表格，當一行充滿時自動換行
            table.addCell("2.1");
            table.addCell("2.2");
            table.addCell("3.2");
            table.addCell("1.3");
            table.addCell("2.3");
            table.addCell("3.3");
            table.addCell("1.3");
            table.addCell("2.3");
            table.addCell("3.3");
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