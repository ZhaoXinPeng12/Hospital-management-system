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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import denglu.Gai_biao2_tu;
import guanlizheTengLu.Jiuzhen_XiangQing;
import util.Age;

public class ChuYuanDan extends JFrame {

	String stoptime = "";
	String time = "";
	String time3 = "";
	String yishengid = "";

	private JLabel aLabel = new JLabel("\u60A3\u8005\u57FA\u672C\u4FE1\u606F \uFF1A");
	private JLabel bLabel = new JLabel("\u6240\u5F00\u836F\u54C1\u8BE6\u60C5 \uFF1A");

	private JLabel shenfenzhengLabel = new JLabel("\u8EAB  \u4EFD   \u8BC1 \uFF1A");
	private JTextPane shenfenzhengPane = new JTextPane();
	private JTextPane telPane = new JTextPane();

	private JLabel addressLabel = new JLabel("\u5BB6\u5EAD \u4F4F\u5740 \uFF1A");
	private JTextPane addressPane = new JTextPane();

	private JLabel houseLabel = new JLabel("\u4F4F\u9662 \u623F\u53F7 \uFF1A");
	private JTextPane housePane = new JTextPane();

	private JLabel resultLabel = new JLabel("\u8BCA\u65AD \u7ED3\u679C \uFF1A");
	private JTextPane resultPane = new JTextPane();

	private JLabel yishengidLabel = new JLabel("\u533B\u751F \u7B7E\u540D \uFF1A");
	private JTextPane yishengPane = new JTextPane();

	private JLabel moneyLabel = new JLabel("\u836F\u54C1 \u8D39\u7528 \uFF1A");
	private JTextPane moneyPane = new JTextPane();

	private JLabel money2Label = new JLabel("\u4F4F\u9662 \u8D39\u7528 \uFF1A");
	private JTextPane money2Pane = new JTextPane();

	private JLabel money3Label = new JLabel("\u603B   \u8D39  \u7528 \uFF1A");
	private JTextPane money3Pane = new JTextPane();

	private JLabel sayLabel = new JLabel("\u533B        \u5631 \uFF1A");
	private JTextPane sayPane = new JTextPane();

	private JLabel time3Label = new JLabel("\u6302\u53F7 \u65F6\u95F4 \uFF1A");
	private JTextPane time3Pane = new JTextPane();

	private JLabel time2Label = new JLabel("\u51FA\u9662 \u65F6\u95F4 \uFF1A");
	private JTextPane time2Pane = new JTextPane();

	private JLabel timeLabel = new JLabel("\u5C31\u8BCA \u65F6\u95F4 \uFF1A");
	private JTextPane timePane = new JTextPane();

	private JButton backButton = new JButton("\u8FD4\u56DE\u7EE7\u7EED\u5C31\u8BCA");

	// 病人表
	private JTable table2 = new JTable() {

		public boolean isCellEditable(int row, int column) {

			return false;
		};

	};
	private JScrollPane pane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,
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

	public ChuYuanDan(String biid) {

		String keshiid = "";

		String zhiyeid = "";
		setTitle("欢迎使用医院高级管理系统");
		setSize(935, 1040);
		setLocationRelativeTo(null);
		setResizable(false);

		pane2.setBounds(61, 122, 824, 65);
		pane3.setBounds(61, 597, 824, 163);

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
		
		aLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		aLabel.setBounds(61, 93, 165, 30);
		bLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));
		bLabel.setBounds(61, 557, 220, 30);
		shenfenzhengLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		shenfenzhengLabel.setBounds(61, 197, 149, 30);
		shenfenzhengPane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		shenfenzhengPane.setBounds(308, 197, 220, 30);
		telPane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		telPane.setBounds(308, 237, 220, 30);
		addressLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		addressLabel.setBounds(61, 317, 165, 30);
		addressPane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		addressPane.setBounds(308, 317, 220, 30);
		houseLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		houseLabel.setBounds(61, 277, 149, 30);
		housePane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		housePane.setBounds(308, 277, 220, 30);
		resultLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		resultLabel.setBounds(63, 357, 147, 30);
		resultPane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		resultPane.setBounds(308, 357, 220, 30);
		yishengidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		yishengidLabel.setBounds(549, 889, 163, 30);
		yishengPane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		yishengPane.setBounds(722, 889, 163, 30);
		moneyLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		moneyLabel.setBounds(61, 437, 165, 30);
		moneyPane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		moneyPane.setBounds(308, 437, 220, 30);
		money2Label.setFont(new Font("微软雅黑", Font.BOLD, 21));

		money2Label.setBounds(61, 477, 149, 30);
		money2Pane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		money2Pane.setBounds(308, 477, 220, 30);
		money3Label.setFont(new Font("微软雅黑", Font.BOLD, 21));

		money3Label.setBounds(61, 517, 165, 30);
		money3Pane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		money3Pane.setBounds(308, 517, 220, 30);
		sayLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		sayLabel.setBounds(61, 397, 149, 30);
		sayPane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		sayPane.setBounds(308, 397, 220, 30);
		time3Label.setFont(new Font("微软雅黑", Font.BOLD, 21));

		time3Label.setBounds(549, 770, 163, 30);
		time3Pane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		time3Pane.setBounds(722, 770, 163, 30);
		timeLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		timeLabel.setBounds(549, 810, 163, 30);
		timePane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		timePane.setBounds(722, 810, 163, 30);
		time2Label.setFont(new Font("微软雅黑", Font.BOLD, 21));

		time2Label.setBounds(549, 849, 163, 30);
		time2Pane.setFont(new Font("微软雅黑", Font.BOLD, 21));
		time2Pane.setBounds(722, 850, 163, 30);
		backButton.setFont(new Font("微软雅黑", Font.BOLD, 21));

		backButton.setBounds(722, 958, 163, 30);

		getContentPane().add(aLabel);
		getContentPane().add(bLabel);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 21));
		lblNewLabel_1.setBounds(61, 237, 123, 30);

		getContentPane().add(lblNewLabel_1);
		getContentPane().add(telPane);

		getContentPane().add(shenfenzhengLabel);
		getContentPane().add(shenfenzhengPane);

		getContentPane().add(addressLabel);
		getContentPane().add(addressPane);

		getContentPane().add(houseLabel);
		getContentPane().add(housePane);

		getContentPane().add(resultLabel);
		getContentPane().add(resultPane);

		getContentPane().add(yishengidLabel);
		getContentPane().add(yishengPane);

		getContentPane().add(moneyLabel);
		getContentPane().add(moneyPane);

		getContentPane().add(money2Label);
		getContentPane().add(money2Pane);

		getContentPane().add(money3Label);
		getContentPane().add(money3Pane);

		getContentPane().add(sayLabel);
		getContentPane().add(sayPane);

		getContentPane().add(time3Label);
		getContentPane().add(time3Pane);

		getContentPane().add(timeLabel);
		getContentPane().add(timePane);

		getContentPane().add(time2Label);
		getContentPane().add(time2Pane);

		getContentPane().add(backButton);

		// 显示病人表
		Vector<String> thVector2 = new Vector<String>();
		thVector2.add("门诊号");
		thVector2.add("姓名");
		thVector2.add("性别");
		thVector2.add("年龄");
		thVector2.add("职业");
		thVector2.add("科室");
		thVector2.add("就诊医生");
		Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();

		Connection connection7 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection7 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root",
					"root");

			String sql = "select g.binid , g.binName , g.binGender , g.binBirthday , z.zhiyeName , k.keName ,y.yiName ,g.binYisheng from yishenbiao y, guahaobiao g, keshibiao k,zhiyebiao z where g.binID = ? and y.yiID=g.binYisheng and k.keID= g.keshiName and z.zhiyeID=g.zhiyeID";
			PreparedStatement ps = connection7.prepareStatement(sql);
			ps.setObject(1, biid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Vector<String> vector2 = new Vector<String>();
				vector2.add(rs.getString(1));
				vector2.add(rs.getString(2));
				vector2.add(rs.getString(3).equals("1") ? "男" : "女");

				String age = rs.getString(4);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(age);
				Age a = new Age();
				int b = a.getAge(date);
				vector2.add("" + b);

				vector2.add(rs.getString(5));
				vector2.add(rs.getString(6));
				vector2.add(rs.getString(7));

				dataVector2.add(vector2);

				yishengid = rs.getString(8);
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
		table2.setDefaultRenderer(Object.class, new denglu.Gai_biao2_tu());
		table2.setRowHeight(30);
		table2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		table2.getTableHeader().setFont(new Font("微软雅黑", 3, 21));
		table2.getTableHeader().setBackground(Color.WHITE);
		pane2.setViewportView(table2);
		getContentPane().add(pane2);

		// 显示药品表
		Vector<String> thVector3 = new Vector<String>();
		thVector3.add("药品序号");
		thVector3.add("药品名称");
		thVector3.add("药品价格");
		thVector3.add("药品类型");
		thVector3.add("包装方式");
		thVector3.add("开药数量");
		Vector<Vector<String>> dataVector3 = new Vector<Vector<String>>();
		Connection connection9 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection9 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select yaoID , yaoName , money , Leixin , baoLeixin , num from kaiyaobiao where binID =? order by yaoID";
			PreparedStatement ps = connection9.prepareStatement(sql);
			ps.setObject(1, biid);
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
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				connection9.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		DefaultTableModel defaultTableModel3 = new DefaultTableModel(dataVector3, thVector3);
		table3.setModel(defaultTableModel3);// 把得到的表模型給表格
		table3.setDefaultRenderer(Object.class, new Gai_biao2_tu());
		table3.setRowHeight(30);
		table3.setFont(new Font("微软雅黑", Font.BOLD, 20));
		table3.getTableHeader().setFont(new Font("微软雅黑", 3, 21));
		table3.getTableHeader().setBackground(Color.WHITE);
		pane3.setViewportView(table3);

		getContentPane().add(pane3);

		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");
			String sql = "select keshiName,house,result,yiName,yiSay,time ,stopTime from zhenduanbiao where binID=?";
			String sql2 = "select binShenfenzheng,binTel,binAddress,binTime from guahaobiao where binID=?";

			PreparedStatement ps = connection.prepareStatement(sql);
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			ps.setObject(1, biid);
			ps2.setObject(1, biid);
			ResultSet rs = ps.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			if (rs.next()) {

				String keshi = rs.getString("keshiName");
				int house = rs.getInt("house");
				String result = rs.getString("result");
				String yisheng = rs.getString("yiName");
				String say = rs.getString("yiSay");
				time = rs.getString("time");
				stoptime = rs.getString("stopTime");

				if (house != 0) {
					housePane.setText(keshi + "  " + house + "号房");
				} else {
					housePane.setText("未住院");
				}

				resultPane.setText(result);
				sayPane.setText(say);
				yishengPane.setText(yisheng);
				timePane.setText(time);
				time2Pane.setText(stoptime);

			} else {
				JOptionPane.showMessageDialog(null, "发生错误");
			}

			if (rs2.next()) {

				String shengfenzheng = rs2.getString("binShenfenzheng");
				String tel = rs2.getString("binTel");
				String address = rs2.getString("binAddress");
				String time2 = rs2.getString("binTime");

				shenfenzhengPane.setText(shengfenzheng);
				telPane.setText(tel);
				addressPane.setText(address);
				time3Pane.setText(time2);

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

		// 费用
		int sum = 0;
		Connection connection2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select binGender,binBirthday,binTime from guahaobiao  where binID = ?";
			String sql2 = "select yaoID , yaoName,money,num,Leixin,baoLeixin from kaiyaobiao where binID = ?";
			PreparedStatement ps = connection2.prepareStatement(sql);
			PreparedStatement ps2 = connection2.prepareStatement(sql2);
			ps.setObject(1, biid);
			ps2.setObject(1, biid);
			ResultSet rs = ps.executeQuery();
			ResultSet rs2 = ps2.executeQuery();

			if (rs.next()) {

				String guaTime = rs.getString("binTime");

			}

			while (rs2.next()) {

				String money2 = rs2.getString(3);
				String num2 = rs2.getString(4);

				int money3 = Integer.parseInt(money2);
				int num3 = Integer.parseInt(num2);
				sum = sum + num3 * money3;

			}

			String money4 = Integer.toString(sum);
			moneyPane.setText(money4 + " 元");
			lblNewLabel.setIcon(
					new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\QQ\u622A\u56FE20190820015514.png"));
			lblNewLabel.setBounds(0, 0, 929, 1031);

			getContentPane().add(lblNewLabel);

			long sum3 = 0;

			if (stoptime != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				Date date = sdf.parse(stoptime);
				Date date2 = sdf.parse(time);

				long day = (date.getTime() - date2.getTime()) / 86400000;
				sum3 = 25 * day;
				String sum4 = String.valueOf(sum3);
				money2Pane.setText(sum4 + " 元");

				long sum5 = sum3 + sum;
				String sum6 = String.valueOf(sum5);
				money3Pane.setText(sum6 + " 元");
			} else {
				money2Pane.setText("无住院费");
				String sum7 = Integer.toString(sum);
				money3Pane.setText(sum7 + " 元");
				time2Pane.setText("暂未出院");

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

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ChuYuanDan.this.dispose();
			
			}
		});

		setVisible(true);

	}

	int aa = 0;
	int bb = 0;
	private final JLabel lblNewLabel = new JLabel("");
	private final JLabel lblNewLabel_1 = new JLabel("\u7535\u8BDD \u53F7\u7801 \uFF1A");



	public static void main(String[] args) {
//		new ChuYuanDan("4");
	}

}
