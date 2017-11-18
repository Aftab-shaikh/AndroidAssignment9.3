package com.example.user1.androidassignment93;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by user1 on 10/11/2017.
 */
public class CustomAdaptor extends BaseAdapter{

    Context context;

    String [] nameArray={"Aftab","Ashraf","Mac","Mark","Leo"};
    String [] phnumArray={"4578765687","56875659","4578586867","969780980978","67878989809"};

    public CustomAdaptor(Context context) {
      this.context=context;

    }

    @Override
    public int getCount() {
        return nameArray.length;
    }

    @Override
    public Object getItem(int position) {
        return nameArray[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.custom_layout,null);
        TextView textView1=(TextView)convertView.findViewById(R.id.textView1);
        TextView textView2=(TextView)convertView.findViewById(R.id.textView2);

        textView1.setText(nameArray[position]);
        textView2.setText(phnumArray[position]);

        return convertView;
    }
}
