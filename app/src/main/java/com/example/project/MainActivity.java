package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText kullanici,sifre;
    private Button giris,sifreUnut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kullanici=findViewById(R.id.etKullaniciAdi);
        sifre=findViewById(R.id.etSifre);
        giris=findViewById(R.id.btnGiris);
        sifreUnut=findViewById(R.id.btnSifreUnut);

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kullanici.getText().toString().equals("admin") && sifre.getText().toString().equals("123")){
                    Intent intent=new Intent(MainActivity.this,MenuActivity.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(MainActivity.this,"Şifreniz Yanlış Aşağıdaki Butondan Ögrenebilirsiniz.",Toast.LENGTH_LONG).show();
                }
            }
        });

        sifreUnut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Kullanıcı Adi:admin ,Şifreniz :123.",Toast.LENGTH_LONG).show();
            }
        });

    }
}
