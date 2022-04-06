package com.zzk;

import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageable;

public class PrintPDF {
    
    public static void main(String args[]) throws IOException,
            IllegalArgumentException, PrinterException {
        PrinterJob job = PrinterJob.getPrinterJob();// 建立列印作業
        PDDocument document = PDDocument.load("建立表格.pdf");// 獲得待列印的文件
        Printable printable = new PDPageable(document);// 建立Printable對像
        job.setPrintable(printable);// 設定列印工作
        job.print();// 列印
        
    }
}
