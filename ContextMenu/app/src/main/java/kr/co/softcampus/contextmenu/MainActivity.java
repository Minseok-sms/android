package kr.co.softcampus.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    ListView list1;
    String [] data1 = {"data1","data2","data3","data4","data5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);
        list1 = (ListView)findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data1);
        list1.setAdapter(adapter);
        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);


        //뷰에 컨텍스트 메뉴 설정 .
        registerForContextMenu(text1);
        registerForContextMenu(list1);
    }
    //컨텍스트 메뉴가 설정된 메뉴의 뷰를 세팅
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater inflater = getMenuInflater();

        super.onCreateContextMenu(menu, v, menuInfo);
        int id = v.getId();
        switch(id){
            case R.id.textView:
                menu.setHeaderTitle("텍스트 뷰의 컨텍스트 메뉴");
                inflater.inflate(R.menu.textview_menu,menu);
                break;
            case R.id.list1:
                //사용자가 길게 누른 항목의 인덱스를 가져온다 .
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;


                menu.setHeaderTitle("컨텍스트 메뉴: " + info.position);
                inflater.inflate(R.menu.listview_menu,menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //사용자가 선택한 메뉴 항목의 id 추출
        int id = item.getItemId();

        //사용자가 길게누른 리스트뷰의 항목인덱스를 가지고있는 객체를 추출 .
        int position = 0;
        ContextMenu.ContextMenuInfo info = item.getMenuInfo();
        if(info != null && info instanceof AdapterView.AdapterContextMenuInfo){
            AdapterView.AdapterContextMenuInfo info2 = (AdapterView.AdapterContextMenuInfo)info;
            position = info2.position;
        }
        switch(id){
            case R.id.text_item1:
                text1.setText("text1");
                break;
            case R.id.text_item2:
                text1.setText("text2");
                break;
            case R.id.list_item1:
                text1.setText("list1: " + position);

                break;
            case R.id.list_item2:
                text1.setText("list2: " + position);
                break;

        }
        return super.onContextItemSelected(item);
    }
    // 리스트 뷰의 리스너

    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text1.setText("item click : " + data1[position]);
        }
    }
}