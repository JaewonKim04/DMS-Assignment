package com.example.mygithub;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.model.GitHubUsers;
import com.rest.AppClient;
import com.rest.GitHubUserEndPoint;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InformationFragment extends Fragment {


    TextView name,follower,following,createday,updateday;
static String username,followingGet,followerGet,madeGet,updateGet;
    static Bitmap myImage;
ImageView avatarImg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_information, container, false);
        name=view.findViewById(R.id.name);
        Bundle extras=getActivity().getIntent().getExtras();
        username=extras.getString("username_String");
        following=view.findViewById(R.id.textView4);
        follower=view.findViewById(R.id.textView3);
        createday=view.findViewById(R.id.textView6);
        updateday=view.findViewById(R.id.textView5);
        avatarImg=view.findViewById(R.id.avatar);
        name.setText(username+"");
        loadData();
        return view;
    }
    public static class ImageDownloader extends AsyncTask<String,Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            try{
                URL url=new URL(strings[0]);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.connect();
                InputStream inputStream=connection.getInputStream();
                Bitmap myBitmap= BitmapFactory.decodeStream(inputStream);
                return myBitmap;
            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

    }
    public void loadData(){
        final GitHubUserEndPoint apiService= AppClient.getClient().create(GitHubUserEndPoint.class);
        Call<GitHubUsers>call=apiService.getUser(username);
        call.enqueue(new Callback<GitHubUsers>() {
            @Override
            public void onResponse(Call<GitHubUsers> call, Response<GitHubUsers> response) {
                InformationFragment.ImageDownloader task=new InformationFragment.ImageDownloader();
                    name.setText(response.body().getLogin()+"");
                    try{
                        InformationFragment.myImage=task.execute(response.body().getAvatar()).get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }catch (ExecutionException e){
                        e.printStackTrace();
                    }
                    avatarImg.setImageBitmap(InformationFragment.myImage);
                    avatarImg.getLayoutParams().height=400;
                    avatarImg.getLayoutParams().width=400;
                    following.setText("팔로잉:"+response.body().getFollowing());
                    follower.setText("팔로워:"+response.body().getFollowers());
                    createday.setText("만든날짜:"+response.body().getMadedate());
                    updateday.setText("마지막커밋:"+response.body().getLastdate());
                }

            @Override
            public void onFailure(Call<GitHubUsers> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(),"로딩실패", Toast.LENGTH_SHORT);
                getActivity().finish();
            }
        });
    }

}