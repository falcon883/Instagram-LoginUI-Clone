package com.insta.android;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class loginFragment extends Fragment {

    private EditText username, password;
    private Button loginBTN;
    private TextView findAcc;
    private RelativeLayout loginPageLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_login, container, false);

        loginBTN = view.findViewById(R.id.login_btn);
        loginBTN.setEnabled(false);

        loginPageLayout = view.findViewById(R.id.loginPageLayout);
        loginPageLayout.setVisibility(View.VISIBLE);

        findAcc = view.findViewById(R.id.findAcc);
        findAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment getHelpFrag = new findAccountFragment();
                FragmentTransaction transaction = requireFragmentManager().beginTransaction();
                transaction.replace(R.id.switchPage, getHelpFrag, "findAccountFragment"); // give your fragment container id in first parameter
                transaction.commit();
                loginPageLayout.setVisibility(View.GONE);
            }
        });

        username = view.findViewById(R.id.username);
        username.addTextChangedListener(watcher);
        password = view.findViewById(R.id.password);
        password.addTextChangedListener(watcher);

        return view;
    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!TextUtils.isEmpty(username.getText()) && !TextUtils.isEmpty(password.getText())) {
                loginBTN.setEnabled(true);
                loginBTN.setAlpha(1.0f);
            } else {
                loginBTN.setEnabled(false);
                loginBTN.setAlpha(0.3f);
            }
        }
    };
}

