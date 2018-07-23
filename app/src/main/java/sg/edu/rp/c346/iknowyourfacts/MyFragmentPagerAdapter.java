package sg.edu.rp.c346.iknowyourfacts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;

public class MyFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter{
    ArrayList<Fragment> fragments;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> al) {
        super(fm);
        fragments = al;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}

