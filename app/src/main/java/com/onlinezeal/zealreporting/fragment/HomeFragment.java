package com.onlinezeal.zealreporting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.onlinezeal.zealreporting.R;
import com.onlinezeal.zealreporting.helper.ZealFragment;


public class HomeFragment extends ZealFragment {

    private RecyclerView recyclerViewMain;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initialiseView(view);
        initialiseListeners();

        return view;
    }

    @Override
    protected void initialiseView(View view) {
        recyclerViewMain = view.findViewById(R.id.recycler_view_main);
        swipeRefreshLayout = view.findViewById(R.id.swiperefresh);
    }

    @Override
    protected void initialiseListeners() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
