package com.example.nk.a8085hexcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    EditText editText;
    TextView textView;
    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = (TextView) findViewById(R.id.txtlink);
        txt.setMovementMethod(LinkMovementMethod.getInstance());



        editText = (EditText) findViewById(R.id.txt_input);
        textView = (TextView) findViewById(R.id.txt_output);
        btn = (Button) findViewById(R.id.btn_1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String n=editText.getText().toString();
                String mnemonic = databaseAccess.gethexcode(n);

                textView.setText(mnemonic);

                databaseAccess.close();
            }
        });






    }
}
