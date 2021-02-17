package kr.co.softcampus.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.softcampus.calculator1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    boolean isFirstInput = true;
    ActivityMainBinding activityMainBinding;
    double resultNumber = 0;
    String operator = "+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
    }
    public void numButtonClick(View view){

        String getButtonText = view.getTag().toString();
        if(isFirstInput){
            activityMainBinding.resultTextView.setText(getButtonText);
            isFirstInput = false;
        }else{
            activityMainBinding.resultTextView.append(getButtonText);
        }

    }

    public void operatorClick(View view){
        double inputNumber = Double.parseDouble(activityMainBinding.resultTextView.getText().toString());
        if(operator.equals("+")){
            resultNumber += inputNumber;
        }else if(operator.equals("-")){
            resultNumber -= inputNumber;
        }else if(operator.equals("×")){
            resultNumber *= inputNumber;
        }else if(operator.equals("÷")){
            resultNumber /= inputNumber;
        }
        activityMainBinding.resultTextView.setText(String.valueOf(resultNumber));
        isFirstInput = true;
        operator = view.getTag().toString();
        activityMainBinding.mathTextView.append(inputNumber + " " + operator + " ");
    }
}