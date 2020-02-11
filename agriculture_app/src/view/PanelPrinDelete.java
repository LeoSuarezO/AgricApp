package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.placeholder.PlaceHolder;

import constants.ConstantsLanguage;
import constants.ConstantsView;
import controller.Command;
import general.HandlerLanguage;
import models.CropManager;
import models.CropTransitory;

public class PanelPrinDelete extends JPanel{


	private static final long serialVersionUID = 1L;
	private JTextField txtIdCroop;
	private ConfigButton btnAddCroop;
	private ConfigButton btnCancel;
	private JLabel logo;
	private PlaceHolder holder;

	public PanelPrinDelete(ActionListener acl) {
		setBackground(Color.WHITE);
		init(acl);
	}

	public void init(ActionListener acl) {
		txtIdCroop = new JTextField();
		btnCancel = new ConfigButton();
		btnAddCroop = new ConfigButton();
		logo = new JLabel();
		config(acl);
	}

	public void config(ActionListener acl) {
		logo.setIcon(new ImageIcon(ConstantsView.BANNER));

		setTextFieldConfig(txtIdCroop, ConstantsLanguage.ID_CROP_HOLD, ConstantsLanguage.Id);

		btnAddCroop.buttonTextIcon(ConstantsView.ADD_WHITE, ConstantsLanguage.CREATE_CROP, ConstantsView.GREEN, false, ConstantsView.BAUHAUS_15, Color.WHITE);
		btnAddCroop.addActionListener(acl);
		btnAddCroop.setActionCommand(Command.DELETE.name());
		btnAddCroop.setPreferredSize(new Dimension(200,45));

		btnCancel.buttonTextIcon(ConstantsView.CANCEL, ConstantsLanguage.CANCEL, Color.RED, false, ConstantsView.BAUHAUS_15, Color.WHITE);
		btnCancel.setActionCommand(Command.CANCEL_DELETE.name());
		btnCancel.addActionListener(acl);
		btnCancel.setPreferredSize(new Dimension(200,45));
		addComp();
	}

	public void addComp() {
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx =0;
		gbc.gridwidth =2;
		gbc.gridy =0;
		gbc.insets = new Insets(5, 5, 5, 5);
		this.add(logo,gbc);

		gbc.gridx = 0;
		gbc.gridy =1;
		gbc.gridwidth =2;
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

	public void setTextFieldConfig(JTextField field, String hold, String title) {
		field.setPreferredSize(new Dimension(400,45));
		field.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(title)));
		setHolder(new PlaceHolder(field, HandlerLanguage.languageProperties.getProperty(hold)));
	}

	public void deleteCrop() {
		int idCroopModify = Integer.parseInt(txtIdCroop.getText());
		CropManager.deleteCroop(idCroopModify);
	}

	public void changeLanguage() {
		setTextFieldConfig(txtIdCroop, ConstantsLanguage.NAME_CROP_HOLD, ConstantsLanguage.CROP);
		btnAddCroop.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.CREATE_CROP));
		btnCancel.setText(HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.CANCEL));
	}

	public PlaceHolder getHolder() {
		return holder;
	}

	public void setHolder(PlaceHolder holder) {
		this.holder = holder;
	}
}
