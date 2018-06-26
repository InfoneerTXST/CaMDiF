package camdif;

import java.io.Serializable;

public class Company implements Serializable {

	private String name;
	private String employees;
	private String year_founded;
	private String URL;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String type;
	private String business_type;
	
	public Company() {
		name = "";
		type = "";
		business_type = "";
		employees = "";
		year_founded = "";
		URL = "";
		address = "";
		city = "";
		state = "";
		zip = "";
	}
	
	public Company(String name, String type, String business_type, String employees, String year_founded,
			String URL, String address, String city, String state, String zip) {
		this.name = name;
		this.type = type;
		this.business_type = business_type;
		this.employees = employees;
		this.year_founded = year_founded;
		this.URL = URL;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public Company(Company c) {
		this.name = c.name;
		this.type = c.type;
		this.business_type = c.business_type;
		this.employees = c.employees;
		this.year_founded = c.year_founded;
		this.URL = c.URL;
		this.address = c.address;
		this.city = c.city;
		this.state = c.state;
		this.zip = c.zip;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmployees() {
		return employees;
	}
	
	public String getYearFounded() {
		return year_founded;
	}
	
	public String getURL() {
		return URL;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public String getType() {
		return type;
	}
	
	public String getBusinessType() {
		return business_type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmployees(String employees) {
		this.employees = employees;
	}
	
	public void setYearFounded(String year_founded) {
		this.year_founded = year_founded;
	}
	
	public void setURL(String URL) {
		this.URL = URL;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setBusinessType(String business_type) {
		this.business_type = business_type;
	}
	
}
