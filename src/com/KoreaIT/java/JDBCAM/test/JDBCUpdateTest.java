package com.KoreaIT.java.JDBCAM.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCUpdateTest {
	public static void main(String[] args) {
		Connection conn = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 번호 : ");
		int id = sc.nextInt();
		System.out.println("바뀔 제목 : ");
		String title = sc.next();
		System.out.println("바뀔 내용 : ");
		String body = sc.next();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/JDBC_AM?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";

			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("연결 성공!");

			String sql = " UPDATE article " + " SET title = ?, body = ? " + " WHERE id = ? ";

			PreparedStatement pstm = null;

			// 3. Query 준비
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, title);
			pstm.setString(2, body);
			pstm.setInt(3, id);
			// 4. Query 실행
			int res = pstm.executeUpdate();
			if (res > 0) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
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