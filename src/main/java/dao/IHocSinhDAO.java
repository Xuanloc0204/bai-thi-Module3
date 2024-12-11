package dao;

import model.HocSinh;

import java.sql.SQLException;
import java.util.List;

public interface IHocSinhDAO {
    List<HocSinh> findAllSach() throws SQLException;
    List<HocSinh> findAllByHocSinhId(int book_id);
}
