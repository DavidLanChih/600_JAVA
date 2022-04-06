package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class TextFlashApplet extends Applet implements Runnable {
    boolean flag = true;// 標記變數
    String value = "";// 存放繪製內容的變數
    public void start() {
        Thread thread = new Thread(this);// 建立線程對像
        thread.start();// 啟動線程對像
    }
    public void paint(Graphics g) {
        Image img = null;// 宣告圖形對像
        img = getImage(getCodeBase(), "com/zzk/PD3.jpg");
        g.clearRect(0, 0, 310, 230);// 清除繪圖上下文的內容
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        Font font = new Font("華文楷體", Font.BOLD, 42);// 建立字體對像
        g.setFont(font);// 指定字體
        g.setColor(Color.red);// 指定顏色
        g.drawString(value, 30, 110);// 繪製純文字
    }
    public void run() {
        try {
            while (true) { // 讀取內容
                Thread.sleep(150);// 目前線程休眠150秒
                if (flag) {// flag為true
                    flag = false; // 給予值為false
                    value = "JAVA編程詞典";// 為value給予值
                } else {
                    flag = true;// 給予值為true
                    value = "";// 給予值為空字符竄
                }
                repaint();// 呼叫paint()方法
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
