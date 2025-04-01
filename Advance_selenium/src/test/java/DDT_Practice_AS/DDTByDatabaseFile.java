package DDT_Practice_AS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DDTByDatabaseFile {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninza_1","root","k@vith@123456789Naveen");
		Statement stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery("select * from Ninza_Details;");
		
		while(result.next())
		{
			String browser=result.getString(1);
			String url=result.getString(2);
			String uname=result.getString(3);
			String pwd=result.getString(4);
			System.out.println(browser+ "  ");
			System.out.print(url + "  ");
			System.out.print(uname + "  ");
			System.out.println(pwd + "  ");
				
		}
		 
		conn.close();
		
	}

}
