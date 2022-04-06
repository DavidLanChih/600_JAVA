package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class UpdateMethodApplet extends Applet {
    boolean flag = false;// 定義標記變數
    public void start() {
        repaint();// 重新呼叫paint方法
    }
    public void paint(Graphics g) {
        g.setColor(Color.RED);// 設定顏色
        g.drawString("這是使用paint()方法繪製的純文字。", 30, 120);// 繪製純文字
        g.setColor(Color.BLUE);// 設定顏色
        g.drawString("下面是使用paint()方法繪製的圖形。", 30, 140);// 繪製純文字
        g.drawRect(30, 150, 50, 40);// 繪製矩形
        update(g);// 呼叫updatae方法
    }
    public void update(Graphics g) {
        if (flag) {
            g.clearRect(0, 0, 300, 220);// 標記變數為true時,清除內容
            flag = false;// 設定標記變數為false
        } else {
            flag = true;// 設定標記變數為true
        }
        g.setColor(Color.BLUE);// 設定顏色
        g.drawString("這是使用updatePaint()方法繪製的純文字。", 30, 20);// 繪製純文字
        g.setColor(Color.RED);// 設定顏色
        g.drawString("下面是使用updatePaint()方法繪製的圖形。", 30, 40);// 繪製純文字
        g.drawRect(30, 50, 50, 40);// 繪製矩形
    }
}
