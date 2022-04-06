package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawArcApplet extends Applet {
    public void paint(Graphics g) {
        String value = "畫弧";
        int x = 35;// 弧位置的橫座標
        int y = 65;// 弧位置的縱座標
        int l = 150;// 弧的長度
        int width = 80;// 弧的寬度
        int startAngle = 10;// 弧的起始角度
        int endAngle = -120;// 終止畫弧前掃過的角度
        g.setColor(Color.red);// 設定顏色
        g.drawArc(x + 20, y, l, width, startAngle, endAngle);// 繪製弧
        
        int x0 = 5;// 弧位置的橫座標
        int y0 = 40;// 弧位置的縱座標
        int l0 = 180;// 弧的長度
        int width0 = 120;// 弧的寬度
        int startAngle0 = 70;// 弧的起始角度
        int endAngle0 = 180;// 終止畫弧前掃過的角度
        g.setColor(Color.red);// 設定顏色
        g.drawArc(x0 + 20, y0, l0, width0, startAngle0, endAngle0);// 繪製弧
        
        int x1 = 19;// 弧位置的橫座標
        int y1 = 90;// 弧位置的縱座標
        int l1 = 200;// 弧的長度
        int width1 = 100;// 弧的寬度
        int startAngle1 = 5;// 弧的起始角度
        int endAngle1 = 300;// 終止畫弧前掃過的角度
        g.setColor(Color.red);// 設定顏色
        g.drawArc(x1 + 20, y1, l1, width1, startAngle1, endAngle1);// 繪製弧
        g.drawString(value, 195, 160);
        
    }
}
