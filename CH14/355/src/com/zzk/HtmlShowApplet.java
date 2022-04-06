package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
public class HtmlShowApplet extends Applet {
    public void paint(Graphics g){
        g.drawString("html檔案已經執行", 50, 50);// 繪製純文字
        g.drawString("在html中顯示了Applet程式", 50, 80);// 繪製純文字
    }
}
