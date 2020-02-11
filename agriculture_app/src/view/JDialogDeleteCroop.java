package view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import constants.ConstantsLanguage;
import constants.ConstantsView;
import general.HandlerLanguage;

public class JDialogDeleteCroop extends JDialog{

	private static final long serialVersionUID = 1L;
	private PanelPrinDelete panel;


	public JDialogDeleteCroop(ActionListener acl) {
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.APP_NAME)+"-"+HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.CREATE_CROP));
		setIconImage(new ImageIcon(ConstantsView.LOGO_APP).getImage());
		setSize( 550, 700 );
		setResizable(false);
		initComponents(acl);
		setContentPane(panel);
		setModal(true);
	}

	private void initComponents(ActionListener acl) {
		panel = new PanelPrinDelete(acl);
	}
	
	public void changeLanguage() {
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.APP_NAME)+"-"+HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.CREATE_CROP));
		panel.changeLanguage();
	}
	
	public void deleteCroop() {
		panel.deleteCrop();
	}
}