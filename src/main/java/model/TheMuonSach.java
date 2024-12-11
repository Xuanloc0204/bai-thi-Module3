package model;

import java.util.Date;

public class TheMuonSach {
    private int maMuonSach;
    private int maSachId;
    private int maHocSinhId;
    private boolean trangThai;  // TRUE: Đã mượn, FALSE: Đã trả
    private Date ngayMuon;
    private Date ngayTra;

    public TheMuonSach(int maMuonSach, int maSachId, int maHocSinhId, boolean trangThai, Date ngayMuon, Date ngayTra) {
        this.maMuonSach = maMuonSach;
        this.maSachId = maSachId;
        this.maHocSinhId = maHocSinhId;
        this.trangThai = trangThai;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public int getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(int maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public int getMaSachId() {
        return maSachId;
    }

    public void setMaSachId(int maSachId) {
        this.maSachId = maSachId;
    }

    public int getMaHocSinhId() {
        return maHocSinhId;
    }

    public void setMaHocSinhId(int maHocSinhId) {
        this.maHocSinhId = maHocSinhId;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public java.sql.Date getNgayMuon() {
        return (java.sql.Date) ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public java.sql.Date getNgayTra() {
        return (java.sql.Date) ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public boolean getTrangThai() {
        return false;
    }
}

