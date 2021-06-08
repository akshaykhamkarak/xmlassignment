package com.mindtree.codechallenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.mindtree.codechallenge.exception.ConnectionUtilityException;
import com.mindtree.codechallenge.model.Order;
import com.mindtree.codechallenge.model.ShipInfo;
import com.mindtree.codechallenge.utility.DBConnection;

public class InsertEmployeeDaoImpl implements InsertEmployeeDao {

	public void insertOrders(Set<Order> orders) throws SQLException, ConnectionUtilityException {
		Connection con = new DBConnection().getConnection();
		Iterator<Order> orderList = orders.iterator();
		// ShipInfo shipinfos = new ShipInfo();

		PreparedStatement pstmt = null;
		try {
			while (orderList.hasNext()) {
				Order order = orderList.next();

				String query = "insert into shipinfo values(?,?,?,?,?,?,?,?,?,?,?,?)";

				ShipInfo shipinfoOrder = order.getShipinfo();

				String CustomerID = order.getCustomerID();
				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, shipinfoOrder.getShipVia());

				pstmt.setFloat(2, shipinfoOrder.getFreight());
				pstmt.setString(3, shipinfoOrder.getShipName());
				pstmt.setString(4, shipinfoOrder.getShipAddress());
				pstmt.setString(5, shipinfoOrder.getShipCity());
				pstmt.setString(6, shipinfoOrder.getShipRegion());
				pstmt.setInt(7, shipinfoOrder.getShipPostalCode());
				pstmt.setString(8, shipinfoOrder.getShipCountry());

				pstmt.setString(9, order.getCustomerID());
				pstmt.setInt(10, order.getEmployeeID());
				pstmt.setString(11, order.getOrderDate());
				pstmt.setString(12, order.getRequiredDate());

				int res = pstmt.executeUpdate();

				if (res == 1) {
					System.out.println("success");
				}

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {

			}
		}

	}

	public Set<Order> getOrders() throws SQLException, ConnectionUtilityException

	{
		Connection con = new DBConnection().getConnection();

		PreparedStatement pstmt = null;
		Set<Order> orders = new LinkedHashSet<>();
		try {

			String query = "select * from shipinfo";
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int ShipVia = rs.getInt("ShipVia");

				Float Freight = rs.getFloat("Freight");

				String ShipName = rs.getString("ShipName");

				String ShipAddress = rs.getString("ShipAddress");

				String ShipCity = rs.getString("ShipCity");

				String ShipRegion = rs.getString("ShipRegion");

				int PostalCode = rs.getInt("ShipPostalCode");

				String ShipCountry = rs.getString("ShipCountry");
				String CustomerID = rs.getString("CustomerID");
				int EmployeeID = rs.getInt("EmployeeID");
				String OrderDate = rs.getString("OrderDate");
				String RequiredDate = rs.getString("RequiredDate");

				ShipInfo shipinfo = new ShipInfo(ShipVia, Freight, ShipName, ShipAddress, ShipCity, ShipRegion,
						PostalCode, ShipCountry);

				orders.add(new Order(CustomerID, EmployeeID, OrderDate, RequiredDate, shipinfo));

			}

			return orders;

		} catch (Exception e) {

		} finally {
			con.close();
			pstmt.close();
		}
		return null;
	}

}
