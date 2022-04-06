package com.zzk;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGraphics2D;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGraphics2DFillShape {
    public static void main(String[] args) throws MalformedURLException {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\使用PdfGraphics2D繪製有填充色的圖形.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            PdfContentByte cb = writer.getDirectContent();// 獲得文件內容
            PdfGraphics2D g = (PdfGraphics2D) cb.createGraphics(700, 800);// 建立Graphics和座標
            Rectangle2D rect = new Rectangle2D.Double(120, 130, 200, 100);// 建立矩形對像
            Ellipse2D circle = new Ellipse2D.Double();// 建立橢圓對像
            circle.setFrameFromCenter(220, 80, 370, 120);// 設定橢圓形的中心點座標和角點座標
            g.setColor(Color.BLUE);// 設定顏色
            g.fill(rect);// 繪製填充的矩形
            g.setColor(Color.PINK);// 設定顏色
            g.fill(circle);// 繪製填充的圓形
            g.dispose();// 佈署
            cb.stroke();// 確認繪製圖形
            document.close();// 關閉文件
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
