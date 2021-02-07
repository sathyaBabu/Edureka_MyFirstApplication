package com.edu.sathya.edureka_myfirstapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.edu.sathya.edureka_myfirstapplication.Util.Constants.KEY_MESSAGE;
import static com.edu.sathya.edureka_myfirstapplication.Util.Constants.KEY_USERNAME;

import static com.edu.sathya.edureka_myfirstapplication.Util.Constants.KEY_PASSWORD;



public class MainActivity extends AppCompatActivity {


    // BAd practice
//    private static final String KEY_USERNAME = "user";
//    private static final String KEY_PASSWORD = "pw";
//    private static final String KEY_MESSAGE =  "mesage";

// https://material.io/resources/color/#!/?view.left=0&view.right=0&primary.color=D84315
   // Activity life cycle
    // https://developer.android.com/guide/components/activities/activity-lifecycle


    // Constructor...
    // We do the house keeping Job here..


    // UI For Login
    // Validate the PW..
    // Lets craete an activity called as LOginAuth
    // 1. Lets craete an Activity NOW
    // 1.a   By clicking on the Login Button lets display LoginAuth Acctivity.
    // 1.b   Lets pass the data to LoginAuth Activity..
    // 2. Validate PW
    // 3. pass the result to the mainActivity

    TextView textView ;
    EditText userName ,passWord ;
    Button   login ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // UI

        textView = (TextView) findViewById(R.id.textView) ;

        userName = (EditText) findViewById(R.id.editTextPersonName) ;
        passWord = (EditText) findViewById(R.id.editTextPassWord) ;

        login    = (Button) findViewById(R.id.buttonLogin) ;


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("tag","User "+userName.getText().toString());
                Log.d("tag","PW : "+passWord.getText().toString());


                // 1.a   By clicking on the Login Button lets display LoginAuth Acctivity.

                // 1.b   Lets pass the data to LoginAuth Activity..

                Bundle bundle = new Bundle();  // Key value pair

                bundle.putString(KEY_USERNAME,userName.getText().toString());
                bundle.putString(KEY_PASSWORD,passWord.getText().toString());


                Intent intent = new Intent(MainActivity.this,LoginAuth.class);
                // 1.c Lets inject the bundle into the intent.
                intent.putExtras(bundle);

                // Phase I
                //startActivity(intent);

                // Phase II
                startActivityForResult(intent,201);

            }
        });

        Log.d("tag","on Create ");
//        Log.e("tag"," Log.d Error ");
//        Log.i("tag"," Log.d Info ");
//        Log.w("tag"," Log.d Warning ");

    }

    // we shall receive e the results here from LoginAuth - setResult calls the folowing method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == 201){

            String msg = data.getStringExtra(KEY_MESSAGE);
            Log.d("tag","Result : "+msg);

            textView.setText(msg);
            textView.setTextSize(19);

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tag","on Start ");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("tag","on resume ");
    }


    @Override
    protected void onPause() {
        super.onPause();

        Log.d("tag","on Pause ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("tag","on Stop ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("tag","on Destroy ");
    }
}