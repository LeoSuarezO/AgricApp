package view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import constants.ConstantsLanguage;
import constants.ConstantsView;
import general.HandlerLanguage;

public class JDialogModifyCroop extends JDialog{

	private static final long serialVersionUID = 1L;
	private PanelPrinDiamodifyCroop panel;


	public JDialogModifyCroop(ActionListener acl) {
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.APP_NAME)+"-"+HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.CREATE_CROP));
		setIconImage(new ImageIcon(ConstantsView.LOGO_APP).getImage());
		setSize( 550, 700 );
		setResizable(false);
		initComponents(acl);
		setContentPane(panel);
		setModal(true);
	}

	private void initComponents(ActionListener acl) {
		panel = new PanelPrinDiamodifyCroop(acl);
	}
	
	public void changeLanguage() {
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.APP_NAME)+"-"+HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.CREATE_CROP));
		panel.changeLanguage();
	}
	
	public void modifyCroop() {
		panel.modifyCroop();
	}
}