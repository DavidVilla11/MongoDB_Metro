package es.iestetuan.dvj;

import es.iestetuan.dvj.JSON.LineaJSON;
import es.iestetuan.dvj.MongoDB.LineaMongoDB;
import es.iestetuan.dvj.utilidades.ParseoJackson;
import es.iestetuan.dvj.vo.Color;
import es.iestetuan.dvj.vo.Linea;

public class AppPruebaProyecto {

	public static void main(String[] args) {

		LineaMongoDB crearMongo = new LineaMongoDB();
		ParseoJackson parseo = new ParseoJackson();
		LineaJSON[] lineas = parseo.obtenerLineasURL();
		
		
		for(LineaJSON item : lineas) {
			
			Color color = new Color();
			Linea linea = new Linea();
			
			color.setCodColor(item.getColor().getCodigocolor());
			color.setNombre(item.getColor().getNombre());
			color.setCodHexadecimal(item.getColor().getCodhexadecimal());
			
			linea.setCodLinea(item.getCodigoLinea());
			linea.setNombreCorto(item.getNombreCorto());
			linea.setNombreLargo(item.getNombreLargo());
			linea.setColor(color);
			linea.setKilometros(item.getKilometros());
			linea.setUrl(item.getUrl());
			crearMongo.crear(linea);
		}
		
		
		//NO TENGO TIEMPO PARA MAS
	}

}
