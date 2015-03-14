package net.erickpineda.autenticacionjavaswing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.Color;

public class InterfazUsuario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5398465102210200089L;
	public static String caraCarta;
	private boolean click = false;
	private JLabel mensajeBienvenida;

	/**
	 * Create the panel.
	 */
	public InterfazUsuario() {
		setLayout(new MigLayout("", "[123px][][][][123px][]",
				"[125px][125px][][][][]"));

		mensajeBienvenida = new JLabel("Bienvenido Usuario!");
		mensajeBienvenida.setForeground(Color.RED);
		mensajeBienvenida.setFont(new Font("Arial", Font.BOLD, 12));
		add(mensajeBienvenida, "cell 0 0 6 1,alignx center,aligny center");

		JButton btnCorazon = new JButton("");
		btnCorazon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				caraCarta = "corazon";
				checkImg();
			}
		});
		btnCorazon.setIcon(new ImageIcon("src/main/resources/corazon.png"));
		add(btnCorazon, "cell 1 1,alignx left,aligny center");

		JButton btnDiamante = new JButton("");
		btnDiamante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				caraCarta = "diamante";
				checkImg();
			}
		});

		JButton btnPica = new JButton("");
		btnPica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				caraCarta = "pica";
				checkImg();
			}
		});
		btnPica.setIcon(new ImageIcon("src/main/resources/pica.png"));
		add(btnPica, "cell 3 1,alignx left,aligny center");
		btnDiamante.setIcon(new ImageIcon("src/main/resources/diamante.png"));
		add(btnDiamante, "cell 1 3,alignx left,aligny center");

		JButton btnTrebol = new JButton("");
		btnTrebol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				caraCarta = "trebol";
				checkImg();
			}
		});
		btnTrebol.setIcon(new ImageIcon("src/main/resources/trebol.png"));
		add(btnTrebol, "cell 3 3,alignx left,aligny center");
	}

	public void setMensajeBienvenida(String user) {
		mensajeBienvenida.setText("Bienvenido " + user);
	}

	public String checkImg() {
		System.out.println("boton corazon clic" + caraCarta);
		click = true;
		return caraCarta;
	}

	public boolean onClick() {
		return click;
	}

}
