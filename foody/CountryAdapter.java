package hcmute.tranhoanglong.foody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends BaseAdapter
{
    private Context context;
    private int layout;
    private ArrayList<Country> arr_country;

    public CountryAdapter(Context context, int layout, ArrayList<Country> arr_country)
    {
        this.context = context;
        this.layout = layout;
        this.arr_country = arr_country;
    }

    @Override
    public int getCount()
    {
        return arr_country.size();
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
        TextView txtView_Country;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ViewHolder holder;
        if (view == null)
        {
            holder = new CountryAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtView_Country = (TextView) view.findViewById(R.id.txtView_Country);
            view.setTag(holder);
        }
        else
        {
            holder = (CountryAdapter.ViewHolder) view.getTag();
        }

        final Country countryL = arr_country.get(i);
        holder.txtView_Country.setText(countryL.getCountry());

        return view;
    }
}