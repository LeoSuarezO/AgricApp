package persistence;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import models.CropManager;
import models.CropTransitory;

public class Manager {


	public Manager() throws DeserializationException, IOException {
		readCrop();
	}

	public static InputStream getHttpURLConnection(boolean isProxy, String filePath) {
		HttpURLConnection httpURLConnection;
		URL url = null;
		InputStream inputStream = null;
		try {
			url = new URL( filePath );
			if ( !isProxy ) {
				System.out.println("Sin proxy");
				httpURLConnection = (HttpURLConnection) url.openConnection();	
				inputStream = httpURLConnection.getInputStream();
			}else {
				System.out.println("Con proxy");
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
				httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
				inputStream = httpURLConnection.getInputStream();
				if(inputStream == null )
					System.out.println( "Este input no quiere funcionar" );
			}
		}catch(ConnectException connectException) {
			isProxy = true;
			return getHttpURLConnection( isProxy, filePath );
		} catch (UnknownHostException e) {
			isProxy = true;
			System.out.println( "Catch: " + e.getMessage()  );
			return getHttpURLConnection( isProxy, filePath );
		} catch (MalformedURLException e1) {
			System.out.println(  e1.getMessage()  );
		}catch (IOException e) {
			System.out.println(  e.getMessage()  );
		}
		return inputStream;
	}


	private void readCrop() throws DeserializationException, IOException {
		String crop;
		String harvestedArea;
		String tons;
		String plantedArea;
		String stateProd;
		String priceProd;
		//kjshdfkjs
		String costs;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(getHttpURLConnection(false, "https://www.datos.gov.co/resource/b9ix-pnhg.json")));
		JsonArray jsonCrops = (JsonArray) Jsoner.deserialize(buffer);
		int count=0;
		for (int i = 0; i < jsonCrops.size(); i++) {
			JsonObject jsonCrop = (JsonObject) jsonCrops.get(i);
			crop = jsonCrop.getString("cultivos");
			harvestedArea = jsonCrop.getString("consolidado_evaluacion_ano_2013_area_cosech_ha");
			plantedArea = jsonCrop.getString("consolidado_evaluacion_ano_2013_area_sembr_ha");
			tons = jsonCrop.getString("consolidado_evaluacion_ano_2013_esperad_ton");
			stateProd = jsonCrop.getString("consolidado_evaluacion_ano_2013_del_produc");
			priceProd = jsonCrop.getString("consolidado_evaluacion_ano_2013_estado_precio_al_producr_ton");
			costs = jsonCrop.getString("consolidado_evaluacion_ano_2013_costos_de_produc_ha");
			CropTransitory croopAdd = new CropTransitory(crop, harvestedArea, plantedArea, tons, stateProd, priceProd, costs);
			count++;
			CropManager.createCropTr(croopAdd);
			croopAdd.setIdCroop(count);;

		}
	}

	public void writeNewCrops() throws IOException {
		JsonArray cropArray = new JsonArray();
		for (int i = 0; i < CropManager.listNewCrops.size(); i++) {
			JsonObject cropObject = new JsonObject();
			cropObject.put("Cultivo: ", CropManager.listNewCrops.get(i).getCrop());
			cropObject.put("Area sembrada: : ", CropManager.listNewCrops.get(i).getPlantedArea());
			cropObject.put("Area cosechada: ", CropManager.listNewCrops.get(i).getHarvestedArea());
			cropObject.put("Tipo cultivo: ", CropManager.listNewCrops.get(i).getStateProd());
			cropObject.put("Cantidad (Ton): ", CropManager.listNewCrops.get(i).getTons());
			cropObject.put("Costos: ", CropManager.listNewCrops.get(i).getCosts());
			cropObject.put("Precio producto: ", CropManager.listNewCrops.get(i).getPriceProd());
			cropArray.add(cropObject);
		}

		FileWriter fw = new FileWriter("resources/NewCrops.json");
		fw.write(cropArray.toJson());
		fw.flush();
		fw.close();

	}

	public void readStringToBinary(String url) {
		FileInputStream file = null;
		DataInputStream dataImput = null;
		String entradaString;
		try {
			file = new FileInputStream(url);
			dataImput = new DataInputStream(file);
			while (true) { 
				entradaString = dataImput.readUTF();  
				System.out.println(entradaString + "XD");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (EOFException e) {
			System.out.println("Fin de fichero");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (file != null) {
					file.close();
				}
				if (dataImput != null) {
					dataImput.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}