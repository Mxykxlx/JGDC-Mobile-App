package com.example.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class addEntry extends AppCompatActivity {
    Button add, cancel;
    EditText nm, rmrks, hbbs;
    TextView bday;
    RadioButton rb1, rb2;
    ImageView ImgVAdd;
    DatePickerDialog dp;
    Bitmap bmp;
    Context c = this;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        in();
        fnctn();

    }


    private void in() {
        add = findViewById(R.id.addentry);
        cancel = findViewById(R.id.canceladd);
        bday = findViewById(R.id.bday);
        hbbs = findViewById(R.id.hbbs);
        nm = findViewById(R.id.nm);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rmrks = findViewById(R.id.rmrks);
        ImgVAdd = findViewById(R.id.ImgVAdd);
    }


    private void fnctn() {

        ImgVAdd.setOnClickListener(view -> {
            Intent pic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (pic.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(pic, REQUEST_IMAGE_CAPTURE);
            }
        });


        bday.setOnClickListener(view -> {
            dpick();
        });


        add.setOnClickListener(view -> {

            String n = nm.getText().toString();
            String r = rmrks.getText().toString();
            String dob = bday.getText().toString();
            String hob = hbbs.getText().toString();
            String m = rb1.getText().toString();
            String fm = rb2.getText().toString();

            String gender = "";

            if ((rb1.isChecked())) {
                gender += m;
            }

            if ((rb2.isChecked())) {
                gender += fm;
            }

            if (gender.equals("")){
                ngndr();
            }

            else if (bmp == null){
                noimg();
            }

            else if (n.equals("")||r.equals("")||dob.equals("")){
                incomplete();
            }


            else{


                Intent it = new Intent();
                it.putExtra("name",n);
                it.putExtra("remarks",r);
                it.putExtra("dob", dob);
                it.putExtra("gndr", gender);
                it.putExtra("hbbs", hob);
                it.putExtra("imgA", bmp);

                setResult(RESULT_OK,it);
                finish();
            }

        });

        cancel.setOnClickListener(view -> {
            finish();
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            bmp = photo;
            ImgVAdd.setBackground(null);
            ImgVAdd.setImageBitmap(bmp);

        }
    }


    private void dpick() {
        dp = new DatePickerDialog(c, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String mon[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                bday.setText((mon[month]) +" " + day +", " +year);
            }
        }, //yr, mm, dd
                // IF SPECIFIC DATE
                2000, 3, 30); //Start of month is 0

        dp.show();
    }

    private  void ngndr() {
        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        adb.setTitle("Gender not indicated!")
                .setMessage("Please specify your gender!")
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

    private  void noimg() {
        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        adb.setTitle("Incomplete input!")
                .setMessage("Please take a photo!")
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