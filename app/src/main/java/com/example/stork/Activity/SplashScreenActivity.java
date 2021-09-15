package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

import com.example.stork.R;


public class SplashScreenActivity extends AppCompatActivity {
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        BackendTest test = new BackendTest();
        test.run();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                switch (checkAppStart()) {
                    case NORMAL:
                        // We don't want to get on the user's nerves
                        System.out.println("normal.");
                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        finish();
                        break;
                    case FIRST_TIME_VERSION:
                        // TODO show what's new
                        System.out.println("this is the first time version.");
                        break;
                    case FIRST_TIME:
                        // TODO show a tutorial
                        System.out.println("this is the first time.");
                        Intent intent = new Intent(SplashScreenActivity.this , IntroActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        break;
                }

            }
        },4000);

    }

    public enum AppStart {
        FIRST_TIME, FIRST_TIME_VERSION, NORMAL;
    }

    /**
     * The app version code (not the version name!) that was used on the last
     * start of the app.
     */
    private static final String LAST_APP_VERSION = "last_app_version";

    /**
     * Finds out started for the first time (ever or in the current version).<br/>
     * <br/>
     * Note: This method is <b>not idempotent</b> only the first call will
     * determine the proper result. Any subsequent calls will only return
     * {@link FirstTime.AppStart#NORMAL} until the app is started again. So you might want
     * to consider caching the result!
     *
     * @return the type of app start
     */
    public FirstTime.AppStart checkAppStart() {
        PackageInfo pInfo;
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        FirstTime.AppStart appStart = FirstTime.AppStart.NORMAL;
        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            int lastVersionCode = sharedPreferences
                    .getInt(LAST_APP_VERSION, -1);
            int currentVersionCode = pInfo.versionCode;
            appStart = checkAppStart(currentVersionCode, lastVersionCode);
            // Update version in preferences
            sharedPreferences.edit()
                    .putInt(LAST_APP_VERSION, currentVersionCode).commit();
        } catch (PackageManager.NameNotFoundException e) {
            System.out.println("Unable to determine current app version from pacakge manager. Defenisvely assuming normal app start.");
        }
        return appStart;
    }

    public FirstTime.AppStart checkAppStart(int currentVersionCode, int lastVersionCode) {
        if (lastVersionCode == -1) {
            return FirstTime.AppStart.FIRST_TIME;
        } else if (lastVersionCode < currentVersionCode) {
            return FirstTime.AppStart.FIRST_TIME_VERSION;
        } else if (lastVersionCode > currentVersionCode) {
            System.out.println("Current version code (" + currentVersionCode
                    + ") is less then the one recognized on last startup ("
                    + lastVersionCode
                    + "). Defenisvely assuming normal app start.");
            return FirstTime.AppStart.NORMAL;
        } else {
            return FirstTime.AppStart.NORMAL;
        }
    }



}