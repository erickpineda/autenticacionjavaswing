package net.erickpineda.autenticacionjavaswing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Accion {

	private static String pathFile = "/datos";
	private static String saveFile = "save";
	private static InputStream ficheroALeer;
	private static BufferedReader inFile;
	private static String user;
	private static String pass;
	private static FileWriter ficheroAEscribir;
	private static PrintWriter outFile;
	private static OutputStream fos;
	private static ObjectOutputStream oos;
	private static FileInputStream fis;
	private static ObjectInputStream ois;
	private static List<Usuario> lista;

	public Accion() {

	}

	protected void inicio(String myUser, String myPass, String myCard) {
		File miFichero = new File(saveFile);

		try {

			if (!miFichero.exists()) {
				crearFichero();
			} else {
				abrirFichero();
			}
			checkUsuario(myUser, myPass, myCard);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Crear unfichero de escritura.
	 * 
	 * @throws IOException
	 *             Excepciones de error.
	 */
	public static void crearFichero() throws IOException {

		fos = new FileOutputStream(saveFile);
		oos = new ObjectOutputStream(fos);
		System.out.println("\n<- CREANDO FICHERO DE INFORMACIÓN ->\n");
		lista = new ArrayList<Usuario>();
	}

	/**
	 * Método que abre un fichero existente y lee la información almacenada.
	 * 
	 * @throws IOException
	 *             Excepciones de error.
	 * @throws ClassNotFoundException
	 *             Si el nombre de la clase no se encuentra.
	 */
	public static void abrirFichero() throws IOException,
			ClassNotFoundException {

		System.out.println("\n*** REANUDANDO INFORMACIÓN ALMACENADA ***\n");

		fis = new FileInputStream(saveFile);
		ois = new ObjectInputStream(fis);

		lista = (List<Usuario>) ois.readObject();

	}

	protected void crearUsuario(String myUser, String myPass, String myCard) {

		lista.add(new Usuario(myUser, myPass, myCard));

	}

	private void escribirUsuarioEnFichero() throws IOException {

		System.out.println("Estoy escribiendo");

		OutputStream fos = new FileOutputStream(saveFile);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(lista);
		oos.close();
	}

	protected boolean comprobarUsuario(String myUser, String myPass) {

		boolean existe = false;

		for (Usuario u : lista) {
			if (u.getNameUser().equals(myUser) && 
					u.getNameUser().equals(myPass)) {
				existe = true;
				System.out.println("existe = " + existe);
			}
		}

		return existe;
	}

	protected void checkUsuario(String myUser, String myPass, String myCard)
			throws IOException {

		if (!comprobarUsuario(myUser,myPass) == true) {
			crearUsuario(myUser, myPass, myCard);
			escribirUsuarioEnFichero();
			
		} else {
			for (Usuario u : lista) 
				System.out.println(u);
			
		}
	}

	protected static void createUserPass(String myUser, String myPass) {
		lista.add(new Usuario(myPass, myPass));
	}

	public static boolean checkUserPass2(String myUser, String myPass) {

		boolean check = false;

		try {

			String linea;

			ficheroALeer = App.class.getResourceAsStream(pathFile.replace(
					"src/main/resources", ""));
			inFile = new BufferedReader(new InputStreamReader(ficheroALeer));

			if (inFile != null) {
				linea = inFile.readLine();

				while (linea != null) {
					String[] array = linea.split(":");

					if (myUser.equalsIgnoreCase(array[0].trim())
							&& myPass.equals(array[1].trim())) {

						lista.add(new Usuario(myPass, myPass));
						check = true;
						System.out.println(myUser + "  " + myPass);

					}

					linea = inFile.readLine();
				}

			}
			inFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	protected static String writeCheck2(String myUser, String myPass,
			String cartaEscogida) {
		try {

			for (int i = 0; i < lista.size(); i++) {
				lista.get(i).setCaraCarta(cartaEscogida);
			}

			oos.writeObject(lista);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return cartaEscogida;
	}

	public static boolean checkUserPass(String myUser, String myPass) {

		boolean check = false;

		try {

			String linea;

			ficheroALeer = App.class.getResourceAsStream(pathFile);
			inFile = new BufferedReader(new InputStreamReader(ficheroALeer));

			if (inFile != null) {
				linea = inFile.readLine();

				while (linea != null) {
					String[] array = linea.split(":");

					if (myUser.equalsIgnoreCase(array[0].trim())
							&& myPass.equals(array[1].trim())) {

						user = myUser;
						pass = myPass;
						check = true;
						System.out.println(user + "  " + pass);

					}

					linea = inFile.readLine();
				}

			}
			inFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	protected static String writeCheck(String myUser, String myPass,
			String cartaEscogida) {
		try {

			ficheroAEscribir = new FileWriter("src/main/resources/aaa", false);
			outFile = new PrintWriter(ficheroAEscribir);

			outFile.println(myUser + " : " + myPass + " : " + cartaEscogida);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ficheroAEscribir != null)
				try {
					ficheroAEscribir.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return cartaEscogida;
	}

}
