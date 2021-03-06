package com.example.user.arpander;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class User3 extends AppCompatActivity {
    ListView lvw;
    public static final String id="id";
    public static final String id1="id1";
    DatabaseReference db;
    ArrayList<String> list1;
    ArrayAdapter<String> adapter1;
    subjects sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user3);
        lvw=findViewById(R.id.ListV);
        list1=new ArrayList<>();
        adapter1=new ArrayAdapter<String>(this,R.layout.list_layout,R.id.textView7,list1);
        final Intent intent=getIntent();
        final String id=intent.getStringExtra(User2.id);
        sub=new subjects();
        db= FirebaseDatabase.getInstance().getReference("subjects").child(id);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dbs :dataSnapshot.getChildren()){
                    sub=dbs.getValue(subjects.class);
                    list1.add(sub.getSubname().toString());
                }
                lvw.setAdapter(adapter1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        lvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent inte=new Intent(getApplicationContext(),ViewFile.class);
                inte.putExtra(id1,lvw.getItemAtPosition(i).toString());
                startActivity(inte);
            }
        });
    }
}
