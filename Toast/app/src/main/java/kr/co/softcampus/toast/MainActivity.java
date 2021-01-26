package kr.co.softcampus.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn1Method(View view){
        //토스트 객체를 생성한다.
        Toast t1 = Toast.makeText(this,"hello from the other side", Toast.LENGTH_SHORT);
        // 토스트 메세 지를 운영체제에 요청
        t1.show();
    }
    public void btn2Method(View view){
        LayoutInflater inflater = getLayoutInflater();
        View v1 = inflater.inflate(R.layout.custom_toast, null);
        ImageView img1 = (ImageView)v1.findViewById(R.id.imageView3);
        TextView text1 = (TextView)v1.findViewById(R.id.textView2);
        //뷰의 배경을 토스트 전용 배경 이미지로 설정한다 .

        v1.setBackgroundResource(android.R.drawable.toast_frame);


        img1.setImageResource(R.drawable.img_android);
        text1.setText("custom toast");

        Toast t2 = new Toast(this);
        t2.setView(v1);
        t2.setDuration(Toast.LENGTH_LONG);
        t2.setGravity(Gravity.CENTER,0,0);
        t2.show();

    }
}