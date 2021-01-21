package kr.co.softcampus.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //뷰의 주솟값을 담을 참조변수를 선언
    TextView text1;
    TextView text2;
    Button button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.text2);
        text1.setText("new text");
        text2 = (TextView)findViewById(R.id.textView3);
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);


        BtnListener1 listener1 = new BtnListener1();
        button1.setOnClickListener(listener1);

        BtnListener2 listener2 = new BtnListener2();
        button2.setOnClickListener(listener2);

        BtnListener34 listener34 = new BtnListener34();
        button3.setOnClickListener(listener34);
        button4.setOnClickListener(listener34);

    }




    //첫번째 버튼과 연결된 리스너
    class BtnListener1 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            text2.setText("첫번째 버튼을 눌렀습니다.");
            text1.setText("boa");
        }
    }
    //두번쨰 버튼과 연결된 리스너
    class BtnListener2 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            text2.setText("두번째 버튼을 눌렀습니다.");
            text1.setText("you are my every thing");
        }
    }
    // 세번쨰 네번째 버튼과 연결된 리스너
    class BtnListener34 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //이벤트가 발생된 뷰의 ID값을 추출
            int id = v.getId();
            switch (id){
                case R.id.button3 :
                    text2.setText("세번째 버튼을 눌렀습니다.");
                    break;
                case R.id.button4 :
                    text2.setText("네번쨰 버튼을 눌렀습니다.");

            }
        }
    }
    // 다섯번째 버튼을 누루면 호출되는 메서드
    public void btn5Method(View view){
        text2.setText("다섯번째 버튼을 눌렀습니다");
    }
    public void btn6Method(View view){
        text2.setText("여섯번째 버튼을 눌렀습니다.");
    }
    //일곱 여덜 번째 버튼을 누루면 호출되는 메서드
    public void btn78Method(View view){
        int id = view.getId();
        if(id == R.id.button7)
            text2.setText("일곱번째 버튼을 눌렀습니다.");
        else if(id == R.id.button8)
            text2.setText("여덟번째 버튼을 눌렀습니다.");

    }










}