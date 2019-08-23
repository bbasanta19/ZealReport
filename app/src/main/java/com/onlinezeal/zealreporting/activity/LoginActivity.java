package com.onlinezeal.zealreporting.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.onlinezeal.zealreporting.R;
import com.onlinezeal.zealreporting.helper.ZealActivity;
import com.onlinezeal.zealreporting.helper.ZealToast;
import com.onlinezeal.zealreporting.utils.UtilitiesFunctions;

public class LoginActivity extends ZealActivity implements View.OnClickListener {

    private EditText etEmail, etPassword;
    private TextView btnForgotPassword, btnLogin;
    private ImageView btnBack;
    private ProgressBar progressBar;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialiseViews();
        initialiseListener();
    }

    @Override
    protected void initialiseViews() {
        etEmail = findViewById(R.id.et_Email);
        etPassword = findViewById(R.id.et_Password);
        btnForgotPassword = findViewById(R.id.btn_forgot_password);
        btnLogin = findViewById(R.id.btn_login);
        btnBack = findViewById(R.id.btn_back);
        progressBar = findViewById(R.id.progress_bar);
    }

    @Override
    protected void initialiseListener() {
        btnLogin.setOnClickListener(this);
        btnForgotPassword.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                progressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(LoginActivity.this, MainActivityNew.class));
                finish();
                break;
            case R.id.btn_forgot_password:
                forgotPasswordDialog();
                break;

            case R.id.btn_back:

                break;
        }
    }

    private void forgotPasswordDialog() {
        dialog = new Dialog(LoginActivity.this, R.style.AppTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_forgot_password);

        //initialize
        final EditText emailEditText = dialog.findViewById(R.id.et_Email);
        final ImageView btnClose = dialog.findViewById(R.id.btn_close);
        final TextView btnResetPassword = dialog.findViewById(R.id.btn_submit);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = emailEditText.getText().toString();
                if (emailEditText.getText().toString().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
                    emailEditText.setError("Enter email address");
                } else {
                    if (UtilitiesFunctions.isNetworkAvailable(LoginActivity.this)) {
                        //loginPresenter.forgotPassword(emailAddress);
                    } else {
                        ZealToast.showToastWithMessage("No internet connection!");
                    }
                    dialog.dismiss();
                }
            }
        });

        if (dialog.getWindow() != null)
            dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }

}
