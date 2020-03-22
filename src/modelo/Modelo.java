package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vista.Login;

public class Modelo {
	private Login miVista;

	private String bd;
	private String login;
	private String pwd;
	private String url;
	private String driver;
	private Connection conexion;

	private String resultado;
	private int fallos;

	public void conectar(String sgbd) {
		try {
			if (sgbd.equals("Oracle"))
				configuraOracle();
			else
				configuraMySQL();
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, login, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void configuraMySQL() {
		bd = "world";
		login = "root";
		pwd = "root";
		url = "jdbc:mysql://localhost/" + bd
				+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		driver = "com.mysql.cj.jdbc.Driver";

	}

	private void configuraOracle() {
		bd = "PEDRO";
		login = "SYSTEM";
		pwd = "root";
		url = "jdbc:oracle:thin:@localhost:1521:XE";
		driver = "oracle.jdbc.driver.OracleDriver";
	}

	public void setVista(Login miVista) {
		this.miVista = miVista;
	}

	public void login(String usr, String pwd) {
		// SQL Inyection: ' or '1'='1
		String query = "SELECT * FROM " + bd + ".users WHERE usr='" + usr + "' AND pwd='" + pwd + "'";
		System.out.println(query);
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			if (rset.next()) {
				resultado = "Correcto";
				fallos = 0;
			} else {
				fallos++;
				if (fallos == 3) {
					resultado = "Cerrar";
				} else
					resultado = "Incorrecto";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		miVista.actualizar();
	}

	public void loginSeguro(String usr, String pwd) {
		String query = "SELECT * FROM " + bd + ".users WHERE usr=? AND pwd=?";

		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, usr);
			pstmt.setString(2, pwd);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				resultado = "Correcto";
				fallos = 0;
			} else {
				fallos++;
				if (fallos == 3) {
					resultado = "Cerrar";
				} else
					resultado = "Incorrecto";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		miVista.actualizar();
	}

	public String getResultado() {
		return this.resultado;
	}

}
