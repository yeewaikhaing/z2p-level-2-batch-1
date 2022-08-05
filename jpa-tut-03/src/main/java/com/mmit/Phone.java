package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

import net.bytebuddy.utility.nullability.MaybeNull;

/**
 * Entity implementation class for Entity: Phone
 *
 */
@Entity

public class Phone implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String number;
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	private static final long serialVersionUID = 1L;

	public Phone() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
   
}
