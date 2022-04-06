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

public class SetCellSpace {
    
    public static void main(String[] args) {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\設定單元格的間距.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            BaseFont bfChinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 定義基本字體
            Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);// 實例化字體
            Table table = new Table(3);// 定義表格
            document.add(new Paragraph("                預設的表格", fontChinese));// 向文件增加內容
            // 將單元格順次的加入到表格，當一行充滿時自動換行
            table.addCell("Cell1.1");
            table.addCell("Cell1.2");
            table.addCell("Cell1.3");
            table.addCell("Cell2.1");
            table.addCell("Cell2.2");
            table.addCell("Cell2.3");
            Table table1 = new Table(3);// 定義表格
            table1.setSpacing(3);// 設定表格邊框與單元格的間距
            table1.setBorderColor(Color.GREEN);// 設定表格邊框顏色
            // 將單元格順次的加入到表格，當一行充滿時自動換行
            table1.addCell("Cell1.1");
            table1.addCell("Cell1.2");
            table1.addCell("Cell1.3");
            table1.addCell("Cell2.1");
            table1.addCell("Cell2.2");
            table1.addCell("Cell2.3");
            document.add(table);
            document.add(new Paragraph("                設定表格邊框顏色與單元格的間距值為3",
                    fontChinese));// 向文件增加內容"
            document.add(table1);// 將表格增加到文件
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