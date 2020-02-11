package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Locale;

import org.json.simple.DeserializationException;

import general.HandlerLanguage;
import models.CropManager;
import models.CropTransitory;
import persistence.Manager;
import view.JDialogAddCrop;
import view.JDialogDeleteCroop;
import view.JDialogModifyCroop;
import view.PrinFrame;
import view.ReportCountTypeCultive;
import view.ReportTypeCropVsAreaHarv;
import view.ReportTypeCropVsAreaPlant;

public class AppManager implements ActionListener, ItemListener{

	private static final String NAME_FILE_CONFIG = "config.init";
	private HandlerLanguage config = null;
	private String languageDefault;
//<<<<<<< HEAD
	private static PrinFrame frame;
	private JDialogAddCrop jDialogAdd;
	private JDialogModifyCroop jDialogModify;
	private JDialogDeleteCroop jDialogDelete;
//=======
//	private PrinFrame frame;
	private JDialogAddCrop jDialog;
//>>>>>>> branch 'master' of https://github.com/LeoSuarezO/AgricApp.git
	public CropManager cropManager; 
	public Manager fileM;
	private ReportTypeCropVsAreaHarv reportHarv;
	private ReportTypeCropVsAreaPlant reportPlant;
	private ReportCountTypeCultive reportCount;

	public AppManager() throws DeserializationException, IOException {
		loadConfiguration();
		fileM = new Manager();
//<<<<<<< HEAD
//		frame = new PrinFrame(this);
		jDialogDelete = new JDialogDeleteCroop(this);
		jDialogAdd = new JDialogAddCrop(this);
		jDialogModify = new JDialogModifyCroop(this);
//=======
		frame = new PrinFrame(this, this);	
		jDialog = new JDialogAddCrop(this);
//>>>>>>> branch 'master' of https://github.com/LeoSuarezO/AgricApp.git
		reportHarv = new ReportTypeCropVsAreaHarv(this);
		reportPlant = new ReportTypeCropVsAreaPlant(this);
		reportCount = new ReportCountTypeCultive(this);
	}

	public void addElementsToTable() {
		for (int i = 0; i < CropManager.getListCropTr().size(); i++) {
			CropTransitory crop = CropManager.getListCropTr().get(i);
			frame.addElementToTable(crop.toObjectVector());
		}
	}
	

	public void changePanelT() {
		frame.changePanelT();
	}

	public void changePanelAdm() {
		frame.changePanelAdm();
	}
	
	public String getLanguageDefault(){
		languageDefault = Locale.getDefault().getLanguage();
		switch (languageDefault) {
		case "es":
			return "Spanish";
		case "us":
			return "English";
		}
		return "Spanish";
	}

	public void loadLanguage() throws IOException{
		try {
			config.loadLanguage();
		} catch (Exception e) {			
		}
	}

	public void saveConfig() throws IOException{
		try {
			new HandlerLanguage(NAME_FILE_CONFIG).saveLanguage();
		} catch (Exception e) {
		}
	}

	public void changeToEnglish() throws IOException{
		HandlerLanguage.language = "language/languageUS.properties";
		saveConfig();
		loadLanguage();		
	}

	public void changeToSpanish() throws IOException{
		HandlerLanguage.language = "language/languageES.properties";
		saveConfig();
		loadLanguage();
	}

	public void loadConfiguration(){
		if(config == null){
			config = new HandlerLanguage(NAME_FILE_CONFIG);
		}
		try{
			config.loadLanguage();
		}catch(IOException e){
			System.err.println("file not found : NAME_FILE_CONFIG");
		}
	}

	private void manageChangeLanguageUS(){
		try {
			changeToEnglish();
		} catch (IOException e1) {
			e1.printStackTrace();
		}			
		manageChangeLanguage();

	}

	private void manageChangeLanguageES(){
		try {
			changeToSpanish();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		manageChangeLanguage();	
	}

	private void manageChangeLanguage(){
		frame.changeLanguage();
		jDialogAdd.changeLanguage();
		reportCount.changeLanguage();
		reportHarv.changeLanguage();
		reportPlant.changeLanguage();
	}
	

	public void changePanelReport() {
		frame.changePanelReport();
	}
	
	public void exportNewCrops() throws IOException {
		fileM.writeNewCrops();
		frame.succes();
	}
	
	public void accept() {
		reportHarv.dispose();
		reportPlant.dispose();
		reportCount.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		switch (Command.valueOf(e.getActionCommand())) {
		case LANGUAGE_ES:
			manageChangeLanguageES();
			break;
		case LANGUAGE_ENG:
			manageChangeLanguageUS();
			break;
		case DATA:
			changePanelT();
			addElementsToTable();
			break;
		case MANAGE_DATA:
			changePanelAdm();
			break;
		case HOME:
			
			break;
		case CREATE_CROOP:
			jDialogAdd.newCrop();
			addElementsToTable();
			jDialogAdd.setVisible(false);
			break;
		case MODIFY:
			jDialogModify.modifyCroop();
			addElementsToTable();
			jDialogModify.setVisible(false);
			break;
		case DELETE:
			jDialogDelete.deleteCroop();
			addElementsToTable();
			jDialogDelete.setVisible(false);
		case ADD_CROOP:
			jDialogAdd.setVisible(true);
			break;
		case DELETE_CROOP:
			jDialogDelete.setVisible(true);
			break;
		case EXPORT:
			try {
				exportNewCrops();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		case REPORTS:
			changePanelReport();
			break;
		case REPORT_HARV:
			reportHarv.setVisible(true);
			break;
		case REPORT_PLANT:
			reportPlant.setVisible(true);
			break;
		case REPORT_FILTER:
			frame.changePanelFilter();
			break;
		case REPORT_COUNT:
			reportCount.setVisible(true);
			break;
		case ACCEPT:
			accept();
			break;
		case CANCEL:
			jDialogAdd.dispose();
			break;
		case EDITE_CROOP:
			jDialogModify.setVisible(true);
			break;		
		default:
			break;
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		frame.changePanelFilter();
		for (int i = 0; i < CropManager.getListCropTr().size(); i++) {
			CropTransitory crop = CropManager.getListCropTr().get(i);
			if(frame.getSelecItemFilter().equals("Fruta")) {
					if(crop.getStateProd().equals("FRUTA")) {
						frame.addElementsToTableFilter(crop.toObjectVector());
					}
				}
				if(frame.getSelecItemFilter().equals("Verde")) {
					if(crop.getStateProd().equals("VERDE")) {
						frame.addElementsToTableFilter(crop.toObjectVector());
					}
				}
				if(frame.getSelecItemFilter().equals("Semilla")) {
					if(crop.getStateProd().equals("SEMILLA")) {
						frame.addElementsToTableFilter(crop.toObjectVector());
					}
				}
			}
	}	
}
