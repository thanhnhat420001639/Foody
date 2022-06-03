package hcmute.tranhoanglong.foody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class SearchActivity extends AppCompatActivity
{
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView image_BackHome;
    private TextView txtView_SearchType, txtView_SearchLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mTabLayout = findViewById(R.id.tabLayout_Search);
        mViewPager = findViewById(R.id.viewPager_Search);

        SearchViewPagerAdapter searchViewPagerAdapter = new SearchViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(searchViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        image_BackHome = (ImageView) findViewById(R.id.image_BackHome);
        image_BackHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        txtView_SearchType = (TextView) findViewById(R.id.txtView_SearchType);
        txtView_SearchType.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SearchActivity.this, SearchTypeActivity.class);
                startActivity(intent);
            }
        });

        txtView_SearchLocation = (TextView) findViewById(R.id.txtView_SearchLocation);
        txtView_SearchLocation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SearchActivity.this, SearchLocationActivity.class);
                startActivity(intent);
            }
        });
    }
}