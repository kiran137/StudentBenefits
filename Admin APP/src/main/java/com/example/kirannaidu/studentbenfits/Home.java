package com.example.kirannaidu.studentbenfits;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.support.v7.widget.Toolbar;


public class Home extends AppCompatActivity {
   public Button log;
   public TextView ed1,ed2;
    private FirebaseAuth firebaseAuth;
    private Timer timer;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ed1= findViewById(R.id.textView2);
      //  ed2= findViewById(R.id.textView3);
        log= findViewById(R.id.button2);

        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser user=firebaseAuth.getCurrentUser();

       log.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FirebaseAuth.getInstance().signOut();
               startActivity(new Intent(Home.this,MainActivity.class));

           }
       });
       ed1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(Home.this,Claasses_list.class));
           }
       });
      // ed2.setOnClickListener(new View.OnClickListener() {
        //   @Override
          // public void onClick(View view) {
            //   startActivity(new Intent(Home.this,Information.class));
           //}
       //});

    }


}




