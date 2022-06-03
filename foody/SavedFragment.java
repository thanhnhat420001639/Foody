package hcmute.tranhoanglong.foody;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class SavedFragment extends Fragment
{
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView image_Search;

    public SavedFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_saved, container, false);

        mTabLayout = rootView.findViewById(R.id.tabLayout_Saved);
        mViewPager = rootView.findViewById(R.id.viewPager_Saved);

        SavedViewPagerAdapter savedViewPagerAdapter = new SavedViewPagerAdapter(requireActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(savedViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        image_Search = (ImageView) rootView.findViewById(R.id.image_Search);
        image_Search.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}