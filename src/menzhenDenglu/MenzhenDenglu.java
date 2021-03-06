package menzhenDenglu;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import denglu.Denglu;
import guanlizheTengLu.GuanlizheTengLu;
import yishengDengLu.YishengDengLu;

public class MenzhenDenglu extends JFrame {

	private JLabel usernameJLabel = new JLabel("用户名");
	private JTextField usernameField = new JTextField("sunjob");

	private JLabel passwordLabel = new JLabel("密码");
	private JTextField passwordField = new JPasswordField("sunjob");

	private JButton resetButton = new JButton("重置");
	private JButton loginButton = new JButton("登录");
	private JButton backButton = new JButton("\u8FD4\u56DE\u4E3B\u767B\u9646\u754C\u9762");//////////////////

	public MenzhenDenglu() {
		setTitle("欢迎进入门诊登陆界面");
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
		usernameJLabel.setBounds(914, 240, 60, 20);
		usernameField.setBounds(1054, 230, 100, 20);
		passwordField.setBounds(1054, 301, 100, 20);

		resetButton.setBounds(963, 301, 60, 20);
		loginButton.setBounds(984, 240, 60, 20);
		backButton.setBounds(766, 419, 145, 33);

		passwordLabel.setBounds(893, 301, 60, 20);

		getContentPane().add(passwordLabel);

		getContentPane().add(usernameJLabel);
		getContentPane().add(usernameField);
		getContentPane().add(passwordField);

		getContentPane().add(resetButton);
		getContentPane().add(loginButton);
		getContentPane().add(backButton);///////////////////

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\QQ\u622A\u56FE20190818004633.png"));
		lblNewLabel.setBounds(52, 10, 1174, 828);
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

						String sql = "select username , password from denglu  where username = ? and password = ? ";
						PreparedStatement ps = connection.prepareStatement(sql);
						ps.setObject(1, username);
						ps.setObject(2, password);

						ResultSet rs = ps.executeQuery();

						if (rs.next()) {
							// 关闭登录界面
							MenzhenDenglu.this.dispose();
							new Main_menzhenView();
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

					String sql = "select username , password from denglu  where username = ? and password = ? ";
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setObject(1, username);
					ps.setObject(2, password);

					ResultSet rs = ps.executeQuery();

					if (rs.next()) {
						// 关闭登录界面
						MenzhenDenglu.this.dispose();
						new Main_menzhenView();
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

				MenzhenDenglu.this.dispose();
				new Denglu();
			}
		});

		setVisible(true);// 写在最后
	}

	public static void main(String[] args) {
		new MenzhenDenglu();
	}

}
