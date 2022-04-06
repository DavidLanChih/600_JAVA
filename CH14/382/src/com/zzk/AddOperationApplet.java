package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class AddOperationApplet extends Applet {
    public void paint(Graphics g) {
        String value = "圖形相加運算";
        Graphics2D g2d = (Graphics2D) g;// p轉為可用的Graphics2D對像
        Rectangle2D.Float rect1 = new Rectangle2D.Float(20, 70, 185, 60);// 建立矩形對像
        Rectangle2D.Float rect2 = new Rectangle2D.Float(120, 20, 65, 160);// 建立矩形對像
        Area area1 = new Area(rect1);// 建立區域矩形
        Area area2 = new Area(rect2);// 建立區域矩形
        area1.add(area2);// 兩個區域進行相加
        g2d.draw(area1);// 繪製相加後的區域矩形
        Rectangle2D.Float rect3 = new Rectangle2D.Float(230, 70, 185, 60);// 建立矩形對像
        Rectangle2D.Float rect4 = new Rectangle2D.Float(290, 20, 65, 160);// 建立矩形對像
        Area area3 = new Area(rect3);// 建立區域矩形
        Area area4 = new Area(rect4);// 建立區域矩形
        area3.add(area4);// 兩個區域進行相加
        g2d.draw(area3);// 繪製相加後的區域矩形
        g2d.drawString(value, 25, 56);// 繪製純文字
    }
}
