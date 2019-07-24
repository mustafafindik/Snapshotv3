package findik.mustafa.snapshot.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import findik.mustafa.snapshot.fragments.FragmentFilter;



public class FilterAdapter extends FragmentPagerAdapter {

    public FilterAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
       return FragmentFilter.getInstance(position);
    }

    @Override
    public int getCount() {
        return 17;
    }
}
