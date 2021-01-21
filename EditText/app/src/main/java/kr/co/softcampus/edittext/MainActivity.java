package kr.co.softcampus.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit1;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText)findViewById(R.id.editText2);
        text1 = (TextView)findViewById(R.id.textView);

        EnterListener listener = new EnterListener();
        edit1.setOnEditorActionListener(listener);

        WatcherClass watcher = new WatcherClass();
        edit1.addTextChangedListener(watcher);


    }
    public void btn1Method(View view){
        edit1.setText("new edit text");
    }
    public void btn2Method(View view){
        String str = edit1.getText().toString();
        text1.setText("get message : " + str);

    }
    class EnterListener implements TextView.OnEditorActionListener{
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            String str = v.getText().toString();

            text1.setText("put string : " + str);
            return false;
        }
    }
    class WatcherClass implements TextWatcher {

        // 문자열 값이 변경되었을 때
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            text1.setText("changed text : " + s);
        }
        //문자열이 변경되기전 .
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        //문자열 값이 변경된 이후
        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}