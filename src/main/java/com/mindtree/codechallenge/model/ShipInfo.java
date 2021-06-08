package com.mindtree.codechallenge.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class ShipInfo {

	private int ShipVia;
	private float Freight;
	private String ShipName;
	private String ShipAddress;
	private String ShipCity;
	private String ShipRegion;
	private int ShipPostalCode;
	private String ShipCountry;
	
	
	
	@Override
	public String toString() {
		return "ShipInfo [ShipVia=" + ShipVia + ", Freight=" + Freight + ", ShipName=" + ShipName + ", ShipAddress="
				+ ShipAddress + ", ShipCity=" + ShipCity + ", ShipRegion=" + ShipRegion + ", ShipPostalCode="
				+ ShipPostalCode + ", ShipCountry=" + ShipCountry + "]";
	}
	public ShipInfo() {
		super();
		
	}
	public ShipInfo(int shipVia, float freight, String shipName, String shipAddress, String shipCity, String shipRegion,
			int shipPostalCode, String shipCountry) {
		super();
		ShipVia = shipVia;
		Freight = freight;
		ShipName = shipName;
		ShipAddress = shipAddress;
		ShipCity = shipCity;
		ShipRegion = shipRegion;
		ShipPostalCode = shipPostalCode;
		ShipCountry = shipCountry;
	}
	@XmlElement
	public int getShipVia() {
		return ShipVia;
	}
	public void setShipVia(int shipVia) {
		ShipVia = shipVia;
	}
	@XmlElement
	public float getFreight() {
		return Freight;
	}
	public void setFreight(float freight) {
		Freight = freight;
	}
	@XmlElement
	public String getShipName() {
		return ShipName;
	}
	public void setShipName(String shipName) {
		ShipName = shipName;
	}
	@XmlElement
	public String getShipAddress() {
		return ShipAddress;
	}
	public void setShipAddress(String shipAddress) {
		ShipAddress = shipAddress;
	}
	@XmlElement
	public String getShipCity() {
		return ShipCity;
	}
	public void setShipCity(String shipCity) {
		ShipCity = shipCity;
	}
	@XmlElement
	public String getShipRegion() {
		return ShipRegion;
	}
	public void setShipRegion(String shipRegion) {
		ShipRegion = shipRegion;
	}
	@XmlElement
	public int getShipPostalCode() {
		return ShipPostalCode;
	}
	public void setShipPostalCode(int shipPostalCode) {
		ShipPostalCode = shipPostalCode;
	}
	@XmlElement
	public String getShipCountry() {
		return ShipCountry;
	}
	public void setShipCountry(String shipCountry) {
		ShipCountry = shipCountry;
	}
	
}
