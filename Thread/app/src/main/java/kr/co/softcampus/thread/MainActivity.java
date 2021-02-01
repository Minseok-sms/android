package kr.co.softcampus.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //뷰의 주소값을 담을참조변수
    TextView text1,text2;
    //쓰래드 동작여부 변수
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);
//        while(true){
//            SystemClock.sleep(100);
//            long now = System.currentTimeMillis();
//            text2.setText("무한 루프 : " + now);
//        }
        //오래걸리는 작업 처리를위해 쓰래드를 발생시킴
        isRunning = true;
        ThreadClass thread = new ThreadClass();
        thread.start();

    }
    public void btnMethod(View view){
        //현재 시간값 을 가져옴
        long now = System.currentTimeMillis();
        text1.setText("버튼 클릭 : " + now);
        // 100ms 마다 현재시간을 가져와서 출력 한다 .

    }

    // 쓰래드 클래스
    class ThreadClass extends Thread{
        @Override
        public void run() {
            while(isRunning){
                SystemClock.sleep(100);
                long now = System.currentTimeMillis();
                Log.d("text", "쓰래드 : " + now);
                text2.setText("쓰래드 : " + now);
            }
        }
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        //쓰래드 종료를 위해 false 값을 넣어준다.
        isRunning = false;
    }
}