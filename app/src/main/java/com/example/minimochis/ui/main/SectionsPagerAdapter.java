package com.example.minimochis.ui.main;

import android.content.Context;
import android.graphics.Path;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.minimochis.Activitat;
import com.example.minimochis.Home;
import com.example.minimochis.Jocs;
import com.example.minimochis.Opcions;
import com.example.minimochis.R;
import com.example.minimochis.databinding.OpcionsLayoutBinding;

import kotlin.contracts.Returns;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3, R.string.tab_text_4};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Home();
                break;
            case 1:
                fragment = new Activitat();
                break;
            case 2:
                fragment = new Jocs();
                break;
            case 3:
                fragment = new Opcions();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Mostra el total de 4 pagines
        return 4;
    }
}