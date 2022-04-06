package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class ImportAndAddPageNumber {
    public static void main(String[] args) {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter.getInstance(document, new FileOutputStream("c:\\頁碼.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            document.add(new Paragraph("No. 1 page")); // 向文件中增加內容
            document.newPage();
            document.add(new Paragraph("No. 2 page")); // 向文件中增加內容
            document.close();// 關閉文件對像
            PdfReader reader = new PdfReader("c:\\頁碼.pdf");// 建立「頁碼.pdf」的PdfReader對像
            int totalPages = reader.getNumberOfPages();
            PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(
                    "c:\\匯入並增加頁碼.pdf"));// 建立PdfStamper對像
            BaseFont chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            PdfContentByte under = null;
            for (int i = 1; i <= totalPages; i++) {
                under = stamp.getUnderContent(i);// 獲得每一頁的內容
                under.beginText();// 標記純文字開始
                under.setFontAndSize(chinese, 18);// 設定字體和字號
                under.setTextMatrix(280, 15);// 設定頁碼的顯示位置
                under.showText("第" + i + "頁");// 增加頁腳
                under.endText();// 標記純文字結束
            }
            stamp.close();// PdfStamper對象，將從「頁碼.pdf」中讀取的文件增加頁碼後寫入「增加頁碼.pdf」
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