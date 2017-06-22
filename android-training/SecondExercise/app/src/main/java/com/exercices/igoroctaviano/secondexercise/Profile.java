package com.exercices.igoroctaviano.secondexercise;

import com.google.gson.annotations.SerializedName;

public class Profile {

    private String name;
    @SerializedName("birth_year")
    private String birthday;
    private String gender;

    public Profile(String name, String birthday, String gender) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getGender() {
        return this.gender;
    }

    public String getName() {
        return this.name;
    }
}
