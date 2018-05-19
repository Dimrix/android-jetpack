package com.androidstudy.androidjetpackdemo.ui.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.androidstudy.androidjetpackdemo.R;
import com.androidstudy.androidjetpackdemo.data.model.User;
import com.androidstudy.androidjetpackdemo.databinding.ActivityMainBinding;
import com.androidstudy.androidjetpackdemo.ui.adapter.MainUserAdapter;
import com.androidstudy.androidjetpackdemo.ui.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    private List<User> userList;

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        //Initialize the View Model in your layout
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getUserList().observe(this, users -> {
            if (MainActivity.this.userList == null) {
                setListData(users);
            }
        });

        saveUser();
    }

    private void saveUser() {
        mainViewModel.addUser(new User(
                "Juma",
                "Allan",
                "27"
        ));
    }

    public void setListData(final List<User> userList) {
        this.userList = userList;
        if (userList.isEmpty()) {
            //Handle No User here - Like show an empty view
        } else {
            MainUserAdapter adapter =
                    new MainUserAdapter(userList, this);
            activityMainBinding.recyclerView.setAdapter(adapter);
        }
    }
}
