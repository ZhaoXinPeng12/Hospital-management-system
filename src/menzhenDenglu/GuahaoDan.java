package menzhenDenglu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import pojo.Keshi;
import pojo.Zhiye;
import util.Age;
import util.Chooser;
import yishengDengLu.BingrenGuanLi;
import yishengDengLu.YishengDengLu;

import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class GuahaoDan extends JFrame {
	
	String id ="";

	private JLabel menzhenLabel = new JLabel("\u95E8  \u8BCA  \u53F7 \uFF1A");
	private JTextPane menzhenPane = new JTextPane();

	private JLabel bnameLabel = new JLabel("\u59D3       \u540D \uFF1A");
	private JTextPane bnamePane = new JTextPane();

	private JLabel bgenderLabel = new JLabel("\u6027       \u522B \uFF1A");
	private JTextPane bgenderPane = new JTextPane();

	private JLabel ageLabel = new JLabel("\u5E74       \u9F84 \uFF1A");
	private JTextPane agePane = new JTextPane();

	private JLabel bzhiyeidLabel = new JLabel("\u804C       \u4E1A \uFF1A");
	private JTextPane bzhiyeiPane = new JTextPane();

	private JLabel bkeshiidLabel = new JLabel("\u79D1       \u5BA4 \uFF1A");
	private JTextPane keshiPane = new JTextPane();

	private JLabel yishengidLabel = new JLabel("\u6302\u53F7\u533B\u751F \uFF1A");
	private JTextPane yishengPane = new JTextPane();

	private JLabel whereLabel = new JLabel("\u79D1\u5BA4\u4F4D\u7F6E \uFF1A");
	private JTextPane wherePane = new JTextPane();

	private JLabel moneyLabel = new JLabel("\u6302\u53F7\u8D39\u7528 \uFF1A");
	private JTextPane moneyPane = new JTextPane();
	
	private JLabel timeLabel = new JLabel("\u6302\u53F7\u65F6\u95F4 \uFF1A");
	private JTextPane timePane = new JTextPane();
	
	private JButton backButton = new JButton("返回上一级");

	public GuahaoDan(String binid) {
		
		id=binid;
		String keshiid = "";
		Integer yishengid = 0;
		String zhiyeid = "";
		setTitle("祝您早日康复");
		setSize(798, 1042);
		setLocationRelativeTo(null);
		setResizable(false);

		getContentPane().setLayout(null);// 绝对布局

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			// public void windowClosing(WindowEvent e) {
			//
			// int n = JOptionPane.showConfirmDialog(null, "真的要退出嘛?", "退出",
			// JOptionPane.YES_NO_OPTION);
			// if (n == JOptionPane.YES_OPTION) {
			// System.exit(0);
			// }
			// }

			public void windowClosing(WindowEvent e) {
				Object[] options = { "确定", "取消" };
				int num = JOptionPane.showOptionDialog(null, "确定退出?", "提示", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (num == 0) {
					System.exit(0);
				}
			}
		});
		menzhenLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		menzhenLabel.setBounds(253, 250, 134, 25);
		menzhenPane.setFont(new Font("微软雅黑", Font.BOLD, 18));
		menzhenPane.setBounds(420, 250, 134, 25);
		bnameLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		bnameLabel.setBounds(253, 320, 134, 25);
		bnamePane.setFont(new Font("微软雅黑", Font.BOLD, 18));
		bnamePane.setBounds(420, 320, 134, 25);
		bgenderLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		bgenderLabel.setBounds(253, 390, 134, 25);
		bgenderPane.setFont(new Font("微软雅黑", Font.BOLD, 18));
		bgenderPane.setBounds(420, 390, 134, 25);
		ageLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		ageLabel.setBounds(253, 460, 134, 25);
		agePane.setFont(new Font("微软雅黑", Font.BOLD, 18));
		agePane.setBounds(420, 460, 134, 25);
		bzhiyeidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		bzhiyeidLabel.setBounds(253, 530, 134, 25);
		bzhiyeiPane.setFont(new Font("微软雅黑", Font.BOLD, 18));
		bzhiyeiPane.setBounds(420, 530, 134, 25);
		bkeshiidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		bkeshiidLabel.setBounds(253, 600, 134, 25);
		keshiPane.setFont(new Font("微软雅黑", Font.BOLD, 18));
		keshiPane.setBounds(420, 600, 134, 25);
		yishengidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		yishengidLabel.setBounds(253, 670, 134, 25);
		yishengPane.setFont(new Font("微软雅黑", Font.BOLD, 18));
		yishengPane.setBounds(420, 670, 134, 25);
		whereLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		whereLabel.setBounds(253, 740, 134, 25);
		wherePane.setFont(new Font("微软雅黑", Font.BOLD, 18));
		wherePane.setBounds(420, 740, 134, 25);
		moneyLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		moneyLabel.setBounds(253, 810, 134, 25);
		moneyPane.setFont(new Font("微软雅黑", Font.BOLD, 18));
		moneyPane.setBounds(420, 810, 134, 25);
		timeLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));
		
		timeLabel.setBounds(253, 880, 134, 25);
		timePane.setFont(new Font("微软雅黑", Font.BOLD, 18));
		timePane.setBounds(420, 880, 134, 25);
		backButton.setBackground(new Color(255, 255, 255));
		backButton.setFont(new Font("微软雅黑", Font.BOLD, 19));
		backButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		
		backButton.setBounds(420,943,134,25);

		getContentPane().add(menzhenLabel);
		getContentPane().add(menzhenPane);

		getContentPane().add(bnameLabel);
		getContentPane().add(bnamePane);

		getContentPane().add(bgenderLabel);
		getContentPane().add(bgenderPane);

		getContentPane().add(ageLabel);
		getContentPane().add(agePane);

		getContentPane().add(bzhiyeidLabel);
		getContentPane().add(bzhiyeiPane);

		getContentPane().add(bkeshiidLabel);
		getContentPane().add(keshiPane);

		getContentPane().add(yishengidLabel);
		getContentPane().add(yishengPane);

		getContentPane().add(whereLabel);
		getContentPane().add(wherePane);

		getContentPane().add(moneyLabel);
		getContentPane().add(moneyPane);
		
		getContentPane().add(timeLabel);
		getContentPane().add(timePane);
		
		getContentPane().add(backButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));
		lblNewLabel.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\guahaoDan20190818150834.png"));
		lblNewLabel.setBounds(0, 0, 1391, 1013);
		getContentPane().add(lblNewLabel);
		


		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");
			// System.out.println(shenfenzheng+"aa");
			// System.out.println(binname+"bb");
			String sql = "select binID,binName,binGender,binBirthday,zhiyeID,KeshiName,binYisheng,binTime from guahaobiao g where g.binID=?";
			// String sql = "select binName from guahaobiao g where
			// shenfenzheng//////g.binShenfenzheng = ? and g.binName =? and
			// g.binYisheng=2";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setObject(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String id;
				id = rs.getString("binID");
				String name = rs.getString("binName");
				
				String time = rs.getString("binTime");
				timePane.setText(time);

				String gender;
				int Gender = rs.getInt("binGender");
				if (Gender == 1) {
					gender = "男";
				} else {
					gender = "女";
				}

				keshiid = rs.getString("KeshiName");
				yishengid = rs.getInt("binYisheng");

				zhiyeid = rs.getString("zhiyeID");

				menzhenPane.setText(id);
				bnamePane.setText(name);
				bgenderPane.setText(gender);
				
				System.out.println(name+"病人的名字");
				System.out.println(gender+"病人的性别");
				System.out.println(time+"病人的年龄");
	
				
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
		}
		// 得出年龄
		Connection connection2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");
			String sql2 = "select binBirthday from guahaobiao where binID=?";
			PreparedStatement ps = connection2.prepareStatement(sql2);
			ps.setObject(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				String age = rs.getString("binBirthday");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(age);
				
				Age a = new Age();
				int b=a.getAge(date);
				agePane.setText(""+b+"岁");

			} else {
				JOptionPane.showMessageDialog(null, "发生错误");
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

		Connection connection3 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection3 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select keName ,weizhi from keshibiao where keID=?";
			PreparedStatement ps = connection3.prepareStatement(sql);
			ps.setObject(1, keshiid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String KeshiName = rs.getString("KeName");
				String yiname = rs.getString("weizhi");

				keshiPane.setText(KeshiName);
				wherePane.setText(yiname);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				connection3.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		Connection connection5 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection5 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select zhiyeName from zhiyebiao where zhiyeID=?";
			PreparedStatement ps = connection5.prepareStatement(sql);
			ps.setObject(1, zhiyeid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String zhiyeName = rs.getString("zhiyeName");

				bzhiyeiPane.setText(zhiyeName);
			} else {
				JOptionPane.showMessageDialog(null, "发生错误");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				connection5.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		Connection connection4 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection4 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql4 = "select guahaofeyon ,yiName from yishenbiao where yiID=?";
			PreparedStatement ps4 = connection4.prepareStatement(sql4);
			ps4.setObject(1, yishengid);

			ResultSet rs4 = ps4.executeQuery();

			if (rs4.next()) {
				String money2 = rs4.getString("guahaofeyon");
				String yiname2 = rs4.getString("yiName");

				moneyPane.setText(money2+" 元");
				yishengPane.setText(yiname2);
			} else {
				JOptionPane.showMessageDialog(null, "发生错误");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				connection4.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				GuahaoDan.this.dispose();
			}
		});

		

		setVisible(true);

	}

	int aa = 0;
	int bb = 0;

	public static void main(String[] args) {

		GuahaoDan aDan = new GuahaoDan("2");

	}
}