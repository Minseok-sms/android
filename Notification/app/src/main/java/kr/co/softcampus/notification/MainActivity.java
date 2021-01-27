package kr.co.softcampus.notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void btn1Method(View view){
        NotificationCompat.Builder builder = getNotificationBuilder("channel","fist channel");
        builder.setTicker("Ticker message");
        builder.setSmallIcon(android.R.drawable.ic_menu_search);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        builder.setLargeIcon(bitmap);

        builder.setNumber(100);
        builder.setContentTitle("Content title");
        builder.setContentText("Content Text");

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(10,notification);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void btn2Method(View view){
        NotificationCompat.Builder builder = getNotificationBuilder("channel","fist channel");
        builder.setTicker("Ticker message");
        builder.setSmallIcon(android.R.drawable.ic_menu_search);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        builder.setLargeIcon(bitmap);

        builder.setNumber(100);
        builder.setContentTitle("Content title2");
        builder.setContentText("Content Text2");

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(20,notification);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void btn3Method(View view){
        NotificationCompat.Builder builder = getNotificationBuilder("channel2","second channel");
        builder.setTicker("Ticker message");
        builder.setSmallIcon(android.R.drawable.ic_menu_search);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        builder.setLargeIcon(bitmap);

        builder.setNumber(100);
        builder.setContentTitle("Content title3");
        builder.setContentText("Content Text3");

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(30,notification);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void btn4Method(View view){
        NotificationCompat.Builder builder = getNotificationBuilder("channel2","second channel");
        builder.setTicker("Ticker message");
        builder.setSmallIcon(android.R.drawable.ic_menu_search);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        builder.setLargeIcon(bitmap);

        builder.setNumber(100);
        builder.setContentTitle("Content title4");
        builder.setContentText("Content Text4");

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(40,notification);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public NotificationCompat.Builder getNotificationBuilder(String id, String name){
        NotificationCompat.Builder builder = null;



            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            manager.createNotificationChannel(channel);
            builder = new NotificationCompat.Builder(this, id);


        return builder;

    }

}