package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.ConstantsView;

public class PanelPrin extends JPanel{

	private static final long serialVersionUID = 1L;
	private PanelNorth panelL;
	private MenuBar menu;
	private PanelTable table;
	private JPanel panelNorth;
	private JPanel aux;
	private PanelFooter panelF;
	private PanelAdmData panelAdmData;
	private JLabel lblImage;

	public PanelPrin(ActionListener acl) {
		setLayout(new BorderLayout());
		init(acl);
	}

	public void init(ActionListener acl) {
		panelNorth = new JPanel();
		panelL = new PanelNorth(acl);
		menu = new MenuBar(acl);
		table = new PanelTable();
		aux = new JPanel();
		lblImage = new JLabel();
		panelF = new PanelFooter(acl);
		panelAdmData = new PanelAdmData(acl);
		config();
	}

	private void config() {
		panelNorth.setLayout(new BorderLayout());
		panelNorth.setBackground(Color.white);
		panelNorth.add(panelL, BorderLayout.NORTH);
		panelNorth.add(menu, BorderLayout.CENTER);
		lblImage.setIcon(new ImageIcon(ConstantsView.CENTER));
		aux.add(lblImage);
		add(panelF, BorderLayout.SOUTH);
		add(panelNorth, BorderLayout.NORTH);
		add(aux, BorderLayout.CENTER);
	}

	public void changePanelT() {
		this.remove(aux);
		aux = table;
		add(aux, BorderLayout.CENTER);
	}

	public void changePanelAdm() {
		this.remove(aux);
		aux = panelAdmData;
		add(panelAdmData, BorderLayout.CENTER);
	}

	public void addElementToTable(Object [] obj) {
		table.addElementToTable(obj);
	}

	public void changeLanguage() {
		panelL.changeLanguge();
		menu.changeLanguage();
		table.changeLanguage();
		panelF.changeLanguage();
		panelAdmData.changeLanguage();
	}

}
