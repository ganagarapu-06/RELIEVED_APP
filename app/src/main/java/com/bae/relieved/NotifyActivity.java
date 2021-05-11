package com.bae.relieved;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.os.Build;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.widget.Toast;

import java.util.Calendar;

import static android.app.NotificationManager.IMPORTANCE_DEFAULT;

public class NotifyActivity extends AppCompatActivity {
    Button btNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        createNotificationChannel();

        btNotification = findViewById(R.id.bt_notification);
        btNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(NotifyActivity.this, "Remainder Set", Toast.LENGTH_SHORT).show();
                Calendar calender = Calendar.getInstance();
                calender.set(Calendar.HOUR_OF_DAY, 22);
                calender.set(Calendar.MINUTE, 30);
                calender.set(Calendar.SECOND, 30);
                calender.set(Calendar.HOUR_OF_DAY, 22);
                calender.set(Calendar.MINUTE,40);
                calender.set(Calendar.SECOND, 30);

                Intent intent = new Intent(NotifyActivity.this, Notification_reciever.class);
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);


                PendingIntent pendingIntent = PendingIntent.getBroadcast(NotifyActivity.this,0,intent,0);


                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
            }
        });

    }
    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "RelievedSentenceChannel";
            String description = "Channel for Relieved Sentence";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyRelieved", name, importance);
            channel.setDescription(description);


            NotificationManager notificationManager = getSystemService(NotificationManager.class);

            notificationManager.createNotificationChannel(channel);
        }
    }
}