package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawOvalApplet extends Applet{
	public void paint(Graphics g){
		String value = "µe¾ò¶ê";
		int x = 25;// ¾ò¶ê¦ì¸m¾î®y¼Ð
		int y = 40;// ¾ò¶ê¦ì¸m
		int xr = 150;// ¾ò¶êªº¾î®y¼Ð¥b®|
		int yr = 150;// ¾ò¶êªºÁa®y¼Ð¥b®|
		g.drawOval(x, y, xr, yr);// Ã¸»s¾ò¶ê
		
		int x0 = 67;// ¾ò¶ê¦ì¸m¾î®y¼Ð
		int y0 = 40;// ¾ò¶ê¦ì¸m
		int xr0 = 65;// ¾ò¶êªº¾î®y¼Ð¥b®|
		int yr0 = 150;// ¾ò¶êªºÁa®y¼Ð¥b®|
		g.setColor(Color.blue);// ³]©wÃC¦â
		g.drawOval(x0, y0, xr0, yr0);// Ã¸»s¾ò¶ê
		g.drawString(value, 150, 210);// Ã¸»s¯Â¤å¦r
		
	}
}
