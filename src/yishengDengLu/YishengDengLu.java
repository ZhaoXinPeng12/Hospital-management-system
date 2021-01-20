package yishengDengLu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.criteria.From;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import denglu.Denglu;
import guanlizheTengLu.GuanlizheTengLu;
import menzhenDenglu.Main_menzhenView;
import menzhenDenglu.MenzhenDenglu;

public class YishengDengLu extends JFrame {

	private JLabel usernameJLabel = new JLabel("用户名");
	private JTextField usernameField = new JTextField("");

	private JLabel passwordLabel = new JLabel("密码");
	private JTextField passwordField = new JPasswordField("");

	private JButton resetButton = new JButton("重置");
	private JButton loginButton = new JButton("登录");
	private final JButton backButton = new JButton("\u8FD4\u56DE\u4E3B\u767B\u9646\u754C\u9762");//////////////////
	private  String yiid;;
	public YishengDengLu() {
		
		setTitle("欢迎进入医生登陆界面");
		setSize(1180, 885);
		setLocationRelativeTo(null);

		getContentPane().setLayout(null);

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

		// 设置控件的参数
		usernameJLabel.setBounds(206, 230, 60, 20);
		usernameField.setBounds(459, 230, 100, 20);
		passwordField.setBounds(459, 301, 100, 20);

		resetButton.setBounds(360, 301, 60, 20);
		loginButton.setBounds(360, 230, 60, 20);
		backButton.setBounds(206, 366, 130, 34);

		passwordLabel.setBounds(206, 301, 60, 20);

		getContentPane().add(passwordLabel);

		getContentPane().add(usernameJLabel);
		getContentPane().add(usernameField);
		getContentPane().add(passwordField);

		getContentPane().add(resetButton);
		getContentPane().add(loginButton);
		getContentPane().add(backButton);///////////////////

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u8F6F\u4EF6\\s81.18\\src\\view\\loginbg7.jpg"));
		lblNewLabel.setBounds(-20, -14, 1174, 828);
		getContentPane().add(lblNewLabel);

		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// 密码框监听事件
				if (e.getKeyCode() == 10) { // 如果按下回车键，因为回车键的ascii是10

					String username = usernameField.getText();
					String password = passwordField.getText();
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
							YishengDengLu.this.dispose();
							new Main_yishengView(id);
							JOptionPane.showMessageDialog(null, "登陆成功！");

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

		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				usernameField.setText("");
				passwordField.setText("");

			}
		});
		
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String username = usernameField.getText();
				String password = passwordField.getText();
				Connection connection = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "select yiName , password from yishenbiao  where yiName = ? and password = ? ";					
					String sql2 = "Select yiID From yishenbiao where yiName = ? ";
					PreparedStatement ps = connection.prepareStatement(sql);
					PreparedStatement ps2 = connection.prepareStatement(sql2);
					ps.setObject(1, username);
					ps.setObject(2, password);
					ps2.setObject(1, username);

					ResultSet rs2 = ps2.executeQuery();
					ResultSet rs = ps.executeQuery();

					if(rs2.next()){
						
						yiid = rs2.getString("yiID");
					
					}
					if (rs.next()) {
						// 关闭登录界面
						YishengDengLu.this.dispose();
						new Main_yishengView(yiid);
						JOptionPane.showMessageDialog(null, "登陆成功！");

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
		});
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				YishengDengLu.this.dispose();
				new Denglu();
			}
		});

		setVisible(true);// 写在最后
	}

	public static void main(String[] args) {
		new YishengDengLu();
	}

}
