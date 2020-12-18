package com.example.hw11.controller.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hw11.R;
import com.example.hw11.controller.activity.MainActivity;
import com.example.hw11.controller.activity.SignUpActivity;
import com.example.hw11.model.User;

import java.util.Date;

public class LoginFragment extends Fragment {

    public static final int REQUEST_CODE = 1;
    private EditText mUserNameLogin;
    private EditText mPasswordLogin;
    private Button mButtonLogin;
    private Button mButtonSignUp;

    private User mUser;
    private String userName;
    private String password;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUser = new User();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        findViews(view);
        setListeners();
        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        if (resultCode != Activity.RESULT_OK || intent == null)
            return;

        if (requestCode == REQUEST_CODE) {
            userName = intent.getStringExtra(SignUpFragment.EXTRA_USER_NAME);
            password = intent.getStringExtra(SignUpFragment.EXTRA_PASSWORD);

        }
    }

    private Boolean conformLogin(){
        if ((mUserNameLogin.getText().toString().equals(userName) )&&
                (mPasswordLogin.getText().toString().equals(password)) )
            return true;
        else
            return false;
    }

    private void findViews(View view) {
        mUserNameLogin = view.findViewById(R.id.input_username);
        mPasswordLogin = view.findViewById(R.id.input_password);
        mButtonLogin = view.findViewById(R.id.btn_login);
        mButtonSignUp = view.findViewById(R.id.btn_sign_up);
    }

    private void setListeners(){
        mButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SignUpActivity.newIntent(getActivity());
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = MainActivity.newIntent(getActivity());
                    startActivity(intent);

            }
        });
    }
}