package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class SetHeightWidth {
    
    public static void main(String[] args) {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\設定高度和寬度的比例.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            Image image = Image.getInstance("image/picture.jpg");// 建立圖形對像
            image.scalePercent(50, 40);// 設定寬度和高度比例分別為原圖片的50%和40%
            document.add(image);// 向文件增加圖片
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