package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class DrawGrainApplet extends Applet {
    private BufferedImage img;// 宣告圖形對像
    public void init() { // 初始化方法
        img = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);// 建立緩衝對像
        Graphics2D g = img.createGraphics();// 建立Graphics2D對像
        g.setPaint(Color.yellow);// 指定顏色
        g.draw(new Rectangle(0, 0, 25, 25));// 繪製矩形
        g.setPaint(Color.red);// 指定顏色
        g.fill(new Rectangle(25, 0, 25, 25));// 填充矩形
        g.setPaint(Color.green);// 指定顏色
        g.fill(new Rectangle(0, 0, 25, 25));// 填充矩形
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;// 強制轉為Graphics2D對像
        g2d.setPaint(new TexturePaint(img, new Rectangle(0, 0, 10, 10)));// 建立紋理並把它加到Graphics中
        g2d.fill(new Ellipse2D.Double(10, 10, 260, 145));// 填充圖形
    }
}
