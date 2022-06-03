package hcmute.tranhoanglong.foody;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class OrderListFragment extends Fragment
{
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    public OrderListFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_order_list, container, false);

        mTabLayout = rootView.findViewById(R.id.tabLayout_OrderList);
        mViewPager = rootView.findViewById(R.id.viewPager_OrderList);

        OrderListViewPagerAdapter orderListViewPagerAdapter = new OrderListViewPagerAdapter(requireActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(orderListViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        return rootView;
    }
}