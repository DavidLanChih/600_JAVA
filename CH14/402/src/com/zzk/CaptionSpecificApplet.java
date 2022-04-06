package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class CaptionSpecificApplet extends Applet implements Runnable {
    int x = 50;// 儲存繪製點的x座標
    int y = 216;// 儲存繪製點的y座標
    String value = "明日圖書網的網址";// 儲存繪製的內容
    public void start() {
        Thread thread = new Thread(this);// 建立線程對像
        thread.start();// 啟動線程對像
    }
    public void paint(Graphics g) {
        g.clearRect(0, 0, 316, 237);// 清除繪圖上下文內容
        Image img = null;// 宣告圖片對像
        img = getImage(getCodeBase(), "com/zzk/PD3.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);// 繪製圖形
        Font font = new Font("華文楷體", Font.BOLD, 20);// 建立字體對像
        g.setFont(font);// 指定字體
        g.setColor(Color.RED);// 指定顏色
        g.drawString(value, x, y);// 繪製純文字
    }
    public void run() {
        try {
            while (true) { // 讀取內容
                Thread.sleep(100); // 目前線程休眠1秒
                if (y <= 216 - 50) {// 如果已經向上移動50像素
                    y = 216;// y座標定位到最下方
                    if (value.equals("明日圖書網的網址")) {
                        value = "http://www.mingribook.com";// 改變繪製的內容
                    } else {
                        value = "明日圖書網的網址";// 改變繪製的內容
                    }
                } else {// 如果還沒向上移動到50像素
                    y -= 2;// y座標上移
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