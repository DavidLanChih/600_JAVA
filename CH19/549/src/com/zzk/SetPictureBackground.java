package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class SetPictureBackground {
    
    public static void main(String[] args) {
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\將圖片設定為背景.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            BaseFont bfChinese = BaseFont.createFont("STSong-Light",
                    "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);// 定義基礎字體
            Font FontChinese = new Font(bfChinese, 50, Font.BOLD,
                    BaseColor.BLUE);// 實例化字體類別與設定字體大小屬性
            Paragraph p = new Paragraph("下面是背景圖片", FontChinese);// 建立段落對像
            p.setSpacingBefore(60); // 設定段落上邊距
            p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            Image image = Image.getInstance("image/gb.jpg");// 定義圖片對像
            image.setAlignment(Image.UNDERLYING);// 將圖片設定為背景
            document.add(image);// 向文件增加如片
            document.add(p);// 增加段落
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