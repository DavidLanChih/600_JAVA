package com.zzk;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ShearTextApplet extends Applet {
    public void paint(Graphics g) { // 重新定義paint()方法
        Graphics2D g2 = (Graphics2D) g;// 轉為Graphics2D型態
        String value = "傾斜文字";// 繪製的純文字
        int x = 10; // 純文字位置的橫座標
        int y = 190; // 純文字位置的縱座標
        Font font = new Font("華文行楷", Font.BOLD, 72); // 建立字體對像
        g2.setFont(font); // 設定字體
        g2.shear(0.1, -0.4);// 傾斜畫布
        g2.drawString(value, x, y); // 繪製純文字
    }
}
