package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ImportAlreadyDocument {

	public static void main(String[] args) {
		try {
			PdfReader reader = new PdfReader("c:\\newPdfFile.pdf");// 建立已有文件的PdfReader對像
			PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(
					"c:\\匯入已有文件.pdf"));// 關聯已有文件與輸出流
			stamp.close();// 關閉PdfStamper對象，完成文件匯入功能
			JOptionPane.showMessageDialog(null, "匯入成功...\n完成已有文件的匯入。");
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