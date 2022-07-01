package dineshmoviedb;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;


public class sqliteMoviedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcUrl = "jdbc:sqlite:/C:\\Users\\J.Gowrishankar\\Desktop\\db\\dineshdb.db";
		try {
			Connection connect=DriverManager.getConnection(jdbcUrl);
			String sql = "SELECT * FROM movies";
			Statement stat = connect.createStatement();
			ResultSet results = stat.executeQuery(sql);
			while(results.next()) {
				String moviename=results.getString("moviename");
				String actor=results.getString("actor");
				String actress=results.getString("actress");
				String director=results.getString("director");
				String year=results.getString("year");
				
				System.out.println(moviename+" | "+actor+" | "+actress+" | "+director+" | "+year);
				
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			String sqlconnect1 = "SELECT moviename FROM movies WHERE actor='Kamalhaasan';";
			Statement statementconnect1 = connect.createStatement();
			ResultSet resultconnect1 = statementconnect1.executeQuery(sqlconnect1);
			while(resultconnect1.next()) {
				String moviename=resultconnect1.getString("moviename");				
				System.out.println(moviename);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error connecting to SQLite Database");
			e.printStackTrace();
		}

	}

}
