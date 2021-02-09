package kr.co.softcampus.onresultactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void btnMethod(View view){
        //실행결과를 셋팅한다.
        //setResult(RESULT_OK);

        finish();
    }
    public void btn2Method(View view){
        setResult(RESULT_CANCELED);
        finish();
    }

    public void btn3Method(View view){
        setResult(RESULT_FIRST_USER);
        finish();
    }

    public void btn4Method(View view){
        setResult(RESULT_FIRST_USER + 1);
        finish();
    }

}