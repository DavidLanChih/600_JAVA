package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawPasswordWithDisturbApplet extends Applet {
    int WIDTH = 120;// 設定寬度
    int HEIGHT = 35;// 設定高度
    private String num = "";// 驗證碼
    Random random = new Random();// 實例化Random
    public void paint(Graphics g) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);// 實例化BufferedImage
        Graphics gs = image.getGraphics(); // 獲得Graphics類別的對像
        if (!num.isEmpty()) {
            num = "";// 清空驗證碼
        }
        Font font = new Font("黑體", Font.BOLD, 20); // 透過Font建構字體
        gs.setFont(font);// 設定字體
        gs.fillRect(0, 0, WIDTH, HEIGHT);// 填充一個矩形
        Image img = null;
        img = getImage(getCodeBase(), "com/zzk/PPD.jpg"); // 建立圖形對像
        gs.drawImage(img, 0, 0, WIDTH, HEIGHT, this);// 在緩衝圖形對像上繪製圖形
        int startX1 = random.nextInt(20);// 隨機獲得第一條干擾線起點的x座標
        int startY1 = random.nextInt(20);// 隨機獲得第一條干擾線起點的y座標
        int startX2 = random.nextInt(30) + 35;// 隨機獲得第一條干擾線終點的x座標，也是第二條干擾線起點的x座標
        int startY2 = random.nextInt(10) + 20;// 隨機獲得第一條干擾線終點的y座標，也是第二條干擾線起點的y座標
        int startX3 = random.nextInt(30) + 90;// 隨機獲得第二條干擾線終點的x座標
        int startY3 = random.nextInt(10) + 5;// 隨機獲得第二條干擾線終點的y座標
        gs.setColor(Color.RED);
        gs.drawLine(startX1, startY1, startX2, startY2);// 繪製第一條干擾線
        gs.setColor(Color.BLUE);
        gs.drawLine(startX2, startY2, startX3, startY3);// 繪製第二條干擾線
        for (int i = 0; i < 4; i++) {// 輸出隨機的驗證文字
            char ctmp = (char) (random.nextInt(26) + 65); // 產生A~Z的字母
            num += ctmp;// 更新驗證碼
            Color color = new Color(20 + random.nextInt(120), 20 + random
                    .nextInt(120), 20 + random.nextInt(120));// 產生隨機顏色
            gs.setColor(color); // 設定顏色
            Graphics2D gs2d = (Graphics2D) gs;// 將文字旋轉指定角度
            AffineTransform trans = new AffineTransform();// 實例化AffineTransform
            trans.rotate(random.nextInt(45) * 3.14 / 180, 22 * i + 8, 7);
            float scaleSize = random.nextFloat() + 0.8f;// 縮放文字
            if (scaleSize > 1f)
                scaleSize = 1f;// 如果scaleSize大於1,則使其等於1
            trans.scale(scaleSize, scaleSize); // 進行縮放
            gs2d.setTransform(trans);// 設定AffineTransform對像
            gs2d.drawString(String.valueOf(ctmp), WIDTH / 6 * i + 28, HEIGHT / 2);// 畫出驗證碼
        }
        g.drawImage(image, 85, 80, null);// 在小應用程式中繪製含有圖片和干擾線驗證碼的緩衝圖形
    }
}