package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawRoundRectApplet extends Applet {
    public void paint(Graphics g) {
        String value = "畫圓角矩形";
        int x = 20;// 圓角矩形位置的橫座標
        int y = 20;// 圓角矩形位置的縱座標
        int width = 70;// 圓角矩形寬度
        int height = 129;// 圓角矩形高度
        int xr = 5;                         // 圓角矩形圓角的水平弧度
        int yr = 7;                         // 圓角矩形圓角的垂直弧度

        g.setColor(Color.blue);// 設定顏色
        g.drawRoundRect(x, y, width, height, xr, yr); // 繪製圖形
        
        int x0 = 35; // 圓角矩形位置的橫座標
        int y0 = 35; // 圓角矩形位置的縱座標
        int width0 = 82; // 圓角矩形寬度
        int height0 = 139; // 圓角矩形高度
        int xr0 = 10; // 圓角矩形圓角的水平弧度
        int yr0 = 12; // 圓角矩形圓角的垂直弧度
        g.setColor(Color.blue);// 設定顏色
        g.drawRoundRect(x0, y0, width0, height0, xr0, yr0);// 繪製圖形
        
        int x1 = 59;// 圓角矩形位置的橫座標
        int y1 = 59;// 圓角矩形位置的縱座標
        int width1 = 92;// 圓角矩形寬度
        int height1 = 151;// 圓角矩形高度
        int xr1 = 20;// 圓角矩形圓角的水平弧度
        int yr1 = 22;// 圓角矩形圓角的垂直弧度
        g.setColor(Color.blue);// 設定顏色
        g.drawRoundRect(x1, y1, width1, height1, xr1, yr1);// 繪製圖形
        g.drawString(value, 165, 30);// 繪製純文字
    }
}
