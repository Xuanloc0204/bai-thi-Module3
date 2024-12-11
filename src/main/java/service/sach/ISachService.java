package service.sach;

import model.Sach;

import java.sql.SQLException;
import java.util.List;

public interface ISachService{
    List<Sach> findAllSach() throws SQLException;
}
