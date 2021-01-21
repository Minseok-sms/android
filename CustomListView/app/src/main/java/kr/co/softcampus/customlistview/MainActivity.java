package kr.co.softcampus.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView list1;

    String [] data = {"data1","data2","data3","data4","data5","data6"};
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1 = (ListView)findViewById(R.id.list1);
        text2 = (TextView)findViewById(R.id.textView2);

        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);

        //어뎁터 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.row, R.id.textView, data);
        list1.setAdapter(adapter);
    }
    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text2.setText(data[position]);
        }
    }
}