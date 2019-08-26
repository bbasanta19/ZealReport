package com.onlinezeal.zealreporting.fragment;

/*
* Created by BasantaBK on 25-Aug-19.
* Copyright (c) 2019 OnlineZeal Pvt. Ltd. All rights reserved.
*
*/

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.onlinezeal.zealreporting.R;
import com.onlinezeal.zealreporting.activity.EmployeesActivity;
import com.onlinezeal.zealreporting.activity.ProfileActivity;
import com.onlinezeal.zealreporting.helper.StartSnapHelper;
import com.onlinezeal.zealreporting.helper.ZealFragment;
import com.onlinezeal.zealreporting.helper.ZealRecyclerViewAdapter;

import java.util.Objects;

public class TeamFragment extends ZealFragment {

    private RecyclerView recyclerViewTeam;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        initialiseView(view);
        initialiseListeners();

        prepareRecyclerView();

        return view;
    }

    @Override
    protected void initialiseView(View view) {
        recyclerViewTeam = view.findViewById(R.id.recycler_view_team);
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

    private void prepareRecyclerView() {
        TeamRecyclerViewAdapter teamRecyclerViewAdapter = new TeamRecyclerViewAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewTeam.setLayoutManager(layoutManager);
        recyclerViewTeam.setAdapter(teamRecyclerViewAdapter);
    }

    private class TeamRecyclerViewAdapter extends ZealRecyclerViewAdapter {

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
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
            recyclerViewHoD.setLayoutManager(layoutManager);
            recyclerViewHoD.setAdapter(hodRecyclerViewAdapter);
        }

        private void prepareRecyclerViewDept(RecyclerView recyclerViewDepartments) {
            DeptRecyclerViewAdapter deptRecyclerViewAdapter = new DeptRecyclerViewAdapter();
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
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
            if (holder instanceof HoDViewHolder){

            }
        }

        @Override
        public int getItemCount() {
            return 8;
        }

        private class HoDViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private CardView cvParent;
            private ImageView ivHodImage;
            private TextView tvHodName, tvHodDepartment;

            public HoDViewHolder(View itemView) {
                super(itemView);
                cvParent = itemView.findViewById(R.id.cv_hod_container);
                ivHodImage = itemView.findViewById(R.id.iv_hod_image);
                tvHodName = itemView.findViewById(R.id.tv_hod_name);
                tvHodDepartment = itemView.findViewById(R.id.tv_hod_department);

                cvParent.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.cv_hod_container:
                        Objects.requireNonNull(getActivity()).startActivity(new Intent(getActivity(), ProfileActivity.class));
                }
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
            return new VHDepartments(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 8;
        }

        private class VHDepartments extends RecyclerView.ViewHolder implements View.OnClickListener {

            private CardView cvContainer;
            private TextView tvInitText, tvDeptName, tvDeptEmpNumber;

            public VHDepartments(View itemView) {
                super(itemView);
                cvContainer = itemView.findViewById(R.id.container);
                tvInitText = itemView.findViewById(R.id.tv_dept_init);
                tvDeptName = itemView.findViewById(R.id.tv_department_name);
                tvDeptEmpNumber = itemView.findViewById(R.id.tv_dept_emp_number);
                cvContainer.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.container:
                        startActivity(new Intent(getActivity(), EmployeesActivity.class));
                        break;
                }
            }
        }
    }
}
