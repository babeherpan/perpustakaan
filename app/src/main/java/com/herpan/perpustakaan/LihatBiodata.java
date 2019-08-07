package com.herpan.perpustakaan;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LihatBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;

    TextView text1, text2, text3, text4, text5, text6, text7, text8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata);

        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.no1);
        text2 = (TextView) findViewById(R.id.tgl1);
        text3 = (TextView) findViewById(R.id.np1);
        text4 = (TextView) findViewById(R.id.tk1);
        text5 = (TextView) findViewById(R.id.jb1);
        text6 = (TextView) findViewById(R.id.nama1);
        text7 = (TextView) findViewById(R.id.ket1);
        text8 = (TextView) findViewById(R.id.denda1);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM herpan038 WHERE tgl = '" +
                getIntent().getStringExtra("tgl") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
            text6.setText(cursor.getString(5).toString());
            text7.setText(cursor.getString(6).toString());
            text8.setText(cursor.getString(7).toString());


        }

    }
}
