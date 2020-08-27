package com.example.mygithub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.model.GitHubRepo;

import java.util.ArrayList;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> implements OnReposItemClick{
ArrayList<GitHubRepo>repos=new ArrayList<GitHubRepo>();
private int rowLayout;
private Context context;
OnReposItemClick listener;

public ReposAdapter(ArrayList<GitHubRepo>repos,int rowLayout,Context context){
    this.setRepos(repos);
    this.setRowLayout(rowLayout);
    this.setContext(context);
}

    @NonNull
    @Override
    public ReposAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new ViewHolder(view,this);
    }

    public void setRepos(ArrayList<GitHubRepo> repos) {
        this.repos = repos;
    }


    public void setContext(Context context) {
        this.context = context;
    }


    public Repos setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
        return null;
    }
    public GitHubRepo getItem(int position){
    return repos.get(position);
    }




    @Override
    public void onBindViewHolder(@NonNull ReposAdapter.ViewHolder holder, int position) {
holder.reposTitle.setText(repos.get(position).getName());
holder.reposCreate.setText("create:"+repos.get(position).getCreate().substring(0,10));
holder.reposUpdate.setText("update:"+repos.get(position).getUpdate().substring(0,10));//날짜까지만 출력하기 위해서 10글자 까지만 잘라냄
holder.reposLanguage.setText(repos.get(position).getLanguage());
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public void setOnItemClickListener(OnReposItemClick listener){
    this.listener=listener;
    }
    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener!=null){
            listener.onItemClick(holder,view,position);
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout reposLayout;
        TextView reposTitle,reposCreate,reposUpdate,reposLanguage;
        public ViewHolder(@NonNull View itemView,final OnReposItemClick listener) {
            super(itemView);
            reposLayout=itemView.findViewById(R.id.repo_list);
            reposTitle=itemView.findViewById(R.id.reposname);
            reposCreate=itemView.findViewById(R.id.createday);
            reposUpdate=itemView.findViewById(R.id.updateday);
            reposLanguage=itemView.findViewById(R.id.language);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    if(listener!=null){
                        listener.onItemClick(ViewHolder.this,view,position);
                    }
                }
            });
        }
    }
}
