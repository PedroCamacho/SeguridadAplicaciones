package vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;
import modelo.Modelo;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Login extends JFrame implements Vistas{
	private Controlador miControlador;
	private Modelo miModelo;
	
	private JTextField txtUsr;
	private JPasswordField txtPwd;
	private JButton btnLogin;
	private JLabel lblRespuesta;
	private JRadioButton rdbtnOracle;
	private JRadioButton rdbtnMySQL;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public Login () {
		setTitle("Login MVC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblUsr = new JLabel("Usuario:");
		lblUsr.setBounds(60, 74, 93, 14);
		getContentPane().add(lblUsr);
		
		JLabel lblPwd = new JLabel("Clave:");
		lblPwd.setBounds(60, 113, 93, 14);
		getContentPane().add(lblPwd);
		
		txtUsr = new JTextField();
		txtUsr.setBounds(143, 71, 109, 20);
		getContentPane().add(txtUsr);
		txtUsr.setColumns(10);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(143, 110, 109, 20);
		getContentPane().add(txtPwd);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miControlador.login();
			}
		});
		btnLogin.setBounds(143, 156, 109, 23);
		getContentPane().add(btnLogin);
		
		lblRespuesta = new JLabel("");
		lblRespuesta.setForeground(Color.RED);
		lblRespuesta.setBounds(60, 138, 212, 14);
		getContentPane().add(lblRespuesta);
		
		rdbtnOracle = new JRadioButton("Oracle");
		rdbtnOracle.setSelected(true);
		buttonGroup.add(rdbtnOracle);
		rdbtnOracle.setBounds(283, 70, 109, 23);
		getContentPane().add(rdbtnOracle);
		
		rdbtnMySQL = new JRadioButton("MySQL");
		buttonGroup.add(rdbtnMySQL);
		rdbtnMySQL.setBounds(283, 109, 109, 23);
		getContentPane().add(rdbtnMySQL);
	}
	
	public String getUsr() {
		return txtUsr.getText();
	}

	public String getPwd() {
		return String.valueOf(txtPwd.getPassword());
	}
	
	public String getSGBD() {
		String respuesta = "Oracle";
		if (rdbtnMySQL.isSelected()) {
			respuesta="MySQL";
		}
		return respuesta;
	}

	public void actualizar() {
		String resultado = miModelo.getResultado();
		if (resultado.equals("Correcto")) {
			lblRespuesta.setText("");
			miControlador.cambiarBienvenida();
		} else if (resultado.equals("Incorrecto")) {
			lblRespuesta.setText("Usario o contraseña incorrectos");
		} else {
			System.exit(0);
		}
	}
	
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
}
