package hcmute.tranhoanglong.foody;

public class NhaHang
{
    private int idNhaHang;
    private String TenNhaHang;
    private String DiaChi;
    private int ThanhPho;
    private int HinhAnh;
    private String KhuVuc;
    private String NghiLe;
    private String DanhMuc;
    private String ThichHop;
    private String AmThuc;
    private String PhucVuCacMon;
    private String SSID;
    private String MatKhau;
    private String MoCua;
    private String Gia;
    private String TenThanhPho;

    public NhaHang(int idNhaHang, String tenNhaHang, String diaChi, int thanhPho, int hinhAnh, String khuVuc, String nghiLe, String danhMuc, String thichHop, String amThuc, String phucVuCacMon, String SSID, String matKhau, String moCua, String gia, String tenThanhPho)
    {
        this.idNhaHang = idNhaHang;
        TenNhaHang = tenNhaHang;
        DiaChi = diaChi;
        ThanhPho = thanhPho;
        HinhAnh = hinhAnh;
        KhuVuc = khuVuc;
        NghiLe = nghiLe;
        DanhMuc = danhMuc;
        ThichHop = thichHop;
        AmThuc = amThuc;
        PhucVuCacMon = phucVuCacMon;
        this.SSID = SSID;
        MatKhau = matKhau;
        MoCua = moCua;
        Gia = gia;
        TenThanhPho = tenThanhPho;
    }

    public NhaHang(int idNhaHang, String tenNhaHang, String diaChi, int hinhAnh, String tenThanhPho)
    {
        this.idNhaHang = idNhaHang;
        TenNhaHang = tenNhaHang;
        DiaChi = diaChi;
        HinhAnh = hinhAnh;
        TenThanhPho = tenThanhPho;
    }

    public int getIdNhaHang() {
        return idNhaHang;
    }

    public void setIdNhaHang(int idNhaHang) {
        this.idNhaHang = idNhaHang;
    }

    public String getTenNhaHang() {
        return TenNhaHang;
    }

    public void setTenNhaHang(String tenNhaHang) {
        TenNhaHang = tenNhaHang;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public int getThanhPho() {
        return ThanhPho;
    }

    public void setThanhPho(int thanhPho) {
        ThanhPho = thanhPho;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getKhuVuc() {
        return KhuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        KhuVuc = khuVuc;
    }

    public String getNghiLe() {
        return NghiLe;
    }

    public void setNghiLe(String nghiLe) {
        NghiLe = nghiLe;
    }

    public String getDanhMuc() {
        return DanhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        DanhMuc = danhMuc;
    }

    public String getThichHop() {
        return ThichHop;
    }

    public void setThichHop(String thichHop) {
        ThichHop = thichHop;
    }

    public String getAmThuc() {
        return AmThuc;
    }

    public void setAmThuc(String amThuc) {
        AmThuc = amThuc;
    }

    public String getPhucVuCacMon() {
        return PhucVuCacMon;
    }

    public void setPhucVuCacMon(String phucVuCacMon) {
        PhucVuCacMon = phucVuCacMon;
    }

    public String getSSID() {
        return SSID;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getMoCua() {
        return MoCua;
    }

    public void setMoCua(String moCua) {
        MoCua = moCua;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public String getTenThanhPho() {
        return TenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        TenThanhPho = tenThanhPho;
    }
}
