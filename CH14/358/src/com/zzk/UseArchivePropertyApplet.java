package com.zzk;

import javax.swing.JApplet;

public class UseArchivePropertyApplet extends JApplet {
    public void init() {
        // 使用與html檔案關聯的NewPanelApp.jar檔案中的NewPanel類別建立對像
        npanel.NewPanel npanel = new npanel.NewPanel();
        setLayout(null);// 設定容器為絕對佈局
        npanel.setBounds(10, 10, 254, 167);// 設定NewPanel對象的顯示位置和大小
        add(npanel);// 將NewPanel對像增加到容器中
    }
}
