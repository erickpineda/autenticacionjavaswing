package net.erickpineda.autenticacionjavaswing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Accion {
	/**
	 * Ruta del fichero a guardar.
	 */
	private static String saveFile = "save";
	/**
	 * Fichero de salida.
	 */
	private static OutputStream fos;
	/**
	 * Escritor del objeto.
	 */
	private static ObjectOutputStream oos;
	/**
	 * Fichero de entrada.
	 */
	private static FileInputStream fis;
	/**
	 * Lector del fichero.
	 */
	private static ObjectInputStream ois;
	/**
	 * Lista de usuarios.
	 */
	private static List<Usuario> lista;

	public Accion() {
		comprobarExistenciaFichero();
	}

	/**
	 * Método que comprueba la existencia del fichero, que guardará la
	 * información necesaria.
	 */
	protected void comprobarExistenciaFichero() {
		File miFichero = new File(saveFile);

		try {

			if (!miFichero.exists()) {
				crearFichero();
			} else {
				abrirFichero();
			}

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
	@SuppressWarnings("unchecked")
	public static void abrirFichero() throws IOException,
			ClassNotFoundException {

		System.out.println("\n*** REANUDANDO INFORMACIÓN ALMACENADA ***\n");

		fis = new FileInputStream(saveFile);
		ois = new ObjectInputStream(fis);

		lista = (List<Usuario>) ois.readObject();

	}

	/**
	 * Método que crea usuarios en la lista.
	 * 
	 * @param myUser
	 *            Parámetro del nombre de usuario.
	 * @param myPass
	 *            Parámetro para contraseña del usuario.
	 * @param myCard
	 *            Parámetro para la carta escogida por el usuario.
	 */
	protected void crearUsuario(String myUser, String myPass, String myCard) {
		lista.add(new Usuario(myUser, myPass, myCard));
	}

	protected void setUsuario(String myUser, String myPass, String myCard) {

		for (Usuario u : lista) {
			if (u.getNameUser().equalsIgnoreCase(myUser)
					&& u.getPassUser().equals(myPass)) {
				u.setCaraCarta(myCard);
			}
		}
	}

	/**
	 * Método que guarda en el fichero la lista de usuarios.
	 */
	protected void escribirUsuarioEnFichero() {

		System.out.println("** Escribiendo en el fichero");

		ObjectOutputStream oos;
		OutputStream fos;

		try {

			fos = new FileOutputStream(saveFile);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(lista);
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que comprueba la existencia de un usuario, a partir de su nombre.
	 * 
	 * @param myUser
	 *            Nombre del usuario.
	 * @return Retorna si el usuario existe o no.
	 */
	protected boolean comprobarExistenciaUsuario(String myUser) {

		boolean existe = false;

		for (Usuario u : lista) {
			if (u.getNameUser().equals(myUser)) {
				existe = true;
				System.out.println("existe = " + existe);
			}
		}

		return existe;
	}

	/**
	 * Comprueba que al iniciar sesión el usuario, sus credenciales son válidas.
	 * 
	 * @param myUser
	 *            Nombre del usuario a comprobar.
	 * @param myPass
	 *            Contraseña del usuario.
	 * @param myCard
	 *            Carta escogida del usuario.
	 * @return Retorna si todos los valores del usuario con correcto o erróneos.
	 */
	protected boolean comprobarCredenciales(String myUser, String myPass,
			String myCard) {

		boolean todoOk = false;

		Iterator<Usuario> itera = lista.iterator();

		while (itera.hasNext()) {
			Usuario u = itera.next();

			if (u.getNameUser().equals(myUser)) {
				if (u.getPassUser().equals(myPass)
						&& u.getCaraCarta().equals(myCard)) {

					todoOk = true;
					System.out.println("  Login correcto ");

				} else {
					System.out.println("  la contraseña es incorrecta ");
				}
			}

		}
		return todoOk;
	}

	/**
	 * 
	 * @return Retorna la lista de usuarios.
	 */
	public List<Usuario> getLista() {
		return lista;
	}

}
