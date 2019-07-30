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

mySQLHelper dbHelper =new mySQLHelper(this);
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

        }
    });}
    private void addData(String num, String name) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        try {
            db.execSQL("insert into " + mySQLHelper.TABLE + " values(null,'" + nim + "','" + nama + "','" + foto+"','" + jurusan + "','" + jk1);
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