package dumb.jdbc;
import java.sql.*;
public class jdbc_code {
	public static Connection initializeDatabase() 
			throws SQLException, ClassNotFoundException
	{
			// driver name
			final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			// database url
			final String URL = "jdbc:mysql://localhost:3306/grey_goose?useSSL=false";
			// database credentials
			final String USER = "root";
			final String PASS = "XXXXX";
			// registering jdbc driver
			Class.forName(JDBC_DRIVER);
			// opening connection
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			
			return con;
		} 
}
