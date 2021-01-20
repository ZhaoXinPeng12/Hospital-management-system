package yishengDengLu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import denglu.Denglu;
import guanlizheTengLu.GuanlizheTengLu;
import menzhenDenglu.MenzhenDenglu;

public class Main_yishengView extends JFrame {
	
	String id="";
	private JDesktopPane desktopPane = new JDesktopPane();
	
	public Main_yishengView(String yiid) {
		id=yiid;
		
		setTitle("欢迎登陆医生管理系统");
		setSize(800, 600);
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

		JButton binrenButton  = new JButton("患者管理");
		binrenButton.setBounds(50, 75, 93, 32);
		getContentPane().add(binrenButton);
		
		JButton guahaoButton = new JButton("值班查询");
		guahaoButton.setBounds(61, 179, 87, 32);
		getContentPane().add(guahaoButton);
		
		JButton yishengButton = new JButton("退出");
		yishengButton.setBounds(61, 295, 82, 32);
		
		getContentPane().add(binrenButton);
		getContentPane().add(guahaoButton);
		getContentPane().add(yishengButton);
		
		binrenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Ruyuan(id);				
			}
		});
		yishengButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Main_yishengView.this.dispose();
				new Denglu();
				
			}
		});
		
		guahaoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Main_yishengView.this.dispose();
				new ZhibanGuanLi(id);
			}
		});

		

		
		
		
		setVisible(true);// 写在最后
	}

	public static void main(String[] args) {
		new Main_yishengView("1");

	}

}

