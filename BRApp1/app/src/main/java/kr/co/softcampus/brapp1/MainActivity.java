package kr.co.softcampus.brapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //broadcast receiver
    TestReceiver br;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //안드로이드 8.0이상이면 암시적 인텐트를 코드로 등록
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            br = new TestReceiver();
            IntentFilter filter = new IntentFilter("kr.co.softcampus.testbr");
            registerReceiver(br,filter);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            if(br != null){
                unregisterReceiver(br);
                br = null;
            }
        }
    }
}