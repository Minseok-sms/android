package kr.co.softcampus.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar bar5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar5 = (ProgressBar)findViewById(R.id.progressBar5);
    }
    public void btn1Method(View view){
        bar5.incrementProgressBy(5);
    }
    public void btn2Method(View view){
        bar5.incrementProgressBy(-5);
    }
    public void btn3Method(View view){
        bar5.setProgress(80);
    }
}