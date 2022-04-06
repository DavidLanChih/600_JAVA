package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class DrawLineDemo {
    
    public static void main(String[] args) {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\繪製直線.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            PdfContentByte cb = writer.getDirectContent();// 獲得內容
            cb.moveTo(50, 780); // 繪製起點座標
            cb.lineTo(260, 780); // 繪製終點座標
            cb.stroke(); // 確認直線的繪製
            cb.moveTo(50, 750);
            cb.lineTo(260, 750);
            cb.stroke();
            cb.moveTo(50, 720);
            cb.lineTo(260, 720);
            cb.stroke();
            document.close();// 關閉文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
