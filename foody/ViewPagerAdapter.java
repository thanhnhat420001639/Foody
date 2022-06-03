package hcmute.tranhoanglong.foody;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ServiceFragment();

            case 1:
                return new MineFragment();

            case 2:
                return new NewsFragment();

            default:
                return new ServiceFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Dịch vụ";
                break;
            case 1:
                title = "Của tôi";
                break;
            case 2:
                title = "Tin mới";
                break;
        }
        return title;
    }
}
