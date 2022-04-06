package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class AddPictureInTable {
    
    public static void main(String[] args) {
        
        try {
            Document document = new Document();// 建立文件對像
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:\\在表格中增加圖片.pdf"));// 關聯文件對象與輸出流
            document.open();// 開啟文件
            Image image = Image.getInstance("image/picture.jpg");// 建立圖形對像
            PdfPTable table = new PdfPTable(3);// 定義表格
            table.addCell("Text");// 增加單元格內容
            table.addCell("Picture");// 增加單元格內容
            table.addCell("Text");// 增加單元格內容
            table.addCell("This is a cell.");// 增加單元格內容
            table.addCell(image);// 向單元格中增加圖形對像
            table.addCell("This is a cell.");// 增加單元格內容
            document.add(table);// 將表格增加到文件
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