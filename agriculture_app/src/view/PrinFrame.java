package view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import constants.ConstantsLanguage;
import constants.ConstantsView;
import general.HandlerLanguage;

public class PrinFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelPrin panel;
	private JScrollPane scroll;
	
	public PrinFrame(ActionListener acl) {
		setIconImage(new ImageIcon(ConstantsView.LOGO_APP).getImage());
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.APP_NAME));
		setExtendedState(MAXIMIZED_BOTH);
		init(acl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void init(ActionListener acl) {
		panel = new PanelPrin(acl);
		scroll = new JScrollPane(panel);
		scroll.setFocusable(false);
		add(scroll);
	}
	
	public void changePanelT() {
		panel.changePanelT();
		this.pack();
		setExtendedState(MAXIMIZED_BOTH);
	}
	
	public void changePanelAdm() {
		panel.changePanelAdm();
		this.pack();
		setExtendedState(MAXIMIZED_BOTH);
	}

	public void changeLanguage() {
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.APP_NAME));
		panel.changeLanguage();
	}
	
	public void addElementToTable(Object [] obj) {
		panel.addElementToTable(obj);
	}
	
}
