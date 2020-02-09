package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import constants.ConstantsLanguage;
import constants.ConstantsView;
import controller.Command;
import general.HandlerLanguage;

public class MenuBar extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public ConfigButton home;
	public ConfigButton data;
	public ConfigButton reports;
	public ConfigButton gestData;

	public MenuBar(ActionListener acl) {
		setBackground(ConstantsView.GREEN);
		init(acl);
	}
	
	public void init(ActionListener acl) {
		home = new ConfigButton();
		data = new ConfigButton();
		reports = new ConfigButton();
		gestData = new ConfigButton();
		config(acl);
	}
	
	public void config(ActionListener acl) {
		home.buttonTextIcon(ConstantsView.HOME, ConstantsLanguage.HOME, ConstantsView.GREEN, true, ConstantsView.BAUHAUS_15, Color.WHITE);
		home.addActionListener(acl);
		home.setActionCommand(Command.HOME.name());
		add(home);
		
		data.buttonTextIcon(ConstantsView.DATA, ConstantsLanguage.DATA, ConstantsView.GREEN, true, ConstantsView.BAUHAUS_15, Color.WHITE);
		data.addActionListener(acl);
		data.setActionCommand(Command.DATA.name());
		add(data);
		
		reports.buttonTextIcon(ConstantsView.REPORTS, ConstantsLanguage.REPORTS, ConstantsView.GREEN, true, ConstantsView.BAUHAUS_15, Color.WHITE);
		reports.addActionListener(acl);
		reports.setActionCommand(Command.REPORTS.name());
		add(reports);
		
		gestData.buttonTextIcon(ConstantsView.MANAGE_DATA, ConstantsLanguage.GEST_DT, ConstantsView.GREEN, true, ConstantsView.BAUHAUS_15, Color.WHITE);
		gestData.addActionListener(acl);
		gestData.setActionCommand(Command.MANAGE_DATA.name());
		add(gestData);
		}
	
	public void changeLanguage() {
		home.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.HOME));
		data.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.DATA));
		reports.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.REPORTS));
		gestData.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.GEST_DT));
	}
}