package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;

public class GainAddressBarPathApplet extends Applet {
    URL url;// 宣告URL對像
    public void start() {
        url = this.getDocumentBase();// 獲得地址欄上路徑的URL對像
    }
    public void paint(Graphics g) {
        g.setColor(Color.blue);// 設定顏色
        g.drawString(url.getFile(), 30, 20);// 繪製地址欄上的路徑
    }
}
