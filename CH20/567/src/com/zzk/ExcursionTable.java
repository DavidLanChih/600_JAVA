package com.zzk;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class ExcursionTable {
    
    public static void main(String[] args) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\偏移表格.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            BaseFont Chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 定義基本字體
            Font FontChinese = new Font(Chinese, 10, Font.NORMAL);// 實例化字體
            Table table = new Table(3);// 建立表格
            table.setBorderWidth(1);// 設定表格邊框寬度
            table.setBorderColor(Color.blue);// 設定表格邊框顏色
            table.setSpacing(5);// 設定表格與單元格的間距
            table.setPadding(5);// 設定單元格與內容的間距
            table.addCell("1.1");// 增加單元格
            table.addCell("1.2");
            table.addCell("1.3");
            document
                    .add(new Paragraph("                     原表格。", FontChinese));// 向文件增加內容
            document.add(table);// 向文件增加表格
            document.add(new Paragraph("                     預設的距離。",
                    FontChinese));
            document.add(table);
            document.add(new Paragraph("                     設定表格偏移值為0的距離。",
                    FontChinese));
            table.setOffset(0);// 設定表格偏移數值
            document.add(table);
            document.add(new Paragraph("                     設定表格偏移值為-15的距離。",
                    FontChinese));
            table.setOffset(-15);// 設定表格偏移數值
            document.add(table);
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