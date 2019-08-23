package com.onlinezeal.zealreporting.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.onlinezeal.zealreporting.R;
import com.onlinezeal.zealreporting.helper.StartSnapHelper;
import com.onlinezeal.zealreporting.helper.ZealActivity;
import com.onlinezeal.zealreporting.helper.ZealRecyclerViewAdapter;

public class MainActivityNew extends ZealActivity implements View.OnClickListener {

    private RecyclerView recyclerViewMain;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);

        initialiseViews();
        initialiseListener();

        prepareRecyclerView();

    }

    @Override
    protected void initialiseViews() {
        recyclerViewMain = findViewById(R.id.recycler_view_main);
        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        //fab = findViewById(R.id.fab_menu);
    }

    @Override
    protected void initialiseListener() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    private void prepareRecyclerView() {
        HomeRecyclerViewAdapter homeRecyclerViewAdapter = new HomeRecyclerViewAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivityNew.this, LinearLayoutManager.VERTICAL, false);
        recyclerViewMain.setLayoutManager(layoutManager);
        recyclerViewMain.setAdapter(homeRecyclerViewAdapter);
    }

    private class HomeRecyclerViewAdapter extends ZealRecyclerViewAdapter {

        private final int TYPE_HOD = 0;
        private final int TYPE_DEPARTMENTS = 1;

        VHHoD vhHoD;
        VHDepartments vhDepartments;

        @Override
        public void add(Object object) {

        }

        @Override
        public void clear() {

        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if (viewType == TYPE_HOD) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_dept_head_parent, parent, false);
                return new VHHoD(itemView);
            } else if (viewType == TYPE_DEPARTMENTS) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_dept_parent, parent, false);
                return new VHDepartments(itemView);
            }
            throw new RuntimeException("View not found");
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof VHHoD) {
                vhHoD = (VHHoD) holder;
                prepareRecyclerViewHoD(vhHoD.recyclerViewHoD);

            } else if (holder instanceof VHDepartments) {
                vhDepartments = (VHDepartments) holder;
                prepareRecyclerViewDept(vhDepartments.recyclerViewDepartments);

            }

        }

        private void prepareRecyclerViewHoD(RecyclerView recyclerViewHoD) {
            HODRecyclerViewAdapter hodRecyclerViewAdapter = new HODRecyclerViewAdapter();
            LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivityNew.this, LinearLayoutManager.HORIZONTAL, false);
            recyclerViewHoD.setLayoutManager(layoutManager);
            recyclerViewHoD.setAdapter(hodRecyclerViewAdapter);
        }

        private void prepareRecyclerViewDept(RecyclerView recyclerViewDepartments) {
            DeptRecyclerViewAdapter deptRecyclerViewAdapter = new DeptRecyclerViewAdapter();
            LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivityNew.this, LinearLayoutManager.VERTICAL, false);
            recyclerViewDepartments.setLayoutManager(layoutManager);
            recyclerViewDepartments.setAdapter(deptRecyclerViewAdapter);
        }

        @Override
        public int getItemCount() {
            return 2;
        }


        @Override
        public int getItemViewType(int position) {
            if (isTypeHoD(position)) {
                return TYPE_HOD;
            }
            return TYPE_DEPARTMENTS;
        }

        private boolean isTypeHoD(int position) {
            return position == 0;
        }

        private class VHHoD extends RecyclerView.ViewHolder implements View.OnClickListener {
            private RecyclerView recyclerViewHoD;

            VHHoD(View itemView) {
                super(itemView);
                recyclerViewHoD = itemView.findViewById(R.id.recycler_view_department_head);
//                SnapHelper snapHelper = new LinearSnapHelper();
                SnapHelper snapHelper = new StartSnapHelper();
                snapHelper.attachToRecyclerView(recyclerViewHoD);
            }

            @Override
            public void onClick(View view) {

            }
        }

        private class VHDepartments extends RecyclerView.ViewHolder implements View.OnClickListener {
            private RecyclerView recyclerViewDepartments;
            private TextView tvTitle, tvViewAll;

            VHDepartments(View itemView) {
                super(itemView);
                recyclerViewDepartments = itemView.findViewById(R.id.recycler_view_departments);
                tvTitle = itemView.findViewById(R.id.tv_departments);
                tvViewAll = itemView.findViewById(R.id.tv_departments_view_all);

                tvViewAll.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {

            }
        }
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
