package vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bienvenida extends JFrame implements Vistas{
	private Controlador miControlador;
	private Modelo miModelo;
	
	private JPanel contentPane;

	public Bienvenida() {
		setTitle("Bievenida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenidos!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 42));
		lblNewLabel.setBounds(90, 89, 265, 90);
		contentPane.add(lblNewLabel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miControlador.cambiarLogin();
			}
		});
		btnLogout.setBounds(335, 228, 89, 23);
		contentPane.add(btnLogout);
	}
	
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
}
