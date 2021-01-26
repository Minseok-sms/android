package kr.co.softcampus.popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);

    }
    public void btnMethod(View view){
        PopupMenu pop = new PopupMenu(this, text1);
        Menu menu = pop.getMenu();
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.popup_menu,menu);
        PopupListener listener = new PopupListener();
        pop.setOnMenuItemClickListener(listener);
        pop.show();
    }
    class PopupListener implements PopupMenu.OnMenuItemClickListener{
        @Override
        public boolean onMenuItemClick(MenuItem item) {
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
            }

            return false;
        }
    }
}