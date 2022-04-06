package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ShadowTextApplet extends Applet {
    public void paint(Graphics g) { // 重新定義paint()方法
        String value = "陰影文字";
        int x = 10; // 純文字位置的橫座標
        int y = 120; // 純文字位置的縱座標
        Font font = new Font("華文行楷", Font.BOLD, 80); // 建立字體對像
        g.setFont(font); // 設定字體
        g.setColor(Color.GRAY);// 設定顏色為灰色
        g.drawString(value, x, y); // 繪製純文字
        x += 3;// 調整繪製點的橫座標值
        y += 3;// 調整繪製點的縱座標值
        g.setColor(Color.BLACK);// 設定顏色黑色
        g.drawString(value, x, y); // 繪製純文字
    }
}
