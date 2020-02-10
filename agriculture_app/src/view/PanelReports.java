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
	private ConfigButton reportPlant;
	private ConfigButton reportCountCrop;
	
	
	public PanelReports(ActionListener acl) {
		setBackground(Color.WHITE);
		init(acl);
	}
	
	public void init(ActionListener acl) {
		reportHarv = new ConfigButton();
		reportFilter = new ConfigButton();
		reportPlant = new ConfigButton();
		reportCountCrop = new ConfigButton();
		config(acl);
	}
	
	public void config(ActionListener acl) {
		reportHarv.buttonTextIcon(ConstantsView.REPORT_S, ConstantsLanguage.REP_TYPE_HARV, Color.WHITE, true, ConstantsView.BAUHAUS_20_PLAIN, Color.DARK_GRAY);
		reportHarv.setActionCommand(Command.REPORT_HARV.name());
		reportHarv.addActionListener(acl);
		
		reportFilter.buttonTextIcon(ConstantsView.REPORT_S, ConstantsLanguage.REP_FILTER, Color.WHITE, true, ConstantsView.BAUHAUS_20_PLAIN, Color.DARK_GRAY);
		reportFilter.setActionCommand(Command.REPORT_FILTER.name());
		reportFilter.addActionListener(acl);
		
		reportPlant.buttonTextIcon(ConstantsView.REPORT_S, ConstantsLanguage.REP_TYPE_PLAN, Color.WHITE, true, ConstantsView.BAUHAUS_20_PLAIN, Color.DARK_GRAY);
		reportPlant.setActionCommand(Command.REPORT_PLANT.name());
		reportPlant.addActionListener(acl);
		
		reportCountCrop.buttonTextIcon(ConstantsView.REPORT_S, ConstantsLanguage.REP_TYPE_COUNT, Color.WHITE, true, ConstantsView.BAUHAUS_20_PLAIN, Color.DARK_GRAY);
		reportCountCrop.setActionCommand(Command.REPORT_COUNT.name());
		reportCountCrop.addActionListener(acl);
		
		add(reportHarv);
		add(reportPlant);
		add(reportCountCrop);
		add(reportFilter);
		
	}
	
	
	public void changeLanguage() {
		reportHarv.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.REP_TYPE_HARV));
		reportFilter.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.REP_FILTER));
		reportPlant.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.REP_TYPE_PLAN));
	}

}
