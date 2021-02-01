package com.example.hw11.controller.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hw11.R;
import com.example.hw11.model.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment {
    private EditText mUsername;
    private EditText mPassword;
    private Button mButtonSignUp;

    private User mUser;

    public SignUpFragment() {
        // Required empty public constructor
    }
    public static SignUpFragment newInstance() {
        SignUpFragment fragment = new SignUpFragment();
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
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        findViews(view);
        setListeners();

        return view;
    }

    private void findViews(View view) {
        mUsername = view.findViewById(R.id.input_sign_up_username);
        mPassword =view.findViewById(R.id.input_sign_up_password);
        mButtonSignUp = view.findViewById(R.id.btn_sign_up);
    }

    private void setListeners(){
        mButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = getTargetFragment();

                int requestCode = getTargetRequestCode();
                int resultCode = Activity.RESULT_OK;
                Intent intent = new Intent();


                fragment.onActivityResult(requestCode, resultCode, intent);
            }
        });
    }
}