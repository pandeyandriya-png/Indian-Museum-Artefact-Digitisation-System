package dao;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtefactDAO {

    public static boolean addArtefact(
            String name,
            String type,
            String material,
            int dynastyId,
            int regionId,
            String description
    ) {

        try (
                Connection conn = DBConnection.getConnection()
        ) {

            int newId = 1;

            String idQuery =
                    "SELECT MAX(artefact_id) FROM Artefact";

            PreparedStatement idStmt =
                    conn.prepareStatement(idQuery);

            ResultSet rs =
                    idStmt.executeQuery();

            if (rs.next()) {
                newId = rs.getInt(1) + 1;
            }

            String sql =
                    "INSERT INTO Artefact " +
                    "(artefact_id,name,type,material,dynasty_id,region_id,description) " +
                    "VALUES(?,?,?,?,?,?,?)";

            PreparedStatement pstmt =
                    conn.prepareStatement(sql);

            pstmt.setInt(1, newId);
            pstmt.setString(2, name);
            pstmt.setString(3, type);
            pstmt.setString(4, material);
            pstmt.setInt(5, dynastyId);
            pstmt.setInt(6, regionId);
            pstmt.setString(7, description);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
}