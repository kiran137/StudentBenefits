package com.example.kirannaidu.studentbenfits;

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

public class ClassList1 extends AppCompatActivity {
    ListView lv;
    public static final String id="id";
    public static final String branch="branchname";
    DatabaseReference dref;
    Semclass sem ;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list1);
        lv=findViewById(R.id.LV);
        sem = new Semclass();
        list=new ArrayList<String>();

        adapter=new ArrayAdapter<String>(this,R.layout.list_layout,R.id.textView7,list);
        dref= FirebaseDatabase.getInstance().getReference("classes");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot sec:dataSnapshot.getChildren()){

                    sem= sec.getValue(Semclass.class);
                    list.add(sem.getBranch().toString()+ "  "+sem.getYearsem().toString());
                }
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(ClassList1.this,SubjectsLists.class);
                intent.putExtra(id,lv.getItemAtPosition(i).toString());
                startActivity(intent);

            }
        });
    }
}
