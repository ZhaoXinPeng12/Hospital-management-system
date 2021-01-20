package guanlizheTengLu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import util.Age;

public class Yi_xinxi_xianqin extends JFrame {

	String id = "";

	private JLabel yiidLabel = new JLabel("医生编号：");
	private JTextPane yiidPane = new JTextPane();

	private JLabel yinameLabel = new JLabel("医生姓名：");
	private JTextPane yinamePane = new JTextPane();

	private JLabel genderLabel = new JLabel("\u6027    \u522B\uFF1A");
	private JTextPane genderPane = new JTextPane();

	private JLabel ageLabel = new JLabel("\u5E74    \u9F84\uFF1A");
	private JTextPane agePane = new JTextPane();

	private JLabel keshiLabel = new JLabel("\u79D1    \u5BA4\uFF1A");
	private JTextPane keshiPane = new JTextPane();

	private JLabel telLabel = new JLabel("电话号码：");
	private JTextPane telPane = new JTextPane();

	private JLabel workLabel = new JLabel("\u804C    \u4F4D\uFF1A");
	private JTextPane workPane = new JTextPane();

	private JLabel moneyLabel = new JLabel("\u85AA    \u6C34\uFF1A");
	private JTextPane moneyPane = new JTextPane();

	private JLabel money2Label = new JLabel("\u6302 \u53F7 \u8D39\uFF1A");
	private JTextPane money2Pane = new JTextPane();

	public Yi_xinxi_xianqin(String yiid) {
		id = yiid;

		setTitle("欢迎使用医院高级管理系统");
		setSize(714, 925);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);// 绝对布局

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Object[] options = { "确定", "取消" };
				int num = JOptionPane.showOptionDialog(null, "确定退出?", "提示", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (num == 0) {
					System.exit(0);
				}
			}

		});

		yiidLabel.setBounds(50, 27, 110, 20);
		yiidPane.setBounds(170, 27, 220, 20);

		yinameLabel.setBounds(50, 57, 110, 20);
		yinamePane.setBounds(170, 57, 220, 20);

		genderLabel.setBounds(50, 87, 110, 20);
		genderPane.setBounds(170, 87, 220, 20);

		ageLabel.setBounds(50, 117, 110, 20);
		agePane.setBounds(170, 117, 220, 20);

		keshiLabel.setBounds(50, 147, 110, 20);
		keshiPane.setBounds(170, 147, 220, 20);

		telLabel.setBounds(50, 177, 110, 20);
		telPane.setBounds(170, 177, 220, 20);

		workLabel.setBounds(50, 207, 110, 20);
		workPane.setBounds(170, 207, 220, 20);

		moneyLabel.setBounds(50, 237, 110, 20);
		moneyPane.setBounds(170, 237, 220, 20);

		money2Label.setBounds(50, 267, 110, 20);
		money2Pane.setBounds(170, 267, 220, 20);

		getContentPane().add(yiidLabel);
		getContentPane().add(yiidPane);

		getContentPane().add(yinameLabel);
		getContentPane().add(yinamePane);

		getContentPane().add(genderLabel);
		getContentPane().add(genderPane);

		getContentPane().add(ageLabel);
		getContentPane().add(agePane);

		getContentPane().add(keshiLabel);
		getContentPane().add(keshiPane);

		getContentPane().add(telLabel);
		getContentPane().add(telPane);

		getContentPane().add(workLabel);
		getContentPane().add(workPane);

		getContentPane().add(moneyLabel);
		getContentPane().add(moneyPane);

		getContentPane().add(money2Label);
		getContentPane().add(money2Pane);

		JButton btnNewButton_1 = new JButton("\u66F4\u6539");
		btnNewButton_1.setBounds(412, 56, 93, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u66F4\u6539");
		btnNewButton_2.setBounds(412, 86, 93, 23);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u66F4\u6539");
		btnNewButton_3.setBounds(412, 116, 93, 23);
		getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("\u66F4\u6539");
		btnNewButton_4.setBounds(412, 146, 93, 23);
		getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("\u66F4\u6539");
		btnNewButton_5.setBounds(412, 179, 93, 23);
		getContentPane().add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("\u66F4\u6539");
		btnNewButton_6.setBounds(412, 207, 93, 23);
		getContentPane().add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("\u66F4\u6539");
		btnNewButton_7.setBounds(412, 240, 93, 23);
		getContentPane().add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("\u66F4\u6539");
		btnNewButton_8.setBounds(412, 266, 93, 23);
		getContentPane().add(btnNewButton_8);

		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");
			String sql = "select y.yiID,y.yiName,y.yiGender,y.yiBirthday,y.keshiName,y.yiTel,y.yiZhiwei,y.Salary ,y.guahaofeyon from yishenbiao y where yiID=? ";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setObject(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				yiidPane.setText(rs.getString(1));
				yinamePane.setText(rs.getString(2));
				genderPane.setText(rs.getString(3).equals("1") ? "男" : "女");

				String age = rs.getString(4);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(age);
				Age a = new Age();
				int b = a.getAge(date);
				agePane.setText("" + b);

				keshiPane.setText(rs.getString(5));
				telPane.setText(rs.getString(6));
				workPane.setText(rs.getString(7));
				moneyPane.setText(rs.getString(8));
				money2Pane.setText(rs.getString(9));

			} else {
				JOptionPane.showMessageDialog(null, "发生错误");
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			btnNewButton_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					String name = yinamePane.getText();

					Connection connection2 = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");
						String sql = "update yishenbiao set yiName =? where yiID=?";
						PreparedStatement ps = connection2.prepareStatement(sql);
						ps.setObject(1, name);
						ps.setObject(2, id);
						int n = ps.executeUpdate();
						if (n > 0) {

							JOptionPane.showMessageDialog(null, "更改成功");

						}

					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						try {
							connection2.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

				}
			});

			btnNewButton_2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

				

				}
			});
			
			btnNewButton_6.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					String w1 = workPane.getText();

					Connection connection2 = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");
						String sql = "update yishenbiao set yiZhiwei =? where yiID=?";
						PreparedStatement ps = connection2.prepareStatement(sql);
						ps.setObject(1, w1);
						ps.setObject(2, id);
						int n = ps.executeUpdate();
						if (n > 0) {

							JOptionPane.showMessageDialog(null, "更改成功");

						}

					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						try {
							connection2.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

				}
			});
			
			btnNewButton_8.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					String m2 = money2Pane.getText();

					Connection connection2 = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");
						String sql = "update yishenbiao set guahaofeyon =? where yiID=?";
						PreparedStatement ps = connection2.prepareStatement(sql);
						ps.setObject(1, m2);
						ps.setObject(2, id);
						int n = ps.executeUpdate();
						if (n > 0) {

							JOptionPane.showMessageDialog(null, "更改成功");

						}

					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						try {
							connection2.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

				}
			});
			
			btnNewButton_7.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					String m1 = moneyPane.getText();

					Connection connection2 = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");
						String sql = "update yishenbiao set Salary =? where yiID=?";
						PreparedStatement ps = connection2.prepareStatement(sql);
						ps.setObject(1, m1);
						ps.setObject(2, id);
						int n = ps.executeUpdate();
						if (n > 0) {

							JOptionPane.showMessageDialog(null, "更改成功");

						}

					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						try {
							connection2.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

				}
			});

			setVisible(true);

		}
	}

	public static void main(String[] args) {
//		new Yi_xinxi_xianqin("1");

	}
}
