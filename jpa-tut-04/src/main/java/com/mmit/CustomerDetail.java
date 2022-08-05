package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CustomerDetail
 *
 */
@Entity

public class CustomerDetail implements Serializable {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "cust_id")
	private int id;
	private String fullName;
	private String phone;
	@OneToOne
	@JoinColumn(name = "cust_id")
	@MapsId
	private Customer customer; // fieldName + "_" + pkFileName(customer_id)
	private static final long serialVersionUID = 1L;

	public CustomerDetail() {
		super();
	}
   
}
