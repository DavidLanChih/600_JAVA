package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageRotateApplet extends Applet {
    public void paint(Graphics g) {
        String value = "旋轉圖形";
        Image img = null;// 宣告圖形對像
        img = getImage(getCodeBase(), "com/zzk/PD2.jpg");// 獲得圖片資訊
        Graphics2D g2d = (Graphics2D) g; // 強制轉為Graphics2D對像
        g2d.drawString(value, 180, 150);// 繪製純文字
        int x = 50;// 圖形位置的橫座標
        int y = -10;// 圖形位置的縱座標
        int w = img.getWidth(this);// 獲得圖片的寬度
        int h = img.getHeight(this);// 獲得圖片的高度
        g2d.drawImage(img, x, y + 50, w / 5, h / 5, this);// 繪製圖形
        g2d.drawImage(img, x + 150, y + 50, w / 5, h / 5, this);// 繪製圖形
        AffineTransform tr = new AffineTransform();// 建立變形對像
        tr.rotate(90, 15, 15, 65);// 設定旋轉角度
        g2d.setTransform(tr);// 執行旋轉
        g2d.drawImage(img, x + 150, y + 20, w / 5, h / 5, this);// 繪製圖形
        tr.rotate(35, 15, 30, 65);// 設定旋轉角度
        g2d.setTransform(tr);// 執行旋轉
        g2d.drawImage(img, x + 120, y - 60, w / 5, h / 5, this);// 繪製圖形
    }
}