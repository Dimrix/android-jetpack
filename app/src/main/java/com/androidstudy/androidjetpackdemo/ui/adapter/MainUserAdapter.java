package com.androidstudy.androidjetpackdemo.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidstudy.androidjetpackdemo.R;
import com.androidstudy.androidjetpackdemo.data.model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainUserAdapter extends RecyclerView.Adapter<MainUserAdapter.UserHolder> {

    private Context context;
    private List<User> userList;

    public MainUserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_user, parent, false);
        final UserHolder mViewHolder = new UserHolder(itemView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        User user = userList.get(position);


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserHolder extends RecyclerView.ViewHolder {

        UserHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

