package net.erickpineda.autenticacionjavaswing;

import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPanelImg extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String caraCarta;
	private boolean click = false;
	/**
	 * Create the panel.
	 */
	public JPanelImg() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnCorazon = new JButton("");
		btnCorazon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				caraCarta = "corazon";
				checkImg();
			}
		});
		btnCorazon.setIcon(new ImageIcon("src/main/resources/corazon.png"));
		add(btnCorazon);

		JButton btnPica = new JButton("");
		btnPica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				caraCarta = "pica";
				checkImg();
			}
		});
		btnPica.setIcon(new ImageIcon("src/main/resources/pica.png"));
		add(btnPica);

		JButton btnDiamante = new JButton("");
		btnDiamante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				caraCarta = "diamante";
				checkImg();
			}
		});
		btnDiamante.setIcon(new ImageIcon("src/main/resources/diamante.png"));
		add(btnDiamante);

		JButton btnTrebol = new JButton("");
		btnTrebol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				caraCarta = "trebol";
				checkImg();
			}
		});
		btnTrebol.setIcon(new ImageIcon("src/main/resources/trebol.png"));
		add(btnTrebol);
	}

	public String checkImg() {
		System.out.println("boton corazon clic" + caraCarta);
		click = true;
		return caraCarta;
	}
	
	public boolean onClick(){
		return click;
	}
}
