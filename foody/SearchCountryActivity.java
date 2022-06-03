package hcmute.tranhoanglong.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchCountryActivity extends AppCompatActivity
{
    Database db;
    ListView listView_Country;
    ArrayList<Country> array_Country;
    CountryAdapter adapter_Country;
    ImageView image_BackHome;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_country);

        db = new Database(this);

        listView_Country = (ListView) findViewById(R.id.listView_Country);
        array_Country = new ArrayList<>();
        adapter_Country = new CountryAdapter(this, R.layout.row_country, array_Country);
        listView_Country.setAdapter(adapter_Country);

        GetDataCountry();

        image_BackHome = (ImageView) findViewById(R.id.image_BackHome);
        image_BackHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }

    private void GetDataCountry()
    {
        // Select dữ liệu
        Cursor dataCountry = db.GetData("SELECT * FROM QuocGia");
        array_Country.clear();
        while (dataCountry.moveToNext())
        {
            int id = dataCountry.getInt(0);
            String country = dataCountry.getString(1);
            array_Country.add(new Country(id, country));
        }

        adapter_Country.notifyDataSetChanged();
    }
}