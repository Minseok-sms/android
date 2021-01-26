package kr.co.softcampus.basicdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);


    }
    public void btn1Method(View view){
        //다이얼로그에 관한정보를 객체 생성.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("default dialog");
        builder.setMessage("dialog's message");
        builder.setIcon(R.mipmap.ic_launcher);
        DialogListener listener = new DialogListener();

        //다이얼로그의 버튼을 설정
        builder.setPositiveButton("Positive",listener);
        builder.setNeutralButton("Neutral",listener);
        builder.setNegativeButton("Negative",listener);

        builder.show();
        //다이어로그의 리스너


    }
    class DialogListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //버튼 종류
            switch(which){
                case DialogInterface.BUTTON_POSITIVE:
                    text1.setText("Positive");
                    break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        text1.setText("Negative");
                        break;
                        case DialogInterface.BUTTON_NEUTRAL:
                            text1.setText("Neutral");
                            break;

            }
        }
    }
    public void btn2Method(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("custom dialog");
        //setmessage 를 커스텀으로 교체
        builder.setIcon(R.mipmap.ic_launcher);

        LayoutInflater inflater = getLayoutInflater();
        View v1 = inflater.inflate(R.layout.dialog, null);
        builder.setView(v1);
        Dialog2Listener listener = new Dialog2Listener();

        builder.setPositiveButton("ok",listener);
        builder.setNegativeButton("No",null);
        builder.show();


    }
    class Dialog2Listener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            AlertDialog alert = (AlertDialog)dialog;
            EditText edit1 = (EditText)alert.findViewById(R.id.editTextTextPersonName);
            EditText edit2 = (EditText)alert.findViewById(R.id.editTextTextPersonName2);
            String str1 = edit1.getText().toString();
            String str2 = edit2.getText().toString();

            text1.setText("edit1 : " + str1 + str2);
        }
    }
    public void btn3Method(View view){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        Dialog3Listener listener = new Dialog3Listener();
        DatePickerDialog picker = new DatePickerDialog(this, listener, year, month, day);
        picker.show();

    }
    class Dialog3Listener implements DatePickerDialog.OnDateSetListener{
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            text1.setText(year + "년 " + (month + 1) + "월 " + dayOfMonth + "일");
        }
    }
}