package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class SetTableAllignment {
    
    public static void main(String[] args) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\設定表格對齊方式.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            BaseFont Chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 定義基本字體
            Font FontChinese = new Font(Chinese, 10, Font.BOLD);// 實例化字體
            PdfPTable table = new PdfPTable(3);// 定義表格
            table.setTotalWidth(200);// 設定表格寬度為200
            table.setLockedWidth(true);
            PdfPCell cell = new PdfPCell(new Paragraph("new table colspan 3"));// 定義一個表格單元
            cell.setColspan(3);// 設定表格跨度
            table.addCell(cell);// 將單元加入到表格
            // 將單元格順次的加入到表格，當一行充滿時自動換行
            table.addCell("1.1");
            table.addCell("2.1");
            table.addCell("3.1");
            table.setHorizontalAlignment(Element.ALIGN_LEFT);// 設定水平對齊方式 居左
            
            PdfPTable table1 = new PdfPTable(3);// 定義表格
            table1.setTotalWidth(200);// 設定表格寬度為200
            table1.setLockedWidth(true);
            PdfPCell cell2 = new PdfPCell(new Paragraph("new table colspan 3"));// 定義一個表格單元
            cell2.setColspan(3);// 設定表格跨度
            table1.addCell(cell2);// 將單元加入到表格
            // 將單元格順次的加入到表格，當一行充滿時自動換行
            table1.addCell("1.1");
            table1.addCell("2.1");
            table1.addCell("3.1");
            table1.setHorizontalAlignment(Element.ALIGN_CENTER);// 設定水平對齊方式 居中
            PdfPTable table2 = new PdfPTable(3);// 定義表格
            table2.setTotalWidth(200);// 設定表格寬度為200
            table2.setLockedWidth(true);
            PdfPCell cell3 = new PdfPCell(new Paragraph("new table colspan 3"));// 定義一個表格單元
            cell3.setColspan(3);// 設定表格跨度
            table2.addCell(cell2);// 將單元加入到表格
            // 將單元格順次的加入到表格，當一行充滿時自動換行
            table2.addCell("1.1");
            table2.addCell("2.1");
            table2.addCell("3.1");
            table2.setHorizontalAlignment(Element.ALIGN_RIGHT);// 設定水平對齊方式 居右
            Paragraph p = new Paragraph("表格居左對齊\n\n", FontChinese);
            p.setAlignment(Element.ALIGN_LEFT);
            document.add(p);// 向文件增加內容
            document.add(table);// 將表格增加到文件
            Paragraph p2 = new Paragraph("表格居中對齊\n\n", FontChinese);
            p2.setAlignment(Element.ALIGN_CENTER);
            document.add(p2);// 向文件增加內容
            document.add(table1);// 將表格增加到文件
            Paragraph p3 = new Paragraph("表格居右對齊\n\n", FontChinese);
            p3.setAlignment(Element.ALIGN_RIGHT);
            document.add(p3);// 向文件增加內容
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