package hcmute.tranhoanglong.foody;

public class MonAn
{
    private int idMonAn;
    private String tenMonAn;
    private int hinhAnh;
    private int giaTien;

    public MonAn(int idMonAn, String tenMonAn, int hinhAnh, int giaTien)
    {
        this.idMonAn = idMonAn;
        this.tenMonAn = tenMonAn;
        this.hinhAnh = hinhAnh;
        this.giaTien = giaTien;
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }
}
