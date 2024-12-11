package dao;

import connection.DatabaseConnection;
import model.HocSinh;
import model.TheMuonSach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TheMuonSachDAO implements ITheMuonSach {
    private static final String INSERT_MUONSACH_SQL = "INSERT INTO Room (maMuonSach, maSachId, maHocSinhId, trangThai, ngayMuon, ngayTra) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_MUONSACH = "SELECT * FROM theMuonSach";
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public void add(TheMuonSach theMuonSach) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MUONSACH_SQL)) {
            preparedStatement.setInt(1, theMuonSach.getMaMuonSach());
            preparedStatement.setInt(2, theMuonSach.getMaSachId());
            preparedStatement.setInt(3, theMuonSach.getMaHocSinhId());
            preparedStatement.setBoolean(4, theMuonSach.getTrangThai());
            preparedStatement.setDate(5, theMuonSach.getNgayMuon());
            preparedStatement.setDate(6, theMuonSach.getNgayTra());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<TheMuonSach> findAll() {
        List<TheMuonSach> theMuonSaches = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MUONSACH)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TheMuonSach theMuonSach = new TheMuonSach(
                        resultSet.getInt("maMuonSach"),
                        resultSet.getInt("maSachId"),
                        resultSet.getInt("maHocSinhId"),
                        resultSet.getBoolean("trangThai"),
                        resultSet.getDate("ngayMuon"),
                        resultSet.getDate("ngayTra")
                );
                theMuonSaches.add(theMuonSach);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return theMuonSaches;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.err.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
