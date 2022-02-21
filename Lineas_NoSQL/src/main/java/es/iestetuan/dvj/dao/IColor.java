package es.iestetuan.dvj.dao;


import java.util.List;

import es.iestetuan.dvj.vo.Color;

public interface IColor {

	public void Crear(Color color);
	public void Modificar(Color color);
	public void Eliminar(Color color);
	public Color buscarporID(int codColor);
	public List<Color>consultarLista();
}
