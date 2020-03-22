package vista;

import controlador.Controlador;
import modelo.Modelo;

public interface Vistas {

	public void setControlador(Controlador miControlador);
	public void setModelo(Modelo miModelo);
	public void setVisible (boolean visible);
	
}
