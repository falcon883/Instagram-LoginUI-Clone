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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class findAccountFragment extends Fragment {

    private EditText username;
    private Button next;
    static boolean fragRunning = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.findaccount, container, false);
        Toolbar toolbar = view.findViewById(R.id.findAccToolBar);
        toolbar.setTitle(getResources().getString(R.string.login_help));
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);

        fragRunning = true;

        username = view.findViewById(R.id.username_findAcc);
        username.addTextChangedListener(watcher);
        next = view.findViewById(R.id.next_btn);

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
            if (!TextUtils.isEmpty(username.getText())) {
                next.setEnabled(true);
                next.setAlpha(1.0f);
            } else {
                next.setEnabled(false);
                next.setAlpha(0.3f);
            }
        }
    };
}
