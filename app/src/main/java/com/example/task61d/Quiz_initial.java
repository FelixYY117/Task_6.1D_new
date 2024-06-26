package com.example.task61d;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import okhttp3.OkHttpClient;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Quiz_initial extends AppCompatActivity {
    private String Username;
    private String description;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_initial);


        Intent intent = getIntent();
        if (intent != null) {
            Username = intent.getStringExtra("username");
        }

        TextView username = findViewById(R.id.textusername);
        ImageButton start = findViewById(R.id.buttonContinue);
        TextView Description = findViewById(R.id.testtaskDescription);

        //get interest
        DBHelper dbHelper = new DBHelper(this);
        List<String> Interests = dbHelper.getUserInterests(Username);

//        int index = (int) (Math.random() * Interests.size());
//        description = Interests.get(index);
        if (Interests.isEmpty()) {
            // 处理空列表的情况,例如使用默认主题或提示用户添加兴趣
            description = "AI";
        } else {
            //随机一个作为测验
            int index = (int) (Math.random() * Interests.size());
            description = Interests.get(index);
        }
        username.setText(Username);
        Description.setText(String.format("Click the following button to get into the quiz of %s", description));

        //启动OnClickListener
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动test页面
                Intent intent = new Intent(Quiz_initial.this, Quiz.class);
                intent.putExtra("description", description);
                startActivity(intent);
            }

        });
    }
}
