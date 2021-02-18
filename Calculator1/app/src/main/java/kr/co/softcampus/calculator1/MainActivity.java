package kr.co.softcampus.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import kr.co.softcampus.calculator1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    boolean isFirstInput = true;
    ActivityMainBinding activityMainBinding;
    boolean isOperatorClick = false;
    double resultNumber = 0;
    double inputNumber = 0;
    String lastOperator = "+";
    String operator = "=";
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
            if(operator.equals("=")){
                activityMainBinding.mathTextView.setText(null);

            }
        }else{
            if(activityMainBinding.resultTextView.getText().toString().equals("0")){
                Toast.makeText(this,"0으로 시작 되는 숫자는 없습니다.", Toast.LENGTH_SHORT).show();
                isFirstInput = true;
            }
            else {
                activityMainBinding.resultTextView.append(getButtonText);
            }
        }

    }

    public void operatorClick(View view){
        isOperatorClick = true;
        lastOperator = view.getTag().toString();
        if(isFirstInput){
            if(operator.equals("=")) {
                operator = view.getTag().toString();
                resultNumber = Double.parseDouble(activityMainBinding.resultTextView.getText().toString());
                activityMainBinding.mathTextView.setText(resultNumber + " " + operator + " ");
            }
                else{
                    operator = view.getTag().toString();
                    String getMathText = activityMainBinding.mathTextView.getText().toString();
                    String subString = getMathText.substring(0,getMathText.length() - 2);
                    activityMainBinding.mathTextView.setText(subString);
                    activityMainBinding.mathTextView.append(operator + " ");
                }

        }else{
            inputNumber = Double.parseDouble(activityMainBinding.resultTextView.getText().toString());
            resultNumber = calculator(resultNumber,inputNumber,operator);
            activityMainBinding.resultTextView.setText(String.valueOf(resultNumber));
            isFirstInput = true;
            operator = view.getTag().toString();
            activityMainBinding.mathTextView.append(inputNumber + " " + operator + " ");
        }

    }



    public void equalsClick(View view){
        if(isFirstInput){
            if(isOperatorClick){
                activityMainBinding.mathTextView.setText(resultNumber + " " + lastOperator + " " + inputNumber + " =");
                resultNumber = calculator(resultNumber, inputNumber, lastOperator);
                activityMainBinding.resultTextView.setText(String.valueOf(resultNumber));
            }



        }else{
            inputNumber = Double.parseDouble(activityMainBinding.resultTextView.getText().toString());
            resultNumber = calculator(resultNumber,inputNumber,operator);


            activityMainBinding.resultTextView.setText(String.valueOf(resultNumber));
            isFirstInput = true;
            operator = view.getTag().toString();
            activityMainBinding.mathTextView.append(inputNumber + " " + operator + " ");
        }

    }
    public void acClick(View view){
        activityMainBinding.resultTextView.setText("0");
        activityMainBinding.mathTextView.setText("");
        resultNumber = 0;
        operator = "=";
        isFirstInput = true;
    }
    public void pointClick(View view){
        if(isFirstInput){
            activityMainBinding.resultTextView.setText("0" + view.getTag().toString());
            isFirstInput = false;
        }else{
            if(activityMainBinding.resultTextView.getText().toString().contains(".")){
                Toast.makeText(this, "이미 소숫점이 존재합니다.", Toast.LENGTH_SHORT).show();
            }
            else{
                activityMainBinding.resultTextView.append(view.getTag().toString());
            }

        }
    }
    private double calculator(double resultNumber, double inputNumber, String operator) {
        switch(operator){
            case "=":
                resultNumber = inputNumber;
                break;
            case "+":
                resultNumber += inputNumber;
                break;
            case "-":
                resultNumber -= inputNumber;
                break;
            case "×":
                resultNumber *= inputNumber;
                break;
            case "÷":
                resultNumber /= inputNumber;
                break;

        }
        return resultNumber;

    }

}