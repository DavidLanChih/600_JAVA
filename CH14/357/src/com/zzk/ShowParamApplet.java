package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class ShowParamApplet extends Applet {
    String id;// 宣告成員變數
    String name;// 宣告成員變數
    String sex;// 宣告成員變數
    public void init() {
        id = getParameter("id");// 獲得參數id的值
        name = getParameter("name");// 獲得參數name的值
        sex = getParameter("sex");// 獲得參數sex的值
    }
    public void paint(Graphics g) {
        g.setColor(Color.blue);// 設定顏色
        g.drawString("學號：", 30, 10);// 繪製純文字
        g.drawString(id, 70, 10);// 繪製獲得的id值
        g.drawString("姓名：", 30, 30);// 繪製純文字
        g.drawString(name, 70, 30);// 繪製獲得的name值
        g.drawString("性別：", 30, 50);// 繪製純文字
        g.drawString(sex, 70, 50);// 繪製獲得的sex值
    }
}
