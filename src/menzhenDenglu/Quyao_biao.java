package menzhenDenglu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import pojo.Bin;
import pojo.Shi;
import util.Age;
import yishengDengLu.ChaHouse;
import yishengDengLu.Main_yishengView;
import yishengDengLu.Ruyuan;

import javax.persistence.Id;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Quyao_biao extends JDialog {

	int i = 0;
	int row = -1;
	int sum2 = 0;
	// int binid = -1;
	String zhiyeid = "";
	String keshiid = "";

	String zhiyename = "";
	String keshiname = "";

	String yiname = "";
	String yid = "";
	String id = "";

	// private JTable table = new JTable();
	// private JScrollPane pane = new
	// JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,
	// JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	// 未付费病人表
	private JTable table2 = new JTable() {

		public boolean isCellEditable(int row, int column) {

			return false;
		};

	};
	private JScrollPane pane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	// VERTICAL_SCROLLBAR_AS_NEEDED;VERTICAL_SCROLLBAR_NEVER;

	// 此病人消费明细表
	private JTable table3 = new JTable() {

		public boolean isCellEditable(int row3, int column3) {

			return false;
		};

	};
	private JScrollPane pane3 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	public Quyao_biao(String binid) {
		id = binid;

		getContentPane().setForeground(Color.LIGHT_GRAY);

		setTitle("欢迎使用医院高级管理系统");
		setSize(923, 940);
		setLocationRelativeTo(null);
		setResizable(false);

		setModal(true);

		// pane.setBounds(746, 271, 500, 40);
		pane2.setBounds(48, 186, 827, 95);
		pane3.setBounds(48, 319, 827, 396);

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

		// 未付费病人表
		Vector<String> thVector2 = new Vector<String>();
		thVector2.add("门诊号");
		thVector2.add("患者名字");
		thVector2.add("性别");
		thVector2.add("年龄");
		thVector2.add("科室");
		thVector2.add("医生名字");
		thVector2.add("电话号码");
		Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();
		Connection connection7 = null;
		try {
			String keshi = "";
			Class.forName("com.mysql.jdbc.Driver");
			connection7 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select g.binID,g.binName,g.binGender,g.binBirthday,y.yiName,g.binTel ,y.keshiName from guahaobiao g,yishenbiao y where g.binYisheng=y.yiID and g.binID = ?";
			String sql2 = "select k.keName from keshibiao k,guahaobiao g where g.keshiName=k.keID";

			PreparedStatement ps = connection7.prepareStatement(sql);
			// PreparedStatement ps2 = connection7.prepareStatement(sql2);
			ps.setObject(1, id);
			ResultSet rs = ps.executeQuery();
			// ResultSet rs2 = ps2.executeQuery();

			while (rs.next()) {
				Vector<String> vector2 = new Vector<String>();
				vector2.add(rs.getString(1));
				vector2.add(rs.getString(2));

				vector2.add(rs.getString(3).equals("1") ? "男" : "女");

				String age = rs.getString("g.binBirthday");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(age);
				Age a = new Age();
				int b = a.getAge(date);
				vector2.add("" + b);

				vector2.add(rs.getString(7));

				vector2.add(rs.getString(5));

				vector2.add(rs.getString(6));

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

		Vector<String> thVector3 = new Vector<String>();
		thVector3.add("药品编号");
		thVector3.add("药品名字");
		thVector3.add("药品价格");
		thVector3.add("开药数量");
		thVector3.add("药品类型");
		thVector3.add("包装类型");
		Vector<Vector<String>> dataVector3 = new Vector<Vector<String>>();

		Connection connection8 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection8 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select yaoID , yaoName,money,num,Leixin,baoLeixin from kaiyaobiao where binID = ?";
			PreparedStatement ps = connection8.prepareStatement(sql);
			ps.setObject(1, binid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Vector<String> vector3 = new Vector<String>();
				vector3.add(rs.getString(1));
				vector3.add(rs.getString(2));
				vector3.add(rs.getString(3));
				vector3.add(rs.getString(4));
				vector3.add(rs.getString(5));
				vector3.add(rs.getString(6));
				dataVector3.add(vector3);

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

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				connection8.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 21));
		btnNewButton_1.setBounds(389, 747, 221, 35);

		getContentPane().add(btnNewButton_1);

		JButton btnNewButton = new JButton("\u8FD4\u56DE\u95E8\u8BCA\u6536\u8D39\u754C\u9762");
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		btnNewButton.setBounds(654, 747, 221, 35);
		getContentPane().add(btnNewButton);

		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel
				.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\QQ\u622A\u56FE20190820061039.png"));
		lblNewLabel.setBounds(0, 0, 917, 1013);

		getContentPane().add(lblNewLabel);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Quyao_biao.this.dispose();
				new YaofeView();

			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Quyao_biao.this.dispose();
				new ChuyuanfeView();

			}
		});

		setVisible(true);

	}

	int aa = 0;
	int bb = 0;
	private final JLabel lblNewLabel = new JLabel("");
	private final JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u51FA\u9662\u6536\u8D39\u754C\u9762");

	public static void main(String[] args) {

		new Quyao_biao("2");

	}
}