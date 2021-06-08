package com.mindtree.codechallenge.dao;

import java.sql.SQLException;
import java.util.Set;

import com.mindtree.codechallenge.exception.ConnectionUtilityException;
import com.mindtree.codechallenge.model.Order;

public interface InsertEmployeeDao {
	public void insertOrders(Set<Order> orders) throws SQLException,ConnectionUtilityException ;
	
	 public Set<Order> getOrders() throws SQLException, ConnectionUtilityException;
}
