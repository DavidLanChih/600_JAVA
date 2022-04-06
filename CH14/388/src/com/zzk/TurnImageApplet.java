package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class TurnImageApplet extends Applet {
    public void paint(Graphics g) {
        String value = "翻轉圖形";
        Image img = null;// 宣告圖形對像
        img = getImage(getCodeBase(), "com/zzk/PD4.jpg");// 獲得圖片資訊
        int w = img.getWidth(this);// 設定圖形的寬度
        int h = img.getHeight(this);// 設定圖形的高度
        Graphics2D g2d = (Graphics2D) g;// 將g轉為可以利用的Graphics2D
        g2d.drawString(value, 100, 130);// 繪製純文字
        AffineTransform tr = new AffineTransform(-1, 0, 0, 1, w, 0);// 建立變換對象並水平翻轉
        AffineTransform tr2 = new AffineTransform(1, 0, 0, -1, 0, h);// 建立變換對象並垂直翻轉
        tr.translate(-20, 40);// 圖形位置的平移
        tr2.translate(120, -40);// 圖形位置的平移
        g2d.drawImage(img, tr, this);// 繪製圖形
        g2d.drawImage(img, tr2, this);// 繪製圖形
    }
}
