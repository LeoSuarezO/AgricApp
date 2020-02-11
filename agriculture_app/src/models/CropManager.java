package models;

import java.util.ArrayList;

public class CropManager {

	public static  ArrayList<CropTransitory> listCropTr = new ArrayList<CropTransitory>();
	public static  ArrayList<CropTransitory> listNewCrops = new ArrayList<CropTransitory>();

	public CropManager() {
		listCropTr = new ArrayList<CropTransitory>();
	}

	public static  void createCropTr(CropTransitory crop) {
		listCropTr.add(crop);
	}
	
	public static void newCrops(String crop, String harvestedArea, String plantedArea, String tons, String stateProd, String priceProd, String costs) {
		listNewCrops.add(new CropTransitory(crop, harvestedArea, plantedArea, tons, stateProd, priceProd, costs));
	}
	
	

	public static  ArrayList<CropTransitory> getListCropTr() {
		return listCropTr;
	}

	public void setListCropTr(ArrayList<CropTransitory> listCropTr) {
		CropManager.listCropTr = listCropTr;
	}
}