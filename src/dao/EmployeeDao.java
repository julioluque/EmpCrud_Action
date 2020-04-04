package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeDao {

	public int save(int id, String name, String email, float salary) throws Exception {

		Class.forName("oracle.jdbc.OracleDriver");
//		Connection con = DriverManager.getConnection("jdbc:oracle:thin@localhost:1521:xe", "system", "password");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XEPDB", "system", "password");
		
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/strutsCrud", "root", "1234");

		PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.setFloat(4, salary);
		int i = ps.executeUpdate();
		return i;
	}
	
}
