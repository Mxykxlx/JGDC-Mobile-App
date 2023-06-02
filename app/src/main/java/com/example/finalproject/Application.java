package com.example.finalproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class Application extends android.app.Application {

    static ArrayList<Accounts>acc;
    Bitmap b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    @Override
    public void onCreate() {
        super.onCreate();


        acc = new ArrayList<>();

        b1 = BitmapFactory.decodeResource(getResources(),R.drawable.a);
        b2 = BitmapFactory.decodeResource(getResources(),R.drawable.b);
        b3 = BitmapFactory.decodeResource(getResources(),R.drawable.c);
        b4 = BitmapFactory.decodeResource(getResources(),R.drawable.d);
        b5 = BitmapFactory.decodeResource(getResources(),R.drawable.e);
        b6 = BitmapFactory.decodeResource(getResources(),R.drawable.f);
        b7 = BitmapFactory.decodeResource(getResources(),R.drawable.g);
        b8 = BitmapFactory.decodeResource(getResources(),R.drawable.h);
        b9 = BitmapFactory.decodeResource(getResources(),R.drawable.i);
        b10 = BitmapFactory.decodeResource(getResources(),R.drawable.j);

        acc.add(new Accounts(b1, "One", "First", "January 1, 2001", "Female", "Sleeping"));
        acc.add(new Accounts(b2, "Two", "Second", "February 2, 2002","Female", "Dancing"));
        acc.add(new Accounts(b3, "Three", "Third", "March 3, 2003", "Female", "Playing"));
        acc.add(new Accounts(b4, "Four", "Fourth", "April 4, 2004", "Male", "Gaming"));
        acc.add(new Accounts(b5, "Five", "Fifth", "May 5, 2005", "Male", "Shopping"));
        acc.add(new Accounts(b6, "Six", "Sixth", "June 6, 2006", "Male", "Travelling"));
        acc.add(new Accounts(b7, "Seven", "Seventh", "July 7, 2007", "Female", "Singing"));
        acc.add(new Accounts(b8, "Eight", "Eighth", "August 8, 2008", "Female", "Watching"));
        acc.add(new Accounts(b9, "Nine", "Nineth", "September 9, 2009", "Male", "Joking"));
        acc.add(new Accounts(b10, "Ten", "Tenth", "October 10, 2010", "Male", "Eating"));
    }
}
