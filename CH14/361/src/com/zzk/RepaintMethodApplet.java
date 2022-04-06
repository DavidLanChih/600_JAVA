package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class RepaintMethodApplet extends Applet {
    static int iFlag = 0;// 定義標記變數
    public void start() {
        iFlag++;// 調整標記變數的值
        repaint();// 重新呼叫paint()方法
    }
    public void paint(Graphics g) {
        if (iFlag == 1) {
            g.drawString("這是使用paint()方法繪製的純文字。", 30, 60);// 繪製純文字
        } else if (iFlag == 2) {
            g.setColor(Color.RED);// 設定顏色
            g.drawString("下面是使用paint()方法繪製的圖形。", 30, 60);// 繪製純文字
            g.drawRect(30, 80, 50, 40);// 繪製矩形
        } else if (iFlag == 3) {
            g.setColor(Color.BLUE);// 設定顏色
            g.drawString("下面是使用paint()方法繪製的圖形。", 30, 60);// 繪製純文字
            g.drawRect(30, 80, 50, 40);// 繪製矩形
        } else {
            g.setColor(Color.GREEN);// 設定顏色
            g.drawString("下面是使用paint()方法繪製的圖形。", 30, 60);// 繪製純文字
            g.drawRect(30, 80, 50, 40);// 繪製矩形
        }
    }
}
