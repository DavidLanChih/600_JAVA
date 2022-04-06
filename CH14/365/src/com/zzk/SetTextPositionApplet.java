package com.zzk;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;

public class SetTextPositionApplet extends Applet {
    public void paint(Graphics g) {
        Font font = new Font("細明體", Font.PLAIN, 32);// 建立字體對像
        g.setFont(font);// 設定字體
        g.drawString("標題", 65, 40);// 繪製純文字，其位置座標為(65，40)
        font = new Font("細明體", Font.PLAIN, 16);// 建立字體對像
        g.setFont(font);// 設定字體
        g.drawString("正文一的內容", 50, 80);// 繪製純文字，其位置座標為(50，80)
        g.drawString("正文二的內容", 50, 120);// 繪製純文字，其位置座標為(50，120)
        g.drawString("正文三的內容", 50, 160);// 繪製純文字，其位置座標為(50，160)
    }
}
