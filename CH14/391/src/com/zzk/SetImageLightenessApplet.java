package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class SetImageLightenessApplet extends Applet {
    private BufferedImage image;// 宣告緩衝圖形對像
    public void paint(Graphics g) {
        Image img = null;// 宣告圖形對像
        String value = "調整圖片亮度";
        img = getImage(getCodeBase(), "com/zzk/PPD.jpg");// 獲得圖形對像
        int a = img.getWidth(this); // 獲得圖片寬度賦給變數a
        int b = img.getHeight(this);// 獲得圖片高度賦給變數b
        if (a >= 0 || b >= 0) {
            image = new BufferedImage(img.getWidth(this), img.getHeight(this),
                    BufferedImage.TYPE_INT_RGB);// 建立緩衝圖形對像
            image.getGraphics().drawImage(img, 0, 0, null);// 在緩衝圖形對像上繪製圖形
            float fa = 2.0f;// 宣告表示像素份量
            float fb = -30.0f;// 宣告表示像素份量
            RescaleOp op = new RescaleOp(fa, fb, null);// 建立RescaleOp對像
            image = op.filter(image, null); // 過濾緩衝圖形對象，實現調整圖形亮度的功能
            g.drawImage(img, 30, 40, this);// 繪製原圖形對像
            g.drawImage(image, 220, 40, this);// 繪製調整亮度後的緩衝圖形對像
            g.drawString(value, 265, 188);// 繪製純文字
        }
    }
}
