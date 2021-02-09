package kr.co.softcampus.parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text1 = (TextView)findViewById(R.id.textView);
        // intent 추출
        Intent intent = getIntent();

        //객체를 추출
        // 클래스의 CREATOR.createFromParcel 메서드를 호출해 반환받는 메서드를 반환한다.
        TestClass t1 = intent.getParcelableExtra("test1");
        text1.setText("t1.data10 : " + t1.data10 + "\n");
        text1.append("t2.data20 :  + t2.data20");

    }
    public void btnMethod(View view){
        Intent intent = new Intent();
        TestClass t2 = new TestClass();
        t2.data10 = 200;
        t2.data20 = "문자열 2";

        intent.putExtra("test2", t2);
        setResult(RESULT_OK,intent);
        finish();
    }
}