package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
public class ShowPositionApplet extends Applet {
    String author;// 宣告成員變數
    public void init() {
        author = "ZhenKun Zhang";// 初始化成員變數
    }
    public void paint(Graphics g){
        g.setColor(Color.blue);// 設定顏色
        g.drawString(author, 50, 30);// 繪製純文字
    }
}
