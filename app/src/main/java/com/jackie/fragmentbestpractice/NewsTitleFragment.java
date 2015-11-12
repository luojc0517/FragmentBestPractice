package com.jackie.fragmentbestpractice;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Law on 2015/11/2.
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {
    private List<News> newsList;
    private ListView newsListView;
    private NewsAdapter newsAdapter;
    private boolean isTwoPage;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newsList = getNewsList();
        newsAdapter = new NewsAdapter(activity, R.layout.news_items, newsList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        newsListView = (ListView) view.findViewById(R.id.news_title_list_view);
        newsListView.setAdapter(newsAdapter);
        newsListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_frag) != null) {
            isTwoPage = true;
        } else {
            isTwoPage = false;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        News news = newsList.get(position);
        if(isTwoPage){
            NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_frag);
            newsContentFragment.refresh(news.getTitle(),news.getContent());
        }else{
            NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
        }

    }

    public List<News> getNewsList() {
        List<News> newsList = new ArrayList<News>();
        newsList.add(new News("终止针对记者犯罪不受惩罚现象国际日", "秘书长潘基文表示，过去十年，有700多名记者仅因为他们的工作被杀。十分之九案件的制造者未受到惩罚。因此，犯罪分子肆无忌惮。人们不敢公开谈论腐败、政治压迫或其他侵犯人权问题。必须终止这种情况。任何地方的记者都不应当冒着生命危险来报道新闻。"));
        newsList.add(new News("关注缅甸局势", "秘书长潘基文11月1日发表声明，对缅甸人口多数派群体中的极端份子为了政治目的不断使用憎恨言论、挑拨社区间仇恨定并滥用宗教名义深表关切。缅甸即将举行选举，潘基文敦促各方避免基于族裔身份、性别、宗教或政治观点而对任何个人或组织施加压力，进行恐吓，散播仇恨，甚至实施暴力。"));
        return newsList;
    }
}
