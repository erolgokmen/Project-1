package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class KullaniciListelemeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[],s2[];
    int images[]={R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_listeleme);


        recyclerView=findViewById(R.id.recyclerView);

        s1=getResources().getStringArray(R.array.Kullanici_Listesi);
        s2=getResources().getStringArray(R.array.Sifre);

        myAdapter myAdapter=new myAdapter(this,s1,s2,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
