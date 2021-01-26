package kr.co.softcampus.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);

    }
    //Activity가 화면에 나타날떄 메뉴 구성을 위해서 호출되는 메서드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //XML를 통햬 메뉴를 구성할수 있는 객체를 추출
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        //true 값을 해줘야 메뉴가 나타남.


//        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "코드메뉴1" );
//        //menu.add(Menu.NONE, Menu.FIRST + 1, Menu.NONE, "코드메뉴2" );
//        Menu sub = menu.addSubMenu("코드메뉴2");
//        sub.add(Menu.NONE ,Menu.FIRST+10, Menu.NONE, "코드 서브메뉴1");
//        sub.add(Menu.NONE ,Menu.FIRST+20, Menu.NONE, "코드 서브메뉴2");
//        menu.add(Menu.NONE, Menu.FIRST + 2, Menu.NONE, "코드메뉴3" );



        return true;
    }
    //옵션메뉴의 항목을 터치하면 호출되는 메서드
    //터치한 항목의 객체가 매게변수 로 들어옴
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //사용자가 터치한 항목 객체의 id를 추출
        int id = item.getItemId();
        switch(id){
            case R.id.item1:
                text1.setText("메뉴 1을 터치 하였습니다.");
                break;
            case R.id.item2_1:
                text1.setText("서브메뉴 1을 터치하였습니다.");
                break;
            case R.id.item2_2:
                text1.setText("서브메뉴 2를 터치하였습니다.");
                break;
            case R.id.item3:
                text1.setText("메뉴3 을 터치 하였습니다.");

        }
//            switch(id){
//                case Menu.FIRST:
//                    text1.setText("코드메뉴 1을 터치하였습니다.");
//                    break;
//                case Menu.FIRST + 10:
//                    text1.setText("코드서브메뉴 1을 터치하였습니다.");
//                    break;
//                case Menu.FIRST + 20:
//                    text1.setText("코드서브메뉴 2를 터치하였습니다.");
//                    break;
//                case Menu.FIRST + 2:
//                    text1.setText("코드메뉴 2를 터치하였습니다.");
//                    break;
//            }


        return super.onOptionsItemSelected(item);
    }
}