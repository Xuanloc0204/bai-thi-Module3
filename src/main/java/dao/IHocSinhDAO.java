package dao;

import model.HocSinh;

import java.sql.SQLException;
import java.util.List;

public interface IHocSinhDAO {
    List<HocSinh> findAllHS() throws SQLException;
    List<HocSinh> findAllByHocSinhId(int id) throws SQLException;
}
