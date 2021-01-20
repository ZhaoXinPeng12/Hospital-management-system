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
import javax.swing.ImageIcon;
import java.awt.Font;

public class YaofeView extends JDialog {

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

	private JLabel a = new JLabel("\u5F53\u524D\u60A3\u8005\u4FE1\u606F \uFF1A");
	private JLabel b = new JLabel("\u672A\u4ED8\u8D39\u60A3\u8005 \uFF1A");
	private JLabel c = new JLabel("\u5F53\u524D\u60A3\u8005\u7528\u836F\u660E\u7EC6 \uFF1A");
	private JTextPane numPane = new JTextPane();

	private JLabel binidLabel = new JLabel("\u95E8  \u8BCA  \u53F7\uFF1A");
	private JTextField binidField = new JTextField();
	private JButton chazhaoButton = new JButton("查找");
	private JButton chonzhiButton = new JButton("重置");

	private JButton sureButton = new JButton("门诊结账：");

	private JLabel zhifuLabel = new JLabel("\u652F\u4ED8 \u91D1\u989D\uFF1A");
	private JTextField zhifuField = new JTextField();

	private JLabel yishengLabel = new JLabel("\u4E3B\u8BCA \u533B\u751F\uFF1A");
	private JTextField yishengField = new JTextField();

	private JLabel xingbieLabel = new JLabel("\u6027        \u522B\uFF1A");
	private JTextField xingbieField = new JTextField();

	private JLabel ageLabel = new JLabel("\u5E74        \u9F84\uFF1A");
	private JTextField ageField = new JTextField();

	private JLabel shenfenLabel = new JLabel("\u7535\u8BDD \u53F7\u7801 \uFF1A");
	private JTextField shenfenField = new JTextField();

	private JLabel keshiLabel = new JLabel("\u79D1        \u5BA4\uFF1A");
	private JTextField keshiField = new JTextField();

	private JLabel nameLabel = new JLabel("\u59D3        \u540D\uFF1A");
	private JTextField nameField = new JTextField();

	private JLabel shenfenzhengLabel = new JLabel("电话 号码：");
	private JTextField shenfenzhengField = new JTextField();

	private JLabel yaofeLabel = new JLabel("\u603B\u533B \u836F\u8D39\uFF1A");
	private JTextField yaofeField = new JTextField();

	private JLabel zhaoqianLabel = new JLabel("\u627E        \u96F6\uFF1A");
	private JTextField zhaoqianField = new JTextField();

	private JButton tianjiaButton = new JButton("\u6DFB\u52A0\u836F\u54C1");

	private JButton backButton = new JButton("返回上一级");

	public YaofeView() {

		getContentPane().setForeground(Color.LIGHT_GRAY);

		setTitle("欢迎使用医院高级管理系统");
		setSize(1930, 1042);
		setLocationRelativeTo(null);
		setResizable(false);

		setModal(true);

		// pane.setBounds(746, 271, 500, 40);
		pane2.setBounds(109, 565, 817, 396);
		pane3.setBounds(998, 565, 817, 396);

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
		a.setFont(new Font("宋体", Font.BOLD, 21));

		a.setBounds(109, 111, 167, 30);
		numPane.setForeground(Color.BLACK);
		numPane.setFont(numPane.getFont().deriveFont(11f));
		numPane.setBounds(1062, 10, 23, 20);
		b.setFont(new Font("宋体", Font.BOLD, 21));
		b.setBounds(109, 512, 167, 30);
		c.setFont(new Font("宋体", Font.BOLD, 21));
		c.setBounds(1001, 512, 229, 30);
		getContentPane().add(a);
		// getContentPane().add(numPane);
		getContentPane().add(b);
		getContentPane().add(c);
		binidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		binidLabel.setBounds(545, 111, 120, 30);
		binidField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		binidField.setBounds(657, 111, 120, 30);
		chazhaoButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chazhaoButton.setBounds(825, 111, 120, 30);
		chonzhiButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chonzhiButton.setBounds(998, 111, 120, 30);
		backButton.setFont(new Font("微软雅黑", Font.BOLD, 21));

		backButton.setBounds(1169, 111, 146, 30);
		sureButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		sureButton.setBounds(1169, 411, 261, 30);
		zhifuLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		zhifuLabel.setBounds(825, 352, 120, 30);
		zhifuField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		zhifuField.setBounds(998, 352, 120, 30);
		yishengLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		yishengLabel.setBounds(545, 188, 120, 30);
		yishengField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		yishengField.setBounds(657, 188, 120, 30);
		xingbieLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		xingbieLabel.setBounds(825, 267, 120, 30);
		xingbieField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		xingbieField.setBounds(998, 267, 120, 30);
		ageLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		shenfenLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		shenfenLabel.setBounds(1169, 188, 120, 30);
		shenfenField.setFont(new Font("微软雅黑", Font.BOLD, 16));
		shenfenField.setBounds(1310, 188, 120, 30);

		ageLabel.setBounds(1169, 267, 120, 30);
		ageField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		ageField.setBounds(1310, 267, 120, 30);
		keshiLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		keshiLabel.setBounds(825, 188, 120, 30);
		keshiField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		keshiField.setBounds(998, 188, 120, 30);
		nameLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		nameLabel.setBounds(545, 267, 120, 30);
		nameField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		nameField.setBounds(657, 267, 120, 30);

		shenfenzhengLabel.setBounds(846, 86, 120, 30);
		shenfenzhengField.setBounds(892, 86, 120, 30);
		yaofeLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		yaofeLabel.setBounds(545, 352, 120, 30);
		yaofeField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		yaofeField.setBounds(657, 352, 120, 30);
		zhaoqianLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		zhaoqianLabel.setBounds(1169, 352, 120, 30);
		zhaoqianField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		zhaoqianField.setBounds(1310, 352, 120, 30);

		getContentPane().add(backButton);
		getContentPane().add(sureButton);

		getContentPane().add(zhifuLabel);
		getContentPane().add(zhifuField);

		getContentPane().add(binidField);
		getContentPane().add(binidLabel);
		getContentPane().add(chazhaoButton);
		getContentPane().add(chonzhiButton);

		getContentPane().add(yishengLabel);
		getContentPane().add(yishengField);

		getContentPane().add(xingbieLabel);
		getContentPane().add(xingbieField);

		getContentPane().add(ageLabel);
		getContentPane().add(ageField);

		getContentPane().add(shenfenLabel);
		getContentPane().add(shenfenField);

		getContentPane().add(keshiLabel);
		getContentPane().add(keshiField);

		getContentPane().add(nameLabel);
		getContentPane().add(nameField);

		getContentPane().add(yaofeLabel);
		getContentPane().add(yaofeField);

		getContentPane().add(zhaoqianLabel);
		getContentPane().add(zhaoqianField);

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

			String sql = "select g.binID,g.binName,g.binGender,g.binBirthday,y.yiName,g.binTel ,y.keshiName from guahaobiao g,yishenbiao y where g.binYisheng=y.yiID and g.Yes_No = ?";
			String sql2 = "select k.keName from keshibiao k,guahaobiao g where g.keshiName=k.keID";

			PreparedStatement ps = connection7.prepareStatement(sql);
			// PreparedStatement ps2 = connection7.prepareStatement(sql2);
			ps.setObject(1, "1");
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

		chazhaoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int sum = 0;

				String binid = (String) table2.getValueAt(row, 0);
				String binname = (String) table2.getValueAt(row, 1);
				String gender = (String) table2.getValueAt(row, 2);
				String age = (String) table2.getValueAt(row, 3);
				String keshi = (String) table2.getValueAt(row, 4);
				String yisheng = (String) table2.getValueAt(row, 5);
				String shenfenzhen = (String) table2.getValueAt(row, 6);

				binidField.setText(binid);
				nameField.setText(binname);
				xingbieField.setText(gender);
				ageField.setText(age);
				keshiField.setText(keshi);
				yishengField.setText(yisheng);
				shenfenField.setText(shenfenzhen);

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

						String money2 = rs.getString(3);
						String num2 = rs.getString(4);

						int money3 = Integer.parseInt(money2);
						int num3 = Integer.parseInt(num2);
						sum = sum + num3 * money3;

					}

					sum2 = sum;
					String money4 = Integer.toString(sum);
					yaofeField.setText(money4);

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

			}
		});

		// 显示开药表
		Vector<String> thVector3 = new Vector<String>();
		thVector3.add("药品编号");
		thVector3.add("药品名字");
		thVector3.add("药品价格");
		thVector3.add("开药数量");
		thVector3.add("药品类型");
		thVector3.add("包装类型");

		Vector<Vector<String>> dataVector3 = new Vector<Vector<String>>();

		for (int s = 0; s < 6; s++) {
			Vector<String> vector3 = new Vector<String>();
			vector3.add("       ");
			vector3.add("       ");
			vector3.add("       ");
			vector3.add("       ");
			vector3.add("       ");
			vector3.add("       ");

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
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\QQ\u622A\u56FE20190818155305.png"));
		lblNewLabel.setBounds(0, 0, 1964, 1013);

		getContentPane().add(lblNewLabel);

		sureButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int sum = 0;

				String binid = (String) table2.getValueAt(row, 0);
				String binname = (String) table2.getValueAt(row, 1);
				String gender = (String) table2.getValueAt(row, 2);
				String age = (String) table2.getValueAt(row, 3);
				String keshi = (String) table2.getValueAt(row, 4);
				String yisheng = (String) table2.getValueAt(row, 5);
				String shenfenzhen = (String) table2.getValueAt(row, 6);

				// while (1 == 1) {

				String zhifu = zhifuField.getText();
				int zhifu2 = Integer.parseInt(zhifu);

				int zhaoqian = zhifu2 - sum2;
				String zhaoqian2 = Integer.toString(zhaoqian);

				if (zhaoqian >= 0) {
					zhaoqianField.setText(zhaoqian2);
					JOptionPane.showMessageDialog(null, "缴费成功！找零"+zhaoqian2+"元");

					Connection connection8 = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						connection8 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

						String sql2 = "update kaiyaobiao set zhuanTai = ? where binID = ?";
						String sql3 = "update guahaobiao set Yes_No = ? where binID = ?";
						String sql4 = "update zhenduanbiao set Yes_No = ? where binID = ?";
						PreparedStatement ps2 = connection8.prepareStatement(sql2);
						PreparedStatement ps3 = connection8.prepareStatement(sql3);
						PreparedStatement ps4 = connection8.prepareStatement(sql4);

						ps2.setObject(1, "0");
						ps2.setObject(2, binid);

						ps3.setObject(1, "2");
						ps3.setObject(2, binid);
						
						ps4.setObject(1, "2");
						ps4.setObject(2, binid);

						int n = ps2.executeUpdate();// 插入操作应该调用executeUpdate方法
						int n3 = ps3.executeUpdate();
						
						int n4 = ps4.executeUpdate();

					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						try {
							connection8.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

					new Quyao_biao(binid);

				} else {
					JOptionPane.showMessageDialog(null, "请确保 缴费金额 高于 应缴费金额！");
					zhifuField.setText("");
					zhaoqianField.setText("");
					// continue;
				}
				// }
			}
		});

		table2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					row = table2.getSelectedRow();// 得到表格选中的是哪一行

					if (row == -1) {
						JOptionPane.showMessageDialog(null, "请先选中所需缴费病人");
						return;
					}
				}

			}

		});

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 关闭界面
				YaofeView.this.dispose();
			}
		});

		setVisible(true);

	}

	int aa = 0;
	int bb = 0;
	private final JLabel lblNewLabel = new JLabel("");

	public static void main(String[] args) {

		new YaofeView();

	}
}
