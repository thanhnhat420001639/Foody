package hcmute.tranhoanglong.foody;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SavedFragment1 extends Fragment
{
    public SavedFragment1()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_saved1, container, false);

        Fragment fragment = new SavedFragment1_1();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_Saved1, fragment).commit();

        return rootView;
    }
}