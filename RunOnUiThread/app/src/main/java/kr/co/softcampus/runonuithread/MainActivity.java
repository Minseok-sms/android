package kr.co.softcampus.runonuithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //뷰의 주소값을 받는다 .
        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);
        //쓰래드를 가동
        isRunning = true;
        ThreadClass thread = new ThreadClass();
        thread.start();

    }
    public void btnMethod(View view){
        long now = System.currentTimeMillis();
        text1.setText("버튼 클릭 : " + now);
    }
    class ThreadClass extends Thread{
        @Override
        public void run() {
            while(isRunning){
                SystemClock.sleep(100);
                final long time = System.currentTimeMillis();
                Log.d("test", "thread : " + time);
                //일반쓰래드에서 화면처리가 필요할경우 runOnUiThread 메서드를 사용한다 .
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        text2.setText("Thread : " + time);
                    }
                });
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }
}