 package denglu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import bingrenDengLu.BingrenDengLu;
import guanlizheTengLu.GuanlizheTengLu;
import guanlizheTengLu.Main_View;
import menzhenDenglu.Main_menzhenView;
import menzhenDenglu.MenzhenDenglu;
import yishengDengLu.BingrenGuanLi;
import yishengDengLu.Main_yishengView;

import java.awt.Toolkit;
import java.awt.Color;

public class Denglu  extends JFrame {
	
	int i = 0;

	private JLabel usernameLabel = new JLabel("\u7528 \u6237 \u540D\uFF1A");
	private JTextField usernameField = new JTextField("sunjob");

	private JLabel passwordLabel = new JLabel("\u5BC6      \u7801\uFF1A");
	private JTextField passwordField = new JPasswordField("sunjob");

	private JButton resetButton = new JButton("\u91CD\u7F6E");
	private JButton loginButton = new JButton("登录");

	private JRadioButton dengluButton1 = new JRadioButton("管理员登录");
	private JRadioButton dengluButton2 = new JRadioButton("门诊登录");
	private JRadioButton dengluButton3 = new JRadioButton("医生登录");
	private final JLabel lblNewLabel_1 = new JLabel("");
	
	
	public Denglu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\\u6355\u83B72.PNG"));
		
		setTitle("欢迎使用医院高级管理系统");
		setSize(1930, 1042);
		setLocationRelativeTo(null);//窗口将置于屏幕的中央

		getContentPane().setFont(new Font("微软雅黑", Font.PLAIN, 10));
		getContentPane().setLayout(null);// 绝对布局
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				int n = JOptionPane.showConfirmDialog(null, "真的要退出嘛?", "退出", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					System.exit(0);
				}
			}
		});
		usernameLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));


		usernameLabel.setBounds(1295, 305, 113, 32);
		usernameField.setBackground(new Color(153, 255, 255));
		usernameField.setFont(new Font("微软雅黑", Font.BOLD, 18));
		usernameField.setBounds(1441, 307, 139, 32);
		passwordLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));
		passwordLabel.setBounds(1295, 363, 113, 32);
		passwordField.setFont(new Font("宋体", Font.BOLD, 16));
		passwordField.setBackground(new Color(153, 255, 255));
		passwordField.setBounds(1441, 367, 139, 32);
		resetButton.setForeground(new Color(0, 204, 102));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		resetButton.setBackground(Color.WHITE);
		resetButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		resetButton.setIcon(null);
		resetButton.setBounds(1295, 534, 93, 32);
		resetButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		loginButton.setBackground(new Color(240, 240, 240));
		loginButton.setForeground(new Color(0, 204, 51));
		loginButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		loginButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
//		loginButton.setBorderPainted(false);// 对JButton去掉按钮的边框的设置
		loginButton.setBounds(1487, 534, 93, 32);
		dengluButton1.setBackground(new Color(153, 255, 255));
		dengluButton1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		dengluButton1.setBounds(1477, 459, 105, 32);
		dengluButton2.setBackground(new Color(153, 255, 255));
		dengluButton2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		dengluButton2.setBounds(1386, 460, 89, 32);
		dengluButton3.setBackground(new Color(153, 255, 255));
		dengluButton3.setFont(new Font("微软雅黑", Font.BOLD, 16));
		dengluButton3.setBounds(1295, 460, 89, 32);

		getContentPane().add(usernameLabel);
		getContentPane().add(usernameField);
		getContentPane().add(passwordLabel);
		getContentPane().add(passwordField);
		getContentPane().add(resetButton);
		getContentPane().add(loginButton);
		getContentPane().add(dengluButton1);
		getContentPane().add(dengluButton2);
		getContentPane().add(dengluButton3);
		lblNewLabel_1.setBackground(new Color(153, 255, 255));
		lblNewLabel_1.setIcon(new ImageIcon("D:\\赛杰项目\\src\\tupian\\20190818014122.png"));
		lblNewLabel_1.setBounds(0, 0, 1914, 1003);
		
		getContentPane().add(lblNewLabel_1);
		

		dengluButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				i = 1;
			}
		});

		dengluButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				i = 2;
			}
		});

		dengluButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				i = 3;
				
				
			}
		});

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String username = usernameField.getText();
				String password = passwordField.getText();

				if (i == 1) {
					Connection connection = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

						String sql = "select username , password from denglu  where username = ? and password = ? ";
						PreparedStatement ps = connection.prepareStatement(sql);
						ps.setObject(1, username);
						ps.setObject(2, password);

						ResultSet rs = ps.executeQuery();

						if (rs.next()) {
							// 关闭登录界面
							Denglu.this.dispose();
							new Main_View();

						} else {
							JOptionPane.showMessageDialog(null, "用户名或密码错误!!!");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						try {
							connection.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				} else if (i == 2) {
					Connection connection = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

						String sql = "select username , password from denglu  where username = ? and password = ? ";
						PreparedStatement ps = connection.prepareStatement(sql);
						ps.setObject(1, username);
						ps.setObject(2, password);

						ResultSet rs = ps.executeQuery();

						if (rs.next()) {
							// 关闭登录界面
							Denglu.this.dispose();
							new Main_menzhenView();

						} else {
							JOptionPane.showMessageDialog(null, "用户名或密码错误!!!");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						try {
							connection.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

				} else {
					Connection connection = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

						String sql = "select yiName ,yiID, password from yishenbiao  where yiName = ? and password = ? ";
						PreparedStatement ps = connection.prepareStatement(sql);
						ps.setObject(1, username);
						ps.setObject(2, password);

						ResultSet rs = ps.executeQuery();

						if (rs.next()) {
							String id = rs.getString("yiID");
							// 关闭登录界面
							Denglu.this.dispose();
							new BingrenGuanLi(id);

						} else {
							JOptionPane.showMessageDialog(null, "用户名或密码错误!!!");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						try {
							connection.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

				}
			}
		});

		setVisible(true);// 写在最后
	}

	public static void main(String[] args) {
		new Denglu();

	}
}
