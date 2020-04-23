package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

private EditText kime,baslik,mesaj;
private Button gönder,ekle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        kime = findViewById(R.id.etKime);
        baslik = findViewById(R.id.etBaslik);
        mesaj = findViewById(R.id.etMesaj);
        gönder = findViewById(R.id.btnGönder);






        gönder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailGonder();
            }
        });
    }
        private void mailGonder(){
            String Alici=kime.getText().toString();

            String Konu=baslik.getText().toString();
            String Mesaj=mesaj.getText().toString();

            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL,new String []{Alici});
            intent.putExtra(Intent.EXTRA_SUBJECT,Konu);
            intent.putExtra(Intent.EXTRA_TEXT,Mesaj);
            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent,"mail gönder"));

        }





    }


