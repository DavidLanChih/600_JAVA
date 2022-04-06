package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class RollTextApplet extends Applet implements Runnable {
    String value = "明日圖書網的網址：http://www.mingribook.com";// 存放繪製的內容
    int x;// 設定橫座標
    int y;// 設定縱座標
    public void init() { // 初始化方法
        x = 316;// 儲存繪製點的x座標
        y = 190;// 儲存繪製點的y座標
    }
    public void start() {
        Thread thread = new Thread(this);// 建立線程對像
        thread.start();// 啟動線程對像
    }
    public void paint(Graphics g) {
        Image img = null;// 宣告圖形對像
        img = getImage(getCodeBase(), "com/zzk/PD3.jpg");// 獲得圖片資源路徑
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);// 繪製圖形
        g.clearRect(0, 0, 0, 230);// 清除繪圖上下文的內容
        g.setColor(Color.BLACK);// 定義顏色
        Font font = new Font("華文楷體", Font.BOLD, 20);// 建立字體對像
        g.setFont(font);// 定義字體
        g.drawString(value, x, y);// 繪製純文字
    }
    public void run() {
        try {
            while (true) { // 讀取內容
                Thread.sleep(50); // 目前線程休眠1秒
                if (x <= -440) {// 該條件可以根據需要自行調整
                    x = 316;// x座標定位到最右側
                } else {
                    x -= 2;// x座標左移
                }
                repaint();// 呼叫paint()方法
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(Graphics g) { // 重新定義update()方法防止閃爍
        paint(g);
    }
}
