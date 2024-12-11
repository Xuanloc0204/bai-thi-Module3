package model;

public class HocSinh {
    private int id;
    private String hoTen;
    private String lop;

    public HocSinh(int id, String hoTen, String lop) {
        this.id = id;
        this.hoTen = hoTen;
        this.lop = lop;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}

