package com.mindtree.codechallenge.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Order  {

	private String CustomerID;
	private int EmployeeID;
	private String OrderDate;
	private String RequiredDate;
	private ShipInfo shipinfo;
	
	
	
	@Override
	public String toString() {
		return "Orders [CustomerID=" + CustomerID + ", EmployeeID=" + EmployeeID + ", OrderDate=" + OrderDate
				+ ", RequiredDate=" + RequiredDate + ", shipinfo=" + shipinfo + "]";
	}
	public Order() {
		super();
	
	}
	public Order(String customerID, int employeeID, String orderDate, String requiredDate, ShipInfo shipinfo) {
		super();
		CustomerID = customerID;
		EmployeeID = employeeID;
		OrderDate = orderDate;
		RequiredDate = requiredDate;
		this.shipinfo = shipinfo;
	}
	@XmlElement
	public String getCustomerID() {
		return CustomerID;
	}
	
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	@XmlElement
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	@XmlElement
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	@XmlElement
	public String getRequiredDate() {
		return RequiredDate;
	}
	public void setRequiredDate(String requiredDate) {
		RequiredDate = requiredDate;
	}
	
	public ShipInfo getShipinfo() {
		return shipinfo;
	}
	
	public void setShipinfo(ShipInfo shipinfo) {
		this.shipinfo = shipinfo;
	}
}
