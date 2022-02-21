package es.iestetuan.dvj.MongoDB;

import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import es.iestetuan.dvj.dao.ILinea;
import es.iestetuan.dvj.vo.Linea;

public class LineaMongoDB implements ILinea {

	public void crear(Linea linea) {
		
		MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		MongoDatabase mongoDB = mongo.getDatabase("RedMetro");
		MongoCollection<Document> mongoCollection = mongoDB.getCollection("Metro");

		Document colorMongo = new Document();
		colorMongo.put("_id", linea.getColor().getCodColor());
		colorMongo.put("nombre", linea.getColor().getNombre());
		colorMongo.put("codigoHexadecimal", linea.getColor().getCodHexadecimal());
		
		Document lineaMongo = new Document();
		lineaMongo.put("_id", linea.getCodLinea());
		lineaMongo.put("nombreCorto", linea.getNombreCorto());
		lineaMongo.put("nombreLargo", linea.getNombreLargo());
		lineaMongo.append("color", colorMongo);
		lineaMongo.put("kilometros", linea.getKilometros());
		lineaMongo.put("url", linea.getUrl());
		
		mongoCollection.insertOne(lineaMongo);
		

	}

	public void modificar(Linea linea) {
		// TODO Auto-generated method stub

	}

	public void eliminar(Linea linea) {
		// TODO Auto-generated method stub

	}

	public Linea getLineasporCod(int codLinea) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Linea> getListaLineas() {
		// TODO Auto-generated method stub
		return null;
	}

}
