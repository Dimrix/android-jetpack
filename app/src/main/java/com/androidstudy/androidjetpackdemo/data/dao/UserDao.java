package com.androidstudy.androidjetpackdemo.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.androidstudy.androidjetpackdemo.data.model.User;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {

    //Insert User
    @Insert(onConflict = REPLACE)
    void addUser(User user);
}
