package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import constants.ConstantsLanguage;
import constants.ConstantsView;
import controller.Command;
import general.HandlerLanguage;

public class PanelNorth extends JPanel{

	private static final long serialVersionUID = 1L;
	private ConfigButton logo;
	public ConfigButton spanish;
	public ConfigButton english;
	public JPanel panelLogo;

	public PanelNorth(ActionListener acl) {
		setBackground(Color.WHITE);
		init(acl);
	}
	
	public void init(ActionListener acl) {
		logo = new ConfigButton();
		spanish = new ConfigButton();
		english = new ConfigButton();
		panelLogo = new JPanel();
		config(acl);
	}
	
	public void config(ActionListener acl) {
		panelLogo.setLayout(new BorderLayout());
		panelLogo.setBackground(Color.WHITE);
		panelLogo.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 400));
		
		logo.buttonImage(ConstantsView.BANNER, Color.white, false);
		panelLogo.add(logo, BorderLayout.WEST);
		add(panelLogo);
		
		spanish.buttonTextIcon(ConstantsView.SPAIN, ConstantsLanguage.LANG_ES, ConstantsView.ORANGE, false, ConstantsView.BAUHAUS_15, Color.WHITE);
		spanish.setActionCommand(Command.LANGUAGE_ES.name());
		spanish.addActionListener(acl);
		add(spanish);
		
		english.buttonTextIcon(ConstantsView.ENG,  ConstantsLanguage.LANG_US, ConstantsView.ORANGE, false, ConstantsView.BAUHAUS_15, Color.WHITE);
		english.addActionListener(acl);
		english.setActionCommand(Command.LANGUAGE_ENG.name());
		add(english);
	}
	
	public void changeLanguge() {
		spanish.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.LANG_ES));
		english.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.LANG_US));
	}
}
