package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class SlantImageApplet extends Applet {
    public void paint(Graphics g) {
        String value = "傾斜圖形";
        Image img = null;// 宣告圖形對像
        img = getImage(getCodeBase(), "com/zzk/PD5.jpg");// 獲得圖片資訊
        Graphics2D g2d = (Graphics2D) g;// 強制轉為Graphics2D對像
        g2d.drawString(value, 209, 170);// 繪製純文字
        AffineTransform tr = new AffineTransform();// 建立AffineTransform對像
        tr.translate(210, 32);// 圖形位置的平移
        tr.shear(3, 3);// 傾斜圖形
        g2d.drawImage(img, tr, this);// 繪製圖形
        AffineTransform tr1 = AffineTransform.getScaleInstance(3.5, 3.5);// 獲得AffineTransform對像
        tr1.translate(15, 13);// 圖形位置的平移
        g2d.drawImage(img, tr1, this);// 繪製圖形
    }
}
