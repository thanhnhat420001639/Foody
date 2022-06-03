package hcmute.tranhoanglong.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChiTietNhaHangActivity extends AppCompatActivity
{
    private Database db;
    private TextView txtView_TenNhaHang, txtView_TenNhaHangDanhMuc, txtView_TrangThaiMoCua, txtView_ThoiGianMoCua, txtView_DiaChi, txtView_KhoangCach, txtView_DanhMucAmthuc, txtView_KhoangGia, txtView_SSID, txtView_MatKhauWifi, txtView_XemthongTin;
    private ImageView imgView_BackHome, imgView_MoreOption, imgView_HinhDaiDien, imgView_TaiAnh , imgView_CheckIn , imgView_BinhLuan , imgView_Luu , imgView_ChiaSe, imgView_DiaDiemCungHeThong , imgView_WifiKhac;
    private LinearLayout linearLayout_LienHe;
    private String ten, diaChi, khuVuc, nghiLe, danhMuc, thichHop, amThuc, phucVuCacMon, SSID, matKhau, moCua, gia, tenThanhPho;
    private int hinhAnh;
    private String t;
    private ArrayList<MonAn> arr_MonAn;
    private MonAnAdapter adapter_MonAn;
    private ListView listView_MonAn;
    private LinearLayout ln_GioHang;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_nha_hang);

        Intent intent = getIntent();
        int id =  intent.getIntExtra("id", 0);
        Global.setIdNhaHang(id);

        // Lấy dữ liệu nhà hàng theo id
        db = new Database(this);
        Cursor dataChiTietNhaHang = db.GetData("SELECT * FROM NhaHang, ThanhPho WHERE NhaHang.ThanhPho = ThanhPho.IdThanhPho AND IdNhaHang = " + id );
        while (dataChiTietNhaHang.moveToNext())
        {
            ten = dataChiTietNhaHang.getString(1);
            diaChi = dataChiTietNhaHang.getString(2);
            hinhAnh = dataChiTietNhaHang.getInt(4);
            khuVuc = dataChiTietNhaHang.getString(5);
            nghiLe = dataChiTietNhaHang.getString(6);
            danhMuc = dataChiTietNhaHang.getString(7);
            thichHop = dataChiTietNhaHang.getString(8);
            amThuc = dataChiTietNhaHang.getString(9);
            phucVuCacMon = dataChiTietNhaHang.getString(10);
            SSID = dataChiTietNhaHang.getString(11);
            matKhau = dataChiTietNhaHang.getString(12);
            moCua = dataChiTietNhaHang.getString(13);
            gia = dataChiTietNhaHang.getString(14);
            tenThanhPho = dataChiTietNhaHang.getString(16);
        }
        txtView_TenNhaHang = findViewById(R.id.txtView_TenNhaHang);
        txtView_TenNhaHang.setText(ten);

        txtView_TenNhaHangDanhMuc = findViewById(R.id.txtView_TenNhaHangDanhMuc);
        t = ten + " - " + danhMuc;
        txtView_TenNhaHangDanhMuc.setText(t);

        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("HH:mm");
        int gioBD = Integer.parseInt(moCua.substring(0,2));
        int phutBD = Integer.parseInt(moCua.substring(3,5));
        int gioKT = Integer.parseInt(moCua.substring(8,10));
        int phutKT = Integer.parseInt(moCua.substring(11));
        int gioHT = Integer.parseInt(ft.format(date).substring(0,2));
        int phutHT = Integer.parseInt(ft.format(date).substring(3));

        txtView_TrangThaiMoCua = findViewById(R.id.txtView_TrangThaiMoCua);
        if (gioHT > gioBD)
        {
            if (gioHT < gioKT)
            {
                txtView_TrangThaiMoCua.setText("ĐANG MỞ CỬA");
                txtView_TrangThaiMoCua.setTextColor(getResources().getColor(R.color.green));
            }
            else
                if (gioHT == gioKT)
                {
                    if (phutHT < phutKT)
                    {
                        txtView_TrangThaiMoCua.setText("ĐANG MỞ CỬA");
                        txtView_TrangThaiMoCua.setTextColor(getResources().getColor(R.color.green));
                    }
                    else
                    {
                        txtView_TrangThaiMoCua.setText("CHƯA MỞ CỬA");
                        txtView_TrangThaiMoCua.setTextColor(getResources().getColor(R.color.gray));
                    }
                }
                else
                {
                    txtView_TrangThaiMoCua.setText("CHƯA MỞ CỬA");
                    txtView_TrangThaiMoCua.setTextColor(getResources().getColor(R.color.gray));
                }
        }
        else
            if (gioHT == gioBD)
            {
                if (phutHT >= phutBD)
                {
                    txtView_TrangThaiMoCua.setText("ĐANG MỞ CỬA");
                    txtView_TrangThaiMoCua.setTextColor(getResources().getColor(R.color.green));
                }
                else
                {
                    txtView_TrangThaiMoCua.setText("CHƯA MỞ CỬA");
                    txtView_TrangThaiMoCua.setTextColor(getResources().getColor(R.color.gray));
                }
            }
            else
            {
                txtView_TrangThaiMoCua.setText("CHƯA MỞ CỬA");
                txtView_TrangThaiMoCua.setTextColor(getResources().getColor(R.color.gray));
            }

        txtView_ThoiGianMoCua = findViewById(R.id.txtView_ThoiGianMoCua);
        txtView_ThoiGianMoCua.setText(moCua);

        txtView_DiaChi = findViewById(R.id.txtView_DiaChi);
        t = diaChi + ", " + tenThanhPho;
        txtView_DiaChi.setText(t);

        txtView_DanhMucAmthuc = findViewById(R.id.txtView_DanhMucAmThuc);
        t = danhMuc + " - " + amThuc;
        txtView_DanhMucAmthuc.setText(t);

        txtView_KhoangGia = findViewById(R.id.txtView_KhoangGia);
        txtView_KhoangGia.setText(gia);

        txtView_SSID = findViewById(R.id.txtView_SSID);
        txtView_SSID.setText(SSID);

        txtView_MatKhauWifi = findViewById(R.id.txtView_MatKhauWifi);
        txtView_MatKhauWifi.setText(matKhau);

        txtView_XemthongTin = findViewById(R.id.txtView_XemThongTin);
        txtView_XemthongTin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ChiTietNhaHangActivity.this, TatCaChiTietNhaHangActivity.class);
                startActivity(intent);
            }
        });

        imgView_BackHome = findViewById(R.id.imgView_BackHome);
        imgView_BackHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ChiTietNhaHangActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        imgView_HinhDaiDien = findViewById(R.id.imgView_HinhDaiDien);
        imgView_HinhDaiDien.setImageResource(hinhAnh);

        // GridView
        listView_MonAn = (ListView) findViewById(R.id.listView_MonAn);
        arr_MonAn = new ArrayList<>();
        adapter_MonAn = new MonAnAdapter(this, R.layout.row_monan, arr_MonAn);
        listView_MonAn.setAdapter(adapter_MonAn);

        GetDataMonAnTheoNhaHang();

        // ScrollView inside ScrollView
        ScrollView parentScroll = (ScrollView)findViewById(R.id.parent_scroll);
        listView_MonAn = (ListView)findViewById(R.id.listView_MonAn);

        parentScroll.setOnTouchListener(new View.OnTouchListener()
        {
                public boolean onTouch(View v, MotionEvent event)
                {
                    //Log.v(TAG,"PARENT TOUCH");
                    findViewById(R.id.listView_MonAn).getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
            });

        listView_MonAn.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View v, MotionEvent event)
            {
                //Log.v(TAG,"CHILD TOUCH");
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        ln_GioHang = findViewById(R.id.ln_GioHang);
        ln_GioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietNhaHangActivity.this, GioHangActivity.class);
                startActivity(intent);
            }
        });
    }

    private void GetDataMonAnTheoNhaHang()
    {
        Intent intent = getIntent();
        int id =  intent.getIntExtra("id", 0);
        // Select dữ liệu
        Cursor dataMonAn = db.GetData("SELECT * FROM MonAn WHERE IdNhaHang = " + id);
        arr_MonAn.clear();
        while (dataMonAn.moveToNext())
        {
            int idMonAn = dataMonAn.getInt(0);
            String tenMonAn = dataMonAn.getString(1);
            int hinhAnhMonAn = dataMonAn.getInt(3);
            int giaMonAn = dataMonAn.getInt(4);
            arr_MonAn.add(new MonAn(idMonAn, tenMonAn, hinhAnhMonAn, giaMonAn));
        }

        adapter_MonAn.notifyDataSetChanged();
    }
}