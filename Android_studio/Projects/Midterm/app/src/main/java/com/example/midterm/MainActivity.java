package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main.xml파일 실행
        setContentView(R.layout.activity_main);


        //Login 버튼 클릭시 액티비티 전환
        Button login_btn = (Button) findViewById(R.id.login_button);
        login_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}