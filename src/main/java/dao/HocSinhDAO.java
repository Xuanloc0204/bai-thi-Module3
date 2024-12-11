package dao;

import connection.DatabaseConnection;
import model.HocSinh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HocSinhDAO implements IHocSinhDAO {
    private static final String SELECT_ALL_HOCSINH = "SELECT * FROM hocSinh";
    private static final Object SELECT_HOCSINH_BY_B_ID = "select id, hoTen, lop from category join book_category bc on category.id = bc.category_id and bc.book_id=?";
    private final DatabaseConnection databaseConnection = new DatabaseConnection();


    @Override
    public List<HocSinh> findAllSach() throws SQLException {
        List<HocSinh> hocSinhs = new ArrayList<>();
        try {
            PreparedStatement statement = databaseConnection.getConnection(SELECT_ALL_HOCSINH);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                HocSinh hocSinh = new HocSinh(id, name, description);
                hocSinhs.add(hocSinh);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hocSinhs;
    }

    @Override
    public List<HocSinh> findAllByHocSinhId(int book_id) {
        List<HocSinh> hocSinhs = new ArrayList<>();
        try {
            PreparedStatement statement1 = databaseConnection.getConnection(SELECT_HOCSINH_BY_B_ID);
            statement1.setInt(1, book_id);
            ResultSet resultSet = statement1.executeQuery();
//            ResultSet resultSet1 = statement1.getGeneratedKeys();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                HocSinh hocSinh = new HocSinh(id, name, description);
                hocSinhs.add(hocSinh);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hocSinhs;
    }

    public DatabaseConnection getDatabaseConnection() {
        return databaseConnection;
    }
}
