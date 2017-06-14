package com.exercices.igoroctaviano.firstexercice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_text);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView textView = (TextView) findViewById(R.id.textView);
        Bundle data = getIntent().getExtras();
        String firstButtonText = data.getString("firstButtonText");
        String secondButtonText = data.getString("secondButtonText");
        textView.setText(firstButtonText != null ? firstButtonText : secondButtonText);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("ShowTextActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("ShowTextActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("ShowTextActivity", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("ShowTextActivity", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("ShowTextActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("ShowTextActivity", "onDestroy");
    }
}
