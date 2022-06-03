package hcmute.tranhoanglong.foody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChiTietHDAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ChiTietHD> chiTietHDList;

    public ChiTietHDAdapter(Context context, int layout, List<ChiTietHD> chiTietHDList) {
        this.context=context;
        this.layout=layout;
        this.chiTietHDList=chiTietHDList;
    }

    @Override
    public int getCount() {
        return chiTietHDList.size();
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
        TextView textViewTenMonAn,textViewSoLuong,textViewTongTien1;
        ImageView imageViewMonAn;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.textViewTenMonAn = (TextView) view.findViewById(R.id.textViewTenMonAn);
            holder.textViewSoLuong = (TextView) view.findViewById(R.id.textViewSoLuong);
            holder.textViewTongTien1 = (TextView) view.findViewById(R.id.textViewTongTien1);
            holder.imageViewMonAn = (ImageView) view.findViewById(R.id.imageViewMonAn);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        final ChiTietHD chiTietHD = chiTietHDList.get(i);
        String soluong =String.valueOf(chiTietHD.getSoLuong());
        String tien =String.valueOf(chiTietHD.getTongTien());
        holder.textViewTenMonAn.setText(chiTietHD.getTenMonAn());
        holder.textViewSoLuong.setText("Số lượng: "+soluong);
        holder.textViewTongTien1.setText("Tổng tiền: "+tien);
        holder.imageViewMonAn.setImageResource(chiTietHD.getHinhAnh());
        return view;
    }
}
