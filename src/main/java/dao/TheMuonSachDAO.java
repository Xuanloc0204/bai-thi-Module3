package dao;

import model.HocSinh;
import model.TheMuonSach;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheMuonSachDAO implements ITheMuonSach {

    @Override
    public List<TheMuonSach> findAllBySachId(int id) {
        return List.of();
    }

    @Override
    public List<TheMuonSach> findAllByHocSinhId(int id) {
        return List.of();
    }

    @Override
    public List<TheMuonSach> findAll() {
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
}
