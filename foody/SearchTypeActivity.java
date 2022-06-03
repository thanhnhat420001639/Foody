package hcmute.tranhoanglong.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchTypeActivity extends AppCompatActivity
{
    ListView listView_SearchType;
    ArrayList<String> array_SearchType;
    SearchTypeAdapter adapter_SearchType;
    ImageView image_BackSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_type);

        listView_SearchType = (ListView) findViewById(R.id.listView_SearchType);
        array_SearchType = new ArrayList<>();
        array_SearchType.clear();
        array_SearchType.add("Địa điểm");
        array_SearchType.add("Bộ sưu tập");
        array_SearchType.add("Hình ảnh");
        array_SearchType.add("Blogs");
        array_SearchType.add("Thành viên");
        adapter_SearchType = new SearchTypeAdapter(this, R.layout.row_searchtype, array_SearchType);
        listView_SearchType.setAdapter(adapter_SearchType);

        //adapter_SearchType.notifyDataSetChanged();

        image_BackSearch = (ImageView) findViewById(R.id.image_BackSearch);
        image_BackSearch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}