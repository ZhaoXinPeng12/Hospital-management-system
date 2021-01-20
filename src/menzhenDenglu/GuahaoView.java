package menzhenDenglu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.enterprise.inject.New;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import pojo.Keshi;
import pojo.Qu;
import pojo.Sheng;
import pojo.Shi;
import pojo.Yisheng;
import pojo.Zhiye;
import util.Chooser;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

//import view.AddEmpView;

public class GuahaoView extends JInternalFrame {

	int shengid = 0;
	int shiid = 0;
	String binid = "";
	StringBuffer s1 = new StringBuffer("");

	private JTabbedPane tabbedPane1 = new JTabbedPane();

	private JLabel bshenfenLabel = new JLabel("\u8EAB  \u4EFD  \u8BC1 \uFF1A");
	private JTextField bshenfenField = new JTextField();
	private JLabel checkLabel2 = new JLabel();

	private JLabel bnameLabel = new JLabel("\u59D3       \u540D \uFF1A");
	private JTextField bnameField = new JTextField();

	private JLabel bgenderLabel = new JLabel("\u6027       \u522B \uFF1A");
	private JRadioButton maleButton = new JRadioButton("男");
	private JRadioButton femaleButton = new JRadioButton("女");

	private JLabel bkeshiidLabel = new JLabel("\u79D1      \u5BA4 \uFF1A");
	private JComboBox<Keshi> bkeshiBox = new JComboBox<Keshi>();

	private JLabel yishengidLabel = new JLabel("\u533B      \u751F \uFF1A");
	private JComboBox<Yisheng> yishengBox = new JComboBox<Yisheng>();

	private JLabel bzhiyeidLabel = new JLabel("\u804C       \u4F4D \uFF1A");
	private JComboBox<Zhiye> bzhiyeBox = new JComboBox<Zhiye>();

	private JLabel shiidLabel = new JLabel("\u57CE      \u5E02 \uFF1A");
	private JComboBox<Shi> shiBox = new JComboBox<Shi>();

	private JLabel shengidLabel = new JLabel("\u7701      \u4EFD \uFF1A");
	private JComboBox<Sheng> shengBox = new JComboBox<Sheng>();

	private JLabel quidLabel = new JLabel("\u533A      \u53BF \uFF1A");
	private JComboBox<Qu> quBox = new JComboBox<Qu>();

	private JLabel telLabel = new JLabel("\u7535       \u8BDD \uFF1A");
	private JTextField telField = new JTextField();
	private JLabel checkLabel = new JLabel();

	private JLabel birthdayLabel = new JLabel("\u51FA\u751F\u65E5\u671F \uFF1A");
	private JTextField birthdayField = new JTextField();

	private JButton resetButton = new JButton("\u91CD      \u7F6E");
	private JButton printButton = new JButton("打印挂号单");

	public GuahaoView() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);// 隐藏分容器标题栏
		setBorder(BorderFactory.createEmptyBorder());// 隐藏分容器边框

		setTitle("欢迎使用医院高级管理系统");
		setSize(800, 1044);
		getContentPane().setLayout(null);// 绝对布局

		tabbedPane1.setBounds(0, 0, 800, 1042);
		getContentPane().add(tabbedPane1);

		JPanel panel_1 = new JPanel();
		tabbedPane1.addTab("欢迎进入患者挂号界面", null, panel_1, null);
		bshenfenLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		bshenfenLabel.setBounds(280, 770, 119, 30);
		bshenfenField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		bshenfenField.setBounds(400, 770, 123, 30);
		checkLabel2.setFont(new Font("微软雅黑", Font.BOLD, 21));
		checkLabel2.setBounds(533, 770, 100, 30);
		bnameLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		bnameLabel.setBounds(280, 70, 125, 30);
		bnameField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		bnameField.setBounds(400, 70, 123, 30);
		bgenderLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		bgenderLabel.setBounds(280, 140, 119, 30);
		maleButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		maleButton.setBounds(400, 140, 60, 30);
		femaleButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		femaleButton.setBounds(459, 140, 60, 30);
		maleButton.setSelected(true);

		ButtonGroup buttonGroup = new ButtonGroup();// 分类，替进层次感
		buttonGroup.add(maleButton);
		buttonGroup.add(femaleButton);
		telLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		telLabel.setBounds(280, 700, 150, 30);
		telField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		telField.setBounds(400, 700, 123, 30);
		checkLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));
		checkLabel.setBounds(533, 700, 100, 30);
		bkeshiidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		bkeshiidLabel.setBounds(280, 350, 127, 30);
		bkeshiBox.setFont(new Font("微软雅黑", Font.BOLD, 21));
		bkeshiBox.setBounds(400, 350, 123, 30);
		yishengidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		yishengidLabel.setBounds(282, 420, 123, 30);
		yishengBox.setFont(new Font("微软雅黑", Font.BOLD, 21));
		yishengBox.setBounds(400, 420, 123, 30);
		bzhiyeidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		bzhiyeidLabel.setBounds(280, 280, 119, 30);
		bzhiyeBox.setFont(new Font("微软雅黑", Font.BOLD, 21));
		bzhiyeBox.setBounds(400, 280, 123, 30);
		shiidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		shiidLabel.setBounds(280, 560, 119, 30);
		shiBox.setFont(new Font("微软雅黑", Font.BOLD, 21));
		shiBox.setBounds(400, 560, 123, 30);
		shengidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		shengidLabel.setBounds(280, 490, 114, 30);
		shengBox.setFont(new Font("微软雅黑", Font.BOLD, 21));
		shengBox.setBounds(400, 490, 123, 30);
		quidLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		quidLabel.setBounds(280, 630, 113, 30);
		quBox.setFont(new Font("微软雅黑", Font.BOLD, 21));
		quBox.setBounds(400, 630, 123, 30);
		birthdayLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));

		birthdayLabel.setBounds(280, 210, 128, 30);
		birthdayField.setFont(new Font("微软雅黑", Font.BOLD, 21));
		birthdayField.setBounds(400, 210, 123, 30);
		resetButton.setBackground(new Color(153, 255, 255));
		resetButton.setFont(new Font("微软雅黑", Font.BOLD, 21));

		resetButton.setBounds(400, 890, 128, 30);
		resetButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		printButton.setBackground(new Color(153, 255, 255));
		printButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		printButton.setBounds(536, 890, 153, 30);
		printButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮

		panel_1.setLayout(null);

		panel_1.add(bshenfenLabel);
		panel_1.add(bshenfenField);
		panel_1.add(checkLabel2);

		panel_1.add(bnameLabel);
		panel_1.add(bnameField);

		panel_1.add(resetButton);
		panel_1.add(printButton);

		panel_1.add(bgenderLabel);
		panel_1.add(maleButton);
		panel_1.add(femaleButton);

		panel_1.add(telLabel);
		panel_1.add(telField);
		panel_1.add(checkLabel);

		panel_1.add(bkeshiidLabel);
		panel_1.add(bkeshiBox);

		panel_1.add(yishengidLabel);
		panel_1.add(yishengBox);

		panel_1.add(bzhiyeidLabel);
		panel_1.add(bzhiyeBox);

		panel_1.add(shiidLabel);
		panel_1.add(shiBox);

		panel_1.add(shengidLabel);
		panel_1.add(shengBox);

		panel_1.add(quidLabel);
		panel_1.add(quBox);

		Chooser chooser = Chooser.getInstance();
		chooser.register(birthdayField);
		panel_1.add(birthdayLabel);
		panel_1.add(birthdayField);
		lblNewLabel.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\GyaHao20190818222330.png"));
		lblNewLabel.setBounds(0, 0, 795, 990);

		panel_1.add(lblNewLabel);

		telField.addActionListener(new ActionListener() {
			// 手机号码
			@Override
			public void actionPerformed(ActionEvent e) {

				String regex = "^(((13|18)[0-9]{9})|(15[012356789][0-9]{8})|((147|170|171|173|175|176|177|178)[0-9]{8}))$";
				String id = telField.getText();
				// System.out.println(id);
				if (id.matches(regex)) {
					aa = 1;
					// System.out.println("号码格式正确");
				} else {
					// System.out.println("号码格式有误");
					telField.setText("");
					aa = 2;
					// usernameField.setText("");
					// passwordField.setText("");
				}
			}
		});
		bshenfenField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String regex = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|"
						+ "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
				String id = bshenfenField.getText();
				// System.out.println(id);
				if (id.matches(regex)) {
					bb = 1;
					// System.out.println("号码格式正确");
				} else {
					// System.out.println("号码格式有误");
					telField.setText("");
					bb = 2;
					// usernameField.setText("");
					// passwordField.setText("");
				}
			}
		});

		// 查找科室
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

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
		// 查找医生
		Connection connection3 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection3 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select yiID , yiName from yishenbiao";
			PreparedStatement ps = connection3.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Yisheng yisheng = new Yisheng();
				yisheng.setyishengID(rs.getInt(1));
				yisheng.setyishengName(rs.getString(2));
				// yishengBox.addItem(yisheng);
				yishengBox.addItem(yisheng);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				connection3.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		bkeshiBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				yishengBox.removeAllItems();
				int keshiid = ((Keshi) bkeshiBox.getSelectedItem()).getkeID();

				Connection connection2 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "select yiID , yiName from yishenbiao where keshiID = ?";
					PreparedStatement ps = connection2.prepareStatement(sql);
					ps.setObject(1, keshiid);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						Yisheng yi = new Yisheng();
						yi.setyishengID(rs.getInt(1));
						yi.setyishengName(rs.getString(2));
						yishengBox.addItem(yi);
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

		// // 查找职位
		Connection connection2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select zhiyeID , zhiyeName from zhiyebiao";
			PreparedStatement ps = connection2.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Zhiye zhiye = new Zhiye();
				zhiye.setzhiID(rs.getInt(1));
				zhiye.setkeName(rs.getString(2));
				bzhiyeBox.addItem(zhiye);
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

		// 查找省份
		Connection connection7 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection7 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select shengID , shengName from sheng";
			PreparedStatement ps = connection7.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Sheng keshi = new Sheng();
				keshi.setshengID(rs.getInt(1));
				keshi.setshengName(rs.getString(2));
				shengBox.addItem(keshi);
				
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

		 int shengid1 = ((Sheng) shengBox.getSelectedItem()).getshengID();
		// 查找市区
		Connection connection8 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection8 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select shiID , shiName from shi where sheng = ?";
			PreparedStatement ps = connection8.prepareStatement(sql);
			ps.setObject(1, shengid1);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Shi keshi = new Shi();
				keshi.setshiID(rs.getInt(1));
				keshi.setshiName(rs.getString(2));
				shiBox.addItem(keshi);
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

		int shiid1 = ((Shi) shiBox.getSelectedItem()).getshiID();
		// 查找区域
		Connection connection9 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection9 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

			String sql = "select quID , quName from qu where shi = ?";
			PreparedStatement ps = connection9.prepareStatement(sql);
			ps.setObject(1, shiid1);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Qu keshi = new Qu();
				keshi.setquID(rs.getInt(1));
				keshi.setquName(rs.getString(2));
				quBox.addItem(keshi);
//				System.out.println(keshi);
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(1));
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

		shengBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				shiBox.removeAllItems();
			
				shengid = ((Sheng) shengBox.getSelectedItem()).getshengID();
//				System.out.println(shengid);

				Connection connection8 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection8 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "select shiID , shiName from shi where sheng = ?";
					PreparedStatement ps = connection8.prepareStatement(sql);
					ps.setObject(1, shengid);
					ResultSet rs = ps.executeQuery();

//					System.out.println("ll");
//
//					System.out.println("22");
					while (rs.next()) {
						Shi keshi1 = new Shi();
						keshi1.setshiID(rs.getInt(1));
						keshi1.setshiName(rs.getString(2));
						shiBox.addItem(keshi1);
					}
//					shiBox.removeItemAt(2);

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

		shiBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

//				quBox.removeAllItems();
								
				if(shiBox.getSelectedItem()==null){
					System.out.println("6ddddd搜索666");
					return ;
				}
				shiid = ((Shi) shiBox.getSelectedItem()).getshiID();

				Connection connection9 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection9 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");

					String sql = "select quID , quName from qu where shi = ?";
					PreparedStatement ps = connection9.prepareStatement(sql);
					ps.setObject(1, shiid);
					ResultSet rs = ps.executeQuery();
					
					quBox.removeAllItems();

					while (rs.next()) {
						Qu keshi = new Qu();
						keshi.setquID(rs.getInt(1));
						keshi.setquName(rs.getString(2));
						quBox.addItem(keshi);
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
			}
		});
		
//		quBox.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				shiBox.removeAllItems();
//								
//				if(shiBox.getSelectedItem()==null){
//					System.out.println("6请求666");
//					return ;
//				}
//				System.out.println("哈哈");
//				shiid = ((Shi) shiBox.getSelectedItem()).getshiID();
//
//				Connection connection9 = null;
//				try {
//					Class.forName("com.mysql.jdbc.Driver");
//					connection9 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");
//
//					String sql = "select quID , quName from qu where shi = ?";
//					PreparedStatement ps = connection9.prepareStatement(sql);
//					ps.setObject(1, shiid);
//					ResultSet rs = ps.executeQuery();
//
//					while (rs.next()) {
//						Qu keshi = new Qu();
//						keshi.setquID(rs.getInt(1));
//						keshi.setquName(rs.getString(2));
//						quBox.addItem(keshi);
//					}
//
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				} finally {
//					try {
//						connection9.close();
//					} catch (SQLException e1) {
//						e1.printStackTrace();
//					}
//				}
//			}
//		});

		printButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Print_Guahaodan print_Guahaodan = new Print_Guahaodan();

				int gender = 1;
				if (femaleButton.isSelected()) {
					gender = 2;
					// print_Guahaodan.setbingender("女");
				} else {
					// print_Guahaodan.setbingender("男");
				}

				Keshi keshi = (Keshi) bkeshiBox.getSelectedItem();
				int KeshiID = keshi.getkeID();
				String Keshiname = keshi.getkeName();
				// print_Guahaodan.setbinkeshi(keshi.getkeName());

				Zhiye zhiye = (Zhiye) bzhiyeBox.getSelectedItem();
				int zhiyeID = zhiye.getzhiID();
				String zhiyename = zhiye.getzhiName();

				Yisheng yisheng = (Yisheng) yishengBox.getSelectedItem();
				int yishengID = yisheng.getyishengID();
				String yishengname = yisheng.getyishengName();

				Sheng sheng = (Sheng) shengBox.getSelectedItem();
				s1.append(sheng.getshengName());

				Shi shi = (Shi) shiBox.getSelectedItem();
				s1.append(shi.getshiName());

				Qu qu = (Qu) quBox.getSelectedItem();
				s1.append(qu.getquName());
				String binname = bnameField.getText();
				print_Guahaodan.setbinname(binname);
				String tel = telField.getText();
				String shenfenzhen = bshenfenField.getText();
				String birthday = birthdayField.getText();
				if (Keshiname != null && zhiyename != null && yishengname != null && (sheng.getshengName()) != null
						&& (shi.getshiName()) != null && (qu.getquName()) != null && binname != null && tel != null
						&& shenfenzhen != null && birthday != null) {
					Connection connection = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/医院管理系统", "root", "root");
						String sql = "insert into guahaobiao(binName,binGender,binTel,keshiName,binBirthday,binShenfenzheng,zhiyeID,binYisheng,binAddress,Yes_No) values(?,?,?,?,?,?,?,?,?,?)";
						String sql2 = "select binID from guahaobiao order by binID desc limit 0,1";
						PreparedStatement ps = connection.prepareStatement(sql);
						PreparedStatement ps2 = connection.prepareStatement(sql2);
						ps.setObject(1, binname);
						ps.setObject(2, gender);
						ps.setObject(3, tel);
						ps.setObject(4, KeshiID);
						ps.setObject(5, birthday);
						ps.setObject(6, shenfenzhen);
						ps.setObject(7, zhiyeID);
						ps.setObject(8, yishengID);
						ps.setObject(9, s1.toString());
						ps.setObject(10, "0");
						int n = ps.executeUpdate();

						ResultSet rs = ps2.executeQuery();

						if (rs.next()) {
							binid = rs.getString("binid");
							new GuahaoDan(binid);

						} else {
							JOptionPane.showMessageDialog(null, "挂号失败");
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

				} else {

					JOptionPane.showMessageDialog(null, "请将挂号表内容填写完整！！！");

				}

			}

		});

		telField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// String tel = telField.getText();
				if (aa == 1) {
					checkLabel.setText("格式正确");
				} else {
					checkLabel.setText("格式有误");
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		bshenfenField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				// String bb = telField.getText();
				if (bb == 1) {
					checkLabel2.setText("格式正确");
				} else {
					checkLabel2.setText("格式有误");
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new GuahaoDan(binid);

			}
		});

		setVisible(true);

	}

	int aa = 0;
	int bb = 0;
	private final JLabel lblNewLabel = new JLabel("");

	public static void main(String[] args) {

		new GuahaoView();

	}
}