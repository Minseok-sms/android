package kr.co.softcampus.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView list1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = (ListView)findViewById(R.id.list1);
        ArrayList<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        list1.setAdapter(adapter);
        data.add("hello");
        data.add("from");
        data.add("the");
        data.add("other side");
        adapter.notifyDataSetChanged();


    }
}