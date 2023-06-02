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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class reg extends AppCompatActivity {

    TextView bday;
    EditText etun, etpw, etcpw, etfn, etln, etea, etcn, etadd, ans1, ans2, ans3;
    CheckBox hb1, hb2, hb3, hb4, hb5, hb6, hb7, hb8, hb9, hb10;
    Button reg, logr;
    RadioButton rb1, rb2;
    RadioGroup rbgrp;
    DatePickerDialog dp;
    Spinner spnr1, spnr2, spnr3;
    Context c = this;
    String qstns[] = {"Please select a question", "What is your name?", "What is your father's pet name?", "What is your maiden name?", "What is your first pet's name?", "What are you doing?"};
    String a1 = "";
    String a2 = "";
    String a3 = "";

    ImageView imgv;
    Bitmap bmp;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        //CALLING OF METHODSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
        ini();
        spinnur();
        fnctn();

        //ADAPTER FOR SPINNERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
        ArrayAdapter<String> adp = new ArrayAdapter<>(c, android.R.layout.simple_spinner_item,qstns);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        spnr1.setAdapter(adp);
        spnr2.setAdapter(adp);
        spnr3.setAdapter(adp);

    }

    private void ini() {
        imgv = findViewById(R.id.imgv);
        bday = findViewById(R.id.bday);
        etun = findViewById(R.id.etun);
        etpw = findViewById(R.id.etpw);
        etcpw = findViewById(R.id.etcpw);
        etfn = findViewById(R.id.etfn);
        etln = findViewById(R.id.etln);
        etea = findViewById(R.id.etea);
        etcn = findViewById(R.id.etcn);
        rbgrp = findViewById(R.id.rbgrp);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        hb1 = findViewById(R.id.hb1);
        hb2 = findViewById(R.id.hb2);
        hb3 = findViewById(R.id.hb3);
        hb4 = findViewById(R.id.hb4);
        hb5 = findViewById(R.id.hb5);
        hb6 = findViewById(R.id.hb6);
        hb7 = findViewById(R.id.hb7);
        hb8 = findViewById(R.id.hb8);
        hb9 = findViewById(R.id.hb9);
        hb10 = findViewById(R.id.hb10);
        reg = findViewById(R.id.reg);
        logr = findViewById(R.id.logr);
        etadd = findViewById(R.id.etadd);
        spnr1 = findViewById(R.id.spnr1);
        ans1 = findViewById(R.id.ans1);
        spnr2 = findViewById(R.id.spnr2);
        ans2 = findViewById(R.id.ans2);
        spnr3 = findViewById(R.id.spnr3);
        ans3 = findViewById(R.id.ans3);
    }

    private void spinnur(){
        spnr1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                int q1 = 0;
                int q2 = 0;
                int q3 = 0;
                int q4 = 0;
                int q5 = 0;

                String str1 = spnr1.getSelectedItem().toString();
                String str2 = spnr2.getSelectedItem().toString();
                String str3 = spnr3.getSelectedItem().toString();

                //FOR QUESTION 1 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[1]){
                    q1 += 1;
                }
                if (str2==qstns[1]){
                    q1 += 1;
                }
                if (str3==qstns[1]){
                    q1 += 1;
                }

                //FOR QUESTION 2 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[2]){
                    q2 += 2;
                }
                if (str2==qstns[2]){
                    q2 += 2;
                }
                if (str3==qstns[2]){
                    q2 += 2;
                }

                //FOR QUESTION 3 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[3]){
                    q3 += 3;
                }
                if (str2==qstns[3]){
                    q3 += 3;
                }
                if (str3==qstns[3]){
                    q3 += 3;
                }

                //FOR QUESTION 4 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[4]){
                    q4 += 4;
                }
                if (str2==qstns[4]){
                    q4 += 4;
                }
                if (str3==qstns[4]){
                    q4 += 4;
                }

                //FOR QUESTION 5 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[5]){
                    q5 += 5;
                }
                if (str2==qstns[5]){
                    q5 += 5;
                }
                if (str3==qstns[5]){
                    q5 += 5;
                }
//  ERRORSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
                //FOR QUESTION 1 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q1>1){
                    error1();
                }

                //FOR QUESTION 2 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q2>2){
                    error1();
                }

                //FOR QUESTION 3 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q3>3){
                    error1();
                }

                //FOR QUESTION 4 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q4>4){
                    error1();
                }

                //FOR QUESTION 5 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q5>5){
                    error1();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        spnr2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                int q1 = 0;
                int q2 = 0;
                int q3 = 0;
                int q4 = 0;
                int q5 = 0;

                String str1 = spnr1.getSelectedItem().toString();
                String str2 = spnr2.getSelectedItem().toString();
                String str3 = spnr3.getSelectedItem().toString();

                //FOR QUESTION 1 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[1]){
                    q1 += 1;
                }
                if (str2==qstns[1]){
                    q1 += 1;
                }
                if (str3==qstns[1]){
                    q1 += 1;
                }

                //FOR QUESTION 2 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[2]){
                    q2 += 2;
                }
                if (str2==qstns[2]){
                    q2 += 2;
                }
                if (str3==qstns[2]){
                    q2 += 2;
                }

                //FOR QUESTION 3 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[3]){
                    q3 += 3;
                }
                if (str2==qstns[3]){
                    q3 += 3;
                }
                if (str3==qstns[3]){
                    q3 += 3;
                }

                //FOR QUESTION 4 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[4]){
                    q4 += 4;
                }
                if (str2==qstns[4]){
                    q4 += 4;
                }
                if (str3==qstns[4]){
                    q4 += 4;
                }

                //FOR QUESTION 3 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[5]){
                    q5 += 5;
                }
                if (str2==qstns[5]){
                    q5 += 5;
                }
                if (str3==qstns[5]){
                    q5 += 5;
                }
//  ERRORSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
                //FOR QUESTION 1 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q1>1){
                    error2();
                }

                //FOR QUESTION 2 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q2>2){
                    error2();
                }

                //FOR QUESTION 3 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q3>3){
                    error2();
                }

                //FOR QUESTION 4 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q4>4){
                    error2();
                }

                //FOR QUESTION 5 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q5>5){
                    error2();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        spnr3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                int q1 = 0;
                int q2 = 0;
                int q3 = 0;
                int q4 = 0;
                int q5 = 0;

                String str1 = spnr1.getSelectedItem().toString();
                String str2 = spnr2.getSelectedItem().toString();
                String str3 = spnr3.getSelectedItem().toString();

                //FOR QUESTION 1 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[1]){
                    q1 += 1;
                }
                if (str2==qstns[1]){
                    q1 += 1;
                }
                if (str3==qstns[1]){
                    q1 += 1;
                }

                //FOR QUESTION 2 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[2]){
                    q2 += 2;
                }
                if (str2==qstns[2]){
                    q2 += 2;
                }
                if (str3==qstns[2]){
                    q2 += 2;
                }

                //FOR QUESTION 3 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[3]){
                    q3 += 3;
                }
                if (str2==qstns[3]){
                    q3 += 3;
                }
                if (str3==qstns[3]){
                    q3 += 3;
                }

                //FOR QUESTION 4 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[4]){
                    q4 += 4;
                }
                if (str2==qstns[4]){
                    q4 += 4;
                }
                if (str3==qstns[4]){
                    q4 += 4;
                }

                //FOR QUESTION 5 ADDINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                if (str1==qstns[5]){
                    q5 += 5;
                }
                if (str2==qstns[5]){
                    q5 += 5;
                }
                if (str3==qstns[5]){
                    q5 += 5;
                }
//  ERRORSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
                //FOR QUESTION 1 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q1>1){
                    error3();
                }

                //FOR QUESTION 2 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q2>2){
                    error3();
                }

                //FOR QUESTION 3 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q3>3){
                    error3();
                }

                //FOR QUESTION 4 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q4>4){
                    error3();
                }

                //FOR QUESTION 5 ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
                if(q5>5){
                    error3();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void fnctn() {
        //BIRTHDAY DATE PICKERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
        bday.setOnClickListener(view -> {
            dpick();
        });

        imgv.setOnClickListener(view -> {
            Intent pic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (pic.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(pic, REQUEST_IMAGE_CAPTURE);
            }
        });

        logr.setOnClickListener(view -> {
            finish();
        });


        //BUTTON LISTENERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
        reg.setOnClickListener(view -> {
            String dob = bday.getText().toString();
            String un = etun.getText().toString();
            String pw = etpw.getText().toString();
            String cpw = etcpw.getText().toString();
            String fn = etfn.getText().toString();
            String ln = etln.getText().toString();
            String ea = etea.getText().toString();
            String cn = etcn.getText().toString();
            String add = etadd.getText().toString();
            String m = rb1.getText().toString();
            String fm = rb2.getText().toString();
            String a1 = ans1.getText().toString();
            String a2 = ans2.getText().toString();
            String a3 = ans3.getText().toString();


            int p1 = spnr1.getSelectedItemPosition();
            int p2 = spnr2.getSelectedItemPosition();
            int p3 = spnr3.getSelectedItemPosition();

            String str1 = spnr1.getSelectedItem().toString();
            String str2 = spnr2.getSelectedItem().toString();
            String str3 = spnr3.getSelectedItem().toString();

            String ast = pw.replaceAll("\\S","*");

            String gender = "";

            //ADDING OF DATAAAA IN GENDERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
            if ((rb1.isChecked())) {
                gender += m;
            }

            if ((rb2.isChecked())) {
                gender += fm;
            }



//            //CONDITIONSSSSSSSSSSSSSSSSSSS FOR ALERTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
            if (!pw.equals(cpw)){
                nm();
            }

            else if (un.equals("")||pw.equals("")||cpw.equals("")||fn.equals("")||ln.equals("")||ea.equals("")||add.equals("")||cn.equals("")||dob.equals("")||a1.equals("")||a2.equals("")||a3.equals("")) {
                incomplete();
            }

            else if(bmp == null){
                noimg();
            }

            else if (p1==0||p2==0||p3==0){
                qstn();
            }

            else if (rb1.isChecked()==false&&rb2.isChecked()==false){
                ngndr();
            }

            else if (hb1.isChecked()==false&&hb2.isChecked()==false&&hb3.isChecked()==false&&hb4.isChecked()==false&&hb5.isChecked()==false&&hb6.isChecked()==false&&hb7.isChecked()==false&&hb8.isChecked()==false&&hb9.isChecked()==false&&hb10.isChecked()==false){
                inccb();
            }

            else if (gender.equals("")){
                ngndr();
            }

            //IF ALL FIELDS ARE COMPLETEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
            else{
                String buffer = "";

                if(hb1.isChecked()) {
                    buffer += "\n*" +hb1.getText().toString();
                }
                if(hb2.isChecked()) {
                    buffer += "\n*" +hb2.getText().toString();
                }
                if(hb3.isChecked()) {
                    buffer += "\n*" +hb3.getText().toString();
                }
                if(hb4.isChecked()) {
                    buffer += "\n*" +hb4.getText().toString();
                }
                if(hb5.isChecked()) {
                    buffer += "\n*" +hb5.getText().toString();
                }
                if(hb6.isChecked()) {
                    buffer += "\n*" +hb6.getText().toString();
                }
                if(hb7.isChecked()) {
                    buffer += "\n*" +hb7.getText().toString();
                }
                if(hb8.isChecked()) {
                    buffer += "\n*" +hb8.getText().toString();
                }
                if(hb9.isChecked()) {
                    buffer += "\n*" +hb9.getText().toString();
                }
                if(hb10.isChecked()) {
                    buffer += "\n*" +hb10.getText().toString();
                }

                if (p1==1||p1==2||p1==3||p1==4||p1==5){
                    a1 = str1;
                }
                if (p2==1||p2==2||p2==3||p2==4||p2==5){
                    a2 = str2;
                }
                if (p3==1||p3==2||p3==3||p3==4||p3==5){
                    a3 = str3;
                }



                AlertDialog.Builder adb = new AlertDialog.Builder(c);
                adb.setTitle("Registered Successfully!")
                        .setMessage("THE REGISTERED DETAILS ARE:\n\n" + "USERNAME: " + un + "\n"
                                + "\nPASSWORD: " + ast + "\n"
                                + "\nFIRST NAME: " + fn + "\n"
                                + "\nFIRST NAME: " + ln + "\n"
                                + "\nEMAIL ADDRESS: " + ea + "\n"
                                + "\nBIRTHDAY: " + dob + "\n"
                                + "\nGENDER: " + gender + "\n"
                                + "\nADDRESS: " + add + "\n"
                                + "\nCONTACT NUMBER: " + cn + "\n"
                                + "\nHOBBIES: " + buffer + "\n"
                                + "\nSELECTED QUESTIONS:\n" + "*" + a1 + "\n" + "*" + a2 + "\n" + "*" + a3)
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent it = new Intent(c, MainActivity.class);

                                it.putExtra("un", un);
                                it.putExtra("pw", pw);
                                it.putExtra("fn", fn);
                                it.putExtra("ln", ln);
                                it.putExtra("img", bmp);

                                startActivity(it);
                                Toast.makeText(c, "Registered succesfully! Thank you so much at natapos din!", Toast.LENGTH_SHORT).show();
                                finish();

                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog d = adb.create();
                d.show();
            }

        });
    }

    private void qstn() {
        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        adb.setTitle("Incomplete security question selected!")
                .setMessage("Please select 3 different security questions!")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(c, "Try again!", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog d = adb.create();
        d.show();
    }


    private void nm(){
        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        adb.setTitle("Passwords didn't match!")
                .setMessage("Passwords are incorrect")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(c, "Try again!", Toast.LENGTH_SHORT).show();
                        etpw.setText(null);
                        etcpw.setText(null);
                    }
                });

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


    private  void inccb() {
        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        adb.setTitle("There's no hobby selected!")
                .setMessage("Please select at least 1 hobby!")
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


    private void error1() {
        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        adb.setTitle("Question already selected!")
                .setMessage("The question has been selected already. Please choose another one!")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(c, "Try again!", Toast.LENGTH_SHORT).show();
                        spnr1.setSelection(0);
                    }
                })
        ;
        AlertDialog d = adb.create();
        d.show();
    }


    private void error2() {
        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        adb.setTitle("Question already selected!")
                .setMessage("The question has been selected already. Please choose another one!")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(c, "Try again!", Toast.LENGTH_SHORT).show();
                        spnr2.setSelection(0);
                    }
                })
        ;
        AlertDialog d = adb.create();
        d.show();
    }


    private void error3() {
        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        adb.setTitle("Question has been already selected!")
                .setMessage("The question has been selected already. Please choose another one!")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(c, "Try again!", Toast.LENGTH_SHORT).show();
                        spnr3.setSelection(0);
                    }
                })
        ;
        AlertDialog d = adb.create();
        d.show();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            bmp = photo;
            imgv.setBackground(null);
            imgv.setImageBitmap(bmp);

        }
    }
}