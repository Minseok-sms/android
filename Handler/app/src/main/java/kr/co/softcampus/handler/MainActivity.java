package kr.co.softcampus.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //뷰의 주소값
    TextView text1,text2;
    Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);
        handler = new Handler();
        //핸들러를 통한 요청할 작업
        ThreadClass thread = new ThreadClass();
        //thread.start();
        //핸들러 를통해 작업을 요청 작업은 메인 쓰레드가 처리함.  위엣꺼는 따로 쓰래드 생성.
        //한번 요청하고 끝.
        //handler.post(thread);
        handler.postDelayed(thread, 100);

    }
    public void btnMethod(View view){
        long now = System.currentTimeMillis();
        text1.setText("버튼클릭 : " + now);
    }
    class ThreadClass extends Thread{
        @Override
        public void run() {
            long now = System.currentTimeMillis();
            text2.setText("Handler : " + now);
            //현재 작업을 다시 요청함.
            //handler.post(this);
            handler.postDelayed(this,100);
        }
    }
}