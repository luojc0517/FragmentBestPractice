
package com.jackie.fragmentbestpractice;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Window;
        import android.view.WindowAnimationFrameStats;

public class NewsContentActivity extends Activity {
    //启动Activity的最佳方式
    public static void actionStart(Context context, String newsTitle, String newsContent) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("newsTitle", newsTitle);
        intent.putExtra("newsContent", newsContent);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.news_content);
        Intent intent = getIntent();
        String newsTitle = intent.getStringExtra("newsTitle");
        String newsContent = intent.getStringExtra("newsContent");
        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager()
                .findFragmentById(R.id.news_frag);//bug002：找错了一个fragment的id
        newsContentFragment.refresh(newsTitle,newsContent);
    }
}
