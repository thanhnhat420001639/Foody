package hcmute.tranhoanglong.foody;

public class HoaDon{
    private int IdHoaDon;
    private int TongTien;

    public HoaDon(int idHoaDon, int tongTien) {
        IdHoaDon=idHoaDon;
        TongTien=tongTien;
    }

    public int getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        IdHoaDon=idHoaDon;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int tongTien) {
        TongTien=tongTien;
    }
}
