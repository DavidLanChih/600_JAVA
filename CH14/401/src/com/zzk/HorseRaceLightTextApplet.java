package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class HorseRaceLightTextApplet extends Applet implements Runnable {
    public void start() {
        Thread thread = new Thread(this);// 建立線程
        thread.start();// 啟動線程對像
    }
    String value = "擁有編程詞典，學習編程真輕鬆。";// 儲存繪製的內容
    char[] drawChar = value.toCharArray();// 將繪製內容轉為字符陣列
    int[] x = new int[drawChar.length];// 儲存每個字符繪製點x座標的陣列
    int y = 100;// 儲存繪製點y座標
    
    public void paint(Graphics g) {
        Image img = null;
        img = getImage(getCodeBase(), "com/zzk/PD3.jpg"); // 建立圖形對像
        g.clearRect(0, 0, getWidth(), getHeight());// 清除繪圖上下文內容
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);// 繪製圖形
        Font font = new Font("華文楷體", Font.BOLD, 20);// 建立字體對像
        g.setFont(font);// 指定字體
        g.setColor(Color.RED);// 指定顏色
        for (int j = drawChar.length - 1; j >= 0; j--) {
            g.drawString(drawChar[drawChar.length - 1 - j] + "", x[j], y);// 繪製純文字
        }
    }
    public void run() {
        boolean flag = false;// 為false時表示第一次執行,x座標進行等比遞增,否則進行等差遞減
        while (true) {// 讀取內容
            try {
                for (int i = drawChar.length - 1; i >= 0; i--) {
                    if (!flag) {
                        x[i] = x[i] + 20 * i;// x座標進行等比遞增
                    } else {
                        x[i] = x[i] + 20;// x座標進行等比遞減
                    }
                    if (x[i] >= 360 - 20) {// 大於窗體寬度減20的值時
                        x[i] = 0; // x座標為0
                    }
                }
                repaint();// 呼叫 paint()方法
                if (!flag) {
                    flag = true;// 給予值為true;
                }
                Thread.sleep(1000);// 目前線程休眠300毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void update(Graphics g) { // 重新定義update()方法防止閃爍
        paint(g);
    }
}
