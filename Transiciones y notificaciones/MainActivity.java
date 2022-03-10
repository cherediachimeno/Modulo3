package es.ua.eps.transiciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.ActivityOptions;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button boton1;
    Button boton2;
    //Here the declarations of the Notification's utilities.
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

                   //Here the three parts of our notification(channel, manager and builder)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){  //This is a letter not zero
            NotificationChannel channel = new NotificationChannel("myCh", "My Channel", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "myCh")
                    .setSmallIcon(android.R.drawable.stat_notify_sync)
                    .setContentTitle("Mi primera notificación")
                    .setContentText("Cuerpo del mensaje");

            NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this, "myCh")
                    .setSmallIcon(android.R.drawable.stat_notify_error)
                    .setContentTitle("Mi segunda notificación")
                    .setContentText("Mensaje");

            notification = builder.build();
            notification2 = builder2.build();
            notificationManagerCompat = NotificationManagerCompat.from(this);
        }
    }

    public void push(View view){
        notificationManagerCompat.notify(1, notification);
        notificationManagerCompat.notify(2, notification2);
    }
    // Here I'm creating a method called go with our intent and our transition
    public void go(View view){
        Intent i = new Intent(this, MainActivity2.class);
        Bundle a = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        startActivity(i, a);
    }

    // Here the onclick method...

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