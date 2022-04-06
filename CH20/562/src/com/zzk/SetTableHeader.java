package com.zzk;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class SetTableHeader {
    
    public static void main(String[] args) {
        Cell cell0 = null;// 定義單元格
        Cell cell1 = null;
        Cell cell2 = null;
        Cell cell3 = null;
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\設定表格的表頭.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            BaseFont Chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 定義基本字體
            Font FontChinese = new Font(Chinese, 12, Font.NORMAL);// 實例化字體
            Table table = new Table(4);// 定義表格
            cell0 = new Cell(new Paragraph("編號", FontChinese));// 建立單元格
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER);// 設定水平居中對齊
            cell0.setVerticalAlignment(Element.ALIGN_CENTER);// 設定垂直居中對齊
            cell0.setBackgroundColor(Color.GRAY);// 設定背景顏色
            cell0.setHeader(true);// 將單元格設定為表頭
            cell1 = new Cell(new Paragraph("姓名", FontChinese)); // 建立單元格
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);// 設定水平居中對齊
            cell1.setVerticalAlignment(Element.ALIGN_CENTER);// 設定垂直居中對齊
            cell1.setBackgroundColor(Color.GRAY);// 設定背景顏色
            cell1.setHeader(true);// 將單元格設定為表頭
            cell2 = new Cell(new Paragraph("年齡", FontChinese)); // 建立單元格
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);// 設定水平居中對齊
            cell2.setVerticalAlignment(Element.ALIGN_CENTER);// 設定垂直居中對齊
            cell2.setBackgroundColor(Color.GRAY);// 設定背景顏色
            cell2.setHeader(true);// 將單元格設定為表頭
            cell3 = new Cell(new Paragraph("電話", FontChinese)); // 建立單元格
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);// 設定水平居中對齊
            cell3.setVerticalAlignment(Element.ALIGN_CENTER);// 設定垂直居中對齊
            cell3.setBackgroundColor(Color.GRAY);// 設定背景顏色
            cell3.setHeader(true);// 將單元格設定為表頭
            // 向表格增加單元格
            table.addCell(cell0);
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.setPadding(4);// 設定內容與單元格間距
            for (int i = 1; i <= 3; i++) {// 向表格的單元格增加內容
                table.addCell(new Paragraph("95**0" + i));
                table.addCell(new Paragraph("李*輝", FontChinese));
                table.addCell(new Paragraph("30"));
                table.addCell(new Paragraph("0431-2222****"));
            }
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