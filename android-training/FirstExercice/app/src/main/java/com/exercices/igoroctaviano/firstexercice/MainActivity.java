package com.exercices.igoroctaviano.firstexercice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button firstButton = (Button) findViewById(R.id.button);
        final Button secondButton = (Button) findViewById(R.id.button2);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ShowTextActivity.class);

                Bundle extras = new Bundle();
                extras.putString("firstButtonText", firstButton.getText().toString());
                myIntent.putExtras(extras);

                // This command above uses bundle internally (it does the same thing)
                // myIntent.putExtra("firstButtonText", firstButton.getText().toString());

                startActivity(myIntent);
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ShowTextActivity.class);

                Bundle extras = new Bundle();
                extras.putString("secondButtonText", secondButton.getText().toString());
                myIntent.putExtras(extras);

                // This command above uses bundle internally (it does the same thing)
                // myIntents.putExtra("secondButtonText", secondButton.getText().toString());

                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("MainActivity", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("MainActivity", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("MainActivity", "onDestroy");
    }
}
