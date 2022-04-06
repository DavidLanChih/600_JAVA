package com.zzk;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGraphics2D;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGraphics2DTransferShape {
    
    public static void main(String[] args) {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\使用PdfGraphics2D平移繪製的圖形.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            PdfContentByte cb = writer.getDirectContent();// 獲得文件內容
            PdfGraphics2D g = (PdfGraphics2D) cb.createGraphics(1200, 800);// 建立Graphics和座標
            Rectangle2D rect = new Rectangle2D.Double(50, 30, 120, 150);// 建立原矩形對像
            g.setColor(Color.BLUE);// 設定顏色
            g.fill(rect);// 繪製有填充色的圖形
            g.translate(150.0f, 1.0f);// 平移矩形對像
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