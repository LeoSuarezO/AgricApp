package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import constants.ConstantsLanguage;
import controller.AppManager;
import controller.Command;

public class JDialogAddCroop extends JDialog{

	private static final long serialVersionUID = 1L;
	private JTextField txtNameCroop;
	private JComboBox<String> jcTypeCroop;
	private JTextField txtPrice;
	private JTextField txtCropArea;
	private JTextField txtPlantingArea;
	private JTextField txtCosts;
	private JTextField txtTons;
	private ConfigButton btnAddCroop;
	private ConfigButton btnCancel;

	public JDialogAddCroop(AppManager control) {
		this.setBackground(Color.WHITE);
		this.setBackground(Color.WHITE);		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		this.setSize( 500, 500 );
		initComponents(control);
		addComponents();
		this.setVisible(true);
		this.setBackground(Color.BLACK);
	}

	private void initComponents(AppManager control) {
		txtNameCroop = new JTextField(ConstantsLanguage.NAME_CROOP);
		txtNameCroop.setPreferredSize(new Dimension(400,45));
		
		jcTypeCroop = new JComboBox<String>();
		jcTypeCroop.setPreferredSize(new Dimension(400,85));
		jcTypeCroop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder (10, 10,
				10, 10, Color.WHITE), ConstantsLanguage.TYPE_CROOP));
		jcTypeCroop.setBackground(Color.WHITE);

		txtPrice = new JTextField(ConstantsLanguage.PRICE_CROOP);
		txtPrice.setPreferredSize(new Dimension(400,45));

		txtCropArea = new JTextField(ConstantsLanguage.HARVESTED_AREA);
		txtCropArea.setPreferredSize(new Dimension(400,45));

		txtPlantingArea = new JTextField(ConstantsLanguage.SOWN_AREA);
		txtPlantingArea.setPreferredSize(new Dimension(400,45));

		txtCosts = new JTextField(ConstantsLanguage.COST_SALE);
		txtCosts.setPreferredSize(new Dimension(400,45));

		txtTons = new JTextField(ConstantsLanguage.TONS_ADD);
		txtTons.setPreferredSize(new Dimension(400,45));
		
		btnAddCroop = new ConfigButton();
		btnAddCroop.txt(ConstantsLanguage.ADD_CROP,Color.WHITE,Color.black);
		btnAddCroop.addActionListener(control);
		btnAddCroop.setActionCommand(Command.CREATE_CROOP.name());
		btnAddCroop.setPreferredSize(new Dimension(200,45));

		btnCancel = new ConfigButton();
		btnCancel.txt(ConstantsLanguage.CANCEL,Color.WHITE,Color.black);
		btnCancel.setPreferredSize(new Dimension(200,75));
	}

	private void addComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx =0;
		gbc.gridwidth =2;
		gbc.gridy =0;
		this.add(txtNameCroop,gbc);

		gbc.gridx =0;
		gbc.gridwidth =2;
		gbc.gridy =1;
		jcTypeCroop.addItem("P-VERDE");
		jcTypeCroop.addItem("G-SECO");
		jcTypeCroop.addItem("TUBER");
		jcTypeCroop.addItem("VERDE");
		jcTypeCroop.addItem("SEMILLA");
		jcTypeCroop.addItem("H-SECA");
		this.add(jcTypeCroop,gbc);

		gbc.gridx =0;
		gbc.gridwidth =2;
		gbc.gridy =2;
		this.add(txtPrice,gbc);

		gbc.gridx =0;
		gbc.gridy =3;
		gbc.gridwidth =2;
		this.add(txtCropArea,gbc);

		gbc.gridx =0;
		gbc.gridy =4;
		gbc.gridwidth =2;
		this.add(txtPlantingArea,gbc);

		gbc.gridx =0;
		gbc.gridy =5;
		gbc.gridwidth =2;
		this.add(txtCosts,gbc);

		gbc.gridx =0;
		gbc.gridy =6;
		gbc.gridwidth =2;
		this.add(txtTons,gbc);

		gbc.gridx =0;
		gbc.gridy =7;
		gbc.gridwidth =1;
		this.add(btnAddCroop,gbc);

		gbc.gridx =1;
		gbc.gridwidth =1;
		gbc.gridy =7;
		this.add(btnCancel,gbc);
	}
	
	public String getTxtCosts() {
		return txtCosts.getText();
	}

	public String getTxtCropArea() {
		return txtCropArea.getText();
	}

	public String getTxtNameCroop() {
		return txtNameCroop.getText();
	}

	public String getTxtPlantingArea() {
		return txtPlantingArea.getText();
	}

	public String getTxtPrice() {
		return txtPrice.getText();
	}

	public String getTxtTons() {
		return txtTons.getText();
	}

	public String getJcTypeCroop() {
		return "" + jcTypeCroop.getSelectedItem();
	}
}