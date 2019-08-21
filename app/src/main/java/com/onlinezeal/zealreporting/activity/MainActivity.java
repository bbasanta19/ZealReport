package com.onlinezeal.zealreporting.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onlinezeal.zealreporting.R;
import com.onlinezeal.zealreporting.helper.ZealActivity;
import com.onlinezeal.zealreporting.helper.ZealRecyclerViewAdapter;

import java.util.List;

public class MainActivity extends ZealActivity implements View.OnClickListener {

    private RecyclerView recyclerViewHoD;
    private HODRecyclerViewAdapter hodRecyclerViewAdapter;
    private RecyclerView recyclerViewDepartments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseViews();
        initialiseListener();

        prepareRecyclerView();

    }

    @Override
    protected void initialiseViews() {
        recyclerViewHoD = findViewById(R.id.recycler_view_department_head);
    }

    @Override
    protected void initialiseListener() {

    }

    @Override
    public void onClick(View v) {

    }

    private void prepareRecyclerView() {
        hodRecyclerViewAdapter = new HODRecyclerViewAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHoD.setLayoutManager(layoutManager);
        recyclerViewHoD.setAdapter(hodRecyclerViewAdapter);
    }

    private class HODRecyclerViewAdapter extends ZealRecyclerViewAdapter {

        @Override
        public void add(Object object) {

        }

        @Override
        public void clear() {

        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_dept_head, parent, false);
            return new HoDViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 8;
        }

        private class HoDViewHolder extends RecyclerView.ViewHolder {

            public HoDViewHolder(View itemView) {
                super(itemView);

            }
        }
    }

}
