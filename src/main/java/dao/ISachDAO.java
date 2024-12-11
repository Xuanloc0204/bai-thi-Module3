package dao;

import model.Sach;

import java.sql.SQLException;
import java.util.List;

public interface ISachDAO {
    List<Sach> findAllSach() throws SQLException;
}

