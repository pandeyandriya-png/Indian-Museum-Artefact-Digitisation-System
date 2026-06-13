package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public static boolean validateUser(String username, String password) {

        String query =
                "SELECT 1 FROM users WHERE username = ? AND password = ? LIMIT 1";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)
        ) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        }
    }
}