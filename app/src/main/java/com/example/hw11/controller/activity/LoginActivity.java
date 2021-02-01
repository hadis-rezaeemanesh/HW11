package com.example.hw11.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.hw11.R;
import com.example.hw11.controller.fragment.LoginFragment;

public class LoginActivity extends SingleFragmentActivity {


    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }


    @Override
    public Fragment createFragment() {
        Intent intent = new Intent();
        String userName = intent.getStringExtra(LoginFragment.EXTRA_USER_NAME);
        String password = intent.getStringExtra(LoginFragment.EXTRA_PASSWORD);
        return LoginFragment.newInstance(userName, password);
    }
}