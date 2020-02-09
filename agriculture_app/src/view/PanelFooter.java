package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.ConstantsLanguage;
import constants.ConstantsView;
import controller.Command;
import general.HandlerLanguage;

public class PanelFooter extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public ContactFooter contactFooter;
	public PrivacyFooter privacyFooter;
	public JPanel lineO;
	public JPanel lineG;
	public JPanel aux;
	public JPanel lang;
	public ConfigButton spanish;
	public ConfigButton english;
	public JLabel copyright;

	public PanelFooter(ActionListener acl) {
		setLayout(new BorderLayout());
		setBackground(ConstantsView.GREEN_FOOTER);
		init(acl);
	}
	
	public void init(ActionListener acl) {
		contactFooter = new ContactFooter();
		privacyFooter = new PrivacyFooter();
		lineO = new JPanel();
		lineG = new JPanel();
		aux = new JPanel();
		lang = new JPanel();
		spanish = new ConfigButton();
		english = new ConfigButton();
		copyright = new JLabel();
		config(acl);
	}
	
	public void config(ActionListener acl) {
		aux.setBackground(ConstantsView.GREEN_FOOTER);
		copyright.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.COPYRIGHT));
		lineO.setBackground(ConstantsView.ORANGE);
		lineO.add(new JLabel());
		lineG.setBackground(ConstantsView.GREEN);
		lineG.add(copyright);
		lang.setBackground(ConstantsView.GREEN_FOOTER);
		lang.setBorder(BorderFactory.createEmptyBorder(100, 0, 20, 20));
		
		spanish.buttonTextIcon(ConstantsView.SPAIN, ConstantsLanguage.LANG_ES, ConstantsView.GREEN_FOOTER, true, ConstantsView.BAUHAUS_15, Color.WHITE);
		spanish.setActionCommand(Command.LANGUAGE_ES.name());
		spanish.addActionListener(acl);
		lang.add(spanish);
		
		english.buttonTextIcon(ConstantsView.ENG,  ConstantsLanguage.LANG_US, ConstantsView.GREEN_FOOTER, true, ConstantsView.BAUHAUS_15, Color.WHITE);
		english.addActionListener(acl);
		english.setActionCommand(Command.LANGUAGE_ENG.name());
		lang.add(english);
		
		aux.add(privacyFooter);
		aux.add(contactFooter);
		aux.add(lang);
		
		add(lineO, BorderLayout.NORTH);
		add(aux, BorderLayout.CENTER);
		add(lineG,BorderLayout.SOUTH);
		
	}
	
	public void changeLanguage() {
		contactFooter.changeLanguage();
		privacyFooter.changeLanguage();
		spanish.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.LANG_ES));
		english.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.LANG_US));
		copyright.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.COPYRIGHT));
	}

}
