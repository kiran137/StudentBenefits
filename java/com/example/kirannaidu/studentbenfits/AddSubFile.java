package com.example.kirannaidu.studentbenfits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddSubFile extends AppCompatActivity {

    ListView l;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    EditText ed1,ed2;
    Button b1,b2;
    Filename f;
    DatabaseReference d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sub_file);
        //l=findViewById(R.id.LT);
        b1=findViewById(R.id.button6);
        list=new ArrayList<String>();
        f=new Filename();
        adapter=new ArrayAdapter<String>(this,R.layout.list_layout,R.id.textView7);
        // b2=findViewById(R.id.button7);
        ed1=findViewById(R.id.editText2);
        ed2=findViewById(R.id.editText3);
        final Intent intent=getIntent();
        final String id=intent.getStringExtra(SubjectsLists.id1);
        d= FirebaseDatabase.getInstance().getReference("Subjectfiles").child(id);
        /*d.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot d:dataSnapshot.getChildren()){
                    f=d.getValue(Filename.class);
                    list.add(f.getName());
                }
                l.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Savesub();
            }
        });

    }
    private void Savesub(){
        String filename=ed1.getText().toString().trim();
        String fileurl=ed2.getText().toString().trim();
        if(!TextUtils.isEmpty(filename)) {
            String id=d.push().getKey();
            Filename f=new Filename(id,filename,fileurl);
            d.child(id).setValue(f);
            Toast.makeText(this,"saved success",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"name should be given",Toast.LENGTH_SHORT).show();

        }
    }


}
