package com.zzk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ReadPwdPdfFile {

	public static void main(String[] args) throws MalformedURLException {
		try {
			PdfReader reader = new PdfReader("c:\\設定密碼.pdf", "123".getBytes());// 建立「水印.pdf」的PdfReader對像
			PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(
					"c:\\TempFile.pdf"));// 建立PdfStamper對像
			stamp.close();// 關閉PdfStamper對象，並將從「設定密碼.pdf」中讀取的內容寫入「TempFile.pdf」
			Document document = new Document();// 建立文件對像
			File file = new File("c:\\TempFile.pdf");// 建立File對像
			try {
				FileInputStream in = new FileInputStream(file);// 建立輸入流對像
				PDFParser parser = new PDFParser(in);// 建立PDF
				parser.parse();// 解析PDF文件
				PDDocument pdfdocument = parser.getPDDocument();// 獲得解析後的PDF文件
				PDFTextStripper stripper = new PDFTextStripper();// 建立PDF純文字剝離器
				String msg = stripper.getText(pdfdocument);// 使用剝離器從PDF文件中剝離純文字資訊
				System.out.println("請取到加密的PDF純文字資訊如下:\n" + msg);// 輸出資訊
				in.close();// 關閉輸入流對像
			} catch (Exception e) {
				e.printStackTrace();
			}
			document.close();// 關閉文件
			file.delete();// 刪除「TempFile.pdf」
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