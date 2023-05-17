package com.example.testapp;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.testapp.model.DailyBoxOfficeList;
import com.example.testapp.model.MyPojo;
import com.example.testapp.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MovieAPI extends AppCompatActivity {

    TextView movie_textView;

    final String MOVIE_API = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/";
    final String API_KEY = "f5eef3421c602c6cb7ea224104795888";
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    MyPojo dataList;
    List<DailyBoxOfficeList> dataInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_api);

        dataInfo = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MovieAPI.this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CustomAdapter(getApplicationContext(), dataInfo);
        recyclerView.setAdapter(adapter);

        Button movie_button = findViewById(R.id.movie_button);
        movie_textView = findViewById(R.id.movie_textView);

        movie_button.setOnClickListener((v) -> {
            String targetDt = "20230501";
            this.getMovieDatas(targetDt);
        });
    }

    public void getMovieDatas(String targetDt) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MOVIE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        Call<MyPojo> call = retrofitService.findAll(
                API_KEY,
                targetDt
        );

        try {
            call.enqueue(new Callback<MyPojo>() {
                @Override
                public void onResponse(Call<MyPojo> call, Response<MyPojo> response) {
                    if (response.isSuccessful()) {
                        MyPojo body = response.body();
                        Log.d(TAG, "body: 성공:\n" + body);
                        Log.d(TAG, "response: 성공:\n" + body.toString());
                        Log.d(TAG, "getBoxOfficeResult: 성공:\n" + body.getBoxOfficeResult().toString());

                        dataList = response.body();
                        dataInfo = body.getBoxOfficeResult().getDailyBoxOfficeList();
                        adapter.setData(dataInfo);

//                        movie_textView.setText(body.getBoxOfficeResult().toString()+'\n');

                        ArrayList<DailyBoxOfficeList> list = body.getBoxOfficeResult().getDailyBoxOfficeList();
                        Log.d(TAG, "getDailyBoxOfficeList():\n" );
                        for (int i = 0; i < list.size() ; i++) {
                            Log.d(TAG,  list.get(i).toString() );
//                            movie_textView.append(list.get(i).toString()+"\n");
                        }

                    } else {
                        Log.d(TAG, "onResponse: 실패");
                    }
                }

                @Override
                public void onFailure(Call<MyPojo> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t.getMessage());
                }
            });

        } catch (Exception e) {
            Log.d(TAG, "Exception: " + e.getMessage());
        }
    }
}