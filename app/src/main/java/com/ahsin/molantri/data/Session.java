package com.ahsin.molantri.data;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.ahsin.molantri.activity.LoginActivity;
import com.ahsin.molantri.activity.MainActivity;
import com.google.gson.Gson;

/**
 * Created by Comp on 7/29/2017.
 */

public class Session {
    SharedPreferences pref;

    SharedPreferences.Editor editor;

    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "molantri";

    private static final String IS_LOGIN = "IsLoged";
    private static final String IS_FIRST = "IsFisrt";
    private static final String IS_NOT_ALARMT = "IsAlarm";

    public static final String KEY_USER = "user";
    public static final String KEY_ALARM = "alarm";
    public static final String KEY_IP = "IP";


    public Session(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String user) {
        Gson gson = new Gson();
        String json = gson.toJson(user);

        editor.putString(KEY_USER, json);

        editor.putBoolean(IS_LOGIN, true);

        editor.commit();

    }


    public String getUser() {
        Gson gson = new Gson();
        String json = pref.getString(KEY_USER, "");
        String obj = gson.fromJson(json, String.class);
        return obj;
    }

    public void checkLogin() {
        if (isLoggedIn()) {
            Intent i = new Intent(_context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }
    }

    public void clearAlarm() {
        pref.edit().remove(KEY_ALARM).commit();
    }

    public void logoutUser() {
        editor.clear();
        editor.commit();
        editor.putBoolean(IS_LOGIN, false);
        editor.putBoolean(IS_FIRST, true);
        editor.putBoolean(IS_NOT_ALARMT, true);

        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ((Activity) _context).finish();
        _context.startActivity(i);
    }


    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }


    public void setIsLogin(Boolean v) {
        editor.putBoolean(IS_LOGIN, v);
        editor.commit();
    }

    public boolean isFirst() {
        return pref.getBoolean(IS_FIRST, false);
    }

    public boolean isAlarm() {
        return pref.getBoolean(IS_NOT_ALARMT, false);
    }

    public String getIp() {
        return pref.getString(KEY_IP, "192.168.1.1");
    }

    public void setIsFisrt(Boolean v) {
        editor.putBoolean(IS_FIRST, v);
        editor.commit();
    }

    public void setAlarm(Boolean v) {
        editor.putBoolean(IS_NOT_ALARMT, v);
        editor.commit();
    }

    public void setIp(String ip) {
        editor.putString(KEY_IP, ip);
        editor.commit();
    }
}
