package com.zzk;
import java.sql.*;
import javax.swing.JOptionPane;

public class DAO {
    private static DAO dao = new DAO(); // �ŧiDAO���O���R�A���
    
    /**
     * �غc��k�A���J��ƨ�Ʈw�X��
     */
    public DAO() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // ���J��ƨ�Ʈw�X��
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "��ƨ�Ʈw�X�ʸ��J���ѡA�бNJTDS�X�ʳ]�w��غc���|���C\n"
                    + e.getMessage());
        }
    }
    
    /**
     * ��o��ƨ�Ʈw�s������k
     * 
     * @return Connection
     */
    public static Connection getConn() {
        try {
            Connection conn = null; // �w�q��ƨ�Ʈw�s��
            String url = "jdbc:jtds:sqlserver://localhost:1433/db_database"; // ��ƨ�Ʈwdb_database��URL
            String username = "sa"; // ��ƨ�Ʈw���ϥΪ̦W��
            String password = ""; // ��ƨ�Ʈw�K�X
            conn = DriverManager.getConnection(url, username, password); // �إ߳s��
            return conn; // �Ǧ^�s��
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "��ƨ�Ʈw�s�����ѡC\n���ˬd�O�_�w�ˤFSP4��s�A\n�H�θ�ƨ�Ʈw�ϥΪ̦W�٩M�K�X�O�_���T�C"
                            + e.getMessage());
            return null;
        }
    }
}