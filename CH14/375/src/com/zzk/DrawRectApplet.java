package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawRectApplet extends Applet {
    public void paint(Graphics g) {
        String value = "畫矩形";
        int x = 42;// 矩形的橫座標
        int y = 27;// 矩形的縱座標
        int width = 122;// 矩形的寬度
        int height = 64;// 矩形的高度
        g.setColor(Color.BLUE);// 設定顏色藍色
        g.drawRect(x, y, width, height);// 繪製矩形
        int x0 = 54;// 矩形的橫座標
        int y0 = 37;// 矩形的縱座標
        int width0 = 130;// 矩形的寬度
        int height0 = 69;// 矩形的高度
        g.setColor(Color.BLUE);// 設定顏色藍色
        g.drawRect(x0, y0, width0, height0);// 繪製矩形
        int x1 = 67;// 矩形的橫座標
        int y1 = 48;// 矩形的縱座標
        int width1 = 137;// 矩形的寬度
        int height1 = 73;// 矩形的高度
        g.setColor(Color.BLUE);// 設定顏色藍色
        g.drawRect(x1, y1, width1, height1);// 繪製矩形
        g.drawString(value, 185, 143);// 繪製純文字
    }
}
