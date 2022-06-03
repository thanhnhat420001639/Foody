package hcmute.tranhoanglong.foody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CityAdapter extends BaseAdapter
{
    private Context context;
    private int layout;
    private ArrayList<City> arr_city;

    public CityAdapter(Context context, int layout, ArrayList<City> arr_city)
    {
        this.context = context;
        this.layout = layout;
        this.arr_city = arr_city;
    }

    @Override
    public int getCount()
    {
        return arr_city.size();
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
        TextView txtView_City;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ViewHolder holder;
        if (view == null)
        {
            holder = new CityAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtView_City = (TextView) view.findViewById(R.id.txtView_City);
            view.setTag(holder);
        }
        else
        {
            holder = (CityAdapter.ViewHolder) view.getTag();
        }

        final City cityL = arr_city.get(i);
        holder.txtView_City.setText(cityL.getCity());

        return view;
    }
}