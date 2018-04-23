package com.example.user.arpander;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

public class User1 extends AppCompatActivity {
    public Button log1;
    public TextView ed13,ed4;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user1);
        ed13=findViewById(R.id.textView11);
        //ed4=findViewById(R.id.textView12);
        log1=findViewById(R.id.button7);
        firebaseAuth=FirebaseAuth.getInstance();
        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        FirebaseUser user=firebaseAuth.getCurrentUser();
        log1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(User1.this,MainActivity.class));
            }
        });
        ed13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(User1.this,User2.class));
            }
        });
       // ed4.setOnClickListener(new View.OnClickListener() {
         //   @Override
        //    public void onClick(View view) {
              //  startActivity(new Intent(User1.this,Claasses_list.class));
          //  }
       // });
    }


}
