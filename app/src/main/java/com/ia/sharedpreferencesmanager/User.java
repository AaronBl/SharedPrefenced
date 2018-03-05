package com.ia.sharedpreferencesmanager;

/**
 * Created by abautista on 3/5/2018.
 */

public class User {
    String Name;
    String lastName;
    String email;
    int age;

    public User(String name, String lastName, String email, int age) {
        Name = name;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
