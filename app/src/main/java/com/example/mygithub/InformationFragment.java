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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InformationFragment extends Fragment {


    TextView name,follower,following,createday,updateday;
    String username;
    static Bitmap myImage;
    ImageView avatarImg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_information, container, false);
        name=view.findViewById(R.id.name);
        Bundle extras=getActivity().getIntent().getExtras();
        username=extras.getString("username_String");//id를 받아옴
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
        protected Bitmap doInBackground(String... urls) {
            try{
                URL url=new URL(urls[0]);
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
            public void onResponse(Call<GitHubUsers> call, Response<GitHubUsers> response) { //정보를 가져와서
                InformationFragment.ImageDownloader task=new InformationFragment.ImageDownloader();

                    try{
                        InformationFragment.myImage=task.execute(response.body().getAvatar()).get();
                        name.setText(response.body().getLogin()+"");
                        following.setText("팔로잉:"+response.body().getFollowing());
                        follower.setText("팔로워:"+response.body().getFollowers());
                        createday.setText("만든날짜:"+ response.body().getMadedate().substring(0,10));
                        updateday.setText("마지막커밋:"+response.body().getLastdate().substring(0,10));                      //데이터를 넣는데 만약 오류가 나면 try안에 있는 코드들은 건너뜀

                    } catch (Exception e) {                                                                 //try 안에서 오류가 나면 입력한 id에 문제가 있다는것이니깐 토스트를 띄우고 다시입력하도록 MainActivity로 돌아감
                        Toast.makeText(getActivity().getApplicationContext(),"사용자를 찾을수 없습니다.",Toast.LENGTH_SHORT).show();
                        getActivity().finish();
                    }
                    avatarImg.setImageBitmap(InformationFragment.myImage);
                    avatarImg.getLayoutParams().height=400;
                    avatarImg.getLayoutParams().width=400;

                }

            @Override
            public void onFailure(Call<GitHubUsers> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(),"로딩실패", Toast.LENGTH_SHORT);
                getActivity().finish();
            }
        });
    }

}