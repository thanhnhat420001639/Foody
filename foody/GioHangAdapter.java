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

import java.util.List;

public class GioHangAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<GioHang> gioHangList;
    private Database db;

    public GioHangAdapter(Context context, int layout, List<GioHang> gioHangList) {
        this.context=context;
        this.layout=layout;
        this.gioHangList=gioHangList;
    }

    @Override
    public int getCount() {
        return gioHangList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder
    {
        TextView textViewTenMonAn,textViewSoLuong,textViewGia, textViewTongTien;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.textViewTenMonAn = (TextView) view.findViewById(R.id.textViewTenMonAn_Gio);
            holder.textViewSoLuong = (TextView) view.findViewById(R.id.textViewSoLuong_Gio);
            holder.textViewGia = (TextView) view.findViewById(R.id.textViewGia_Gio);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        db = new Database(context.getApplicationContext());

        final GioHang gio = gioHangList.get(i);
        String soluong =String.valueOf(gio.getSoLuong());
        String gia =String.valueOf(gio.getTien());
        String ten = "";

        Log.d("XXXX","4");
        Cursor t = db.GetData("SELECT TenMonAn FROM MonAn WHERE IdMonAn = " + gio.getIdMA());
        while (t.moveToNext())
        {
            ten = t.getString(0);
        }
        Log.d("XXXX","5");
        holder.textViewTenMonAn.setText(ten);
        holder.textViewSoLuong.setText("Số lượng: "+soluong);
        holder.textViewGia.setText("Giá: " + gia);
        return view;
    }
}
