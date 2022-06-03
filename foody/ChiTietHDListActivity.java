package hcmute.tranhoanglong.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class ChiTietHDListActivity extends AppCompatActivity {
    Database db = new Database(this);
    ListView listView_ChiTietHD;
    ArrayList<ChiTietHD> array_ChiTietHD;
    ChiTietHDAdapter adapter;
    ImageView imageViewBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_hdlist);
        listView_ChiTietHD = (ListView)findViewById(R.id.listView_ChiTietHD) ;
        array_ChiTietHD = new ArrayList<>();
        adapter = new ChiTietHDAdapter(this, R.layout.dong_chi_tiet_hoa_don, array_ChiTietHD);
        listView_ChiTietHD.setAdapter(adapter);
        Intent intent = getIntent();
        int id =  intent.getIntExtra("id", 0);
        GetDataChiTietHD(id);
        imageViewBack = (ImageView) findViewById(R.id.imageViewBack1);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
    private void GetDataChiTietHD(int id) {
        // Select dữ liệu
        Cursor data=db.GetData("SELECT HinhAnh,TenMonAn,SoLuong,Tien FROM ChiTietHD,MonAn where IdHoaDon = "+id+" and ChiTietHD.IdNhaHang = MonAn.IdNhaHang And ChiTietHD.IdMonAn = MonAn.IdMonAn");
        array_ChiTietHD.clear();
        while (data.moveToNext()) {
            int HinhAnh = data.getInt(0);
            String TenMonAn =data.getString(1);
            int Soluong = data.getInt(2);
            int Tien = data.getInt(3);
            array_ChiTietHD.add(new ChiTietHD(HinhAnh,TenMonAn,Soluong,Tien));
        }

        adapter.notifyDataSetChanged();
    }
}