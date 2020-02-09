package persistence;

import java.io.BufferedReader;
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
		String costs;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(getHttpURLConnection(false, "https://www.datos.gov.co/resource/b9ix-pnhg.json")));
		JsonArray jsonCrops = (JsonArray) Jsoner.deserialize(buffer);
		for (int i = 0; i < jsonCrops.size(); i++) {
			JsonObject jsonCrop = (JsonObject) jsonCrops.get(i);
			crop = jsonCrop.getString("cultivos");
			harvestedArea = jsonCrop.getString("consolidado_evaluacion_ano_2013_area_cosech_ha");
			plantedArea = jsonCrop.getString("consolidado_evaluacion_ano_2013_area_sembr_ha");
			tons = jsonCrop.getString("consolidado_evaluacion_ano_2013_esperad_ton");
			stateProd = jsonCrop.getString("consolidado_evaluacion_ano_2013_del_produc");
			priceProd = jsonCrop.getString("consolidado_evaluacion_ano_2013_estado_precio_al_producr_ton");
			costs = jsonCrop.getString("consolidado_evaluacion_ano_2013_costos_de_produc_ha");
			CropManager.createCropTr(crop, harvestedArea, plantedArea, tons, stateProd, priceProd, costs);
		}
		
	}
}