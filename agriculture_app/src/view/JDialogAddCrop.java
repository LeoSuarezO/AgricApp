package view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import constants.ConstantsLanguage;
import constants.ConstantsView;
import general.HandlerLanguage;

public class JDialogAddCrop extends JDialog{

	private static final long serialVersionUID = 1L;
	private PanelPrinDialAddCrop panel;


	public JDialogAddCrop(ActionListener acl) {
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.APP_NAME)+"-"+HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.CREATE_CROP));
		setIconImage(new ImageIcon(ConstantsView.LOGO_APP).getImage());
		setSize( 550, 700 );
		setResizable(false);
		initComponents(acl);
		setContentPane(panel);
		setModal(true);
	}

	private void initComponents(ActionListener acl) {
		panel = new PanelPrinDialAddCrop(acl);
	}
	
	public void changeLanguage() {
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.APP_NAME)+"-"+HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.CREATE_CROP));
		panel.changeLanguage();
	}
	
	public void newCrop() {
		panel.newCrop();
	}
}