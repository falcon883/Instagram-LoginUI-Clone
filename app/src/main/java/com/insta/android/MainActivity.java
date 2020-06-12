package com.insta.android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    LinearLayout dashPanel;
    FrameLayout switchPage;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dashPanel = findViewById(R.id.dashPage);
        switchPage = findViewById(R.id.switchPage);
        switchPage.setVisibility(View.GONE);

        Button loginPage = findViewById(R.id.gotoLoginPage);
        loginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new loginFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        switchPage.setVisibility(View.VISIBLE);
        // create a FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.switchPage, fragment, "loginFragment");
        fragmentTransaction.commit(); // save the changes
        dashPanel.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        if (dashPanel.getVisibility() == View.VISIBLE) {
            super.onBackPressed();
        } else if (!loginFragment.fragRunning) {
            loadFragment(new loginFragment());
        } else {
            dashPanel.setVisibility(View.VISIBLE);
            switchPage.setVisibility(View.GONE);
        }
    }
}