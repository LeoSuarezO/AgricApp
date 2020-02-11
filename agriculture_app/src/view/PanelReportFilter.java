package view;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import constants.ConstantsLanguage;
import constants.ConstantsView;
import controller.AppManager;
import general.HandlerLanguage;

public class PanelReportFilter extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboFilter;
	private String [] types;
	private TableFilter table;
	
	public PanelReportFilter() {
		setLayout(new BorderLayout());
		init();
	}
	
	public void init() {
		comboFilter = new JComboBox<String>();
		types = new String [] {HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.FRUITS), HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.GREEN), HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.SEEDS)};
		table = new TableFilter();
		config();
	}
	
	public void config() {
		comboFilter.setModel(new DefaultComboBoxModel<String>(types));
		comboFilter.setFont(ConstantsView.BAUHAUS_15_PLAIN);
		comboFilter.setFocusable(false);
		comboFilter.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				AppManager.filterElemntsTable(comboFilter.getSelectedItem().toString());
			}
		});
		add(comboFilter, BorderLayout.NORTH);
		add(table, BorderLayout.CENTER);
	}
	
	public void addElementsToTable(Object [] obj) {
		table.addElementToTable(obj);
	}
	
	public String getSelectedItem() {
		return comboFilter.getSelectedItem().toString();
	}
	public void changeLanguage() {
		types = new String [] {HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.FRUITS), HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.GREEN), HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.SEEDS)};
		table.changeLanguage();
	}

}
