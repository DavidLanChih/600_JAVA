package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class ExclusiveOrOperationApplet extends Applet {
    public void paint(Graphics g) { // 重新定義paint()方法
        Graphics2D g2d = (Graphics2D) g; // 強制轉為Graphics2D對像
        Ellipse2D.Float ellipse1 = new Ellipse2D.Float(30, 80, 180, 80);// 建立橢圓對像
        Ellipse2D.Float ellipse2 = new Ellipse2D.Float(80, 30, 80, 180);// 建立橢圓對像
        Area area1 = new Area(ellipse1);// 建立橢圓區域
        Area area2 = new Area(ellipse2);// 建立橢圓區域
        area1.exclusiveOr(area2);// 兩個區域圖形進行互斥運算
        g2d.fill(area1);// 繪製互斥運算後的區域圖形
        Ellipse2D.Float ellipse3 = new Ellipse2D.Float(270, 80, 180, 80);// 建立橢圓對像
        Ellipse2D.Float ellipse4 = new Ellipse2D.Float(270, 30, 80, 180);// 建立橢圓對像
        Area area3 = new Area(ellipse3);// 建立橢圓區域
        Area area4 = new Area(ellipse4);// 建立橢圓區域
        area3.exclusiveOr(area4);// 繪製互斥運算後的區域圖形
        g2d.fill(area3);// 繪製互斥運算後的區域圖形
    }
}
