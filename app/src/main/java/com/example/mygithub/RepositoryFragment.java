package com.example.mygithub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mygithub.OnReposItemClick;
import com.example.mygithub.R;
import com.example.mygithub.ReposAdapter;
import com.model.GitHubRepo;
import com.model.GitHubUsers;
import com.rest.AppClient;
import com.rest.GitHubRepoEndPoint;
import com.rest.GitHubUserEndPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryFragment extends Fragment{


    RecyclerView mrecyclerView;
    static String recievedUserName;
    TextView userNameTv;
    ArrayList<GitHubRepo> mdDtaSource=new ArrayList<>();
    ReposAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_repository, container, false);
        userNameTv=view.findViewById(R.id.userNameTV);
        mrecyclerView=view.findViewById(R.id.recyclerview);
        Bundle extras=getActivity().getIntent().getExtras();
        recievedUserName=extras.getString("username_String");
        userNameTv.setText("(Click to go repository)");
        loadRepositories();

        mrecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));      //
        mAdapter = new ReposAdapter(mdDtaSource,R.layout.repos_item, requireActivity().getApplicationContext());
        mrecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnReposItemClick() {
            @Override
            public void onItemClick(ReposAdapter.ViewHolder holder, View view, int position) {
                GitHubRepo item=mAdapter.getItem(position);
                String gotoRepos="https://github.com/"+recievedUserName+"/"+item.getName();
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(gotoRepos));
                startActivity(intent);
            }
        });
        return view;
    }
    public void loadRepositories(){
        GitHubRepoEndPoint apiService=AppClient.getClient().create(GitHubRepoEndPoint.class);
        Call<List<GitHubRepo>>call=apiService.getRepo(recievedUserName);
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                mdDtaSource.clear();
                mdDtaSource.addAll(response.body());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Log.d("Repos",t.toString());
            }
        });
    }
    
}