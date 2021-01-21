package kr.co.softcampus.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seek1,seek2;
    TextView text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seek1 = (SeekBar)findViewById(R.id.seekBar);
        seek2 = (SeekBar)findViewById(R.id.seekBar2);

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);

        SeekBarListener seekbar = new SeekBarListener();
        seek1.setOnSeekBarChangeListener(seekbar);
        seek2.setOnSeekBarChangeListener(seekbar);

    }

    public void btn1Method(View view){
        seek1.incrementProgressBy(1);
        seek2.incrementProgressBy(1);
    }
    public void btn2Method(View view){
        seek1.incrementProgressBy(-1);
        seek2.incrementProgressBy(-1);
    }
    public void btn3Method(View view){
        seek1.setProgress(9);
        seek2.setProgress(3);
    }
    public void btn4Method(View view){
        int value1 = seek1.getProgress();
        int value2 = seek2.getProgress();

        text1.setText("seek1 : " + value1);
        text2.setText("seek2 : " + value2);

    }
    class SeekBarListener implements SeekBar.OnSeekBarChangeListener{
        @Override
        //현재 값을 변경시켰을대 반응 하는 메서드
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int id = seekBar.getId();
            switch(id){
                case R.id.seekBar :
                    text1.setText("fist seekbar : " + progress);
                    break;
                case R.id.seekBar2:
                    text1.setText("second seekbar : "+ progress);
                    break;
            }
            if(fromUser == true)
                text2.setText("from user");
            else
                text2.setText("from code");
        }

        @Override
        // 값을 변경하기위해 터치  하면 호출되는 메서드
        public void onStartTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            switch(id){
                case R.id.seekBar :
                    text2.setText("first seek bar touch");
                    break;
                case R.id.seekBar2 :
                    text2.setText("second seek bar touch");
                    break;
            }


        }

        @Override
        // 값을 변경하고 터치를 떄면호출되는 메서드
        public void onStopTrackingTouch(SeekBar seekBar) {
           int id = seekBar.getId();
           switch(id){
               case R.id.seekBar :
                   text2.setText("first seek bar detach");
                   break;
               case R.id.seekBar2 :
                   text2.setText("second seek bar deatch");
                   break;
           }
        }
    }
}