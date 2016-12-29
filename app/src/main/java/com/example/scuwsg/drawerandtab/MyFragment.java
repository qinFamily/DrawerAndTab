package com.example.scuwsg.drawerandtab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Cenoo on 2016/12/28.
 */

public class MyFragment extends Fragment {
    public static String TAG_TAB_TITLE = "tab_title";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String tabTitle;       //frgment在viewpager中的位置

    public MyFragment() {
    }

    public static MyFragment newInstance(String tabTitle) {
        Bundle args = new Bundle();
        args.putString(TAG_TAB_TITLE, tabTitle);

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabTitle = getArguments().getString(TAG_TAB_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(tabTitle, getContext());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
