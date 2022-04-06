package com.zzk;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class TextFileToPdf {

	public static void main(String[] args) {
		// 將純文字檔案oldTextFile.txt轉為PDF檔案newPdfFile.pdf
		txtFileToPdfFile("textFile\\oldTextFile.txt", "C:\\newPdfFile.pdf");
	}

	/**
	 * 將純文字檔案轉為PDF檔案的方法
	 * @param txtFile 原純文字檔案的路徑
	 * @param pdfFile 產生pdf檔案的路徑
	 */
	private static void txtFileToPdfFile(String txtFile, String pdfFile) {
		Document doc = new Document();// 建立文件對像
		try {
			FileReader fileRead = new FileReader(txtFile);// 建立字符流對像
			BufferedReader read = new BufferedReader(fileRead);// 建立字符緩衝流對像
			PdfWriter.getInstance(doc, new FileOutputStream(pdfFile));// 關聯文件和輸出流對像
			doc.open();// 開啟文件
			BaseFont Chinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			Font fontChinese = new Font(Chinese, 18, Font.BOLDITALIC,
					BaseColor.BLUE);// 實例化字體類別、設定字體大小和顏色
			String line = null;// 儲存從純文字檔案中讀取的內容
			while ((line = read.readLine()) != null) {// 讀取一行資訊
				doc.add(new Paragraph(line, fontChinese));// 將讀取的資訊增加到文件中
			}
			doc.close();// 關閉文件對像
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
