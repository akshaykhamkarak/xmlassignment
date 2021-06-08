package com.mindtree.codechallenge.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orders")
public class Orders {

	List<Order> orders;

	public List<Order> getOrder() {
		return orders;
	}

	@XmlElement(name = "order")
	public void setOrder(List<Order> orders) {
		this.orders = orders;
	}

	public void add(Order order) {
		if (this.orders == null) {
			this.orders = new ArrayList<Order>();
		}
		this.orders.add(order);
	}

}
