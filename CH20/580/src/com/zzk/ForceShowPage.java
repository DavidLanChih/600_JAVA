package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ForceShowPage {
	

	public static void main(String[] args) {
		
        Document document = new Document();// 建立文件對像
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\強行在一頁顯示（可能會遺失資料).pdf"));// 關聯文件對象與輸出流	
            document.open();// 開啟文件
            String[] data = { "C033010", "MX", "980", "350", "800", "999",
                    "655", "800", "23", "860" };// 定義資料資訊
            PdfPTable table = new PdfPTable(10);// 定義表格
            int columnwidths[] = { 8, 3, 11, 10, 8, 6, 8, 12, 3, 6 };// 定義列寬
            table.setWidths(columnwidths);// 向表格增加列寬
            table.setWidthPercentage(100);// 向表格增加絕對寬度
            table.getDefaultCell().setPadding(3);// 設定單元格填充為3
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);// 設定單元格居中對齊
            table.addCell("Number");// 將單元格內容順次的加入到表格，當一行充滿時自動換行
            table.addCell("Name");
            table.addCell("aggression");
            table.addCell("defend");
            table.addCell("reaction");
            table.addCell("shoot");
            table.addCell("header");
            table.addCell("bodybalance");
            table.addCell("age");
            table.addCell("speed");
            table.setHeaderRows(1);// 為表格每一頁設定表頭
            for (int i = 1; i < 100; i++) {// 循環向表格中增加100條記錄
                if (i % 2 == 1) {
                    table.getDefaultCell().setBackgroundColor(
                            BaseColor.LIGHT_GRAY);// 填充顏色
                } else {
                    table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);// 填充顏色
                }
                for (int x = 0; x < 10; x++) {
                    String var = data[x];// 獲得陣列中的資料
                    for (int y = 0; y < i; y++) {
                        var += "\n" + y;// 連接字串產生單元格內容
                    }
                    table.addCell(var);// 為單元格增加內容
                }
            }
     		table.setSplitRows(false);// 使行強行在一頁顯示，但是可能會遺失資料
     		document.add(table);// 向文件增加表格
     		document.close();// 關閉文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        
	}
}
