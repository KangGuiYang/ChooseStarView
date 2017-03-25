package com.iseeyou.kang.star;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    StarView mStarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStarView = (StarView) this.findViewById(R.id.star_view);
        //设置是否可以点击
        mStarView.setCanSelected(true);
        // 设置显示等级
        mStarView.setLevel(5);
    }
}
