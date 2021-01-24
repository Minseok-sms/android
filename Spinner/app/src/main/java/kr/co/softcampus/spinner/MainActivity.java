package kr.co.softcampus.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //스피너 구성을 위한 문자열 배열

    String [] data1 = {"spinner1","spinner2","spinner3","spinner4","spinner5"};
    Spinner spin1;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin1 = (Spinner)findViewById(R.id.spinner);
        text1 = (TextView)findViewById(R.id.textView);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,data1);
        //드롭다운 으로 나타나는 항목 뷰
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adapter1);
        SpinnerListener listener = new SpinnerListener();
        spin1.setOnItemSelectedListener(listener);

    }
    public void btnMethod(View view){
        int index = spin1.getSelectedItemPosition();
        text1.setText("selected : " + data1[index]);

    }
    class SpinnerListener implements AdapterView.OnItemSelectedListener{
        //사용자가 항목을 선택햇을시
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            text1.setText(data1[position]);

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

}