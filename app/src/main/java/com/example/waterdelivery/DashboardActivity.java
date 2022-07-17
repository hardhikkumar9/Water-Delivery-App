package com.example.waterdelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.waterdelivery.databinding.ActivityDashboardBinding;

public class DashboardActivity extends DrawerBaseActivity {

    ActivityDashboardBinding activityDashboardBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding =ActivityDashboardBinding.inflate(getLayoutInflater());
        allcateActivityTitle("Dashboard");
        setContentView(activityDashboardBinding.getRoot());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}