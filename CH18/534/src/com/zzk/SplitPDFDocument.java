package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;

public class SplitPDFDocument {
	public static void main(String[] args) {
		String filePathFile = "c:\\A.pdf ";// 需要拆分的原文件
		PdfReader reader = null;// 宣告PdfReader對像
		try {
			reader = new PdfReader(filePathFile);// 建立PdfReader對像
		} catch (IOException e) {
			e.printStackTrace();
		}
		int pageN = reader.getNumberOfPages();// 獲得檔案內的頁數
		for (int i = 0; i < pageN; i++) {// 循環向外拆分頁
			Document document = new Document(reader
					.getPageSizeWithRotation(i + 1));// 建立文件 同時獲得前面循環的頁
			PdfCopy copy = null;
			try {
				int len = filePathFile.length();// 獲得檔案完整路徑的長度
				String noExt = filePathFile.substring(0, len - 5);// 去除檔案擴充名後的路徑
				String fileName = noExt + "-" + (i + 1) + ".pdf";// 拆分後產生的檔案名稱
				copy = new PdfCopy(document, new FileOutputStream(fileName));// 建立拷貝並關聯文件與輸出流對像
				document.open();// 開啟文件
				copy.addPage(copy.getImportedPage(reader, i + 1));// 根據獲得的頁建立新文件
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
}
