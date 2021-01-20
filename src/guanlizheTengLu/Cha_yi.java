package guanlizheTengLu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import denglu.Gai_biao;
import pojo.Keshi;
import util.Age;
import util.Chooser;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Cha_yi extends JInternalFrame {

	String id = "";

	private JTabbedPane tabbedPane1 = new JTabbedPane();

	private JTable table2 = new JTable() {

		public boolean isCellEditable(int row, int column) {
			return false;
		};

	};
	private JScrollPane pane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private JLabel uidLabel = new JLabel("\u6309\u533B\u751F\u59D3\u540D\u67E5\u8BE2 \uFF1A");
	private JTextField uidField = new JTextField();

	private JLabel uLabel = new JLabel("\u6309\u533B\u751F\u79D1\u5BA4\u67E5\u8BE2 \uFF1A");
	private JComboBox<Keshi> keshiBox = new JComboBox<Keshi>();

	private JButton chaxunButton = new JButton("\u67E5      \u8BE2");
	private JButton chaxunButton3 = new JButton("\u67E5      \u8BE2");

	private JButton chaxunButton2 = new JButton("管理工作时间");
	//////////////////////////////////////////////////////////////////
	String ida = "";

	private JTabbedPane tabbedPane1a = new JTabbedPane();

	private JTable table2a = new JTable() {

		public boolean isCellEditable(int row, int column) {
			return false;
		};

	};
	private JScrollPane pane2a = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private JLabel uidLabela = new JLabel("\u6309\u533B\u751F\u59D3\u540D\u67E5\u8BE2 :");
	private JTextField uidFielda = new JTextField();

	private JLabel uLabela = new JLabel("\u6309\u533B\u751F\u79D1\u5BA4\u67E5\u8BE2 :");
	private JComboBox<Keshi> keshiBoxa = new JComboBox<Keshi>();

	private JButton chaxunButtona = new JButton("\u67E5      \u8BE2");
	private JButton chaxunButton3a = new JButton("\u67E5      \u8BE2");

	private JButton chaxunButton2a = new JButton("修改医生信息");
	
	////////////////////////////////////////////////////////////

	private JLabel yinameLabel = new JLabel("\u533B\u751F \u59D3\u540D \uFF1A");
	private JTextPane yinameField = new JTextPane();

	private JLabel genderLabel = new JLabel("\u6027        \u522B \uFF1A");
	private JRadioButton maleButton = new JRadioButton("男");
	private JRadioButton femaleButton = new JRadioButton("女");

	private JLabel ageLabel = new JLabel("\u51FA\u751F \u65E5\u671F :");
	private JTextPane ageField = new JTextPane();

	private JLabel keshiLabel = new JLabel("\u79D1        \u5BA4 \uFF1A");
	private JComboBox<Keshi> keshiBox3 = new JComboBox<Keshi>();

	private JLabel telLabel = new JLabel("\u7535\u8BDD \u53F7\u7801 \uFF1A");
	private JTextPane telField = new JTextPane();
	private JLabel checkLabel = new JLabel();

	private JLabel workLabel = new JLabel("\u804C        \u4F4D \uFF1A");
	private JRadioButton w1Button = new JRadioButton("主任医师");
	private JRadioButton w2Button = new JRadioButton("副主任医师");

	private JLabel moneyLabel = new JLabel("\u85AA        \u6C34 \uFF1A");
	private JTextPane moneyField = new JTextPane();

	private JLabel money2Label = new JLabel("\u6302   \u53F7   \u8D39\uFF1A");
	private JTextPane money2Field = new JTextPane();
	
	private JLabel mimaLabel = new JLabel("\u767B\u5165 \u5BC6\u7801 \uFF1A");
	private JTextPane mimaField = new JTextPane();
	private JButton mimaButton = new JButton("\u586B\u5165\u9ED8\u8BA4\u5BC6\u7801");
	
	private JButton tianjiaButton= new JButton("\u786E\u8BA4    \u65B0\u589E");
	private final JLabel lblNewLabel = new JLabel("");
	private final JLabel lblNewLabel_1 = new JLabel("");
	private final JLabel lblNewLabel_2 = new JLabel("");


	public Cha_yi() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);// 隐藏分容器标题栏
		setBorder(BorderFactory.createEmptyBorder());// 隐藏分容器边框

		setTitle("欢迎进入医生管理界面");
		setSize(800, 1042);
		getContentPane().setLayout(null);// 设置绝对布局

		tabbedPane1.setBounds(0, 0,800, 1042);
		getContentPane().add(tabbedPane1);

		JPanel panel_1 = new JPanel();
		tabbedPane1.addTab("管理医生工作时间", null, panel_1, null);

		JPanel panel_2 = new JPanel();
		tabbedPane1.addTab("管理医生基本信息", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane1.addTab("新增医生员工信息", null, panel_3, null);

		pane2.setBounds(45, 194, 705, 163);
		uidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		uidLabel.setBounds(45, 138, 182, 30);
		uidField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		uidField.setBounds(237, 138, 134, 30);
		uLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		uLabel.setBounds(45, 87, 182, 30);
		keshiBox.setFont(new Font("微软雅黑", Font.BOLD, 21));
		keshiBox.setBounds(237, 87, 134, 30);
		chaxunButton.setFont(new Font("微软雅黑", Font.BOLD, 21));

		chaxunButton.setBounds(420, 87, 125, 30);
		chaxunButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		chaxunButton3.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chaxunButton3.setBounds(420, 138, 125, 30);
		chaxunButton3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		chaxunButton2.setFont(new Font("微软雅黑", Font.BOLD, 21));

		chaxunButton2.setBounds(587, 383, 163, 30);
		chaxunButton3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		///////////////////////////////////////////////////////
		pane2a.setBounds(45, 206, 704, 138);
		uidLabela.setFont(new Font("微软雅黑", Font.BOLD, 21));

		uidLabela.setBounds(45, 148, 182, 30);
		uidFielda.setFont(new Font("微软雅黑", Font.BOLD, 21));
		uidFielda.setBounds(237, 148, 135, 30);
		uLabela.setFont(new Font("微软雅黑", Font.BOLD, 21));

		uLabela.setBounds(45, 96, 182, 30);
		keshiBoxa.setFont(new Font("微软雅黑", Font.BOLD, 21));
		keshiBoxa.setBounds(237, 96, 135, 30);
		chaxunButtona.setFont(new Font("微软雅黑", Font.BOLD, 21));

		chaxunButtona.setBounds(419, 96, 140, 30);
		chaxunButtona.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		chaxunButton3a.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chaxunButton3a.setBounds(419, 148, 140, 30);
		chaxunButton3a.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		chaxunButton2a.setFont(new Font("微软雅黑", Font.BOLD, 21));

		chaxunButton2a.setBounds(590, 379, 159, 30);
		chaxunButton2a.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		yinameLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));
		
		///////////////////////////////////////////////////////////

		yinameLabel.setBounds(210, 70, 142, 30);
		yinameField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		yinameField.setBounds(420, 70, 196, 30);
		genderLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		genderLabel.setBounds(210, 140, 142, 30);
		maleButton.setBackground(new Color(102, 204, 204));
		maleButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		maleButton.setBounds(420, 140, 60, 30);
		maleButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		femaleButton.setBackground(new Color(102, 204, 204));
		femaleButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		femaleButton.setBounds(556, 140, 60, 30);
		femaleButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		maleButton.setSelected(true);
		ButtonGroup buttonGroup = new ButtonGroup();// 分类，替进层次感
		buttonGroup.add(maleButton);
		buttonGroup.add(femaleButton);
		ageLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		ageLabel.setBounds(210, 210, 168, 30);
		ageField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		ageField.setBounds(420, 210, 196, 30);
		keshiLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		keshiLabel.setBounds(210, 280, 182, 30);
		keshiBox3.setFont(new Font("微软雅黑", Font.BOLD, 21));
		keshiBox3.setBounds(420, 280, 196, 30);
		telLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		telLabel.setBounds(210, 350, 196, 30);
		telField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		telField.setBounds(420, 350, 196, 30);
		checkLabel.setBounds(290, 350, 100, 30);
		workLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		workLabel.setBounds(210, 560, 142, 30);
		w1Button.setBackground(new Color(102, 204, 204));
		w1Button.setFont(new Font("微软雅黑", Font.BOLD, 16));
		w1Button.setBounds(527, 563, 89, 30);
		w2Button.setBackground(new Color(102, 204, 204));
		w2Button.setFont(new Font("微软雅黑", Font.BOLD, 16));
		w2Button.setBounds(420, 563, 105, 30);
		maleButton.setSelected(true);
		moneyLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		moneyLabel.setBounds(210, 490, 182, 30);
		moneyField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		moneyField.setBounds(420, 490, 196, 30);
		money2Label.setFont(new Font("微软雅黑", Font.BOLD, 21));

		money2Label.setBounds(210, 420, 150, 30);
		money2Field.setFont(new Font("微软雅黑", Font.BOLD, 21));
		money2Field.setBounds(420, 420, 196, 30);
		mimaLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));
		
		mimaLabel.setBounds(210, 630, 172, 30);
		mimaField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		mimaField.setBounds(420, 630, 196, 30);
		mimaButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		mimaButton .setBounds(420, 700, 196, 30);
		mimaButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		tianjiaButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		
		tianjiaButton.setBounds(420, 768, 196, 30);
		tianjiaButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮

		panel_1.setLayout(null);
		panel_1.add(uidLabel);
		panel_1.add(uidField);
		panel_1.add(keshiBox);
		panel_1.add(uLabel);
		panel_1.add(chaxunButton);
		panel_1.add(chaxunButton3);
		panel_1.add(chaxunButton2);

		panel_2.setLayout(null);
		panel_2.add(uidLabela);
		panel_2.add(uidFielda);
		panel_2.add(keshiBoxa);
		panel_2.add(uLabela);
		panel_2.add(chaxunButtona);
		panel_2.add(chaxunButton3a);
		panel_2.add(chaxunButton2a);
		
		panel_3.setLayout(null);
		panel_3.add(yinameLabel);
		panel_3.add(yinameField);
		panel_3.add(genderLabel);
		panel_3.add(maleButton);
		panel_3.add(femaleButton);
		
		Chooser chooser = Chooser.getInstance();
		chooser.register(ageField);
		panel_3.add(ageLabel);
		panel_3.add(ageField);
		
		panel_3.add(keshiLabel);
		panel_3.add(keshiBox3);
		panel_3.add(telLabel);
		panel_3.add(telField);
		panel_3.add(checkLabel);
		panel_3.add(workLabel);
		panel_3.add(w1Button);
		panel_3.add(w2Button);
		panel_3.add(moneyLabel);
		panel_3.add(moneyField);
		panel_3.add(money2Label);
		panel_3.add(money2Field);
		panel_3.add(mimaLabel);
		panel_3.add(mimaField);
		panel_3.add(mimaButton);
		panel_3.add(tianjiaButton);
		lblNewLabel_2.setBackground(new Color(102, 204, 204));
		lblNewLabel_2.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\QQ\u622A\u56FE20190819163600.png"));
		lblNewLabel_2.setBounds(0, 0, 795, 988);
		
		panel_3.add(lblNewLabel_2);
		

		Vector<String> thVector2 = new Vector<String>();
		thVector2.add("医生编号");
		thVector2.add("姓名");
		thVector2.add("性别");
		thVector2.add("年龄");
		thVector2.add("职位");
		thVector2.add("科室");
		thVector2.add("薪水");
		final Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();
		
		for (int s = 0; s < 6; s++) {
			Vector<String> vector2 = new Vector<String>();
			vector2.add("       ");
			vector2.add("       ");
			vector2.add("       ");
			vector2.add("       ");
			vector2.add("       ");
			vector2.add("       ");

			dataVector2.add(vector2);
		}
		
		DefaultTableModel defaultTableModel2 = new DefaultTableModel(dataVector2, thVector2);
		table2.setModel(defaultTableModel2);// 把得到的表模型給表格
		table2.setDefaultRenderer(Object.class, new denglu.Gai_biao());
		table2.setRowHeight(30);
		table2.setFont(new Font("Menu.font", Font.BOLD, 20));
		pane2.setViewportView(table2);
		panel_1.add(pane2);
		lblNewLabel.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\QQ\u622A\u56FE20190819163600.png"));
		lblNewLabel.setBounds(0, 0, 795, 988);
		
		panel_1.add(lblNewLabel);
		
		///////////////////////////////////////
		Vector<String> thVector3 = new Vector<String>();
		thVector3.add("医生编号");
		thVector3.add("姓名");
		thVector3.add("性别");
		thVector3.add("年龄");
		thVector3.add("职位");
		thVector3.add("科室");
		thVector3.add("薪水");
		final Vector<Vector<String>> dataVector3 = new Vector<Vector<String>>();
		
		for (int s1 = 0; s1 < 6; s1++) {
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
		table2a.setModel(defaultTableModel3);// 把得到的表模型給表格
		table2a.setDefaultRenderer(Object.class, new Gai_biao());
		table2a.setRowHeight(30);
		table2a.setFont(new Font("微软雅黑", Font.BOLD, 20));
		table2a.getTableHeader().setFont(new Font("微软雅黑", 3, 21));
		table2a.getTableHeader().setBackground(Color.WHITE);
		table2a.setFont(new Font("Menu.font", Font.BOLD, 20));
		pane2a.setViewportView(table2a);
		panel_2.add(pane2a);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\QQ\u622A\u56FE20190819163600.png"));
		lblNewLabel_1.setBounds(0, 0, 795, 986);
		
		panel_2.add(lblNewLabel_1);


		
		// 查找科室
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");
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
				keshiBox.addItem(keshi);
				keshiBoxa.addItem(keshi);
				keshiBox3.addItem(keshi);
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

		chaxunButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Keshi keshi = (Keshi) keshiBox.getSelectedItem();
				String Keshiname = keshi.getkeName();

				// 显示病人表
				Vector<String> thVector2 = new Vector<String>();
				thVector2.add("医生编号");
				thVector2.add("姓名");
				thVector2.add("性别");
				thVector2.add("年龄");
				thVector2.add("职位");
				thVector2.add("科室");
				thVector2.add("薪水");
				Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();

				Connection connection7 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root",
							"root");

					String sql = "select yiID,yiName,yiGender,yiBirthday,yiZhiwei,keshiName,Salary from yishenbiao  where keshiName = ? ";
					PreparedStatement ps = connection7.prepareStatement(sql);
					ps.setObject(1, Keshiname);
					ResultSet rs = ps.executeQuery();

					DefaultTableModel defaultTableModel2 = (DefaultTableModel) table2.getModel();
					defaultTableModel2.getDataVector().clear();////

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

						defaultTableModel2.addRow(vector2);
					}
					defaultTableModel2.fireTableDataChanged();
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						connection7.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
//		//////////////////////////////////////////////
		chaxunButtona.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Keshi keshi = (Keshi) keshiBoxa.getSelectedItem();
				String Keshiname = keshi.getkeName();

				// 显示病人表
				Vector<String> thVector3 = new Vector<String>();
				thVector3.add("医生编号");
				thVector3.add("姓名");
				thVector3.add("性别");
				thVector3.add("年龄");
				thVector3.add("职位");
				thVector3.add("科室");
				thVector3.add("薪水");
				Vector<Vector<String>> dataVector3 = new Vector<Vector<String>>();

				Connection connection7 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root",
							"root");

					String sql = "select yiID,yiName,yiGender,yiBirthday,yiZhiwei,keshiName,Salary from yishenbiao  where keshiName = ? ";
					PreparedStatement ps = connection7.prepareStatement(sql);
					ps.setObject(1, Keshiname);
					ResultSet rs = ps.executeQuery();

					DefaultTableModel defaultTableModel3 = (DefaultTableModel) table2a.getModel();
					defaultTableModel3.getDataVector().clear();////

					while (rs.next()) {
						Vector<String> vector3 = new Vector<String>();
						vector3.add(rs.getString(1));
						vector3.add(rs.getString(2));
						vector3.add(rs.getString(3).equals("1") ? "男" : "女");

						String age = rs.getString(4);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date date = sdf.parse(age);
						Age a = new Age();
						int b = a.getAge(date);
						vector3.add("" + b);

						vector3.add(rs.getString(5));
						vector3.add(rs.getString(6));
						vector3.add(rs.getString(7));

						defaultTableModel3.addRow(vector3);
					}
					defaultTableModel3.fireTableDataChanged();
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						connection7.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		chaxunButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String name = uidField.getText();

				// 显示病人表
				Vector<String> thVector2 = new Vector<String>();
				thVector2.add("医生编号");
				thVector2.add("姓名");
				thVector2.add("性别");
				thVector2.add("年龄");
				thVector2.add("职位");
				thVector2.add("科室");
				thVector2.add("薪水");
				Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();

				Connection connection7 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root",
							"root");

					String sql = "select yiID,yiName,yiGender,yiBirthday,yiZhiwei,keshiName,Salary from yishenbiao  where yiName = ? ";
					PreparedStatement ps = connection7.prepareStatement(sql);
					ps.setObject(1, name);
					ResultSet rs = ps.executeQuery();

					DefaultTableModel defaultTableModel2 = (DefaultTableModel) table2.getModel();
					defaultTableModel2.getDataVector().clear();////

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

						defaultTableModel2.addRow(vector2);
					}
					defaultTableModel2.fireTableDataChanged();
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						connection7.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		
//		///////////////////////////////////////////
		chaxunButton3a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String name = uidFielda.getText();

				// 显示病人表
				Vector<String> thVector3 = new Vector<String>();
				thVector3.add("医生编号");
				thVector3.add("姓名");
				thVector3.add("性别");
				thVector3.add("年龄");
				thVector3.add("职位");
				thVector3.add("科室");
				thVector3.add("薪水");
				Vector<Vector<String>> dataVector3 = new Vector<Vector<String>>();

				Connection connection7 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root",
							"root");

					String sql = "select yiID,yiName,yiGender,yiBirthday,yiZhiwei,keshiName,Salary from yishenbiao  where yiName = ? ";
					PreparedStatement ps = connection7.prepareStatement(sql);
					ps.setObject(1, name);
					ResultSet rs = ps.executeQuery();

					DefaultTableModel defaultTableModel3 = (DefaultTableModel) table2a.getModel();
					defaultTableModel3.getDataVector().clear();////

					while (rs.next()) {
						Vector<String> vector3 = new Vector<String>();
						vector3.add(rs.getString(1));
						vector3.add(rs.getString(2));
						vector3.add(rs.getString(3).equals("1") ? "男" : "女");

						String age = rs.getString(4);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date date = sdf.parse(age);
						Age a = new Age();
						int b = a.getAge(date);
						vector3.add("" + b);

						vector3.add(rs.getString(5));
						vector3.add(rs.getString(6));
						vector3.add(rs.getString(7));

						defaultTableModel3.addRow(vector3);
					}
					defaultTableModel3.fireTableDataChanged();
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						connection7.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		
		telField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				String regex = "^(((13|18)[0-9]{9})|(15[012356789][0-9]{8})|((147|170|171|173|175|176|177|178)[0-9]{8}))$";
				String i = telField.getText();
				if ( (i.matches(regex))) {
					checkLabel.setText("格式正确");
				} else {
					checkLabel.setText("格式正确 ");
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		mimaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				mimaField.setText("sunjob");
			}
		});


		chaxunButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Yi_TimeXiangqin(id);
			}
		});
		
		chaxunButton2a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Yi_xinxi_xianqin(ida);
			}
		});
		
		tianjiaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		table2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					int row = table2.getSelectedRow();// 得到表格选中的是哪一行
					id = (String) table2.getValueAt(row, 0);
					if (row == -1) {
						JOptionPane.showMessageDialog(null, "请先选中所查询医生");
						return;
					}
				}

			}

		});
		
		table2a.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					int row = table2a.getSelectedRow();// 得到表格选中的是哪一行
					ida = (String) table2a.getValueAt(row, 0);
					if (row == -1) {
						JOptionPane.showMessageDialog(null, "请先选中所查询医生");
						return;
					}
				}

			}

		});

	}

	public static void main(String[] args) {

	}

}
