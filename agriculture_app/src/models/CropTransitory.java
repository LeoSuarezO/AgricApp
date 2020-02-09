package models;

public class CropTransitory {

	private String crop;
	private String harvestedArea;
	private String tons;
	private String plantedArea;
	private String stateProd;
	private String priceProd;
	private String costs;


	public CropTransitory(String crop, String harvestedArea, String plantedArea, String tons, String stateProd, String priceProd, String costs) {
		this.crop = crop;
		this.harvestedArea = harvestedArea;
		this.plantedArea = plantedArea;
		this.tons = tons;
		this.stateProd = stateProd;
		this.priceProd = priceProd;
		this.costs = costs;
	}
	
	public Object[] toObjectVector(){
		return new Object[] {crop, stateProd, priceProd, harvestedArea, plantedArea, costs, tons};
	}

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public String getHarvestedArea() {
		return harvestedArea;
	}

	public void setHarvestedArea(String harvestedArea) {
		this.harvestedArea = harvestedArea;
	}

	public String getTons() {
		return tons;
	}

	public void setTons(String tons) {
		this.tons = tons;
	}

	public String getPlantedArea() {
		return plantedArea;
	}

	public void setPlantedArea(String plantedArea) {
		this.plantedArea = plantedArea;
	}


	public String getStateProd() {
		return stateProd;
	}

	public void setStateProd(String stateProd) {
		this.stateProd = stateProd;
	}

	public String getPriceProd() {
		return priceProd;
	}

	public void setPriceProd(String priceProd) {
		this.priceProd = priceProd;
	}

	public String getCosts() {
		return costs;
	}

	public void setCosts(String costs) {
		this.costs = costs;
	}
	
	public String toString() {
	return "nombre cultivo" +  crop + "\n" + 
			"tipo cultivo" +  stateProd + "\n" +
			"precio" +  priceProd + "\n" +
			"area cosecha" +  harvestedArea + "\n" +
			"area siembra" +  plantedArea + "\n" +
			"costo" +  costs + "\n" +
			"toneladas" +  tons + "\n" ;
	}

}
