package npanel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class NewPanel extends JPanel {
    private JTextField textField;// 宣告純文字框
    public NewPanel() {
        super();// 呼叫超類別的建構方法
        setLayout(null);// 設定面板為絕對佈局
        setBounds(100, 100, 254, 167);// 設定面板的位置和大小
        final JButton button = new JButton();// 建立按鈕
        button.setText("按鈕一");// 指定按鈕標題
        button.setBounds(38, 86, 73, 28);// 指定按鈕在面板中的顯示位置和大小
        add(button);// 將按鈕增加到面板上
        final JButton button_1 = new JButton();// 建立按鈕
        button_1.setText("按鈕二");// 指定按鈕標題
        button_1.setBounds(140, 86, 73, 28);// 指定按鈕在面板中的顯示位置和大小
        add(button_1);// 將按鈕增加到面板上
        textField = new JTextField();// 建立純文字框
        textField.setText("這是一個純文字框控制項");// 指定純文字框的標題
        textField.setBounds(38, 35, 175, 22);// 設定純文字框的顯示位置和大小
        add(textField);// 將純文字框增加到面板上
    }
}
