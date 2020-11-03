package Proxy;

public class ProxyInternetAccess implements OfficeInternetAccess {
	private Employee employee;
	private RealInternetAccess realaccess;

	public ProxyInternetAccess(Employee e) {
		this.employee = e;
	}

	public void grantInternetAccess() {  
        
		if (employee.getRole() > 4) {
			realaccess = new RealInternetAccess(employee);
			realaccess.grantInternetAccess();
		}
		else {
			System.out.println("Internet access denied");
		}
    }  
}