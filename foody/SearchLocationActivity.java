package hcmute.tranhoanglong.foody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchLocationActivity extends AppCompatActivity
{
    private Database db;
    private ListView listView_City;
    private ArrayList<City> array_City;
    private CityAdapter adapter_City;
    private ImageView image_BackHome;
    private LinearLayout linearLayout_SearchCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_location);

        db = new Database(this);

        // ListView
        listView_City = (ListView) findViewById(R.id.listView_City);
        array_City = new ArrayList<>();
        adapter_City = new CityAdapter(this, R.layout.row_city, array_City);
        listView_City.setAdapter(adapter_City);

        GetDataCity();

        image_BackHome = (ImageView) findViewById(R.id.image_BackHome);
        image_BackHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        linearLayout_SearchCountry = (LinearLayout) findViewById(R.id.linearLayout_SearchCountry);
        linearLayout_SearchCountry.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SearchLocationActivity.this, SearchCountryActivity.class);
                startActivity(intent);
            }
        });
    }

    private void GetDataCity()
    {
        // Select dữ liệu
        Cursor dataCity = db.GetData("SELECT * FROM ThanhPho");
        array_City.clear();
        while (dataCity.moveToNext())
        {
            int id = dataCity.getInt(0);
            String city = dataCity.getString(1);
            array_City.add(new City(id, city));
        }

        adapter_City.notifyDataSetChanged();
    }
}