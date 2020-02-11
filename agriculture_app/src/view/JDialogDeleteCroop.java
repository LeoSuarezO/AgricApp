package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import constants.ConstantsView;

public class JDialogDeleteCroop extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField txtIdCroop;
	private ConfigButton btnAddCroop;
	private ConfigButton btnCancel;
	private JLabel logo;
	
	public JDialogDeleteCroop() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(300,200));
		addComponents();
		init();
	}
	
	private void addComponents() {
		txtIdCroop = new JTextField();
		btnCancel = new ConfigButton();
		logo = new JLabel();
		btnAddCroop = new ConfigButton();
	}
	
	private void init() {
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx =0;
		gbc.gridwidth =2;
		gbc.gridy =0;
		gbc.insets = new Insets(5, 5, 5, 5);
		this.add(logo,gbc);
		
		gbc.gridx =0;
		gbc.gridwidth =2;
		gbc.gridy =1;
		this.add(txtIdCroop,gbc);
		
		gbc.gridx =0;
		gbc.gridy =2;
		gbc.gridwidth =1;
		this.add(btnAddCroop,gbc);

		gbc.gridx =1;
		gbc.gridwidth =1;
		gbc.gridy =2;
		this.add(btnCancel,gbc);
	}
	private void configComponents() {
		logo.setIcon(new ImageIcon(ConstantsView.BANNER));

	}

}
