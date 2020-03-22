package controlador;

import modelo.Modelo;
import vista.Bienvenida;
import vista.Login;
import vista.Vistas;

public class Controlador {
	private Modelo miModelo;
	private Login miLogin;
	private Bienvenida miBienvenida;
	private Vistas ventanaActiva;

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void setLogin(Login login) {
		this.miLogin = login;
	}

	public void setBienvenida(Bienvenida bienvenida) {
		this.miBienvenida = bienvenida;
	}

	public void setVentanaActiva(Vistas vista) {
		this.ventanaActiva = vista;
	}

	public void login() {
		String usr = miLogin.getUsr();
		String pwd = miLogin.getPwd();
		String sgbd = miLogin.getSGBD();
		miModelo.conectar(sgbd);
//		miModelo.login(usr, pwd);
		miModelo.loginSeguro(usr,pwd);
	}

	public void cambiarLogin() {
		ventanaActiva.setVisible(false);
		miLogin.setVisible(true);
		ventanaActiva = miLogin;
	}

	public void cambiarBienvenida() {
		ventanaActiva.setVisible(false);
		miBienvenida.setVisible(true);
		ventanaActiva = miBienvenida;
	}

}
