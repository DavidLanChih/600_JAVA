package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawPolygonApplet extends Applet {
    public void paint(Graphics g) {
        String value = "繪製多角形";
        int x[] = { 60, 103, 170, 150, 120 };// 宣告多角形的橫座標陣列
        int y[] = { 80, 180, 140, 80, 120 };// 宣告多角形的縱座標陣列
        int num = x.length;// 取得多角形x,y座標對陣列的長度
        g.setColor(Color.blue);// 設定顏色
        g.drawPolygon(x, y, num);// // 繪製多角形
        g.drawString(value, 120, 70);// 繪製純文字
    }
}
