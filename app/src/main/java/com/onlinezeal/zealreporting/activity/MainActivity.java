package com.onlinezeal.zealreporting.activity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onlinezeal.zealreporting.R;
import com.onlinezeal.zealreporting.helper.ZealActivity;
import com.onlinezeal.zealreporting.helper.ZealRecyclerViewAdapter;

public class MainActivity extends ZealActivity implements View.OnClickListener {

    private RecyclerView recyclerViewHoD;
    private RecyclerView recyclerViewDepartments;
    private HODRecyclerViewAdapter hodRecyclerViewAdapter;
    private DeptRecyclerViewAdapter deptRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseViews();
        initialiseListener();

        prepareRecyclerViewHdD();
        prepareRecyclerViewDept();

    }

    @Override
    protected void initialiseViews() {
        recyclerViewHoD = findViewById(R.id.recycler_view_department_head);
        recyclerViewDepartments = findViewById(R.id.recycler_view_departments);
    }

    @Override
    protected void initialiseListener() {

    }

    @Override
    public void onClick(View v) {

    }

    private void prepareRecyclerViewHdD() {
        hodRecyclerViewAdapter = new HODRecyclerViewAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHoD.setLayoutManager(layoutManager);
        recyclerViewHoD.setAdapter(hodRecyclerViewAdapter);
    }

    private void prepareRecyclerViewDept() {
        deptRecyclerViewAdapter = new DeptRecyclerViewAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerViewDepartments.setLayoutManager(layoutManager);
        recyclerViewDepartments.setAdapter(deptRecyclerViewAdapter);
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

    private class DeptRecyclerViewAdapter extends ZealRecyclerViewAdapter {

        @Override
        public void add(Object object) {

        }

        @Override
        public void clear() {

        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_departments, parent, false);
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
