package hcmute.tranhoanglong.foody;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SavedViewPagerAdapter extends FragmentPagerAdapter
{
    public SavedViewPagerAdapter(@NonNull FragmentManager fm, int behavior)
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
                return new SavedFragment1();

            case 1:
                return new SavedFragment2();

            case 2:
                return new SavedFragment3();

            case 3:
                return new SavedFragment4();

            default:
                return new SavedFragment1();
        }
    }

    @Override
    public int getCount()
    {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = "";
        switch(position)
        {
            case 0:
                title = "Tất cả";
                break;

            case 1:
                title = "Địa điểm";
                break;

            case 2:
                title = "Hình ảnh";
                break;

            case 3:
                title = "Bài viết";
                break;
        }
        return title;
    }
}