package yishengDengLu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import pojo.Keshi;
import pojo.Yisheng;

public class ZhibanGuanLi extends JDialog {

	String keshiname = "";
	String yiname = "";
	String yid = "";

	// 表1
	private JTable table2 = new JTable() {

		public boolean isCellEditable(int row, int column) {

			return false;
		};

	};
	private JScrollPane pane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	// VERTICAL_SCROLLBAR_AS_NEEDED;VERTICAL_SCROLLBAR_NEVER;

	// 表2
	private JTable table3 = new JTable() {

		public boolean isCellEditable(int row, int column) {

			return false;
		};

	};
	private JScrollPane pane3 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private JLabel bkeshiidLabel = new JLabel("科室");
	private JComboBox<Keshi> bkeshiBox = new JComboBox<Keshi>();

	private JLabel yiLabel = new JLabel("医生");
	private JComboBox<Yisheng> yiBox = new JComboBox<Yisheng>();

	private JButton cha1Button = new JButton("查询");
	private JButton cha2Button = new JButton("查询");
	private JButton backButton = new JButton("返回上一级");

	public ZhibanGuanLi(String yiid) {

		yid = yiid;
		setTitle("欢迎使用医院高级管理系统");
		setSize(1930, 1042);
		setLocationRelativeTo(null);
		setResizable(false);

		setModal(true);

		pane2.setBounds(50, 224, 700, 300);
		pane3.setBounds(800, 224, 700, 300);

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

		bkeshiidLabel.setBounds(49, 183, 60, 20);
		bkeshiBox.setBounds(129, 183, 100, 20);

		yiLabel.setBounds(929, 196, 60, 20);
		yiBox.setBounds(1025, 196, 100, 20);

		cha1Button.setBounds(234, 183, 78, 20);
		cha2Button.setBounds(1150, 196, 78, 20);
		backButton.setBounds(1150, 596, 78, 20);

		getContentPane().add(bkeshiidLabel);
		getContentPane().add(bkeshiBox);

		getContentPane().add(yiLabel);
		getContentPane().add(yiBox);

		getContentPane().add(cha1Button);
		getContentPane().add(cha2Button);
		getContentPane().add(backButton);

		// 查找科室,医生
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select keID , keName from keshibiao";
			PreparedStatement ps = connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			String sql2 = "select yiID , yiName from yishenbiao";
			PreparedStatement ps2 = connection.prepareStatement(sql2);

			ResultSet rs2 = ps2.executeQuery();

			while (rs.next()) {
				Keshi keshi = new Keshi();
				keshi.setkeID(rs.getInt(1));
				keshi.setkeName(rs.getString(2));
				bkeshiBox.addItem(keshi);
			}

			while (rs2.next()) {
				Yisheng yi = new Yisheng();
				yi.setyishengID(rs2.getInt(1));
				yi.setyishengName(rs2.getString(2));
				yiBox.addItem(yi);
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

		bkeshiBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				yiname = ((Yisheng) yiBox.getSelectedItem()).getyishengName();
				yiBox.removeAllItems();
				int keshiid = ((Keshi) bkeshiBox.getSelectedItem()).getkeID();
				keshiname = ((Keshi) bkeshiBox.getSelectedItem()).getkeName();

				Connection connection2 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "select yiID , yiName from yishenbiao where keshiID = ?";
					PreparedStatement ps = connection2.prepareStatement(sql);
					ps.setObject(1, keshiid);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						Yisheng yi = new Yisheng();
						yi.setyishengID(rs.getInt(1));
						yi.setyishengName(rs.getString(2));
						yiBox.addItem(yi);
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

		cha1Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 显示科室Time表
				Vector<String> thVector2 = new Vector<String>();
				thVector2.add("科室");
				thVector2.add("医生姓名");
				thVector2.add("医生编号");
				thVector2.add("工作时间");

				Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();
				Connection connection7 = null;
				try {
					String a = "";
					a = keshiname;
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "select keshi , yiName , yiiD , worKtime  from yiworktime where keshi=?";
					PreparedStatement ps = connection7.prepareStatement(sql);
					ps.setObject(1, a);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						Vector<String> vector2 = new Vector<String>();
						vector2.add(rs.getString(1));
						vector2.add(rs.getString(2));
						vector2.add(rs.getString(3));
						vector2.add(rs.getString(4));

						dataVector2.add(vector2);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						connection7.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				DefaultTableModel defaultTableModel2 = new DefaultTableModel(dataVector2, thVector2);
				table2.setModel(defaultTableModel2);// 把得到的表模型給表格
				table2.setDefaultRenderer(Object.class, new denglu.Gai_biao());
				table2.setRowHeight(30);
				table2.setFont(new Font("微软雅黑", Font.BOLD, 20));
				table2.getTableHeader().setFont(new Font("微软雅黑", 3, 21));
				table2.getTableHeader().setBackground(Color.WHITE);
				pane2.setViewportView(table2);

				getContentPane().add(pane2);
				// 设置表格内容居中

				table2.getTableHeader().setReorderingAllowed(false);// 不允许重新排序
				table2.getTableHeader().setResizingAllowed(false);// 不允许重置表格大小

				table2.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(100);// 设置单元格式
				table2.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(100);

				DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
				cellRenderer.setHorizontalAlignment(JLabel.CENTER);// 设置水平位置
				table2.setDefaultRenderer(Object.class, cellRenderer);
			}
		});

		cha2Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 显示科室Time表
				Vector<String> thVector3 = new Vector<String>();
				thVector3.add("科室");
				thVector3.add("医生姓名");
				thVector3.add("医生编号");
				thVector3.add("工作时间");

				Vector<Vector<String>> dataVector3 = new Vector<Vector<String>>();
				Connection connection7 = null;
				try {
					String b = "";
					b = yiname;
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "select keshi , yiName , yiiD , worKtime  from yiworktime where yiName=?";
					PreparedStatement ps = connection7.prepareStatement(sql);
					ps.setObject(1, b);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						Vector<String> vector3 = new Vector<String>();
						vector3.add(rs.getString(1));
						vector3.add(rs.getString(2));
						vector3.add(rs.getString(3));
						vector3.add(rs.getString(4));

						dataVector3.add(vector3);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						connection7.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				DefaultTableModel defaultTableModel3 = new DefaultTableModel(dataVector3, thVector3);
				table3.setModel(defaultTableModel3);// 把得到的表模型給表格
				table3.setDefaultRenderer(Object.class, new denglu.Gai_biao());
				table3.setRowHeight(30);
				table3.setFont(new Font("微软雅黑", Font.BOLD, 20));
				table3.getTableHeader().setFont(new Font("微软雅黑", 3, 21));
				table3.getTableHeader().setBackground(Color.WHITE);
				pane3.setViewportView(table3);

				getContentPane().add(pane3);
			}
		});

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 关闭界面
				ZhibanGuanLi.this.dispose();
				new Main_yishengView(yid);
			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {
		 new ZhibanGuanLi("1");

	}

}
