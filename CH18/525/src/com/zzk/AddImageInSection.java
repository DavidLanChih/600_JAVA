package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class AddImageInSection {
	public static void main(String[] args) {
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream(
					"C:\\在小節中增加圖片.pdf"));// 關聯文件對象與輸出流
			document.open();// 開啟文件
			BaseFont Chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			Font fontChinese1 = new Font(Chinese, 18, Font.BOLDITALIC,
					BaseColor.RED);// 實例化字體類別、設定字體大小和顏色
			Font fontChinese2 = new Font(Chinese, 15, Font.BOLDITALIC,
					BaseColor.BLUE);// 實例化字體類別、設定字體大小和顏色
			Font fontChinese3 = new Font(Chinese, 12, Font.NORMAL,
					BaseColor.BLACK);// 實例化字體類別、設定字體大小和顏色
			Paragraph paragraph = new Paragraph("章節", fontChinese1);// 建立段落對像
			Chapter chapter = new Chapter(paragraph, 1);// 建立章節對像
			paragraph = new Paragraph("小節", fontChinese2);// 建立段落對像
			Section section = chapter.addSection(paragraph);// 建立並加入小節對像
			paragraph = new Paragraph("\n小節中增加的圖片如下：\n\n", fontChinese3);// 建立段落對像
			section.add(paragraph);// 向小節增加段落
			Image image = Image.getInstance("image/image.jpg");// 定義圖片資訊
			image.scalePercent(40);// 設定圖片的顯示百分比
			section.add(image);// 向小節增加圖片
			document.add(chapter);// 向文件增加章節
			document.close();// 關閉文件
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