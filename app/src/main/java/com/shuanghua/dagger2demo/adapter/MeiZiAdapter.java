package com.shuanghua.dagger2demo.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.shuanghua.dagger2demo.R;
import com.shuanghua.dagger2demo.bean.MeiZi;
import com.shuanghua.dagger2demo.viewholder.MeiziViewHolder;

public class MeiZiAdapter extends RecyclerArrayAdapter<MeiZi.ShowapiResBodyEntity.NewslistEntity> {

    public MeiZiAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeiziViewHolder(parent, R.layout.item_meizi);
    }
}
