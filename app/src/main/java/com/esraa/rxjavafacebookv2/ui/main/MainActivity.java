 package com.esraa.rxjavafacebookv2.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.esraa.rxjavafacebookv2.R;

 public class MainActivity extends AppCompatActivity {
PostViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        
    }
}