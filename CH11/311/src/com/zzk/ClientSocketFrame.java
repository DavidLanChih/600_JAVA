package com.zzk;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.JScrollPane;

public class ClientSocketFrame extends JFrame { // 建立類別繼承JFrame類別
    private PrintWriter writer; // 宣告PrintWriter類別對像
    private Socket socket; // 宣告Socket對像
    private JTextArea ta_info = new JTextArea(); // 建立JtextArea對像
    private JTextField tf_send = new JTextField(); // 建立JtextField對像
    private Container cc; // 宣告Container對像
    
    public ClientSocketFrame() { // 建構方法
        super(); // 呼叫父類別的建構方法
        setTitle("客戶端程式");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 351, 257);
        cc = this.getContentPane(); // 實例化對像
        cc.add(tf_send, "South"); // 將純文字框放在窗體的下部
        tf_send.addActionListener(new ActionListener() { // 綁定事件
                    public void actionPerformed(ActionEvent e) {
                        writer.println(tf_send.getText()); // 將純文字框中資訊寫入流
                        ta_info.append("客戶端發送的資訊是：" + tf_send.getText() + "\n"); // 將純文字框中資訊顯示在純文字域中
                        tf_send.setText(""); // 將純文字框清空
                    }
                });
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta_info);
    }
    
    private void connect() { // 連接套接字方法
        ta_info.append("嘗試連接......\n"); // 純文字域中資訊資訊
        try { // 捕捉例外
            socket = new Socket("localhost", 1978); // 實例化Socket對像
            writer = new PrintWriter(socket.getOutputStream(), true);// 建立輸出流對像
            ta_info.append("完成連接。\n"); // 純文字域中提示資訊
        } catch (Exception e) {
            e.printStackTrace(); // 輸出例外資訊
        }
    }
    
    public static void main(String[] args) { // 主方法
        ClientSocketFrame clien = new ClientSocketFrame(); // 建立本例對像
        clien.setVisible(true); // 將窗體顯示
        clien.connect(); // 呼叫連接方法
    }
}
