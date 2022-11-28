package me.seun.springbasic.jdbc;

import java.sql.*;

public class JdbcApp {

    private static final String URL = "jdbc:mysql://localhost:12345/study";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "tpdns12";

    public static void main(String[] args) {
        // DB 커넥션 엳기
        try {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            con.setAutoCommit(false);

            String sql = "select * from member where name = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "tester1");
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            long memberId = rs.getLong("member_id");
            String name = rs.getString("name");

            System.out.println(memberId);
            System.out.println(name);
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
