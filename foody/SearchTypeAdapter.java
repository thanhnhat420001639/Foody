package hcmute.tranhoanglong.foody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchTypeAdapter extends BaseAdapter
{
    private Context context;
    private int layout;
    private ArrayList<String> arr_searchType;

    public SearchTypeAdapter(Context context, int layout, ArrayList<String> arr_searchType)
    {
        this.context = context;
        this.layout = layout;
        this.arr_searchType = arr_searchType;
    }

    @Override
    public int getCount()
    {
        return arr_searchType.size();
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
        TextView txtView_SearchType;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        SearchTypeAdapter.ViewHolder holder;
        if (view == null)
        {
            holder = new SearchTypeAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtView_SearchType = (TextView) view.findViewById(R.id.txtView_SearchType);
            view.setTag(holder);
        }
        else
        {
            holder = (SearchTypeAdapter.ViewHolder) view.getTag();
        }

        final String searchTypeL = arr_searchType.get(i);
        holder.txtView_SearchType.setText(searchTypeL);

        return view;
    }
}