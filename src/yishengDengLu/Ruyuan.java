package yishengDengLu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

import javax.enterprise.inject.New;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import guanlizheTengLu.Jiuzhen_XiangQing;
import menzhenDenglu.GuahaoDan;
import menzhenDenglu.GuahaoView;
import menzhenDenglu.MenzhenDenglu;
import pojo.Bin;
import pojo.Keshi;
import pojo.Yaopin;
import pojo.Yisheng;
import pojo.Zhiye;
import util.Age;
import util.Chooser;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Ruyuan extends JDialog {

	int i = 0;
	int row = -1;
	// int binid = -1;
	String zhiyeid = "";
	String keshiid = "";

	String zhiyename = "";
	String keshiname = "";

	String yiname = "";
	String yid = "";

	// 病人表
	private JTable table = new JTable();
	private JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	// 药品表
	private JTable table2 = new JTable() {

		public boolean isCellEditable(int row, int column) {

			return false;
		};

	};
	private JScrollPane pane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	// VERTICAL_SCROLLBAR_AS_NEEDED;VERTICAL_SCROLLBAR_NEVER;

	// 开药表
	private JTable table3 = new JTable() {

		public boolean isCellEditable(int row, int column) {

			return false;
		};

	};
	private JScrollPane pane3 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private JLabel a = new JLabel("\u76EE \u524D    \u5DF2 \u6709 :");
	private JLabel b = new JLabel("\u6302  \u53F7");
	private JTextPane numPane = new JTextPane();

	private JLabel binLabel = new JLabel("请选择病人的门诊号");
	private JComboBox<Bin> binBox = new JComboBox<Bin>();
	private JButton sureButton = new JButton("确认");

	private JLabel jieguoLabel = new JLabel("\u8BCA \u65AD    \u7ED3 \u679C \uFF1A");
	private JTextPane jieguoPane = new JTextPane();

	private JLabel houseLabel = new JLabel("\u75C5     \u623F     \u53F7 :");
	private JTextPane housePane = new JTextPane();
	private JButton chahouseButton = new JButton("分配病房");

	private JLabel sayLabel = new JLabel("\u533B      \u5631 :");
	private JTextField sayField = new JTextField();

	private JLabel qianmingLabel = new JLabel("\u533B\u751F \u7B7E\u540D \uFF1A");
	private JTextPane qianmPane = new JTextPane();

	private JLabel shulianLabel = new JLabel("\u586B\u5165\u836F\u54C1\u6570\u91CF\uFF1A");
	private JTextField shulianField = new JTextField();

	private JTextField yao1Field = new JTextField();
	private JTextField yao2Field = new JTextField();
	private JTextField yao3Field = new JTextField();
	private JTextField yao4Field = new JTextField();

	private JButton tianjiaButton = new JButton("\u6DFB\u52A0\u836F\u54C1");
	private JButton printButton = new JButton("打印挂号单");
	private JButton backButton = new JButton("返回上一级");

	private JRadioButton w1Button = new JRadioButton("中药类");
	private JRadioButton w2Button = new JRadioButton("感冒类药品");
	private JRadioButton w3Button = new JRadioButton("消化类药品");
	private JRadioButton w4Button = new JRadioButton("心脑血管类");
	private JRadioButton w5Button = new JRadioButton("抗生素类药品");
	private JRadioButton w6Button = new JRadioButton("维生素类药品");

	public Ruyuan(String yiid) {
		yid = yiid;
		getContentPane().setForeground(Color.LIGHT_GRAY);

		setSize(900, 1042);
		setLocationRelativeTo(null);
		setResizable(false);

		setModal(true);

		pane.setBounds(50, 110, 782, 65);
		pane2.setBounds(50, 411, 782, 213);
		pane3.setBounds(50, 650, 782, 141);

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
		a.setFont(new Font("微软雅黑", Font.BOLD, 21));

		a.setBounds(50, 20, 145, 30);
		numPane.setForeground(Color.BLACK);
		numPane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		numPane.setBounds(205, 20, 25, 30);
		b.setFont(new Font("微软雅黑", Font.BOLD, 21));
		b.setBounds(260, 20, 120, 30);
		getContentPane().add(a);
		getContentPane().add(numPane);
		getContentPane().add(b);
		jieguoLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		jieguoLabel.setBounds(50, 235, 167, 30);
		jieguoPane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		jieguoPane.setBounds(261, 235, 351, 30);
		houseLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		houseLabel.setBounds(50, 183, 145, 30);
		housePane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		housePane.setBounds(260, 183, 145, 30);
		chahouseButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chahouseButton.setBounds(469, 183, 143, 30);
		binLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		binLabel.setBounds(50, 72, 194, 30);
		binBox.setFont(new Font("微软雅黑", Font.BOLD, 21));
		binBox.setBounds(260, 72, 145, 30);
		sayLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		sayLabel.setBounds(53, 801, 107, 30);
		sayField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		sayField.setBounds(53, 841, 779, 82);
		qianmingLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		qianmingLabel.setBounds(50, 933, 130, 30);
		qianmPane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		qianmPane.setBounds(155, 933, 145, 30);
		sureButton.setFont(new Font("微软雅黑", Font.BOLD, 21));

		sureButton.setBounds(467, 72, 145, 30);
		printButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		printButton.setBounds(653, 933, 179, 30);
		backButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		backButton.setBounds(653, 973, 179, 30);
		tianjiaButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		tianjiaButton.setBounds(469, 286, 143, 30);
		shulianLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		shulianLabel.setBounds(50, 286, 167, 30);
		shulianField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		shulianField.setBounds(260, 286, 145, 30);

		yao1Field.setBounds(28, 486, 88, 30);
		yao2Field.setBounds(140, 486, 100, 30);
		yao3Field.setBounds(269, 486, 107, 30);
		yao4Field.setBounds(408, 484, 107, 30);

		w1Button.setBackground(new Color(51, 204, 204));
		w1Button.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w1Button.setBounds(50, 375, 196, 30);
		w2Button.setBackground(new Color(51, 204, 204));
		w2Button.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w2Button.setBounds(345, 331, 196, 30);
		w3Button.setBackground(new Color(51, 204, 204));
		w3Button.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w3Button.setBounds(50, 331, 196, 30);
		w4Button.setBackground(new Color(51, 204, 204));
		w4Button.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w4Button.setBounds(636, 331, 196, 30);
		w5Button.setBackground(new Color(51, 204, 204));
		w5Button.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w5Button.setBounds(345, 375, 196, 30);
		w6Button.setBackground(new Color(51, 204, 204));
		w6Button.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w6Button.setBounds(636, 375, 196, 30);

		getContentPane().add(w1Button);
		getContentPane().add(w2Button);
		getContentPane().add(w3Button);
		getContentPane().add(w4Button);
		getContentPane().add(w5Button);
		getContentPane().add(w6Button);

		getContentPane().add(sureButton);
		getContentPane().add(printButton);
		getContentPane().add(backButton);
		getContentPane().add(tianjiaButton);

		getContentPane().add(shulianField);
		getContentPane().add(shulianLabel);

		getContentPane().add(jieguoLabel);
		getContentPane().add(jieguoPane);

		getContentPane().add(houseLabel);
		getContentPane().add(housePane);
		getContentPane().add(chahouseButton);

		getContentPane().add(binLabel);
		getContentPane().add(binBox);

		getContentPane().add(sayLabel);
		getContentPane().add(sayField);

		getContentPane().add(qianmingLabel);
		getContentPane().add(qianmPane);

		// getContentPane().add(yao1Field);
		// getContentPane().add(yao2Field);
		// getContentPane().add(yao3Field);
		// getContentPane().add(yao4Field);

		Connection connection8 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection8 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql8 = "select yiName from yishenbiao where yiID =?";
			PreparedStatement ps8 = connection8.prepareStatement(sql8);
			ps8.setObject(1, yiid);
			ResultSet rs8 = ps8.executeQuery();

			if (rs8.next()) {
				yiname = rs8.getString("yiName");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				connection8.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		setTitle("欢迎使用医院高级管理系统--" + yiname + "医师");

		// 显示药品表
		Vector<String> thVector2 = new Vector<String>();
		thVector2.add("药品序号");
		thVector2.add("药品名称");
		thVector2.add("药品价格");
		thVector2.add("药品类型");
		thVector2.add("包装方式");
		thVector2.add("库存数量");
		Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();
		Connection connection7 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection7 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select yaoBianhao , yaoName , yaoJiage , yaoLeixing , leixing , yaoShuliang from yaopinbiao";
			PreparedStatement ps = connection7.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Vector<String> vector2 = new Vector<String>();
				vector2.add(rs.getString(1));
				vector2.add(rs.getString(2));
				vector2.add(rs.getString(3));
				vector2.add(rs.getString(4));
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

		// 查人数,病人入库
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select  Yes_No,binYisheng ,binID ,binName from guahaobiao where binYisheng = ? and Yes_No = 0";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setObject(1, yiid);
			ResultSet rs = ps.executeQuery();

			int a = 0;
			while (rs.next()) {

				if (rs.getInt(1) == 0) {
					a++;
				}

				Bin bin = new Bin();
				bin.setbinID(rs.getInt(3));
				bin.setbinName(rs.getString(4));
				binBox.addItem(bin);
			}

			numPane.setText("" + a);
			a = 0;

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		// 显示患者
		sureButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Bin bin = (Bin) binBox.getSelectedItem();
				int binid = bin.getbinID();

				Vector<String> thVector = new Vector<String>();
				thVector.add("门诊号");
				thVector.add("姓名");
				thVector.add("性别");
				thVector.add("年龄");
				thVector.add("职业");
				thVector.add("科室");
				Vector<Vector<String>> dataVector = new Vector<Vector<String>>();

				Connection connection = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "select binid , binName , binGender , binBirthday , zhiyeID , keshiName from guahaobiao where binID = ?";
					String sql2 = "select  keName from keshibiao where keID = ?";
					String sql3 = "select  zhiyeName  from zhiyebiao where zhiyeID = ?";

					PreparedStatement ps = connection.prepareStatement(sql);
					PreparedStatement ps2 = connection.prepareStatement(sql2);
					PreparedStatement ps3 = connection.prepareStatement(sql3);
					ps.setObject(1, binid);

					// System.out.println(zhiyeid);

					ResultSet rs = ps.executeQuery();

					Vector<String> vector = new Vector<String>();
					if (rs.next()) {

						zhiyeid = rs.getString("zhiyeID");
						keshiid = rs.getString("keshiName");

						vector.add(rs.getString(1));
						vector.add(rs.getString(2));
						vector.add(rs.getString(3).equals("1") ? "男" : "女");

						String age = rs.getString(4);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date date = sdf.parse(age);
						Age a = new Age();
						int b = a.getAge(date);
						vector.add("" + b);

					}
					ps2.setObject(1, keshiid);
					ps3.setObject(1, zhiyeid);
					ResultSet rs2 = ps2.executeQuery();
					ResultSet rs3 = ps3.executeQuery();

					if (rs3.next()) {
						vector.add(rs3.getString(1));

					}

					if (rs2.next()) {
						vector.add(rs2.getString(1));

					}

					dataVector.add(vector);
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						connection.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

				DefaultTableModel defaultTableModel = new DefaultTableModel(dataVector, thVector);
				table.setModel(defaultTableModel);// 把得到的表模型給表格
				table.setDefaultRenderer(Object.class, new denglu.Gai_biao());
				table.setRowHeight(30);
				table.setFont(new Font("微软雅黑", Font.BOLD, 20));
				table.getTableHeader().setFont(new Font("微软雅黑", 3, 21));
				table.getTableHeader().setBackground(Color.WHITE);
				pane.setViewportView(table);

				getContentPane().add(pane);

			}
		});

		// 显示开药表
		Vector<String> thVector3 = new Vector<String>();
		thVector3.add("药品编号");
		thVector3.add("药品名称");
		thVector3.add("药品价格");
		thVector3.add("药品类型");
		thVector3.add("包装方式");
		thVector3.add("开药数量");
		Vector<Vector<String>> dataVector3 = new Vector<Vector<String>>();
		// Connection connection8 = null;
		// try {
		// Bin bin = (Bin) binBox.getSelectedItem();
		// int binid = bin.getbinID();
		//
		// System.out.println(binid);
		// Class.forName("com.mysql.jdbc.Driver");
		// connection8 =
		// DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统",
		// "root", "root");
		//
		// String sql = "select yaoID,yaoName,money,Leixin,baoLeixin,num from
		// kaiyaobiao where binID = ?";
		// PreparedStatement ps = connection8.prepareStatement(sql);
		// ps.setObject(1, binid);
		// ResultSet rs = ps.executeQuery();
		//
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
		// } catch (Exception e1) {
		// e1.printStackTrace();
		// } finally {
		// try {
		// connection8.close();
		// } catch (SQLException e1) {
		// e1.printStackTrace();
		// }
		// }
		DefaultTableModel defaultTableModel3 = new DefaultTableModel(dataVector3, thVector3);
		table3.setModel(defaultTableModel3);// 把得到的表模型給表格
		table3.setDefaultRenderer(Object.class, new denglu.Gai_biao());
		table3.setRowHeight(30);
		table3.setFont(new Font("微软雅黑", Font.BOLD, 20));
		table3.getTableHeader().setFont(new Font("微软雅黑", 3, 21));
		table3.getTableHeader().setBackground(Color.WHITE);
		pane3.setViewportView(table3);

		getContentPane().add(pane3);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));
		lblNewLabel.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\RuYuan20190819110109.png"));
		lblNewLabel.setBounds(-10, 10, 894, 1013);
		getContentPane().add(lblNewLabel);

		chahouseButton.addActionListener(new ActionListener() {//////////////////////////////////////////////////////////////////////////////////////////////////////////////

			@Override
			public void actionPerformed(ActionEvent e) {

				new ChaHouse(yid);
			}
		});

		table2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					row = table2.getSelectedRow();// 得到表格选中的是哪一行

					if (row == -1) {
						JOptionPane.showMessageDialog(null, "请先选中所需药品");
						return;
					}
				}

			}

		});

		// new了就会执行，默认Box取值为1；
		// Bin bin = (Bin) binBox.getSelectedItem();
		// int id = bin.getbinID();
		// System.out.println(id);

		tianjiaButton.addActionListener(new ActionListener() {

			int i = 1;

			@Override
			public void actionPerformed(ActionEvent e) {
				Bin bin = (Bin) binBox.getSelectedItem();
				int binid = bin.getbinID();

				String yaoid = (String) table2.getValueAt(row, 0);

				String yaoname = (String) table2.getValueAt(row, 1);
				String money = (String) table2.getValueAt(row, 2);
				String leixin = (String) table2.getValueAt(row, 3);
				String baoleixin = (String) table2.getValueAt(row, 4);
				String yaoshu = (String) table2.getValueAt(row, 5);
				String shulian = shulianField.getText();

				int a = Integer.parseInt(money);
				int b = Integer.parseInt(shulian);
				int c = a * b;
				String money2 = Integer.toString(c);

				Connection connection = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");
					String sql = "insert into kaiyaobiao(yaoName,binID,yaoID,money,Leixin,baoLeixin,zhuanTai,num) values(?,?,?,?,?,?,?,?)";
					String sql2 = "insert into binmoney(binID,yaoMoney) values(?,?)";
					String sql3 = "update yaopinbiao set yaoShuliang = ? where yaoBianhao = ?";
					PreparedStatement ps = connection.prepareStatement(sql);
					PreparedStatement ps2 = connection.prepareStatement(sql2);

					ps.setObject(2, binid);
					ps.setObject(3, yaoid);
					ps.setObject(1, yaoname);
					ps.setObject(4, money);
					ps.setObject(5, leixin);
					ps.setObject(6, baoleixin);
					ps.setObject(7, 1);
					ps.setObject(8, shulian);

					ps2.setObject(1, binid);
					ps2.setObject(2, money2);

					int n = ps.executeUpdate();
					int n2 = ps2.executeUpdate();

					int yaoshu2 = Integer.parseInt(yaoshu);
					int shulian2 = Integer.parseInt(shulian);

					if (n > 0) {

						shulianField.setText("");

						DefaultTableModel defaultTableModel3 = (DefaultTableModel) table3.getModel();
						defaultTableModel3.setValueAt(yaoid, i - 1, 0);
						defaultTableModel3.setValueAt(yaoname, i - 1, 1);
						defaultTableModel3.setValueAt(money, i - 1, 2);
						defaultTableModel3.setValueAt(leixin, i - 1, 3);
						defaultTableModel3.setValueAt(baoleixin, i - 1, 4);
						defaultTableModel3.setValueAt(shulian, i - 1, 5);
						i++;

						DefaultTableModel defaultTableModel2 = (DefaultTableModel) table2.getModel();
						defaultTableModel2.setValueAt(yaoshu2 - shulian2, row, 5);

					} else {
						JOptionPane.showMessageDialog(null, "选药失败");
					}

					PreparedStatement ps3 = connection.prepareStatement(sql3);
					ps3.setObject(1, yaoshu2 - shulian2);
					ps3.setObject(2, yaoid);
					int n3 = ps3.executeUpdate();

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

		printButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Bin bin = (Bin) binBox.getSelectedItem();
				int binid = bin.getbinID();
				String binname = bin.getbinName();
				String result = jieguoPane.getText();

				String house = "";
				if (housePane.getText() == null) {

					 house = "0";
				} else {

					 house = housePane.getText();

				}

				String yisay = sayField.getText();
				String yiname = qianmPane.getText();

				Connection connection8 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection8 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "insert into zhenduanbiao(binID,result,house,yiSay,yiName,keshiID,binName,keshiName,Yes_No) values(?,?,?,?,?,?,?,?,?)";
					String sql2 = "update guahaobiao set Yes_NO =? where binid=?";
					String sql3 = "update house set binName = ? ,binID = ? where houNum= ? and keshiID = ?";

					PreparedStatement ps = connection8.prepareStatement(sql);
					PreparedStatement ps2 = connection8.prepareStatement(sql2);
					PreparedStatement ps3 = connection8.prepareStatement(sql3);

					ps.setObject(1, binid);
					ps.setObject(2, result);
					ps.setObject(3, house);
					ps.setObject(4, yisay);
					ps.setObject(5, yiname);
					ps.setObject(6, keshiid);
					ps.setObject(7, binname);
					ps.setObject(8, keshiname);
					ps.setObject(9, "1");

					ps2.setObject(1, 1);
					ps2.setObject(2, binid);

					ps3.setObject(1, binname);
					ps3.setObject(2, binid);
					ps3.setObject(3, house);
					ps3.setObject(4, keshiid);

					int n2 = ps2.executeUpdate();

					int n = ps.executeUpdate();// 真正去执行sql语句

					int n3 = ps3.executeUpdate();

					if (n > 0) {

						String idd = "";
						idd = Integer.toString(binid);
						new Jiuzhen_XiangQing(idd);

					} else {
						JOptionPane.showMessageDialog(null, "打印失败");
					}
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

		w1Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 显示药品表
				Vector<String> thVector2 = new Vector<String>();
				thVector2.add("药品序号");
				thVector2.add("药品名称");
				thVector2.add("药品价格");
				thVector2.add("药品类型");
				thVector2.add("包装方式");
				thVector2.add("库存数量");
				final Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();

				Connection connection7 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root",
							"root");

					String sql = "select yaoBianhao , yaoName , yaoJiage , yaoLeixing , leixing , yaoShuliang from yaopinbiao where yaoLeixing = ?";
					PreparedStatement ps = connection7.prepareStatement(sql);
					ps.setObject(1, "中药类");
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						Vector<String> vector2 = new Vector<String>();
						vector2.add(rs.getString(1));
						vector2.add(rs.getString(2));
						vector2.add(rs.getString(3));
						vector2.add(rs.getString(4));
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
				pane2.setViewportView(table2);
			}
		});

		w2Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 显示药品表
				Vector<String> thVector2 = new Vector<String>();
				thVector2.add("药品序号");
				thVector2.add("药品名称");
				thVector2.add("药品价格");
				thVector2.add("药品类型");
				thVector2.add("包装方式");
				thVector2.add("库存数量");
				final Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();

				Connection connection7 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root",
							"root");

					String sql = "select yaoBianhao , yaoName , yaoJiage , yaoLeixing , leixing , yaoShuliang from yaopinbiao where yaoLeixing = ?";
					PreparedStatement ps = connection7.prepareStatement(sql);
					ps.setObject(1, "感冒类药品");
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						Vector<String> vector2 = new Vector<String>();
						vector2.add(rs.getString(1));
						vector2.add(rs.getString(2));
						vector2.add(rs.getString(3));
						vector2.add(rs.getString(4));
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
				pane2.setViewportView(table2);
			}
		});

		w3Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 显示药品表
				Vector<String> thVector2 = new Vector<String>();
				thVector2.add("药品序号");
				thVector2.add("药品名称");
				thVector2.add("药品价格");
				thVector2.add("药品类型");
				thVector2.add("包装方式");
				thVector2.add("库存数量");
				final Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();

				Connection connection7 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root",
							"root");

					String sql = "select yaoBianhao , yaoName , yaoJiage , yaoLeixing , leixing , yaoShuliang from yaopinbiao where yaoLeixing = ?";
					PreparedStatement ps = connection7.prepareStatement(sql);
					ps.setObject(1, "消化类药品");
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						Vector<String> vector2 = new Vector<String>();
						vector2.add(rs.getString(1));
						vector2.add(rs.getString(2));
						vector2.add(rs.getString(3));
						vector2.add(rs.getString(4));
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
				pane2.setViewportView(table2);
			}
		});

		w4Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 显示药品表
				Vector<String> thVector2 = new Vector<String>();
				thVector2.add("药品序号");
				thVector2.add("药品名称");
				thVector2.add("药品价格");
				thVector2.add("药品类型");
				thVector2.add("包装方式");
				thVector2.add("库存数量");
				final Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();

				Connection connection7 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root",
							"root");

					String sql = "select yaoBianhao , yaoName , yaoJiage , yaoLeixing , leixing , yaoShuliang from yaopinbiao where yaoLeixing = ?";
					PreparedStatement ps = connection7.prepareStatement(sql);
					ps.setObject(1, "心脑血管类");
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						Vector<String> vector2 = new Vector<String>();
						vector2.add(rs.getString(1));
						vector2.add(rs.getString(2));
						vector2.add(rs.getString(3));
						vector2.add(rs.getString(4));
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
				pane2.setViewportView(table2);
			}
		});

		w5Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 显示药品表
				Vector<String> thVector2 = new Vector<String>();
				thVector2.add("药品序号");
				thVector2.add("药品名称");
				thVector2.add("药品价格");
				thVector2.add("药品类型");
				thVector2.add("包装方式");
				thVector2.add("库存数量");
				final Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();

				Connection connection7 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root",
							"root");

					String sql = "select yaoBianhao , yaoName , yaoJiage , yaoLeixing , leixing , yaoShuliang from yaopinbiao where yaoLeixing = ?";
					PreparedStatement ps = connection7.prepareStatement(sql);
					ps.setObject(1, "抗生素类药品");
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						Vector<String> vector2 = new Vector<String>();
						vector2.add(rs.getString(1));
						vector2.add(rs.getString(2));
						vector2.add(rs.getString(3));
						vector2.add(rs.getString(4));
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
				pane2.setViewportView(table2);
			}
		});

		w6Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 显示药品表
				Vector<String> thVector2 = new Vector<String>();
				thVector2.add("药品序号");
				thVector2.add("药品名称");
				thVector2.add("药品价格");
				thVector2.add("药品类型");
				thVector2.add("包装方式");
				thVector2.add("库存数量");
				final Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();

				Connection connection7 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root",
							"root");

					String sql = "select yaoBianhao , yaoName , yaoJiage , yaoLeixing , leixing , yaoShuliang from yaopinbiao where yaoLeixing = ?";
					PreparedStatement ps = connection7.prepareStatement(sql);
					ps.setObject(1, "维生素类药品");
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						Vector<String> vector2 = new Vector<String>();
						vector2.add(rs.getString(1));
						vector2.add(rs.getString(2));
						vector2.add(rs.getString(3));
						vector2.add(rs.getString(4));
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
				pane2.setViewportView(table2);
			}
		});

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 关闭界面
				Ruyuan.this.dispose();
			}
		});

		setVisible(true);

	}

	int aa = 0;
	int bb = 0;

	public static void main(String[] args) {

		new Ruyuan("1");

	}
}