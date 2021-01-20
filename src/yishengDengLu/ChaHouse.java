package yishengDengLu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import pojo.Keshi;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ChaHouse extends JDialog {

	String yid = "";

	// 表1
	private JTable table2 = new JTable() {

		public boolean isCellEditable(int row, int column) {

			return false;
		};

	};
	private JScrollPane pane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	// VERTICAL_SCROLLBAR_AS_NEEDED;VERTICAL_SCROLLBAR_NEVER;

	private JLabel bkeshiidLabel = new JLabel("\u79D1        \u5BA4 :");
	private JComboBox<Keshi> bkeshiBox = new JComboBox<Keshi>();

	private JButton cha1Button = new JButton("\u67E5      \u8BE2");
	private JButton backButton = new JButton("返回上一级");
	private final JLabel lblNewLabel = new JLabel("");

	public ChaHouse(String yiid) {

		yid = yiid;
		setTitle("欢迎使用医院高级管理系统");
		setSize(800, 464);
		setLocationRelativeTo(null);
		setResizable(false);

		setModal(true);

		pane2.setBounds(51, 92, 700, 300);
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
		bkeshiidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		bkeshiidLabel.setBounds(51, 52, 120, 30);
		bkeshiBox.setFont(new Font("微软雅黑", Font.BOLD, 21));
		bkeshiBox.setBounds(212, 52, 120, 30);
		cha1Button.setBackground(new Color(64, 224, 208));
		cha1Button.setFont(new Font("微软雅黑", Font.BOLD, 21));

		cha1Button.setBounds(411, 52, 120, 30);
		cha1Button.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		backButton.setBackground(new Color(64, 224, 208));
		backButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
//		sureButton.setBounds(1150, 196, 78, 20);
		backButton.setBounds(599, 52, 152, 30);
		backButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮

		getContentPane().add(cha1Button);
		getContentPane().add(backButton);
		
		getContentPane().add(bkeshiBox);
		getContentPane().add(bkeshiidLabel);

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

		// 显示开药表
				Vector<String> thVector2 = new Vector<String>();
				thVector2.add("药品编号");
				thVector2.add("药品名称");
				thVector2.add("药品价格");
				thVector2.add("药品类型");
				thVector2.add("包装方式");
				thVector2.add("开药数量");
				Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();
				for (int s = 0; s < 5; s++) {
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
				getContentPane().add(pane2);
				lblNewLabel.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\DengLuanniu20190818001542.png"));
				lblNewLabel.setBounds(0, 0, 794, 435);
				
				getContentPane().add(lblNewLabel);
				
		
		cha1Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 显示病房表
				Vector<String> thVector2 = new Vector<String>();
				thVector2.add("病房序号");
				thVector2.add("病房状况");
				thVector2.add("科室");

				Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();

				String keshiname = ((Keshi) bkeshiBox.getSelectedItem()).getkeName();

				Connection connection = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "select houNum , binName from house where keshiName = ?";
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setObject(1, keshiname);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						Vector<String> vector2 = new Vector<String>();
						vector2.add(rs.getString(1));
						if(rs.getString(2)==null){
							vector2.add("空床位");
							
						}else{
							vector2.add(rs.getString(2));
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
				getContentPane().add(pane2);

			
			
			}	
			
		});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				// 关闭界面
				ChaHouse.this.dispose();
//				new Ruyuan(yid);
			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {

		new ChaHouse("1");
	}

}
