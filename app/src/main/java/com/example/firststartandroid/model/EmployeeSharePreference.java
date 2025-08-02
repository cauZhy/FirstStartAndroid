package com.example.firststartandroid.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class EmployeeSharePreference {

    private static final String PREF_NAME = "employee_pref";
    private static final String KEY_EMPLOYEE = "key_employee";

    private SharedPreferences sharedPreferences;
    private Gson gson;

    public EmployeeSharePreference(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void save(Employee employee) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String json = gson.toJson(employee);
        editor.putString(KEY_EMPLOYEE, json);
        editor.apply();
    }

    public Employee get() {
        String json = sharedPreferences.getString(KEY_EMPLOYEE, null);
        if (json == null) return null;
        return gson.fromJson(json, Employee.class);
    }

    public void remove() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_EMPLOYEE);
        editor.apply();
    }
}

