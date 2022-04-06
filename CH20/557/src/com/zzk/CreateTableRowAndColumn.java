package com.zzk;

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

public class CreateTableRowAndColumn {
    
    public static void main(String[] args) {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\建立具有指定行列數的表格.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            //BaseFont bfChinese = BaseFont.createFont("STSong-Light",
            //        "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);// 定義基本字體
            BaseFont bfChinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 定義基本字體
            Font fontChinese = new Font(bfChinese, 28, Font.NORMAL);// 實例化字體
            document.add(new Paragraph("        這是一個3行3列的表格", fontChinese));
            Table table = new Table(3, 3);// 建立一個3行3列的表格
            // 將單元格順次的加入到表格，當一行充滿時自動換行
            table.addCell("1,1");
            table.addCell("1,2");
            table.addCell("1,3");
            table.addCell("2,1");
            table.addCell("2,2");
            table.addCell("2,3");
            table.addCell("3,1");
            table.addCell("3,2");
            table.addCell("3,3");
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