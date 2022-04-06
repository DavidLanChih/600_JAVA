package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;

public class ClassSavePathApplet extends Applet {
    URL url;// 宣告URL對像
    public void start() {
        url = this.getCodeBase();// 獲得class存放路徑的URL對像
    }
    public void paint(Graphics g) {
        g.setColor(Color.blue);// 設定顏色
        g.drawString(url.getFile(), 30, 20);// 繪製class的存放路徑
    }
}
