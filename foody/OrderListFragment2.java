package hcmute.tranhoanglong.foody;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class OrderListFragment2 extends Fragment
{
    Database db;
    ListView listView_HoaDon;
    ArrayList<HoaDon> array_HoaDon;
    HoaDonAdapter adapter;
    public OrderListFragment2()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if(!Global.getTen().equals(""))
        {
            db = new Database(getActivity());
            View rootView = inflater.inflate(R.layout.fragment_order_list2_1, container, false);
            listView_HoaDon = (ListView)rootView.findViewById(R.id.listView_HoaDon) ;
            array_HoaDon = new ArrayList<>();
            adapter = new HoaDonAdapter(getActivity(), R.layout.dong_hoa_don, array_HoaDon);
            listView_HoaDon.setAdapter(adapter);

            GetDataHoaDon();
            listView_HoaDon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getActivity(),ChiTietHDListActivity.class);
                    intent.putExtra("id", array_HoaDon.get(i).getIdHoaDon());
                    startActivity(intent);
                }
            });
            return rootView;
        }
        else
        {

            return inflater.inflate(R.layout.fragment_order_list2, container, false);
        }
    }
    private void GetDataHoaDon()
    {
        // Select dữ liệu
        Cursor dataHoaDon = db.GetData("SELECT * FROM HoaDon where TenTaiKhoan = '"+Global.getTenTaiKhoan()+"'");
        array_HoaDon.clear();
        while (dataHoaDon.moveToNext())
        {
            int id = dataHoaDon.getInt(0);
            int tien = dataHoaDon.getInt(2);
            array_HoaDon.add(new HoaDon(id, tien));
        }

        adapter.notifyDataSetChanged();
    }
}