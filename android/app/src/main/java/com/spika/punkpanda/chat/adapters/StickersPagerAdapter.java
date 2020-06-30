package com.spika.punkpanda.chat.adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ling on 23.03.16..
 */
public class StickersPagerAdapter extends FragmentStatePagerAdapter{

    private Context ctx;
    private List<Fragment> data = new ArrayList<>();

    public StickersPagerAdapter(FragmentManager fm, Context context, List<Fragment> newData) {
        super(fm);

        this.ctx = context;
        this.data = newData;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

}
