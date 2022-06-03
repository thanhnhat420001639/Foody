package hcmute.tranhoanglong.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GioHangActivity extends AppCompatActivity {
    Database db = new Database(this);
    ListView listView_ListGioHang;
    ArrayList<GioHang> array_GioHang;
    GioHangAdapter adapter;
    ImageView imageViewBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        listView_ListGioHang = (ListView)findViewById(R.id.listView_ListGioHang) ;
        array_GioHang = new ArrayList<>();
        adapter = new GioHangAdapter(this, R.layout.dong_giohang, array_GioHang);
        listView_ListGioHang.setAdapter(adapter);

        GetDataGioHang();
        imageViewBack = (ImageView) findViewById(R.id.imageViewBack1);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btn_DatHang = findViewById(R.id.btn_DatHang);
        btn_DatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(Global.getTenTaiKhoan().equals(""))
                {
                    Toast.makeText(GioHangActivity.this, "Vui lòng đăng nhập", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int tong = 0;
                    int idHD = 0;
                    Cursor data_1 = db.GetData("Select Max(IdHoaDon) from HoaDon");
                    while (data_1.moveToNext()) {
                        idHD = data_1.getInt(0);
                    }
                    idHD = idHD +1;
                    Cursor data = db.GetData("SELECT * FROM GioHang");
                    while (data.moveToNext()) {
                        int idNH = data.getInt(0);
                        int idMA = data.getInt(1);
                        int Soluong = data.getInt(2);
                        int Tien = data.getInt(3);
                        int TongTienMon = Soluong * Tien;
                        tong = tong + TongTienMon;
                        db.QueryData("INSERT INTO ChiTietHD VALUES(" + idHD + ", " + idNH + ", " + idMA + ", " + Soluong + ", " +  TongTienMon + ")");
                    }

                    db.QueryData("INSERT INTO HoaDon VALUES(" + idHD + " ,'" + Global.getTenTaiKhoan() + "', " + tong + ")");
                    db.QueryData("DELETE FROM GioHang");
                    Toast.makeText(GioHangActivity.this, "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void GetDataGioHang()
    {
        // Select dữ liệu
        Cursor data = db.GetData("SELECT * FROM GioHang");
        array_GioHang.clear();
        while (data.moveToNext()) {
            int idNH = data.getInt(0);
            int idMA = data.getInt(1);
            int Soluong = data.getInt(2);
            int Tien = data.getInt(3);
            array_GioHang.add(new GioHang(idNH,idMA,Soluong,Tien));
        }

        adapter.notifyDataSetChanged();
    }
}