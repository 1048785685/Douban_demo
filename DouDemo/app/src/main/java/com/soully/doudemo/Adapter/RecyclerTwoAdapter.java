package com.soully.doudemo.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.soully.doudemo.Bean.TwoBean;
import com.soully.doudemo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Soully on 2017/4/5.
 */

public class RecyclerTwoAdapter extends RecyclerView.Adapter<RecyclerTwoAdapter.ViewHolder>{
    private List<TwoBean> twoBeanList;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnRecycleViewListener onRecycleViewListener;
    public RecyclerTwoAdapter(Context context,List<TwoBean> list){
        this.mContext = context;
        this.twoBeanList = list;
        this.mInflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.two_recycle_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Glide.with(mContext).load(twoBeanList.get(position).getImage()).into(holder.imageView);
        holder.textView.setText(twoBeanList.get(position).getName());
        if(onRecycleViewListener != null){//如果设置了回调，则设置监听事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();//和position值一样
                    onRecycleViewListener.onItemClick(holder.itemView,pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return twoBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cardView_text)TextView textView;
        @BindView(R.id.cardView_image)ImageView imageView;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            ButterKnife.bind(this,itemView);
        }
    }
    public void deleteData(int position) {
        twoBeanList.remove(position);
        notifyItemRemoved(position);
    }
    public interface OnRecycleViewListener{
        void onItemClick(View view, int position);
    }
    public void setOnRecycleViewListener(OnRecycleViewListener mOnItemClickListener){
        this.onRecycleViewListener = mOnItemClickListener;
    }
}
