package com.zzk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;

public class UnitePDFDocument {
    
    public static void main(String[] args) {
        String[] subFiles = { "c:\\原文件-1.pdf", "c:\\原文件-2.pdf", "c:\\原文件-3.pdf" }; // 待合併的PDF文件
        String newFile = "C:\\合併結果.pdf";// 合併後的新文件
        Document document = new Document();// 建立純文字文件
        try {
            PdfCopy copy = new PdfCopy(document, new FileOutputStream(newFile));// 建立copy對像關聯文件與輸出流
            document.open();// 開啟文件
            for (int i = 0; i < subFiles.length; i++) {// 做循環 獲得待合併檔案長度
                PdfReader reader = new PdfReader(subFiles[i]);// 讀取待合併檔案長度
                int totalPages = reader.getNumberOfPages();// 獲得每個子文件的總頁數
                for (int p = 1; p <= totalPages; p++) {// 檢查子文件的每一頁
                    copy.addPage(copy.getImportedPage(reader, p));// 將子文件的每一頁都增加到新文件中
                }
            }
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
