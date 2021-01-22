package kr.co.softcampus.twolinelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    //리스트뷰의 한ㅇ목을 구성하기 위한 문자열배열
    String [] data1 = {"s1","s2","s3","s4","s5","s6"};
    String [] data2 = {"c1","c2","c3","c4","c5","c6"};

    ListView list1;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = (ListView)findViewById(R.id.list1);
        text1 = (TextView)findViewById(R.id.textView);
        ArrayList<HashMap<String, String>> data_list = new ArrayList<>();
        for(int i = 0 ; i < data1.length ; i++){
            HashMap<String,String> map = new HashMap<>();
            map.put("str1",data1[i]);
            map.put("str2",data2[i]);

            data_list.add(map);
        }
        String [] keys = {"str1","str2"};
        int [] ids = {android.R.id.text1, android.R.id.text2};
        SimpleAdapter adapter = new SimpleAdapter(this, data_list, android.R.layout.simple_list_item_2,keys, ids);
        list1.setAdapter(adapter);

        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);
    }
    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text1.setText(data1[position]);
        }
    }
}