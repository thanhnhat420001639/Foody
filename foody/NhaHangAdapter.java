package hcmute.tranhoanglong.foody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NhaHangAdapter extends BaseAdapter
{
    private Context context;
    private int layout;
    private ArrayList<NhaHang> arr_nhaHang;

    public NhaHangAdapter(Context context, int layout, ArrayList<NhaHang> arr_nhaHang)
    {
        this.context = context;
        this.layout = layout;
        this.arr_nhaHang = arr_nhaHang;
    }

    @Override
    public int getCount()
    {
        return arr_nhaHang.size();
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
        ImageView imgView_HinhAnh;
        TextView txtView_TenNhaHang;
        TextView txtView_DiaChi;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        NhaHangAdapter.ViewHolder holder;
        if (view == null)
        {
            holder = new NhaHangAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.imgView_HinhAnh = (ImageView) view.findViewById(R.id.imgView_HinhAnhNhaHang);
            holder.txtView_TenNhaHang = (TextView) view.findViewById(R.id.txtView_TenNhaHang);
            holder.txtView_DiaChi = (TextView) view.findViewById(R.id.txtView_DiaChi);
            view.setTag(holder);
        }
        else
        {
            holder = (NhaHangAdapter.ViewHolder) view.getTag();
        }

        final NhaHang nhaHang = arr_nhaHang.get(i);
        holder.imgView_HinhAnh.setImageResource(nhaHang.getHinhAnh());

        String tenNhaHang = nhaHang.getTenNhaHang();
        if(tenNhaHang.length() > 21)
        {
            tenNhaHang = tenNhaHang.substring(0, 21);
            tenNhaHang = tenNhaHang + "...";
            holder.txtView_TenNhaHang.setText(tenNhaHang);
        }
        else
            holder.txtView_TenNhaHang.setText(tenNhaHang);

        String diaChi = nhaHang.getDiaChi() + ", " + nhaHang.getTenThanhPho();
        if(diaChi.length() > 24)
        {
            diaChi = diaChi.substring(0, 24);
            diaChi = diaChi + "...";
            holder.txtView_DiaChi.setText(diaChi);
        }
        else
            holder.txtView_DiaChi.setText(diaChi);

        return view;
    }
}