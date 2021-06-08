package com.mindtree.codechallenge.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.mindtree.codechallenge.model.Order;
import com.mindtree.codechallenge.model.Orders;




public class XMLServicesImpl {

	
	public void readToXml(Set<Order> orders) {
		String xmlData="";
		Orders ordersto=new Orders();
		if(orders!=null) {
			for(Order order : orders) {
				ordersto.add(order);
				
			}
			xmlData =readObjToXml(ordersto)+"\n";
			File file = new File("Order.xml");
			try(FileWriter fw = new FileWriter(file)){
				fw.write(xmlData);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(xmlData);
			
		}else {
			System.out.println("Data Generation failed");
		}
		
	}

	private String readObjToXml(Orders ordersto) {
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Orders.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			StringWriter sw = new StringWriter();
			marshaller.marshal(ordersto, sw);
			String bookData = sw.toString();
			return bookData;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
