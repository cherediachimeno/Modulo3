package com.example.transiciones_10_03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.ActivityOptions;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button boton1;
    Button boton2;

    // declaración de las notificaciones
    NotificationManagerCompat notificationManagerCompat;
    Notification notification;
    Notification notification2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = (Button) findViewById(R.id.button);
        boton2 = (Button) findViewById(R.id.button2);

        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);

        // aquí las tres partes de nuestra notificación (channel, manager y builder)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("myCh", "My Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        Intent resultIntent = new Intent(this,MainActivity2.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this,1,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        // constructor que unific todo y la personaliza
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"myCh")
                .setSmallIcon(android.R.drawable.stat_notify_sync)
                .setContentTitle("Mi primera notificación")
                .setContentText("este es el cuerpo(body)del mensaje")
                .setAutoCancel(true)
                .setContentIntent(resultPendingIntent);

        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this,"myCh")
                .setSmallIcon(android.R.drawable.stat_notify_error)
                .setContentTitle("Mi segunda notificación")
                .setContentText("mensaje");


        notification = builder.build();
        notification2 = builder2.build();
        notificationManagerCompat=NotificationManagerCompat.from(this);

    }

    public void go(View view){
        Intent i = new Intent(this, MainActivity2.class);
        Bundle a = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        startActivity(i,a);
    }

    public void push(View view){


       notificationManagerCompat.notify(1,notification);
       notificationManagerCompat.notify(2,notification2);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button: go(view);
            break;
            case R.id.button2: push(view);
            break;
        }

    }


}