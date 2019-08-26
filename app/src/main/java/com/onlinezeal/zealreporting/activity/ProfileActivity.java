package com.onlinezeal.zealreporting.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.onlinezeal.zealreporting.R;
import com.onlinezeal.zealreporting.helper.ZealActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends ZealActivity implements View.OnClickListener {

    private LinearLayout layoutBack, layoutTitle, layoutLogout, layoutSaveChanges;
    private CircleImageView ivProfileImage;
    private TextView tvProfileName, tvEditProfile, btnSaveChanges;
    private EditText etProfileEmail, etProfileContact, etProfileDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initialiseViews();
        initialiseListener();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    @Override
    protected void initialiseViews() {
        layoutBack = findViewById(R.id.back_layout);
        layoutTitle = findViewById(R.id.title_layout);
        layoutLogout = findViewById(R.id.logout_layout);
        layoutSaveChanges = findViewById(R.id.save_changes_layout);
        layoutSaveChanges.setVisibility(View.GONE);
        ivProfileImage = findViewById(R.id.iv_profile_image);
        tvProfileName = findViewById(R.id.tv_profile_name);
        tvEditProfile = findViewById(R.id.tv_edit_profile);
        etProfileEmail = findViewById(R.id.et_profile_email);
        etProfileContact = findViewById(R.id.et_profile_contact);
        etProfileDepartment = findViewById(R.id.et_profile_department);
        btnSaveChanges = findViewById(R.id.tv_save_changes);
    }

    @Override
    protected void initialiseListener() {
        layoutBack.setOnClickListener(this);
        layoutLogout.setOnClickListener(this);
        tvEditProfile.setOnClickListener(this);
        btnSaveChanges.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_layout:
                onBackPressed();
                break;
            case R.id.tv_edit_profile:
                if (tvEditProfile.getText().equals("Edit Profile")){
                    makeProfileEditible();
                } else {
                    makeProfileNonEditible();
                }
                break;
        }
    }

    private void makeProfileEditible(){
        layoutSaveChanges.setVisibility(View.VISIBLE);
        etProfileContact.setEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            etProfileContact.setFocusedByDefault(true);
        }
        etProfileDepartment.setEnabled(true);
        etProfileEmail.setEnabled(true);
        tvEditProfile.setText("Cancel Edit");
        tvEditProfile.setTextColor(getResources().getColor(R.color.colorMterialRed));
        InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    private void makeProfileNonEditible(){
        layoutSaveChanges.setVisibility(View.GONE);
        etProfileContact.setEnabled(false);
        etProfileDepartment.setEnabled(false);
        etProfileEmail.setEnabled(false);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        tvEditProfile.setVisibility(View.VISIBLE);
        tvEditProfile.setText("Edit Profile");
        tvEditProfile.setTextColor(getResources().getColor(R.color.colorAccent));
        InputMethodManager imm = (InputMethodManager)getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(etProfileContact.getWindowToken(), 0);
    }
}
