package com.KoreaIT.java.JDBCAM.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDeleteTest {
	public static void main(String[] args) {
		Connection conn = null;

		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/JDBC_AM?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";

			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("연결 성공!");

			System.out.println("삭제할 번호를 입력해주세요 : ");
			int id = sc.nextInt();

			String sql = " DELETE FROM article " + " WHERE id = ? ";

			PreparedStatement pstm = null;

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			int res = pstm.executeUpdate();
			if (res > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("내용이 없습니다");
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