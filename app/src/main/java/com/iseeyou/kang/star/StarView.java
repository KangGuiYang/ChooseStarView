package com.iseeyou.kang.star;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kGod on 2017/3/24.
 * Email 18252032703@163.com
 * Thank you for watching my code 替换图片 TODO
 */

public class StarView extends FrameLayout implements View.OnClickListener {

    private Context mContext;
    private View mView;
    private ImageView iv1, iv2, iv3, iv4, iv5;
    private List<ImageView> imageViews = new ArrayList<>();
    // 等级
    private int level;
    // 是否可以点击
    private boolean canSelected;

    public void setCanSelected(boolean isCanSelected) {
        this.canSelected = isCanSelected;
        if (canSelected) {
            for (ImageView iv : imageViews) {
                iv.setOnClickListener(this);
            }
        }
    }


    public StarView(@NonNull Context context) {
        this(context, null);
    }

    public StarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StarView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mView = View.inflate(mContext, R.layout.view_star_layout, this);
        iv1 = (ImageView) $(mView, R.id.iv1);
        iv2 = (ImageView) $(mView, R.id.iv2);
        iv3 = (ImageView) $(mView, R.id.iv3);
        iv4 = (ImageView) $(mView, R.id.iv4);
        iv5 = (ImageView) $(mView, R.id.iv5);
        imageViews.add(iv1);
        imageViews.add(iv2);
        imageViews.add(iv3);
        imageViews.add(iv4);
        imageViews.add(iv5);
        if (canSelected) {
            for (ImageView iv : imageViews) {
                iv.setOnClickListener(this);
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        setSeleted(id);
    }

    private void setSeleted(int id) {
        for (int i = 0; i < imageViews.size(); i++) {
            ImageView iv = imageViews.get(i);
            iv.setSelected(false);
        }
        switch (id) {
            case R.id.iv1:
                iv1.setSelected(true);
                level = 1;
                break;
            case R.id.iv2:
                iv1.setSelected(true);
                iv2.setSelected(true);
                level = 2;
                break;
            case R.id.iv3:
                iv1.setSelected(true);
                iv2.setSelected(true);
                iv3.setSelected(true);
                level = 3;
                break;
            case R.id.iv4:
                iv1.setSelected(true);
                iv2.setSelected(true);
                iv3.setSelected(true);
                iv4.setSelected(true);
                level = 4;
                break;
            case R.id.iv5:
                iv1.setSelected(true);
                iv2.setSelected(true);
                iv3.setSelected(true);
                iv4.setSelected(true);
                iv5.setSelected(true);
                level = 5;
                break;
        }
    }

    /**
     * 获取选择的评价等级
     *
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * 设置等级
     *
     * @param level 可根据百分比得出12345等级用于显示
     */
    public void setLevel(int level) {
        for (int i = 0; i < imageViews.size(); i++) {
            ImageView iv = imageViews.get(i);
            iv.setSelected(false);
        }
        switch (level) {
            case 1:
                iv1.setSelected(true);
                break;
            case 2:
                iv1.setSelected(true);
                iv2.setSelected(true);
                break;
            case 3:
                iv1.setSelected(true);
                iv2.setSelected(true);
                iv3.setSelected(true);
                break;
            case 4:
                iv1.setSelected(true);
                iv2.setSelected(true);
                iv3.setSelected(true);
                iv4.setSelected(true);
                break;
            case 5:
                iv1.setSelected(true);
                iv2.setSelected(true);
                iv3.setSelected(true);
                iv4.setSelected(true);
                iv5.setSelected(true);
                break;
        }
    }

    /**
     * findViewById
     * @param view
     * @param id
     * @return
     */
    private View $(View view, int id) {
        return view.findViewById(id);
    }
}
