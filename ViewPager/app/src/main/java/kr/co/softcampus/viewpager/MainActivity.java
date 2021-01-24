package kr.co.softcampus.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager pager1;
    TextView text1;
    ArrayList<View> viewList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager1 = (ViewPager)findViewById(R.id.pager);
        text1 = (TextView)findViewById(R.id.textView);

        //xml파일의 내용을 view 값으로 변환해줌

        LayoutInflater inflater = getLayoutInflater();
        View v1 = inflater.inflate(R.layout.view1,null);
        View v2 = inflater.inflate(R.layout.view2,null);
        View v3 = inflater.inflate(R.layout.view3,null);

        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);


        CustomAdapter adapter = new CustomAdapter();
        pager1.setAdapter(adapter);

        PagerListener listener = new PagerListener();
        pager1.setOnPageChangeListener(listener);

    }
    class CustomAdapter extends PagerAdapter{
        @Override
        //뷰페이저의 항목리스트 갯수
        public int getCount() {
            return viewList.size();
        }

        //뷰페이저를 통해보여줄 뷰 객체를 반환 .
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            //position 번쨰 뷰객체 를 뷰페이저에 세팅한다.
            pager1.addView(viewList.get(position));
            return viewList.get(position);
        }
        //instantiateItem메서드에서 반환한 뷰객체를 사용할것인가?
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
        //뷰가 제거될떄 호출되는 메서드

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            pager1.removeView((View)object);
        }
    }
    class PagerListener implements ViewPager.OnPageChangeListener{
        //뷰의 전환이 완료 되었을떄 호출되는 메서드
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            text1.setText(position + "번쨰 뷰가 나타났습니다.");
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

        @Override
        public void onPageSelected(int position) {

        }
    }
}