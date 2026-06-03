// File: app/src/main/java/com/fxcopytrade/app/SplashActivity.java

package com.fxcopytrade.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

/**
 * SplashActivity - Launch screen shown when app starts
 * Displays app logo/name for 2 seconds then transitions to MainActivity
 * Checks for internet connection before proceeding
 */
public class SplashActivity extends AppCompatActivity {

    // Splash screen duration in milliseconds
    private static final int SPLASH_DURATION = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        // Hide action bar if exists
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Check internet connection and proceed
        checkConnectionAndProceed();
    }

    /**
     * Check internet connection and proceed to main activity
     */
    private void checkConnectionAndProceed() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isNetworkAvailable()) {
                    // Internet is available, proceed to MainActivity
                    navigateToMainActivity();
                } else {
                    // No internet, show dialog
                    showNoInternetDialog();
                }
            }
        }, SPLASH_DURATION);
    }

    /**
     * Navigate to MainActivity
     */
    private void navigateToMainActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        
        // Add smooth transition animation
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        
        // Finish splash activity so user can't go back to it
        finish();
    }

    /**
     * Check if network connection is available
     */
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        
        return false;
    }

    /**
     * Show dialog when no internet connection is detected
     */
    private void showNoInternetDialog() {
        new AlertDialog.Builder(this)
                .setTitle("No Internet Connection")
                .setMessage("This app requires an internet connection to work. Please check your connection and try again.")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Retry connection check
                        checkConnectionAndProceed();
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Exit the app
                        finish();
                    }
                })
                .setCancelable(false)
                .show();
    }

    @Override
    public void onBackPressed() {
        // Disable back button on splash screen
        // Do nothing
    }
}
