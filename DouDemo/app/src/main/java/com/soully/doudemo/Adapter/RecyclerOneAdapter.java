package com.soully.doudemo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.soully.doudemo.Bean.OneBean;
import com.soully.doudemo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Soully on 2017/3/30.
 */

public class RecyclerOneAdapter extends RecyclerView.Adapter<RecyclerOneAdapter.ViewHolder>{
    private List<OneBean> oneBeanList;
    private Context mContext;
    private LayoutInflater mInflater;
    public RecyclerOneAdapter(Context context,List<OneBean> list){
        this.mContext = context;
        this.oneBeanList = list;
        this.mInflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.first_recycle_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("qwer",position+"");
        if (position == 0){
        Glide.with(mContext).load(oneBeanList.get(position).getHotImage(0)).into(holder.imageViewOne);
        Glide.with(mContext).load(oneBeanList.get(position).getHotImage(1)).into(holder.imageViewTwo);
        Glide.with(mContext).load(oneBeanList.get(position).getHotImage(2)).into(holder.imageViewThree);
        holder.textViewOne.setText(oneBeanList.get(position).getHot(0));
        holder.textViewTwo.setText(oneBeanList.get(position).getHot(1));
        holder.textViewThree.setText(oneBeanList.get(position).getHot(2));
        holder.more.setText(oneBeanList.get(position).getMore());
        holder.movie.setText(oneBeanList.get(position).getList_name(position));
        }else if (position == 1){
            Glide.with(mContext).load(oneBeanList.get(position).getRecentlyImage(0)).into(holder.imageViewOne);
            Glide.with(mContext).load(oneBeanList.get(position).getRecentlyImage(1)).into(holder.imageViewTwo);
            Glide.with(mContext).load(oneBeanList.get(position).getRecentlyImage(2)).into(holder.imageViewThree);
            holder.textViewOne.setText(oneBeanList.get(position).getRecently(0));
            holder.textViewTwo.setText(oneBeanList.get(position).getRecently(1));
            holder.textViewThree.setText(oneBeanList.get(position).getRecently(2));
            holder.more.setText(oneBeanList.get(position).getMore());
            holder.movie.setText(oneBeanList.get(position).getList_name(position));
        }else if (position == 2){
            Glide.with(mContext).load(oneBeanList.get(position).getUsImage(0)).into(holder.imageViewOne);
            Glide.with(mContext).load(oneBeanList.get(position).getUsImage(1)).into(holder.imageViewTwo);
            Glide.with(mContext).load(oneBeanList.get(position).getUsImage(2)).into(holder.imageViewThree);
            holder.textViewOne.setText(oneBeanList.get(position).getUs(0));
            holder.textViewTwo.setText(oneBeanList.get(position).getUs(1));
            holder.textViewThree.setText(oneBeanList.get(position).getUs(2));
            holder.more.setText(oneBeanList.get(position).getMore());
            holder.movie.setText(oneBeanList.get(position).getList_name(position));
        }
    }

    @Override
    public int getItemCount() {
        return oneBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_one)ImageView imageViewOne;
        @BindView(R.id.image_two)ImageView imageViewTwo;
        @BindView(R.id.image_three)ImageView imageViewThree;
        @BindView(R.id.name_one)TextView textViewOne;
        @BindView(R.id.name_two)TextView textViewTwo;
        @BindView(R.id.name_three)TextView textViewThree;
        @BindView(R.id.movie)TextView movie;
        @BindView(R.id.more)TextView more;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    //设置DeletData删除动作
    public void deleteData(int position) {
        oneBeanList.remove(position);
        notifyItemRemoved(position);
    }
}
