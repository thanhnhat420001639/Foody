package hcmute.tranhoanglong.foody;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SearchViewPagerAdapter extends FragmentPagerAdapter
{
    public SearchViewPagerAdapter(@NonNull FragmentManager fm, int behavior)
    {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        switch(position)
        {
            case 0:
                return new SearchFragment1();

            case 1:
                return new SearchFragment2();

            case 2:
                return new SearchFragment3();

            default:
                return new SearchFragment1();
        }
    }

    @Override
    public int getCount()
    {
        // Số lượng tab
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = "";
        switch(position)
        {
            case 0:
                title = "Xem gần đây";
                break;

            case 1:
                title = "Đặt gần đây";
                break;

            case 2:
                title = "Đã tìm";
                break;
        }
        return title;
    }
}