package com.shuanghua.dagger2demo.viewholder;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.shuanghua.dagger2demo.R;
import com.shuanghua.dagger2demo.bean.MeiZi;

/**
 * MeiziViewHolder
 * Created by ShuangHua on 2016/5/7.
 */
public class MeiziViewHolder extends BaseViewHolder<MeiZi.ShowapiResBodyEntity.NewslistEntity> {

    private ImageView mImageView;

    public MeiziViewHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
        mImageView = $(R.id.image_meizi);
    }

    @Override
    public void setData(MeiZi.ShowapiResBodyEntity.NewslistEntity meiZiData) {
        Glide.with(getContext()).load(meiZiData.getPicUrl()).into(mImageView);
    }
}
