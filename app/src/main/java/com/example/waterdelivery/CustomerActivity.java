package com.example.waterdelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.waterdelivery.databinding.ActivityCustomerBinding;

public class CustomerActivity extends DrawerBaseActivity {

    ActivityCustomerBinding activityCustomerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCustomerBinding = ActivityCustomerBinding.inflate(getLayoutInflater());
        setContentView(activityCustomerBinding.getRoot());
        allocateActivityTitle("Customer");
    }

}