package com.example.android_lesson_006;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class activity_congrlatulations extends AppCompatActivity {

    TextView tvResult;
    ImageView ivStar1;
    ImageView ivStar2;
    ImageView ivStar3;
    LinearLayout lnPlayAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrlatulations);
    }
    private void initUI() {
        tvResult = findViewById(R.id.result);
        ivStar1 = findViewById(R.id.star1);
        ivStar2 = findViewById(R.id.star2);
        ivStar3 = findViewById(R.id.star3);
        lnPlayAgain = findViewById(R.id.play_again);

        Bundle bundle = getIntent().getExtras();
        String resultVal = bundle.getString("natija");

        onClicks();
        tvResult.setText(resultVal);
    }

    private void onClicks() {
        lnPlayAgain.setOnClickListener(view -> {
            setContentView(R.layout.activity_main);
        });
    }
}