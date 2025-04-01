package DDT_Practice_AS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DeletingDataInMySqlDatabase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninza_1","root","k@vith@123456789Naveen");
		Statement stmt = conn.createStatement();
		
		int result = stmt.executeUpdate("delete from Ninza_Details where Browser='chrome'"); //inside condition given
		
		System.out.println(result);
		if(result!= 0)
		{
			System.out.println("Deleting Successful");
		}
		else
		{
			System.out.println("operation failed");
		}
		conn.close();

	}

}
