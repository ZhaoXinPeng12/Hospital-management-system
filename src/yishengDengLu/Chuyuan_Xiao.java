package yishengDengLu;

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
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import pojo.Keshi;

import javax.swing.JDialog;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

public class Chuyuan_Xiao extends JInternalFrame {

	int row = -1;
	
	String yid = "";
	String binid = "";

	private JTabbedPane tabbedPane1 = new JTabbedPane();

	// 床位表
	private JTable table2 = new JTable() {

		public boolean isCellEditable(int row, int column) {

			return false;
		};

	};
	private JScrollPane pane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	// VERTICAL_SCROLLBAR_AS_NEEDED;VERTICAL_SCROLLBAR_NEVER;

	private JLabel bkeshiidLabel = new JLabel("\u79D1        \u5BA4 \uFF1A");
	private JComboBox<Keshi> bkeshiBox = new JComboBox<Keshi>();

	private JLabel houseLabel = new JLabel("\u75C5  \u623F  \u53F7 \uFF1A");
	private JTextField houseidField = new JTextField();
	private JLabel binnameLabel = new JLabel("\u51FA\u9662 \u60A3\u8005 :");
	private JTextField binnameField = new JTextField();

	private JButton sureButton = new JButton("\u6253\u5370\u51FA\u9662\u5355");
	private final JLabel lblNewLabel = new JLabel("");

	public Chuyuan_Xiao(String yiid) {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);// 隐藏分容器标题栏
		setBorder(BorderFactory.createEmptyBorder());// 隐藏分容器边框

		yid = yiid;
		setTitle("欢迎使用医院高级管理系统");
		setSize(800, 1042);
		getContentPane().setLayout(null);// 设置绝对布局

		tabbedPane1.setBounds(0, 0, 800, 1042);
		getContentPane().add(tabbedPane1);

		JPanel panel_1 = new JPanel();
		tabbedPane1.addTab("出院管理", null, panel_1, null);
		bkeshiidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		bkeshiidLabel.setBounds(51, 113, 153, 30);

		pane2.setBounds(51, 159, 698, 190);
		bkeshiBox.setFont(new Font("微软雅黑", Font.BOLD, 21));
		bkeshiBox.setBounds(218, 113, 131, 30);
		houseLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		houseLabel.setBounds(58, 387, 146, 30);
		houseidField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		houseidField.setBounds(218, 387, 131, 30);
		binnameLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));
		binnameLabel.setBounds(58, 445, 114, 30);
		binnameField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		binnameField.setBounds(218, 445, 131, 30);
		sureButton.setFont(new Font("微软雅黑", Font.BOLD, 21));

		sureButton.setBounds(422, 113, 167, 30);

		panel_1.setLayout(null);
		panel_1.add(bkeshiidLabel);
		panel_1.add(bkeshiBox);

		panel_1.add(houseidField);
		panel_1.add(houseLabel);
		panel_1.add(binnameField);
		panel_1.add(binnameLabel);

		panel_1.add(sureButton);

		Vector<String> thVector2 = new Vector<String>();
		thVector2.add("病房序号");
		thVector2.add("病房状况");
		thVector2.add("门诊号");
		thVector2.add("科室");
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
		table2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		table2.getTableHeader().setFont(new Font("微软雅黑", 3, 21));
		table2.getTableHeader().setBackground(Color.WHITE);
		pane2.setViewportView(table2);
		panel_1.add(pane2);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 21));
		lblNewLabel.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\RuYuan20190819110109.png"));
		lblNewLabel.setBounds(0, 0, 795, 986);

		panel_1.add(lblNewLabel);

		// 查找科室
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select keID , keName from keshibiao";
			PreparedStatement ps = connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

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

		bkeshiBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String keshiname = ((Keshi) bkeshiBox.getSelectedItem()).getkeName();

				// 显示病房表
				Vector<String> thVector2 = new Vector<String>();
				thVector2.add("病房序号");
				thVector2.add("病房状况");
				thVector2.add("门诊号");
				thVector2.add("科室");
				Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();

				Connection connection = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "select houNum , binName,binID from house where keshiName = ?";
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setObject(1, keshiname);
					ResultSet rs = ps.executeQuery();

					DefaultTableModel defaultTableModel2 = (DefaultTableModel) table2.getModel();
					defaultTableModel2.getDataVector().clear();////

					while (rs.next()) {
						Vector<String> vector2 = new Vector<String>();
						vector2.add(rs.getString(1));
						if (rs.getString(2) == null) {
							vector2.add("空床位");
						} else {
							vector2.add(rs.getString(2));
						}

						if (rs.getString(3) == null) {
							vector2.add("空");
						} else {
							vector2.add(rs.getString(3));
						}
						vector2.add(keshiname);
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
			}

		});

		sureButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Keshi bin = (Keshi) bkeshiBox.getSelectedItem();
				int keshiid = bin.getkeID();

				String houseid = houseidField.getText();
				String binname = binnameField.getText();
				String id = binid;

				Connection connection = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "update house set binName = ?,binID = ? where houNum= ? and keshiID = ?";
					String sql2 = "insert into chuyuanbiao(binID,binHouse,Yes_No) values(?,?,?)";
					PreparedStatement ps = connection.prepareStatement(sql);
					PreparedStatement ps2 = connection.prepareStatement(sql2);
					ps.setObject(1, null);
					ps.setObject(2, null);
					ps.setObject(3, houseid);
					ps.setObject(4, keshiid);

					ps2.setObject(1, id);
					ps2.setObject(2, houseid);
					ps2.setObject(3, "1");

					int n = ps.executeUpdate();// 真正去执行sql语句
					int n2 = ps2.executeUpdate();// 真正去执行sql语句
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "出院成功");
						// 关闭界面
						// new Chuyuan_Xiao(yid);
						DefaultTableModel defaultTableModel2 = (DefaultTableModel) table2.getModel();
						defaultTableModel2.setValueAt(binname, row, 1);
						defaultTableModel2.setValueAt(binid, row, 0);
						
						new ChuYuanDan(binid);

					} else {
						JOptionPane.showMessageDialog(null, "出院失败");
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
			}
		});

		table2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					row = table2.getSelectedRow();// 得到表格选中的是哪一行
					// System.out.println(row);
					if (row == -1) {
						JOptionPane.showMessageDialog(null, "请选中先");
						return;
					}
					String houseid = (String) table2.getValueAt(row, 0);
					String binname = (String) table2.getValueAt(row, 1);
					binid = (String) table2.getValueAt(row, 2);

					houseidField.setText(houseid);
					binnameField.setText(binname);

				}
			}

		});

		setVisible(true);
	}

	public static void main(String[] args) {

		new Chuyuan_Xiao("1");
	}

}
