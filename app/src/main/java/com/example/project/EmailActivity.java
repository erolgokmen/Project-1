package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EmailActivity extends AppCompatActivity {

    private EditText kime,baslik,mesaj;
    private TextView attachment;
    private Button gönder,ekle;
    Uri URI = null;
    private static final int PICK_FROM_GALLERY = 101;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        kime = findViewById(R.id.etKime);
        baslik = findViewById(R.id.etBaslik);
        mesaj = findViewById(R.id.etMesaj);
        attachment=findViewById(R.id.tvAttachment);
        gönder = findViewById(R.id.btnGönder);


        gönder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailGonder();
            }
        });

        attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            dosyaAc();
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {
            URI = data.getData();
            attachment.setText(URI.getLastPathSegment());
            attachment.setVisibility(View.VISIBLE);
        }
    }

        private void mailGonder(){
            String Alici=kime.getText().toString();

            String Konu=baslik.getText().toString();
            String Mesaj=mesaj.getText().toString();

            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL,new String []{Alici});
            intent.putExtra(Intent.EXTRA_SUBJECT,Konu);
            intent.putExtra(Intent.EXTRA_TEXT,Mesaj);
            intent.putExtra(Intent.EXTRA_STREAM, URI);

            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent,"mail gönder"));

        }



        private void dosyaAc(){
                Intent intent = new Intent();
                intent.setType("*/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.putExtra("return-data", true);
              startActivityForResult(Intent.createChooser(intent, "Tamamla"), PICK_FROM_GALLERY);
            }
        }





