package yishengDengLu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;

import denglu.Denglu;
import guanlizheTengLu.Cha_bin;
import guanlizheTengLu.Cha_yi;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class BingrenGuanLi extends JFrame {

	String yiid = "";
	String name = "";

	private JDesktopPane desktopPane = new JDesktopPane();

	public BingrenGuanLi(String id) {
		yiid = id;

		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select yiName  from yishenbiao  where  yiid = ? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setObject(1, yiid);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				name = rs.getString(1);

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

		setTitle("欢迎登陆医生操作界面--"+name+"医师");
		setSize(1930, 1042);
		setLocationRelativeTo(null);
		setResizable(false);// 设置窗口大小固定
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

		desktopPane.setBounds(550, 0, 800, 1000);
		getContentPane().add(desktopPane);

		JButton binrenButton = new JButton("\u6302\u53F7\u8BCA\u65AD");
		binrenButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		binrenButton.setBounds(155, 191, 250, 100);
		getContentPane().add(binrenButton);
		binrenButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮

		JButton guahaoButton = new JButton("出院登记");
		guahaoButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		guahaoButton.setBounds(155, 60, 250, 100);
		getContentPane().add(guahaoButton);
		guahaoButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮

		JButton chaButton = new JButton("值班查询");
		chaButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chaButton.setBounds(155, 322, 250, 100);
		getContentPane().add(chaButton);
		chaButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮

		JButton button = new JButton("\u60A3\u8005\u7BA1\u7406");
		button.setFont(new Font("微软雅黑", Font.BOLD, 21));
		button.setBounds(155, 452, 250, 100);
		getContentPane().add(button);
		button.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮

		JButton yishengButton = new JButton("返回登陆界面");
		yishengButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		yishengButton.setBounds(155, 574, 250, 100);
		getContentPane().add(yishengButton);
		yishengButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮

		Chuyuan_Xiao chuyuan_Xiao = new Chuyuan_Xiao(yiid);
		chuyuan_Xiao.setBounds(0, 0, 800, 1042);
		desktopPane.add(chuyuan_Xiao);

		Cha_yi_yi cha_yi_yi = new Cha_yi_yi(yiid);
		cha_yi_yi.setBounds(0, 0, 800, 1042);
		desktopPane.add(cha_yi_yi);

		Cha_bin_yi cha_bin_yi = new Cha_bin_yi();
		cha_bin_yi.setBounds(0, 0, 800, 1042);
		desktopPane.add(cha_bin_yi);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\MenZhen20190818220822.png"));
		label.setBounds(0, 0, 1924, 1013);
		getContentPane().add(label);

		binrenButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Ruyuan(yiid);

			}
		});

		yishengButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				BingrenGuanLi.this.dispose();
				new Denglu();

			}
		});

		guahaoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Chuyuan_Xiao(yiid);
				// 以数组的形式返回桌面中当前显示的所有JInternalFrame
				JInternalFrame[] internalFrames = desktopPane.getAllFrames();
				boolean f = true;
				for (JInternalFrame internalFrame : internalFrames) {
					if (internalFrame instanceof Chuyuan_Xiao) {
						internalFrame.setVisible(true);
						f = false;
					} else {
						internalFrame.setVisible(false);
					}
				}

			}
		});

		chaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Cha_yi_yi(yiid);
				// 以数组的形式返回桌面中当前显示的所有JInternalFrame
				JInternalFrame[] internalFrames = desktopPane.getAllFrames();
				boolean f = true;
				for (JInternalFrame internalFrame : internalFrames) {
					if (internalFrame instanceof Cha_yi_yi) {
						internalFrame.setVisible(true);
						f = false;
					} else {
						internalFrame.setVisible(false);
					}
				}

			}
		});

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Cha_bin_yi();
				// 以数组的形式返回桌面中当前显示的所有JInternalFrame
				JInternalFrame[] internalFrames = desktopPane.getAllFrames();
				boolean f = true;
				for (JInternalFrame internalFrame : internalFrames) {
					if (internalFrame instanceof Cha_bin_yi) {
						internalFrame.setVisible(true);
						f = false;
					} else {
						internalFrame.setVisible(false);
					}
				}

			}
		});

		setVisible(true);// 写在最后
	}

	public static void main(String[] args) {
		new BingrenGuanLi("1");

	}
}
