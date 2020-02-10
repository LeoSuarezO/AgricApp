package view;

import java.awt.Color;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import constants.ConstantsLanguage;
import general.HandlerLanguage;

public class PanelReports extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String [] typeReport;
	private JComboBox<TypeReport> comboReports;
	
	
	public PanelReports(ItemListener itl) {
		setBackground(Color.WHITE);
		init(itl);
	}
	
	public void init(ItemListener itl) {
		comboReports = new JComboBox<TypeReport>();
		config(itl);
	}
	
	public void config(ItemListener itl) {
		comboReports.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.REPORTS)));
		comboReports.setModel(new DefaultComboBoxModel<TypeReport>(TypeReport.values()));
		comboReports.addItemListener(itl);
		add(comboReports);
	}
	
	public String getSelectedItem() {
		return comboReports.getSelectedItem().toString();
	}
	
	public void changeLanguage() {
		comboReports.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.REPORTS)));
		comboReports.setModel(new DefaultComboBoxModel<TypeReport>(TypeReport.values()));
	}

}
