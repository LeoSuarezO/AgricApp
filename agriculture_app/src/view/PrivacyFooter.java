package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import constants.ConstantsLanguage;
import constants.ConstantsView;
import general.HandlerLanguage;

public class PrivacyFooter extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public ConfigButton privacy;
	public JLabel privacyUs;
	public ConfigButton who;
	public ConfigButton about;
	public ConfigButton help;
	
	public PrivacyFooter() {
		setBackground(ConstantsView.GREEN_FOOTER);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 40));
		init();
	}
	
	public void init() {
		privacy = new ConfigButton();
		who = new ConfigButton();
		about = new ConfigButton();
		help = new ConfigButton();
		privacyUs = new JLabel();
		config();
	}
	
	public void config() {
		privacyUs.setHorizontalAlignment(SwingConstants.LEFT);
		privacyUs.setIcon(new ImageIcon(ConstantsView.POLICIES));
		privacyUs.setForeground(Color.WHITE);
		privacyUs.setFont(ConstantsView.BAUHAUS_17_PLAIN);
		privacyUs.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.POLICIES));
		privacyUs.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 50));
		
		privacy.buttonTextIcon(ConstantsView.NULL, ConstantsLanguage.PRIVACY, ConstantsView.GREEN_FOOTER, false, ConstantsView.BAUHAUS_15, Color.white);
		who.buttonTextIcon(ConstantsView.NULL, ConstantsLanguage.WHO, ConstantsView.GREEN_FOOTER, false, ConstantsView.BAUHAUS_15, Color.white);
		about.buttonTextIcon(ConstantsView.NULL, ConstantsLanguage.ABOUT, ConstantsView.GREEN_FOOTER, false, ConstantsView.BAUHAUS_15, Color.white);
		help.buttonTextIcon(ConstantsView.NULL, ConstantsLanguage.HELP, ConstantsView.GREEN_FOOTER, false, ConstantsView.BAUHAUS_15, Color.white);
		
		privacy.setHorizontalAlignment(SwingConstants.LEFT);
		who.setHorizontalAlignment(SwingConstants.LEFT);
		about.setHorizontalAlignment(SwingConstants.LEFT);
		help.setHorizontalAlignment(SwingConstants.LEFT);
		add(privacyUs);
		add(privacy);
		add(who);
		add(about);
		add(help);
	}
	
	public void changeLanguage() {
		privacyUs.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.POLICIES));
		privacy.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.PRIVACY));
		who.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.WHO));
		about.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.ABOUT));
		help.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.HELP));
	}

}
