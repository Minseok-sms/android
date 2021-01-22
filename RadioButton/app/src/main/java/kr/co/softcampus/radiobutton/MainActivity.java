package kr.co.softcampus.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioButton radio3,radio4;
    RadioGroup group1,group2;
    TextView text1,text2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radio3 = (RadioButton)findViewById(R.id.radioButton3);
        radio4 = (RadioButton)findViewById(R.id.radioButton4);

        group1 = (RadioGroup)findViewById(R.id.group1);
        group2 = (RadioGroup)findViewById(R.id.group2);

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);
        RadioListener radiolisten = new RadioListener();
        group1.setOnCheckedChangeListener(radiolisten);
        group2.setOnCheckedChangeListener(radiolisten);


    }
    public void btn1Method(View view){
        radio3.setChecked(true);
        radio4.setChecked(true);
    }
    public void btn2Method(View view){
        int id1 = group1.getCheckedRadioButtonId(); // 그룹내에 채크되어잇는라디오 버튼 아이디값
        int id2 = group2.getCheckedRadioButtonId();

        switch(id1){
            case R.id.radioButton :
                text1.setText("1-1 radio button set");
                break;
            case R.id.radioButton2 :
                text1.setText("1-2 radio button set");
                break;
            case R.id.radioButton3 :
                text1.setText("1-3 radio button set");
                break;

        }
        switch(id2){
            case R.id.radioButton4 :
                text2.setText("2-1 radio button set");
                break;
            case R.id.radioButton5 :
                text2.setText("2-2 radio button set");
                break;
            case R.id.radioButton6 :
                text2.setText("2-3 radio button set");
                break;

        }
    }
    class RadioListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id = group.getId();
            switch(id){
                case R.id.group1:
                    switch(checkedId){
                        case R.id.radioButton :
                            text1.setText("radio event 1-1");
                            break;
                        case R.id.radioButton2 :
                            text1.setText("radio event 1-2");
                            break;
                        case R.id.radioButton3 :
                            text1.setText("radio event 1-3");
                            break;
                    }
                    break;
                case R.id.group2:
                    switch(checkedId){
                        case R.id.radioButton4 :
                            text2.setText("radio event 2-1");
                            break;
                        case R.id.radioButton5 :
                            text2.setText("radio event 2-2");
                            break;
                        case R.id.radioButton6 :
                            text2.setText("radio event 2-3");
                            break;
                    }
                    break;
            }

        }
    }
}