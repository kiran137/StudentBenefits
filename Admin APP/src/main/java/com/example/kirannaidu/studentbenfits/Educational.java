package com.example.kirannaidu.studentbenfits;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Educational extends AppCompatActivity {
    public static final String id="id";
    public static final String branch="branchname";

    public static final String year="year";
    public static final String sem="sem";

    private Spinner spinner1, spinner2;
    private TextView btnSubmit;
    private TextView txt1,txt2;

    DatabaseReference databasesection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational);
        spinner1 = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner3);

        txt1 = findViewById(R.id.textview1);
        txt2 = findViewById(R.id.textView2);
        //helper=new FirebaseHelper(databasesection);

          // recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnSubmit = findViewById(R.id.textView4);

        databasesection= FirebaseDatabase.getInstance().getReference("classes");
        btnSubmit.setOnClickListener(new OnClickListener() {
                                         @Override
                                         public void onClick(View view) {

                                             addCLASS();
                                             Intent intent=new Intent(Educational.this,Claasses_list.class);
                                             startActivity(intent);
                                         }


                                     }

        );


    }

    private void addCLASS(){
        String branch=spinner1.getSelectedItem().toString();
        String yearsem=spinner2.getSelectedItem().toString();

        String id=databasesection.push().getKey();
        Semclass semi=new Semclass(id,branch,yearsem);
        databasesection.child(id).setValue(semi);
        Toast.makeText(this,"ADDED",Toast.LENGTH_SHORT).show();

    }



}
