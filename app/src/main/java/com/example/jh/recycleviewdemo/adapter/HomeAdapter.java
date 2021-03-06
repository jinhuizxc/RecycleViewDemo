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
    private OnItemClickLitener mOnItemClickLitener;

    public void setmOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

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
    public void onBindViewHolder(final HomeAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(mDatas.get(position));

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    removeData(pos);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * 添加一条数据
     * @param position
     */
    public void addData(int position) {
        mDatas.add(position, "Insert One");
        notifyItemInserted(position);
    }

    /**
     * 移除一条数据
     * @param position
     */
    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_num);
        }
    }
}
