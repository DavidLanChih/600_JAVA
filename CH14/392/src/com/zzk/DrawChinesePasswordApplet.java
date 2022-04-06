package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawChinesePasswordApplet extends Applet {
    int WIDTH = 120;// 寬度
    int HEIGHT = 35;// 高度
    private String num = "";// 驗證碼
    Random random = new Random();// 實例化Random
    public void paint(Graphics g) {
        String hanZi = "本實例透過從字串中隨機獲得四個字符實現了中文驗證碼的功能";// 定義驗證碼使用的中文字
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);// 實例化BufferedImage
        Graphics gs = image.getGraphics(); // 獲得Graphics類別的對像
        if (!num.isEmpty()) {
            num = "";// 清空驗證碼
        }
        Font font = new Font("黑體", Font.BOLD, 20); // 透過Font建構字體
        gs.setFont(font);// 設定字體
        gs.fillRect(0, 0, WIDTH, HEIGHT);// 填充一個矩形
        // 輸出隨機的驗證文字
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(hanZi.length());// 隨機獲得中文字的索引值
            String ctmp = hanZi.substring(index, index + 1);// 獲得指定索引處的一個中文字
            num += ctmp;// 更新驗證碼
            Color color = new Color(20 + random.nextInt(120), 20 + random
                    .nextInt(120), 20 + random.nextInt(120));// 產生隨機顏色
            gs.setColor(color); // 設定顏色
            Graphics2D gs2d = (Graphics2D) gs;// 將文字旋轉指定角度
            AffineTransform trans = new AffineTransform();// 實例化AffineTransform
            trans.rotate(random.nextInt(45) * 3.14 / 180, 22 * i + 8, 7);
            float scaleSize = random.nextFloat() + 0.8f;// 縮放文字
            if (scaleSize > 1f)
                scaleSize = 1f;// 如果scaleSize大於1,則等於1
            trans.scale(scaleSize, scaleSize); // 進行縮放
            gs2d.setTransform(trans);// 設定AffineTransform對像
            gs2d.drawString(ctmp, WIDTH / 6 * i + 28, HEIGHT / 2);// 畫出驗證碼
        }
        g.drawImage(image, 85, 80, null);// 在小應用程式中繪製驗證碼
    }
}
