package yishengDengLu;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Chuyuan_Main  extends JInternalFrame{
	
	private JTabbedPane tabbedPane1 = new JTabbedPane();
	
	// 表1
	private JTable table2 = new JTable() {

		public boolean isCellEditable(int row, int column) {

			return false;
		};

	};
	private JScrollPane pane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	// VERTICAL_SCROLLBAR_AS_NEEDED;VERTICAL_SCROLLBAR_NEVER;


	public Chuyuan_Main(){
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);// 隐藏分容器标题栏
		setBorder(BorderFactory.createEmptyBorder());// 隐藏分容器边框

		setTitle("欢迎进入医生管理界面");
		setSize( 800, 1042);
		getContentPane().setLayout(null);// 设置绝对布局

		tabbedPane1.setBounds(0, 0, 800, 1042);
		getContentPane().add(tabbedPane1);

		JPanel panel_1 = new JPanel();
		tabbedPane1.addTab("出院管理", null, panel_1, null);
		
		pane2.setBounds(45, 25, 500, 138);
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {

	}

}
