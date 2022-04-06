package com.zzk;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGraphics2D;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGraphics2DRotateShape {
    
    public static void main(String[] args) throws MalformedURLException {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\使用PdfGraphics2D旋轉繪製的圖形.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            PdfContentByte cb = writer.getDirectContent();// 獲得文件內容
            PdfGraphics2D g = (PdfGraphics2D) cb.createGraphics(700, 800);// 建立PdfGraphics2D對像
            Rectangle2D rect = new Rectangle2D.Double(200, 200, 150, 200);// 建立矩形對像
            g.setColor(Color.BLUE);// 設定圖形顏色
            g.rotate(20, 380, 150);// 旋轉圖形
            g.draw(rect);// 繪製矩形對像
            g.dispose();// 佈署
            document.close();// 關閉文件
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
