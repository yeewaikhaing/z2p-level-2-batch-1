package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity

public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	@OneToOne(mappedBy = "customer")
	@PrimaryKeyJoinColumn
	private CustomerDetail detail;
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}
   
}
