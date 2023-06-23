package com.kickymaulana.com.vigenerechipher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Enkripsi extends AppCompatActivity {

    AppCompatEditText plain_text, kunci, hasil_enkripsi;
    AppCompatButton enkripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enkripsi);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Enkripsi");

        plain_text = (AppCompatEditText) findViewById(R.id.plain_text);
        kunci = (AppCompatEditText) findViewById(R.id.kunci);
        hasil_enkripsi = (AppCompatEditText)  findViewById(R.id.hasil_enkripsi);
        enkripsi = (AppCompatButton)  findViewById(R.id.enkripsi);
        enkripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hasilnya = encrypt(plain_text.getText().toString(), kunci.getText().toString());
                hasil_enkripsi.setText(hasilnya);
            }
        });
    }

    public static String encrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
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