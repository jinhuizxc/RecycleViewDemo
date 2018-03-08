package com.example.jh.recycleviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jh.recycleviewdemo.R;

import java.util.List;

/**
 * Created by jinhui on 2018/3/8.
 * Email:1004260403@qq.com
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{

    private List<String> mDatas;
    private Context context;

    public HomeAdapter(List<String> mDatas, Context context) {
        this.mDatas = mDatas;
        this.context = context;
    }

    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_home, parent, false));
    }

    @Override
    public void onBindViewHolder(HomeAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_num);
        }
    }
}
