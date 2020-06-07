package com.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Test {
	public static void main(String[] args) {
		marshal();
		unmarshal();
	}

	public static void marshal() {
		
		List<Address> addresses = new ArrayList<Address>();

		Address address1 = new Address();
		address1.setCity("New Delhi");
		address1.setState("Delhi");
		address1.setCountry("India");

		Address address2 = new Address();
		address2.setCity("Patna");
		address2.setState("Bihar");
		address2.setCountry("India");

		addresses.add(address1);
		addresses.add(address2);

		Employee employee = new Employee();
		employee.setId(100);
		employee.setName("Peter");
		employee.setAddreses(addresses);

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(com.demo.Employee.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			FileOutputStream fos = new FileOutputStream("emp.xml");
			marshaller.marshal(employee, fos);
			System.out.println("Marshalling done!");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void unmarshal() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Employee employee = (Employee)unmarshaller.unmarshal(new FileInputStream("emp.xml"));
			System.out.println(employee);
			System.out.println("Unmarshalling done!");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
