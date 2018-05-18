package com.androidstudy.androidjetpackdemo.data.dao;

import android.arch.persistence.room.Insert;

import com.androidstudy.androidjetpackdemo.data.model.User;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

public interface UserDao {

    //Insert User
    @Insert(onConflict = REPLACE)
    void addUser(User user);
}
