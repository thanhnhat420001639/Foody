package hcmute.tranhoanglong.foody;

public class GioHang
{
    private int idNH;
    private int idMA;
    private int SoLuong;
    private int tien;

    public GioHang(int idNH, int idMA, int soLuong, int tien) {
        this.idNH = idNH;
        this.idMA = idMA;
        SoLuong = soLuong;
        this.tien = tien;
    }

    public int getIdNH() {
        return idNH;
    }

    public void setIdNH(int idNH) {
        this.idNH = idNH;
    }

    public int getIdMA() {
        return idMA;
    }

    public void setIdMA(int idMA) {
        this.idMA = idMA;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }
}