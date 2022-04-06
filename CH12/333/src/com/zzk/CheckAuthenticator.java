package com.zzk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CheckAuthenticator extends Authenticator {
    class UserPassDialog extends JDialog {// �Ω���ܥ�͵������������O
        private JPasswordField pf_pwd;// �K�X��
        private JTextField tf_user;// �ϥΪ̦W�ٯ¤�r��
        
        public UserPassDialog() {
            super();
            getContentPane().setLayout(null);
            setTitle("�������ҥ�͵���");
            setBounds(100, 100, 253, 165);
            
            final JLabel label = new JLabel();
            label.setText("�ϥΪ̦W�ٺ١G");
            label.setBounds(10, 25, 66, 18);
            getContentPane().add(label);
            
            tf_user = new JTextField();
            tf_user.setBounds(82, 23, 146, 22);
            getContentPane().add(tf_user);
            
            final JLabel label_1 = new JLabel();
            label_1.setText("�ϥΪ̱K�X�G");
            label_1.setBounds(10, 63, 66, 18);
            getContentPane().add(label_1);
            
            pf_pwd = new JPasswordField();
            pf_pwd.setBounds(82, 61, 146, 22);
            getContentPane().add(pf_pwd);
            
            final JButton btn_ok = new JButton();
            btn_ok.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent e) {
                    setVisible(false);
                }
            });
            btn_ok.setText("�T  �w");
            btn_ok.setBounds(20, 89, 92, 28);
            getContentPane().add(btn_ok);
            
            final JButton btn_return = new JButton();
            btn_return.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent e) {
                    setVisible(false);
                }
            });
            btn_return.setText("��  �^");
            btn_return.setBounds(132, 89, 92, 28);
            getContentPane().add(btn_return);
            //
        }
        
    }
    
    public PasswordAuthentication getPasswordAuthentication() {
        UserPassDialog dialog = new UserPassDialog();// �إߥ�͵���
        dialog.setModal(true);// �]�w���Ҧ���͵���
        dialog.setVisible(true);// ��ܥ�͵���
        String user = dialog.tf_user.getText().trim();// ��o�ϥΪ̦W��
        String pwd = new String(dialog.pf_pwd.getPassword());// ��o�K�X
        dialog.tf_user.setText(null);// �M�ŨϥΪ̦W�ٯ¤�r��
        dialog.pf_pwd.setText(null);// �M�űK�X��
        return new PasswordAuthentication(user, pwd);// �Ǧ^PasswordAuthentication�ﹳ
    }
}
