package com.example.lab6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class listAdapter extends BaseAdapter {
    Context context;
    List<item> lista;
    listAdapter(Context c, ArrayList<item> list){
        context=c;
        lista=list;
    }
    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(lista.get(position).getId());
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view==null){
            LayoutInflater in= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view=in.inflate(R.layout.item_ui,null);
        }
        TextView titulo = (TextView)view.findViewById(R.id.title);
        TextView descripcion = (TextView)view.findViewById(R.id.desc);
        //ImageView image = (ImageView) view.findViewById(R.id.img​);
        titulo.setText(lista.get(position).getTitle());
        descripcion.setText(lista.get(position).getDescription());
        return view;
    }

}
