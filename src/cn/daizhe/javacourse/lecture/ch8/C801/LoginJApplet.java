package cn.daizhe.javacourse.lecture.ch8.C801;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginJApplet extends JApplet implements ActionListener
{
    private JTextField text_user;                          //用户名文本行
    private JPasswordField password;                       //口令文本�?
    private JComboBox combobox_mailbox;                    //邮箱组合�?
    private JButton button_login;                          //登录按钮      

    public void init()                                     //初始化Applet
    {
        this.setBackground(Color.white);                   //设置背景颜色
        this.setLayout(new FlowLayout(FlowLayout.LEFT));   //行布�?
        
        this.add(new JLabel("邮箱"));
        text_user = new JTextField("用户名",10);
        text_user.addActionListener(this);                 //为文本行注册单击事件监听�?
        this.add(text_user);

        this.add(new JLabel("@"));
        Object box[]={"263.net", "x263.net"};
        combobox_mailbox = new JComboBox(box);
        this.add(combobox_mailbox);

        this.add(new JLabel("密码"));
        password = new JPasswordField("******",10);
        this.add(password);

        button_login = new JButton("登录"); 
        this.add(button_login);
        button_login.addActionListener(this);              //为按钮注册单击事件监听器
    }
    
    public void actionPerformed(ActionEvent e)             //单击按钮或文本行中单击Enter键时
    {
        if ((e.getSource()==button_login) || (e.getSource()==password))
        {
        	JOptionPane.showMessageDialog(this,"登陆中，请稍�?.....","登陆",
			JOptionPane.WARNING_MESSAGE);
			}
    }
}