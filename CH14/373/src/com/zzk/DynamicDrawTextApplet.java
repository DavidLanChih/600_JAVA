package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class DynamicDrawTextApplet extends Applet implements Runnable {
    int x = 20;// 起始點的x座標
    int y = 30;// 起始點的y座標
    String textStrings = "小應用程式中縮放圖形\n小應用程式中翻轉圖形\n小應用程式中旋轉圖形\n小應用程式中傾斜圖形";// 需要動態繪製的字串
    String value = "";// 儲存字串中的單一字符
    public void init() {
        Thread thread = new Thread(this);// 建立線程對像
        thread.start();// 啟動線程對像
    }
    public void paint(Graphics g) {
        Font font = new Font("華文楷體", Font.BOLD, 20);// 建立字體對像
        g.setFont(font);// 指定字體
        g.setColor(Color.RED);// 指定顏色
        g.drawString(value, x, y);// 繪製純文字
    }
    public void update(Graphics g) {// 重新定義update方法，防止無法顯示繪製的所有內容
        paint(g);// 呼叫paint()方法
    }
    public void run() {
        try {
            for (int i = 0; i < textStrings.length(); i++) {
                Thread.sleep(400); // 目前線程休眠400毫秒
                value = textStrings.substring(i, i + 1);// 截取字串中的一個字符
                if (value.equals("\n")) {// 是換行符
                    x = 20;// 下一行起始點的x座標
                    y += 30;// 下一行純文字的y座標
                } else {// 不是確認或換行符
                    x += 20;// 目前行下一個字的x座標
                }
                repaint();// 呼叫paint()方法
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
