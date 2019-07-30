package com.gmail.fransabadi91;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import static com.gmail.fransabadi91.mySQLHelper.jk1;
import static com.gmail.fransabadi91.mySQLHelper.jurusan;
import static com.gmail.fransabadi91.mySQLHelper.nama;
import static com.gmail.fransabadi91.mySQLHelper.nim;
import static com.gmail.fransabadi91.mySQLHelper.foto;

public class Tampillist extends AppCompatActivity{

    // TODO 1 : Inisialisasi list, maintitle, subtitle, dan imgid
    ListView list;
    Activity context;
    String[] nama;
    String[] nim;
    String[] jurusan;
    String[] jk1;
    Integer[] foto;

    // TODO 2 : Inisialisasi kelas TampilList dengan tampilan layout tampil_list
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        // TODO 2.1 : Memanggil kelas ListAdapter pada variabel adapter dengan parameter maintitle, subtitle, dan imgid
        listAdapter adapter = new listAdapter(this, nama, nim, foto, jurusan, jk1);

        // TODO 2.2 : Mengambil layout ListView dan disimpan pada variabel, kemudian memberikan adapter
        list = findViewById(R.id.list);
        list.setAdapter(adapter);

        // TODO 2.3 : Membuat adapter pada saat item list diklik
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
