package com.example.jh.recycleviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jh.recycleviewdemo.R;

import java.util.List;

/**
 * Created by jinhui on 2018/3/28.
 * Email:1004260403@qq.com
 *
 * 这篇挺有参考价值的：
 * RecyclerView的加载显示多种布局
 * https://blog.csdn.net/a516972602/article/details/50802898
 */

public class CheckPointAdapter extends RecyclerView.Adapter<CheckPointAdapter.MyViewHolder>{

    private static final String TAG = "CheckPointAdapter";
    private List<String> mDatas;
    private Context context;
    private OnItemClickLitener mOnItemClickLitener;

    // 要写三种布局
    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;
    private static final int TYPE_THREE = 3;

    public void setmOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public CheckPointAdapter(List<String> mDatas, Context context) {
        this.mDatas = mDatas;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
//        return position % 3 == 0 ? TYPE_ONE : TYPE_TWO;
        if (position % 2 == 0){
            return TYPE_ONE;
        }else if (position % 3 == 0){
            return TYPE_TWO;
        }else {
            return TYPE_THREE;
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ONE){
            return new MyViewHolder(LayoutInflater.from(context)
                    .inflate(R.layout.item_checkpoint1, parent, false));
        }else if (viewType == TYPE_TWO){
            return new MyViewHolder(LayoutInflater.from(context)
                    .inflate(R.layout.item_checkpoint2, parent, false));
        }else {
           return new MyViewHolder(LayoutInflater.from(context)
                   .inflate(R.layout.item_checkpoint3, parent, false));
        }
    }

//    0-26个position，设置3的位置
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        // 设置数据
        holder.imageView.setImageResource(R.mipmap.ic_launcher);
        Log.e(TAG, "position = " + position);
        // 取余
//        if (position % 3 == 0){
//            holder.imageView.setImageResource(R.drawable.btn_play_press);
//        }

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

        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
        }
    }
}