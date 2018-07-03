package br.com.tuiuti.swapgames.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import br.com.tuiuti.swapgames.fragments.FeedFragment;

public class HomeViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentos;

    public HomeViewPagerAdapter(final FragmentManager fm, List<Fragment> fragmentos) {
        super(fm);
        mFragmentos = fragmentos;
    }

    @Override
    public Fragment getItem(final int position) {
        return mFragmentos.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentos.size();
    }
}
