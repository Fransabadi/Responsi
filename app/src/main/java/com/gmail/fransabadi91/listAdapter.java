package com.gmail.fransabadi91;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import static com.gmail.fransabadi91.mySQLHelper.jk1;

public class listAdapter extends  ArrayAdapter<String>{

    // TODO 1 : Inisialisasi objek yang akan digunakan
    private final Activity context;
    private final String[] nama;
    private final String[] nim;
    private final String[] jurusan;
    private final String[] jk1;
    private final Integer[] foto;

    // TODO 2 : Membuat konstruktor ListAdapter dan memberikan parameter
    public listAdapter(Activity context, String[] nama, String[] nim, Integer[] foto, String[] jurusan, String[] jk1) {
        super(context, R.layout.mylist, nama);

        // TODO 2.1 : Inisialisasi variabel-variabel dengan parameter pada ListAdapter
        this.context = context;
        this.nama = nama;
        this.nim = nim;
        this.foto = foto;
        this.jurusan = jurusan;
        this.jk1= jk1 ;
    }

    // TODO 3 : Membuat View pada layout mylist
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);

        // TODO 3.1 : Mengambil data title, subtitle dan icon dari layout
        TextView namaText = rowView.findViewById(R.id.nama);
        ImageView imageView = rowView.findViewById(R.id.foto);
        TextView nimText = rowView.findViewById(R.id.nim);
        TextView jurusanText = rowView.findViewById(R.id.jurusan);
        TextView jk1Text = rowView.findViewById(R.id.jk1);

        // TODO 3.2 : Menambahkan data pada title, subtitle dan icon berdasarkan posisi dari masing-masing array
        nimText.setText(nim[position]);
        imageView.setImageResource(foto[position]);
        namaText.setText(nama[position]);
        jurusanText.setText(jurusan[position]);
        jk1Text.setText(jk1[position]);
        return rowView;
    }
}