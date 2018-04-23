package com.example.kirannaidu.studentbenfits;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Claasses_list extends AppCompatActivity {

    public static final String id="id";
    public static final String branch="branchname";
    DatabaseReference dref;
    ListView listview;

    Semclass sem ;
    Button but;
        ArrayList<String> list;
    ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claasses_list);
        listview=findViewById(R.id.ListViewClass);
          sem = new Semclass();
          list=new ArrayList<String>();
          but=findViewById(R.id.button4);
        adapter=new ArrayAdapter<String>(this,R.layout.list_layout,R.id.textView7,list);
        dref= FirebaseDatabase.getInstance().getReference("classes");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot sec:dataSnapshot.getChildren()){

                  sem= sec.getValue(Semclass.class);
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
               // Semclass s=(Semclass)adapterView.getAdapter().getItem(i);
                Intent intent=new Intent(getApplicationContext(),SubjectEntry.class);
                intent.putExtra(id,listview.getItemAtPosition(i).toString());
                //intent.putExtra(branch,s.getBranch()+" "+s.getYearsem());
                startActivity(intent);
            }
        });
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Claasses_list.this,Educational.class);
                startActivity(intent);
            }
        });

    }
}
