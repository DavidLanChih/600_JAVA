package com.zzk;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ImportAddNewPageContent {
	public static void main(String[] args) {
		try {
			PdfReader reader = new PdfReader("c:\\建立第一個PDF文件.pdf");// 匯入文件
			PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(
					"c:\\匯入並增加新頁和內容.pdf"));// 關聯文件與輸出流
			BaseFont Chinese = BaseFont.createFont("STSong-Light",
					"UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);// 定義基礎字體
			PdfContentByte cb = stamp.getOverContent(1);// 獲得第一頁內容
			cb.beginText();// 寫內容
			cb.setFontAndSize(Chinese, 25);// 設定字體屬性
			cb.setTextMatrix(15, 15);// 設定矩陣(座標)
			cb.showText("第一頁");// 矩陣處顯示純文字
			cb.showTextAligned(Element.ALIGN_CENTER, "新增的內容。", 180, 760, 0);// 設定純文字對齊，內容，位置和旋轉角度
			cb.endText();// 內容結束
			stamp.insertPage(2, PageSize.A4);// 增加新頁
			cb = stamp.getOverContent(2);// 獲得第2頁內容
			cb.beginText();// 寫內容
			cb.setFontAndSize(Chinese, 20);// 設定字體屬性
			cb.showTextAligned(Element.ALIGN_LEFT, "在新增的頁中增加的內容。", 100, 600, 0);// 設定純文字對齊，內容，位置和旋轉角度
			cb.endText();// 內容結束
			stamp.close();// 關閉
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
