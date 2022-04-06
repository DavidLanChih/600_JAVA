package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class ZoomImageApplet extends Applet {
    public void paint(Graphics g) {
        String value = "縮放圖形";
        Image img = null;// 宣告圖形對像
        img = getImage(getCodeBase(), "com/zzk/PD2.jpg");// 獲得圖片資訊
        AffineTransform tr = AffineTransform.getScaleInstance(0.25, 0.25);// 建立變形以獲得縮放對像
        tr.translate(120, 100);// 設定對像平移
        AffineTransform tr2 = AffineTransform.getScaleInstance(0.15, 0.15);// 建立變形以獲得縮放對像
        tr2.translate(900, 950);// 設定對像平移
        Graphics2D g2d = (Graphics2D) g;// 將g轉換成一個可用的Graphics2D對像
        g2d.drawImage(img, tr, this);// 繪製圖形
        g2d.drawImage(img, tr2, this);// 繪製圖形
        g2d.drawString(value, 60, 150);// 繪製純文字
    }
}
