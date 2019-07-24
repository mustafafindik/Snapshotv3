package findik.mustafa.snapshot.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import findik.mustafa.snapshot.fragments.CameraFragment;
import findik.mustafa.snapshot.fragments.ChatFragment;
import findik.mustafa.snapshot.fragments.StoryFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return ChatFragment.create();
            case 1:
                return CameraFragment.create();
            case 2:
                return StoryFragment.create();

        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Chat";
            case 1:
                return "Kamera";
            case 2:
                return "Hikaye";
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
