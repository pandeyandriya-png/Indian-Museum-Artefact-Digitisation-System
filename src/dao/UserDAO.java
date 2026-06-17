package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.swing.JOptionPane;

import java.util.List;
import java.util.ArrayList;
import java.sql.Statement;

public class UserDAO {
    public static boolean validateUser(String username, String password) {
        String query = "SELECT 1 FROM users WHERE username = ? AND password = ? LIMIT 1";

        // Connection, Statement, and ResultSet all auto-close here
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            if (conn == null) {
                System.err.println("Database connection failed!");
                return false;
            }

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Returns true if a record exists
            }

        } catch (SQLException e) {
            // Log the error for debugging
            System.err.println("Login Query Error: " + e.getMessage());
            return false;
        }
    }

public static boolean add_User(User a) { // 'a' is defined here
    try (Connection conn = DBConnection.getConnection()) {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Users (userID, username, password) VALUES (?, ?, ?)");
        
        // Use 'a' because that is the name in the parentheses above
        ps.setInt(1, a.getID()); 
        ps.setString(2, a.getUser());
        ps.setString(3, a.getPassword());
        
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
    return false;
}

public static boolean delete_User(int userId)
{
        String sql = "DELETE FROM Users WHERE userID = ?";

    try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) 
    {

        ps.setInt(1, userId);
        return ps.executeUpdate() > 0;

    } 
    catch (SQLException e) 
    {
            e.printStackTrace();
    }

    return false;
}


public static List<User> getAllUsers() 
{
    List<User> list = new ArrayList<>();
    String sql = "SELECT userID, username, password FROM Users"; // Check column names!

    try (Connection conn = DBConnection.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) 
    {

        while (rs.next())
        {
            list.add(new User(
                rs.getInt("userID"),
                rs.getString("username"),
                rs.getString("password")
            ));
        }
    } 
    catch (SQLException e) 
    {
        e.printStackTrace();
    }
    return list;
}
}