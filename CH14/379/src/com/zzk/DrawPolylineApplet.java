package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawPolylineApplet extends Applet {
    public void paint(Graphics g) {
        String value = "聚合線";
        int[] x = { 30, 60, 60, 20 };// 宣告表示聚合線橫座標的陣列
        int[] y = { 30, 70, 150, 80 };// 宣告表示聚合線縱座標的陣列
        int num1 = x.length;// 分析x,y座標對陣列的長度
        g.setColor(Color.blue);// 設定顏色
        g.drawPolyline(x, y, num1);// 繪製聚合線
        int[] x0 = { 80, 110, 65, 80, 200 };// 宣告表示聚合線橫座標的陣列
        int[] y0 = { 30, 70, 100, 120, 150 };// 宣告表示聚合線縱座標的陣列
        int num2 = x0.length;// 分析x0,y0座標對陣列的長度
        g.drawPolyline(x0, y0, num2);// 繪製聚合線
        g.drawString(value, 160, 130);// 繪製純文字
    }
}
