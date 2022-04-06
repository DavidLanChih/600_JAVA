package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class PaintMethodApplet extends Applet {
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);// 設定顏色
        g.drawString("這是使用paint()方法繪製的純文字。", 30, 40);// 繪製純文字內容
        g.setColor(Color.RED);// 設定顏色
        g.drawString("下面是使用paint()方法繪製的圖形。", 30, 80);// 繪製純文字內容
        g.drawRect(30, 100, 50, 40);// 繪製圖形
    }
}
