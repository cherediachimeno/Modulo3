package es.ua.eps.transiciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        boton1 = (Button) findViewById(R.id.button);

        boton1.setOnClickListener(this);
    }

    public void go(View view){
        Intent i = new Intent(this, MainActivity.class);
        Bundle a = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        startActivity(i, a);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button: go(view);
        }
    }
}