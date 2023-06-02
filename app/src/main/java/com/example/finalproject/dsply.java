package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class dsply extends AppCompatActivity {

    TextView dname, drmrks, dbday, ne, dhbbs;
    RadioButton rb1, rb2;
    Button back;
    ImageView dimg;

    Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsply);

        ini();
        set();


    }

    private void ini() {
        ne = findViewById(R.id.ne);
        dname = findViewById(R.id.dname);
        drmrks = findViewById(R.id.drmrks);
        dbday = findViewById(R.id.dbday);
        dhbbs = findViewById(R.id.dhbbs);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        dimg = findViewById(R.id.dimg);
        back = findViewById(R.id.back);
    }

    private void set() {

        Intent in = getIntent();
        String n = in.getStringExtra("name");
        String r = in.getStringExtra("remarks");
        String b = in.getStringExtra("dob");
        String g = in.getStringExtra("gndr");
        String h = in.getStringExtra("hbbs");

        Bundle bun = getIntent().getExtras();
        Bitmap i = bun.getParcelable("img");

        ne.setText(n);
        dname.setText(n);
        drmrks.setText(r);
        dbday.setText(b);
        dhbbs.setText(h);
        dimg.setImageBitmap(i);
        rb1.setEnabled(false);
        rb2.setEnabled(false);

        if (g.equals("Male")){
            rb1.setChecked(true);
        }

        else {
            rb2.setChecked(true);
        }


        back.setOnClickListener(view -> {
            Intent it = getIntent();
            setResult(RESULT_OK,it);
            finish();
        });
    }
}