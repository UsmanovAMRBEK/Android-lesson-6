package com.example.android_lesson_006;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.android_lesson_006.questions.Question;
import com.example.android_lesson_006.questions.Questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView questionNum;
    TextView tvQuestion;
    RadioGroup rgAnswers;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    AppCompatButton previousBtn;
    AppCompatButton nextBtn;
    List<Question> questionList;
    TextView corrects;
    int currentQuestion;
    boolean isEnd;
    int correctAnswers;
    int belgilangan;
    Map<Integer, Integer> userAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        onclicks();
    }


    private void initUI() {
        progressBar = findViewById(R.id.progress_horizontal);
        questionNum = findViewById(R.id.tv_qnumber);
        tvQuestion = findViewById(R.id.tv_question);
        rb1 = findViewById(R.id.rb_1);
        rb2 = findViewById(R.id.rb_2);
        rb3 = findViewById(R.id.rb_3);
        previousBtn = findViewById(R.id.btn_previous);
        nextBtn = findViewById(R.id.btn_next);
        // load questions
        belgilangan = 1;
        questionList = Questions.getQuestions(); // savollarni chaqiradi
        currentQuestion = 0; // savollarni tartib raqami
        loadQuestions(currentQuestion); // savollarni yuklaydi
        userAnswers = new HashMap<>(); // userdan javoblarni olish uchun
        corrects = findViewById(R.id.correct); // correct tanlanganlar uchun
        // tugatish uchun
        isEnd = false;
    }


    private void onclicks() {
        nextBtn.setOnClickListener(view -> {

            if (currentQuestion < questionList.size() - 1) {
                loadQuestions(++currentQuestion);
            }
            if (currentQuestion == questionList.size() - 1) {
                nextBtn.setText("Finish");
                isEnd = true;
            }
            corrects.setText(countCorrects());

//            if (isEnd) {
//                corrects.setText(countCorrects());
////                Intent i = new Intent(this, activity_congrlatulations.class);
////                Bundle bundle = new Bundle();
////                bundle.putString("natija", countCorrects());
////                i.putExtras(bundle);
////                startActivity(i);
////                setContentView(R.layout.activity_congrlatulations);
//            }
//            Toast.makeText(MainActivity.this, "Next bosildi", Toast.LENGTH_SHORT).show();
        });

        previousBtn.setOnClickListener(view -> {

            nextBtn.setText("Next");
            if (currentQuestion > 0) {
                loadQuestions(--currentQuestion);
            }
            corrects.setText(countCorrects());
//            Toast.makeText(MainActivity.this, "Previous bosildi", Toast.LENGTH_SHORT).show();
        });

        rbBackgorund();

    }
    private void loadQuestions(int i) {
        loadUserTickAnswers(-1);
        try {
            if (userAnswers.containsKey(currentQuestion)){
                loadUserTickAnswers(userAnswers.get(currentQuestion));
            }
        }catch (Exception e) {
            Toast.makeText(this, "Loadquestionsdan", Toast.LENGTH_SHORT).show();
        }
        tvQuestion.setText(questionList.get(i).getQuestion());
        rb1.setText(questionList.get(i).getAnswer1());
        rb2.setText(questionList.get(i).getAnswer2());
        rb3.setText(questionList.get(i).getAnswer3());
        questionNum.setText((i+1) + "/" + (questionList.size()));
        progressBar.setProgress((i+1)  * 100 / questionList.size());
    }

    public void rbBackgorund(){
        rb1.setOnClickListener(view -> {
            userAnswers.put(currentQuestion, 1);
            rb1.setBackgroundResource(R.drawable.answer_bg);
            rb2.setBackgroundResource(R.drawable.answer_bg2);
            rb3.setBackgroundResource(R.drawable.answer_bg2);
            Toast.makeText(this, userAnswers.toString(), Toast.LENGTH_SHORT).show();
        });
        rb2.setOnClickListener(view -> {
            userAnswers.put(currentQuestion, 2);
            rb2.setBackgroundResource(R.drawable.answer_bg);
            rb1.setBackgroundResource(R.drawable.answer_bg2);
            rb3.setBackgroundResource(R.drawable.answer_bg2);
            Toast.makeText(this, userAnswers.toString(), Toast.LENGTH_SHORT).show();
        });
        rb3.setOnClickListener(view -> {
            userAnswers.put(currentQuestion, 3);
            rb3.setBackgroundResource(R.drawable.answer_bg);
            rb1.setBackgroundResource(R.drawable.answer_bg2);
            rb2.setBackgroundResource(R.drawable.answer_bg2);
            Toast.makeText(this, userAnswers.toString(), Toast.LENGTH_SHORT).show();
        });
    }
    private void loadUserTickAnswers(int i) {
        switch (i) {
            case 1:
                rb1.setBackgroundResource(R.drawable.answer_bg);
                rb2.setBackgroundResource(R.drawable.answer_bg2);
                rb3.setBackgroundResource(R.drawable.answer_bg2);
                break;
            case 2:
                rb1.setBackgroundResource(R.drawable.answer_bg2);
                rb2.setBackgroundResource(R.drawable.answer_bg);
                rb3.setBackgroundResource(R.drawable.answer_bg2);
                break;
            case 3:
                rb1.setBackgroundResource(R.drawable.answer_bg2);
                rb2.setBackgroundResource(R.drawable.answer_bg2);
                rb3.setBackgroundResource(R.drawable.answer_bg);
                break;
            default:
                rb3.setBackgroundResource(R.drawable.answer_bg2);
                rb1.setBackgroundResource(R.drawable.answer_bg2);
                rb2.setBackgroundResource(R.drawable.answer_bg2);
                break;
        }
    }

    private String countCorrects() {
        int res = 0;
        int q = 0;
        for (Question question : questionList) {
            try {
                if(question.getCorrectAnswer() == userAnswers.get(q++)) {
                    res += 1;
                }
            }catch (Exception e) {
//                Toast.makeText(this, "countCorrects funksiyasidan", Toast.LENGTH_SHORT).show();
            }
        }
        return String.valueOf(res);
    }

}