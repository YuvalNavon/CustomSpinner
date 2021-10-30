package com.example.customspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] countryList;
    String[] capitalList;
    int flags[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] countryList,String[] capitalList, int[] flags) {
        this.context = context;
        this.countryList = countryList;
        this.capitalList = capitalList;
        this.flags = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return countryList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinnerlayout, null);
        TextView country = (TextView) view.findViewById(R.id.name);
        TextView capital = (TextView) view.findViewById(R.id.capital);
        ImageView flag = (ImageView) view.findViewById(R.id.imageView);
        country.setText(countryList[i]);
        capital.setText(capitalList[i]);
        flag.setImageResource(flags[i]);
        return view;
    }
}

