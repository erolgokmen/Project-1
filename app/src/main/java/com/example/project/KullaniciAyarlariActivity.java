package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class KullaniciAyarlariActivity extends AppCompatActivity {

    private Button btnKaydet;
    private EditText etKullaniciAdi, etYasi, etCinsiyet, etBoy, etKilo;
    private TextView tvkullanici,tvyas,tvcinsiyet,tvboy,tvkilo,tvKaranlik;
    private Switch swKaranlik;


    SharedPreferences sharedPreferences;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_ayarlari);


        etKullaniciAdi = findViewById(R.id.etKullaniciAdi);
        etYasi = findViewById(R.id.etYasi);
        etCinsiyet = findViewById(R.id.etCinsiyet);
        etBoy = findViewById(R.id.etBoy);
        etKilo = findViewById(R.id.etKilo);
        btnKaydet = findViewById(R.id.btnKaydet);
        tvkullanici=findViewById(R.id.tvkullanici);
        tvyas=findViewById(R.id.tvyasi);
        tvcinsiyet=findViewById(R.id.tvcinsiyet);
        tvboy=findViewById(R.id.tvboy);
        tvkilo=findViewById(R.id.tvkilo);
        tvKaranlik=findViewById(R.id.tvKaranlikMod);
        swKaranlik=findViewById(R.id.swDark);



         sharedPreferences=this.getSharedPreferences("com.example.project", Context.MODE_PRIVATE);



       String kayitlikullanici=sharedPreferences.getString("keyKullanici","-");
       tvkullanici.setText(("Kullanıcı Adı"+kayitlikullanici));

        int kayitliyas=sharedPreferences.getInt("keyYasi",0);
       tvyas.setText("Yaşı"+kayitliyas);

        String kayitlicinsiyet=sharedPreferences.getString("keyCinsiyet","-");
        tvcinsiyet.setText(("Cinsiyet:"+kayitlicinsiyet));

        int kayitlikilo=sharedPreferences.getInt("keyKilo",0);
        tvkilo.setText("Kilo:"+kayitlikilo);


        int kayitliboy=sharedPreferences.getInt("keyBoy",0);
        tvboy.setText("Boy:"+kayitliboy);



    }


    public void Kaydet(View view) {

        String kullanici=etKullaniciAdi.getText().toString();
        tvkullanici.setText("Kullanıcı Adı:"+kullanici);


        int yas=Integer.parseInt(etYasi.getText().toString());
        tvyas.setText("yaşın:"+yas);

        String cinsiyet=etCinsiyet.getText().toString();
        tvcinsiyet.setText("Cinsiyet:"+cinsiyet);

        int boy=Integer.parseInt(etBoy.getText().toString());
        tvboy.setText("Boy:"+boy);

        int kilo=Integer.parseInt(etKilo.getText().toString());
        tvkilo.setText("Kilo:"+kilo);





        sharedPreferences.edit().putString("keyKullanici",kullanici).apply();
        sharedPreferences.edit().putInt("keyYasi",yas).apply();
        sharedPreferences.edit().putString("keyCinsiyet",cinsiyet).apply();
        sharedPreferences.edit().putInt("keyKilo",kilo).apply();
        sharedPreferences.edit().putInt("keyBoy",boy).apply();


    }

}