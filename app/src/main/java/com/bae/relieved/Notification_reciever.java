package com.bae.relieved;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class Notification_reciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent repeating_intent = new Intent(context,Repeating_activity.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifyRelieved")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Relieved")
                .setContentText("Sentence of the day")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificationManager.notify(200,builder.build());
    }
}
