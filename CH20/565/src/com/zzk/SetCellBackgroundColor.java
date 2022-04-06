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

public class SetCellBackgroundColor {
    
    public static void main(String[] args) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\設定單元格的背景色.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            BaseFont Chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 定義基本字體
            Font FontChinese = new Font(Chinese, 12, Font.NORMAL);// 實例化字體
            document
                    .add(new Paragraph("                 為單元格填充顏色", FontChinese));
            Table table = new Table(5);// 定義表格
            table.addCell("1.1");// 將單元格順次的加入到表格，當一行充滿時自動換行
            table.addCell("2.1");
            table.addCell("3.1");
            table.addCell("2.1");
            table.addCell("2.2");
            Cell cell = new Cell();// 建立單元格
            cell.setBackgroundColor(Color.yellow);// 為單元格填充背景色
            table.addCell(cell); // 將單元格填入到表格
            table.addCell("1.3");
            table.addCell("2.3");
            Cell cell2 = new Cell();// 建立單元格
            cell2.setBackgroundColor(Color.red);// 為單元格填充背景色
            table.addCell(cell2);
            table.addCell("3.0");
            table.addCell("3.1");
            table.addCell("2.1");
            Cell cell3 = new Cell();// 建立單元格
            cell3.setBackgroundColor(Color.green);// 為單元格填充背景色
            table.addCell(cell3);
            table.addCell("3.2");
            table.addCell("1.3");
            table.addCell("2.3");
            Cell cell4 = new Cell();// 建立單元格
            cell4.setBackgroundColor(Color.red);// 為單元格填充背景色
            table.addCell(cell4); // 將單元格填入到表格
            table.addCell("2.1");
            table.addCell("2.2");
            Cell cell5 = new Cell();// 建立單元格
            cell5.setBackgroundColor(Color.blue);// 為單元格填充背景色
            table.addCell(cell5); // 將單元格填入到表格
            table.addCell("1.3");
            table.addCell("2.3");
            table.addCell("3.3");
            table.addCell("3.0");
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