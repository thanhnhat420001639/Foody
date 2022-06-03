package hcmute.tranhoanglong.foody;

public class Global {
    public static String TenTaiKhoan = "";
    public static String Ten = "";
    public static int idNhaHang = 0;

    public static int getIdNhaHang() {
        return idNhaHang;
    }

    public static void setIdNhaHang(int idNhaHang) {
        Global.idNhaHang = idNhaHang;
    }

    public static String getTen() {
        return Ten;
    }

    public static void setTen(String ten) {
        Ten=ten;
    }

    public static String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public static void setTenTaiKhoan(String tenTaiKhoan) {
        TenTaiKhoan=tenTaiKhoan;
    }

}
