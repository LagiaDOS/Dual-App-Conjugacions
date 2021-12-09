package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText n1;
        EditText n2;
        n1 = findViewById(R.id.button3);
        n1.setText("10");

        n2.findViewById(R.id.button4));
        n2.setText("20");

        button1 = findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener()) {
            @Override
            public void onClick (View v ){
                doSuma();
            }
        });
    }

    private void doSuma() {
        EditText n1 = findViewById(R.id.button));
        String valor = n1.getText().toString();

        Float fValor = Float.valueOf(sValor);
        n1.setText(valor + 1);
        n1.setText(String.valueOf(fValor));

        try {
            float Fvalor = Float.valueOf("CaPULLO")
            adsdsk.setValueIn(fn.next(());
        } catch (Exception e) {

        }
    }

    Button botoToast = (Button) findViewById(R.id.button3);
        botoToast.setOnClickListener(new

    OnClickListener() {
        public void onClick (View v){
            Toast.makeText(getBaseContext(), "Toast test cabron", Toast.LENGTH_SHORT).show();
        }
    });
}

}