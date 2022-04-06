package com.zzk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class AddWatermark {
	public static void main(String[] args) {
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream(
					"c:\\tempWatermark.pdf"));// 關聯文件對象與臨時檔案的輸出流
			document.open();// 開啟文件
			document.add(new Paragraph(" ")); // 向文件中增加內容
			document.close();// 關閉文件對像
			PdfReader reader = new PdfReader("c:\\tempWatermark.pdf");// 建立「tempWatermark.pdf」的PdfReader對像
			PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(
					"c:\\增加水印.pdf"));// 建立PdfStamper對像
			Image img = Image.getInstance("image/watermark.jpg");// 建立圖形對像
			img.setAbsolutePosition(50, 385);// 定位圖片對像
			PdfContentByte under = stamp.getUnderContent(1);// 獲得第一頁的內容
			under.addImage(img);// 增加圖片,完成水印功能
			BaseFont chinese = BaseFont.createFont("STSong-Light",
					"UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);// 定義字體
			under.beginText();// 標記純文字開始
			under.setFontAndSize(chinese, 42);// 設定字體和字號
			under.setTextMatrix(70, 550);// 設定增加內容的顯示位置
			under.showText("下面是增加的水印圖片.");// 增加內容
			under.endText();// 標記純文字結束
			stamp.close();// PdfStamper對象，將從「tempWatermark.pdf」中讀取的文件增加水印後寫入「增加水印.pdf」
			File file = new File("c:\\tempWatermark.pdf");// 建立臨時檔案的File對像
			file.delete();// 刪除臨時檔案
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
