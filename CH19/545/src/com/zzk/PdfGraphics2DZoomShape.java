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

public class PdfGraphics2DZoomShape {
    
    public static void main(String[] args) throws MalformedURLException {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\使用PdfGraphics2D縮放繪製的圖形.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            PdfContentByte cb = writer.getDirectContent();// 獲得文件內容
            PdfGraphics2D g = (PdfGraphics2D) cb.createGraphics(700, 800);// 建立Graphics和座標
            Rectangle2D rect = new Rectangle2D.Double(50, 30, 120, 150);// 建立原矩形對像
            g.setColor(Color.BLUE);// 設定顏色
            g.fill(rect);// 繪製有填充色的圖形
            rect = new Rectangle2D.Double(150, 30, 120, 150);// 建立與原矩形大小相同的矩形對像
            g.scale(1.4, 1.2f);// 縮放矩形對像
            g.setColor(Color.PINK);// 設定顏色
            g.fill(rect);// 繪製有填充色的圖形
            g.dispose();// 佈署
            cb.stroke();// 確認繪製內容
            document.close();// 關閉文件
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
