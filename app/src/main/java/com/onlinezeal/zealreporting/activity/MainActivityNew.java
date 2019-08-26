package com.onlinezeal.zealreporting.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.onlinezeal.zealreporting.R;
import com.onlinezeal.zealreporting.fragment.HomeFragment;
import com.onlinezeal.zealreporting.fragment.TeamFragment;
import com.onlinezeal.zealreporting.helper.StartSnapHelper;
import com.onlinezeal.zealreporting.helper.ZealActivity;
import com.onlinezeal.zealreporting.helper.ZealRecyclerViewAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivityNew extends ZealActivity implements View.OnClickListener {

    private RecyclerView recyclerViewMain;
    private SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayout bottomNavigation, toolbarTitle;
    private TabLayout tabLayout;
    private RelativeLayout homeParent, teamParent, notificationParent, questionsParent;
    private RelativeLayout lastSelectedView;
    private FloatingActionButton fabAddNew;
    private CircleImageView ivProfileImage;
    private ImageView btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);

        initialiseViews();
        initialiseListener();

        setUpFragment(new HomeFragment(), "home");
    }

    @Override
    protected void initialiseViews() {
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setVisibility(View.GONE);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        homeParent = findViewById(R.id.home_parent);
        teamParent = findViewById(R.id.team_parent);
        notificationParent = findViewById(R.id.notification_parent);
        questionsParent = findViewById(R.id.question_parent);
        fabAddNew = findViewById(R.id.fab_add_new);
        toolbarTitle = findViewById(R.id.title_parent);
        ivProfileImage = findViewById(R.id.iv_profile_image);
        btnMenu = findViewById(R.id.iv_menu);
        lastSelectedView = homeParent;
    }

    @Override
    protected void initialiseListener() {
        homeParent.setOnClickListener(this);
        teamParent.setOnClickListener(this);
        notificationParent.setOnClickListener(this);
        questionsParent.setOnClickListener(this);
        fabAddNew.setOnClickListener(this);
        ivProfileImage.setOnClickListener(this);
        btnMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_parent:
                if (!getVisibleFragment("home")) {
                    setUpBottomNavigation(homeParent);
                    setUpFragment(new HomeFragment(), "home");
                }
                break;
            case R.id.team_parent:
                if (!getVisibleFragment("team")) {
                    setUpBottomNavigation(teamParent);
                    setUpFragment(new TeamFragment(), "team");
                }
                break;
        }
    }

    public boolean getVisibleFragment(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.container);
        assert currentFragment.getTag() != null;
        if (currentFragment.getTag().equals(tag)) {
            return true;
        }
        return false;
    }

    /**
     * @param fragment fragment to load
     */
    private void setUpFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.commit();
    }

    public void setUpBottomNavigation(RelativeLayout view) {
        if (lastSelectedView != null) {
            for (int i = 0; i < lastSelectedView.getChildCount(); i++) {
                View view1 = lastSelectedView.getChildAt(i);
                if (view1 instanceof ImageView) {
                    ((ImageView) view1).setColorFilter(getResources().getColor(R.color.colorLightGrey));
                } else {
                    ((TextView) view1).setTextColor(getResources().getColor(R.color.colorLightGrey));
                }
            }
        }
        for (int i = 0; i < view.getChildCount(); i++) {
            View view1 = view.getChildAt(i);
            if (view1 instanceof ImageView) {
                ((ImageView) view1).setColorFilter(ContextCompat.getColor(this, R.color.colorSelected));

            } else {
                ((TextView) view1).setTextColor(ContextCompat.getColor(this, R.color.colorSelected));
            }

        }
        lastSelectedView = view;
    }
}
