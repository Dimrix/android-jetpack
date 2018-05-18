package com.androidstudy.androidjetpackdemo.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.androidstudy.androidjetpackdemo.data.Database;
import com.androidstudy.androidjetpackdemo.data.model.User;

public class MainViewModel extends AndroidViewModel {

    private Database appDatabase;

    public MainViewModel(@NonNull Application application) {
        super(application);
        appDatabase = Database.getDatabase(this.getApplication());
    }

    //Add New User
    public void addUser(User user) {
        new addAsyncTask(appDatabase).execute(user);
    }

    private static class addAsyncTask extends AsyncTask<User, Void, Void> {

        private Database db;

        addAsyncTask(Database appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final User... params) {
            db.userDao().addUser(params[0]);
            return null;
        }

    }
}
