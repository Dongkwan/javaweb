import java.io.*;
import java.sql.*;

public class JDBC_Ex2 {
	public static void main (String[] args) {
		Connection conn;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?serverTimezone=UTC", "root","root");
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement();
			ResultSet srs = stmt.executeQuery("select * from student");
			printData(srs, "name", "id", "dept");
			srs = stmt.executeQuery("select name, id, dept from student where name='lee'");
			printData(srs, "name", "id", "dept");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 오류");
		}
	}
	private static void printData(ResultSet srs, String col1, String col2, String col3) throws SQLException {
		while (srs.next()) {
			if (!col1.equals(""))
				System.out.print(srs.getString("name")); 
			if (!col2.equals(""))
				System.out.print("\t|\t" + srs.getString("id"));
			if (!col3.equals(""))
				System.out.println("\t|\t" + srs.getString("dept"));
			else 
				System.out.println();
		}
	}
}