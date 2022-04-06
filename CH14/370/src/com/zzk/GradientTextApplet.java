package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GradientTextApplet extends Applet {
    public void paint(Graphics g) { // 重新定義paint()方法
        Graphics2D g2 = (Graphics2D) g;// 轉為Graphics2D型態
        String value = "漸層色文字";// 繪製的純文字
        int x = 15; // 純文字位置的橫座標
        int y = 120; // 純文字位置的縱座標
        Font font = new Font("楷體", Font.BOLD, 60); // 建立字體對像
        g2.setFont(font); // 設定字體
        GradientPaint paint = new GradientPaint(20, 20, Color.BLUE, 100, 120,
                Color.RED, true);// 建立循環漸層的GradientPaint對像
        g2.setPaint(paint);// 設定漸層
        g2.drawString(value, x, y); // 繪製純文字
    }
}
