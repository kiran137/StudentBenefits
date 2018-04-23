package com.example.user.arpander;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewFile extends AppCompatActivity {

    ListView lsd;
    public static final String id="id";

    DatabaseReference dref;
    Filename f;
    List <Filename> list;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_file);

        lsd=findViewById(R.id.lsd);
        list=new ArrayList<Filename>();
        f=new Filename();
        Intent intent=getIntent();

        String id=intent.getStringExtra(User3.id1);

        dref= FirebaseDatabase.getInstance().getReference("Subjectfiles").child(id);
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    f=ds.getValue(Filename.class);
                    list.add(f);
                }
                String[] uploads = new String[list.size()];

                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = list.get(i).getName();
                }
                adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.list_layout,R.id.textView7, uploads);
                lsd.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        lsd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Filename fun=list.get(i);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(fun.getUrl()));
                startActivity(intent);
            }
        });


    }


}