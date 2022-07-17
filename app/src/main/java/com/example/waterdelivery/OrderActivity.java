package com.example.waterdelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.waterdelivery.databinding.ActivityCustomerBinding;
import com.example.waterdelivery.databinding.ActivityOrderBinding;

public class OrderActivity extends DrawerBaseActivity {

    ActivityOrderBinding activityOrderBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOrderBinding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(activityOrderBinding.getRoot());
        allocateActivityTitle("Orders");
    }
}