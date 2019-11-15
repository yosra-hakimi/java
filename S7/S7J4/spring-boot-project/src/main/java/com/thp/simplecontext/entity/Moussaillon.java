package com.thp.simplecontext.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "moussaillon", schema = "moussaillonjdbc")

@NamedQueries({
		@NamedQuery(name = Moussaillon.QN.FIND_MOUSSAILLON_BY_ID, query = "SELECT m FROM Moussaillon m WHERE id = :id"),

		@NamedQuery(name = Moussaillon.QN.FIND_ALL_MOUSSAILLON, query = "SELECT m FROM Moussaillon m ")

})

public class Moussaillon implements Serializable {

	public static class QN {
		public static final String FIND_MOUSSAILLON_BY_ID = "Moussaillon.findById";
		// public static final String CREATE_MOUSSAILLON =
		// "Moussaillon.createMoussaillon";
		public static final String FIND_ALL_MOUSSAILLON = "Moussaillon.findAll";

	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "config")
	private String config;

	@Transient
	private int bateau_id;
	
	@ManyToOne
	@JoinColumn(name = "bateau_id")
	private Bateau bateau;

	public Bateau getBateau() {
		return bateau;
	}


	public int getBateau_id() {
		return bateau_id;
	}

	public void setBateau_id(int bateau_id) {
		this.bateau_id = bateau_id;
	}
	

	/*
	 * public Moussaillon(String firstName, String lastName, String config) {
	 * super(); this.firstName = firstName; this.lastName = lastName; this.config =
	 * config; }
	 */
	public Moussaillon() {

	}

	public Moussaillon(int id, String firstName, String lastName, String config, Bateau bateau) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.config = config;
		this.bateau = bateau;
	}

	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void afficher() {
		System.out.println("Le pr�nom du moussaillon :" + " " + firstName);
		System.out.println("Le nom du moussaillon :" + " " + lastName);
		System.out.println("Configuration utilis�e :" + " " + config);

	}

	@Override
	public String toString() {
		return "Moussaillon [id=" + id + ", firstName=" + firstName.trim() + ", lastName=" + lastName.trim()
				+ ", config=" + config.trim() + ", bateau=" + bateau + "]";
	}

}