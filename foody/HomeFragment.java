package hcmute.tranhoanglong.foody;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment
{
    private Database db;
    private GridView gridView_NhaHang;
    private ArrayList<NhaHang> array_NhaHang;
    private NhaHangAdapter adapter_NhaHang;
    private TextView txtView_Search, txtView_SearchLocation;
    private TextView txtView_XemGanDay, txtView_GanToi;

    public HomeFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // GridView
        gridView_NhaHang = (GridView) rootView.findViewById(R.id.gridView_NhaHang);
        array_NhaHang = new ArrayList<>();
        adapter_NhaHang = new NhaHangAdapter(getActivity(), R.layout.cell_nhahang, array_NhaHang);
        gridView_NhaHang.setAdapter(adapter_NhaHang);

        // Xem thông tin chi tiết
        gridView_NhaHang.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent = new Intent(getActivity(),ChiTietNhaHangActivity.class);
                intent.putExtra("id", array_NhaHang.get(i).getIdNhaHang());
                startActivity(intent);
            }
        });

        // SQLite
        db = new Database(getActivity());
        CreateDB();
        //AddData();
        GetDataNhaHang();

        // Thanh tìm kiếm theo tên
        txtView_Search = (TextView) rootView.findViewById(R.id.txtView_Search);
        txtView_Search.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        // Thanh tìm kiếm theo địa điểm
        txtView_SearchLocation = (TextView) rootView.findViewById(R.id.txtView_SearchLocation);
        txtView_SearchLocation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), SearchLocationActivity.class);
                startActivity(intent);
            }
        });

        // Xem gần đây
        txtView_XemGanDay = (TextView) rootView.findViewById(R.id.txtView_XemGanDay);
        txtView_XemGanDay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtView_XemGanDay.setTextColor(getResources().getColor(R.color.black));
                txtView_GanToi.setTextColor(getResources().getColor(R.color.gray));
                GetDataNhaHang();
            }
        });

        // Gần tôi
        txtView_GanToi = (TextView) rootView.findViewById(R.id.txtView_GanToi);
        txtView_GanToi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtView_GanToi.setTextColor(getResources().getColor(R.color.black));
                txtView_XemGanDay.setTextColor(getResources().getColor(R.color.gray));
                GetDataNhaHang2();
            }
        });

        return rootView;
    }

    private void CreateDB()
    {
        // Tạo bảng NhaHang
        db.QueryData("CREATE TABLE IF NOT EXISTS NhaHang(IdNhaHang INTEGER PRIMARY KEY AUTOINCREMENT, TenNhaHang NVARCHAR(255), DiaChi NVARCHAR(255), ThanhPho INTEGER, HinhAnh INTEGER, KhuVuc NVARCHAR(255), NghiLe NVARCHAR(255), DanhMuc NVARCHAR(255), ThichHop NVARCHAR(255), AmThuc NVARCHAR(255), PhucVuCacMon NVARCHAR(255), SSID NVARCHAR(255), MatKhau NVARCHAR(255), MoCua NVARCHAR(255), Gia NVARCHAR(255))");

        // Tạo bảng MonAn
        db.QueryData("CREATE TABLE IF NOT EXISTS MonAn(IdMonAn INTEGER PRIMARY KEY AUTOINCREMENT, TenMonAn NVARCHAR(255), IdNhaHang INTEGER, HinhAnh INTEGER, GiaTien INTEGER)");

        // Tạo bảng ThanhPho
        db.QueryData("CREATE TABLE IF NOT EXISTS ThanhPho(IdThanhPho INTEGER PRIMARY KEY AUTOINCREMENT, TenThanhPho NVARCHAR(255), IdQuocGia INTEGER)");

        // Tạo bảng QuocGia
        db.QueryData("CREATE TABLE IF NOT EXISTS QuocGia(IdQuocGia INTEGER PRIMARY KEY AUTOINCREMENT, TenQuocGia NVARCHAR(255))");

        // Tạo bảng TaiKhoan
        db.QueryData("CREATE TABLE IF NOT EXISTS TaiKhoan(IdTaiKhoan INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(255), TenTaiKhoan VARCHAR(255), MatKhau VARCHAR(255), SDT VARCHAR(255), Email VARCHAR(255))");

        // Tạo bảng HoaDon
        db.QueryData("CREATE TABLE IF NOT EXISTS HoaDon(IdHoaDon INTEGER PRIMARY KEY, TenTaiKhoan VARCHAR(255), TongTien INTEGER)");

        // Tạo bảng ChiTietHD
        db.QueryData("CREATE TABLE IF NOT EXISTS ChiTietHD(IdHoaDon INTEGER, IdNhaHang INTEGER, IdMonAn INTEGER, SoLuong INTEGER, Tien INTEGER, PRIMARY KEY (IdHoaDon, IdMonAn))");

        // Tạo bảng GioHang
        db.QueryData("CREATE TABLE IF NOT EXISTS GioHang(IdNhaHang INTEGER, IdMonAn INTEGER, SoLuong INTEGER, Gia INTEGER, PRIMARY KEY (IdNhaHang, IdMonAn))");
    }

    private void AddData()
    {
        // QuocGia
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'Vietnam')");
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'Malaysia')");
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'Singapore')");
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'Myanmar')");
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'Cambodia')");
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'Philippines')");
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'Australia')");
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'United States')");
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'Canada')");
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'Taiwan')");
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'China')");
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'Hong Kong')");
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'Japan')");
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'Laos')");
        db.QueryData("INSERT INTO QuocGia VALUES(null, 'South korea')");

        // ThanhPho
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'TP.HCM', 1)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Hà Nội', 1)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Đà Nẵng', 1)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Hải Phòng', 1)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Cần Thơ', 1)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Đồng Nai', 1)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Vũng Tàu', 1)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'An Giang', 1)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Bạc Liêu', 1)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Bắc Kạn', 1)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Kuala Lumpur', 2)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Selangor', 2)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Putra Jaya', 2)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Malacca', 2)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Johor', 2)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Kedah', 2)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Kelantan', 2)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Negeri Sembilan', 2)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Pahang', 2)");
        db.QueryData("INSERT INTO ThanhPho VALUES(null, 'Penang', 2)");

        // NhaHang
        db.QueryData("INSERT INTO NhaHang VALUES(null, 'Rules Of Tea', '213D Nguyễn Văn Cừ, P. 3, Quận 5', 1, " + R.drawable.nhahang_1 + ", 'Nowzone - Nguyễn Văn Cừ', 'Các ngày lễ trong năm', 'Café/Dessert', 'Buổi sáng, Buổi trưa, Buổi xế, Buổi tối', 'Đài Loan', 'Trà, Trà sữa', 'KUNGFUTEA L1', 'kungfuq5', '06:30 - 21:00', '35,000 đồng - 55,000 đồng')");
        db.QueryData("INSERT INTO NhaHang VALUES(null, 'Anh Quán - Mì Khô Gà Quay & Hủ Tiếu Mì Sủi Cảo', '80/17/138 Dương Quảng Hàm, P. 5, Gò Vấp', 1, " + R.drawable.nhahang_2 + ", 'Dương Quảng Hàm', 'Các ngày lễ trong năm', 'Quán ăn', 'Buổi sáng, Buổi trưa, Buổi xế, Buổi tối', 'Món Trung Hoa', 'Thịt gà, Món nước, Cơm', 'Thêm Wifi', 'Tạo mật khẩu', '06:00 - 20:00', '45,000 đồng - 55,000 đồng')");
        db.QueryData("INSERT INTO NhaHang VALUES(null, 'Thành Mập', '159/49/9 Bạch Đằng, P. 2, Quận Tân Bình', 1, " + R.drawable.nhahang_3 + ", 'Trường Sơn - Sân Bay', 'Các ngày lễ trong năm', 'Shop Online', 'Buổi trưa, Buổi xế, Buổi tối', 'Món Việt', 'Thịt gà, Chè, Bánh - Kẹo', 'Thu Thảo', '11011964', '08:00 - 23:00', '65,000 đồng - 210,000 đồng')");
        db.QueryData("INSERT INTO NhaHang VALUES(null, 'Lẩu Đức Trọc', '61 Ngõ 298 Tây Sơn, P. Ngã Tư Sở, Đống Đa', 2, " + R.drawable.nhahang_4 + ", 'Thái Hà Thái Thịnh', 'Các ngày lễ trong năm', 'Nhà hàng', 'Buổi trưa, Buổi xế, Buổi tối', 'Món Việt', 'Thịt gà, Tôm, Thịt dê, Thịt ếch, Thịt bò, Thịt heo, Cá, Mực, Ăn Vặt - Ăn nhẹ', 'Thêm Wifi', 'Tạo mật khẩu', '10:00 - 23:00', '80,000 đồng - 500,000 đồng')");
        db.QueryData("INSERT INTO NhaHang VALUES(null, 'Bánh Canh Ghẹ 82', ' 15 Hàng Hương, P. Hàng Mã, Quận Hoàn Kiếm', 2, " + R.drawable.nhahang_5 + ", '', 'Các ngày lễ trong năm', 'Quán Ăn', 'Buổi trưa', 'Món Miền Nam', 'Bún, Hải sản', 'Thêm Wifi', 'Tạo mật khẩu', '10:00 - 17:00', '5,000 đồng - 55,000 đồng')");
        db.QueryData("INSERT INTO NhaHang VALUES(null, 'Gà Rán KFC - Vinmart', '42 Đường 30 Tháng 4, P. An Phú, Quận Ninh Kiều', 5, " + R.drawable.nhahang_6 + ", 'Bến Ninh Kiều', 'Các ngày lễ trong năm', 'Nhà Hàng', 'Buổi sáng, Buổi trưa, Buổi xế, Buổi tối', 'Món Việt, Mỹ', 'Gà rán, Hamburger, Beefsteak - Bò né, Cá, Súp, Salad, Cơm, FastFood - Thức ăn nhanh', 'Nha tro Hoang Tung 1', 'passkhongco', '09:00 - 22:00', '30,000 đồng - 88,000 đồng')");
        db.QueryData("INSERT INTO NhaHang VALUES(null, 'Don Chicken - Nhà Hàng Gà Nướng Hàn Quốc', '42 Trần Văn Khéo, P. Cái Khế, Quận Ninh Kiều', 5, " + R.drawable.nhahang_7 + ", 'Sân Vận Động Cần Thơ', 'Các ngày lễ trong năm', 'Nhà hàng', 'Buổi sáng, Buổi trưa, Buổi xế, Buổi tối', 'Món Hàn', 'Thịt gà, Ăn vặt, Ăn nhẹ, Cơm', 'don checken', 'ilovedonchicken42', '10:00 - 22:00', '50,000 đồng - 300,000 đồng')");
        db.QueryData("INSERT INTO NhaHang VALUES(null, 'TocoToco Bubble Tea', '306 Nguyễn Tri Phương, P. 4, Quận 10', 1, " + R.drawable.nhahang_8 + ", 'Ngã Sáu Nguyễn Tri Phương', 'Các ngày lễ trong năm', 'Café/Dessert', 'Buổi sáng, Buổi trưa, Buổi xế, Buổi tối', 'Món Việt', 'Trà, Sinh tố - Nước ép, Trà sữa, Sữa', 'tocotoco wifi', '1900636936', '09:30 - 22:30', '28,000 đồng - 89,000 đồng')");
        db.QueryData("INSERT INTO NhaHang VALUES(null, 'Bún Chả Gốc Đề', '90 Lạc Trung, Quận Hai Bà Trưng', 2, " + R.drawable.nhahang_9 + ", 'Chợ Quỳnh Mai', 'Các ngày lễ trong năm', 'Quán ăn', 'Buổi sáng, Buổi trưa, Buổi xế, Buổi tối', 'Món Việt', 'Bún', 'Thêm Wifi', 'Tạo mật khẩu', '08:00 - 14:30', '30,000 đồng - 66,000 đồng')");
        db.QueryData("INSERT INTO NhaHang VALUES(null, 'Mì Cay Omega', '20 Trần Hưng Đạo, Quận Ninh Kiều', 5, " + R.drawable.nhahang_10 + ", 'Đại học Cần Thơ', 'Các ngày lễ trong năm', 'Quán Ăn', 'Buổi sáng, Buổi trưa, Buổi xế, Buổi tối', 'Món Hàn', 'Món nước', 'diaocminhphuong1', 'ctyminhphuong', '08:00 - 22:00', '15,000 đồng - 55,000 đồng')");

        // MonAn
        db.QueryData("INSERT INTO MonAn VALUES(null, 'Trà Sữa Đế Vương', 1, " + R.drawable.monan_1 + ", 35000)");
        db.QueryData("INSERT INTO MonAn VALUES(null, 'Mì khô gà quay cọng lớn', 2, " + R.drawable.monan_2 + ", 46800)");
        db.QueryData("INSERT INTO MonAn VALUES(null, 'Chân Gà Rút Xương Ngâm Sả Tắc', 3, " + R.drawable.monan_3 + ", 210000)");
        db.QueryData("INSERT INTO MonAn VALUES(null, 'Lẩu Thái Chua Cay Set 2', 4, " + R.drawable.monan_4 + ", 460750)");
        db.QueryData("INSERT INTO MonAn VALUES(null, 'Bánh Canh Hải Sản', 5, " + R.drawable.monan_5 + ", 55000)");
        db.QueryData("INSERT INTO MonAn VALUES(null, '1 miếng Gà Tokbokki', 6, " + R.drawable.monan_6 + ", 40000)");
        db.QueryData("INSERT INTO MonAn VALUES(null, 'Combo Cơm Gà Xốt Teriyaki', 6, " + R.drawable.monan_7 + ", 42000)");
        db.QueryData("INSERT INTO MonAn VALUES(null, 'Burger Zinger', 6, " + R.drawable.monan_8 + ", 50000)");
        db.QueryData("INSERT INTO MonAn VALUES(null, 'Gà phô mai tuyết', 7, " + R.drawable.monan_9 + ", 178200)");
        db.QueryData("INSERT INTO MonAn VALUES(null, 'Hộp gà nướng & rán 4 vị', 7, " + R.drawable.monan_10 + ", 342654)");

        // TaiKhoan
        db.QueryData("INSERT INTO TaiKhoan VALUES(null, 'Thành Nhất', 'nhat123','123','0123445678','nhat@gmail.com')");
        db.QueryData("INSERT INTO TaiKhoan VALUES(null, 'Hoàng Long', 'long123','123','0123445678','long@gmail.com')");

    }

    private void GetDataNhaHang()
    {
        // Select dữ liệu
        Cursor dataNhaHang = db.GetData("SELECT * FROM NhaHang, ThanhPho WHERE NhaHang.ThanhPho = ThanhPho.IdThanhPho");
        array_NhaHang.clear();
        while (dataNhaHang.moveToNext())
        {
            int id = dataNhaHang.getInt(0);
            String ten = dataNhaHang.getString(1);
            String diaChi = dataNhaHang.getString(2);
            int hinhAnh = dataNhaHang.getInt(4);
            String tenThanhPho = dataNhaHang.getString(16);
            array_NhaHang.add(new NhaHang(id, ten, diaChi, hinhAnh, tenThanhPho));
        }

        adapter_NhaHang.notifyDataSetChanged();
    }

    private void GetDataNhaHang2()
    {
        // Select dữ liệu
        Cursor dataNhaHang = db.GetData("SELECT * FROM NhaHang, ThanhPho WHERE NhaHang.ThanhPho = ThanhPho.IdThanhPho AND IdThanhPho = " + 1);
        array_NhaHang.clear();
        while (dataNhaHang.moveToNext())
        {
            int id = dataNhaHang.getInt(0);
            String ten = dataNhaHang.getString(1);
            String diaChi = dataNhaHang.getString(2);
            int hinhAnh = dataNhaHang.getInt(4);
            String tenThanhPho = dataNhaHang.getString(16);
            array_NhaHang.add(new NhaHang(id, ten, diaChi, hinhAnh, tenThanhPho));
        }

        adapter_NhaHang.notifyDataSetChanged();
    }
}