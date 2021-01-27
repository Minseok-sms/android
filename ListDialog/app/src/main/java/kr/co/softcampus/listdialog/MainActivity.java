package kr.co.softcampus.listdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String [] data1 = {"list1","list2","list3","list4","list5","list6","list7","list8"};
    String [] data2 = {"토고","프랑스","스위스","스페인","일본","독일","브라질","대한민국"};
    int [] data3 = {R.drawable.imgflag1,R.drawable.imgflag2,R.drawable.imgflag3,R.drawable.imgflag4,
    R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8};
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);


    }
    public void btn1Method(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("list dialog");
        builder.setNegativeButton("exit",null);
        Dialog1Listener listener = new Dialog1Listener();

        builder.setItems(data1,listener);
        builder.show();
    }

    class Dialog1Listener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            text1.setText("list : " + data1[which]);
        }
    }
    public void btn2Method(View view){
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        for(int i = 0; i < data2.length;i++){
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("data2",data2[i]);
            map.put("data3",data3[i]);
            list.add(map);
        }

        String [] keys = {"data2","data3"};
        int [] ids = {R.id.textView2, R.id.imageView};
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.row, keys, ids);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("custom list dialog");
        Dialog2Listener listener = new Dialog2Listener();
        builder.setAdapter(adapter, listener);
        builder.setNegativeButton("cancel",null);
        builder.show();

    }
    class Dialog2Listener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            text1.setText("custom list : " + data2[which]);
        }
    }
}