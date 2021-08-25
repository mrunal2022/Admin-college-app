package com.mrunal.admincollegeapp.faculty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrunal.admincollegeapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {
    FloatingActionButton fab;
    private RecyclerView csDepartment,itDepartment,entcDepartment;
    private LinearLayout csNoData,itNoData,entcNoData;
    private List<TeacherData> list1,list2,list3;
    private DatabaseReference reference,dbRef;
    private TeacherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        entcNoData=findViewById(R.id.entcNoData);
        itNoData=findViewById(R.id.itNoData);
        csNoData=findViewById(R.id.csNoData);


        csDepartment=findViewById(R.id.csDepartment);
        itDepartment=findViewById(R.id.itDepartment);
        entcDepartment=findViewById(R.id.entcDepartment);
        reference= FirebaseDatabase.getInstance().getReference().child("teacher");
        csDepartment();
        itDepartment();
        entcDepartment();


        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFaculty.this,AddTeacher.class));


            }
        });
    }

    private void csDepartment() {
        dbRef=reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1=new ArrayList<>();
                if(!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);

                }else{
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data=snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter=new TeacherAdapter(list1,UpdateFaculty.this,"Computer Science");
                    csDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void itDepartment() {
        dbRef=reference.child("Information technology");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2=new ArrayList<>();
                if(!dataSnapshot.exists()){
                    itNoData.setVisibility(View.VISIBLE);
                    itDepartment.setVisibility(View.GONE);

                }else{
                    itNoData.setVisibility(View.GONE);
                    itDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data=snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    itDepartment.setHasFixedSize(true);
                    itDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter=new TeacherAdapter(list2,UpdateFaculty.this,"Information technology");
                    itDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void entcDepartment() {
        dbRef=reference.child("EnTC");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3=new ArrayList<>();
                if(!dataSnapshot.exists()){
                    entcNoData.setVisibility(View.VISIBLE);
                    entcDepartment.setVisibility(View.GONE);

                }else{
                    entcNoData.setVisibility(View.GONE);
                    entcDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data=snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    entcDepartment.setHasFixedSize(true);
                    entcDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter=new TeacherAdapter(list3,UpdateFaculty.this,"EnTC");
                    entcDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}