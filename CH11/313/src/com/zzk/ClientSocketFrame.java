package com.zzk;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ClientSocketFrame extends JFrame { // 建立類別繼承JFrame類別
    private JLabel label;
    private JPanel panel;
    private PrintWriter writer; // 宣告PrintWriter類別對像
    private BufferedReader reader; // 宣告BufferedReader對像
    private Socket socket; // 宣告Socket對像
    private JTextArea ta_info = new JTextArea(); // 建立JtextArea對像
    private JTextField tf_send = new JTextField(); // 建立JtextField對像
    
    public ClientSocketFrame() { // 建構方法
        super(); // 呼叫父類別的建構方法
        setTitle("客戶端程式");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 361, 257);
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta_info);
        getContentPane().add(getPanel(), BorderLayout.NORTH);
    }
    
    private void connect() { // 連接套接字方法
        ta_info.append("嘗試連接......\n"); // 純文字域中資訊資訊
        try { // 捕捉例外
            socket = new Socket("localhost", 1978); // 實例化Socket對像
            while (true) {
                writer = new PrintWriter(socket.getOutputStream(), true);
                reader = new BufferedReader(new InputStreamReader(socket
                        .getInputStream())); // 實例化BufferedReader對像
                ta_info.append("完成連接。\n"); // 純文字域中提示資訊
                getClientInfo();
            }
        } catch (Exception e) {
            e.printStackTrace(); // 輸出例外資訊
        }
    }
    
    public static void main(String[] args) { // 主方法
        ClientSocketFrame clien = new ClientSocketFrame(); // 建立本例對像
        clien.setVisible(true); // 將窗體顯示
        clien.connect(); // 呼叫連接方法
    }
    
    private void getClientInfo() {
        try {
            while (true) { // 如果套接字是連接狀態
                if (reader != null) {
                    String line = reader.readLine();
                    if (line != null)
                        ta_info.append("接收到服務器發送的資訊：" + line + "\n"); // 獲得客戶端資訊
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    
                    reader.close();// 關閉流
                    
                }
                if (socket != null) {
                    socket.close(); // 關閉套接字
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * @return
     */
    protected JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel();
            panel.add(getLabel());
            tf_send.setPreferredSize(new Dimension(200, 25));
            panel.add(tf_send);
            tf_send.addActionListener(new ActionListener() { // 綁定事件
                        public void actionPerformed(ActionEvent e) {
                            writer.println(tf_send.getText()); // 將純文字框中資訊寫入流
                            ta_info.append("客戶端發送的資訊是：" + tf_send.getText()
                                    + "\n"); // 將純文字框中資訊顯示在純文字域中
                            tf_send.setText(""); // 將純文字框清空
                        }
                    });
        }
        return panel;
    }
    
    /**
     * @return
     */
    protected JLabel getLabel() {
        if (label == null) {
            label = new JLabel();
            label.setText("客戶端發送的資訊：");
        }
        return label;
    }
}
