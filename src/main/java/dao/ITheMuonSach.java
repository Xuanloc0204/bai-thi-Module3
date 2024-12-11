package dao;

import model.TheMuonSach;

import java.util.List;

public interface ITheMuonSach {

    List<TheMuonSach> findAllBySachId(int id);
    List<TheMuonSach> findAllByHocSinhId(int id);
    List<TheMuonSach> findAll();


}
