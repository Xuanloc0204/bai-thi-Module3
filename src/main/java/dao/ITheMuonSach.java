package dao;

import model.TheMuonSach;

import java.util.List;

public interface ITheMuonSach {

    void add(TheMuonSach theMuonSach);
    List<TheMuonSach> findAll();


}
