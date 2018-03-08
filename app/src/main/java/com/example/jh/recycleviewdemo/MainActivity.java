package com.example.jh.recycleviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jh.recycleviewdemo.adapter.HomeAdapter;
import com.example.jh.recycleviewdemo.divider.MyDividerItemDecoration;
import com.example.jh.recycleviewdemo.divider.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * http://blog.csdn.net/lmj623565791/article/details/45059587
 * <p>
 * 整体上看RecyclerView架构，提供了一种插拔式的体验，高度的解耦，异常的灵活，
 * 通过设置它提供的不同LayoutManager，ItemDecoration , ItemAnimator实现令人瞠目的效果。
 * 你想要控制其显示的方式，请通过布局管理器LayoutManager
 * <p>
 * 你想要控制Item间的间隔（可绘制），请通过ItemDecoration
 * 你想要控制Item增删的动画，请通过ItemAnimator
 * 你想要控制点击、长按事件，请自己写
 *
 *  // 设置布局管理器
 recycleView.setLayoutManager(layout);
 // 设置adapter
 recycleView.setAdapter(adapter);
 // 设置Item增加、移除动画
 recycleView.setItemAnimator(new DefaultItemAnimator());
 // 添加分割线
 recycleView.addItemDecoration(new MyDividerItemDecoration(
 getActivity(), MyDividerItemDecoration.HORIZONTAL_LIST));
 */

/**
 * ListView可能只需要去设置一个adapter就能正常使用了。
 * 而RecyclerView基本需要上面一系列的步骤，那么为什么会添加这么多的步骤呢？
 * 那么就必须解释下RecyclerView的这个名字了，从它类名上看，
 * RecyclerView代表的意义是，我只管Recycler View，也就是说RecyclerView只管回收与复用View，其他的你可以自己去设置。
 * 可以看出其高度的解耦，给予你充分的定制自由（所以你才可以轻松的通过这个控件实现ListView,GirdView，瀑布流等效果）。
 *
 * 添加分割线：
 * 看起来好丑，Item间应该有个分割线，当你去找时，你会发现RecyclerView并没有支持divider这样的属性。
 * 那么怎么办，你可以给Item的布局去设置margin，当然了这种方式不够优雅，我们文章开始说了，我们可以自由的去定制它，当然我们的分割线也是可以定制的。
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private List<String> mDatas;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new HomeAdapter(mDatas, this);
        recyclerView.setAdapter(mAdapter);

        // 系统分割线
//        recycleView.addItemDecoration(new MyDividerItemDecoration(this,
//                MyDividerItemDecoration.VERTICAL_LIST));
        // 自定义分割线
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i <= 'Z'; i++) {
//            mDatas.add("" + i); // 输出65-89；
            mDatas.add("" + (char)i); // 输出A-Z
        }
    }
}
