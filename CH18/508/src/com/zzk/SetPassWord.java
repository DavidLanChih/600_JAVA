package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class SetPassWord {
	
	
	public static void main(String[] args) {
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("C:\\設定密碼.pdf"));// 關聯文件對象與輸出流
			writer.setEncryption("zzk".getBytes(), "123".getBytes(),
					PdfWriter.ALLOW_COPY, PdfWriter.STANDARD_ENCRYPTION_128);// 設定密碼參數和常數
			document.open();// 開啟文件
			document.add(new Paragraph("Set Encryption"));// 向文件增加內容
			document.close();// 關閉文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
