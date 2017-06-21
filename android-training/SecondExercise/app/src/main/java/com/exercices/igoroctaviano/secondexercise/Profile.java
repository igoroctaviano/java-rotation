package com.exercices.igoroctaviano.secondexercise;

public class Profile {
    private String name;
    private String birthday;
    private String gender;

    public Profile(String name, String birthday, String gender) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Profile() {

    }

    public String getBirthday() { return birthday; }

    public void setBirthday(String birth) { this.birthday = birth; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
