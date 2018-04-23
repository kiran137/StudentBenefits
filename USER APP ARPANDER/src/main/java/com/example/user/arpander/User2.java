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

public class User2 extends AppCompatActivity {
    public static final String id="id";
    public static final String branch="branchname";
    DatabaseReference dref;
    ListView listview;
    Semclass sem ;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user2);
        listview=findViewById(R.id.Lst);
        sem=new Semclass();
        dref= FirebaseDatabase.getInstance().getReference("classes");
        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.list_layout,R.id.textView7,list);
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    sem= ds.getValue(Semclass.class);
                    list.add(sem.getBranch().toString()+ "  "+sem.getYearsem().toString());
                }
                listview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(),User3.class);
                intent.putExtra(id,listview.getItemAtPosition(i).toString());
                //intent.putExtra(branch,s.getBranch()+" "+s.getYearsem());
                startActivity(intent);
            }
        });

    }
}
