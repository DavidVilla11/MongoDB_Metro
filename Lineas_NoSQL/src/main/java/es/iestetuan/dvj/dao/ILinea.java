package es.iestetuan.dvj.dao;

import java.util.List;

import es.iestetuan.dvj.vo.Linea;

public interface ILinea {

	public void crear(Linea linea);
	public void modificar(Linea linea);
	public void eliminar(Linea linea);	
	public Linea getLineasporCod(int codLinea);
	public List<Linea> getListaLineas();
}
