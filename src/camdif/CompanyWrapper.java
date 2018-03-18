package camdif;

public class CompanyWrapper {

	private Company company;
	private String save_name;
	
	public CompanyWrapper(Company company, String save_name) {
		this.company = new Company();
		this.company.setName(company.getName());
		this.company.setType(company.getType());
		this.company.setBusinessType(company.getBusinessType());
		this.company.setEmployees(company.getEmployees());
		this.company.setYearFounded(company.getYearFounded());
		this.company.setURL(company.getURL());
		this.company.setAddress(company.getAddress());
		this.company.setCity(company.getCity());
		this.company.setState(company.getState());
		this.company.setZip(company.getZip());		
		this.save_name = save_name;
	}
	
	public Company getCompany() {
		return company;
	}	
	
	public String toString() {
		return save_name;
	}
	
}
