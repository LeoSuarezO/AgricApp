package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import constants.ConstantsLanguage;
import constants.ConstantsView;
import general.HandlerLanguage;

public class ContactFooter extends JPanel{

	
	private static final long serialVersionUID = 1L;
	private JLabel contact;
	private JTextArea info;
	
	public ContactFooter() {
		setLayout(new BorderLayout());
		setBackground(ConstantsView.GREEN_FOOTER);
		setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 300));
		init();
	}
	
	public void init() {
		contact = new JLabel();
		info = new JTextArea();
		config();
	}
	
	public void config() {
		contact.setHorizontalAlignment(SwingConstants.LEFT);
		contact.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.CONTACT));
		contact.setIcon(new ImageIcon(ConstantsView.CONTACT));
		contact.setForeground(Color.WHITE);
		contact.setFont(ConstantsView.BAUHAUS_17_PLAIN);
		contact.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
		add(contact, BorderLayout.NORTH);
		
		info.setBackground(ConstantsView.GREEN_FOOTER);
		info.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.CONTACT_INFO));
		info.setFont(ConstantsView.BAUHAUS_15);
		info.setForeground(Color.WHITE);
		info.setEditable(false);
		add(info, BorderLayout.CENTER);
	}
	
	public void changeLanguage() {
		contact.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.CONTACT));
		info.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.CONTACT_INFO));
	}

}
