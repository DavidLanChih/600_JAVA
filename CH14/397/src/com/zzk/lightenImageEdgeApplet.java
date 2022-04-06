package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class lightenImageEdgeApplet extends Applet {
    private BufferedImage image;// 宣告緩衝圖形對像
    public void paint(Graphics g) {
        Image img = null;// 宣告建立圖形對像
        String value = "照亮圖形邊緣";
        img = getImage(getCodeBase(), "com/zzk/PPD.jpg");// 獲得圖片資訊
        int a = img.getWidth(this); // 獲得圖片寬度賦給變數a
        int b = img.getHeight(this);// 獲得圖片高度賦給變數b
        if (a >= 0 || b >= 0) {
            image = new BufferedImage(a, b, BufferedImage.TYPE_INT_RGB);// 建立緩衝圖形對像
            image.getGraphics().drawImage(img, 0, 0, this);// 在緩衝圖形對像上繪製圖形
            float[] f = { 0.0f, -1.5f, 0.0f, -1.5f, 6.0f, -1.5f, 0.0f, -1.5f,
                    0.0f };// 宣告表示像素份量
            Kernel kernel = new Kernel(3, 3, f);// 建立Kernel對像
            ConvolveOp op = new ConvolveOp(kernel);// 建立RescaleOp對像
            image = op.filter(image, null); // 過濾緩衝圖形對像
            g.drawImage(img, 25, 35, this);// 繪製緩衝圖形對像
            g.drawImage(image, 217, 35, this);// 繪製緩衝圖形對像
            g.drawString(value, 258, 186);// 繪製純文字
        }
    }
}
