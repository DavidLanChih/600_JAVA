package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class SetCellPadSpacing {
    
    public static void main(String[] args) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\設定單元格的填充和行間距.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            PdfPTable table = new PdfPTable(2);// 定義表格
            table.addCell("no Padding");// 向單元格增加內容
            table.addCell("MingRiCompany MingRi MingRiCompany");// 單元格填充前內容
            table.addCell("Set Padding");// 向單元格增加內容
            table.getDefaultCell().setPadding(24);// 向單元格設定填充24
            table.addCell("MingRi MingRiCompany");// 單元格填充後內容
            document.add(table);// 將表格增加到文件
            PdfPTable table1 = new PdfPTable(2);// 定義表格
            table1.addCell("no Leading");// 向單元格增加內容
            table1
                    .addCell("MingRi MingRi MingRiCompanyMingRiCompany MingRiCompany");// 增加行間距前內容
            table1.getDefaultCell().setLeading(12, 1);// 增加行間距
            table1.addCell("Set Leading");// 向單元格增加內容
            table1
                    .addCell("MingRi MingRi MingRiCompanyMingRiCompany MingRiCompany");// 增加行間距後內容
            document.add(table1);// 將表格增加到文件
            document.close();// 關閉文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
