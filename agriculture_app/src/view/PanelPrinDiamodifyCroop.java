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

public class PanelPrinDiamodifyCroop extends JPanel{


	private static final long serialVersionUID = 1L;
	private JTextField txtNameCrop;
	private JTextField txtIdCrop;
	private JComboBox<String> jcTypeCroop;
	private JTextField txtPrice;
	private JTextField txtCropArea;
	private JTextField txtPlantingArea;
	private JTextField txtCosts;
	private JSpinner txtTons;
	private ConfigButton btnAddCroop;
	private ConfigButton btnCancel;
	private JLabel logo;
	private PlaceHolder holder;

	public PanelPrinDiamodifyCroop(ActionListener acl) {
		setBackground(Color.WHITE);
		init(acl);
	}

	public void init(ActionListener acl) {
		txtIdCrop = new JTextField();
		txtNameCrop = new JTextField();
		jcTypeCroop = new JComboBox<String>();
		txtPrice = new JTextField();
		txtCropArea = new JTextField();
		txtPlantingArea = new JTextField();
		txtCosts = new JTextField();
		txtTons = new JSpinner();
		btnCancel = new ConfigButton();
		btnAddCroop = new ConfigButton();
		logo = new JLabel();
		config(acl);
	}

	public void config(ActionListener acl) {
		logo.setIcon(new ImageIcon(ConstantsView.BANNER));

		jcTypeCroop.setPreferredSize(new Dimension(400,85));
		jcTypeCroop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder (10, 10, 10, 10, Color.WHITE), HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.TYPE_AL)));
		jcTypeCroop.setBackground(Color.WHITE);

		setTextFieldConfig(txtIdCrop, ConstantsLanguage.ID_CROP_HOLD, ConstantsLanguage.ID_CROP);
		setTextFieldConfig(txtNameCrop, ConstantsLanguage.NAME_CROP_HOLD, ConstantsLanguage.CROP);
		setTextFieldConfig(txtPrice, ConstantsLanguage.PRICE_CROP_HOLD, ConstantsLanguage.PRICE);
		setTextFieldConfig(txtCropArea, ConstantsLanguage.HARVESTED_AREA_HOLD, ConstantsLanguage.HARV_AREA);
		setTextFieldConfig(txtPlantingArea, ConstantsLanguage.PLANTED_AREA_HOLD, ConstantsLanguage.PLANT_AREA);
		setTextFieldConfig(txtCosts, ConstantsLanguage.COST_SALE_HOLD, ConstantsLanguage.COSTS);

		txtTons.setPreferredSize(new Dimension(400,45));
		txtTons.setModel(new SpinnerNumberModel(10, 5, 10000, 10));

		btnAddCroop.buttonTextIcon(ConstantsView.ADD_WHITE, ConstantsLanguage.CREATE_CROP, ConstantsView.GREEN, false, ConstantsView.BAUHAUS_15, Color.WHITE);
		btnAddCroop.addActionListener(acl);
		btnAddCroop.setActionCommand(Command.MODIFY.name());
		btnAddCroop.setPreferredSize(new Dimension(200,45));

		btnCancel.buttonTextIcon(ConstantsView.CANCEL, ConstantsLanguage.CANCEL, Color.RED, false, ConstantsView.BAUHAUS_15, Color.WHITE);
		btnCancel.setActionCommand(Command.CANCEL_MODIFY.name());
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
		this.add(txtIdCrop,gbc);
		
		gbc.gridx = 0;
		gbc.gridy =2;
		gbc.gridwidth =2;
		this.add(txtNameCrop,gbc);

		gbc.gridx = 0;
		gbc.gridy =3;
		gbc.gridwidth =2;
		jcTypeCroop.addItem("P-VERDE");
		jcTypeCroop.addItem("G-SECO");
		jcTypeCroop.addItem("TUBER");
		jcTypeCroop.addItem("VERDE");
		jcTypeCroop.addItem("SEMILLA");
		jcTypeCroop.addItem("H-SECA");
		jcTypeCroop.addItem("Fruta");
		this.add(jcTypeCroop,gbc);

		gbc.gridx =0;
		gbc.gridwidth =4;
		gbc.gridy =3;
		this.add(txtPrice,gbc);

		gbc.gridx =0;
		gbc.gridy =5;
		gbc.gridwidth =2;
		this.add(txtCropArea,gbc);

		gbc.gridx =0;
		gbc.gridy =6;
		gbc.gridwidth =2;
		this.add(txtPlantingArea,gbc);

		gbc.gridx =0;
		gbc.gridy =7;
		gbc.gridwidth =2;
		this.add(txtCosts,gbc);

		gbc.gridx =0;
		gbc.gridy =8;
		gbc.gridwidth =2;
		this.add(txtTons,gbc);

		gbc.gridx =0;
		gbc.gridy =9;
		gbc.gridwidth =1;
		this.add(btnAddCroop,gbc);

		gbc.gridx =1;
		gbc.gridwidth =1;
		gbc.gridy =10;
		this.add(btnCancel,gbc);
	}

	public void setTextFieldConfig(JTextField field, String hold, String title) {
		field.setPreferredSize(new Dimension(400,45));
		field.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(title)));
		setHolder(new PlaceHolder(field, HandlerLanguage.languageProperties.getProperty(hold)));
	}

	public void modifyCroop() {
		int idCroopModify = Integer.parseInt(txtIdCrop.getText());
		CropTransitory croopNew = new CropTransitory(Integer.parseInt(txtIdCrop.getText()), txtNameCrop.getText(),txtCropArea.getText(), txtPlantingArea.getText(), txtTons.getValue().toString(), jcTypeCroop.getSelectedItem().toString(), txtPrice.getText(), txtCosts.getText());
		CropManager.modifyCroop(croopNew,idCroopModify);
	}

	public void changeLanguage() {
		jcTypeCroop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder (10, 10, 10, 10, Color.WHITE), HandlerLanguage.languageProperties.getProperty(ConstantsLanguage.TYPE_AL)));
		setTextFieldConfig(txtNameCrop, ConstantsLanguage.NAME_CROP_HOLD, ConstantsLanguage.CROP);
		setTextFieldConfig(txtPrice, ConstantsLanguage.PRICE_CROP_HOLD, ConstantsLanguage.PRICE);
		setTextFieldConfig(txtCropArea, ConstantsLanguage.HARVESTED_AREA_HOLD, ConstantsLanguage.HARV_AREA);
		setTextFieldConfig(txtPlantingArea, ConstantsLanguage.PLANTED_AREA_HOLD, ConstantsLanguage.PLANT_AREA);
		setTextFieldConfig(txtCosts, ConstantsLanguage.COST_SALE_HOLD, ConstantsLanguage.COSTS);
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
