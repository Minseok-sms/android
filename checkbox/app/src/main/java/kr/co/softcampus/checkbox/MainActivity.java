package kr.co.softcampus.checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    CheckBox check1,check2,check3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        check1 = (CheckBox)findViewById(R.id.checkBox);
        check2 = (CheckBox)findViewById(R.id.checkBox2);
        check3 = (CheckBox)findViewById(R.id.checkBox3);

        //체크박스의 리스너를 설정.
        CheckBoxListener listener = new CheckBoxListener();
        check1.setOnCheckedChangeListener(listener);
        check2.setOnCheckedChangeListener(listener);
        check3.setOnCheckedChangeListener(listener);

    }
    //첫번쨰 버튼을 누루면 호출되는 메서드

    public void btn1Method(View view){
        text1.setText("");
        // 체크 상태에 따라 필요한 처리를 해준다 .
        boolean a1 = check1.isChecked();
        boolean a2 = check2.isChecked();
        boolean a3 = check3.isChecked();

        if(a1 == true){
            text1.append("check 1 is checked\n");
        }
        if(a2 == true){
            text1.append("check 2 is checked\n");
        }
        if(a3 == true){
            text1.append("check 3 is checked\n");
        }
    }

    // 두번쨰 버튼과 연결된 메서드
    // 모든 체커박스의 상태를 체크상태로 설정.
    public void btn2Method(View view){
        check1.setChecked(true);
        check2.setChecked(true);
        check3.setChecked(true);
    }
    public void btn3Method(View view){
        check1.setChecked(false);
        check2.setChecked(false);
        check3.setChecked(false);
    }
    // 네번쨰 버튼과 연결된 메서드
    // 모든 체커박스의 상태를 반전시킴.
    public void btn4Method(View view){
        check1.toggle();
        check2.toggle();
        check3.toggle();
    }
    //체크박스의 체크상태가 변경되면 반응 하는 메서드
    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int id = buttonView.getId();
            switch(id){
                case R.id.checkBox:
                    if(isChecked == true)
                        text1.setText("checkbox 1 is checked");
                    else
                        text1.setText("checkbox 1 is checked non");
                    break;
                case R.id.checkBox2 :
                    if(isChecked == true)
                        text1.setText("checkbox 2 is checked");
                    else
                        text1.setText("checkbox 2 is checked non");
                    break;
                case R.id.checkBox3 :
                    if(isChecked == true)
                        text1.setText("checkbox 3 is checked");
                    else
                        text1.setText("checkbox 3 is checked non");
                    break;
            }
        }
    }
}