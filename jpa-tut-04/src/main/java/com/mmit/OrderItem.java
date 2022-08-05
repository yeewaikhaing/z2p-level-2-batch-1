package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: OrderItem
 *
 */
@Entity
public class OrderItem implements Serializable {

	
	private static final long serialVersionUID = 1L;
	//@EmbeddedId
	//private OrderItemPK id;
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	//@MapsId("orderId")
	private Order order;
	@ManyToOne
	@JoinColumn(name = "product_id")
	//@MapsId("productId")
	private Product product;
	
	private int subQty;
	
	public OrderItem() {
		super();
	}
   
}
