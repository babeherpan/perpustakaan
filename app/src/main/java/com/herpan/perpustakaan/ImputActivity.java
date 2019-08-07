package com.herpan.perpustakaan;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ImputActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1;
    EditText text1, text2, text3, text4, text5, text6, text7, text8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imput);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.no);
        text2 = (EditText) findViewById(R.id.tgl);
        text3 = (EditText) findViewById(R.id.no_pinjam);
        text4 = (EditText) findViewById(R.id.tgl_kembali);
        text5 = (EditText) findViewById(R.id.judul);
        text6 = findViewById(R.id.nama);
        text7=findViewById(R.id.keterangan);
        text8=findViewById(R.id.denda);
        ton1 = (Button) findViewById(R.id.button1);

        ton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into herpan038(noo, tgl, np, tk, jb, nama, ket, denda) values('" +
                        text1.getText().toString() + "','" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "','" +
                        text4.getText().toString() + "','" +
                        text5.getText().toString() + "','" +
                        text6.getText().toString() + "','" +
                        text7.getText().toString() + "','" +
                        text8.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                ListActivity.ma.RefreshList();
                finish();
            }
        });

    }
}
