package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.ShortLookupTable;

public class NegativeImageApplet extends Applet {
    private BufferedImage image;// 宣告緩衝圖形對像
    public void paint(Graphics g) {
        String value = "反向圖形";
        Image img = null;// 宣告圖形對像
        img = getImage(getCodeBase(), "com/zzk/PD3.jpg");// 獲得圖片資訊
        int a = img.getWidth(this); // 獲得圖片寬度賦給變數a
        int b = img.getHeight(this);// 獲得圖片高度賦給變數b
        if (a >= 0 || b >= 0) {
            image = new BufferedImage(img.getWidth(this), img.getHeight(this),
                    BufferedImage.TYPE_INT_RGB);// 建立緩衝圖形對像
            image.getGraphics().drawImage(img, 0, 0, null);// 在緩衝圖形對像上繪製圖形
            short[] negative = new short[256 * 1];// 建立表示顏色反向的份量陣列
            for (int i = 0; i < 256; i++) {
                negative[i] = (short) (255 - i);// 為陣列給予值
            }
            ShortLookupTable table = new ShortLookupTable(0, negative);// 建立尋找表對像
            LookupOp op = new LookupOp(table, null);// 建立實現從源到目標尋找操作的LookupOp對像
            image = op.filter(image, null);// 呼叫LookupOp對象的filter()方法，實現圖形反向功能
            if (image != null) {
                g.drawImage(img, 35, 40, null);// 繪製緩衝圖形對像
                g.drawImage(image, 220, 40, null);// 繪製緩衝圖形對像
            }
            g.drawString(value, 265, 175);// 繪製純文字
        }
    }
}