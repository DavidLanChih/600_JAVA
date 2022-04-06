package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.*;


public class HandleChineseErrorCode {
	public static void main(String[] args){
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream("C:\\亞運速遞.pdf"));// 關聯文件對象與輸出流
			document.open();// 開啟文件
			BaseFont Chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);   
			Font FontChinese = new Font(Chinese, 20, Font.NORMAL);// 實例化字體類別與設定字體大小屬性           
			document.add(new Paragraph("中國再一次實現了金牌數和獎牌數第一的目標", FontChinese));// 向文件中增加內容並指定中文
			document.close();// 關閉文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}