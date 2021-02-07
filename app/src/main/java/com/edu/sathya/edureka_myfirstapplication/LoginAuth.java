package com.edu.sathya.edureka_myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import static com.edu.sathya.edureka_myfirstapplication.Util.Constants.KEY_MESSAGE;
import static com.edu.sathya.edureka_myfirstapplication.Util.Constants.KEY_PASSWORD;
import static com.edu.sathya.edureka_myfirstapplication.Util.Constants.KEY_USERNAME;

public class LoginAuth extends AppCompatActivity {


//
//    private static final String KEY_USERNAME = "user";
//    private static final String KEY_PASSWORD = "pw";
//    private static final String KEY_MESSAGE =  "mesage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_auth);

        // retrive the bundle from the intent..
        // we need the keys to get the data from bundle

        Bundle bundle = getIntent().getExtras();

        String userName = bundle.getString(KEY_USERNAME);
        String passWord = bundle.getString(KEY_PASSWORD);

        Log.d("tag","User "+userName);
        Log.d("tag","PW : "+passWord);


        // Lets validate the PW

        Intent intent = new Intent();

        if( passWord.equalsIgnoreCase("bangalore")){
            intent.putExtra(KEY_MESSAGE,"Success...");
        }else{
            intent.putExtra(KEY_MESSAGE,"Failure...");
        }

        setResult(201,intent);
        finish();  // destroy itself..  backstack comes into the play.

    }
}