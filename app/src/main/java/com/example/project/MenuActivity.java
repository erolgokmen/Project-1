package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private Button emailGonder,kullaniciListele,ivmeOlcer,isikSensoru,kullaniciAyarlari,bilgi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        emailGonder=findViewById(R.id.btnEmailGonder);
        kullaniciListele=findViewById(R.id.btnKullaniciListele);
        ivmeOlcer=findViewById(R.id.btnİvmeOlcer);
        isikSensoru=findViewById(R.id.btnIsıkSensoru);
        kullaniciAyarlari=findViewById(R.id.btnKullaniciAyarlari);
        bilgi=findViewById(R.id.btnBilgi);


        emailGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,EmailActivity.class);
                startActivity(intent);

            }
        });


        kullaniciListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,KullaniciListelemeActivity.class);
                startActivity(intent);

            }
        });


        kullaniciAyarlari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,KullaniciAyarlariActivity.class);
                startActivity(intent);

            }
        });


        bilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,BilgiActivity.class);
                startActivity(intent);

            }
        });

        isikSensoru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,IsikSensor.class);
                startActivity(intent);

            }
        });



    }
}
