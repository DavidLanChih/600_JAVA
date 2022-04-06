package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class DrawImageApplet extends Applet {
    public void paint(Graphics g) {// 初始化方法
        String value = "繪製圖片";
        Image image = null;// 宣告圖形對像
        image = getImage(getCodeBase(), "com/zzk/PD2.jpg");// 獲得圖片資訊
        int x = 10;// 圖形位置的橫座標
        int y = 20;// 圖形位置的縱座標
        int width = image.getWidth(this);// 獲得圖形的寬度
        int height = image.getHeight(this);// 獲得圖形的高度
        g.drawImage(image, x + 150, y + 30, width / 5, height / 5, this);// 繪製圖形
        g.drawImage(image, x + 25, y + 10, (int) (width * 0.2),
                (int) (height * 0.3), this);// 繪製圖形
        g.drawString(value, 140, 170);// 繪製純文字
    }
}
