package kr.co.softcampus.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        MenuItem search_item = menu.findItem(R.id.item5);


        SearchView search_view = (SearchView)search_item.getActionView();
        search_view.setQueryHint("검색어를 입력해주세요.");

        SearchViewListener listener = new SearchViewListener();
        search_view.setOnQueryTextListener(listener);

        return true;
    }
    class SearchViewListener implements SearchView.OnQueryTextListener{
        @Override
        //서치뷰의 문자열이 변경될때마다 호출되는 메서드
        public boolean onQueryTextChange(String newText) {
            text1.setText(newText);
            return false;
        }
        //키보드의 엔터키를 누루면 호출되는 메서드
        @Override
        public boolean onQueryTextSubmit(String query) {
            text2.setText(query);
            return false;
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.item1:
                text1.setText("menu1");
                break;
            case R.id.item2:
                text1.setText("menu2");
                break;
            case R.id.item3:
                text1.setText("menu3");
                break;
            case R.id.item4:
                text1.setText("menu4");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}