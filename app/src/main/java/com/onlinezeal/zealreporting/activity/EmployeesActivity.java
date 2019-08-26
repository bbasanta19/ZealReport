package com.onlinezeal.zealreporting.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.onlinezeal.zealreporting.R;
import com.onlinezeal.zealreporting.helper.ZealActivity;
import com.onlinezeal.zealreporting.helper.ZealRecyclerViewAdapter;

public class EmployeesActivity extends ZealActivity {

    private LinearLayout layoutBack, layoutTitle;
    private RecyclerView recyclerViewEmployees;
    private SwipeRefreshLayout swipeRefreshLayout;
    private EmployeeRecyclerViewAdapter employeeRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);

        initialiseViews();
        initialiseListener();

        prepareRecyclerView();

    }

    @Override
    protected void initialiseViews() {
        layoutBack = findViewById(R.id.back_layout);
        layoutTitle = findViewById(R.id.title_layout);
        recyclerViewEmployees = findViewById(R.id.recycler_view_employees);
        swipeRefreshLayout = findViewById(R.id.swiperefresh);
    }

    @Override
    protected void initialiseListener() {

    }

    private void prepareRecyclerView(){
        employeeRecyclerViewAdapter = new EmployeeRecyclerViewAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(EmployeesActivity.this, RecyclerView.VERTICAL, false);
        recyclerViewEmployees.setLayoutManager(layoutManager);
        recyclerViewEmployees.setAdapter(employeeRecyclerViewAdapter);
    }

    private class EmployeeRecyclerViewAdapter extends ZealRecyclerViewAdapter {

        @Override
        public void add(Object object) {

        }

        @Override
        public void clear() {

        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employees, parent, false);
            return new VHEmployee(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof VHEmployee){

            }
        }

        @Override
        public int getItemCount() {
            return 15;
        }

        private class VHEmployee extends RecyclerView.ViewHolder implements View.OnClickListener{

            private CardView container;
            private ImageView ivEmpImage;
            private TextView tvEmpName, tvEmpPosition;

            public VHEmployee(@NonNull View itemView) {
                super(itemView);
                container = itemView.findViewById(R.id.container);
                ivEmpImage = itemView.findViewById(R.id.iv_emp_image);
                tvEmpName = itemView.findViewById(R.id.tv_emp_name);
                tvEmpPosition = itemView.findViewById(R.id.tv_emp_position);
                container.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.container:
                        startActivity(new Intent(EmployeesActivity.this, ProfileActivity.class));
                        break;
                }
            }
        }
    }
}
