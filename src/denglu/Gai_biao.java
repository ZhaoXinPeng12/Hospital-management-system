package denglu;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class Gai_biao implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) {
		JLabel renderer = (JLabel) new DefaultTableCellRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if(row%2==0){
			renderer.setForeground(Color.black);
			renderer.setBackground(Color.cyan);
		}else{
			renderer.setForeground(Color.black);
			renderer.setBackground(Color.WHITE);
		}

		return renderer;
	}

}
