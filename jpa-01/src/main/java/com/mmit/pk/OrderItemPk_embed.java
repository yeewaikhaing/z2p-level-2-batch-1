package com.mmit.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class OrderItemPk_embed implements Serializable{

	private static final long serialVersionUID = 1L;
	private int productId;
	private int orderId;
	@Override
	public int hashCode() {
		return Objects.hash(orderId, productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPk_embed other = (OrderItemPk_embed) obj;
		return orderId == other.orderId && productId == other.productId;
	}
	
	
	
	
}
