package kr.co.softcampus.onresultactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //뷰의 주솟값을 담을 참조변수
    TextView text2;
    final int SECOND_ACTIVITY = 1;
    final int THIRD_ACTIVITY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text2 = (TextView)findViewById(R.id.textView2);
    }
    public void btn1Method(View view){
        //SecondActivity 실행을 요청한다 .
        Intent intent = new Intent(this, SecondActivity.class);
        //startActivity(intent);
        startActivityForResult(intent, SECOND_ACTIVITY);

    }
    public void btn2Method(View view){
        //ThirdActivity 실행을 요청한다.
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivityForResult(intent, THIRD_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case SECOND_ACTIVITY:
                text2.setText("Second back\n");
                switch(resultCode){
                    case RESULT_OK:
                        text2.append("RESULT_OK");
                        break;
                    case RESULT_CANCELED:
                        text2.append("RESULT_CANCELED");
                        break;
                    case RESULT_FIRST_USER:
                        text2.append("RESULT_FIRST_USER");
                        break;
                    case RESULT_FIRST_USER + 1:
                        text2.append("RESULT_FIRST_USER + 1");
                        break;
                }
                break;
            case THIRD_ACTIVITY:
                text2.setText("Third back");
                break;

        }


    }
}