package controlador;
import modelo.Modelo;
import vista.Bienvenida;
import vista.Login;

public class Main {

	public static void main(String[] args) {
		Controlador miControlador = new Controlador();
		Modelo miModelo = new Modelo();
		Login miLogin = new Login();
		Bienvenida miBienvenida = new Bienvenida();
		
		miControlador.setModelo(miModelo);
		miControlador.setBienvenida(miBienvenida);
		miControlador.setLogin(miLogin);
		miControlador.setVentanaActiva(miLogin);
		
		miModelo.setVista(miLogin);
		
		miLogin.setControlador(miControlador);
		miLogin.setModelo(miModelo);
		
		miBienvenida.setControlador(miControlador);
		miBienvenida.setModelo(miModelo);
		
		miLogin.setVisible(true);
	}

}
