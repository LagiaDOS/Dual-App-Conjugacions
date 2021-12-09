package com.epiaedu.testintentsimplicits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button botoWeb = (Button) findViewById(R.id.botoWeb);
        botoWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.es"));
                startActivity(intent);
            }
        });


        Button btnTrucada = findViewById(R.id.btnTelf);
        btnTrucada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "337238275857853"));
                startActivity(intent);
            }
        });

        Button btnMaps = findViewById(R.id.btnMaps);
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + "32 08’59.96″ N, 110 50’09.03″W"));
                startActivity(intent);
            }
        });

        Button btnFoto = findViewById(R.id.btnFoto);
        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        Button btnCorreu = findViewById(R.id.btnCorreu);
        btnCorreu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "438434uufewn**6654ufew@fdsfjdsiofdsapss.aaakdsdj"));
                startActivity(intent);
            }
        });


    }
}