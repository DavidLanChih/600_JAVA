package com.zzk;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientFrame extends JFrame {
    private JTextField tf_newUser;
    private JList user_list;
    private JTextArea ta_info;
    private JTextField tf_send;
    private ObjectOutputStream out;// �ŧi��X�y�ﹳ
    private boolean loginFlag = false;// ��true�ɪ��ܤw�g�n�J�A��false�ɪ��ܥ��n�J
    
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChatClientFrame frame = new ChatClientFrame();
                    frame.setVisible(true);
                    frame.createClientSocket();// �I�s��k�إ߮M���r�ﹳ
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public void createClientSocket() {
        try {
            Socket socket = new Socket("localhost", 1982);// �إ߮M���r�ﹳ
            out = new ObjectOutputStream(socket.getOutputStream());// �إ߿�X�y�ﹳ
            new ClientThread(socket).start();// �إߨñҰʽu�{�ﹳ
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    class ClientThread extends Thread {
        Socket socket;
        public ClientThread(Socket socket) {
            this.socket = socket;
        }
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));// �إ߿�J�y�ﹳ
                DefaultComboBoxModel model = (DefaultComboBoxModel) user_list
                        .getModel();// ��o�C���ت��ҫ�
                while (true) {
                    String info = in.readLine().trim();// Ū����T
                    if (!info.startsWith("MSG:")) {// �����쪺���O�T��
                        if (info.startsWith("�h�X�G")) {// �����쪺�O�h�X�T��
                            model.removeElement(info.substring(3));// �q�ϥΪ̦C���������ϥΪ�
                        } else {// �����쪺�O�n�J�ϥΪ�
                            boolean itemFlag = false;// �аO�O�_���C���ؼW�[�C�O���A��true���W�[�A��false�W�[
                            for (int i = 0; i < model.getSize(); i++) {// ��ϥΪ̦C���i���ˬd
                                if (info.equals((String) model.getElementAt(i))) {// �p�G�ϥΪ̦C�����s�b�ӨϥΪ̦W��
                                    itemFlag = true;// �]�w��true�A���ܤ��W�[��ϥΪ̦C��
                                    break;// ����for�`��
                                }
                            }
                            if (!itemFlag) {
                                    model.addElement(info);// �N�n�J�ϥΪ̼W�[��ϥΪ̦C��
                            } 
                        }
                    } else {// �p�G��o���O�T���A�h�b�¤�r�줤��ܱ����쪺�T��
                        DateFormat df = DateFormat.getDateInstance();// ��oDateFormat���
                        String dateString = df.format(new Date());         // �榡�Ƭ����
                        df = DateFormat.getTimeInstance(DateFormat.MEDIUM);// ��oDateFormat���
                        String timeString = df.format(new Date());         // �榡�Ƭ��ɶ�
                        String sendUser = info.substring(4,info.indexOf("�G�o�e���G"));// ��o�o�e��T���ϥΪ�
                        String receiveInfo = info.substring(info.indexOf("�G����T�O�G")+6);// ��o�����쪺��T
                        ta_info.append("  "+sendUser + "    " +dateString+"  "+timeString+"\n  "+receiveInfo+"\n");// �b�¤�r�줤��ܸ�T
                        ta_info.setSelectionStart(ta_info.getText().length()-1);// �]�w��ܰ_�l��m
                        ta_info.setSelectionEnd(ta_info.getText().length());// �]�w��ܪ�������m
                        tf_send.requestFocus();// �ϵo�e��T�¤�r����o�J�I
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void send() {
        if (!loginFlag) {
            JOptionPane.showMessageDialog(null, "�Х��n�J�C");
            return;// �p�G�ϥΪ̨S�n�J�h�Ǧ^
        }
        String sendUserName = tf_newUser.getText().trim();// ��o�n�J�ϥΪ̦W��
        String info = tf_send.getText();// ��o��J���o�e��T
        if (info.equals("")) {
            return;// �p�G�S��J��T�h�Ǧ^�A�Y���o�e
        }
        Vector<String> v = new Vector<String>();// �إߦV�q��H�A�Ω��x�s�o�e���T��
        Object[] receiveUserNames = user_list.getSelectedValues();// ��o��ܪ��ϥΪ̰}�C
        if (receiveUserNames.length <= 0) {
            return;// �p�G�S��ܨϥΪ̫h�Ǧ^
        }
        for (int i = 0; i < receiveUserNames.length; i++) {
            String msg = sendUserName + "�G�o�e���G" + (String) receiveUserNames[i]
                    + "�G����T�O�G " + info;// �w�q�o�e����T
            v.add(msg);// �N��T�W�[��V�q
        }
        try {
            out.writeObject(v);// �N�V�q�g�J��X�y�A������T���o�e
            out.flush();// ��s��X�w�İ�
        } catch (IOException e) {
            e.printStackTrace();
        }
        DateFormat df = DateFormat.getDateInstance();// ��oDateFormat���
        String dateString = df.format(new Date());         // �榡�Ƭ����
        df = DateFormat.getTimeInstance(DateFormat.MEDIUM);// ��oDateFormat���
        String timeString = df.format(new Date());         // �榡�Ƭ��ɶ�
        String sendUser = tf_newUser.getText().trim();// ��o�o�e��T���ϥΪ�
        String receiveInfo = tf_send.getText().trim();// ��ܵo�e����T
        ta_info.append("  "+sendUser + "    " +dateString+"  "+timeString+"\n  "+receiveInfo+"\n");// �b�¤�r�줤��ܸ�T
        tf_send.setText(null);// �M�ů¤�r��
        ta_info.setSelectionStart(ta_info.getText().length()-1);// �]�w��ܪ��_�l��m
        ta_info.setSelectionEnd(ta_info.getText().length());// �]�w��ܪ�������m
        tf_send.requestFocus();// �ϵo�e��T�¤�r����o�J�I
    }
    
    /**
     * Create the frame
     */
    public ChatClientFrame() {
        super();
        setTitle("��ѫǫȤ��");
        setBounds(100, 100, 385, 288);
        
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);
        
        final JLabel label = new JLabel();
        label.setText("��J��Ѥ��e�G");
        panel.add(label);
        
        tf_send = new JTextField();
        tf_send.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                send();// �I�s��k�o�e��T
            }
        });
        tf_send.setPreferredSize(new Dimension(180, 25));
        panel.add(tf_send);
        
        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                send();// �I�s��k�o�e��T
            }
        });
        button.setText("�o  �e");
        panel.add(button);
        
        final JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(100);
        getContentPane().add(splitPane, BorderLayout.CENTER);
        
        final JScrollPane scrollPane = new JScrollPane();
        splitPane.setRightComponent(scrollPane);
        
        ta_info = new JTextArea();
        ta_info.setFont(new Font("", Font.BOLD, 14));
        scrollPane.setViewportView(ta_info);
        
        final JScrollPane scrollPane_1 = new JScrollPane();
        splitPane.setLeftComponent(scrollPane_1);
        
        user_list = new JList();
        user_list.setModel(new DefaultComboBoxModel(new String[] { "" }));
        scrollPane_1.setViewportView(user_list);
        
        final JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.NORTH);
        
        final JLabel label_1 = new JLabel();
        label_1.setText("�ϥΪ̦W�ٺ١G");
        panel_1.add(label_1);
        
        tf_newUser = new JTextField();
        tf_newUser.setPreferredSize(new Dimension(140, 25));
        panel_1.add(tf_newUser);
        
        final JButton button_1 = new JButton();
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (loginFlag) {// �w�n�J�аO��true
                    JOptionPane.showMessageDialog(null, "�b�P�@�����u��n�J�@���C");
                    return;
                }
                String userName = tf_newUser.getText().trim();// ��o�n�J�ϥΪ̦W��
                Vector v = new Vector();// �w�q�V�q�A�Ω��x�s�n�J�ϥΪ�
                v.add("�ϥΪ̡G" + userName);// �W�[�n�J�ϥΪ�
                try {
                    out.writeObject(v);// �N�ϥΪ̦V�q�o�e��A�Ⱦ�
                    out.flush();// ��s��X�w�İ�
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                tf_newUser.setEnabled(false);// �T�ΨϥΪ̯¤�r��
                loginFlag = true;// �N�w�n�J�аO�]�w��true
            }
        });
        button_1.setText("�n  ��");
        panel_1.add(button_1);

        final JButton button_2 = new JButton();
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                String exitUser = tf_newUser.getText().trim();
                Vector v = new Vector();
                v.add("�h�X�G" + exitUser);
                try {
                    out.writeObject(v);
                    out.flush();// ��s��X�w�İ�
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);                                     // �h�X�t��
            }
        });
        button_2.setText("�h  �X");
        panel_1.add(button_2);
        //�u�@�C
        if (SystemTray.isSupported()){                                      // �P�_�O�_�䴩�t�Τu�@�C
            URL url=ChatClientFrame.class.getResource("client.png");          // ��o�Ϥ��Ҧb��URL
            ImageIcon icon = new ImageIcon(url);                            // ��Ҥƹϧιﹳ
            Image image=icon.getImage();                                    // ��oImage�ﹳ
            TrayIcon trayIcon=new TrayIcon(image);                          // �إߤu�@�C�ϼ�
            trayIcon.addMouseListener(new MouseAdapter(){                   // ���u�@�C�W�[���Ф����d
                public void mouseClicked(MouseEvent e){                     // ���Шƥ�
                    if (e.getClickCount()==2){                              // �P�_�O�_�����F����
                        showFrame();                                    // �I�s��k��ܵ���
                    }
                }
            });
            trayIcon.setToolTip("�t�Τu�@�C");                                    // �W�[�u�㴣�ܯ¤�r
            PopupMenu popupMenu=new PopupMenu();                    // �إߥX�{���
            MenuItem exit=new MenuItem("�h�X");                           // �إ߿�涵
            exit.addActionListener(new ActionListener() {                   // �W�[�ƥ��ť��
                public void actionPerformed(final ActionEvent arg0) {
                    String exitUser = tf_newUser.getText().trim();
                    Vector v = new Vector();
                    v.add("�h�X�G" + exitUser);
                    try {
                        out.writeObject(v);
                        out.flush();// ��s��X�w�İ�
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    System.exit(0);                                     // �h�X�t��
                }
            });
            popupMenu.add(exit);                                        // ���X�{���W�[��涵
            trayIcon.setPopupMenu(popupMenu);                           // ���u�@�C�ϼХ[�X�{��u
            SystemTray systemTray=SystemTray.getSystemTray();           // ��o�t�Τu�@�C�ﹳ
            try{
                systemTray.add(trayIcon);                               // ���t�Τu�@�C�[�u�@�C�ϼ�
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    public void showFrame(){
        this.setVisible(true);                                              // ��ܵ���
        this.setState(Frame.NORMAL);
    }

}
