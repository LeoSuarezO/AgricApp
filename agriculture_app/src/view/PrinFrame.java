package view;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import constants.ConstantsLanguage;
import constants.ConstantsView;
import general.HandlerLanguage;

public class PrinFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelPrin panel;
	private JScrollPane scroll;
	
	public PrinFrame(ActionListener acl, ItemListener itl) {
		setIconImage(new ImageIcon(ConstantsView.LOGO_APP).getImage());
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.APP_NAME));
		setExtendedState(MAXIMIZED_BOTH);
		init(acl, itl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void init(ActionListener acl, ItemListener itl) {
		panel = new PanelPrin(acl, itl);
		scroll = new JScrollPane(panel);
		new JOptionPane();
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
	
	public void changePanelReport() {
		panel.changePanelReport();
		this.pack();
		setExtendedState(MAXIMIZED_BOTH);
	}
	
	public String getSelectedItem() {
		return panel.getSelectedItem();
	}
	public void succes() {
		JOptionPane.showMessageDialog(this, HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.SUCCES_DATA),  HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.EXPORT), JOptionPane.DEFAULT_OPTION, new ImageIcon(ConstantsView.SUCCES));
	}

	public void changeLanguage() {
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.APP_NAME));
		panel.changeLanguage();
	}
	
	public void addElementToTable(Object [] obj) {
		panel.addElementToTable(obj);
	}
	
}
