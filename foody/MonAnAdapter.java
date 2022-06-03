package hcmute.tranhoanglong.foody;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter
{
    private Context context;
    private int layout;
    private ArrayList<MonAn> arr_MonAn;
    private Database db;

    public MonAnAdapter(Context context, int layout, ArrayList<MonAn> arr_MonAn)
    {
        this.context = context;
        this.layout = layout;
        this.arr_MonAn = arr_MonAn;
    }

    @Override
    public int getCount()
    {
        return arr_MonAn.size();
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    private class ViewHolder
    {
        ImageView imgView_HinhAnhMonAn;
        TextView txtView_TenMonAn;
        TextView txtView_GiaTien;
        ImageView imgView_ThemMonAn;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        MonAnAdapter.ViewHolder holder;
        if (view == null)
        {
            holder = new MonAnAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.imgView_HinhAnhMonAn = (ImageView) view.findViewById(R.id.imgView_HinhAnhMonAn);
            holder.txtView_TenMonAn = (TextView) view.findViewById(R.id.txtView_TenMonAn);
            holder.txtView_GiaTien = (TextView) view.findViewById(R.id.txtView_GiaTien);
            holder.imgView_ThemMonAn = (ImageView) view.findViewById(R.id.imgView_ThemMonAn);
            view.setTag(holder);
        }
        else
        {
            holder = (MonAnAdapter.ViewHolder) view.getTag();
        }

        final MonAn monAn = arr_MonAn.get(i);
        holder.imgView_HinhAnhMonAn.setImageResource(monAn.getHinhAnh());
        holder.txtView_TenMonAn.setText(monAn.getTenMonAn());
        String giaTien = monAn.getGiaTien() + "đ";
        holder.txtView_GiaTien.setText(giaTien);
        holder.imgView_ThemMonAn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ThemMonAn(Global.getIdNhaHang(), monAn.getIdMonAn(), monAn.getGiaTien());
                Toast.makeText(context.getApplicationContext(), "Thêm món ăn vào giỏ thành công", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void ThemMonAn(int idNH, int idMA, int gia)
    {
        db = new Database(context.getApplicationContext());

        int sl = 0;
        Cursor t = db.GetData("SELECT * FROM GioHang WHERE IdNhaHang = " + idNH + " AND IdMonAn = " + idMA);
        while (t.moveToNext())
        {
            sl = t.getInt(2);
        }
        sl = sl + 1;
        if (sl == 1)
            db.QueryData("INSERT INTO GioHang VALUES(" + idNH + "," + idMA + ", " + sl + ", " + gia + ")");
        else
            db.QueryData("UPDATE GioHang SET SoLuong = " + sl + " WHERE IdNhaHang = " + idNH + " AND IdMonAn = " + idMA);
    }
}
