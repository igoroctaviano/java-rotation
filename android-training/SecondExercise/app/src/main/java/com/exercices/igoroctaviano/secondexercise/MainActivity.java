package com.exercices.igoroctaviano.secondexercise;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView reclyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.reclyclerView = (RecyclerView) findViewById(R.id.list_profiles);
        this.reclyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.reclyclerView.setAdapter(new ProfileAdapter(new ArrayList<Profile>(), MainActivity.this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProfilesService service = retrofit.create(ProfilesService.class);
        Call<JsonResult> userCall = service.listProfiles();

        userCall.enqueue(new Callback<JsonResult>() {
            @Override
            public void onResponse(@NonNull Call<JsonResult> call, @NonNull Response<JsonResult> response) {
                JsonResult results = response.body();

                if (results != null) {
                    MainActivity.this.reclyclerView.setAdapter(
                        new ProfileAdapter(results.getResults(), MainActivity.this)
                    );
                }
            }

            @Override
            public void onFailure(@NonNull Call<JsonResult> call, @NonNull Throwable t) {
                Log.v("Retrofit error", t.getMessage());
            }
        });
    }
}
