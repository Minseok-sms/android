package kr.co.softcampus.intentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    //View
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        text2 = (TextView)findViewById(R.id.textView2);
        //현 액티비티를 실행하기 위해 사용된 인텐트 객체를 추출 .
        Intent intent = getIntent();
        int data1 = intent.getIntExtra("data1",0);
        double data2 = intent.getDoubleExtra("data2",0.0);
        boolean data3 = intent.getBooleanExtra("data3",false);
        String data4 = intent.getStringExtra("data4");

        text2.setText("data1 : " + data1 + "\n");
        text2.append("data2 : " + data2 + "\n");
        text2.append("data3 : " + data3 + "\n");
        text2.append("data4 : " + data4);
    }
    public void btnMethod(View view){
        //돌아갈 때 전달할 데이터를 세팅한다 .
        Intent intent = new Intent();
        intent.putExtra("value1", 200);
        intent.putExtra("value2",22.22);
        intent.putExtra("value3", true);
        intent.putExtra("value4","write 2");

        setResult(RESULT_OK, intent);
        finish();
    }
}