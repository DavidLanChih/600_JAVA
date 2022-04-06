package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class TextScaleApplet extends Applet implements Runnable {
    public void start() {
        Thread thread = new Thread(this);// 建立線程對像
        thread.start();// 啟動線程對像
    }
    private Image img = null; // 宣告圖形對像
    boolean flag = false;// 定義標記變數,使用者控制x的值
    int x = 12;// 定義表示字體大小的變數x
    Font font = new Font("華文楷體", Font.BOLD, 42);// 建立字體對像
    public void paint(Graphics g) {
        img = getImage(getCodeBase(), "com/zzk/PD3.jpg");// 獲得圖片資源的路徑
        Graphics2D g2 = (Graphics2D) g;// 獲得Graphics2D對像
        g2.drawImage(img, 0, 0, getWidth(), getHeight(), this);// 繪製圖形
        g2.setFont(font);// 指定字體
        g2.setColor(Color.red);// 指定顏色
        g2.drawString("學無止境", 30, 120);// 繪製純文字
    }
    public void run() {
        while (true) {
            if (flag) { // flag為true時
                x -= 2; // x進行減1計算
                if (x <= 12) {// x小於等於12時
                    x = 12; // x等於12
                    flag = false;// 為flag給予值為false
                }
            } else {// flag為false時
                x += 2;// x進行加1計算
                if (x >= 72) {// x大於等於72時
                    x = 72;// x等於72
                    flag = true;// 為flag給予值為true
                }
            }
            font = new Font("華文楷體", Font.BOLD, x);// 重新建立字體對像
            repaint();// 呼叫paint()方法
            try {
                Thread.sleep(50);// 休眠50毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
//    public void update(Graphics g) {
//        paint(g);
//    }
}
