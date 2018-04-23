package com.example.user.arpander;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.TestLooperManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private EditText ed1,ed2;
    private TextView td1;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed1= findViewById(R.id.loginid);
        ed2= findViewById(R.id.password);
        td1= findViewById(R.id.textView);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user!=null)
        {
            finish();
            startActivity(new Intent(Login.this,User1.class));
        }
        td1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate1()) {
                    validate2(ed1.getText().toString(), ed2.getText().toString());
                }
                else {
                    Toast.makeText(Login.this,"enter details",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void validate2(String username,String Password){
        progressDialog.setMessage("Please wait");

        firebaseAuth.signInWithEmailAndPassword(username, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    // if (ed1.getText().toString() == "pulaparthikiran@gmail.com" && ed2.getText().toString() == "kiran12345")
                    //progressDialog.dismiss();
                    //Toast.makeText(Login.this, "login Success", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(Login.this, Home.class));

                    progressDialog.dismiss();
                    Toast.makeText(Login.this, "login Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, User1.class));

                } else {
                    progressDialog.dismiss();
                    Toast.makeText(Login.this, "login credentials wrong or internet problem", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private boolean validate1(){
        Boolean result=false;
        String name=ed1.getText().toString();
        String password=ed2.getText().toString();
        if(name.isEmpty() || password.isEmpty()){
            Toast.makeText(Login.this,"please enter details",Toast.LENGTH_SHORT).show();

        }else
        {
            result=true;
        }
        return result;
    }
}