package dao;

import db.DBConnection;
import model.Artefact;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchDAO {

public static ObservableList<Artefact> getAllArtefacts() {

    ObservableList<Artefact> artefacts =
            FXCollections.observableArrayList();

    String sql =
            "SELECT a.artefact_id, a.name, a.type, a.material, " +
            "d.name AS Dynasty, r.name AS Region " +
            "FROM Artefact a " +
            "JOIN Dynasty d ON a.dynasty_id = d.dynasty_id " +
            "JOIN Region r ON a.region_id = r.region_id";

    try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            ResultSet rs =
                    pstmt.executeQuery()
    ) {

        while (rs.next()) {

            artefacts.add(

                    new Artefact(
                            rs.getInt("artefact_id"),
                            rs.getString("name"),
                            rs.getString("type"),
                            rs.getString("material"),
                            rs.getString("Dynasty"),
                            rs.getString("Region"),
                            ""
                    )

            );
        }

    } catch (SQLException e) {

        e.printStackTrace();

    }

    return artefacts;
}

public static ObservableList<String> getDynasties() {

    ObservableList<String> list =
            FXCollections.observableArrayList();

    list.add("All");

    String sql =
            "SELECT DISTINCT name FROM Dynasty ORDER BY name";

    try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            ResultSet rs =
                    pstmt.executeQuery()
    ) {

        while (rs.next()) {
            list.add(rs.getString("name"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}

public static ObservableList<String> getRegions() {

    ObservableList<String> list =
            FXCollections.observableArrayList();

    list.add("All");

    String sql =
            "SELECT DISTINCT name FROM Region ORDER BY name";

    try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            ResultSet rs =
                    pstmt.executeQuery()
    ) {

        while (rs.next()) {
            list.add(rs.getString("name"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}

public static ObservableList<String> getTypes() {

    ObservableList<String> list =
            FXCollections.observableArrayList();

    list.add("All");

    String sql =
            "SELECT DISTINCT type FROM Artefact ORDER BY type";

    try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            ResultSet rs =
                    pstmt.executeQuery()
    ) {

        while (rs.next()) {
            list.add(rs.getString("type"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}

public static ObservableList<String> getMaterials() {

    ObservableList<String> list =
            FXCollections.observableArrayList();

    list.add("All");

    String sql =
            "SELECT DISTINCT material FROM Artefact ORDER BY material";

    try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            ResultSet rs =
                    pstmt.executeQuery()
    ) {

        while (rs.next()) {
            list.add(rs.getString("material"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}
public static ObservableList<Artefact> searchArtefacts(
        String dynasty,
        String region,
        String type,
        String material) {

    ObservableList<Artefact> artefacts =
            FXCollections.observableArrayList();

    StringBuilder sql = new StringBuilder(

            "SELECT a.artefact_id, a.name, a.type, a.material, " +
            "d.name AS Dynasty, r.name AS Region " +
            "FROM Artefact a " +
            "JOIN Dynasty d ON a.dynasty_id = d.dynasty_id " +
            "JOIN Region r ON a.region_id = r.region_id " +
            "WHERE 1=1"

    );

    if (!dynasty.equals("All")) {
        sql.append(" AND d.name = ?");
    }

    if (!region.equals("All")) {
        sql.append(" AND r.name = ?");
    }

    if (!type.equals("All")) {
        sql.append(" AND a.type = ?");
    }

    if (!material.equals("All")) {
        sql.append(" AND a.material = ?");
    }

    try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt =
                    conn.prepareStatement(sql.toString())
    ) {

        int index = 1;

        if (!dynasty.equals("All")) {
            pstmt.setString(index++, dynasty);
        }

        if (!region.equals("All")) {
            pstmt.setString(index++, region);
        }

        if (!type.equals("All")) {
            pstmt.setString(index++, type);
        }

        if (!material.equals("All")) {
            pstmt.setString(index++, material);
        }

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            artefacts.add(

                    new Artefact(
                            rs.getInt("artefact_id"),
                            rs.getString("name"),
                            rs.getString("type"),
                            rs.getString("material"),
                            rs.getString("Dynasty"),
                            rs.getString("Region"),
                            ""
                    )

            );
        }

    } catch (SQLException e) {

        e.printStackTrace();

    }

    return artefacts;
}


}
