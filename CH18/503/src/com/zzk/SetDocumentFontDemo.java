package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class SetDocumentFontDemo {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter.getInstance(document, new FileOutputStream("c://Java類別庫.pdf"));	//關聯文件對象與輸出流
            document.open();							//開啟文件
            BaseFont bfChinese = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);//定義基本字體
            Font contentFont = new Font(bfChinese, 20);	//定義普通字體和大小
            document.add(new Paragraph("Java Function Classes", contentFont));	//向文件中增加內容並指定普通字體
            document.close();							//關閉文件
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