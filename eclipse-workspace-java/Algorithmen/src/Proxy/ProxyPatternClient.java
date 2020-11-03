package Proxy;

public class ProxyPatternClient {
	public static void main(String[] args) {
		
		Employee a = new Employee("Heiko Waldberger", 5);
		Employee b = new Employee("Ashwani Rajput", 2);
		Employee c = new Employee("Gundalf Hochueli", 6);
		Employee d = new Employee("Melchior Müller", 7);
		Employee e = new Employee("Dino van der Werft", 1);
		
		OfficeInternetAccess accessA = new ProxyInternetAccess(a);
		accessA.grantInternetAccess();
		OfficeInternetAccess accessB = new ProxyInternetAccess(b);
		accessB.grantInternetAccess();
		OfficeInternetAccess accessC = new ProxyInternetAccess(c);
		accessC.grantInternetAccess();
		OfficeInternetAccess accessD = new ProxyInternetAccess(d);
		accessD.grantInternetAccess();
		OfficeInternetAccess accessE = new ProxyInternetAccess(e);
		accessE.grantInternetAccess();
	}
}
