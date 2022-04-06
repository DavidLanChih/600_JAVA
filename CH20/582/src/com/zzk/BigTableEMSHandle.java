package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class BigTableEMSHandle {
    
    public static void main(String args[]) {
        int bigtablesize = 5;
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter.getInstance(document, new FileOutputStream(
                    "c:\\大表格的記憶體處理.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            
            BaseFont chinese = BaseFont.createFont("STSong-Light",
                    "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);// 定義基礎字體
            Font fontChinese1 = new Font(chinese, 10, Font.NORMAL,
                    new BaseColor(90, 90, 90));// 實例化字體類別與設定字體大小屬性
            Font fontChinese2 = new Font(chinese, 15, Font.NORMAL,
                    BaseColor.BLUE);// 實例化字體類別與設定字體大小屬性
            document.add(new Paragraph("大表格的記憶體管理\n\n", fontChinese2));
            float[] hw = { 0.1f, 0.2f, 0.1f, 0.2f, 0.1f, 0.3f };// 設定列寬
            PdfPTable table = new PdfPTable(hw);// 建立表格
            table.setHeaderRows(2);// 設定頭排
            table.addCell("10%");// 將單元格內容順次的加入到表格，當一行充滿時自動換行
            table.addCell("20%");
            table.addCell("10%");
            table.addCell("20%");
            table.addCell("10%");
            table.addCell("30%");
            for (int i = 1; i <= 500; i++) {// 循環向表格中增加500條記錄
                if (i % bigtablesize == 4) {// 求余
                    document.add(table);// 向文件增加表格
                    table.deleteBodyRows();// 刪除多餘行
                    table.setSkipFirstHeader(true);// 使表頭始終保持在首行
                }
                PdfPCell cell0 = new PdfPCell(new Paragraph(String.valueOf(i),
                        fontChinese1));// 向單元格增加內容
                table.addCell(cell0);// 向表格增加單元格
                PdfPCell cell1 = new PdfPCell(new Paragraph("明日科技",
                        fontChinese1));// 向單元格增加內容
                table.addCell(cell1);// 向表格增加單元格
                PdfPCell cell2 = new PdfPCell(new Paragraph(String.valueOf(i),
                        fontChinese1));// 向單元格增加內容
                table.addCell(cell2);// 向表格增加單元格
                PdfPCell cell3 = new PdfPCell(new Paragraph("明日科技",
                        fontChinese1));// 向單元格增加內容
                table.addCell(cell3);// 向表格增加單元格
            }
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