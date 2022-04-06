package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class SolidTextApplet extends Applet {
    public void paint(Graphics g) { // 重新定義paint()方法
        String value = "立體文字效果";
        int x = 10; // 純文字位置的橫座標
        int y = 120; // 純文字位置的縱座標
        Font font = new Font("細明體", Font.BOLD, 72); // 建立字體對像
        g.setFont(font); // 設定字體
        g.setColor(Color.GRAY);// 設定顏色為灰色
        int i = 0;// 循環變數
        while (i < 8) {
            g.drawString(value, x, y); // 繪製純文字
            x += 1;// 調整繪製點的橫座標值
            y += 1;// 調整繪製點的縱座標值
            i++;// 調整循環變數的值
        }
        g.setColor(Color.BLACK);// 設定顏色黑色
        g.drawString(value, x, y); // 繪製純文字
    }
}
