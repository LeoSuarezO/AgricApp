package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import constants.ConstantsLanguage;
import constants.ConstantsView;
import controller.Command;
import general.HandlerLanguage;

public class PanelAdmData extends JPanel{

	private static final long serialVersionUID = 1L;
	public ConfigButton addCrop;
	public ConfigButton editCrop;
	public ConfigButton delCrop;
	public ConfigButton exportCrop;
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	
	public PanelAdmData(ActionListener control) {
		setBackground(Color.WHITE);
		init();
		setLayout(gbl);
		setBorder(BorderFactory.createEmptyBorder(40, 450, 40, 450));
		config(control);
	}
	
	public void init() {
		addCrop = new ConfigButton();
		editCrop = new ConfigButton();
		delCrop = new ConfigButton();
		exportCrop = new ConfigButton();
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
	}
	
	public void config(ActionListener acl) {
		addCrop.buttonTextIcon(ConstantsView.ADD, ConstantsLanguage.CREATE_CROP, Color.WHITE, true, ConstantsView.BAUHAUS_17_PLAIN, Color.DARK_GRAY);
		addCrop.setActionCommand(Command.ADD_CROOP.name());
		addCrop.addActionListener(acl);
		addCrop.setBorder(new RoundBorder(10));
		
		delCrop.buttonTextIcon(ConstantsView.DELETE, ConstantsLanguage.DEL_CROP, Color.WHITE, true, ConstantsView.BAUHAUS_17_PLAIN, Color.DARK_GRAY);
		delCrop.setActionCommand(Command.DELETE_CROOP.name());
		delCrop.addActionListener(acl);
		delCrop.setBorder(new RoundBorder(10));
		
		editCrop.buttonTextIcon(ConstantsView.MODIFY, ConstantsLanguage.EDIT_CROP, Color.WHITE, true, ConstantsView.BAUHAUS_17_PLAIN, Color.DARK_GRAY);
		editCrop.setActionCommand(Command.EDITE_CROOP.name());
		editCrop.addActionListener(acl);
		editCrop.setBorder(new RoundBorder(10));
		
		exportCrop.buttonTextIcon(ConstantsView.EXPORT, ConstantsLanguage.EXPORT, Color.WHITE, true, ConstantsView.BAUHAUS_17_PLAIN, Color.DARK_GRAY);
		exportCrop.setActionCommand(Command.EXPORT.name());
		exportCrop.addActionListener(acl);
		exportCrop.setBorder(new RoundBorder(10));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		add(addCrop, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(delCrop, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(editCrop, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(exportCrop, gbc);
	}
	
	public void changeLanguage() {
		addCrop.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.CREATE_CROP));
		delCrop.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.DEL_CROP));
		editCrop.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.EDIT_CROP));
		exportCrop.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.EXPORT));
	}

}
