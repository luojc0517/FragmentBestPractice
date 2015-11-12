package com.jackie.fragmentbestpractice;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class NewsContentFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.news_content_frag, container, false);
        return view;
    }

    public void refresh(String newsTitle,String newsContent){
        view.setVisibility(View.VISIBLE);
        TextView tvNewsTitle = (TextView) view.findViewById(R.id.news_title);
        TextView tvNewsContent = (TextView) view.findViewById(R.id.news_content);
        tvNewsTitle.setText(newsTitle);
        tvNewsContent.setText(newsContent);

    }




}
