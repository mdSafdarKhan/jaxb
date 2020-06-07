package com.demo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "name", "addreses" })
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlAttribute
	private Integer id;

	@XmlElement
	private String name;

	@XmlElement
	private List<Address> addreses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddreses() {
		return addreses;
	}

	public void setAddreses(List<Address> addreses) {
		this.addreses = addreses;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", addreses=" + addreses + "]";
	}

}
