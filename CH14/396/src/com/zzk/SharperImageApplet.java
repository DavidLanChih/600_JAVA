package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class SharperImageApplet extends Applet {
    private BufferedImage image;// 宣告緩衝圖形對像
    public void paint(Graphics g) {
        Image img = null;// 宣告建立圖形對像
        String value = "銳化圖形";
        img = getImage(getCodeBase(), "com/zzk/PPD.jpg");// 獲得圖片資訊
        int a = img.getWidth(this); // 獲得圖片寬度賦給變數a
        int b = img.getHeight(this);// 獲得圖片高度賦給變數b
        if (a >= 0 || b >= 0) {
            image = new BufferedImage(img.getWidth(this), img.getHeight(this),
                    BufferedImage.TYPE_INT_RGB);// 建立緩衝圖形對像
            image.getGraphics().drawImage(img, 0, 0, null);// 在緩衝圖形對像上繪製圖形
            float[] data = { 0.0f, -1.0f, 0.0f, -1.0f, 6.0f, -1.0f, 0.0f,
                    -1.0f, 0.0f };// 宣告表示像素份量的陣列
            Kernel kernel = new Kernel(3, 3, data); // 建立 Kernel對像
            ConvolveOp op = new ConvolveOp(kernel);// 建立ConvolveOp對像
            image = op.filter(image, null); // 過濾緩衝圖形對像
            g.drawImage(img, 25, 35, this);// 繪製緩衝圖形對像
            g.drawImage(image, 215, 35, this);// 繪製緩衝圖形對像
            g.drawString(value, 275, 182);// 繪製純文字
        }
    }
}
