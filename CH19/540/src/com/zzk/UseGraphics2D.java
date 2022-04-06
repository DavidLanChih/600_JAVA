package com.zzk;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class UseGraphics2D {
    
    public static void main(String[] args) throws MalformedURLException {
        Document document = new Document(); // 建立文件對像
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("C:\\使用Graphics2D繪製圖形.pdf"));// 關聯文件對象與輸出流
            document.open(); // 開啟文件
            PdfContentByte cb = writer.getDirectContent(); // 獲得文件內容
            Graphics2D g = cb.createGraphics(850, 850); // 建立Graphics和座標
            Rectangle2D rect1 = new Rectangle2D.Double(50, 50, 200, 150); // 建立矩形對像
            g.draw(rect1); // 繪製矩形
            Rectangle2D rect2 = new Rectangle2D.Double(70, 70, 160, 110); // 建立矩形對像
            g.fill(rect2); // 繪製填充矩形
            g.dispose(); // 佈署
            cb.stroke(); // 確認繪製的圖形
            document.close(); // 關閉文件
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
