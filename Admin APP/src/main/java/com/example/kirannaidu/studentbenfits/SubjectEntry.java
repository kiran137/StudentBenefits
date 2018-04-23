package com.example.kirannaidu.studentbenfits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SubjectEntry extends AppCompatActivity {

   TextView branch1,year1,sem1;
   EditText subject;
   ListView Listviewsub;
   Button submit;
   Button sub;
   DatabaseReference databasesubjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_entry);
       // branch1=(TextView)findViewById(R.id.textView6);
        sub=findViewById(R.id.button5);
        subject=(EditText)findViewById(R.id.editText);
        //Listviewsub=(ListView)findViewById(R.id.ListViewClasses);
        submit=(Button)findViewById(R.id.button3);
        Intent intent=getIntent();
        String id=intent.getStringExtra(Claasses_list.id);
      //  String branch=intent.getStringExtra(Educational.branch);
       // String year=intent.getStringExtra(Educational.year);
      //  String sem=intent.getStringExtra(Educational.sem);
        //branch1.setText(branch);
       // year1.setText(year);
     //   sem1.setText(sem);
        databasesubjects= FirebaseDatabase.getInstance().getReference("subjects").child(id);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSubject();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SubjectEntry.this,ClassList1.class);
                startActivity(intent);
            }
        });
    }
    private void saveSubject(){
        String subname=subject.getText().toString().trim();
        if(!TextUtils.isEmpty(subname)){
            String id=databasesubjects.push().getKey();
            subjects s=new subjects(id,subname);
            databasesubjects.child(id).setValue(s);
            Toast.makeText(this,"saved success",Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(this,"name should be given",Toast.LENGTH_SHORT).show();
        }

    }
}
