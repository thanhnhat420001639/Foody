package hcmute.tranhoanglong.foody;

public class ChiTietHD {
    private int HinhAnh;
    private String TenMonAn;
    private int SoLuong;
    private int TongTien;

    public ChiTietHD(int hinhAnh, String tenMonAn, int soLuong, int tongTien) {
        HinhAnh=hinhAnh;
        TenMonAn=tenMonAn;
        SoLuong=soLuong;
        TongTien=tongTien;
    }


    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh=hinhAnh;
    }

    public String getTenMonAn() {
        return TenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        TenMonAn=tenMonAn;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong=soLuong;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int tongTien) {
        TongTien=tongTien;
    }
}
