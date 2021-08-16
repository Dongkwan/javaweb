import java.io.*;
import java.sql.*;

public class JDBC_Ex3 {
	public static void main (String[] args) throws Exception {
		Connection conn;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?serverTimezone=UTC", "root","root");
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into student (name, id, dept) values('rhee', '0893012', 'ce');");
			printTable(stmt);
			stmt.executeUpdate("update student set id='0189011' where name='lee'");
			printTable(stmt);
			stmt.executeUpdate("delete from student where name='lee'");
			printTable(stmt);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 오류");
		}
	}
	
	private static void printTable(Statement stmt) throws SQLException, UnsupportedEncodingException {
		ResultSet srs = stmt.executeQuery("select * from student");
		while (srs.next()) {
			System.out.print(srs.getString("name"));
			System.out.print("\t|\t" + srs.getString("id"));
			System.out.println("\t|\t" + srs.getString("dept"));
		}
	}
}