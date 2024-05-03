package com.example.task61d;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import okhttp3.OkHttpClient;

public class InterestSelectionActivity extends AppCompatActivity {


    private CheckBox[] checkBoxes;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_selection);

        // Initialise 初始化
        checkBoxes = new CheckBox[]{
                findViewById(R.id.checkBoxTechnology),
                findViewById(R.id.checkBoxBasketball),
                findViewById(R.id.checkBoxMusic),
                findViewById(R.id.checkBoxDance),
                findViewById(R.id.checkBoxAlgorithms),
                findViewById(R.id.checkBoxWebDevelopment),
                findViewById(R.id.checkBoxAI),
                findViewById(R.id.checkBoxDataStructure),
                findViewById(R.id.checkBoxTesting)
        };


        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add 选中兴趣
                List<String> selectedInterests = new ArrayList<>();


                for (CheckBox checkBox : checkBoxes) {
                    // 检查当前复选框是否被选中
                    if (checkBox.isChecked()) {
                        // 将选中的兴趣添加到列表中
                        selectedInterests.add(checkBox.getText().toString());

                    }
                }


                Intent intent = new Intent(InterestSelectionActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        //  CheckBox setOnClickListener
        for (final CheckBox checkBox : checkBoxes) {
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (checkBox.isChecked()) {
                        checkBox.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                    } else {
                        checkBox.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    }
                }
            });
        }
    }

}
