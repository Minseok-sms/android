package kr.co.softcampus.brapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnMethod(View view){
        //Intent intent = new Intent();
        // intent.setClassName("kr.co.softcampus.brapp1","kr.co.softcampus.brapp1.TestReceiver");
        Intent intent = new Intent("kr.co.softcampus.testbr");
        sendBroadcast(intent);
    }
}