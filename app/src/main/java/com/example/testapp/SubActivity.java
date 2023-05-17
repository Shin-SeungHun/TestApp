package com.example.testapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    // 변서 선언
    TextView sub_textView;
    EditText sub_editTextText;
    Button sub_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // 초기화
        sub_textView = findViewById(R.id.sub_textView);
        sub_editTextText = findViewById(R.id.sub_editTextText);

        // 인텐트 값 가져오기
        String getMainMsg = getIntent().getStringExtra("mainActivityMsg").toString();

        // 가져온 값 화면에 바인딩
        sub_textView.setText(getMainMsg);

        // 닫기 버튼
        sub_button = findViewById(R.id.sub_button);
        sub_button.setOnClickListener((v) -> {
            
            // 인텐트 초기화
            Intent intent = new Intent(SubActivity.this, MainActivity.class);
            
            intent.putExtra("subActivityMsg", sub_editTextText.getText().toString());

            // 상태값 추가 전달
            setResult(RESULT_OK, intent);

            finish();

        });


    }


}