import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;

public class Test{

	
	
	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
		try {
			Statement statement = java.sql.Connection.CreateArrayOf("String", Object obj[]);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
}
