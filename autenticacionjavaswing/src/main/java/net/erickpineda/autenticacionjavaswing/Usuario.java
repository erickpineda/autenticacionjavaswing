package net.erickpineda.autenticacionjavaswing;

import java.io.Serializable;

public class Usuario implements Serializable {

	/**
	 * Identificador del objeto Usuario.
	 */
	private static final long serialVersionUID = 5949923607162238588L;
	/**
	 * Será la carta que ha escogido el usuario.
	 */
	private String caraCarta;
	/**
	 * Será la contraseña del usuario.
	 */
	private String pass;

	/**
	 * Será el nombre del usuario.
	 */
	private String user;

	/**
	 * Constructor de usuarios.
	 * 
	 * @param myUser
	 *            Valor que será el nombre del usuario.
	 * @param myPass
	 *            Valor que será la contraseña del usuario.
	 */
	public Usuario(String myUser, String myPass) {
		this.user = myUser;
		this.pass = myPass;
	}

	/**
	 * Constructor de usuarios con carta.
	 * 
	 * @param myUser
	 *            Valor que será el nombre del usuario.
	 * @param myPass
	 *            Valor que será la contraseña del usuario.
	 * @param myCard
	 *            Valor que será la carta del usuario.
	 */
	public Usuario(String myUser, String myPass, String myCard) {
		this.user = myUser;
		this.pass = myPass;
		this.caraCarta = myCard;
	}

	/**
	 * @return Retorna la carta que ha escogido el usuario.
	 */
	public String getCaraCarta() {
		return caraCarta;
	}

	/**
	 * @return Retorna el nombre usuario.
	 */
	public String getNameUser() {
		return user;
	}

	/**
	 * @return Retorna la contraseña del usuario.
	 */
	public String getPassUser() {
		return pass;
	}

	/**
	 * @param caraCarta
	 *            Cambia la carta escogida por el usuario.
	 */
	public void setCaraCarta(String caraCarta) {
		this.caraCarta = caraCarta;
	}

	/**
	 * @param user
	 *            Cambia el nombre del usuario.
	 */
	public void setNameUser(String user) {
		this.user = user;
	}

	/**
	 * @param pass
	 *            Cambia la contraseña del usuario.
	 */
	public void setPassUser(String pass) {
		this.pass = pass;
	}

	public String toString() {
		return "El usuario: " + this.getNameUser() + " con password: "
				+ this.getPassUser() + " y cara carta " + this.getCaraCarta();
	}

}
