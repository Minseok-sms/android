package kr.co.softcampus.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView list1;
    TextView text1;

    String [] data = {"data1","data2","data3","data4","data5","data6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1 = (ListView)findViewById(R.id.list1);
        text1 = (TextView)findViewById(R.id.textView2);

        ListAdapater adapter = new ListAdapater();
        list1.setAdapter(adapter);







    }
    class ListAdapater extends BaseAdapter{
        btnListener listener = new btnListener();

        //배열의 갯수
        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.row , null);
            }
            TextView sub_text = (TextView)convertView.findViewById(R.id.textView);
            Button sub_btn1 = (Button)convertView.findViewById(R.id.button);
            Button sub_btn2 = (Button)convertView.findViewById(R.id.button2);
            sub_btn1.setOnClickListener(listener);
            sub_btn2.setOnClickListener(listener);

            sub_text.setText(data[position]);
            return convertView;
        }
    }
    //
    class btnListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch(id){
                case R.id.button :
                    text1.setText("first button clicked");
                    break;
                case R.id.button2 :
                    text1.setText("second button clicked");
                    break;
            }
        }
    }
}