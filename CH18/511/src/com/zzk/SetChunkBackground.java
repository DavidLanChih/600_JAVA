package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;


public class SetChunkBackground {
	
	
	public static void main(String[] args){
		Document document = new Document();// 建立文件對像
		try {
			PdfWriter.getInstance(document, new FileOutputStream("c:\\Java編程全能詞典.pdf"));// 關聯文件對象與輸出流
			document.open();// 開啟文件
			Chunk chunk = new Chunk("Compile once, Run all!");// 定義塊並增加內容
			chunk.setBackground(BaseColor.LIGHT_GRAY); // 設定背景顏色
			document.add(chunk);// 增加背景顏色
			document.close();// 關閉文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
