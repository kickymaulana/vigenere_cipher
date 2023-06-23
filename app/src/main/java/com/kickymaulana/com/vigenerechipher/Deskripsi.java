package com.kickymaulana.com.vigenerechipher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Deskripsi extends AppCompatActivity {


    AppCompatEditText plain_text, kunci, hasil_enkripsi;
    AppCompatButton deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Deskripsi");

        plain_text = (AppCompatEditText) findViewById(R.id.plain_text);
        kunci = (AppCompatEditText) findViewById(R.id.kunci);
        hasil_enkripsi = (AppCompatEditText)  findViewById(R.id.hasil_enkripsi);
        deskripsi = (AppCompatButton)  findViewById(R.id.deskripsi);

        deskripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jadi_plain_text = decrypt(hasil_enkripsi.getText().toString(), kunci.getText().toString());
                plain_text.setText(jadi_plain_text);

            }
        });
    }


    public static String decrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemid = item.getItemId();
        if (itemid == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}