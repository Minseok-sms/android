package kr.co.softcampus.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        text1 = findViewById(R.id.textView);


        Intent intent = getIntent();
        String str = intent.getStringExtra("str");
        text1.setText(str);
    }
}