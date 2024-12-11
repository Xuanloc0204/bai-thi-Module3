package dao;

import connection.DatabaseConnection;
import model.Sach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachDAO implements ISachDAO {
    private static final String SELECT_ALL_SACH = "SELECT * FROM sach";;
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public List<Sach> findAllSach() throws SQLException {
        List<Sach> saches = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SACH)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sach sach = new Sach(
                        resultSet.getInt("id"),
                        resultSet.getString("tenSach"),
                        resultSet.getString("tacGia"),
                        resultSet.getString("moTa"),
                        resultSet.getInt("soLuong")
                );
                saches.add(sach);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return saches;
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
