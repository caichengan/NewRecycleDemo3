package com.diandianguanjia.newrecycledemo3.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.adapter.RecycleViewAdapter;

/**
 * Created by an on 2017/7/31.
 */

public class ListsFragment extends Fragment {

    private static final String TAG = "ListsFragment";
    private RecyclerView recyclerView;
    private int i;

    public ListsFragment(int i) {
        this.i=i;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        recyclerView= (RecyclerView) View.inflate(getActivity(), R.layout.fragment_lists,null);

        return recyclerView;


    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i(TAG, "---------onResume: 进入一个新的fragment=--"+i);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new RecycleViewAdapter(getActivity()));

    }
}
