package yishengDengLu;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;

import pojo.Keshi;
import util.Age;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

public class Cha_yi_yi extends JInternalFrame {

	String id = "";

	private JTabbedPane tabbedPane1 = new JTabbedPane();

	private JTable table2 = new JTable() {

		public boolean isCellEditable(int row, int column) {
			return false;
		};

	};
	private JScrollPane pane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private JLabel uidLabel = new JLabel("\u6309\u533B\u751F\u59D3\u540D\u67E5\u8BE2 :");
	private JTextField uidField = new JTextField();

	private JLabel uLabel = new JLabel("\u6309\u533B\u751F\u79D1\u5BA4\u67E5\u8BE2 :");
	private JComboBox<Keshi> keshiBox = new JComboBox<Keshi>();

	private JButton chaxunButton = new JButton("查询");
	private JButton chaxunButton3 = new JButton("查询");
	private final JLabel lblNewLabel = new JLabel("");

	public Cha_yi_yi(String yiid) {

		id = yiid;

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);// 隐藏分容器标题栏
		setBorder(BorderFactory.createEmptyBorder());// 隐藏分容器边框

		setTitle("欢迎进入医生管理界面");
		setSize(800, 1042);
		getContentPane().setLayout(null);// 设置绝对布局

		tabbedPane1.setBounds(0, 0, 800, 1042);
		getContentPane().add(tabbedPane1);

		JPanel panel_1 = new JPanel();
		tabbedPane1.addTab("管理工作信息", null, panel_1, null);

		pane2.setBounds(40, 220, 713, 351);
		uidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		uidLabel.setBounds(40, 154, 185, 30);
		uidField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		uidField.setBounds(235, 154, 135, 30);
		uLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		uLabel.setBounds(40, 99, 185, 30);
		keshiBox.setFont(new Font("微软雅黑", Font.BOLD, 21));
		keshiBox.setBounds(235, 99, 135, 30);
		chaxunButton.setFont(new Font("微软雅黑", Font.BOLD, 21));

		chaxunButton.setBounds(414, 99, 101, 30);
		chaxunButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		chaxunButton3.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chaxunButton3.setBounds(414, 154, 101, 30);
		chaxunButton3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮

		panel_1.setLayout(null);
		panel_1.add(uidLabel);
		panel_1.add(uidField);
		panel_1.add(keshiBox);
		panel_1.add(uLabel);
		panel_1.add(chaxunButton);
		panel_1.add(chaxunButton3);
		
		// 查找科室
		Connection connection2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection2 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");
			String sql2 = "select keID , keName from keshibiao";
			PreparedStatement ps2 = connection2.prepareStatement(sql2);
			ResultSet rs2 = ps2.executeQuery();

			while (rs2.next()) {
				Keshi keshi = new Keshi();
				keshi.setkeID(rs2.getInt(1));
				keshi.setkeName(rs2.getString(2));
				keshiBox.addItem(keshi);
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

		Vector<String> thVector2 = new Vector<String>();
		thVector2.add("科室");
		thVector2.add("医生名字");
		thVector2.add("医生编号");
		thVector2.add("工作时间");
		final Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();

		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select keshi , yiName,yiiD,worktime from yiworktime where yiiD = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setObject(1, id);
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
				connection.close();
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
		panel_1.add(pane2);
		lblNewLabel.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\RuYuan20190819110109.png"));
		lblNewLabel.setBounds(0, 0, 795, 987);
		
		panel_1.add(lblNewLabel);

		chaxunButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String name = uidField.getText();

				Vector<String> thVector2 = new Vector<String>();
				thVector2.add("科室");
				thVector2.add("医生名字");
				thVector2.add("医生编号");
				thVector2.add("工作时间");
				final Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();

				Connection connection = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "select keshi , yiName,yiiD,worktime from yiworktime where yiName = ?";
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setObject(1, name);
					ResultSet rs = ps.executeQuery();

					DefaultTableModel defaultTableModel2 = (DefaultTableModel) table2.getModel();
					defaultTableModel2.getDataVector().clear();////

					while (rs.next()) {
						Vector<String> vector2 = new Vector<String>();
						vector2.add(rs.getString(1));
						vector2.add(rs.getString(2));
						vector2.add(rs.getString(3));
						vector2.add(rs.getString(4));
						defaultTableModel2.addRow(vector2);
					}
					defaultTableModel2.fireTableDataChanged();
					
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

		chaxunButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Keshi keshi = (Keshi) keshiBox.getSelectedItem();
				String Keshiname = keshi.getkeName();
				
				Vector<String> thVector2 = new Vector<String>();
				thVector2.add("科室");
				thVector2.add("医生名字");
				thVector2.add("医生编号");
				thVector2.add("工作时间");
				final Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();

				Connection connection = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "select keshi , yiName,yiiD,worktime from yiworktime where keshi = ?";
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setObject(1, Keshiname);
					ResultSet rs = ps.executeQuery();

					DefaultTableModel defaultTableModel2 = (DefaultTableModel) table2.getModel();
					defaultTableModel2.getDataVector().clear();////

					while (rs.next()) {
						Vector<String> vector2 = new Vector<String>();
						vector2.add(rs.getString(1));
						vector2.add(rs.getString(2));
						vector2.add(rs.getString(3));
						vector2.add(rs.getString(4));
						defaultTableModel2.addRow(vector2);
					}
					defaultTableModel2.fireTableDataChanged();
					
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

		
	}

	public static void main(String[] args) {

	}

}
