package com.zzk;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.JScrollPane;

public class ClientSocketFrame extends JFrame { // �إ����O�~��JFrame���O
    private PrintWriter writer; // �ŧiPrintWriter���O�ﹳ
    private Socket socket; // �ŧiSocket�ﹳ
    private JTextArea ta_info = new JTextArea(); // �إ�JtextArea�ﹳ
    private JTextField tf_send = new JTextField(); // �إ�JtextField�ﹳ
    private Container cc; // �ŧiContainer�ﹳ
    
    public ClientSocketFrame() { // �غc��k
        super(); // �I�s�����O���غc��k
        setTitle("�Ȥ�ݵ{��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 351, 257);
        cc = this.getContentPane(); // ��Ҥƹﹳ
        cc.add(tf_send, "South"); // �N�¤�r�ة�b���骺�U��
        tf_send.addActionListener(new ActionListener() { // �j�w�ƥ�
                    public void actionPerformed(ActionEvent e) {
                        writer.println(tf_send.getText()); // �N�¤�r�ؤ���T�g�J�y
                        ta_info.append("�Ȥ�ݵo�e����T�O�G" + tf_send.getText() + "\n"); // �N�¤�r�ؤ���T��ܦb�¤�r�줤
                        tf_send.setText(""); // �N�¤�r�زM��
                    }
                });
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta_info);
    }
    
    private void connect() { // �s���M���r��k
        ta_info.append("���ճs��......\n"); // �¤�r�줤��T��T
        try { // �����ҥ~
            socket = new Socket("localhost", 1978); // ��Ҥ�Socket�ﹳ
            writer = new PrintWriter(socket.getOutputStream(), true);// �إ߿�X�y�ﹳ
            ta_info.append("�����s���C\n"); // �¤�r�줤���ܸ�T
        } catch (Exception e) {
            e.printStackTrace(); // ��X�ҥ~��T
        }
    }
    
    public static void main(String[] args) { // �D��k
        ClientSocketFrame clien = new ClientSocketFrame(); // �إߥ��ҹﹳ
        clien.setVisible(true); // �N�������
        clien.connect(); // �I�s�s����k
    }
}
