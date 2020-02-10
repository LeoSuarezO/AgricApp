package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import constants.ConstantsLanguage;
import constants.ConstantsView;
import controller.Command;
import general.HandlerLanguage;

public class PanelReports extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConfigButton reportHarv;
	private ConfigButton reportFilter;
	
	
	public PanelReports(ActionListener acl) {
		setBackground(Color.WHITE);
		init(acl);
	}
	
	public void init(ActionListener acl) {
		reportHarv = new ConfigButton();
		reportFilter = new ConfigButton();
		config(acl);
	}
	
	public void config(ActionListener acl) {
		reportHarv.buttonTextIcon(ConstantsView.REPORT_S, ConstantsLanguage.REP_TYPE_HARV, Color.WHITE, true, ConstantsView.BAUHAUS_20_PLAIN, Color.DARK_GRAY);
		reportHarv.setActionCommand(Command.REPORT_HARV.name());
		reportHarv.addActionListener(acl);
		
		reportFilter.buttonTextIcon(ConstantsView.REPORT_S, ConstantsLanguage.REP_FILTER, Color.WHITE, true, ConstantsView.BAUHAUS_20_PLAIN, Color.DARK_GRAY);
		reportFilter.setActionCommand(Command.REPORT_PLANT.name());
		reportFilter.addActionListener(acl);
		
		add(reportHarv);
		add(reportFilter);
	}
	
	
	public void changeLanguage() {
		reportHarv.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.REP_TYPE_HARV));
		reportFilter.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.REP_FILTER));
	}

}
