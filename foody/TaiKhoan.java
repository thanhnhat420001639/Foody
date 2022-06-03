package hcmute.tranhoanglong.foody;

import android.app.Application;

public class TaiKhoan extends Application {
    private int IdTaiKhoan;
    private String Ten;
    private String TenTaiKhoan;
    private String MatKhau;
    private String SDT;
    private String Email;

    public TaiKhoan(int idTaiKhoan, String ten, String tenTaiKhoan, String matKhau, String SDT, String email) {
        IdTaiKhoan=idTaiKhoan;
        Ten=ten;
        TenTaiKhoan=tenTaiKhoan;
        MatKhau=matKhau;
        this.SDT=SDT;
        Email=email;
    }

    public int getIdTaiKhoan() {
        return IdTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        IdTaiKhoan=idTaiKhoan;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten=ten;
    }

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        TenTaiKhoan=tenTaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau=matKhau;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT=SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email=email;
    }



}

