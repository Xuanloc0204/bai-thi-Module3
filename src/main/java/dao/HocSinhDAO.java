package dao;

import connection.DatabaseConnection;
import model.HocSinh;
import model.Sach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HocSinhDAO implements IHocSinhDAO {
    private static final String SELECT_ALL_HOCSINH = "SELECT * FROM hocSinh";
    private static final String SELECT_HOCSINH_BY_B_ID = "SELECT id, hoTen, lop FROM Room WHERE roomId = ?";
    private final DatabaseConnection databaseConnection = new DatabaseConnection();


    @Override
    public List<HocSinh> findAllHS() throws SQLException {
        List<HocSinh> hocSinhs = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOCSINH)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HocSinh hocSinh = new HocSinh(
                        resultSet.getInt("id"),
                        resultSet.getString("hoTen"),
                        resultSet.getString("lop")
                );
                hocSinhs.add(hocSinh);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return hocSinhs;
    }

    @Override
    public List<HocSinh> findAllByHocSinhId(int id) throws SQLException {
        HocSinh hocSinh = null;
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_HOCSINH_BY_B_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                hocSinh = new HocSinh(
                        rs.getInt("id"),
                        rs.getString("hoTen"),
                        rs.getString("lop")
                );
            }
        }
        return (List<HocSinh>) hocSinh;
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
