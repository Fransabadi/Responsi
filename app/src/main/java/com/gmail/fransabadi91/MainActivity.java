package com.gmail.fransabadi91;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

mySQLHelper dbHelper;
    ImageButton imageView;
    EditText nama;
    EditText nim;
    EditText jurusan;
    RadioButton jk1;
    ImageButton foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
         dbHelper=new mySQLHelper(this);
        nama = (EditText) this.findViewById(R.id.nama);
        nim = (EditText) this.findViewById(R.id.nim);
        jurusan = (EditText) this.findViewById(R.id.jurusan);
        jk1 = (RadioButton) this.findViewById(R.id.jk1);
        foto = (ImageButton) this.findViewById(R.id.foto);




        ImageButton btnCamera = (ImageButton) findViewById(R.id.foto);
        Button tombol = (Button) findViewById(R.id.button);
        imageView = findViewById(R.id.foto);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, 0);
            }
        });
    tombol.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addData(nim.getText().toString(), nama.getText().toString(), jurusan.getText().toString(), jk1.getText().toString());
            Intent intent = new Intent(getApplicationContext(), Tampillist.class);
            startActivity(intent);
        }
    });}
    private void addData(String nim1, String nama1, String jurusan1, String jk11) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        try {
            db.execSQL("insert into " + mySQLHelper.TABLE + " values(null,'" + nim1 + "','" + nama1 + "','" + jurusan1 + "','" + jk11+ "');");
        } catch (Exception e) {
            nama.setText(e.toString());
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);



        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(imageBitmap);
            }
        }
    }}