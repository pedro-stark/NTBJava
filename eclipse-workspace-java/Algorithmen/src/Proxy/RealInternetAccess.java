package Proxy;

public class RealInternetAccess implements OfficeInternetAccess {  
    private Employee employee;  
    public RealInternetAccess(Employee e) {  
        this.employee = e;  
    }  
    @Override  
    public void grantInternetAccess() {  
        System.out.println("Internet Access granted for employee: "+ employee.getName());  
    }  
}
