package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawLineApplet extends Applet {
    public void paint(Graphics g) {
        String value = "畫直線";
        int x = 215;// 直線的橫座標(右)
        int y = 45;// 直線的縱座標(右)
        int x1 = 15;// 直線的橫座標(左)
        int y1 = 45;// 直線的縱座標(左)
        int x2 = 300;// 直線的橫座標(右)
        int y2 = 100;// 直線的縱座標(右)
        int x3 = 60;// 直線的橫座標(左)
        int y3 = 100;// 直線的縱座標(左)
        g.setColor(Color.blue);// 設定顏色紅色
        g.drawLine(x, y, x1, y1);// 繪製直線
        g.drawLine(x2, y2, x3, y3);// 繪製直線
        g.drawString(value, 120, 75);// 繪製純文字
    }
}
