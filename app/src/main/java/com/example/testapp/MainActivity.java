package com.example.testapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView main_textView;
    Button main_button;
    EditText main_editTextText;


    // 돌아와서 실행
    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {

        if (result.getResultCode() == Activity.RESULT_OK) {
            // RESULT_OK -> 일 때 실행 할 코드
            Intent data = result.getData();
            String resultText = data.getStringExtra("subActivityMsg").toString();

            main_textView.setText(resultText);
        } else {
            // ex) 실패시 조치
        }

    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_textView = findViewById(R.id.main_textView);
        main_button = findViewById(R.id.main_button);
        main_editTextText = findViewById(R.id.main_editTextText);

        // 람다 형식 - 버튼 이벤트 리스터
        main_button.setOnClickListener((v) -> {
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            intent.putExtra("mainActivityMsg", main_editTextText.getText().toString());

            // 방법.1 - 인텐트
            // startActivity(intent);

            // 방법.2 - 양방향 -> launch()로 실행
            startActivityResult.launch(intent);
        });


        Button getMoviePage = findViewById(R.id.getMoviePage);

        getMoviePage.setOnClickListener((v) -> {
             startActivity(new Intent(MainActivity.this, MovieAPI.class));
        });


    }
}