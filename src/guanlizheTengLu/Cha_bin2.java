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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import menzhenDenglu.GuahaoDan;
import pojo.Keshi;
import util.Age;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Cha_bin2 extends JInternalFrame {

	String id = "";

	// private JComponent panel = new JPanel();
	private JTabbedPane tabbedPane1 = new JTabbedPane();

	private JTable table2 = new JTable() {

		public boolean isCellEditable(int row, int column) {
			return false;
		};

	};
	private JScrollPane pane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private JTable table3 = new JTable() {

		public boolean isCellEditable(int row, int column) {
			return false;
		};

	};
	private JScrollPane pane3 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private JTable table4 = new JTable() {

		public boolean isCellEditable(int row, int column) {
			return false;
		};

	};
	private JScrollPane pane4 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private JLabel uidLabel = new JLabel("\u6309\u59D3\u540D\u67E5\u8BE2 : ");
	private JTextField uidField = new JTextField();

	private JLabel uLabel = new JLabel("\u6309\u95E8\u8BCA\u53F7\u67E5\u8BE2 :");
	private JTextField uField = new JTextField();

	private JLabel Label = new JLabel("\u6309\u79D1\u5BA4\u67E5\u8BE2  :");
	private JComboBox<Keshi> bkeshiBox = new JComboBox<Keshi>();

	private JButton chaxunButton = new JButton("查询");
	private JButton chaxunButton2 = new JButton("查询");
	private JButton chaxunButtonk = new JButton("查询");

	private JButton chaxunButton3 = new JButton("查询就诊详情");
	private JButton chaxunButton4 = new JButton("查询就诊详情");
	private JButton chaxunButtonk2 = new JButton("查询就诊详情");
	private final JLabel lblNewLabel = new JLabel("");
	private final JLabel lblNewLabel_1 = new JLabel("");
	private final JLabel lblNewLabel_2 = new JLabel("查询挂号详情");
	private final JButton btnNewButton_3 = new JButton("\u67E5\u8BE2\u6302\u53F7\u8BE6\u60C5");

	public Cha_bin2() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);// 隐藏分容器标题栏
		setBorder(BorderFactory.createEmptyBorder());// 隐藏分容器边框

		setTitle("用户信息录入");
		setSize( 800, 1042);
		getContentPane().setLayout(null);// 设置绝对布局

		// panel.setLayout(null);
		// panel.setBounds(0, 0, 652, 566);
		// getContentPane().add(panel);

		tabbedPane1.setBounds(0, 0,  800, 1042);
		// panel.add(tabbedPane1);
		getContentPane().add(tabbedPane1);

		JPanel panel_1 = new JPanel();
		tabbedPane1.addTab("按姓名查询", null, panel_1, null);

		JPanel panel_2 = new JPanel();
		tabbedPane1.addTab("按门诊号查询", null, panel_2, null);

		JPanel panel_3 = new JPanel();
		tabbedPane1.addTab("按科室查询", null, panel_3, null);

		pane2.setBounds(50, 168, 703, 261);
		pane3.setBounds(50, 168, 703, 261);
		pane4.setBounds(50, 168, 703, 261);
		uidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		uidLabel.setBounds(50, 98, 129, 30);
		uidField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		uidField.setBounds(189, 98, 129, 30);
		uLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		uLabel.setBounds(50, 98, 165, 30);
		uField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		uField.setBounds(225, 98, 129, 30);
		Label.setFont(new Font("微软雅黑", Font.BOLD, 21));

		Label.setBounds(50, 98, 129, 30);
		bkeshiBox.setFont(new Font("微软雅黑", Font.BOLD, 21));
		bkeshiBox.setBounds(220, 98, 105, 30);
		chaxunButton.setBackground(new Color(204, 255, 255));
		chaxunButton.setFont(new Font("微软雅黑", Font.BOLD, 21));

		chaxunButton.setBounds(377, 98, 109, 30);
		chaxunButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		chaxunButton2.setBackground(new Color(204, 255, 255));
		chaxunButton2.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chaxunButton2.setBounds(373, 98, 102, 30);
		chaxunButton2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		chaxunButtonk.setBackground(new Color(204, 255, 255));
		chaxunButtonk.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chaxunButtonk.setBounds(380, 98, 105, 30);
		chaxunButtonk.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		chaxunButton3.setBackground(new Color(224, 255, 255));
		chaxunButton3.setFont(new Font("微软雅黑", Font.BOLD, 21));

		chaxunButton3.setBounds(572, 472, 180, 30);
		chaxunButton3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		chaxunButton4.setBackground(new Color(224, 255, 255));
		chaxunButton4.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chaxunButton4.setBounds(573, 469, 180, 30);
		chaxunButton4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		chaxunButtonk2.setBackground(new Color(224, 255, 255));
		chaxunButtonk2.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chaxunButtonk2.setBounds(573, 474, 180, 30);
		chaxunButtonk2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮

		panel_1.setLayout(null);
		panel_1.add(uidLabel);
		panel_1.add(uidField);
		panel_1.add(chaxunButton);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u6302\u53F7\u8BE6\u60C5");
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		btnNewButton.setBounds(360, 472, 169, 30);
		panel_1.add(btnNewButton);
		panel_1.add(chaxunButton3);

		panel_2.setLayout(null);
		panel_2.add(uLabel);
		panel_2.add(uField);
		panel_2.add(chaxunButton2);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2\u6302\u53F7\u8BE6\u60C5");
		btnNewButton_1.setBackground(new Color(224, 255, 255));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 21));
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		btnNewButton_1.setBounds(362, 469, 165, 30);
		panel_2.add(btnNewButton_1);
		panel_2.add(chaxunButton4);

		panel_3.setLayout(null);
		panel_3.add(Label);
		panel_3.add(bkeshiBox);
		panel_3.add(chaxunButtonk);
		btnNewButton_3.setBackground(new Color(224, 255, 255));
		btnNewButton_3.setFont(new Font("微软雅黑", Font.BOLD, 21));/////////////
		btnNewButton_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		btnNewButton_3.setBounds(348, 474, 171, 30);
		
		panel_3.add(btnNewButton_3);
		panel_3.add(chaxunButtonk2);

		Vector<String> thVector2 = new Vector<String>();
		thVector2.add("门诊号");
		thVector2.add("姓名");
		thVector2.add("性别");
		thVector2.add("年龄");
		thVector2.add("职业");
		thVector2.add("科室");
		thVector2.add("就诊医生");
		final Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();
		
		for (int s2 = 0; s2 < 6; s2++) {
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
		table2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		table2.getTableHeader().setFont(new Font("微软雅黑", 3, 21));
		table2.getTableHeader().setBackground(Color.WHITE);
		pane2.setViewportView(table2);
		panel_1.add(pane2);
		lblNewLabel.setBackground(new Color(204, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\QQ\u622A\u56FE20190819163600.png"));
		lblNewLabel.setBounds(0, 0, 795, 988);
		
		panel_1.add(lblNewLabel);

		//////////////////////////////////////////
		Vector<String> thVector3 = new Vector<String>();
		thVector3.add("门诊号");
		thVector3.add("姓名");
		thVector3.add("性别");
		thVector3.add("年龄");
		thVector3.add("职业");
		thVector3.add("科室");
		thVector3.add("就诊医生");
		final Vector<Vector<String>> dataVector3 = new Vector<Vector<String>>();
		
		for (int x = 0; x < 6; x++) {
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
		panel_2.add(pane3);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\QQ\u622A\u56FE20190819163600.png"));
		lblNewLabel_1.setBounds(0, 0, 795, 988);
		
		panel_2.add(lblNewLabel_1);

		//////////////////////////////////////////
		Vector<String> thVector4 = new Vector<String>();
		thVector4.add("门诊号");
		thVector4.add("姓名");
		thVector4.add("性别");
		thVector4.add("年龄");
		thVector4.add("职业");
		thVector4.add("科室");
		thVector4.add("就诊医生");
		final Vector<Vector<String>> dataVector4 = new Vector<Vector<String>>();
		
		for (int s1 = 0; s1 < 6; s1++) {
			Vector<String> vector4 = new Vector<String>();
			vector4.add("       ");
			vector4.add("       ");
			vector4.add("       ");
			vector4.add("       ");
			vector4.add("       ");
			vector4.add("       ");
			dataVector4.add(vector4);
		}
		
		DefaultTableModel defaultTableModel4 = new DefaultTableModel(dataVector4, thVector4);
		table4.setModel(defaultTableModel4);// 把得到的表模型給表格
		table4.setDefaultRenderer(Object.class, new denglu.Gai_biao());
		table4.setRowHeight(30);
		table4.setFont(new Font("微软雅黑", Font.BOLD, 20));
		table4.getTableHeader().setFont(new Font("微软雅黑", 3, 21));
		table4.getTableHeader().setBackground(Color.WHITE);
		pane4.setViewportView(table4);
		panel_3.add(pane4);
		lblNewLabel_2.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\QQ\u622A\u56FE20190819163600.png"));
		lblNewLabel_2.setBounds(0, -26, 795, 1016);
		
		panel_3.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2");
		btnNewButton_2.setBounds(380, 482, 145, 30);//////////////////////////////////
		panel_3.add(btnNewButton_2);

		//查找科室
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
				bkeshiBox.addItem(keshi);
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

				String name = uidField.getText();

				// 字符串的拼接
				StringBuffer sb = new StringBuffer(
						"select g.binid , g.binName , g.binGender , g.binBirthday , z.zhiyeName , k.keName ,y.yiName from yishenbiao y, guahaobiao g, keshibiao k,zhiyebiao z where  y.yiID=g.binYisheng and k.keID= g.keshiName and z.zhiyeID=g.zhiyeID and 1=1");

				List list = new ArrayList();

				if (name.trim().length() > 0) {
					sb.append(" and binName like ? ");
					// 模糊查询
					list.add("%" + name + "%");
				}

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

		chaxunButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String id = uField.getText();

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

					String sql = "select g.binid , g.binName , g.binGender , g.binBirthday , z.zhiyeName , k.keName ,y.yiName from yishenbiao y, guahaobiao g, keshibiao k,zhiyebiao z where g.binID = ? and y.yiID=g.binYisheng and k.keID= g.keshiName and z.zhiyeID=g.zhiyeID";
					PreparedStatement ps = connection7.prepareStatement(sql);
					ps.setObject(1, id);
					ResultSet rs = ps.executeQuery();

					DefaultTableModel defaultTableModel3 = (DefaultTableModel) table3.getModel();
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
		
		chaxunButtonk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Keshi keshi = (Keshi) bkeshiBox.getSelectedItem();
				int KeshiID = keshi.getkeID();

				// 显示病人表
				Vector<String> thVector4 = new Vector<String>();
				thVector4.add("门诊号");
				thVector4.add("姓名");
				thVector4.add("性别");
				thVector4.add("年龄");
				thVector4.add("职业");
				thVector4.add("科室");
				thVector4.add("就诊医生");
				Vector<Vector<String>> dataVector4 = new Vector<Vector<String>>();

				Connection connection7 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection7 = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root","root");

					String sql = "select g.binid , g.binName , g.binGender , g.binBirthday , z.zhiyeName , k.keName ,y.yiName from yishenbiao y, guahaobiao g, keshibiao k,zhiyebiao z where g.keshiName = ? and y.yiID=g.binYisheng and k.keID= g.keshiName and z.zhiyeID=g.zhiyeID";
					PreparedStatement ps = connection7.prepareStatement(sql);
					ps.setObject(1, KeshiID);
					ResultSet rs = ps.executeQuery();
					
					DefaultTableModel defaultTableModel5 = (DefaultTableModel) table4.getModel();
					defaultTableModel5.getDataVector().clear();////

					while (rs.next()) {
						Vector<String> vector5 = new Vector<String>();
						vector5.add(rs.getString(1));
						vector5.add(rs.getString(2));
						vector5.add(rs.getString(3).equals("1") ? "男" : "女");

						String age = rs.getString(4);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date date = sdf.parse(age);
						Age a = new Age();
						int b = a.getAge(date);
						vector5.add("" + b);

						vector5.add(rs.getString(5));
						vector5.add(rs.getString(6));
						vector5.add(rs.getString(7));

						defaultTableModel5.addRow(vector5);
					}
					defaultTableModel5.fireTableDataChanged();
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

				new Jiuzhen_XiangQing(id);
			}
		});

		chaxunButton4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Jiuzhen_XiangQing(id);
			}
		});
		chaxunButtonk2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Jiuzhen_XiangQing(id);
			}
		});
		
////////////////////////////////////////////////////////////

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new GuahaoDan(id);
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new GuahaoDan(id);
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new GuahaoDan(id);
			}
		});

		
		table2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					int row = table2.getSelectedRow();// 得到表格选中的是哪一行
					id = (String) table2.getValueAt(row, 0);
					
					if (row == -1) {
						JOptionPane.showMessageDialog(null, "请先选中所需药品");
						return;
					}
				}

			}

		});

		table3.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					int row = table3.getSelectedRow();// 得到表格选中的是哪一行
					id = (String) table3.getValueAt(row, 0);
					if (row == -1) {
						JOptionPane.showMessageDialog(null, "请先选中所需药品");
						return;
					}
				}

			}

		});
		
		table4.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					int row = table4.getSelectedRow();// 得到表格选中的是哪一行
					id = (String) table4.getValueAt(row, 0);
					if (row == -1) {
						JOptionPane.showMessageDialog(null, "请先选中所需药品");
						return;
					}
				}

			}

		});
		
		chaxunButtonk2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Jiuzhen_XiangQing(id);
			}
		});


		setVisible(true);
	}

	public static void main(String[] args) {

	}
}
