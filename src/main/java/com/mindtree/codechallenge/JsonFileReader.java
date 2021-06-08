package com.mindtree.codechallenge;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.imageio.spi.ImageTranscoderSpi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
import com.mindtree.codechallenge.exception.ConnectionUtilityException;
import com.mindtree.codechallenge.exception.JsonFileNotFoundException;

import com.mindtree.codechallenge.model.Order;
import com.mindtree.codechallenge.model.ShipInfo;
import com.mindtree.codechallenge.service.InsertIntoDb;
import com.mindtree.codechallenge.service.XMLServicesImpl;


public class JsonFileReader {
	public static void main(String[] args) throws SQLException, JsonFileNotFoundException {

		JSONParser parser = new JSONParser();
		InsertIntoDb service = new InsertIntoDb();
		Object obj;
		final ObjectMapper mapper = new ObjectMapper();
		try {

			obj = parser.parse(new FileReader("Orders.json"));
			// System.out.println(obj);
			JSONArray jsonArray = (JSONArray) obj;

			Iterator<JSONObject> orderobject = jsonArray.iterator();
			JSONObject jsonObject1, obj2;
			Set<Order> order = new LinkedHashSet<Order>();
			// JSONObject jsonObject2=null;
			while (orderobject.hasNext()) {

				jsonObject1 = (JSONObject) orderobject.next();

				String CustomerID = (String) jsonObject1.get("CustomerID");
				int EmployeeID = Integer.parseInt(jsonObject1.get("EmployeeID").toString());
				String OrderDate = (String) jsonObject1.get("OrderDate");
				String RequiredDate = (String) jsonObject1.get("RequiredDate");

				ShipInfo shipinfo = new ShipInfo();
				String shipinfo1 = jsonObject1.toString();

				JsonNode root = mapper.readTree(shipinfo1);
				JsonNode ship1 = root.path("ShipInfo");

				int ShipVia = Integer.parseInt((ship1.path("ShipVia")).toString().replace("\"", ""));
				String ShipName = (ship1.path("ShipName")).toString().replace("\"", "");

				float Freight = Float.parseFloat((ship1.path("Freight")).toString().replace("\"", ""));

				String ShipAddress = (ship1.path("ShipAddress")).toString().replace("\"", "");
				String ShipCity = (ship1.path("ShipCity")).toString().replace("\"", "");
				String ShipRegion = (ship1.path("ShipRegion")).toString().replace("\"", "");
				int ShipPostalCode = Integer.parseInt((ship1.path("ShipPostalCode")).toString().replace("\"", ""));
				String ShipCountry = (ship1.path("ShipCountry")).toString().replace("\"", "");

				shipinfo = new ShipInfo(ShipVia, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode,
						ShipCountry);
				order.add(new Order(CustomerID, EmployeeID, OrderDate, RequiredDate, shipinfo));

			}
			// insert record into table
			service.insertOrders(order);
			// get record from table
			Set<Order> readOrders = service.getOrders();

			// store into XML file
			new XMLServicesImpl().readToXml(readOrders);

		}
		
		catch (ConnectionUtilityException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("Please provide json file as input..");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
