package es.iestetuan.dvj.MongoDB;

import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import es.iestetuan.dvj.dao.IColor;
import es.iestetuan.dvj.vo.Color;

public class ColorMongoDB implements IColor {

	public void Crear(Color color) {
		
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		MongoDatabase mongoDB= mongoClient.getDatabase("RedMetro");
		MongoCollection<Document> mongoCollection = mongoDB.getCollection("Metro");
		
		Document colorMongo = new Document();
		colorMongo.put("_id", color.getCodColor());
		colorMongo.put("nombre", color.getNombre());
		colorMongo.put("codigoHexadecimal",color.getCodHexadecimal());
		
		mongoCollection.insertOne(colorMongo);
	}

	public void Modificar(Color color) {
		// TODO Auto-generated method stub
		
	}

	public void Eliminar(Color color) {
		// TODO Auto-generated method stub
		
	}

	public Color buscarporID(int codColor) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Color> consultarLista() {
		// TODO Auto-generated method stub
		return null;
	}

}
