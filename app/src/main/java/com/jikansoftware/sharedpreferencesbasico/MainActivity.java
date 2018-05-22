package com.jikansoftware.sharedpreferencesbasico;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText)findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
        editText1.setText(pref.getString("mail", ""));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarAccion();
            }
        });
    }



    public void ejecutarAccion(){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        Editor editor = preferencias.edit();
        editor.putString("mail", editText1.getText().toString());
        editor.commit();
        finish();
    }
}
