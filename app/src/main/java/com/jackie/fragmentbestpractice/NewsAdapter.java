package com.jackie.fragmentbestpractice;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Law on 2015/11/2.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.news_items, null);
        } else {
            view = convertView;
        }
        TextView newsTitle = (TextView) view.findViewById(R.id.news_title);
        newsTitle.setText(news.getTitle());
        //bug001：这个视图没有content控件，误添加导致空指针。
        return view;

    }
}
