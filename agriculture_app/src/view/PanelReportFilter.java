package view;

import java.awt.BorderLayout;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import constants.ConstantsView;

public class PanelReportFilter extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboFilter;
	private String [] types;
	private TableFilter table;
	
	public PanelReportFilter(ItemListener itl) {
		setLayout(new BorderLayout());
		init(itl);
	}
	
	public void init(ItemListener itl) {
		comboFilter = new JComboBox<String>();
		types = new String [] {"Fruta", "Verde", "Semilla"};
		table = new TableFilter();
		config(itl);
	}
	
	public void config(ItemListener itl) {
		comboFilter.setModel(new DefaultComboBoxModel<String>(types));
		comboFilter.setFont(ConstantsView.BAUHAUS_15_PLAIN);
		comboFilter.setFocusable(false);
		comboFilter.addItemListener(itl);
		add(comboFilter, BorderLayout.NORTH);
		add(table, BorderLayout.CENTER);
	}
	
	public void clearTable() {
		table.clearTable();
	}
	
	public void addElementsToTable(Object [] obj) {
		table.addElementToTable(obj);
	}
	
	public String getSelectedItem() {
		return comboFilter.getSelectedItem().toString();
	}
	public void changeLanguage() {
		table.changeLanguage();
	}

}
