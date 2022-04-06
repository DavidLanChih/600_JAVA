package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class ChangeTextColorApplet extends Applet implements Runnable {
    Color color = new Color(0, 0, 255);// 建立顏色對像
    public void init() {
        Thread thread = new Thread(this);// 建立線程對像
        thread.start();// 啟動線程對像
    }
    public void paint(Graphics g) { // 重新定義paint()方法
        Graphics2D g2 = (Graphics2D) g;// 轉為Graphics2D型態
        String value = "會變色的文字";// 繪製的純文字
        int x = 10; // 純文字位置的橫座標
        int y = 110; // 純文字位置的縱座標
        Font font = new Font("楷體", Font.BOLD, 40); // 建立字體對像
        g2.setFont(font); // 設定字體
        g2.setColor(color);// 設定顏色
        g2.drawString(value, x, y); // 繪製純文字
    }
    public void run() {
        Random random = new Random();// 建立隨機數對像
        while (true) {
            int R = random.nextInt(256);// 隨機產生顏色的R值
            int G = random.nextInt(256);// 隨機產生顏色的G值
            int B = random.nextInt(256);// 隨機產生顏色的B值
            color = new Color(R, G, B);// 建立顏色對像
            repaint();// 呼叫paint()方法
            try {
                Thread.sleep(300);// 休眠300毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
