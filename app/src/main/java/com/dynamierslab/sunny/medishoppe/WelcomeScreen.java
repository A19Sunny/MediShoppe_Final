package com.dynamierslab.sunny.medishoppe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);


        // Checking for first time launch - before calling setContentView()
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }

        final ImageView imageView = (ImageView) findViewById(R.id.vector_ws);
        final Animation animrotate = AnimationUtils.loadAnimation(getBaseContext(), R.anim.clockwise);

        imageView.startAnimation(animrotate);

        TextView btn_reg = (TextView) findViewById(R.id.btn_reg_ws);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_reg = new Intent(WelcomeScreen.this,RegisterActivity.class);
                startActivity(intent_reg);
            }
        });

        TextView btn_lgn = (TextView) findViewById(R.id.btn_lgn_ws);
        btn_lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_lgn = new Intent(WelcomeScreen.this,LoginActivity.class);
                startActivity(intent_lgn);
            }
        });

        TextView btn_skip = (TextView) findViewById(R.id.btn_skip_ws);
        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeScreen();
            }
        });
    }

    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(WelcomeScreen.this, MainActivity.class));
        finish();
    }

}
