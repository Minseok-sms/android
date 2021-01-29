package kr.co.softcampus.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_move;
    EditText edit1;
    String str;
    ImageView img1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);



        btn_move = (Button)findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = edit1.getText().toString();
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                intent.putExtra("str",str);

                startActivity(intent); // 액티비티 이동

            }
        });

        img1 = (ImageView)findViewById(R.id.imageView);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "hallowed",Toast.LENGTH_LONG).show();
            }
        });


    }
}