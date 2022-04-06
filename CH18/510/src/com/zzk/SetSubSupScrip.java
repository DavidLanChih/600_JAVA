package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class SetSubSupScrip {
	public static void main(String[] args) {
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream(
					"C:\\設定上標和索引.pdf"));// 關聯文件對象與輸出流
			document.open();
			BaseFont Chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			Font fontChinese = new Font(Chinese, 20, Font.NORMAL);// 實例化字體類別與設定字體大小屬性
			document.add(new Paragraph("下面是使用上標的效果：", fontChinese));// 增加段落
			Chunk chunk = new Chunk("X");// 建立塊
			document.add(chunk);// 向文件增加內容
			chunk = new Chunk("2");// 建立塊
			chunk.setTextRise(4.0f);// 提升塊純文字
			document.add(chunk);// 增加塊
			chunk = new Chunk("+Y");// 建立塊
			document.add(chunk);// 增加塊
			chunk = new Chunk("2");// 建立塊
			chunk.setTextRise(4.0f);// 提升塊純文字
			document.add(chunk);// 增加塊
			document.add(new Paragraph("下面是使用索引的效果：", fontChinese));// 增加段落
			chunk = new Chunk("M");// 建立塊
			document.add(chunk);// 增加塊
			chunk = new Chunk("2");// 建立塊
			chunk.setTextRise(-3.0f);// 降低塊純文字
			document.add(chunk);// 增加塊
			chunk = new Chunk("+N");// 建立塊
			document.add(chunk);// 增加塊
			chunk = new Chunk("2");// 建立塊
			chunk.setTextRise(-3.0f);// 降低塊純文字
			document.add(chunk);// 增加塊
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