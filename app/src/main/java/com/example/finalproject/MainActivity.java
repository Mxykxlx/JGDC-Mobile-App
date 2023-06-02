package com.example.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etun, etpw;
    Button login, signup;

    Context c = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set();
        fnctn();

        Intent in = getIntent();
        String f = in.getStringExtra("fn");
        String l = in.getStringExtra("ln");


    }

    private void set() {
        etun = findViewById(R.id.etun);
        etpw = findViewById(R.id.etpw);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
    }

    private void fnctn() {


        login.setOnClickListener(view -> {

            String un = etun.getText().toString();
            String pw = etpw.getText().toString();

            Intent in = getIntent();
            String u = in.getStringExtra("un");
            String p = in.getStringExtra("pw");
            String f = in.getStringExtra("fn");
            String l = in.getStringExtra("ln");


            if(un.equals("")&&pw.equals("")){
                mt();
            }

            else if (un.equals(u) && pw.equals(p)) {
                Intent it = new Intent(c, loggedin.class);

                Bundle ex = getIntent().getExtras();
                Bitmap b = ex.getParcelable("img");

                it.putExtra("un", u);
                it.putExtra("pw", p);
                it.putExtra("fn", f);
                it.putExtra("ln", l);
                it.putExtra("img", b);
                startActivity(it);
                finish();
            }

            else {
                inco();
            }

        });


        signup.setOnClickListener(view -> {
            Intent it = new Intent(c, reg.class);
            startActivity(it);
        });
    }

    private void mt(){
        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        adb.setTitle("Input Username and Password!")
                .setMessage("Please enter a valid Username and Password.")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        etpw.setText(null);
                        Toast.makeText(c, "Try again!", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog d = adb.create();
        d.show();
    }


    private void inco(){
        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        adb.setTitle("Login failed successfully!")
                .setMessage("Invalid Username or Password.")
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
    }