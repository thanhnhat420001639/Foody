package hcmute.tranhoanglong.foody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class HoaDonAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<HoaDon> hoaDonList;

    public HoaDonAdapter(Context context, int layout, List<HoaDon> congViecList) {
        this.context=context;
        this.layout=layout;
        this.hoaDonList=congViecList;
    }


    @Override
    public int getCount() {
        return hoaDonList.size();
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
        TextView textViewMaHoaDon,textViewTongTien;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.textViewMaHoaDon = (TextView) view.findViewById(R.id.textViewMaHoaDon);
            holder.textViewTongTien = (TextView) view.findViewById(R.id.textViewTongTien);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        final HoaDon hoaDon = hoaDonList.get(i);
        String id =String.valueOf(hoaDon.getIdHoaDon());
        String tien =String.valueOf(hoaDon.getTongTien());
        holder.textViewMaHoaDon.setText("Mã hóa đơn: "+id);
        holder.textViewTongTien.setText("Tổng tiền: "+tien);
        return view;
    }
}
