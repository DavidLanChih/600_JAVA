package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class SetAbsoluteWidth {
    
    public static void main(String[] args) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\設定絕對寬度.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            BaseFont Chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 定義基本字體
            Font FontChinese = new Font(Chinese, 10, Font.NORMAL);// 實例化字體
            PdfPTable table1 = new PdfPTable(3);// 定義表格
            PdfPCell cell1 = new PdfPCell(new Paragraph("new table colspan 3"));// 定義一個表格單元
            cell1.setColspan(3);// 設定表格跨度
            table1.addCell(cell1);// 將單元加入到表格
            table1.addCell("1.1");// 將單元格順次的加入到表格，當一行充滿時自動換行
            table1.addCell("2.1");
            table1.addCell("3.1");
            table1.addCell("1.2");
            table1.addCell("2.2");
            table1.addCell("3.2");
            table1.addCell("1.3");
            table1.addCell("2.3");
            table1.addCell("3.3");
            PdfPTable table2 = new PdfPTable(3);// 定義表格
            PdfPCell cell2 = new PdfPCell(new Paragraph("new table colspan 3"));// 定義一個表格單元
            cell2.setColspan(3);// 設定表格跨度
            table2.addCell(cell2);// 將單元加入到表格
            table2.addCell("1.1");// 將單元格順次的加入到表格，當一行充滿時自動換行
            table2.addCell("2.1");
            table2.addCell("3.1");
            table2.addCell("1.2");
            table2.addCell("2.2");
            table2.addCell("3.2");
            table2.addCell("1.3");
            table2.addCell("2.3");
            table2.addCell("3.3");
            table2.setTotalWidth(200);// 設定表格寬度為200
            table2.setLockedWidth(true);// 鎖定寬度
            document.add(new Paragraph("                  預設的表格\n\n", FontChinese));
            document.add(table1);// 將表格增加到文件
            document.add(new Paragraph("                  設定表格寬度200",
                    FontChinese));
            document.add(table2);// 將表格增加到文件
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