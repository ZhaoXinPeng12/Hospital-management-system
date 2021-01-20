package menzhenDenglu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;

import denglu.Denglu;
import guanlizheTengLu.Cha_bin;
import guanlizheTengLu.Cha_yi;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Main_menzhenView extends JFrame {

	private JDesktopPane desktopPane = new JDesktopPane();

	private final JButton binButton = new JButton("患者挂号");
	private final JButton yaoButton = new JButton("门诊收费");
	private final JButton chuyuanButton = new JButton("出院收费");
	private final JButton chaxunButton = new JButton("挂号表查询");
	private final JButton backButton = new JButton("返回主登陆界面");
	private final JLabel lblNewLabel = new JLabel("");

	public Main_menzhenView() {

		setTitle("欢迎进入门诊界面");
		setSize(1930, 1042);
		setLocationRelativeTo(null);
		setResizable(false);// 设置窗口大小固定
		getContentPane().setLayout(null);// 绝对布局

		// 设置界面关闭事件
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				int n = JOptionPane.showConfirmDialog(null, "真的要退出嘛?", "退出", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					System.exit(0);
				}
			}
		});
		yaoButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		yaoButton.setBounds(160, 196, 250, 100);
		yaoButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		chuyuanButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chuyuanButton.setBounds(160, 331, 250, 100);
		chuyuanButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		chaxunButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		chaxunButton.setBounds(160, 458, 250, 100);
		chaxunButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		backButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		backButton.setBounds(160, 607, 250, 100);
		backButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		getContentPane().add(yaoButton);
		getContentPane().add(chuyuanButton);
		getContentPane().add(chaxunButton);
		getContentPane().add(backButton);

		desktopPane.setBounds(550, 0, 800, 1000);
		getContentPane().add(desktopPane);

		GuahaoView guahaoView = new GuahaoView();
		guahaoView.setBounds(0, 0, 800,1042);
		desktopPane.add(guahaoView);

		Cha_bin cha_bin = new Cha_bin();
		cha_bin.setBounds(0, 0, 800, 1042);
		desktopPane.add(cha_bin);
		binButton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		binButton.setBounds(160, 65, 250, 100);
		binButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));// 设置凸起来的按钮
		getContentPane().add(binButton);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));
		lblNewLabel.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\MenZhen20190818220822.png"));
		lblNewLabel.setBounds(0, 10, 1924, 1013);
		
		getContentPane().add(lblNewLabel);

		binButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new GuahaoView();
				// 以数组的形式返回桌面中当前显示的所有JInternalFrame
				JInternalFrame[] internalFrames = desktopPane.getAllFrames();
				boolean f = true;
				for (JInternalFrame internalFrame : internalFrames) {
					if (internalFrame instanceof GuahaoView) {
						internalFrame.setVisible(true);
						f = false;
					} else {
						internalFrame.setVisible(false);
					}
				}
			}
		});

		chaxunButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Cha_bin();
				// 以数组的形式返回桌面中当前显示的所有JInternalFrame
				JInternalFrame[] internalFrames = desktopPane.getAllFrames();
				boolean f = true;
				for (JInternalFrame internalFrame : internalFrames) {
					if (internalFrame instanceof Cha_bin) {
						internalFrame.setVisible(true);
						f = false;
					} else {
						internalFrame.setVisible(false);
					}
				}

			}
		});

		yaoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new YaofeView();

			}
		});

		chuyuanButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new ChuyuanfeView();

			}
		});

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Denglu();

			}
		});

		setVisible(true);

	}

	public static void main(String[] args) {

		new Main_menzhenView();

	}

}
