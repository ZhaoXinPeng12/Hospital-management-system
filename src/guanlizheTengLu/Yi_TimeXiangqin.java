package guanlizheTengLu;

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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import denglu.Gai_biao;
import menzhenDenglu.GuahaoDan;
import menzhenDenglu.GuahaoView;
import util.Age;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

public class Yi_TimeXiangqin extends JDialog {
	String id = "";
	String worktime = "";
	String keshi = "";
	String yiname = "";
	int row = -1;

	private JTable table2 = new JTable() {

		public boolean isCellEditable(int row, int column) {

			return false;
		};
	};
	private JScrollPane pane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private JLabel depnameLabel2 = new JLabel("\u8F93\u5165\u66F4\u6539\u540E\u7684\u65F6\u95F4 \uFF1A");
	private JTextField depnameField2 = new JTextField();

	private JButton genggaiButton = new JButton("\u66F4    \u6539");
	
	private JButton backButton = new JButton("返回继续查询");
	private final JLabel lblNewLabel = new JLabel("");


	public Yi_TimeXiangqin(String yiid) {

		id = yiid;

		setTitle("欢迎使用赛杰高级管理系统");
		setSize(600, 461);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		setModal(true);

		// 设置界面关闭事件
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				int n = JOptionPane.showConfirmDialog(null, "真的要退出嘛?", "退出", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {

					System.exit(0);
				}
			}
		});
		depnameLabel2.setFont(new Font("微软雅黑", Font.BOLD, 21));

		depnameLabel2.setBounds(50, 40, 198, 30);
		depnameField2.setFont(new Font("微软雅黑", Font.BOLD, 21));
		depnameField2.setBounds(258, 40, 131, 30);
		genggaiButton.setFont(new Font("微软雅黑", Font.BOLD, 21));

		genggaiButton.setBounds(429, 40, 121, 30);
		genggaiButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		backButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		
		backButton.setBounds(381, 289, 169, 30);
		backButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮

		pane2.setBounds(50, 100, 500, 146);

		getContentPane().add(depnameLabel2);
		getContentPane().add(depnameField2);

		getContentPane().add(genggaiButton);
		
		getContentPane().add(backButton);

		Vector<String> thVector = new Vector<String>();
		thVector.add("科室");
		thVector.add("医生名字");
		thVector.add("医生编号");
		thVector.add("工作时间");
		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select keshi , yiName,yiiD,worktime from yiworktime where yiiD = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setObject(1, id);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Vector<String> vector = new Vector<String>();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				dataVector.add(vector);

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

		final DefaultTableModel defaultTableModel = new DefaultTableModel(dataVector, thVector);
		table2.setModel(defaultTableModel);// 把得到的表模型給表格
		table2.setDefaultRenderer(Object.class, new Gai_biao());
		table2.setRowHeight(30);
		table2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		table2.getTableHeader().setFont(new Font("微软雅黑", 3, 21));
		table2.getTableHeader().setBackground(Color.WHITE);
		pane2.setViewportView(table2);
		getContentPane().add(pane2);
		lblNewLabel.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\DengLuanniu20190818001542.png"));
		lblNewLabel.setBounds(0, 0, 594, 432);
		
		getContentPane().add(lblNewLabel);

		// 更改
		genggaiButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String worktime2 = depnameField2.getText();

				Connection connection2 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "update yiworktime set worktime =? where worktime=? and keshi = ? and yiName =?";
					PreparedStatement ps = connection2.prepareStatement(sql);
					ps.setObject(1, worktime2);
					ps.setObject(2, worktime);
					ps.setObject(3, keshi);
					ps.setObject(4, yiname);

					int n = ps.executeUpdate();
					if (n > 0) {
						DefaultTableModel defaultTableModel = (DefaultTableModel) table2.getModel();
						defaultTableModel.setValueAt(worktime2, row, 3);
						JOptionPane.showMessageDialog(null, "工作时间更改成功");
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

		table2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					row = table2.getSelectedRow();// 得到表格选中的是哪一行
					keshi = (String) table2.getValueAt(row, 0);
					yiname = (String) table2.getValueAt(row, 1);
					worktime = (String) table2.getValueAt(row, 3);
					depnameField2.setText(worktime);

					if (row == -1) {
						JOptionPane.showMessageDialog(null, "请先选中所查询医生");
						return;
					}
				}

			}

		});
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Yi_TimeXiangqin.this.dispose();
			}
		});


		setVisible(true);
	}

	public static void main(String[] args) {
//		new Yi_TimeXiangqin("1");

	}

}
