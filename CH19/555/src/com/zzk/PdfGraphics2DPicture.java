package com.zzk;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGraphics2D;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGraphics2DPicture {
    
    public static void main(String[] args) {
        Document document = new Document(); // 開啟文件
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("c:\\使用PdfGraphics2D繪製圖片.pdf"));// 關聯文件與輸出流
            document.open();// 開啟文件
            PdfContentByte cb = writer.getDirectContent();// 獲得文件內容
            PdfGraphics2D g = (PdfGraphics2D) cb.createGraphics(700, 800);// 建立PdfGraphics2D對像
            BufferedImage image = ImageIO.read(new File("image/picture.jpg"));// 獲得圖片
            g.drawImage(image, 50, 10, null);// 繪製圖片
            g.dispose();// 佈署
            cb.stroke();// 確認繪製的內容
            document.close();// 關閉文件
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
