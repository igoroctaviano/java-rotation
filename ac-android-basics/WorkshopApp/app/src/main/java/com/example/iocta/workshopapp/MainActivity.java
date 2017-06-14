package com.example.iocta.workshopapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<People> peopleList;
    private PeopleAdapter peopleAdapter;

   /*  private Button button;
    private TextView textView;

    private Button calcButton;
    private Button plusButton;
    private Button minusButton;

    private TextView resultTextView;
    private EditText firstEditText;
    private EditText secondEditText;

    public String currentOperation; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peopleList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.people_list);

        People people = new People();
        people.setName("Pato Donald");
        peopleList.add(people);

        People people2 = new People();
        people2.setName("Pato Donald Jr");
        peopleList.add(people2);

        loadAdapter();
        new GetPeopleList().execute("http://swapi.co/api/people/");
    }

    private void loadAdapter() {
        peopleAdapter = new PeopleAdapter(peopleList);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        recyclerView.setAdapter(peopleAdapter);
    }

    class GetPeopleList extends AsyncTask<String, Void, FetchPeople> {

        @Override
        protected FetchPeople doInBackground(String... urls) {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();

                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();
                String json = sb.toString();

                return new Gson().fromJson(json, FetchPeople.class);
            } catch (Exception e) {
                Log.e("GetPeopleList", e.getMessage(), e);
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(FetchPeople fetchPeople) {
            if (fetchPeople != null) {
                MainActivity.this.peopleList.addAll(fetchPeople.getResults());
                peopleAdapter.notifyDataSetChanged();
            }
        }
    }

    ;
    /* resultTextView = (TextView) findViewById(R.id.resultTextView);
        firstEditText = (EditText) findViewById(R.id.firstEditText);
        secondEditText = (EditText) findViewById(R.id.secondEditText);

        minusButton = (Button) findViewById(R.id.minusButton);
        plusButton = (Button) findViewById(R.id.plusButton);
        calcButton = (Button) findViewById(R.id.calcButton);

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentOperation = "-";
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentOperation = "+";
            }
        });

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstValue = Integer.parseInt(firstEditText.getText().toString());
                int secondValue = Integer.parseInt(secondEditText.getText().toString());
                if (currentOperation.equals("+"))
                    resultTextView.setText(String.valueOf(firstValue + secondValue));
                else
                    resultTextView.setText(String.valueOf(firstValue - secondValue));
            }
        }); */
}