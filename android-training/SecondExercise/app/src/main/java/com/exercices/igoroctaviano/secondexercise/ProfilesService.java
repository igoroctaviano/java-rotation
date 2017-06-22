package com.exercices.igoroctaviano.secondexercise;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProfilesService {
    @GET("people/")
    Call<JsonResult> listProfiles();
}
