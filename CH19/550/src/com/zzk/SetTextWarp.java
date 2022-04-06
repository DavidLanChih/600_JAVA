package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class SetTextWarp {
    
    public static void main(String[] args) {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\設定文字環繞.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            Image image = Image.getInstance("image/picture.jpg");// 建立圖形對像
            image.scalePercent(33);// 設定原圖形的比例
            image.setAlignment(Image.TEXTWRAP);// 將圖片設定為文字環繞
            document.add(image);// 向文件增加圖片
            StringBuffer sb = new StringBuffer();// 建立字串快取記憶體
            for (int i = 1; i <= 200; i++) {
                sb.append(i + " ");// 向字串快取記憶體中增加內容
            }
            Paragraph p = new Paragraph(sb.toString());// 建立段落對像
            document.add(p);// 將段落增加到文件中
            document.close();// 關閉文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
