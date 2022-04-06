package com.zzk;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.exceptions.IllegalPdfSyntaxException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class AddPageNumber extends PdfPageEventHelper {

	public PdfTemplate pdfTemplate;// 宣告模板對像
	public BaseFont baseFont;// 宣告基礎字體對像

	public static void main(String[] args) {
		Document document = new Document(PageSize.A4);// 建立A4紙張大小的PDF文件對像
		try {
			PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("C:\\增加頁碼.pdf"));// 關聯文件對象與輸出流 
			writer.setPageEvent(new AddPageNumber());// 增加頁面事件監聽器
			document.open();// 開啟文件
			BaseFont bf =BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED); 
			Paragraph pargraph = new Paragraph("增加頁碼和總頁數。", new Font(bf, 15,
					Font.BOLD, BaseColor.BLUE));// 建立段落對象並指定中文
			document.add(pargraph);// 向文件中增加段落
			document.newPage();// 建立新頁
			document.add(pargraph);// 增加段落
			document.newPage();// 建立新頁
			document.add(pargraph);// 增加段落
			document.close();// 關閉文件
		} catch (IllegalPdfSyntaxException de) {
			de.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onOpenDocument(PdfWriter writer, Document document) {// 開啟文件時執行該方法
			pdfTemplate = writer.getDirectContent().createTemplate(180, 180);// 建立模板對像
			try {
				baseFont = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public void onEndPage(PdfWriter writer, Document document) {// 結束頁時執行該方法
		PdfContentByte cb = writer.getDirectContent();// 建立內容對像
		cb.saveState();// 儲存狀態
		cb.beginText();// 純文字開始標記
		cb.setFontAndSize(baseFont, 12);// 設定字體和字號
		cb.setTextMatrix(260, 800);// 設定純文字顯示位置
		String page = "第" + writer.getPageNumber() + "頁/共";// 定義表示頁碼資訊的變數
		cb.showText(page);// 顯示純文字
		cb.endText();// 純文字結束標記
		cb.addTemplate(pdfTemplate, 305, 800);// 增加模板對像
		cb.stroke();// 確認並儲存操作
		cb.restoreState();// 恢復標記
		cb.closePath();// 關閉內容通道
	}

	public void onCloseDocument(PdfWriter writer, Document document) {// 關閉文件時執行該方法
		pdfTemplate.beginText();// 模板純文字開始標記
		pdfTemplate.setFontAndSize(baseFont, 12);// 設定模板字體和字號
		int totalPages = writer.getPageNumber() - 1;// 獲得總頁數
		pdfTemplate.showText(totalPages + "頁");// 顯示總頁數資訊
		pdfTemplate.endText();// 模板純文字結束標記
		pdfTemplate.closePath();// 關閉模板通道
	}
}
