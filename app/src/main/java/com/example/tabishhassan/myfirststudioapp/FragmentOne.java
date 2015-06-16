package com.example.tabishhassan.myfirststudioapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tabishhassan on 6/16/15.
 */
public class FragmentOne extends Fragment {

    static Activity context;
    static FragmentOne newInstance(Activity context) {
        FragmentOne f = new FragmentOne();
        FragmentOne.context = context;
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rowView = inflater.inflate(R.layout.fragmentone_layout, null, true);
        ListView mylistview = (ListView)rowView.findViewById(R.id.listView);
        List<String> softhouse = new ArrayList<String>();
        softhouse.add("Netsol");
        softhouse.add("Techlogix");
        softhouse.add("I2C");
        softhouse.add("Arbisoft");
        softhouse.add("Northbay");
        softhouse.add("Axcat");
        CustomAdapter adapter = new CustomAdapter(context,softhouse);
        mylistview.setAdapter(adapter);
        return rowView;
    }
}

class CustomAdapter extends BaseAdapter{

    Activity activity;
    LayoutInflater inflater = null;
    List<String> softwerehouses;

    public CustomAdapter(Activity activity, List<String> softwerehouses) {
        this.activity = activity;
        this.softwerehouses = softwerehouses;
    }

    @Override
    public int getCount() {
        return softwerehouses.size();
    }
    @Override
    public Object getItem(int location) {
        return softwerehouses.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        TextView textname = (TextView)convertView.findViewById(R.id.textView);
        textname.setText(softwerehouses.get(position));
        return convertView;
    }
}
