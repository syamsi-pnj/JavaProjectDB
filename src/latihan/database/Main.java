package latihan.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/db_latihan";
	static final String USER = "root";
	static final String PASS = "";
	
	static Connection connection;
	static Statement stmt;
	static ResultSet rs;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,USER,PASS);
			
			stmt = connection.createStatement();
			
			String SQL = "select * from mahasiswa";
			
			rs = stmt.executeQuery(SQL);
			
			while (rs.next()) {
				System.out.println("id = "+ rs.getInt("id"));
				System.out.println("nim = "+ rs.getString("nim"));
				System.out.println("nama = "+ rs.getString("nama"));
				System.out.println("email = "+ rs.getString("email"));
				System.out.println("kelas = "+ rs.getString("kelas"));
				System.out.println();
			}
			
			stmt.close();
			connection.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
