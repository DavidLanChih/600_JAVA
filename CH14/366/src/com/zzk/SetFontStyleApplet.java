package com.zzk;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;

public class SetFontStyleApplet extends Applet {
    public void paint(Graphics g) {
        Font font = new Font("細明體", Font.PLAIN, 16);// 建立字體對象，字體樣式為普通字體
        g.setFont(font);// 設定字體
        g.drawString("普通字體", 30, 20);// 繪製純文字
        font = new Font("細明體", Font.ITALIC, 22);// 建立字體對象，字體樣式為傾斜字體
        g.setFont(font);// 設定字體
        g.drawString("傾斜字體", 30, 60);// 繪製純文字
        font = new Font("細明體", Font.BOLD, 28);// 建立字體對象，字體樣式為粗體字體
        g.setFont(font);// 設定字體
        g.drawString("粗體字體", 30, 120);// 繪製純文字
    }
}
