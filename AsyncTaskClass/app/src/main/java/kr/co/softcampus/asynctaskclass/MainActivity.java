package kr.co.softcampus.asynctaskclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //뷰의 주소값을 받을 참조변수
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);

        AsyncTaskClass async = new AsyncTaskClass();
        async.execute(10,20);

    }
    public void btnMethod(View view){
        long now = System.currentTimeMillis();
        text1.setText("click : " + now);
    }
    //첫번째 제네릭 : execute 메서드의 매게변수, doInBackground 메서드의 매개 변수 타입
    //두번쨰 제네릭 : publishProgress 메서드의 매개변수 , OnProgressUpdate 메서드의 매개변수타입.
    //세번쨰 제네릭 : doInBackground 메서드의 반환 타입, onPostExecute 매개변수
    class AsyncTaskClass extends AsyncTask<Integer, Long, String>{
        @Override
        //doInBackground 메서드가 호출되기전에 호출되는 메서드 Main Thread가처리
        //일반 쓰래드로 처리할 작업이 동작하기전에 필요한 사전 작업을 해준다.


        protected void onPreExecute() {
            super.onPreExecute();
            text2.setText("AsyncTask  가동 ");
        }
        //메인쓰레드가아닌 일반쓰레드가 처리하는

        @Override
        protected String doInBackground(Integer... integers) {
            int a1 = integers[0];
            int a2 = integers[1];

            for(int i = 0 ;i < 10 ; i++){
                SystemClock.sleep(1000);
                a1++;
                a2++;
                Log.d("Test", i + " : " + a1 + ", " + a2);
                // 일반 쓰래드 에서 화면처리 하기위함
                long now = System.currentTimeMillis();
                publishProgress(now);
            }
            return "작업 종료";
        }
        //doInBackground메서드에서 publishProgress메서드를 호출하면 Main Thread가 처리하는 메서드.
        // 일반 doInBackground메서드내에서 화면처리가 필요할때 main thread
        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            text2.setText("async : " + values[0]);
        }
        //doInBackground가 완료되면 Main thread가 처리
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            text2.setText(s);
        }
    }
}