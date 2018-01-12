package com.example.madamkinza.mynotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btnNotify);
        msg = (EditText) findViewById(R.id.etMessage);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = msg.getText().toString();
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

                NotificationManager mNotificationManager =

                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra("asd", 1);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(MainActivity.this).
                                setSmallIcon(R.drawable.icon).
                                setContentIntent(pendingIntent).
                                setContentTitle("My notification").
                                setContentText(message);

                Notification notification = mBuilder.build();
                mNotificationManager.notify(0, notification);


            }
        });

    }
}
