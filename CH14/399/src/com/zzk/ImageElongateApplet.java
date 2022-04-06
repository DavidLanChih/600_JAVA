package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class ImageElongateApplet extends Applet implements Runnable {
    private boolean flag = true;// 宣告標記變數
    private static float xw;// 定義調整圖形寬度的變數
    public void init(){
        xw = 0.5f;// 初始化圖形寬度
    }
    public void start(){
        Thread th = new Thread(this);// 建立線程對像
        th.start();// 啟動線程對像
    }
    public void paint(Graphics g) {
        Image img = null;// 宣告圖形對像
        img = getImage(getCodeBase(), "com/zzk/PD4.jpg");// 獲得圖片資訊
        int w = img.getWidth(this);// 設定圖形的寬度
        int h = img.getHeight(this);// 設定圖形的高度
        Graphics2D g2d = (Graphics2D) g;// 將g轉為可以利用的Graphics2D
        g2d.drawImage(img, w - 50, h, this);// 繪製圖形
        AffineTransform tr = new AffineTransform(xw, 0, 0, 1, 150, h);// 建立仿射變換對像進行設定變換（第一個參數）
        g2d.drawImage(img, tr, this);// 繪製圖形
        
    }
    @Override
    public void run() {
        while (true) {
            if (flag) {// 標記變數為true時執行
                xw += 0.1f;// 使寬度變大
                if (xw > 2.0f) {// 寬度大於2.0時
                    flag = false;// 標記變數為false
                }
            } else {// 標記變數為false時執行
                xw -= 0.1f;// 使寬度變小
                if (xw < 0.5f) {// 寬度小於2.0時
                    flag = true;// 標記變數為true
                }
            }
            try {
                Thread.sleep(200);// 休眠200毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();// 重新呼叫paint()方法
        }
    }
}
