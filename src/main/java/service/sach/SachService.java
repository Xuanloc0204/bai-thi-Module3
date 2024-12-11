package service.sach;

import dao.ISachDAO;
import dao.SachDAO;
import model.Sach;

import java.sql.SQLException;
import java.util.List;

public class SachService implements ISachService{
    private final ISachDAO sachDAO = new SachDAO();
    @Override
    public List<Sach> findAllSach() throws SQLException {
        return sachDAO.findAllSach();
    }
}
