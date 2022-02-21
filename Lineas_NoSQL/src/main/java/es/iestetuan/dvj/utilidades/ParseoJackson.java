package es.iestetuan.dvj.utilidades;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import es.iestetuan.dvj.JSON.LineaJSON;

public class ParseoJackson {

	public LineaJSON[] obtenerLineasURL(){
		
		LineaJSON[] listaLineas = null;
		ObjectMapper mp = new JsonMapper();
		HttpClient cliente = HttpClient.newHttpClient();
		URI uri=URI.create("http://dam2.actividad.cf:55555/rest/lineas");
		HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
		
		try {
			HttpResponse<String> rsp = cliente.send(request, BodyHandlers.ofString());
			String result = rsp.body();
			listaLineas = mp.readValue(result, LineaJSON[].class);
			
		}catch(Exception err) {
			err.printStackTrace();
		}
		return listaLineas;
	}
}
