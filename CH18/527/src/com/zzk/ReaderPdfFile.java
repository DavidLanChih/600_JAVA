package com.zzk;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import com.itextpdf.text.Document;

public class ReaderPdfFile {

	public static void main(String[] args) throws MalformedURLException {
		Document document = new Document();// 建立文件對像
		File file = new File("c:\\建立第一個PDF文件.pdf");// 建立File對像
		try {
			FileInputStream in = new FileInputStream(file);// 建立輸入流對像
			PDFParser parser = new PDFParser(in);// 建立PDF解析器
			parser.parse();// 解析PDF文件
			PDDocument pdfdocument = parser.getPDDocument();// 獲得解析後的PDF文件
			PDFTextStripper stripper = new PDFTextStripper();// 建立PDF純文字剝離器
			String msg = stripper.getText(pdfdocument);// 使用剝離器從PDF文件中剝離純文字資訊
			System.out.println("請取到的PDF純文字資訊如下:\n" + msg);// 輸出資訊
			in.close();// 關閉輸入流對像
		} catch (Exception e) {
			e.printStackTrace();
		}
		document.close();// 關閉文件
	}
}
