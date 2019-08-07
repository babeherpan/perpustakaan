package com.herpan.perpustakaan;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1;
    EditText text1, text2, text3, text4, text5, text6, text7, text8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.no);
        text2 = (EditText) findViewById(R.id.tgl);
        text3 = (EditText) findViewById(R.id.no_pinjam);
        text4 = (EditText) findViewById(R.id.tgl_kembali);
        text5 = (EditText) findViewById(R.id.judul);
        text6 = findViewById(R.id.nama);
        text7=findViewById(R.id.keterangan);
        text8=findViewById(R.id.denda);
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
        ton1 = (Button) findViewById(R.id.button1);
        // daftarkan even onClick pada btnSimpan
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update herpan038 set tgl='"+
                        text2.getText().toString() +"', np='" +
                        text3.getText().toString()+"', tk='"+
                        text4.getText().toString() +"', jb='" +
                        text5.getText().toString() +"', nama='" +
                        text6.getText().toString() +"', ket='" +
                        text7.getText().toString() +"', denda='" +
                        text8.getText().toString() + "' where noo='" +
                        text1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                ListActivity.ma.RefreshList();
                finish();
            }
        });

    }

}

