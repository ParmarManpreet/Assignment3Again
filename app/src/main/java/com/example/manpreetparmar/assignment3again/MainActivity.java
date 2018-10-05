package com.example.manpreetparmar.assignment3again;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    protected Button button =null;
    protected SharedPreferenceHelper sharedPreferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferenceHelper = new SharedPreferenceHelper(MainActivity.this);
        button= (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                goToProfileActivity();
            }
        });

    }

    protected void onStart() {
        super.onStart();

        //check if button has string name
        String name = sharedPreferenceHelper.getProfileName();

        if(name == null)
            goToProfileActivity();
        else
            button.setText(name);

    }
    void goToProfileActivity()
    {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }



}

