package guanlizheTengLu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Main_View extends JFrame {

	private JDesktopPane desktopPane = new JDesktopPane();

	private final JButton binButton = new JButton("病人管理");
	private final JButton yiButton = new JButton("医生管理");
	private final JButton yaoButton = new JButton("药库管理");
	private final JButton btnNewButton_3 = new JButton("死亡职工管理");
	private final JLabel lblNewLabel = new JLabel("");

	public Main_View() {

		setTitle("欢迎使用高级医院管理系统");
		setSize(1930, 1042);
		setLocationRelativeTo(null);
		setResizable(false);// 设置窗口大小固定
		getContentPane().setLayout(null);// 绝对布局

		// 设置界面关闭事件
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

		binButton.setBounds(160, 80, 250, 100);
		getContentPane().add(binButton);

		yiButton.setBounds(160, 346, 250, 100);
		getContentPane().add(yiButton);

		yaoButton.setBounds(160, 215, 250, 100);
		getContentPane().add(yaoButton);

		desktopPane.setBounds(550, 0, 800, 1000);
		getContentPane().add(desktopPane);

		Cha_bin2 cha_bin2 = new Cha_bin2();
		cha_bin2.setBounds(0, 0, 800,1042);
		desktopPane.add(cha_bin2);

		Cha_yi cha_yi = new Cha_yi();
		cha_yi.setBounds(0, 0, 800,1042);
		desktopPane.add(cha_yi);

		Cha_yao cha_yao = new Cha_yao();
		cha_yao.setBounds(0, 0, 800,1042);
		desktopPane.add(cha_yao);
		lblNewLabel.setIcon(new ImageIcon("D:\\\u8D5B\u6770\u9879\u76EE\\src\\tupian\\MenZhen20190818220822.png"));
		lblNewLabel.setBounds(0, 0, 1924, 1013);
		
		getContentPane().add(lblNewLabel);

		binButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Cha_bin2();
				// 以数组的形式返回桌面中当前显示的所有JInternalFrame
				JInternalFrame[] internalFrames = desktopPane.getAllFrames();
				boolean f = true;
				for (JInternalFrame internalFrame : internalFrames) {
					if (internalFrame instanceof Cha_bin2) {
						internalFrame.setVisible(true);
						f = false;
					} else {
						internalFrame.setVisible(false);
					}
				}

			}
		});

		yiButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Cha_bin();
				// 以数组的形式返回桌面中当前显示的所有JInternalFrame
				JInternalFrame[] internalFrames = desktopPane.getAllFrames();
				boolean f = true;
				for (JInternalFrame internalFrame : internalFrames) {
					if (internalFrame instanceof Cha_yi) {
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

				new Cha_yao();
				// 以数组的形式返回桌面中当前显示的所有JInternalFrame
				JInternalFrame[] internalFrames = desktopPane.getAllFrames();
				boolean f = true;
				for (JInternalFrame internalFrame : internalFrames) {
					if (internalFrame instanceof Cha_yao) {
						internalFrame.setVisible(true);
						f = false;
					} else {
						internalFrame.setVisible(false);
					}
				}

			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {

		new Main_View();
	}

}
