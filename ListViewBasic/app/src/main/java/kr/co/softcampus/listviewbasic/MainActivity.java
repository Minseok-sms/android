package kr.co.softcampus.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView list1;
    TextView text1;
    String [] data1 = {"list1","list2","list3","list4","list5","list6","list7","list8"
    ,"list9","list10","list11","list12","list13","list14","list15","list16","list17","list18"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1 = (ListView)findViewById(R.id.list1);
        text1 = (TextView)findViewById(R.id.textView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data1);
        list1.setAdapter(adapter);


        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);
    }
    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        //position => 사용자가 터치한 인덱스번호

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text1.setText(data1[position]);
        }
    }
}