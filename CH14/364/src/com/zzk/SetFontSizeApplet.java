package com.zzk;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;

public class SetFontSizeApplet extends Applet {
    public void paint(Graphics g) {
        Font font = new Font("細明體", Font.PLAIN, 16);// 建立字體對象，字體大小為16
        g.setFont(font);// 設定字體
        g.drawString("字體大小為16", 30, 20);// 繪製純文字
        font = new Font("細明體", Font.PLAIN, 22);// 建立字體對象，字體大小為22
        g.setFont(font);// 設定字體
        g.drawString("字體大小為22", 30, 60);// 繪製純文字
        font = new Font("細明體", Font.PLAIN, 36);// 建立字體對象，字體大小為36
        g.setFont(font);// 設定字體
        g.drawString("字體大小為36", 30, 120);// 繪製純文字
    }
}
