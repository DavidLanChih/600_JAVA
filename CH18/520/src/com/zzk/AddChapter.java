package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public class AddChapter {
	public static void main(String[] args) {
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document,
					new FileOutputStream("C:\\增加章節.pdf"));// 關聯文件對象與輸出流
			document.open();// 開啟文件
			Chapter chapter = new Chapter("This is chapter 1", 1);// 建立與新章節對像關聯的內容
			document.add(chapter);// 向文件中增加章節
			chapter = new Chapter("This is chapter 2", 2);// 建立與新章節對像關聯的內容
			document.add(chapter);// 向文件中增加章節
			chapter = new Chapter("This is chapter 3", 3);// 建立與新章節對像關聯的內容
			document.add(chapter);// 向文件中增加章節
			chapter = new Chapter("This is chapter 4", 4);// 建立與新章節對像關聯的內容
			document.add(chapter);// 向文件中增加章節
			document.close();// 關閉文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}
}
