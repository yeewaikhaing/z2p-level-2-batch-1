package com.mmit.pk;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "customer_email")
	private String customerEmail;
	@Column(name = "order_date")
	private LocalDate orderDate;
	
	
	public Order() {
		super();
	}
   
}
