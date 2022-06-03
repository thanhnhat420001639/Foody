package hcmute.tranhoanglong.foody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends BaseAdapter
{
    private Context context;
    private int layout;
    private List<Food> foodList;

    public FoodAdapter(Context context, int layout, List<Food> foodList)
    {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public int getCount()
    {
        return foodList.size();
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
        TextView txtView_FoodName;
        TextView txtView_FoodDescription;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ViewHolder holder;
        if (view == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtView_FoodName = (TextView) view.findViewById(R.id.txtView_FoodName);
            holder.txtView_FoodDescription = (TextView) view.findViewById(R.id.txtView_FoodDescription);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        final Food foodL = foodList.get(i);
        holder.txtView_FoodName.setText(foodL.getName());
        holder.txtView_FoodDescription.setText(foodL.getDescription());

        return view;
    }
}
