package com.mindtree.codechallenge.service;

import java.sql.SQLException;
import java.util.Set;

import com.mindtree.codechallenge.dao.InsertEmployeeDao;
import com.mindtree.codechallenge.dao.InsertEmployeeDaoImpl;
import com.mindtree.codechallenge.exception.ConnectionUtilityException;
import com.mindtree.codechallenge.model.Order;

public class InsertIntoDb {
	InsertEmployeeDao impl = new InsertEmployeeDaoImpl();

	public void insertOrders(Set<Order> orders) throws SQLException, ConnectionUtilityException {
		impl.insertOrders(orders);
	}

	public Set<Order> getOrders() throws SQLException, ConnectionUtilityException {
		return impl.getOrders();

	}

	
	
}