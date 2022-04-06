package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class AddTableInSection {

	public static void main(String[] args) {
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream(
					"C:\\在小節中增加表格.pdf"));// 關聯文件對象與輸出流
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
			PdfPTable table = new PdfPTable(3);// 建立表格對像
			table.addCell("1,1");// 將單元格順次的加入到表格，當一行充滿時自動換行
			table.addCell("1,2");
			table.addCell("1,3");
			table.addCell("2,1");
			table.addCell("2,2");
			table.addCell("2,3");
			table.addCell("3,1");
			table.addCell("3,2");
			table.addCell("3,3");
			paragraph = new Paragraph("\n下面是小節中增加的表格：\n\n", fontChinese3);// 建立段落
			section.add(paragraph);// 向小節增加段落內容
			section.add(table);// 將表格增加到小節
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