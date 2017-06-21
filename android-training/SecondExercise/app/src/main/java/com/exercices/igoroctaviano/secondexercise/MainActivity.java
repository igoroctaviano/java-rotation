package com.exercices.igoroctaviano.secondexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView reclyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.reclyclerView = (RecyclerView) findViewById(R.id.list_profiles);
        this.reclyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Igor Octaviano", "June 94", "Male"));
        profiles.add(new Profile("Igor Octaviano", "June 94", "Male"));
        profiles.add(new Profile("Igor Octaviano", "June 94", "Male"));
        profiles.add(new Profile("Igor Octaviano", "June 94", "Male"));
        profiles.add(new Profile("Igor Octaviano", "June 94", "Male"));
        profiles.add(new Profile("Igor Octaviano", "June 94", "Male"));
        profiles.add(new Profile("Igor Octaviano", "June 94", "Male"));
        profiles.add(new Profile("Igor Octaviano", "June 94", "Male"));

        this.reclyclerView.setAdapter(new ProfileAdapter(profiles, this));
    }
}
