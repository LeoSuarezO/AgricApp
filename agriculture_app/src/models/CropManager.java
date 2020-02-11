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
	public boolean check(int idCroop) {
		for (int i = 0; i < listCropTr.size(); i++) {
			if (listCropTr.get(i).getIdCroop() == idCroop) {
				return true;
			}
		}
		return false;
	}
	public static void modifyCroop(CropTransitory croop,int idCroop) {
		for (int i = 0; i < listCropTr.size(); i++) {
			if (listCropTr.get(i).getIdCroop() == idCroop) {
				listCropTr.set(i, croop);
			}
		}
	}

	public static void newCrops(int id, String crop, String harvestedArea, String plantedArea, String tons, String stateProd, String priceProd, String costs) {
		listNewCrops.add(new CropTransitory(id, crop, harvestedArea, plantedArea, tons, stateProd, priceProd, costs));
	}

	public void deleteCroop(int idCroop) {
		for (int i = 0; i < listCropTr.size(); i++) {
			if (listCropTr.get(i).getIdCroop() == idCroop) {
				listCropTr.remove(i);
			}
		}
	}


	public static  ArrayList<CropTransitory> getListCropTr() {
		return listCropTr;
	}

	public void setListCropTr(ArrayList<CropTransitory> listCropTr) {
		CropManager.listCropTr = listCropTr;
	}
}