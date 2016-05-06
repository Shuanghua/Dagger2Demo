package com.shuanghua.dagger2demo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shuanghua.dagger2demo.R;
import com.shuanghua.dagger2demo.bean.Repo;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by ShuangHua on 2016/5/4.
 */
public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    ArrayList<Repo> mRepos;

    public RepoAdapter() {
        mRepos = new ArrayList<>();
    }

    public void setRepos(ArrayList<Repo> repos) {
        this.mRepos = repos;
        notifyItemInserted(mRepos.size() - 1);
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.bindTo(mRepos.get(position));
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    static class RepoViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.item_iv_repo_name)
        TextView itemIvRepoName;
        @InjectView(R.id.item_iv_repo_detail)
        TextView itemIvRepoDetail;
        private ArrayList<Repo> mRepo;

        public RepoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }

        public void bindTo(Repo repo) {
            itemIvRepoName.setText(repo.name);
            itemIvRepoDetail.setText(String.valueOf(repo.description + "(" + repo.language + ")"));
        }
    }
}
