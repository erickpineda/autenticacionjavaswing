package net.erickpineda.autenticacionjavaswing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

/**
 * 
 * @author Erick Pineda - Autenticacion Java Swing.
 *
 */

public class App extends JFrame {

	/**
	 * ID del objeto.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Seráel Panel que estará dentro del frame, y llevará los botnes y demás
	 * componentes.
	 */
	private JPanel contentPane;
	/**
	 * Campo de texto donde el usuario escribe la contraseña.
	 */
	private JPasswordField textPass;
	/**
	 * Campo de texto, donde el usuario escribe el nombre de usuario.
	 */
	private JTextField textUser;
	/**
	 * Logo del programa o Frame.
	 */
	private String logo = "src/main/resources/mantis.png";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setResizable(false);
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(logo));
		setTitle("Sistema de login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();

		contentPane.setBorder(new CompoundBorder(null, new TitledBorder(
				new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)),
				"Iniciar sesi\u00F3n", TitledBorder.CENTER, TitledBorder.TOP,
				null, new Color(0, 0, 0))));

		setContentPane(contentPane);
		contentPane
				.setLayout(new FormLayout(new ColumnSpec[] {
						ColumnSpec.decode("51px"), ColumnSpec.decode("56px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("86px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("36px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("86px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("57px"), }, new RowSpec[] {
						RowSpec.decode("21px"), RowSpec.decode("23px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		contentPane.setSize(240, 400);

		JLabel lblUsuario = new JLabel("Usuario");
		contentPane.add(lblUsuario, "4, 8, left, center");

		textUser = new JTextField();
		textUser.setColumns(10);
		contentPane.add(textUser, "6, 8, 3, 1, default, center");

		JLabel lblPassword = new JLabel("Contraseña");
		contentPane.add(lblPassword, "4, 10, left, center");

		textPass = new JPasswordField();
		textPass.setColumns(10);
		contentPane.add(textPass, "6, 10, 3, 1, default, center");

		JButton btnLogin = new JButton("Login");

		btnLogin.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				clickLogin(textUser.getText(), textPass.getText());
			}
		});

		contentPane.add(btnLogin, "4, 14");

		JButton btnCancelar = new JButton("Cancelar");

		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(null,
						"¿Quieres cancelar el inicio de sesión?",
						"Salir del login", JOptionPane.YES_NO_OPTION);

				if (answer == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		contentPane.add(btnCancelar, "8, 14");
		setLocationRelativeTo(null);
	}

	public void clickLogin(String myUser, String myPass) {

		if (myUser.length() > 0 && myPass.length() > 0) {

			if (Accion.checkUserPass(myUser, myPass) == true) {

				JPanelImg escogerImg = new JPanelImg();

				JOptionPane.showConfirmDialog(null, escogerImg,
						"Escoge una imágen", JOptionPane.OK_CANCEL_OPTION);

				Accion actua = new Accion();
				actua.inicio(myUser, myPass, escogerImg.checkImg());
				
				//Accion.writeCheck(myUser, myPass, escogerImg.checkImg());

			} else {
				JOptionPane.showMessageDialog(null,
						"Error Username / Password", "Incorrecto",
						JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Error Write Username / Password", "Error null values",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}