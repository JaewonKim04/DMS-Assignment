package com.example.mygithub;

import android.view.View;

public interface OnReposItemClick {
    void onItemClick(ReposAdapter.ViewHolder holder, View view,int position);
}
