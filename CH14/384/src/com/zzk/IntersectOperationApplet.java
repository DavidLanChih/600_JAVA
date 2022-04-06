package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class IntersectOperationApplet extends Applet {
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;// 強制轉為Graphics2D對像
        Rectangle2D.Float rect1 = new Rectangle2D.Float(0, 40, 140, 140);// 建立矩形對像
        Ellipse2D.Float ellipse1 = new Ellipse2D.Float(80, 40, 140, 140);// 建立橢圓對像
        Area area1 = new Area(rect1);// 建立矩形區域
        Area area2 = new Area(ellipse1);// 建立橢圓區域
        area1.intersect(area2);// 兩個區域相交
        g2d.fill(area1);// 繪製相交後的區域圖形
        Rectangle2D.Float rect2 = new Rectangle2D.Float(240, 0, 160, 160);// 建立矩形對像
        Ellipse2D.Float ellipse2 = new Ellipse2D.Float(190, 60, 140, 140);// 建立橢圓對像
        Area area3 = new Area(rect2);// 建立矩形區域
        Area area4 = new Area(ellipse2);// 建立橢圓區域
        area3.intersect(area4);// 兩個區域相交
        g2d.fill(area3);// 繪製相交後的區域圖形
    }
}
