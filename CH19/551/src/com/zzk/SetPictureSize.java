package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class SetPictureSize {
    public static void main(String[] args) {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\設定圖片大小.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            Image image = Image.getInstance("image/picture.jpg");// 建立圖形對像
            image.setAlignment(Image.MIDDLE);// 居中顯示圖片
            image.scaleAbsolute(180, 120);// 設定圖片新的寬度和高度
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