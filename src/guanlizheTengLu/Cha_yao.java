package guanlizheTengLu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Cha_yao extends JInternalFrame {

	private JTabbedPane tabbedPane1 = new JTabbedPane();

	private JTable table2 = new JTable() {

		public boolean isCellEditable(int row, int column) {
			return false;
		};

	};
	private JScrollPane pane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private JLabel yaonameLabel = new JLabel("\u6309 \u836F \u540D \u67E5 \u627E :");
	private JTextField yaonameField = new JTextField();
	private JButton chaxunButton = new JButton("查询");
	private JRadioButton w1Button = new JRadioButton("中药类");
	private JRadioButton w2Button = new JRadioButton("感冒类药品");
	private JRadioButton w3Button = new JRadioButton("消化类药品");
	private JRadioButton w4Button = new JRadioButton("心脑血管类");
	private JRadioButton w5Button = new JRadioButton("抗生素类药品");
	private JRadioButton w6Button = new JRadioButton("维生素类药品");
	////////////////////////////////////
	private JTable table2a = new JTable() {

		public boolean isCellEditable(int row, int column) {
			return false;
		};

	};
	private JScrollPane pane2a = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private JLabel yaonameLabela = new JLabel("\u6309 \u836F \u540D \u67E5 \u627E :");
	private JTextField yaonameFielda = new JTextField();
	private JButton chaxunButtona = new JButton("\u5220        \u9664");
	private JRadioButton w1Buttona = new JRadioButton("中药类");
	private JRadioButton w2Buttona = new JRadioButton("感冒类药品");
	private JRadioButton w3Buttona = new JRadioButton("消化类药品");
	private JRadioButton w4Buttona = new JRadioButton("心脑血管类");
	private JRadioButton w5Buttona = new JRadioButton("抗生素类药品");
	private JRadioButton w6Buttona = new JRadioButton("维生素类药品");

	private JLabel lblNewLabel = new JLabel("");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public Cha_yao() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);// 隐藏分容器标题栏
		setBorder(BorderFactory.createEmptyBorder());// 隐藏分容器边框

		setTitle("用户信息录入");
		setSize(800, 1042);
		getContentPane().setLayout(null);// 设置绝对布局

		tabbedPane1.setBounds(0, 0, 800, 1042);
		getContentPane().add(tabbedPane1);

		JPanel panel_2 = new JPanel();
		tabbedPane1.addTab("药品查看", null, panel_2, null);

		JPanel panel_3 = new JPanel();
		tabbedPane1.addTab("药品增加", null, panel_3, null);

		JPanel panel_4 = new JPanel();
		tabbedPane1.addTab("药品删除", null, panel_4, null);

		pane2.setBounds(0, 289, 795, 347);
		yaonameLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		yaonameLabel.setBounds(49, 73, 168, 30);
		yaonameField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		yaonameField.setBounds(298, 73, 196, 30);
		chaxunButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chaxunButton.setBounds(543, 73, 196, 30);
		w1Button.setBackground(new Color(51, 204, 204));
		w1Button.setFont(new Font("微软雅黑", Font.BOLD, 21));

		w1Button.setBounds(49, 224, 196, 30);
		w2Button.setBackground(new Color(51, 204, 204));
		w2Button.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w2Button.setBounds(49, 157, 196, 30);
		w3Button.setBackground(new Color(51, 204, 204));
		w3Button.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w3Button.setBounds(298, 157, 196, 30);
		w4Button.setBackground(new Color(51, 204, 204));
		w4Button.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w4Button.setBounds(543, 157, 196, 30);
		w5Button.setBackground(new Color(51, 204, 204));
		w5Button.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w5Button.setBounds(298, 224, 196, 30);
		w6Button.setBackground(new Color(51, 204, 204));
		w6Button.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w6Button.setBounds(543, 224, 196, 30);
		yaonameLabela.setFont(new Font("微软雅黑", Font.BOLD, 21));

		yaonameLabela.setBounds(49, 73, 168, 30);
		yaonameFielda.setFont(new Font("微软雅黑", Font.BOLD, 21));
		yaonameFielda.setBounds(298, 73, 196, 30);
		chaxunButtona.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chaxunButtona.setBounds(543, 73, 196, 30);
		w1Buttona.setBackground(new Color(51, 204, 204));
		w1Buttona.setFont(new Font("微软雅黑", Font.BOLD, 21));

		w1Buttona.setBounds(49, 224, 196, 30);
		w2Buttona.setBackground(new Color(51, 204, 204));
		w2Buttona.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w2Buttona.setBounds(49, 157, 196, 30);
		w3Buttona.setBackground(new Color(51, 204, 204));
		w3Buttona.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w3Buttona.setBounds(298, 157, 196, 30);
		w4Buttona.setBackground(new Color(51, 204, 204));
		w4Buttona.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w4Buttona.setBounds(543, 157, 196, 30);
		w5Buttona.setBackground(new Color(51, 204, 204));
		w5Buttona.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w5Buttona.setBounds(298, 224, 196, 30);
		w6Buttona.setBackground(new Color(51, 204, 204));
		w6Buttona.setFont(new Font("微软雅黑", Font.BOLD, 21));
		w6Buttona.setBounds(543, 224, 196, 30);

		panel_2.setLayout(null);
		panel_2.add(yaonameLabel);
		panel_2.add(yaonameField);
		panel_2.add(chaxunButton);
		panel_2.add(w1Button);
		panel_2.add(w2Button);
		panel_2.add(w3Button);
		panel_2.add(w4Button);
		panel_2.add(w5Button);
		panel_2.add(w6Button);

		panel_4.setLayout(null);
		panel_4.add(yaonameLabela);
		panel_4.add(yaonameFielda);
		panel_4.add(chaxunButtona);
		panel_4.add(w1Buttona);
		panel_4.add(w2Buttona);
		panel_4.add(w3Buttona);
		panel_4.add(w4Buttona);
		panel_4.add(w5Buttona);
		panel_4.add(w6Buttona);

		panel_3.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		textField.setBounds(455, 104, 171, 30);
		panel_3.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("微软雅黑", Font.BOLD, 21));
		textField_1.setBounds(455, 188, 171, 30);
		panel_3.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("微软雅黑", Font.BOLD, 21));
		textField_2.setBounds(455, 274, 171, 30);
		panel_3.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("\u836F\u54C1 \u6570\u91CF \uFF1A");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.BOLD, 21));
		lblNewLabel_5.setBounds(224, 274, 126, 30);
		panel_3.add(lblNewLabel_5);

		JLabel lblNewLabel_4 = new JLabel("\u836F\u54C1 \u7C7B\u578B \uFF1A");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 21));
		lblNewLabel_4.setBounds(224, 188, 171, 30);
		panel_3.add(lblNewLabel_4);

		JLabel lblNewLabel_3 = new JLabel("\u836F\u54C1 \u540D\u79F0 \uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 21));
		lblNewLabel_3.setBounds(224, 104, 162, 30);
		panel_3.add(lblNewLabel_3);

		JLabel lblNewLabel_6 = new JLabel("\u836F\u54C1 \u4EF7\u683C \uFF1A");
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.BOLD, 21));
		lblNewLabel_6.setBounds(224, 355, 178, 30);
		panel_3.add(lblNewLabel_6);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("微软雅黑", Font.BOLD, 21));
		textField_3.setBounds(455, 363, 171, 30);
		panel_3.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("\u5305\u88C5 \u7C7B\u578B \uFF1A");
		lblNewLabel_7.setFont(new Font("微软雅黑", Font.BOLD, 21));
		lblNewLabel_7.setBounds(224, 447, 196, 30);
		panel_3.add(lblNewLabel_7);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("微软雅黑", Font.BOLD, 21));
		textField_4.setBounds(455, 447, 171, 30);
		panel_3.add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("\u786E\u8BA4 \u6DFB\u52A0");
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		btnNewButton.setBounds(455, 536, 171, 30);
		panel_3.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 21));
		lblNewLabel_1
				.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\QQ\u622A\u56FE20190819163600.png"));
		lblNewLabel_1.setBounds(0, 0, 795, 990);
		panel_3.add(lblNewLabel_1);

		panel_4.setLayout(null);
		pane2a.setBounds(0, 289, 795, 347);
		///////////////////////////////////////////////////////
		pane2a.setBounds(0, 289, 795, 347);
		table2a.setDefaultRenderer(Object.class, new denglu.Gai_biao());
		table2a.setRowHeight(30);
		table2a.setFont(new Font("微软雅黑", Font.BOLD, 20));
		table2a.getTableHeader().setFont(new Font("微软雅黑", 3, 21));
		table2a.getTableHeader().setBackground(Color.WHITE);
		pane2a.setViewportView(table2a);
		panel_4.add(pane2a);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2
				.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\QQ\u622A\u56FE20190819163600.png"));
		lblNewLabel_2.setBounds(0, 0, 795, 992);
		panel_4.add(lblNewLabel_2);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String a = textField.getText();
				String b = textField_1.getText();
				String c = textField_2.getText();
				String d = textField_3.getText();
				String f = textField_4.getText();

				Connection connection7 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root",
							"root");

					// String sql = "select yaoBianhao , yaoName , yaoJiage ,
					// yaoLeixing , leixing , yaoShuliang from yaopinbiao";
					String sql = "insert into yaopinbiao(yaoName,yaoLeixing,yaoShuliang,yaoJiage,leixing) values(?,?,?,?,?)";
					PreparedStatement ps = connection7.prepareStatement(sql);
					// ps.setObject(1, binid);
					ps.setObject(1, a);
					ps.setObject(2, b);
					ps.setObject(3, c);
					ps.setObject(4, d);
					ps.setObject(5, f);

					int n = ps.executeUpdate();

					if (n > 0) {
						JOptionPane.showMessageDialog(null, "药品添加成功");
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

			}
		});

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
		panel_2.add(pane2);

		///////
		// 显示药品表
		Vector<String> thVector2a = new Vector<String>();
		thVector2a.add("药品序号");
		thVector2a.add("药品名称");
		thVector2a.add("药品价格");
		thVector2a.add("药品类型");
		thVector2a.add("包装方式");
		thVector2a.add("库存数量");
		final Vector<Vector<String>> dataVector2a = new Vector<Vector<String>>();
		Connection connection7a = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection7a = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root",
					"root");

			String sql = "select yaoBianhao , yaoName , yaoJiage , yaoLeixing , leixing , yaoShuliang from yaopinbiao";
			PreparedStatement ps = connection7a.prepareStatement(sql);
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
				connection7a.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		DefaultTableModel defaultTableModel2a = new DefaultTableModel(dataVector2a, thVector2a);

		lblNewLabel
				.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\QQ\u622A\u56FE20190819163600.png"));
		lblNewLabel.setBounds(0, 0, 795, 992);
		panel_2.add(lblNewLabel);

		chaxunButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String name = yaonameField.getText();

				// 字符串的拼接
				StringBuffer sb = new StringBuffer(
						"select yaoBianhao , yaoName , yaoJiage , yaoLeixing , leixing , yaoShuliang from yaopinbiao where 1=1 ");
				List list = new ArrayList();

				if (name.trim().length() > 0) {
					sb.append(" and yaoName like ? ");
					// 模糊查询
					list.add("%" + name + "%");
				}

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

					PreparedStatement ps = connection7.prepareStatement(sb.toString());
					ps.setObject(1, name);

					for (int i = 0; i < list.size(); i++) {
						ps.setObject(i + 1, list.get(i));
					}

					ResultSet rs = ps.executeQuery();

					DefaultTableModel defaultTableModel2 = (DefaultTableModel) table2.getModel();
					defaultTableModel2.getDataVector().clear();////

					while (rs.next()) {
						Vector<String> vector2 = new Vector<String>();
						vector2.add(rs.getString(1));
						vector2.add(rs.getString(2));
						vector2.add(rs.getString(3));
						vector2.add(rs.getString(4));
						vector2.add(rs.getString(5));
						vector2.add(rs.getString(6));
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
		
		chaxunButtona.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String name = yaonameField.getText();

				// 字符串的拼接
				StringBuffer sb = new StringBuffer(
						"select yaoBianhao , yaoName , yaoJiage , yaoLeixing , leixing , yaoShuliang from yaopinbiao where 1=1 ");
				List list = new ArrayList();

				if (name.trim().length() > 0) {
					sb.append(" and yaoName like ? ");
					// 模糊查询
					list.add("%" + name + "%");
				}

				// 显示药品表
				Vector<String> thVector2a = new Vector<String>();
				thVector2a.add("药品序号");
				thVector2a.add("药品名称");
				thVector2a.add("药品价格");
				thVector2a.add("药品类型");
				thVector2a.add("包装方式");
				thVector2a.add("库存数量");
				final Vector<Vector<String>> dataVector2a = new Vector<Vector<String>>();

				Connection connection7 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root",
							"root");

					PreparedStatement ps = connection7.prepareStatement(sb.toString());
					ps.setObject(1, name);

					for (int i = 0; i < list.size(); i++) {
						ps.setObject(i + 1, list.get(i));
					}

					ResultSet rs = ps.executeQuery();

					DefaultTableModel defaultTableModel2a = (DefaultTableModel) table2a.getModel();
					defaultTableModel2a.getDataVector().clear();////

					while (rs.next()) {
						Vector<String> vector2a = new Vector<String>();
						vector2a.add(rs.getString(1));
						vector2a.add(rs.getString(2));
						vector2a.add(rs.getString(3));
						vector2a.add(rs.getString(4));
						vector2a.add(rs.getString(5));
						vector2a.add(rs.getString(6));
						defaultTableModel2a.addRow(vector2a);
					}
					defaultTableModel2a.fireTableDataChanged();

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
		
		w1Buttona.addActionListener(new ActionListener() {

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
				table2a.setModel(defaultTableModel2);// 把得到的表模型給表格
				table2a.setDefaultRenderer(Object.class, new denglu.Gai_biao());
				table2a.setRowHeight(30);
				pane2a.setViewportView(table2a);
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
		
		w2Buttona.addActionListener(new ActionListener() {

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
				table2a.setModel(defaultTableModel2);// 把得到的表模型給表格
				table2a.setDefaultRenderer(Object.class, new denglu.Gai_biao());
				table2a.setRowHeight(30);
				pane2a.setViewportView(table2a);
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
		
		w3Buttona.addActionListener(new ActionListener() {

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
				table2a.setModel(defaultTableModel2);// 把得到的表模型給表格
				table2a.setDefaultRenderer(Object.class, new denglu.Gai_biao());
				table2a.setRowHeight(30);
				pane2a.setViewportView(table2a);
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
		
		w4Buttona.addActionListener(new ActionListener() {

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
				table2a.setModel(defaultTableModel2);// 把得到的表模型給表格
				table2a.setDefaultRenderer(Object.class, new denglu.Gai_biao());
				table2a.setRowHeight(30);
				pane2a.setViewportView(table2a);
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
		
		w5Buttona.addActionListener(new ActionListener() {

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
				table2a.setModel(defaultTableModel2);// 把得到的表模型給表格
				table2a.setDefaultRenderer(Object.class, new denglu.Gai_biao());
				table2a.setRowHeight(30);
				pane2a.setViewportView(table2a);
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
		
		w6Buttona.addActionListener(new ActionListener() {

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
				table2a.setModel(defaultTableModel2);// 把得到的表模型給表格
				table2a.setDefaultRenderer(Object.class, new denglu.Gai_biao());
				table2a.setRowHeight(30);
				pane2a.setViewportView(table2a);
			}
		});


		setVisible(true);
	}

	public static void main(String[] args) {

	}
}
