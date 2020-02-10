package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Locale;

import org.json.simple.DeserializationException;

import general.HandlerLanguage;
import models.CropManager;
import models.CropTransitory;
import persistence.Manager;
import view.JDialogAddCrop;
import view.PrinFrame;
import view.ReportConutTypeCultive;
import view.ReportTypeCropVsAreaHarv;
import view.ReportTypeCropVsAreaPlant;

public class AppManager implements ActionListener{

	private static final String NAME_FILE_CONFIG = "config.init";
	private HandlerLanguage config = null;
	private String languageDefault;
	private PrinFrame frame;
	private JDialogAddCrop jDialog;
	public CropManager cropManager; 
	public Manager fileM;
	private ReportTypeCropVsAreaHarv reportHarv;
	private ReportTypeCropVsAreaPlant reportPlant;
	private ReportConutTypeCultive reportCount;

	public AppManager() throws DeserializationException, IOException {
		loadConfiguration();
		fileM = new Manager();
		frame = new PrinFrame(this);	
		jDialog = new JDialogAddCrop(this);
		reportHarv = new ReportTypeCropVsAreaHarv(this);
		reportPlant = new ReportTypeCropVsAreaPlant(this);
		reportCount = new ReportConutTypeCultive(this);
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
		jDialog.changeLanguage();
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
			jDialog.newCrop();
			addElementsToTable();
			jDialog.setVisible(false);
			break;
		case ADD_CROOP:
			jDialog.setVisible(true);
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
			break;
		case REPORT_COUNT:
			reportCount.setVisible(true);
			break;
		case ACCEPT:
			reportHarv.dispose();;
			reportPlant.dispose();
			reportCount.dispose();
			break;
		case CANCEL:
			jDialog.dispose();
			break;
		default:
			break;
		}
	}	
}
