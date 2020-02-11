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

	private void modifyCroop(CropTransitory croop) {
		for (int i = 0; i < listCropTr.size(); i++) {
			if (listCropTr.get(i).getIdCroop() == croop.getIdCroop()) {
				listCropTr.set(i, croop);
			}
		}
	}

	public static void newCrops(String crop, String harvestedArea, String plantedArea, String tons, String stateProd, String priceProd, String costs) {
		listNewCrops.add(new CropTransitory(crop, harvestedArea, plantedArea, tons, stateProd, priceProd, costs));
	}

	private void deleteCroop(int idCroop) {
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