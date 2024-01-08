package com.KoreaIT.java.JDBCAM.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCUpdateTest {
	public static void main(String[] args) {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/JDBC_AM?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";

			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("연결 성공!");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("수정할 ID : ");
			int id = sc.nextInt();
			System.out.println("수정할 게시글 : ");
			String article = sc.next();
			System.out.println("수정할 내용 : ");
			String body = sc.next();
			
			String sql = " UPDATE article "
					   + " SET id = '" + id + "', article = '" + article
					   + "' WHERE body = " + body;
		
			Statement stmt = null;

			try {
				//3. Query 준비
				stmt = conn.createStatement();
				
				//4. Query 실행 및 리턴
				int res = stmt.executeUpdate(sql);
				if(res > 0) {
					System.out.println("입력 성공");
				}else {
					System.out.println("입력 실패");
				}
			
			
			


		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		


}
}
	}