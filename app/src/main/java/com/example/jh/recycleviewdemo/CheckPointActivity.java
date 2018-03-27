package com.example.jh.recycleviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jh.recycleviewdemo.adapter.CheckPointAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/3/28.
 * Email:1004260403@qq.com
 */

public class CheckPointActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    CheckPointAdapter checkPointAdapter;
    private List<String> datas;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkpoint);
        ButterKnife.bind(this);

        initData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        checkPointAdapter = new CheckPointAdapter(datas, this);
        recyclerView.setAdapter(checkPointAdapter);

        recyclerView.scrollToPosition(datas.size() - 1);
    }

    /**
     *  int[] arr = { 1, 2, 3, 4 ,5};

     for (int i = 0; i < arr.length / 2; i++) {
     int tmp = arr[i];
     arr[i] = arr[arr.length - i - 1];
     arr[arr.length - i - 1] = tmp;
     }
     */
    private void initData() {
        datas = new ArrayList<String>();
        for (int i = 'A'; i <= 'Z'; i++) {
            datas.add("" + (char) i); // 输出A-Z
        }

    }


}
