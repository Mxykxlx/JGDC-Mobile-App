package com.example.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class EditEntry extends AppCompatActivity {

    ImageView IVedit;
    EditText EDTNAM, EDTREM, EDTHOB;
    Button save, cancel;
    RadioGroup rbgrp;
    RadioButton rb1, rb2;
    TextView EDTBDAY;
    DatePickerDialog dp;
    Bitmap bmp;

    Context c = this;



    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_entry);


        in();
        fnctn();

        Intent intent = getIntent();
        int position = intent.getIntExtra("pstn",0);

        bmp = Application.acc.get(position).getImg();
        String nam = Application.acc.get(position).getTtl();
        String rem = Application.acc.get(position).getRmrks();
        String b = Application.acc.get(position).getBday();
        String g = Application.acc.get(position).getGndr();
        String h = Application.acc.get(position).getHbbs();

        IVedit.setImageBitmap(bmp);
        EDTNAM.setText(nam);
        EDTREM.setText(rem);
        EDTBDAY.setText(b);
        EDTHOB.setText(h);

        if(g.equals("Male")){
            rb1.setChecked(true);
        }

        if(g.equals("Female")){
            rb2.setChecked(true);
        }





    }

    private void in() {
        IVedit = findViewById(R.id.IVedit);
        EDTNAM = findViewById(R.id.EDTNAM);
        EDTREM = findViewById(R.id.EDTREM);
        EDTBDAY = findViewById(R.id.EDTBDAY);
        EDTHOB = findViewById(R.id.EDTHOB);
        rbgrp = findViewById(R.id.rbgrp);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel);
    }

    private void fnctn() {

        IVedit.setOnClickListener(view -> {
            Intent pic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (pic.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(pic, REQUEST_IMAGE_CAPTURE);
            }
        });

        EDTBDAY.setOnClickListener(view -> {
            dpick();
        });

        save.setOnClickListener(view -> {

            String n = EDTNAM.getText().toString();
            String r = EDTREM.getText().toString();
            String dob = EDTBDAY.getText().toString();
            String hob = EDTHOB.getText().toString();

            if (n.equals("")||r.equals("")){
                incomplete();
            }

            else{
                Intent gi = getIntent();
                int position = gi.getIntExtra("pstn",0);
                String gender = "";

                if ((rb1.isChecked())) {
                    gender = rb1.getText().toString();
                }

                if ((rb2.isChecked())) {
                    gender = rb2.getText().toString();
                }

                    Application.acc.set(position, new Accounts(bmp,n,r,dob,gender, hob));
                    setResult(RESULT_OK,gi);
                    finish();
            }
        });

        cancel.setOnClickListener(view -> {

            Intent it = new Intent();
            setResult(RESULT_CANCELED, it);
            finish();

        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            bmp = photo;
            IVedit.setBackground(null);
            IVedit.setImageBitmap(photo);
        }
    }

    private void dpick() {
        dp = new DatePickerDialog(c, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String mon[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                EDTBDAY.setText((mon[month]) +" " + day +", " +year);
            }
        }, //yr, mm, dd
                // IF SPECIFIC DATE
                2000, 3, 30); //Start of month is 0

        dp.show();
    }

    private  void incomplete() {
        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        adb.setTitle("Incomplete details!")
                .setMessage("Please answer all the empty fields!")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(c, "Try again!", Toast.LENGTH_SHORT).show();
                    }
                })
        ;
        AlertDialog d = adb.create();
        d.show();
    }


}
