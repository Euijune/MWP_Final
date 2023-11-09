package com.example.midterm;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignupActivity extends AppCompatActivity {
    private String request_url = "127.0.0.1:8000";
    private EditText uid, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_login.xml파일 실행
        setContentView(R.layout.activity_signup);

        uid = findViewById(R.id.signup_uid);
        pw = findViewById(R.id.signup_password);

        //login 버튼을 누르면 username, password에 입력한 정보 받아 server에 request
        Button login_btn = findViewById(R.id.register_button);
        login_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // REST API 요청
                getUserInfo();

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }

            public void getUserInfo() {
                try {
                    ///okHttpClient 호출
                    OkHttpClient client = new OkHttpClient();

                    //유저 정보 확인 후 로그인
                    JSONObject json_input = new JSONObject();
                    json_input.put("uid", uid.getText().toString());
                    json_input.put("pw", pw.getText().toString());

                    RequestBody reqBody = RequestBody.create(
                            json_input.toString(),
                            MediaType.parse("application/json; charset=utf-8")
                    );
                    Request request = new Request.Builder()
                            .post(reqBody)
                            .url(request_url+"/user/signup/")
                            .build();

                    Response response = null;
                    response = client.newCall(request).execute();
                    System.out.println(response.body().string());

                    // 있으면? 로그인해서 스터디화면으로 넘어감
                    // ... code

                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}