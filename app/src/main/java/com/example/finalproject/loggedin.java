package com.example.finalproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class loggedin extends AppCompatActivity {


    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    li li;
    Button add, logout;
    TextView nmlgt;
    ImageView imgVxml;
    Bitmap bmp;


    Context c = this;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    static final int REQ_CODE = 2;

    static final int REQ_EDIT = 3;

    static final int REQ_DISPLAY = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);

        set();
        fnctn();

//        KapeList = acc
//        Kape = Accounts
//        myrecyclerview adapter = li
//        rvact = loggedin

        Intent in = getIntent();
        String f = in.getStringExtra("fn");
        String l = in.getStringExtra("ln");
        String n = in.getStringExtra("name");
        String r = in.getStringExtra("remarks");
        String b = in.getStringExtra("dob");
        String g = in.getStringExtra("gndr");

        Bundle bun = getIntent().getExtras();
        Bitmap i = bun.getParcelable("img");


        nmlgt.setText(f + " " + l);
        imgVxml.setImageBitmap(i);

    }

    private void set() {

        nmlgt = findViewById(R.id.nmlgt);
        rv = findViewById(R.id.rv);
        rv.hasFixedSize();
        lm = new LinearLayoutManager(c);
        rv.setLayoutManager(lm);
        li = new li(c, R.layout.listinli, Application.acc);
        add = findViewById(R.id.add);
        logout = findViewById(R.id.logout);
        rv.setAdapter(li);

        imgVxml = findViewById(R.id.imgVxml);
    }

    private void fnctn() {

        add.setOnClickListener(view -> {

            Intent it = new Intent(c, addEntry.class);
            startActivityForResult(it, REQ_CODE);

        });


        logout.setOnClickListener(view -> {
            lo();
        });

        li.setOnItemClickListener(new li.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Bitmap img = Application.acc.get(position).getImg();
                String n = Application.acc.get(position).getTtl();
                String r = Application.acc.get(position).getRmrks();
                String b = Application.acc.get(position).getBday();
                String g = Application.acc.get(position).getGndr();
                String h = Application.acc.get(position).getHbbs();



//                Toast.makeText(c, Application.acc.get(position).getTtl() , Toast.LENGTH_SHORT).show();

                Intent dsply = new Intent(c, dsply.class);

                dsply.putExtra("name",n);
                dsply.putExtra("remarks",r);
                dsply.putExtra("dob",b);
                dsply.putExtra("gndr",g);
                dsply.putExtra("hbbs",h);
                dsply.putExtra("img", img);

                startActivityForResult(dsply, REQ_DISPLAY);

            }

            @Override
            public void OnItemEdit(int position) {

                Intent in = getIntent();

                String n = in.getStringExtra("name");
                String b = in.getStringExtra("dob");
                String g = in.getStringExtra("gndr");
                Intent edit = new Intent(c, EditEntry.class);


                edit.putExtra("name",n);
                edit.putExtra("dob", b);
                edit.putExtra("gndr", g);
                edit.putExtra("img", bmp);
                edit.putExtra("pstn", position);
                li.notifyItemChanged(position);
                startActivityForResult(edit, REQ_EDIT);
            }



            @Override
            public void OnItemDelete(int position) {
                AlertDialog.Builder adb = new AlertDialog.Builder(c);
                adb.setTitle("Item will be deleted!")
                        .setMessage("Are you sure you want to delete?")
                        .setCancelable(false)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Application.acc.get(position);
                                        Application.acc.remove(position);
                                        li.notifyItemRemoved(position);
                                        lm.scrollToPosition(position);
                                        Toast.makeText(c, "Item deleted successfully!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        ).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                AlertDialog ad = adb.create();
                ad.show();

            }
        });


    }

    private void lo() {
        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        adb.setTitle("Don't leave me!")
                .setMessage("Are you sure you want to logout?")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent in = getIntent();
                                String f = in.getStringExtra("fn");
                                String l = in.getStringExtra("ln");
                                String u = in.getStringExtra("un");
                                String p = in.getStringExtra("pw");

                                Bundle ex = getIntent().getExtras();
                                Bitmap b = ex.getParcelable("img");

                                Intent it = new Intent(c, MainActivity.class);
                                it.putExtra("un", u);
                                it.putExtra("pw", p);
                                it.putExtra("fn", f);
                                it.putExtra("ln", l);
                                it.putExtra("img", b);
                                startActivity(it);
                                finish();

                            }
                        }
                ).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        AlertDialog ad = adb.create();
        ad.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (REQ_CODE == requestCode && resultCode == RESULT_OK) {
            String n = data.getStringExtra("name");
            String r = data.getStringExtra("remarks");
            String b = data.getStringExtra("dob");
            String g = data.getStringExtra("gndr");
            String h = data.getStringExtra("hbbs");

            Bundle bun = data.getExtras();
            Bitmap i = bun.getParcelable("imgA");

//            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),b);
            Application.acc.add(new Accounts(i, n, r, b, g, h));
            li.notifyDataSetChanged();
            lm.scrollToPosition(rv.getAdapter().getItemCount() - 1);
        }


        if (REQ_DISPLAY == requestCode && resultCode == RESULT_OK) {
            Intent gi = getIntent();
            int position = gi.getIntExtra("pstn",0);

            li.notifyDataSetChanged();
            lm.scrollToPosition(position);

        }

        if (REQ_EDIT == requestCode && resultCode == RESULT_OK) {
            Intent gi = getIntent();
            int position = gi.getIntExtra("pstn",0);

            li.notifyDataSetChanged();
            lm.scrollToPosition(position);

        }


    }



}