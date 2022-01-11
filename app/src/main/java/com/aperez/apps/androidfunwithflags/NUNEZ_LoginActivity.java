package com.aperez.apps.androidfunwithflags;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NUNEZ_LoginActivity extends AppCompatActivity {

    private EditText editTextUsuario;
    private EditText editTextContrasena;
    private Button buttonIngresar;
    private Button buttonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nunez_login);

        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextContrasena = findViewById(R.id.editTextContrasena);
        buttonIngresar = findViewById(R.id.buttonIngresarr);
        buttonRegistrar = findViewById(R.id.buttonRegistrar);

        buttonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = editTextUsuario.getText().toString();
                String contrasena = editTextContrasena.getText().toString();

                if(usuario.equals(""))
            }
        });
    }


}